package logic.utils;

import java.io.IOException;

import logic.exceptions.DescTooLongExceptionView;
import logic.exceptions.DuplicateReviewExceptionView;
import logic.exceptions.EmptyFieldView;
import logic.exceptions.ExceptionView;
import logic.exceptions.PendingRequestExceptionView;

public class ExceptionFactory {
	//***Singleton***/
		private static ExceptionFactory instance = null;
		private ExceptionFactory() {}
		
		public static synchronized ExceptionFactory getInstance() {
			if(instance == null) {
				instance = new ExceptionFactory();
			}
			return instance;
		}
		
		public ExceptionView createView(TypeException ex) throws IOException{
			
			switch(ex.getType()) {   
			case 0:
				return new DescTooLongExceptionView(ex);
			case 1: 
				return new DuplicateReviewExceptionView(ex);
			case 2: 
				return new EmptyFieldView(ex);
			case 3:
				return new PendingRequestExceptionView(ex);
			
			
			default:
				return new DescTooLongExceptionView(ex);
			}
		}
	}

