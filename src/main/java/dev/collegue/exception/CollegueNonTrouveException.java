package dev.collegue.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollegueNonTrouveException extends RuntimeException {

	private static final long serialVersionUID = 6918457547023278924L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CollegueNonTrouveException.class);
	
	public CollegueNonTrouveException() {
		
	}
	
	public CollegueNonTrouveException(String msg) {
		
		LOGGER.error(msg);
		
	}

}
