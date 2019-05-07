package dev.collegue.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentaireInvalideException extends RuntimeException {

	private static final long serialVersionUID = 5121426618734046273L;

	private static final Logger LOGGER = LoggerFactory.getLogger(CommentaireInvalideException.class);

	public static String message;

	public CommentaireInvalideException(String msg) {

		message = msg;
		LOGGER.error(msg);

	}

}
