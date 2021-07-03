package logic.appcontroller;

import java.util.ArrayList;
import java.util.List;

import logic.bean.SponsoredShowBean;

import logic.dao.SponsoredShowDao;

import logic.entity.SponsoredShow;

public class SSUserController {
	//ss stands for SponsoredShow
	public List<String> buildShowStringArray(){
		//this method builds the array needed for a listView gathering each free artist that can be contcted
		List<String> shows = new ArrayList<>();
		SponsoredShowDao ssd = new SponsoredShowDao();
		List<SponsoredShow> ls = ssd.getSponsoredShows();
		for(int i = 0; i < ls.size(); i++) {
			String x = ls.get(i).getTitle();
			shows.add(x);
		}
		
		return shows;
	}
	
	public SponsoredShowBean getSponsoredShow(String title) {
		SponsoredShowDao ssd = new SponsoredShowDao();
		SponsoredShow ss = ssd.getSponsoredShow(title);
		SponsoredShowBean ssb = new SponsoredShowBean();
		
		//traslating entity in bean
		ssb.setTitle(ss.getTitle());
		ssb.setArtist(ss.getArtist());
		ssb.setCapacity(ss.getCapacity());
		ssb.setLocation(ss.getLocation());
		ssb.setDescription(ss.getDescription());
		ssb.setSponsor(ss.getSponsor());
		ssb.setPartner(ss.getPartner());
		
		return ssb;		
		
	}
	
}
