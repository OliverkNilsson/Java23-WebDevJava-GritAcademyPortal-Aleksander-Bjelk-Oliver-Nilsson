package org.example.slutprojekt_portal.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;

/**
 * Db Connector Singleton. Uses queries defined in queries.csv
 * Access object with MySQLConnector.getConnector();
 * Use one of <operation>Query methods.
 */
public class MySQLConnector {

    final private String queriesPath = "src/main/java/org/example/slutprojekt_portal/models/queries.csv";
    private static MySQLConnector connector = null;

    private MySQLConnector(){};

    public static MySQLConnector getConnector() {
        if (connector == null) {
            connector = new MySQLConnector();
        }
        return connector;
    }

    /**
     * Gets data from the Db, based on the SELECT query
     * Additional conditional variable arguments can be added to the query with {0}, {1} ...
     * @param queryName String
     * @return LinkedList with data String Arrays
     */
    public LinkedList<String[]> selectQuery(String queryName, String... args) throws NullPointerException{
        try(BufferedReader br = new BufferedReader(new FileReader(queriesPath))) {
            String query = br.readLine();
            String[] line = null;
            while (query != null){
                line = query.trim().split(";");
                if(line[0].equals(queryName)){
                    for (int i = 0; i < args.length; i++) {
                        line[1] = line[1].replace("{"+i+"}",args[i]) ;
                    }
                    System.out.println("Executing query: "+queryName +" - "+ line[1]);
                    return select(line[1], line[2], line[3], line[4], line[5], line[6]);
                }
                query = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



    /**
     * Returns a list of String Arrays with data rows recieved from Db.
     * Each datapoint has type of String or null if missing.
     * @param query String
     */
    private LinkedList<String[]> select(String query, String db, String ip, String port, String user, String password){
        LinkedList<String[]> queryReturn = new LinkedList<String[]>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            //add header row to queryReturn
            String[] headerRow = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                headerRow[i-1] = md.getColumnName(i);
            }
            queryReturn.add(headerRow);

            //add data row to queryReturn
            while (rs.next()){
                String[] dataRow = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    dataRow[i-1] = rs.getString(i);
                }
                queryReturn.add(dataRow);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return queryReturn;
    }

    /**
     * Insert query needs to set a type for each input datapoint
     * In the lookup table (CSV - file) variable inputs should be defined as:
     * ?,?,?,? for 4 input parameters. Args should be defined as:
     * argument0, argument1, argument2, argument4, S, S, S, S for 4 arguments of Type S
     * "I" should be used for type if its an integer
     * @param queryName
     * @param args
     * @return
     * @throws NullPointerException
     */
    public boolean insertQuery(String queryName, String... args) throws NullPointerException{
        try(BufferedReader br = new BufferedReader(new FileReader(queriesPath))) {
            String query = br.readLine();
            String[] line = null;
            while (query != null){
                line = query.trim().split(";");
                if(line[0].equals(queryName)){
                    return insert(line[1], line[2], line[3], line[4], line[5], line[6], args);
                }
                query = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    private boolean insert(String query, String db, String ip, String port, String user, String password, String... args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db, user, password);

            PreparedStatement ps = con.prepareStatement(query);

            for (int i = 0; i < args.length/2; i++) {
                System.out.println(i);
                //if(args[i].equals("")) continue;
                if(args[i+(args.length/2)].equals("S")){
                    ps.setString(i+1,args[i]);
                }else if(args[i].equals("I")){
                    ps.setInt(i+1,Integer.parseInt(args[i]));
                }
            }

            int i = ps.executeUpdate();
            if (i > 0)
                return true;
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

}
