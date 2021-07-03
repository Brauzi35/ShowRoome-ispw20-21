package logic.appcontroller;

import java.util.ArrayList;
import java.util.List;


import logic.bean.ReviewBean;
import logic.dao.ArtistDao;
import logic.dao.ReviewDao;
import logic.entity.Artist;
import logic.entity.Review;
import logic.exceptions.DuplicateReviewException;
import logic.utils.SessionUser;

public class ReviewController {
	
	public List<ReviewBean> getReviews(String username) {
		List<ReviewBean> lrb = new ArrayList<>();
		ArtistDao ad = new ArtistDao();
		Artist a = ad.getArtist(username);
		ReviewDao rd = new ReviewDao();
		List<Review> lr = rd.getReview(a.getUsername());
		
		if(lr==null) {
			//if there are no reviews referred to the artist
			return lrb;
		}
		
		for(int i = 0; i < lr.size(); i++) {
			ReviewBean x = new ReviewBean();
			Review review = lr.get(i);
			x.setArtist(review.getArtist());
			x.setAuthor(review.getAuthor());
			x.setReview(review.getReview());
			lrb.add(x);//building reviewBean list
		}
		return lrb;
	}
	
	public void saveReview(String artist, String review) throws DuplicateReviewException {
		SessionUser user = SessionUser.getInstance();
		//get the string "author" from the singleton class
		ArtistDao ad = new ArtistDao();
		Artist a = ad.getArtist(artist);
		//these 2 lines check if the artist exist in the database
		ReviewDao rd = new ReviewDao();
		rd.submitReview(user.getUsername(), a.getUsername(), review);
	}
}
