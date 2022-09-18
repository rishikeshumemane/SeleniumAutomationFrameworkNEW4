package com.cs.exceptions;

@SuppressWarnings("serial")
public class XSSFWorkbookCreationException extends FrameworkException{

	
	public XSSFWorkbookCreationException(String message)
	{
		super(message);
	}
	
	public XSSFWorkbookCreationException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
