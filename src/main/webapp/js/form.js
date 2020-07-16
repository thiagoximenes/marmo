jQuery( document ).ready( function( $ ){
	function waitForFlatpicker( callback ) {
	if ( typeof window.flatpickr !== 'function' ) {
		setTimeout( function() { waitForFlatpicker( callback ) }, 2 );
	}
		callback();
	}
	waitForFlatpicker( function(){
		flatpickr.l10ns.pt = {
		weekdays: {
		shorthand: ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"],
		longhand: [
		"Domingo",
		"Segunda-feira",
		"Terça-feira",
		"Quarta-feira",
		"Quinta-feira",
		"Sexta-feira",
		"Sábado",
		],
		},
		months: {
		shorthand: [
		"Jan",
		"Fev",
		"Mar",
		"Abr",
		"Mai",
		"Jun",
		"Jul",
		"Ago",
		"Set",
		"Out",
		"Nov",
		"Dez",
		],
		longhand: [
		"Janeiro",
		"Fevereiro",
		"Março",
		"Abril",
		"Maio",
		"Junho",
		"Julho",
		"Agosto",
		"Setembro",
		"Outubro",
		"Novembro",
		"Dezembro",
		],
		},
		rangeSeparator: " até ",
		};
		//set translations
		flatpickr.localize(flatpickr.l10ns.pt);
		flatpickr('.elementor-date-field');
		//set format
		setTimeout( function(){
		$('.elementor-date-field').each(function(){ flatpickr( $(this)[0] ).set('dateFormat', 'd/m/Y');});
		}, 1000 );
	});
});

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
