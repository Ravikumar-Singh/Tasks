package com.task.allocation.exceptionhandling;

import java.util.Date;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseBody
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(TaskException.class)
	public ResponseEntity<ErrorMessage> exception(TaskException ex,WebRequest request) {
		
		
		ErrorMessage message = new ErrorMessage(
		        HttpStatus.NOT_FOUND.value(),
		        new Date(),
		        ex.getMessage(),
		        request.getDescription(false));
		String exception="";
		for(StackTraceElement elm:ex.getStackTrace())
		{
			exception=exception+elm.getClassName()+":- line"+elm.getLineNumber()+",";
		}
		message.setObj(exception);
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionhandling(TaskException ex,WebRequest request) {
		
		
		ErrorMessage message = new ErrorMessage(
		        HttpStatus.NOT_FOUND.value(),
		        new Date(),
		        ex.getMessage(),
		        request.getDescription(false));
		String exception="";
		for(StackTraceElement elm:ex.getStackTrace())
		{
			exception=exception+elm.getClassName()+":- line"+elm.getLineNumber()+",";
		}
		message.setObj(exception);
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}
}
