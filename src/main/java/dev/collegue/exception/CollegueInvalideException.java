package dev.collegue.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollegueInvalideException extends RuntimeException {

	private static final long serialVersionUID = 7915732452686261175L;

	private static final Logger LOGGER = LoggerFactory.getLogger(CollegueInvalideException.class);
	
	public static String message;

	public CollegueInvalideException(String msg) {
		
		message = msg;
		LOGGER.error(msg);

	}

	public CollegueInvalideException(Exception e) {

		LOGGER.error(e.getMessage());

	}

}
