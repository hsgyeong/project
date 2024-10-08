<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<div style=" display: flex; justify-content: right;">
	<button style="margin-left: 5px;" class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<c:if test="${board.user.id == principal.user.id }">
		<a href="/board/${board.id }/updateForm" class="btn btn-warning" style="margin-left: 5px;">수정</a>
		<button id="btn-delete" class="btn btn-danger" style="margin-left: 5px;">삭제</button>
	</c:if>
	</div>
	<br /> <br />
	<div>
		글 번호 : <span id="id"><i>${board.id } </i></span> 작성자 : <span><i>${board.user.username } </i></span>
	</div>
	<br />
	<div class="form-group">
		<h4>${board.title }</h4>
	</div>
	<hr />
	<div class="form-group">
		<div>${board.content }</div>
		<hr />
	</div>
	<div class="card">
		<form>
			<input type="hidden" id="boardId" value="${board.id }" />
			<input type="hidden" id="userId" value="${principal.user.id }" />
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer" style=" display: flex; justify-content: right;">
				<button id="btn-reply-save" class="btn btn-primary" >등록</button>
			</div>
		</form>
	</div>
	<br />
	<div class="card">
		<div class="card-header">댓글 리스트</div>
		<ul id="reply-box" class="list-group">
			<c:forEach var="reply" items="${board.replys }">
				<li id="reply-${reply.id }" class="list-group-item d-flex justify-content-between">
					<div>${reply.content }</div>
					<div class="d-flex">
						<div class="font-italic">작성자 : ${reply.user.username } &nbsp;</div>
						<c:if test="${reply.user.id == principal.user.id }">
						<button onClick="index.replyDelete(${board.id}, ${reply.id} )" class='badge'>삭제</button>
						</c:if>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
