<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>강의평가</title>
	<!-- 부트스트랩 CSS -->
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<!-- 커스텀 CSS -->
	<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="index.jsp">강의평가</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a class="nav-link" href="index.jsp">메인</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="dropdown" data-bs-toggle="dropdown">
						회원 관리
					</a>
					<div class="dropdown-menu" aria-labelledby="dropdown">
						<a class="dropdown-item" href="#">로그인</a>
						<a class="dropdown-item" href="#">회원가입</a>
						<a class="dropdown-item" href="#">로그아웃</a>
					</div>
				</li>
			</ul>
			<form class="d-inline-flex ms-auto">
				<input class="form-control search me-2" type="search" placeholder="내용을 입력하세요." aria-label="Search">
				<button class="btn btn-outline-success" style="white-space: nowrap;" type="submit">검색</button>
			</form>
		</div>
	</nav>
	<section class="container">
		<form method="get" action="./index.jsp" class="d-flex mt-3">
			<select name="lectureDivide" class="form-control mx-1 mt-2" style="width: 150px;">
				<option value="전체">전체</option>
				<option value="전공">전공</option>
				<option value="교양">교양</option>
				<option value="기타">기타</option>
			</select>
			<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요." style="width: 300px;">
			<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
			<a class="btn btn-primary mx-1 mt-2" data-bs-toggle="modal" href="#registerModal">등록하기</a>
			<a class="btn btn-danger mx-1 mt-2" data-bs-toggle="modal" href="#reportModal">신고</a>
		</form>
		<div class="card bg-light mt-3"  style="margin-bottom: 15px;">
			<div class="card-header bg-light">
				<div class="row">
					<div class="col-8 text-left">컴퓨터개론&nbsp;&nbsp;<small>홍도리</small></div>
					<div class="col-4 text-right">
						종합&nbsp;<span style="color: red;">B</span>
					</div>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title"  style="margin-bottom: 10px;">
				그럭저럭 들었습니다. &nbsp;&nbsp; <small>(2018년 1학기)</small>
			</h5>
			<p5 class="card-text">수업 내용이 어려워요.</p5>
			<div class="row">
				<div class="col-9 text-left">
					성적 <span style="color: red; margin-right: 10px;">C</span>
					널널 <span style="color: red; margin-right: 10px;">A</span>
					강의 <span style="color: red; margin-right: 10px;">C</span>
					<span style="color: green;">(추천: 21)</span>
				</div>
				<div class="col-3 text-right">
					<a onclick="return confirm('추천하시겠습니까?')" href="./likeAction.jsp?evaluationID=" style="text-decoration: none">추천</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a onclick="return confirm('삭제하시겠습니까?')" href="./deleteAction.jsp?evaluationID=" style="text-decoration: none">삭제</a>
				</div>
			</div>
		</div>
		<div class="card bg-light mt-3"  style="margin-bottom: 15px;">
			<div class="card-header bg-light">
				<div class="row">
					<div class="col-8 text-left">컴퓨터개론&nbsp;&nbsp;<small>김도리</small></div>
					<div class="col-4 text-right">
						종합&nbsp;<span style="color: red;">A</span>
					</div>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title"  style="margin-bottom: 10px;">
				정말 좋은 강의에요. &nbsp;&nbsp; <small>(2016년 겨울학기)</small>
			</h5>
			<p5 class="card-text">강의 구성이 알차고, 학점도 잘 나오는 좋은 강의 같습니다.</p5>
			<div class="row">
				<div class="col-9 text-left">
					성적 <span style="color: red; margin-right: 10px;">A</span>
					널널 <span style="color: red; margin-right: 10px;">A</span>
					강의 <span style="color: red; margin-right: 10px;">B</span>
					<span style="color: green;">(추천: 21)</span>
				</div>
				<div class="col-3 text-right">
					<a onclick="return confirm('추천하시겠습니까?')" href="./likeAction.jsp?evaluationID=" style="text-decoration: none">추천</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a onclick="return confirm('삭제하시겠습니까?')" href="./deleteAction.jsp?evaluationID=" style="text-decoration: none">삭제</a>
				</div>
			</div>
		</div>
		<div class="card bg-light mt-3"  style="margin-bottom: 15px;">
			<div class="card-header bg-light">
				<div class="row">
					<div class="col-8 text-left">컴퓨터개론&nbsp;&nbsp;<small>맛도리</small></div>
					<div class="col-4 text-right">
						종합&nbsp;<span style="color: red;">A</span>
					</div>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title"  style="margin-bottom: 10px;">
				강의 추천합니다. &nbsp;&nbsp; <small>(2016년 1학기)</small>
			</h5>
			<p5 class="card-text">수업 너무 재밌어요!</p5>
			<div class="row">
				<div class="col-9 text-left">
					성적 <span style="color: red; margin-right: 10px;">A</span>
					널널 <span style="color: red; margin-right: 10px;">A</span>
					강의 <span style="color: red; margin-right: 10px;">A</span>
					<span style="color: green;">(추천: 21)</span>
				</div>
				<div class="col-3 text-right">
					<a onclick="return confirm('추천하시겠습니까?')" href="./likeAction.jsp?evaluationID=" style="text-decoration: none">추천</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a onclick="return confirm('삭제하시겠습니까?')" href="./deleteAction.jsp?evaluationID=" style="text-decoration: none">삭제</a>
				</div>
			</div>
		</div>
	</section>
	
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">평가 등록</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" >
					</button>
				</div>
				<div class="modal-body">
					<form action="./evaluationRegisterAction.jsp" method="post">
						<div class="form-row d-flex">
							<div class="form-group col-sm-6">
								<label>강의명</label>
								<input type="text" name="lectureName" class="form-control" maxlength="20" style="width: 220px;">
							</div>
							<div class="form-group col-sm-6">
								<label>교수명</label>
								<input type="text" name="professorName" class="form-control" maxlength="20" style="width: 220px;">
							</div>
						</div>
						<div class="form-row">
							<div class="d-flex">
								<div class="form-group col-sm-4">
									<label>수강 연도</label>
									<select name="lectureYear" class="form-control" style="width: 140px;">
										<option value="2013">2013</option>
										<option value="2014">2014</option>
										<option value="2015">2015</option>
										<option value="2016" selected>2016</option>
										<option value="2017">2017</option>
										<option value="2018">2018</option>
										<option value="2019">2019</option>
										<option value="2020">2020</option>
										<option value="2021">2021</option>
										<option value="2022">2022</option>
										<option value="2023">2023</option>
										<option value="2024">2024</option>
									</select>
								</div>
								<div class="form-group col-sm-4">
									<label>수강 학기</label>
									<select name="semesterDivide" class="form-control" style="width: 140px;">
										<option value="1학기" selected>1학기</option>
										<option value="여름학기">여름학기</option>
										<option value="2학기">2학기</option>
										<option value="겨울학기">겨울학기</option>
									</select>
								</div>
								<div class="form-group col-sm-4">
									<label>강의 구분</label>
									<select name="lectureDivide" class="form-control" style="width: 140px;">
										<option value="전공" selected>전공</option>
										<option value="교양">교양</option>
										<option value="기타">기타</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label>제목</label>
								<input type="text" name="evaluationTime" class="form-control" maxlength="30" style="width: 100%;">
							</div>
							<div class="form-group">
								<label>내용</label>
								<textarea name="evaluationContent" class="form-control" maxlength="2048" style="width: 100%; height: 180px;"></textarea>
							</div>
						</div>
						<div class="form-row d-flex">
							<div class="form-group col-sm-3">
								<label>종합</label>
								<select name="totalScore" class="form-control" style="width: 80px;">
									<option value="A" selected>A</option>
									<option value="B" >B</option>
									<option value="C" >C</option>
									<option value="D" >D</option>
									<option value="F" >F</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>성적</label>
								<select name="creditScore" class="form-control" style="width: 80px;">
									<option value="A" selected>A</option>
									<option value="B" >B</option>
									<option value="C" >C</option>
									<option value="D" >D</option>
									<option value="F" >F</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>널널</label>
								<select name="comfortableScore" class="form-control" style="width: 80px;">
									<option value="A" selected>A</option>
									<option value="B" >B</option>
									<option value="C" >C</option>
									<option value="D" >D</option>
									<option value="F" >F</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>강의</label>
								<select name="lectureScore" class="form-control" style="width: 80px;">
									<option value="A" selected>A</option>
									<option value="B" >B</option>
									<option value="C" >C</option>
									<option value="D" >D</option>
									<option value="F" >F</option>
								</select>
							</div>
						</div>
						<br>
						<div class="modal-footer">
							<button type="button" class="btn btn-warning" data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-primary">등록하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
		<div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">신고하기</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" >
					</button>
				</div>
				<div class="modal-body">
					<form action="./reportAction.jsp" method="post">
							<div class="form-group">
								<label>신고 제목</label>
								<input type="text" name="reportTitle" class="form-control" maxlength="30" style="width: 100%;">
							</div>
							<br>
							<div class="form-group">
								<label>신고 내용</label>
								<textarea name="reportContent" class="form-control" maxlength="2048" style="width: 100%; height: 180px;"></textarea>
							</div>
						<br>
						<div class="modal-footer">
							<button type="button" class="btn btn-warning" data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-danger">신고하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		Copyright &copy; 2024 홍성경 All Rights Reserved.
	</footer>
	<!-- 부트스트랩 자바스크립트 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>