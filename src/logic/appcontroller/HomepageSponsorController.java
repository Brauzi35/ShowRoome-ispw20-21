package logic.appcontroller;

import logic.dao.SponsoredShowDao;

public class HomepageSponsorController {
	
	public void delete() {
		SponsoredShowDao ssd = new SponsoredShowDao();
		ssd.dismissShow();
	}
		
	
}
