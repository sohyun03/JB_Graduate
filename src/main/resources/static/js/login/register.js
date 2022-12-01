$('#cId').blur(function() {
	
	let id = $('#cId').val();
	
	$.ajax({
		type: 'POST',
		url: "idCheck",
		data: {
			cId: id
		},
		success: function(data) {
			if(data == 0){
				
			}
		},
		error: function() {
			alert("error.")
		}
	});
});