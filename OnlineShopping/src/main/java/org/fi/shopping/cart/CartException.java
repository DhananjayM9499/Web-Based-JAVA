package org.fi.shopping.cart;

public class CartException extends RuntimeException {

	public CartException() {
		super();
	}
public CartException(String message,Throwable cause, boolean enableSupression,boolean writableStackTrace)
{
	super(message,cause,enableSupression,writableStackTrace);
}

public CartException(String message, Throwable cause) {
	super (message,cause);
}
public CartException(String message) {
	super(message);
	// TODO Auto-generated constructor stub
}
public CartException(Throwable cause) {
	super(cause);
	// TODO Auto-generated constructor stub
}

}
