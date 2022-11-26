let aValue = 0;
let tValue = 0;
let sValue = 0;
let total;
let seatNum = new Array();
let arr = [];

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
	}
}

$('.p-num').click(function() {
	aValue = $("input[type=radio][name=adult]:checked").val();
	tValue = $("input[type=radio][name=teenager]:checked").val();
	sValue = $("input[type=radio][name=soldier]:checked").val();

	total = parseInt(aValue) + parseInt(tValue) + parseInt(sValue);

	if (total > 0) {
		$("input:checkbox[name='rSeats']").prop("disabled", false);
	} else if (total == 0) {
		$("input:checkbox[name='rSeats']").prop("disabled", true);
		$("input:checkbox[name='rSeats']").prop("checked", false);
		seatNum.length = 0;
		arr.length = 0;
		$("#choiceList li").each(function() {
			$(this.remove());
		});
	}

})

$('.seatArea').each(function() {
	$(this).find('input').change(function() {

		let c = $('input:checkbox[name=rSeats]:checked');

		total = parseInt(aValue) + parseInt(tValue) + parseInt(sValue);
		$('.s-num').attr("disabled", false);

		let cv = c.length;
		if (cv >= total) {
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
	let list = $('input:checkbox[name=rSeats]');

	for (var i = 0; i < list.length; i++) {
		if (list[i].checked) {
			seatNum.push(list[i].value);
		}
	}
	$.ajax({
		type: 'POST',
		url: "seats",
		data: {
			rPeople: total,
			//rSeats: seats
		},
		success: function(data) {
			console.log("success");
		},
		error: function(error) {
			console.log("error");
		}
	});
});