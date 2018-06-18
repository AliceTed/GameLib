<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../layouts/header.jsp" %>

<form class="form-signin" action="SignUp.action" method="post" name="signup">

<div class="panel panel-default">
  <div class="panel-heading">
   <h2 class="form-signin-heading">Create Account</h2>
  </div>
  <div class="panel-body">
   <label for="inputName" class="sr-only">Name</label>
    <input id="inputName" name="name" class="form-control" placeholder="name" required autofocus>

    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>

    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="passward" class="form-control" placeholder="Password" required>

    <label for="inputRePassword" class="sr-only">RePassword</label>
    <input type="password" id="inputRePassword" name="repassward" class="form-control" placeholder="Password" required>

    <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return CheckPassward()">Create</button>
  </div>
</div>

</form>

<%@include file="../layouts/footer.jsp" %>