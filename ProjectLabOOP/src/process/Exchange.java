package process;

import java.time.LocalDate;

public class Exchange {
	private String date;
	private String category;
	private double money;
	private String receiver;
	
	public Exchange(String date, String category, double money2, String receiver) {
		this.date = date;
		this.category = category;
		money = money2;
		this.receiver = receiver;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	
}
