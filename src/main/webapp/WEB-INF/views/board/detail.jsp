<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<a class="btn btn-secondary" href="/">목록</a>
	<c:if test="${board.user.id == principal.user.id}">
		<a class="btn btn-warning" href="/board/${board.id}/updateForm">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>
	<br /> <br />
	<div>
		글 번호 : <span id="id"><i>${board.id} </i></span>
	</div>
	<div>
		작성자 : <span><i>${board.user.username} </i></span>
	</div>

	<br />

	<div>
		<h3>${board.title}</h3>
	</div>
	<hr />
	<div>
		<div>${board.content}</div>
	</div>


	<div class="card">

		 <input type="hidden" id="boardId" value="${board.id}" />
		<div class="card-body"> 
			<textarea id="reply-content" class="form-control" rows="1"></textarea>
		</div>
			<div class="card-footer">
			<button id="btn-reply-save" class="btn btn-primary">등록</button>
			</div>
		</div>

	<br />

	<div class="card">
		<div class="card-header">댓글 리스트</div>
		<ul id="reply-box" class="list-group">
			<c:forEach var="reply" items="${board.replys}">
	
				<li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between" >
					<div>${reply.content}</div>
						<div class="d-flex">
						<div class="font-italic">작성자 : ${reply.user.username}&nbsp;</div>
						<c:if test="${reply.user.id == principal.user.id}">
						<button onClick="index.replyDelete(${board.id}, ${reply.id})" class="badge">삭제</button>
						</c:if>
					</div>
				</li>
			</c:forEach>

		</ul>
	</div>

</div>
<hr />
<br />

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
