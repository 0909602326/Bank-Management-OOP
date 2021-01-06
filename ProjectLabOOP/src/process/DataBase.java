package process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataBase {
	public DataBase() {

	}

	public ListOfAdmin readAdmin(String part) throws Exception {
		ListOfAdmin l = new ListOfAdmin();
		File f = new File(part);
		if (f.exists()) {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				String line = s.nextLine();
				String[] data = line.split(",");
				Admin ad = new Admin(data[0], data[1], data[2], data[3], data[4]);
				l.addAdmin(ad);
			}
			s.close();
		} else {
			f.createNewFile();
		}
		return l;
	}
	
	public void writeAdmin(String part, ListOfAdmin list) throws Exception {
		try (PrintWriter out = new PrintWriter(new FileOutputStream(part), true)) {
			for (Admin ad : list.getList()) {
				String data = ad.getPIN() + "," + ad.getFullname() +"," + ad.getPhonenumber() + "," + ad.getID() + "," + ad.getPassword();
				out.println(data);
			}
		}
	}

	public ListOfCustomer readCustomer(String part) throws Exception {
		ListOfCustomer l = new ListOfCustomer();
		File f = new File(part);
		if (f.exists()) {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				String line = s.nextLine();
				String[] data = line.split(",");
				Customer cs = new Customer(data[0], data[1], data[2], data[3], data[4], Double.parseDouble(data[5]));
				l.addCustomer(cs);
			}
			s.close();
		} else {
			f.createNewFile();
		}
		return l;
	}

	public ExchangeHistory readHistory(String part) throws Exception {
		ExchangeHistory h = new ExchangeHistory();
		File f = new File(part);
		if (f.exists()) {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				String line = s.nextLine();
				String[] data = line.split(",");
				Exchange ex = new Exchange(data[0], data[1], Double.parseDouble(data[2]), data[3]);
				h.addEvent(ex);
			}
			s.close();
		} else {
			f.createNewFile();
		}
		return h;
	}

	public void writeEvent(String part, ExchangeHistory h) throws Exception {
		try (PrintWriter out = new PrintWriter(new FileOutputStream(part), true)) {
			for (Exchange ex : h.getList()) {
				String data = ex.getDate() + "," + ex.getCategory() + "," + ex.getMoney() + "," + ex.getReceiver();
				out.println(data);
			}
		}
	}

	public void writeCustomer(String part, ListOfCustomer list) throws Exception {
		try (PrintWriter out = new PrintWriter(new FileOutputStream(part), true)) {
			for (Customer cs : list.getList()) {
				String data = cs.getPIN() + "," + cs.getFullname() + "," + cs.getPhonenumber() + "," + cs.getID() + ","
						+ cs.getPassword() + "," + cs.getBalance();
				out.println(data);
			}
		}
	}
}
