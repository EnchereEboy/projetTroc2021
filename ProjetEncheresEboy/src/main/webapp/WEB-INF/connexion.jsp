<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	h1{color:blue}

</style>
<title>eboy - Connexion</title>
<style>
body{
  text-align: center;
}
table{
  margin:auto;
}
h3{font-weight: bold;
color: red;}
</style>
  </head>

  <body>
  	 <h1>ENI-Enchères</h1>
 
<h3>${messageUser}</h3>
  	<form action="<%=request.getContextPath() %>/ServletConnexion" method="POST">
	
	 <table id="MaTable" style="text-align: center" >
				<tbody>
						<tr>
						<td >Identifiant :</td>
						<td ><input type ="text" id="ididentifiant" name="id" required></td>
						</tr>
						
						<tr>
						<td >Mot de passe :</td>
						<td ><input type ="password" id="idmdp" name="mdp" required></td>
						</tr>
						
						<tr >
						<td rowspan="2"><input type="submit" id="connexion" value="Connexion"></td>
						 
						 
						<td colspan="2"><input type="checkbox"  id="idsouvenir" name="souvenir">Se souvenir de moi<td> 
						  </tr>
						 
						 <td><a href="">Mot de passe oublié</a></td>
					
				</tbody>
	</table>
	</form>					
						
    <form action="<%=request.getContextPath() %>/ServletInscription" method="GET">
     <input type="submit" name="creer" id="creer" value="Créer un compte">
    </form>
    
</body>
</html>