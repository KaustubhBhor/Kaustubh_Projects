package DataStorePackage;

public class TestDataStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataStore.put("Firstname", "Kaustubh");
		
		System.out.println(DataStore.get("Firstname"));
	}

}
