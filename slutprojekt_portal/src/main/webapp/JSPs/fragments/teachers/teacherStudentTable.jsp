<div class="center">
    <form action="/userpage" method="post">
        <select id="user_type" name="courseId">
            <c:forEach items="${courses}" var="dataC">
                <option value="${dataC[0]}">${dataC[1]}</option>
            </c:forEach>
        </select>
        <input type="submit" id="studentSubmit" name="showStudentsButton" value="Show Students courses">
        <button onclick=location.href='/userpage'>Go Back</button>
    </form>
</div>