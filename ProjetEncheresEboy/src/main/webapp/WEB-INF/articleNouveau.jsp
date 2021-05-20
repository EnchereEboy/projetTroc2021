<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet" media="all">
<script src="vendor/jScript.js"></script>
</head>
<body>
<a href="<%=response.encodeRedirectURL(request.getContextPath() + "/accueil")%>"><h3>ENI-Enchères</h3></a>
   <form  action="<%=request.getContextPath() %>/NouvelleVente"  method="POST"  onsubmit="return verifDate()" >
                 <table     id="MaTable" class="tabcenter">
						<tbody>  
						<caption> Nouvelle vente   </caption>
						<tr  >
						<td  rowspan="9"><img class="fit-picture" src="images/NoImage.png" alt="Photo de l'article"></td>
						<td >Article :</td>
						<td ><input type ="text" name="article" id="article" placeholder="Nom de l'article." required></td>
						</tr>
						<tr  >
						<td >Description </td>
						<td  ><textarea name="description" id="description" minlength="10" maxlength="250" placeholder="Description de l'article." rows="5" cols="30" required></textarea></td> 
						</tr>
						<tr >
						<td >Categorie :</td>
						<td >
						   <select name="categorie" id="categorie" required>
								<option value=""> </option>
								<option value="1">Informatique</option>
								<option value="2">Ameublement</option>
								<option value="3">Vêtement</option> 
								<option value="4">Sport&Loisirs </option> 
							</select>
						</td> 
						</tr>
						<tr >
						<td >Photo de l'article : </td>
						<td ><input type="file" accept="image/jpeg,image/png" ></td> 
						</tr>
						<tr >
						<td >Mise à prix :</td>
						<td >
						    <input type="number" id="miseaprix" name="miseaprix" min="100" max="10000" required>
						</td> 
						</tr>
						<tr >
						<td >Début de l'enchere :</td>
						<td >
<!-- 						      <input type="datetime-local" id="datedebutenchere" -->
<!-- 								   name="datedebutenchere" value="" -->
<!-- 								   min="2021" required > -->
						        <input id="datedebutenchere" type="date" name="datedebutenchere"> <input type="time" name="heuredebutenchere"  id="heuredebutenchere">
						</td> 
						</tr>
						<tr >
						<td >Fin de l'enchere :</td>
						 <td >
<!-- 						      <input type="datetime-local" id="datefinenchere" -->
<!-- 								   name="datefinenchere" value="" -->
<!-- 								   min="2021" required > -->
						    <input id="datefinenchere" type="date" name="datefinenchere"><input type="time" name="heurefinenchere"  id="heurefinenchere">
						
						</td> 
						</tr>
						<tr  >
						<!-- <td  ></td> --> 
						<td  colspan="2">
						<fieldset>
			             <legend>Retrait</legend>
						        <table   id="MaTable1" >
										<tr >
											<td width="50%"><label>Rue</label></td>
											<td width="50%"><input type="text" name="adresse" value="${user.rue}" placeholder="Votre adresse"/> </td>
										</tr>
										<tr>
											<td><label>Code postal</label></td>
											<td><input type="text" name="codepostal" value="${user.codePostal}" placeholder="Votre code postal"/></td>
										</tr>
										<tr>
											<td><label>Ville</label></td>
											<td><input type="text" name="ville" value="${user.ville}" placeholder="Votre Ville"/></td>
										</tr>
								</table>
						</fieldset>
						</td> 
						</tr>
						<tr >
						<td class="button" ><input type="submit" name="enregistrer" value="Enregistrer"  ></td>
						<td class="button"><input type="reset"  name="Annuler" value="Annuler" align="center"></td> 
						</tr>
						</tbody>
</table>
   
   </form>
</body>
</html>