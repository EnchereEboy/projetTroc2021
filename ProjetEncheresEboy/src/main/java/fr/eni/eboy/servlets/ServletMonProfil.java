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
 * Servlet implementation class ServletProfil
 */
@WebServlet("/monProfil")
public class ServletMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionEncheres = request.getSession();
//		sessionEncheres.getAttribute("idUser");
		if( sessionEncheres.getAttribute("idUser")==null) { 
			RequestDispatcher rd = request.getRequestDispatcher("/index");
			rd.forward(request, response);
			
		}else {
			 Integer idUser = Integer.parseInt(request.getParameter("id"));
			sessionEncheres.setAttribute( "idUser", idUser ); 
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			Utilisateur utilisateur = new Utilisateur();
					
			try {
				utilisateur = utilisateurManager.retournerUtilisateurParId(idUser);
				request.setAttribute("utilisateur", utilisateur);
				sessionEncheres.setAttribute( "credit", utilisateur.getCredit() );
				sessionEncheres.setAttribute("userReturnedSession", utilisateur);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/monProfil.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
			
	//		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
