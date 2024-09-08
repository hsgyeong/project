let index = {
	init: function() {
		$("#btn-save").on("click", ()=>{ // function(){} 대신 () => {}  사용 -> this를 바인딩하기 위함. 
			this.save();
		}); // bind(this)를 사용하여 this가 index 객체를 가리키게 함
	},
	
	save: function(){
		// alert('user의 save함수 호출');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		// console.log(data);
		
		// ajax 호출시 default가 비동기 호출
		// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		$.ajax({
			type : "POST",
			url : "/blog/api/user",
			data : JSON.stringify(data), // http body 데이터
			contentType : "application/json; charset=utf-8", // body 데이터가 어떤 타입인지(MIME)
			dataType: "json" // 요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (json 형태라면 javascript object로 변경)
		}).done(function(res){
			alert("회원가입이 완료되었습니다.");
			// console.log(res);
			location.href="/blog";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	},
	
	login: function(){
		// alert('user의 save함수 호출');
		let data = {
			username: $("#username").val(),
			password: $("#password").val()
		};
		
		$.ajax({
			type : "POST",
			url : "/blog/api/user/login",
			data : JSON.stringify(data), // http body 데이터
			contentType : "application/json; charset=utf-8", // body 데이터가 어떤 타입인지(MIME)
			dataType: "json" // 요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (json 형태라면 javascript object로 변경)
		}).done(function(res){
			alert("로그인이 완료되었습니다.");
			// console.log(res);
			location.href="/blog";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	}
}
