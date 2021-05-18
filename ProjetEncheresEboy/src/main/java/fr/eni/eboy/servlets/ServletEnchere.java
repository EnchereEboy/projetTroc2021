package fr.eni.eboy.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.eboy.bll.ArticleManager;
import fr.eni.eboy.bll.EnchereManager;
import fr.eni.eboy.bo.Article;
import fr.eni.eboy.bo.Enchere;

/**
 * Servlet implementation class ServletEnchere
 */
@WebServlet("/enchere")
public class ServletEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEnchere() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Article articleEnCours = new Article();
	Integer idArticle = Integer.parseInt(request.getParameter("id"));
	System.out.println(idArticle);
	articleEnCours = new ArticleManager().selectById(idArticle);
	request.setAttribute("article", articleEnCours);
	System.out.println("article en cours : "+articleEnCours);
	Enchere enchereSelectionnee = new EnchereManager().selectByArticleMeilleurOffre(articleEnCours);
	request.setAttribute("enchere", enchereSelectionnee);
	request.setAttribute("meilleurAcheteur", enchereSelectionnee.getUtilisateur());
	System.out.println("Voici l'enchere selectionnée : " + enchereSelectionnee);
	System.out.println("Enchere faite par  :" + enchereSelectionnee.getUtilisateur());
	
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/enchere.jsp");
	rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
