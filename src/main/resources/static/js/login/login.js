$('#login').click(function() {

	const id = $('#id').val();
	const pw = $('#pw').val();

	if (id.trim() == '') {
		alert("아이디를 입력해주세요");
	} else if (pw.trim() == '') {
		alert("비밀번호를 입력해주세요.")
	} else if (id.trim() != '' && pw.trim() != '') {
		$.ajax({
			type: 'POST',
			url: "login",
			data: {
				id: id,
				pw: pw
			},
			success: function(data) {
				if (data == 1) {
					alert("존재하지 않는 아이디입니다.");
				} else if (data == 2) {
					alert("잘못된 비밀번호입니다.");
				} else if (data == 0) {
					location.replace("/");
				}
			},
			error: function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	}

});