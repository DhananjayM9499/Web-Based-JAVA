package org.fi.shopping.cart;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletContext;


public class CartFactory 
{
public static Cart getInstance(ServletContext application)
{
	try {
		String className = application.getInitParameter("cartClass");
		Class refClass = Class.forName(className);
		Constructor defaultConstructor = refClass.getConstructor(null);
		return
				(Cart)defaultConstructor.newInstance(null);
	}catch(ClassNotFoundException e ) {
		e.printStackTrace();
	}catch(NoSuchMethodException e) {
		e.printStackTrace();
	}catch(SecurityException e) {
		e.printStackTrace();
	}catch(InstantiationException e ) {
		e.printStackTrace();
	}catch(IllegalAccessException e) {
		e.printStackTrace();
	}catch(IllegalArgumentException e) {
		e.printStackTrace();
	}catch(InvocationTargetException e ) {
		e.printStackTrace();
	}
	return null;
}
}
