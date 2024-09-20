let index = {
	init: function() {
		$("#btn-save").on("click", ()=>{ // function(){} 대신 () => {}  사용 -> this를 바인딩하기 위함. 
			this.save();
		});  
	},
	
	save: function(){
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};
		
		$.ajax({
			type : "POST",
			url : "/api/board",
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8", 
			dataType: "json" 
		}).done(function(res){
			alert("저장이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	},

/*	
	login: function(){
		// alert('user의 save함수 호출');
		let data = {
			username: $("#username").val(),
			password: $("#password").val()
		};
		
		$.ajax({
			type : "POST",
			url : "/api/user/login",
			data : JSON.stringify(data), // http body 데이터
			contentType : "application/json; charset=utf-8", // body 데이터가 어떤 타입인지(MIME)
			dataType: "json" // 요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (json 형태라면 javascript object로 변경)
		}).done(function(res){
			alert("로그인이 완료되었습니다.");
			// console.log(res);
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	}
*/
}

index.init();