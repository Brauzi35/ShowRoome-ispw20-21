package logic.web.controller;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;

import logic.utils.SessionUser;
import logic.utils.SessionSponsor;
import logic.utils.SessionArtist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  SessionArtist sa = SessionArtist.getInstance();
		SessionSponsor ss = SessionSponsor.getInstance();
		SessionUser su = SessionUser.getInstance();


    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		session.invalidate();
		sa.setDescription(null);
		sa.setEmail(null);
		sa.setUsername(null);
		sa.setPassword(null);
		sa.setTalent(null);
		ss.setActivity(null);
		ss.setCapacity(null);
		ss.setDescription(null);
		ss.setPassword(null);
		ss.setUsername(null);
		su.setId(0);
		su.setPassword(null);
		su.setUsername(null);		
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
		dispatcher1.forward(request, response);
	}

}
