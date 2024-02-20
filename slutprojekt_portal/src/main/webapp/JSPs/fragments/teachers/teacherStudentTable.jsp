<div class="center">
    <form action="/userpage" method="post">
        <select id="user_type" name="studentId">
            <c:forEach items="${students}" var="dataC">
                <option value="${dataC[0]}">${dataC[0]}</option>
            </c:forEach>
        </select>
        <input type="submit" id="studentSubmit" name="showStudentsButton" value="Show Students courses">
        <button onclick=location.href='/userpage'>Go Back</button>
    </form>
</div>