package process;

import java.util.ArrayList;

public class ListOfCustomer {
	private ArrayList<Customer> list;

	public ListOfCustomer() {
		super();
		list = new ArrayList<Customer>();
	}

	public ArrayList<Customer> getList() {
		return list;
	}
	
	public Customer getCustomerInList(int index) {
		return list.get(index);
	}

	public int numberOfCustomer() {
		return list.size();
	}
	
	public void addCustomer(Customer cts) {
		list.add(cts);
	}
	
	public void removeCustomer(int index) {
		list.remove(index);
	}
	
	public void toString_1() {
		for(Customer cs : list) {
			System.out.println(cs.getPIN() + " - " + cs.getFullname()+ " - " + cs.getBalance());
		}
	}
	
}
