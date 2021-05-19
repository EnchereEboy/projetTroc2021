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
 * Servlet implementation class ServletSuppressionCompte
 */
@WebServlet("/suppressionCompte")
public class ServletSuppressionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionEncheres = request.getSession();
		String id =request.getParameter("id"); 
		Integer idUserToDelete=Integer.parseInt(id);
		UtilisateurManager userDelete = new UtilisateurManager(); 
		Utilisateur user = (Utilisateur) sessionEncheres.getAttribute("userReturnedSession");
		String userPwd = user.getMotDePasse();
		String oldPwd = request.getParameter("motDePasse"); 
		
		if (userPwd.equals(oldPwd)) {
				int retour = userDelete.supprimerUtilisateur(idUserToDelete);
				
				if(retour > 0) {
					request.setAttribute("msgDeconnexion", "Votre compte a été supprimé"); 
					sessionEncheres.invalidate();
					 RequestDispatcher rd = request.getRequestDispatcher("/index");
					 rd.forward(request, response); 
				} else {
					//Utilisateur user = (Utilisateur) sessionEncheres.getAttribute("userReturnedSession");
					request.setAttribute("userUpdate", user);
					request.setAttribute("msgDeconnexion", "Votre compte ne peut pas être supprimé");
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
					rd.forward(request, response); 
				}
	    }else {
	    	request.setAttribute("incorrectOldPwd", "Le mot de passe fourni est incorrect");
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
			rd.forward(request, response);
	    }
		//session.setAttribute("utilisateur", null);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
