let id = '';
let name = '';
let email = '';
let pw = '';
let pwCheck = '';

$('#cId').blur(function() {

	id = $('#cId').val();
	//console.log(id);

	if (!id) {
		$('#idNt').text("필수 정보입니다.");
	} else {
		$.ajax({
			type: 'POST',
			url: "idCheck",
			data: {
				cId: id
			},
			success: function(data) {
				if (data == true) { // 중복일 경우
					$('#idNt').text("중복된 아이디 입니다.");
				}
			},
			error: function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	}

});


$('#cName').blur(function() {

	name = $('#cName').val();

	if (!name) {
		$('#nameNt').text("필수 정보입니다.");
	} else {
		$('#nameNt').text("");
	}
});

$('#cEmail').blur(function() {

	email = $('#cEmail').val();

	if (!email) {
		$('#emailNt').text("필수 정보입니다.");
	} else {
		$.ajax({
			type: 'POST',
			url: "emailCheck",
			data: {
				cId: id
			},
			success: function(data) {

			},
			error: function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	}
});

$('#cPw').blur(function() {

	pw = $('#cPw').val();

	if (!pw) {
		$('#pwNt').text("필수 정보입니다.");
	} else {
		$('#pwNt').text("");
	}
});

$('#pwCheck').blur(function() {

	pwCheck = $('#pwCheck').val();

	if (!pwCheck) {
		$('#pwChNt').text("필수 정보입니다.");
	} else if (pwCheck != pw) {
		$('#pwChNt').text("비밀번호가 일치하지 않습니다.");
	} else{
		$('#pwChNt').text("");
	}
});