<%@include file="head.jsp"%>
<html>
<body>
<h2>User Display Exercise - Week 1</h2>
<a href = "searchUser">Go to the User Search</a>
<form  action="searchUser" method="get">
<div>
    <label for="ln">Search By LastName:</label>
    <input type="text"
           name="searchType"
           id="lN" />
</div>
<input type="submit"
       value="Submit"
       name="" />

</form>

</body>
</html>
