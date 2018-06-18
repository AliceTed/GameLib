<%@page contentType="text/html; charset=UTF-8"%>

<%@include file="../layouts/header.jsp"%>

<form class="form-signin" action="SignIn.action" method="post">

	<div class="panel panel-default">
		<div class="panel-heading">
			<h2 class="form-signin-heading">Please Sign in</h2>
		</div>
		<div class="panel-body">
			<label for="inputEmail" class="sr-only">Email address</label>
		    <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address..." required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="passward" class="form-control" placeholder="Password..." required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			<a href="signup.jsp" class="btn btn-lg btn-default btn-block" role="button">Sign up</a>
		</div>
	</div>

</form>
<%@include file="../layouts/footer.jsp"%>