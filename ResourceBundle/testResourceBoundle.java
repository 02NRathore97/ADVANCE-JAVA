package in.com.raystec.ResourceBundle;

import java.util.ResourceBundle;

public class testResourceBoundle {
public static void main(String[] args) {
	ResourceBundle rb = ResourceBundle.getBundle("in.com.raystec.Resourcebundle.app");
	
	System.out.println(rb.getString("driver"));
	System.out.println(rb.getString("url"));
	System.out.println(rb.getString("user"));
	System.out.println(rb.getString("pswd"));
}
}
