package database;

import java.util.ArrayList;

import model.Confectionary;

public class DatabaseManager {
	public static DatabaseManager INSTANCE;
	
	ArrayList<Confectionary> db = new ArrayList<Confectionary>();
	
	public static DatabaseManager getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new DatabaseManager();
			
			return INSTANCE;
		}
		return INSTANCE;
		
	}
	
	public void addConfectionary(Confectionary confectionary) {
		db.add(confectionary);
		
	}
	
	public ArrayList<Confectionary> getAllConfectionary(){
		return (ArrayList<Confectionary>) db.clone();
	}
	
	public DatabaseManager() {
		// TODO Auto-generated constructor stub
	}

}
