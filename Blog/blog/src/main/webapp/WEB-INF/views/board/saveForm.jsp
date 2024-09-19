<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form action="/auth/loginProc"  method="post">
		<div class="form-group">
			<label for="title">Title</label> 
			<input type="text"  class="form-control" placeholder="Enter Title" id="title">
		</div>
		<!-- 09:05  -->
		<div class="form-group">
 			 <label for="content">Content</label>
 			 <textarea class="form-control" rows="5" id="comment"></textarea>
		</div>
		<button id="btn-save"  type="submit" class="btn btn-primary">저장</button>
	</form>
</div>
	
	<%@ include file="../layout/footer.jsp" %>

