package dev.collegue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value = { CollegueNonTrouveException.class })
	protected ResponseEntity<Object> handleConflictCollegueNotFound(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Collegue non trouvé";
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyOfResponse);
	 }
	
	@ExceptionHandler(value = { CollegueInvalideException.class })
	protected ResponseEntity<Object> handleConflictCollegueInvalid(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Collègue invalide: " + CollegueInvalideException.message;
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bodyOfResponse);
	 }
	
}
