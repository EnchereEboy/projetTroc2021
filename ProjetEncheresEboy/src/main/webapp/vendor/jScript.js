  function verifDate(){
	 
	var reggie = /(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2})/;
	var nomArticle = document.getElementById("article").value;
	var descriptionArticle = document.getElementById("description").value;
	var categorieArticle = document.getElementById("categorie").value;
	var miseAPrixArticle = document.getElementById("miseaprix").value;
	var datedebutenchereArticle = document.getElementById("datedebutenchere").value;
	var heuredebutenchereArticle = document.getElementById("heuredebutenchere").value;
	var debutenchere=datedebutenchereArticle+" "+heuredebutenchereArticle;
   
      var datefinenchereArticle = document.getElementById("datefinenchere").value;
      var heurefinenchereArticle = document.getElementById("heurefinenchere").value;
      var finenchere=datefinenchereArticle+" "+heurefinenchereArticle;

    	var datedebutencherArray = reggie.exec(debutenchere);
		var datefinencherArray = reggie.exec(finenchere);
	var dateheuredebutenchere = new Date(
	    (+datedebutencherArray[1]),
	    (+datedebutencherArray[2])-1, // Careful, month starts at 0!
	    (+datedebutencherArray[3]),
	    (+datedebutencherArray[4]),
	    (+datedebutencherArray[5])
    ); 

var dateheurefinenchere = new Date(
	    (+datefinencherArray[1]),
	    (+datefinencherArray[2])-1, // Careful, month starts at 0!
	    (+datefinencherArray[3]),
	    (+datefinencherArray[4]),
	    (+datefinencherArray[5])
    ); 


 
var currentDate = new Date();
	if(currentDate.getTime() > dateheuredebutenchere.getTime() ){
		alert("Le debut des encheres doit être superieur à la date de today");
		return false;
	} else if(dateheuredebutenchere.getTime() > dateheurefinenchere.getTime()){
		alert("La date de debut doit etre inferieure à la date de fin ");
		return false;
	}else {
							 
					  var r = confirm("Etes vous surs de mettre en ligne l'article "+nomArticle);
					  if (r == true) {
					    return true;
					  } else {
					    return false;
					  } 
				 
		
		
	}
	
	  
}