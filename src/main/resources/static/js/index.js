var swiper = new Swiper(".mySwiper", {
	effect: "coverflow",
	grabCursor: true,
	centeredSlides: true,
	slidesPerView: 4,
	coverflowEffect: {
		rotate: 55,
		stretch: 0,
		depth: 100,
		modifier: 1,
		slideShadows: true,
	},
//	pagination: {
//		el: ".swiper-pagination",
//	},
});