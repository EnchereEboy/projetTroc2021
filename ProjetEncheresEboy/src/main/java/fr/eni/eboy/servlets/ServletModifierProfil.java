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
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/modifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		RequestDispatcher rd =null;		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = null;
		HttpSession session = request.getSession();

		String identifiant = request.getParameter("pseudo");	
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
		String confirmationMotDePasse = request.getParameter("confirmationMotDePasse");
					
		try {
			if (nouveauMotDePasse != null) {
				if (!nouveauMotDePasse.equals(confirmationMotDePasse)) {					
					rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
					rd.forward(request, response);
				} else {
					utilisateur = utilisateurManager.retournerUtilisateur(identifiant);
					utilisateur.setPseudo(identifiant);
					utilisateur.setNom(nom);
					utilisateur.setPrenom(prenom);
					utilisateur.setEmail(email);
					utilisateur.setTelephone(telephone);
					utilisateur.setRue(rue);
					utilisateur.setCodePostal(codePostal);
					utilisateur.setVille(ville);
					utilisateur.setMotDePasse(nouveauMotDePasse);
					utilisateurManager.modificationUtilisateur(utilisateur);
						
					utilisateur = utilisateurManager.retournerUtilisateur(identifiant);
					session.setAttribute("utilisateur", utilisateur);
					rd = request.getRequestDispatcher("index");
					rd.forward(request, response);
				}
			} else {
				utilisateur = utilisateurManager.retournerUtilisateur(identifiant);
				utilisateur.setPseudo(identifiant);
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				utilisateur.setEmail(email);
				utilisateur.setTelephone(telephone);
				utilisateur.setRue(rue);
				utilisateur.setCodePostal(codePostal);
				utilisateur.setVille(ville);
				utilisateur.setMotDePasse(motDePasse);
				utilisateurManager.modificationUtilisateur(utilisateur);
					
				utilisateur = utilisateurManager.retournerUtilisateur(identifiant);
				session.setAttribute("utilisateur", utilisateur);
				rd = request.getRequestDispatcher("index");
				rd.forward(request, response);
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
