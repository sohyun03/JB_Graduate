let id = '';
let iname = '';
let email = '';
let pw = '';
let pwCheck = '';
let is, ns, es, ps, pcs;

$('#cId').blur(function() {

	id = $('#cId').val();
	//console.log(id);
	if (!id) {
		is = 1;
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
					is = 1;
				} else {
					$('#idNt').text("");
					is = 0;
				}
			},
			error: function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	}

});

$('#cName').blur(function() {

	iname = $('#cName').val();

	if (!iname) {
		ns = 1;
		$('#nameNt').text("필수 정보입니다.");
	} else {
		$('#nameNt').text("");
		ns = 0;
	}
});

$('#cEmail').blur(function() {

	email = $('#cEmail').val();

	const regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

	if (!email) {
		es = 1;
		$('#emailNt').text("필수 정보입니다.");
	} else if (!regExp.test(email)) {
		es = 1;
		$('#emailNt').text("이메일 형식이 아닙니다.");
	} else {
		es = 0;
		$('#emailNt').text("");
	}
});

$('#cPw').blur(function() {

	pw = $('#cPw').val();

	const num = pw.search(/[0-9]/g);
	const eng = pw.search(/[a-z]/ig);
	const spe = pw.search(/[`.,~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

	if (!pw) {
		ps = 1;
		$('#pwNt').text("필수 정보입니다.");
	} else if (pw.length < 8 || pw.length > 20) {
		ps = 1;
		$('#pwNt').text("8자리 ~ 20자리 이내로 입력해주세요.");
	} else if (pw.search(/\s/) != -1) {
		ps = 1;
		$('#pwNt').text("비밀번호는 공백 없이 입력해주세요.");
	} else if (num < 0 || eng < 0 || spe < 0) {
		ps = 1;
		$('#pwNt').text("영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
	} else {
		ps = 0;
		$('#pwNt').text("");
	}
});

$('#pwCheck').blur(function() {

	pwCheck = $('#pwCheck').val();

	if (!pwCheck) {
		pcs = 1;
		$('#pwChNt').text("필수 정보입니다.");
	} else if (pwCheck != pw) {
		pcs = 1;
		$('#pwChNt').text("비밀번호가 일치하지 않습니다.");
	} else {
		pcs = 0;
		$('#pwChNt').text("");
	}
});

$('#register').click(function() {
	if (!id || is == 1) {
		alert("아이디를 입력해주세요.");
		$('#cId').focus();
	} else if (!iname || ns == 1) {
		alert("이름을 입력해주세요.");
		$('#cName').focus();
	} else if (!email || es == 1) {
		alert("이메일을 입력해주세요.");
		$('#cEmail').focus();
	} else if (!pw || ps == 1) {
		alert("비밀번호를 입력해주세요.");
		$('#cPw').focus();
	} else if (!pwCheck || pcs == 1) {
		alert("비밀번호확인을 입력해주세요.");
		$('#pwCheck').focus();
	} else if ((is && ns && es && ps && pcs) == 0) {
		$.ajax({
			type: 'POST',
			url: "register",
			data: {
				cId: id,
				pw: pw,
				cName: iname,
				cEmail: email
			},
			success: function(data) {
				if (data == 0) {
					location.replace("/login/login.do");
				}
			},
			error: function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	} else {
		alert("다시 시도해주세요.");
	}

});