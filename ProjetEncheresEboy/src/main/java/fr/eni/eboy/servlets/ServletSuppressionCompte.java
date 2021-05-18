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
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		utilisateurManager.supprimerUtilisateur(utilisateur.getNumero());
		request.setAttribute("msgDeconnexion", "Votre compte a été supprimé");
		session.setAttribute("utilisateur", null);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
