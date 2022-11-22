let aValue = 0;
let tValue = 0;
let sValue = 0;

$('.p-num').click(function() {
	aValue = $("input[type=radio][name=adult]:checked").val();
	tValue = $("input[type=radio][name=teenager]:checked").val();
	sValue = $("input[type=radio][name=soldier]:checked").val();

	let total = parseInt(aValue) + parseInt(tValue) + parseInt(sValue);
	
	if (total > 0) {
		$("input:checkbox[name='seat']").prop("disabled", false);
	} else if(total == 0){
		$("input:checkbox[name='seat']").prop("disabled", true);
	}

})


function count(event) {
	
	let c = $('input:checkbox[name=seat]:checked');
	
	let total = parseInt(aValue) + parseInt(tValue) + parseInt(sValue);
	$('.s-num').attr("disabled", false);

	let cv = c.length;
	if (cv >= total) {
		$('.s-num').attr("disabled", true);
		c.attr("disabled", false);
	}
	
	let seatNum = new Array();
	console.log(event.target.val());
}
