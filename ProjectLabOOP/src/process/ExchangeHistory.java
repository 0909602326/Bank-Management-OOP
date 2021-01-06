package process;

import java.util.ArrayList;

public class ExchangeHistory {
	private ArrayList<Exchange> list;
	
	public ExchangeHistory() {
		super();
		list = new ArrayList<Exchange>();
	}

	public ArrayList<Exchange> getList() {
		return list;
	}
	
	public void addEvent(Exchange ex) {
		list.add(ex);
	}
}
