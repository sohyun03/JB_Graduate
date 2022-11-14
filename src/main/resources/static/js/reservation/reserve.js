function areaClick(event) {
	var pa = event.parentNode;
	pa.classList.toggle("active");
}

const cinemaArea = document.querySelectorAll('.ca');
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

const moveTitle = document.querySelectorAll('.mt');

moveTitle.forEach((tab, idx) => {
	tab.addEventListener('click', function() {

		moveTitle.forEach((item) => {
			item.classList.remove('active')
		})

		moveTitle[idx].classList.add('active')
	})
})





const dateList = document.querySelectorAll('.dl');

dateList.forEach((tab, idx) => {
	tab.addEventListener('click', function() {

		dateList.forEach((item) => {
			item.classList.remove('active')
		})

		dateList[idx].classList.add('active')
	})
})
$("#adul").on('click', '.ad', function() {

	$('#adul li').removeClass('active');
	$(this).addClass('active');

	//	const areaDetail = document.querySelectorAll('.ad');
	//
	//	areaDetail.forEach((tab, idx) => {
	//		tab.addEventListener('click', function() {
	//
	//			areaDetail.forEach((item) => {
	//				item.classList.remove('active')
	//			})
	//
	//			areaDetail[idx].classList.add('active')
	//
	//		})
	//	})
})

function area(aNo) {
	// console.log(name);
	$.ajax({
		type: 'POST',
		url: "option",
		data: {
			aNo: aNo
		},
		success: function(data) {
			$('#adul').load(location.href + ' #adul');
		},
		error: function(error) {
			console.log("error");
		}
	});
}