package process;

import java.util.ArrayList;

public class ListOfAdmin {
	private ArrayList<Admin> list;

	public ListOfAdmin() {
		list = new ArrayList<Admin>();
	}
	public void addAdmin(Admin ad) {
		list.add(ad);
	}
	public void removeAdmin(int index) {
		list.remove(index);
	}
	public ArrayList<Admin> getList() {
		return list;
	}
	
	
}
