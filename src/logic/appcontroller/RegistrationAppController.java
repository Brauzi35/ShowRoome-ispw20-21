package logic.appcontroller;

import logic.dao.ArtistDao;
import logic.dao.GeneralUserDao;
import logic.exceptions.DuplicateUsernameException;

public class RegistrationAppController {
	
	GeneralUserDao gud = new GeneralUserDao();
	ArtistDao ad = new ArtistDao();
	
	public void artistReg(String username, String password, String email, String description, String talent) {
		ad.registerArtist(username, password, email, description, talent);
	}
	
	public void userReg(String username, String password) throws DuplicateUsernameException {
		gud.register(this.newUserId(), username, password);
	}
	
	public void sponsorReg(String username, String password, String activity, String capacity, String description) {
		//void for now
	}
	
	public int newUserId() {
		return gud.getMaxId() + 1;
	}
}
