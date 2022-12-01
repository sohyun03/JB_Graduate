let aValue = 0;
let tValue = 0;
let sValue = 0;
let totalNum = 0;
let seatNum = new Array();
let arr = [];
let adultp = 6000;
let teenp = 4000;
let solp = 3000;
let totalPrice = 0;

// 뒤로가기시 초기화
window.onpageshow = function(event) {
	if (event.persisted || (window.performance && window.performance.navigation.type == 2)) {
		seatNum.length = 0;
		arr.length = 0;
		$("input:checkbox[name='rSeats']").prop("disabled", true);
		$("input:checkbox[name='rSeats']").prop("checked", false);
		$("input[type=radio][name=adult]:radio[value=0]").prop('checked', true);
		$("input[type=radio][name=teenager]:radio[value=0]").prop('checked', true);
		$("input[type=radio][name=soldier]:radio[value=0]").prop('checked', true);
		$("#choiceList li").each(function() {
			$(this.remove());
		});
		totalNum = 0;
		$(".totalAmt").html("총 0원");
	}
}

$('.p-num').click(function() {

	aValue = $("input[type=radio][name=adult]:checked").val();
	tValue = $("input[type=radio][name=teenager]:checked").val();
	sValue = $("input[type=radio][name=soldier]:checked").val();

	totalPrice = (aValue * adultp) + (tValue * teenp) + (sValue * solp);
	let tempPrice = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
	$(".totalAmt").html("총 " + tempPrice + "원");

	totalNum = parseInt(aValue) + parseInt(tValue) + parseInt(sValue);

	let ch = $("input:checkbox[name='rSeats']:checked").length;

	if (totalNum > 0) {
		$("input:checkbox[name='rSeats']").prop("disabled", false);
	} else if (totalNum == 0) {
		$("input:checkbox[name='rSeats']").prop("disabled", true);
		$("input:checkbox[name='rSeats']").prop("checked", false);
		seatNum.length = 0;
		arr.length = 0;
		$("#choiceList li").each(function() {
			$(this.remove());
		});
	}
	if (totalNum < ch) {
		alert("선택한 좌석 수보다 적은 인원을 선택할 수 없습니다.\n좌석을 취소하시고 선택해주세요.");
		$("input[type=radio][name=adult]:radio[value=0]").prop('checked', true);
		$("input[type=radio][name=teenager]:radio[value=0]").prop('checked', true);
		$("input[type=radio][name=soldier]:radio[value=0]").prop('checked', true);
		event.preventDefault();
	}
})


$('.seatArea').each(function() {
	$(this).find('input').change(function() {

		$(".reserved").prop("disabled", true);
		$(".reserved").prop("checked", false);

		let c = $('input:checkbox[name=rSeats]:checked');

		totalNum = parseInt(aValue) + parseInt(tValue) + parseInt(sValue);
		$('.s-num').attr("disabled", false);

		let cv = c.length;
		if (cv >= totalNum) {
			$('.s-num').attr("disabled", true);
			c.attr("disabled", false);
		}


		const li = document.createElement("li");
		li.setAttribute('class', "on");

		let setname;
		if ($(this).prop('checked') == true) {
			//console.log( $(this).next('span').text() );
			setname = $(this).next('span').text();
			arr.push(setname);
			arr.sort();

			let textNode = document.createTextNode(setname);
			li.appendChild(textNode);
			document.getElementById('choiceList').appendChild(li);
			//console.log(arr);
		} else {
			setname = $(this).next('span').text();
			var popIdx = arr.indexOf(setname);
			if (popIdx > -1) {
				arr.splice(popIdx, 1);
			}
			arr.sort();

			let text;
			$("#choiceList li").each(function() {
				//console.log($(this).text());
				text = $(this).text();
				if (text == setname) {
					$(this.remove());
				}
			});

		}
	});


});

$('#paygo').click(function() {
	
	let ch = $("input:checkbox[name='rSeats']:checked").length;
	
	if (totalNum == 0) {
		alert("인원과 좌석을 선택해주세요.");
	} else if(totalNum > ch){
		alert("인원에 맞게 좌석을 선택해주세요.");
	} else {
		$.ajax({
			type: 'POST',
			url: "seats",
			data: {
				adult: aValue,
				teenager : tValue,
				soldier: sValue,
				rSeats: arr,
				price: totalPrice,
			},
			success: function() {
				console.log("success");
				window.location.href = "/reservation/payment.do";
			},
			error: function() {
				console.log("error");
				window.location.href = "/";
				alert("예매를 다시 시도해주세요.")
			}
		});
	}

});