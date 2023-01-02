package org.fi.SpringSecond.beans;



import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Component;

@Component 
public class AmazonAccount implements Account{
@Autowired // ByType 
Users objUser;

@Override

public Users getUserInfo() { 
	// TODO Auto-generated method stub 
	return objUser;

}

@Override
public void activateAccount() {
// TODO Auto-generated method stub 
System.out.println("Account Activated");
}

@Override 
public float subscriptionFees () { 
	// TODO Auto-generated method stub 
	return 5000;
}

@Override 
public String toString() { 
	return "AmazonAccount [objuser=" + objUser +

"]"; }

}

