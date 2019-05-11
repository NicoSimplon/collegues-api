package dev.collegue.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PasswordModifException extends RuntimeException {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentaireInvalideException.class);

	public static String message;

	public PasswordModifException(String msg) {

		message = msg;
		LOGGER.error(msg);

	}

}
