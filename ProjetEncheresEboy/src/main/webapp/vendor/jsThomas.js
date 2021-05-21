 function oncheckedAll(){
			setTimeout(() => {
				uncheckAll();
			}, 10);
		}
			function delay() {
				setTimeout(() => {
					uncheckAll();
				}, 10);
				
			}
			function uncheckAll() {
				var RADIO = document.getElementById("achats");
				RADIO.removeAttribute("checked");
				var CHECK = document.getElementById("enchereOuverte");
				if(CHECK.checked){
					CHECK.checked = false;
				}
				var CHECK = document.getElementById("enchereUtilisateur");
				if(CHECK.checked){
					CHECK.checked = false;
				}
				var CHECK = document.getElementById("enchereGagnee");
				if(CHECK.checked){
					CHECK.checked = false;
				}
				
				var RADIO = document.getElementById("ventes");
				RADIO.removeAttribute("checked");
				var CHECK = document.getElementById("ventesOuverte");
				if(CHECK.checked){
					CHECK.checked = false;
				}
				var CHECK = document.getElementById("venteNonDebutee");
				if(CHECK.checked){
					CHECK.checked = false;
				}
				var CHECK = document.getElementById("venteTerminee");
				if(CHECK.checked){
					CHECK.checked = false;
				}
			}
			
			function unGreyMeGreyOther(a) {
				if (a == 0) {
					var LISTE = document.getElementById("listeVente");
					LISTE.className="listeGreyUnchecked";
					var LISTE = document.getElementById("listeAchat");
					LISTE.className="liste";
					var CHECK = document.getElementById("ventesOuverte");
					if(CHECK.checked){
						CHECK.checked = false;
					}
					var CHECK = document.getElementById("venteNonDebutee");
					if(CHECK.checked){
						CHECK.checked = false;
					}
					var CHECK = document.getElementById("venteTerminee")
					if(CHECK.checked){
						CHECK.checked = false;
					}
					}
				if (a == 1) {
					var LISTE = document.getElementById("listeAchat")
					LISTE.className="listeGreyUnchecked"
					var LISTE = document.getElementById("listeVente")
					LISTE.className="liste"
					var CHECK = document.getElementById("enchereOuverte")
					if(CHECK.checked){
						CHECK.checked = false;
					}
					var CHECK = document.getElementById("enchereUtilisateur")
					if(CHECK.checked){
						CHECK.checked = false;
					}
					var CHECK = document.getElementById("enchereGagnee")
					if(CHECK.checked){
						CHECK.checked = false;
					}
					}
			}