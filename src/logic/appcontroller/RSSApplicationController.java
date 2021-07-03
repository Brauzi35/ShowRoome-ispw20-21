package logic.appcontroller;

import logic.bean.RequestedShowBean;
import logic.dao.RequestsDao;
import logic.dao.SponsoredShowDao;
import logic.entity.RequestedShow;
import logic.entity.SponsoredShow;
import logic.exceptions.DescriptionTooLongException;

public class RSSApplicationController {
	public RequestedShowBean getPendingRequest() {
		RequestedShowBean result = new RequestedShowBean();
		RequestsDao rd = new RequestsDao();
		RequestedShow rs = rd.getQueuedShow();
		if(rs!=null) {
			result.setHost(rs.getHost());
			result.setTitle(rs.getTitle());
			result.setArtist(rs.getArtist());
			result.setPartner(rs.getPartner());
			result.setDescription(rs.getDescription());
			result.setApprovedArtist(rs.getApprovedArtist());
			result.setApprovedPartner(rs.getApprovedPartner());
			return result;
		}
		else {
			return null;
		}
	}
	
	public void hostSponsoredShow(String title, String artist, String sponsor, String location, String capacity, String partner, String description) {
		SponsoredShow ss = new SponsoredShow(title, artist, sponsor, location, capacity, partner, description);
		SponsoredShowDao ssd = new SponsoredShowDao();
		try {
			ssd.hostSponsoredShow(ss);
		} catch (DescriptionTooLongException e) {
			//implementare controllo errore
			e.printStackTrace();
		}
		this.deleteRequest();
	}
	
	public void deleteRequest() {
		RequestsDao rd = new RequestsDao();
		rd.deleteRequest();
	}
}
