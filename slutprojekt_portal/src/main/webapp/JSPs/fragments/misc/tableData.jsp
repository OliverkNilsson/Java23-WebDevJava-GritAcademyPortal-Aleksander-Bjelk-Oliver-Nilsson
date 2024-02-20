<%--
  Created by IntelliJ IDEA.
  User: aleksanderbjelk
  Date: 2024-02-20
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<table id="table data">
    <c:forEach items="${data}" var="dataC">
        <tr>
            <c:forEach items="${dataC}" var="dataColumn">
                <td>${dataColumn}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
