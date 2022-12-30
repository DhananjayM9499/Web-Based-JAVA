package org.fi.shopping.cart;

import java.util.ArrayList;
import java.util.Iterator;
import org.fi.shopping.pojo.CartItem;

public class ShoppingCart implements Cart {
	ArrayList<CartItem> cartItems = new ArrayList<>();// Type inference

	@Override
	public void addCart(CartItem item) {
		if (item==null)
			throw new CartException("Invalid details");
		cartItems.add(item);
	}

	@Override
	public void removeCart(CartItem item) {
		cartItems.remove(item);
	}

	@Override
	public Iterator<CartItem> getAllItems() {
		if (!cartItems.isEmpty())
			return cartItems.iterator();
		else
			throw new CartException("No products in the cart");

	}

}
