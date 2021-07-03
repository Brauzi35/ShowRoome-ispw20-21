package logic.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.dao.SponsorDao;
import logic.exceptions.PendingRequestException;
import logic.utils.SessionUser;


@WebServlet("/HostShowWebController")
public class HostShowWebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HostShowWebController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionUser su = SessionUser.getInstance();
		if(su.getId()==2) {
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/ArtistRequest.jsp");
			dispatcher2.forward(request, response);
		}
		if(su.getId()==3) {
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/RequestStatus.jsp");
			dispatcher2.forward(request, response);
		}
		if(su.getId()==1) {
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/UserSponsoredEvents.jsp");
			dispatcher2.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String artist = request.getParameter("artista");
		String title = request.getParameter("titolo");
		String desc = request.getParameter("descrizione");
		
		SponsorDao sd = new SponsorDao();
   	    try {
			sd.createSSQueue(title, artist, "no", desc);
		} catch (PendingRequestException e) {
			e.printStackTrace();
		}
   	    
   	    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/RequestStatus.jsp");
		dispatcher2.forward(request, response);
	}

}
