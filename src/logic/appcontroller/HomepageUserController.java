package logic.appcontroller;

import java.util.ArrayList;
import java.util.List;

import logic.bean.ArtistBean;
import logic.bean.EventBean;
import logic.bean.PlaceBean;
import logic.dao.ArtistDao;
import logic.dao.EventDao;
import logic.dao.PlaceDao;
import logic.entity.Artist;
import logic.entity.Event;
import logic.entity.Place;

public class HomepageUserController {
	//application controller to pass an array list to the graphic controller
		//convert list<event> in list<eventBean>
		public List<EventBean> liveEventsList(){
			List<EventBean> leb = new ArrayList<>();//return value
			EventDao ed = new EventDao();
			List<Event> le = ed.getLiveEvents();
			
			for(int i = 0; i < le.size(); i++) {
				EventBean x = new EventBean();
				Event event = le.get(i);
				x.setArtist(event.getArtist());
				x.setDescription(event.getDescription());
				x.setName(event.getName());
				x.setPlace(event.getPlace());
				leb.add(x);//building eventBean list
			}
			
			return leb;
		}
		
	  public PlaceBean getPlace(String name) {
		  
		  //given a name gets the placebean
		  PlaceDao pd = new PlaceDao();
		  PlaceBean pb = new PlaceBean();
		  Place p = pd.getPlace(name);
		  
		  pb.setName(p.getName());
		  pb.setAddress(p.getAddress());
		  pb.setCapacity(p.getCapacity());
		  pb.setFree(p.isFree());
		  
		  return pb;
	  }
	  
	  public ArtistBean getArtist(String name) {
		  ArtistDao ad = new ArtistDao();
		  ArtistBean ab = new ArtistBean();
		  Artist a = ad.getArtist(name);
		  
		  ab.setUsername(name);
		  ab.setTalent(a.getTalent());
		  ab.setPassword(a.getPassword());
		  ab.setEmail(a.getEmail());
		  ab.setDescription(a.getDescription());
		  return ab;
	  }
		
}
