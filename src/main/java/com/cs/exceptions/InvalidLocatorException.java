package com.cs.exceptions;

@SuppressWarnings("serial")
public class InvalidLocatorException extends FrameworkException{

		public InvalidLocatorException(String message)
		{
			super(message);
		}
		public InvalidLocatorException(String message, Throwable cause)
		{
			super(message, cause);
		}
}
