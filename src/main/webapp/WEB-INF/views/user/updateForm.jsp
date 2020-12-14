<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<%-- 업데이트할 때 필요한 id 값 hidden 값으로 javascript 파일에 전달 --%>
		<input type="hidden" id="id" value="${principal.user.id}"/>
		<div class="form-group">
			<label for="username">Username</label>
			<input type="text" class="form-control" value="${principal.user.username}" id="username" readonly>
		</div>
		
				<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control"  id="password" placeholder="Enter password">
		</div> 
		
		<div class="form-group">
			<label for="email">Email</label> <input type="email"
				class="form-control" id="email" value="${principal.user.email}">
		</div>
	</form>
	
		<button id="btn-update" class="btn btn-primary" >회원정보 수정</button>

</div>
<br/>
<script src="/js/users.js"></script>
<%@ include file="../layout/footer.jsp"%>
