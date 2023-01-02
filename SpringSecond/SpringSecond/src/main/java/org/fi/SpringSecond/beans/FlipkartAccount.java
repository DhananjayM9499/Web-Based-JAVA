package org.fi.SpringSecond.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlipkartAccount implements Account {

	@Autowired
	Users objuser;

	@Override
	public Users getUserInfo() {
		// TODO Auto-generated method
		return objuser;
	}

	@Override
	public void activateAccount() {

	}

	@Override
	public float subscriptionFees() {
		// TODO Auto-generated method stub
		return 1111;
	}

	@Override
	public String toString() {
		return "FlipkartAccount [objuser=" + objuser + "]";
	}

}
