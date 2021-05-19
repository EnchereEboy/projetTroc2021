package fr.eni.eboy.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eboy.bll.UtilisateurManager;

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
		Integer idUserToDelete=Integer.parseInt(request.getParameter("id"));
		UtilisateurManager userDelete = new UtilisateurManager(); 
		
		int retour = userDelete.supprimerUtilisateur(idUserToDelete);
		
		if(retour > 0) {
			request.setAttribute("msgDeconnexion", "Votre compte a été supprimé");
		} else {
			request.setAttribute("msgDeconnexion", "Votre compte ne peut pas être supprimé");
		}
		
		//session.setAttribute("utilisateur", null);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
