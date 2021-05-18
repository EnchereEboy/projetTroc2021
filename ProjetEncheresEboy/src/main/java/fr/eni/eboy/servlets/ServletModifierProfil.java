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
	private UtilisateurManager modifUtilisateur = new UtilisateurManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("id") == null) {
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
			rd.forward(request, response);
		} else {
			Integer idUser = Integer.parseInt(request.getParameter("id"));
			Utilisateur utilisateur = new Utilisateur();

			try {
				utilisateur = modifUtilisateur.retournerUtilisateurParId(idUser);
				request.setAttribute("userUpdate", utilisateur);
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		try {
			Utilisateur utilisateur = new Utilisateur();
			request.setAttribute("utilisateur", utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
		String confirmationMotDePasse = request.getParameter("confirmationMotDePasse"); 
		Integer credit = Integer.parseInt(session.getAttribute("credit").toString());
		boolean admin = false; 
		
		Utilisateur utilisateur = new Utilisateur(); 
		utilisateur.setPseudo(pseudo);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setTelephone(telephone);
		utilisateur.setRue(rue);
		utilisateur.setCodePostal(codePostal);
		utilisateur.setVille(ville);
		utilisateur.setMotDePasse(nouveauMotDePasse);
		utilisateur.setCredit(credit);
		utilisateur.setAdministrateur(admin);
		int id =  (Integer) session.getAttribute( "idUserSession" );
		utilisateur.setNumero(id);
		
		if(nouveauMotDePasse.equals(confirmationMotDePasse)) {
			try {
				modifUtilisateur.modificationUtilisateur(utilisateur);
				request.setAttribute("utilisateur", utilisateur);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/monProfil.jsp");
			rd.forward(request, response);
		}
	}

}
