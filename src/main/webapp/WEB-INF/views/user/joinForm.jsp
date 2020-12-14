<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="username">Username</label> <input type="text"
				class="form-control" id="username" placeholder="Enter Username">
		</div>
		
				<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" id="password" placeholder="Enter password">
		</div> 
		
		<div class="form-group">
			<label for="email">Email</label> <input type="email"
				class="form-control" id="email" placeholder="Enter email">
		</div>
	</form>
	
		<button id="btn-save" class="btn btn-primary" >회원가입</button>

</div>
<br/>
<script src="/js/users.js"></script>
<%@ include file="../layout/footer.jsp"%>
