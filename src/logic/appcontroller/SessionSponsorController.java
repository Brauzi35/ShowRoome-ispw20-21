package logic.appcontroller;


import logic.dao.SponsorDao;

import logic.entity.Sponsor;

import logic.utils.SessionSponsor;
import logic.utils.SessionUser;

public class SessionSponsorController {
	public void sessionSponsorSetup() {
		SessionSponsor instanceS = SessionSponsor.getInstance();
		SessionUser instanceU = SessionUser.getInstance();
		//ci va uno sponsor dao qui
		SponsorDao sd = new SponsorDao();
		Sponsor s = sd.getSponsor(instanceU.getUsername()); //uso l'entity, chiedere se è corretto altrimenti tradurre in bean
		instanceS.setUsername(s.getUsername());
		instanceS.setDescription(s.getDescription());
		instanceS.setCapacity(s.getCapacity());
		instanceS.setPassword(s.getPassword());
		instanceS.setActivity(s.getActivity());
	}
}
