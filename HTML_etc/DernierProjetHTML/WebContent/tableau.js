
var compteur = 0;

$(document).ready(function(){
	$(".but").click(function(){
		
		
		compteur+= 1;
		$(this).addClass('flip');
		$(this).html(compteur);
	})

});



function reinit(){ 
	location.reload();
}


