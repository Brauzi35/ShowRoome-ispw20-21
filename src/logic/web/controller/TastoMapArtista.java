package logic.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.appcontroller.HomepageArtistController;
import logic.appcontroller.MapController;
import logic.bean.EventBean;
import logic.bean.PlaceBean;
import logic.exceptions.DescriptionTooLongException;
import logic.exceptions.EmptyFieldException;
import logic.utils.SessionArtist;
import logic.utils.SessionSponsor;


@WebServlet("/TastoMapArtista")
public class TastoMapArtista extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int ringbell=0;
    String mapartistjsp = "/WEB-INF/views/MapArtist.jsp";
    String book= "already booked";
    
    public TastoMapArtista() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("text1");
		String desc = request.getParameter("text2");
		String place = request.getParameter("plc");
		String control = request.getParameter("plc6");
		if (control==null) {
		String value = request.getParameter("action");
		MapController mc = new MapController();
		List<PlaceBean> freePlaces = mc.freePlaces();
		
		HttpSession session = request.getSession();
		
		for(int i=0; i<freePlaces.size(); i++) {
        	if(freePlaces.get(i).getName().equals(value)) {
        		session.setAttribute("Posto", freePlaces.get(i).getName());
        		session.setAttribute("Indirizzo", freePlaces.get(i).getAddress());
        		session.setAttribute("Capienza", freePlaces.get(i).getCapacity());
        		ringbell = 1;
        	}
        }
		
		if(ringbell==0) {
			session.setAttribute("Posto", book);
    		session.setAttribute("Indirizzo", book);
    		session.setAttribute("Capienza", 0);
		}
		ringbell=0;
		RequestDispatcher dispatcherN = request.getRequestDispatcher( mapartistjsp);
    	dispatcherN.forward(request, response);
	}
		
		else {
			MapController mc = new MapController();
			try {
				
					mc.submitEvent(name, place, desc);
				} catch (DescriptionTooLongException e) {
					
					e.printStackTrace();
				}
			 catch (EmptyFieldException e) {
				e.printStackTrace();
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("Hosting", name);
			RequestDispatcher dispatcherN = request.getRequestDispatcher( mapartistjsp);
	    	dispatcherN.forward(request, response);
	    	
		}
	}
	

}
