$(function () {
  $('[data-toggle="popover"]').popover()
})

/*$(document).ready(
		function(){
		$("tr").hide();
		}
)*/

function ajouter(){
	
	var identifiant = parseInt(document.getElementById("identifiant").innerHTML);
	var idPlusUn = identifiant + 1;
	var nom = document.getElementById("nom").value;
	var prenom = document.getElementById("prenom").value;
	var age = document.getElementById("age").value;
	var situation = document.getElementById("situation").value;
	
	
	var table = document.getElementById("tabInfo");
	var tr = document.createElement("tr");
	
	//Toutes les données à ajouter 
	var tdId = document.createElement("th");
	var tdNom = document.createElement("td");
	var tdPrenom = document.createElement("td");
	var tdAge = document.createElement("td");
	var tdSituation = document.createElement("td");
	var tdOptions = document.createElement("td");
	var modifButton = document.createElement("button");
	var supprButton = document.createElement("button");
	var tdButton = document.createElement("td");
	
	
	modifButton.innerHTML = "Modifier";
	supprButton.innerHTML = "Supprimer";
	
	tdId.setAttribute("scope", "row")
	
	modifButton.setAttribute("class", "btn btn-sm btn-primary");
	modifButton.setAttribute("data-toggle", "popover");
	modifButton.setAttribute("title", "Modifier");
	modifButton.setAttribute("data-content", "Ce bouton ne sert à rien pour le moment...");
	
	supprButton.setAttribute("class", "btn btn-danger btn-sm ");
	supprButton.setAttribute("onclick", "remove(this); ");
	
	tdButton.appendChild(modifButton);
	tdButton.appendChild(supprButton);
	
	
	
	tdId.appendChild(document.createTextNode(idPlusUn));
	tdNom.appendChild(document.createTextNode(nom));
	tdPrenom.appendChild(document.createTextNode(prenom));
	tdSituation.appendChild(document.createTextNode(situation));
	tdAge.appendChild(document.createTextNode(age));

	
	tr.appendChild(tdId);
	tr.appendChild(tdNom);
	tr.appendChild(tdPrenom);
	tr.appendChild(tdAge);
	tr.appendChild(tdSituation);
	tr.appendChild(tdButton);
	
	
	
	table.appendChild(tr);
}

function remove(elem){
	
	var row = elem.parentNode.parentNode;
	var table = document.getElementById("tabInfo");
	table.removeChild(row);
	
}	

