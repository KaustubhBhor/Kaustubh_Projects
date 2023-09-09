package DataStorePackage;

import java.util.HashMap;
import java.util.Map;

public class DataStore {

	private static Map<String, Object> context = new HashMap<String, Object>();
	
	private static String KeyNameSeperator = "##";
	
	public static void put(String Key, Object Value) {
		context.put(Thread.currentThread().getName() +KeyNameSeperator+ Key, Value);
		System.out.println("Thread safe Key is : "+Thread.currentThread().getName() +KeyNameSeperator+ Key);
	}
	
	public static Object get(String Key) {
		return context.get(Thread.currentThread().getName() +KeyNameSeperator+ Key);
	}
}
