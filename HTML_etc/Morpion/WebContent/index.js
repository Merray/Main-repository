
function bonjour(){
	
	console.log("Hello");
}

function reinit(){ 
	location.reload();
}

function changePlayer(joueur){
	
	if(joueur == 1){
		joueur = 2;
	}
	else{
		joueur = 1;
	}
	
	return joueur;
}

function applyTocken(joueur, bouton){
	console.log(bouton);
	if (joueur == 1){
		
		bouton.html("X");
		
	}
	else{
		bouton.html("O");
	}
	
	bouton.attr("disabled", "disabled");
}


function morpion(){
	
	var player = 2;
	var win = 1;
	
	//while (win == 1) {
	    
		player = changePlayer(player);
		
		$(".afficheJoueur").html("Joueur : 	"+player);
		
		$(".but").click(function(){
			applyTocken(player, $(this));
		});
		
}
	//}
	