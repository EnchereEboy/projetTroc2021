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
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletConnexion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupération des données venant de la jsp connexion identifiant et mot de passe
		String identifiant= "";
		String motDePasse = "";
		
		//Récupération des paramètres à envoyer à la bll
		identifiant = request.getParameter("id");
		
		
		
		motDePasse = request.getParameter("mdp");
		
		//Création de la fiche information saisie par l'utilisateur dans la page connexion
		
		//Récupération des info de connection, Le manager va faire le select... 
		Utilisateur userConnected = new UtilisateurManager().insertConnection(identifiant,motDePasse);
		System.out.println(userConnected);
		
		if(userConnected.getNom()== null && userConnected.getNumero()== null){ 
			request.setAttribute("messageUser", "Identifiant ou mot de passe érroné.<br>Veuillez de nouveau saisir votre identifiant et mot de passe");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
			rd.forward(request, response);
		}else {
			HttpSession sessionEnchere = request.getSession();
			//On recupere l'identifiant de l'utilisateur
			Integer idUser=userConnected.getNumero();
			// On le stock dans une variable de session
			sessionEnchere.setAttribute("idUserSession", idUser);
//			sessionEnchere.setAttribute("objetUser", userConnected);
			request.setAttribute("utilisateurconnecte", userConnected);
			RequestDispatcher rd = request.getRequestDispatcher("/index");
			rd.forward(request, response);
		}
		
		
		// Vérification du mot de passe(si mdp correspond à id alors connexion réussi sinon retour à la jsp connexion avec message votre mot de passe est incorrecte)
		
					/*	if(identifiant.equals("pseudo") && (motDePasse.equals("mdp"))) {
							System.out.println("Connexion établie");
							RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
							
						}else (identifiant.equals("email") && (motDePasse.equals("mdp"))){
							System.out.println("Connexion établie");
							RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
						}else {
							System.out.println("Login ou mot de passe érroné. Veuillez de nouveau saisir vos identifiants et mot de passe");
						}
					*/	
		
	
		
		//S'il y a pas d'erreur, on va dans la jsp insciption
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
			//	rd.forward(request, response);
	}

}
