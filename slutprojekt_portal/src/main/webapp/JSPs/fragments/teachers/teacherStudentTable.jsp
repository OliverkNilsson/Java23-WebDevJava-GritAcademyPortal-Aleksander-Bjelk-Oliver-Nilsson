<div class="center">
    <form action="/userpage" method="post">
        <select id="user_type" name="studentName">
            <c:forEach items="${students}" var="dataC">
                <option value="${dataC[0]}">${dataC[0]}</option>
            </c:forEach>
        </select>
        <input type="submit" id="studentSubmit" name="showCoursesForStudent" value="Show Students courses">
        <button onclick=location.href='/userpage'>Go Back</button>
    </form>
</div>