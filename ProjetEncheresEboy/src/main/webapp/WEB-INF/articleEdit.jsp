<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eboy - Article ? vendre</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/4-col-portfolio.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" media="all">
</head>

<body class="container">
	<h1 class="jumbotron">Nouvelle vente</h1>

	<div class="jumbotron">
		<a
			href="<%=response.encodeRedirectURL(request.getContextPath() + "/accueil")%>"><h3>ENI-Ench?res</h3></a>
		<form action="<%=request.getContextPath()%>/EditVente" method="POST">
			<table id="MaTable" class="tabcenter">
				<tbody>				
				<tr>
					<td rowspan="9"><img class="fit-picture"
						src="images/bonnet.jpg" alt="Photo de l'article"></td>
					<td>Article :</td>
					<td><input type="text" name="article" id="article"
						placeholder="Nom de l'article." required></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea name="description" minlength="10"
							maxlength="250" placeholder="Description de l'article." rows="5"
							cols="30" required></textarea></td>
				</tr>
				<tr>
					<td>Categorie :</td>
					<td><select name="categorie" id="categorie" required>
							<option value=""></option>
							<option value="1">Informatique</option>
							<option value="2">Ameublement</option>
							<option value="3">V?tement</option>
							<option value="4">Sport&Loisirs</option>
					</select></td>
				</tr>
				<tr>
					<td>Photo de l'article :</td>
					<td><input type="file" accept="image/jpeg,image/png"></td>
				</tr>
				<tr>
					<td>Mise ? prix :</td>
					<td><input type="number" id="miseaprix" name="miseaprix"
						min="100" max="10000" required></td>
				</tr>
				<tr>
					<td>D?but de l'enchere :</td>
					<td><input type="datetime-local" id="datedebutenchere"
						name="datedebutenchere" value="" min="2021" required></td>
				</tr>
				<tr>
					<td>Fin de l'enchere :</td>
					<td><input type="datetime-local" id="datefinenchere"
						name="datefinenchere" value="" min="2021" required></td>
				</tr>
				<tr>
					<!-- <td  ></td> -->
					<td colspan="2">
						<fieldset>
							<legend>Retrait</legend>
							<table id="MaTable1">
								<tr>
									<td width="50%"><label>Rue</label></td>
									<td width="50%"><input type="text" name="adresse"
										value="${user.rue}" placeholder="Votre adresse" /></td>
								</tr>
								<tr>
									<td><label>Code postal</label></td>
									<td><input type="text" name="codepoastal"
										value="${user.codePostal}" placeholder="Votre code postal" /></td>
								</tr>
								<tr>
									<td><label>Ville</label></td>
									<td><input type="text" name="ville" value="${user.ville}"
										placeholder="Votre Ville" /></td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td class="button"><input type="submit" name="enregistrer"
						value="Enregistrer"></td>
					<td class="button"><input type="reset" name="Annuler"
						value="Annuler" align="center"></td>
				</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>