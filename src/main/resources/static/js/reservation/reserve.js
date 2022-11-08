function areaClick(event){
	var pa = event.parentNode;
	pa.classList.toggle("active");
}

const cinemaArea = document.querySelectorAll('.ca');

cinemaArea.forEach((tab, idx)=> {
    tab.addEventListener('click', function(){

        cinemaArea.forEach((item)=> {
            item.classList.remove('active')
        })

        cinemaArea[idx].classList.add('active')
    })
})

const areaDetail = document.querySelectorAll('.ad');

areaDetail.forEach((tab, idx)=> {
    tab.addEventListener('click', function(){

        areaDetail.forEach((item)=> {
            item.classList.remove('active')
        })

        areaDetail[idx].classList.add('active')
    })
})

const moveTitle = document.querySelectorAll('.mt');

moveTitle.forEach((tab, idx)=> {
    tab.addEventListener('click', function(){

        moveTitle.forEach((item)=> {
            item.classList.remove('active')
        })

        moveTitle[idx].classList.add('active')
    })
})

const dateList = document.querySelectorAll('.dl');

dateList.forEach((tab, idx)=> {
    tab.addEventListener('click', function(){

        dateList.forEach((item)=> {
            item.classList.remove('active')
        })

        dateList[idx].classList.add('active')
    })
})