let cinemaArea = document.querySelectorAll('.ca');
const ele = document.querySelectorAll('.cinemaArea li')[0];
ele.classList.add('active');

cinemaArea.forEach((tab, idx) => {
	tab.addEventListener('click', function() {

		cinemaArea.forEach((item) => {
			item.classList.remove('active')
		})

		cinemaArea[idx].classList.add('active')

	})
})

$("#adul").on('click', '.ad', function() {

	$('#adul li').removeClass('active');
	$(this).addClass('active');
})

$("#mtul").on('click', '.mt', function() {

	$('#mtul li').removeClass('active');
	$(this).addClass('active');
})

let dateList = document.querySelectorAll('.dl');
let bt = $(".hi");
//console.log(bt[0].value);

dateList.forEach((tab, idx) => {
	tab.addEventListener('click', function() {

		dateList.forEach((item) => {
			item.classList.remove('active')
		})

		dateList[idx].classList.add('active')
	})
})

let timebox = document.querySelectorAll('.timebox');

timebox.forEach((tab, idx) => {
	tab.addEventListener('click', function() {

		timebox.forEach((item) => {
			item.classList.remove('active')
		})

		timebox[idx].classList.add('active')
	})
})
/*********************ajax 통신*********************/

// 지역 입력받아서 세부지역 뿌려주기
function area(aNo) {
	// console.log(name);
	$.ajax({
		type: 'POST',
		url: "option",
		data: {
			aNo: aNo
		},
		success: function() {
			$('#adul').load(location.href + ' #adul');
		},
		error: function() {
			console.log("error");
		}
	});
}

// 세부지역 받아서 영화 뿌려주기
function cinema(ciNo) {
	// console.log(ciNo);
	$.ajax({
		type: 'POST',
		url: "option2",
		data: {
			ciNo: ciNo
		},
		success: function() {
			$('#mtul').load(location.href + ' #mtul');
		},
		error: function() {
			console.log("error");
		}
	});
}



let getaNo = 0;
let getciName = "";
let movieName = "";
let getDate = "";
let getTheater = "";
let getTime = "";

function aNofuc(aNo) {
	getaNo = aNo;
	// console.log(aNo);
}
function ciNofuc(ciName) {
	getciName = ciName;
	$("#sCinema").text(ciName + "점");
	//console.log(getciName)
	// $('input[name=inputValue]').attr('value',"test");
}
function mlfuc(mlName) {
	movieName = mlName;
	$("#sTitle").text(mlName);

	$.ajax({
		type: 'POST',
		url: "poster",
		data: {
			mlName: mlName
		},
		success: function(data) {
			document.getElementById("posterThum").src = data;
		},
		error: function() {
			console.log("error");
		}
	});
}
function dfuc(date) {
	let d = date.substr(0, 1);
	let b = date.substr(2, 3);
	getDate = "2022-12-" + b + " (" + d + ")";
	$("#sDate").text(getDate);
}
function tfuc(time) {
	//console.log(time);

	if (time == 1) {
		getTime = "15:00~17:10";
		$("#sTime").text(getTime);
		$("#sTheater").text("2D/5관");
	} else if (time == 2) {
		getTime = "18:30~20:40";
		$("#sTime").text(getTime);
		$("#sTheater").text("2D/5관");
	}
}

$('#seatgo').click(function() {

	if (getaNo == 0) {
		alert("지역을 선택해주세요.")
	} else if (getciName == "") {
		alert("영화관을 선택해주세요.")
	} else if (movieName == "") {
		alert("영화를 선택해주세요.")
	} else if (getDate == "") {
		alert("날짜를 선택해주세요.")
	} else if (getTime == "") {
		alert("시간을 선택해주세요.")
	} else {
		$.ajax({
			type: 'POST',
			url: "reserve",
			data: {
				rArea: getaNo,
				rCinema: getciName,
				rMovie: movieName,
				rDate: getDate,
				rTime: getTime
			},
			success: function() {
				location.replace("/reservation/seat.do");
			},
			error: function() {
				console.log("error");
			}
		});
	}


});