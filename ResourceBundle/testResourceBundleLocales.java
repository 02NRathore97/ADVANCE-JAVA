package in.com.raystec.ResourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class testResourceBundleLocales {
public static void main(String[] args) {
	ResourceBundle rb = ResourceBundle.getBundle("in.com.raystec.ResourceBundle.app", new Locale("hi"));
	ResourceBundle rb1 = ResourceBundle.getBundle("in.com.raystec.ResourceBundle.app", new Locale("hi","IN","GJ"));
	System.out.println(rb.getString("greet"));
	System.out.println(rb1.getString("greet"));

}
}
