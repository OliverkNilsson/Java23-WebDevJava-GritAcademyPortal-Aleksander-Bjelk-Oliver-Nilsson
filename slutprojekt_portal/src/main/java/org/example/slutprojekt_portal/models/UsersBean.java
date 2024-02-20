package org.example.slutprojekt_portal.models;

import java.io.Serializable;

public class UsersBean implements Serializable {
    String id;
    private USER_TYPE userType;
    private PRIVILAGE_TYPE privilageType = PRIVILAGE_TYPE.user;
    private STATE_TYPE stateType = STATE_TYPE.anonymous;


    public UsersBean() {}
    public UsersBean(String id, USER_TYPE userType, PRIVILAGE_TYPE privilageType, STATE_TYPE stateType) {
        this.id = id;
        this.userType = userType;
        this.privilageType = privilageType;
        this.stateType = stateType;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public USER_TYPE getUserType() {
        return userType;
    }

    public void setUserType(USER_TYPE userType) {
        this.userType = userType;
    }

    public STATE_TYPE getStateType() {
        return stateType;
    }

    public void setStateType(STATE_TYPE stateType) {
        this.stateType = stateType;
    }

    public PRIVILAGE_TYPE getPrivilageType() {
        return privilageType;
    }

    public void setUserPrivilage(PRIVILAGE_TYPE userPrivilage) {
        this.privilageType = userPrivilage;
    }

    @Override
    public String toString() {
        return userType + " " + privilageType + " " + stateType;
    }
}



