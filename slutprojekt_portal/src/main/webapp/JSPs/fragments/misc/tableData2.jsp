<%--
  Created by IntelliJ IDEA.
  User: aleksanderbjelk
  Date: 2024-02-20
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<div class="generalpicture">
<table id="table data">
    <c:forEach items="${data2}" var="dataC">
        <tr>
            <c:forEach items="${dataC}" var="dataColumn">
                <td>${dataColumn}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</div>