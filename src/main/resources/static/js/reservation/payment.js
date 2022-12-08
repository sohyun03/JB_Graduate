let paybtn = document.querySelectorAll('.paySelect');

paybtn.forEach((tab, idx) => {
	tab.addEventListener('click', function() {

		paybtn.forEach((item) => {
			item.classList.remove('active');
		})

		paybtn[idx].classList.add('active');
	})
})
let paySelect;

$('.payul li').click(function() {
	paySelect = $(this).val();
	//console.log(paySelect);

	if (paySelect == 1) {
		$('#bank').css('display', 'block');
	} else {
		$('#bank').css('display', 'none');
	}
});

$('#paybtn').click(function() {

	if (paySelect == 0) {
		var IMP = window.IMP; // 생략 가능
		IMP.init("imp11605316"); // 예: imp00000000
		// IMP.request_pay(param, callback) 결제창 호출

		IMP.request_pay({
			pg: 'html5_inicis',
			pay_method: 'card',
			merchant_uid: 'merchant_' + new Date().getTime(),
			name: '상품1', //결제창에서 보여질 이름
			amount: 100, //실제 결제되는 가격
			buyer_email: 'iamport@siot.do',
			buyer_name: '구매자이름',
			buyer_tel: '010-1234-5678',
			buyer_addr: '서울 강남구 도곡동',
			buyer_postcode: '123-456'
		}, function(rsp) {
			//console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';

				$.ajax({
					type: 'POST',
					url: "reserveDB",
					success: function() {
						location.replace("/reservation/complete.do");
					},
					error: function() {
						alert("ajax실패");
					}
				});

			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
		});
	} else if (paySelect == 1) {
		location.replace("/reservation/complete.do");
		$.ajax({
			type: 'POST',
			url: "reserveDB",
			success: function(data) {
				console.log(data);
				location.replace("/reservation/complete.do");
			},
			error: function(request,status,error) {
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	}




}); 