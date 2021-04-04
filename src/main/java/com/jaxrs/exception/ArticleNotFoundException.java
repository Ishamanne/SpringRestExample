package com.jaxrs.exception;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Not Found") 
public class ArticleNotFoundException extends Exception{
	private static final long serialVersionUID = -3332292346834265371L;

	public ArticleNotFoundException(int id){
		super("ArticleNotFoundException with id="+id);
	}

}
