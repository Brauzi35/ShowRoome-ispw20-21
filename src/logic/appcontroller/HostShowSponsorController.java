package logic.appcontroller;

import java.util.ArrayList;
import java.util.List;

import logic.dao.ArtistDao;
import logic.dao.SponsorDao;
import logic.entity.Artist;
import logic.entity.Sponsor;
import logic.utils.SessionSponsor;

public class HostShowSponsorController {
	public List<String> buildArtistStringArray(){
		//this method builds the array needed for a listView gathering each free artist that can be contcted
		List<String> artists = new ArrayList<>();
		ArtistDao ad = new ArtistDao();
		List<Artist> la = ad.getArtists();
		for(int i = 0; i < la.size(); i++) {
			String x = la.get(i).getUsername();
			artists.add(x);//building reviewBean list
		}
		
		return artists;
	}
	
	public String getDescription(String artist){
		String description;
		ArtistDao ad = new ArtistDao();
		description = ad.getArtist(artist).getDescription();
		return description;
		
	}
	
	public List<String> buildSponsorStringArray(){
		//this method provides a string array which contains every sponsor username except for the sessionSponsor's one
		List<String> sponsors = new ArrayList<>();
		SponsorDao sd = new SponsorDao();
		List<Sponsor> la = sd.getSponsors();
		for(int i = 0; i < la.size(); i++) {
			String x = la.get(i).getUsername();
			sponsors.add(x);//building reviewBean list
		}
		//given the full list now the sessionSponsor username has to be removed
		SessionSponsor instance = SessionSponsor.getInstance();
		sponsors.remove(instance.getUsername());
		
		return sponsors;
		
	}
}
