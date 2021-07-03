package logic.web.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.appcontroller.HomepageArtistController;
import logic.appcontroller.HomepageSponsorController;
import logic.utils.SessionArtist;
import logic.utils.SessionSponsor;
import logic.utils.SessionUser;
  

@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Homepage() {
        super();
      
    	
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionArtist sa = SessionArtist.getInstance();
		SessionUser su = SessionUser.getInstance();
		if (sa.getUsername()!=null){
			HomepageArtistController hac = new HomepageArtistController();
			hac.dismissLiveShow();
			//dynamic button hiding
			HttpSession session = request.getSession();
			session.setAttribute("Hosting", "noshow");
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/HomepageArtists.jsp");
			dispatcher2.forward(request, response);
		    }
		if (su.getId()==3){
			//sponsor
			HomepageSponsorController hsc = new HomepageSponsorController();
			hsc.delete();
			//dynamic button hiding
			HttpSession session = request.getSession();
			session.setAttribute("HostingSponsor", "noshow");
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/Homepagesponsor.jsp");
			dispatcher2.forward(request, response);
		    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionArtist sa = SessionArtist.getInstance();
		SessionSponsor ss = SessionSponsor.getInstance();
		
	    if (sa.getUsername()!=null){
	    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/HomepageArtists.jsp");
		dispatcher2.forward(request, response);
	    }
	    if (ss.getUsername()!=null){
		    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/Homepagesponsor.jsp");
			dispatcher3.forward(request, response); 
	    }
	    else{
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/HomepageUsers.jsp");
	    dispatcher1.forward(request, response);
		}
	}
	}

