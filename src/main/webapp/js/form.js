function iniciarInputDate(){
//	if(DEBUG) console.log('date inputinit');
	try{
		console.log("cai aqui");
		$('.custom-date').each(function() {
		    $(this).flatpickr({
		    	dateFormat: "d/m/Y"
		    });
		});
		
		$('.custom-datetime').each(function() {
		    $(this).flatpickr({
				enableTime: true,
				time_24hr: true,
		    	dateFormat: "d/m/Y H:i"
		    });
		});
	}catch(e){
		console.error('Falha iniciando meiomask!', e)
	}
}

iniciarInputDate();