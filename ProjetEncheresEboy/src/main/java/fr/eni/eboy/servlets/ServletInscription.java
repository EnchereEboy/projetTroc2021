package fr.eni.eboy.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.eboy.bll.UtilisateurManager;

import fr.eni.eboy.bo.Utilisateur;


/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//RequestDispatcher (jsp inscription)
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionEnchere = request.getSession();
		//Récupération des données du formulaire d'inscription
				String pseudo = "";
				String nom = "";
				String prenom = "";
				String email = "";
				String telephone = "";
				String rue = "";
				String codePostal = "";
				String ville = "";
				String motDePasse = "";
				String confirmation="";
				//String hiddenKey="";
				
				//Récupération des paramètres à envoyer à la bll
//				String userSessionId= (String) sessionEnchere.getAttribute("idUserSession"); 
//				hiddenKey = request.getParameter("keyUser");
//			if(userSessionId.equals(hiddenKey)) {
//				
//			}else {
				pseudo = request.getParameter("pseudo");
				nom = request.getParameter("nom");
				prenom = request.getParameter("prenom");
				email = request.getParameter("email");
				telephone = request.getParameter("telephone");
				rue = request.getParameter("rue");
				codePostal = request.getParameter("cp");
				ville = request.getParameter("ville");
				motDePasse = request.getParameter("mdp");
				confirmation = request.getParameter("mdpconfirmation");
				System.out.println(motDePasse+"-- confirmation --"+confirmation);
//			}
				
				if(!motDePasse.equals(confirmation)) {
					//Creation des valeurs pour remplir le formulaire afin d'eviter de perdre la saisie du User
					request.setAttribute("pseudo", pseudo);
					request.setAttribute("nom", nom);
					request.setAttribute("prenom", prenom);
					request.setAttribute("email", email);
					request.setAttribute("telephone", telephone);
					request.setAttribute("rue", rue);
					request.setAttribute("codePostal", codePostal);
					request.setAttribute("ville", ville);
					request.setAttribute("mdpPasIdentique", "Les mots de passe doivent être identiques");
					//Modifier pour rediriger vers l'accueil
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
					rd.forward(request, response);
					
				}else {
					//Création de la fiche d'information saisie par l'utlisateur
					
					Utilisateur nouveauUtilisateur = new Utilisateur( pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 100);					
					//Récupération des infoInscription puis le manager va faire l'insert 
					System.out.println(nouveauUtilisateur );
					Utilisateur utilisateurAjout = new UtilisateurManager().insert(nouveauUtilisateur);
					//on cree une session si elle n'existe pas
				
					//On recupere l'identifiant de l'utilisateur
					Integer idUser=utilisateurAjout.getNumero(); 
					// On le stock dans une variable de session
					sessionEnchere.setAttribute("idUser", idUser);
					//Modifier pour rediriger vers l'accueil
					request.removeAttribute("pseudo");
					request.removeAttribute("nom");
					request.removeAttribute("prenom");
					request.removeAttribute("email");
					request.removeAttribute("telephone");
					request.removeAttribute("rue");
					request.removeAttribute("codePostal");
					request.removeAttribute("ville");
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
					rd.forward(request, response);
				}
 
				
				
				
				
	}

}
