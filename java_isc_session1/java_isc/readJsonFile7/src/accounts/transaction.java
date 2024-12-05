package accounts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class transaction {
	
	@JsonProperty("to")
	private String to;
	
	@JsonProperty("amount")
	private int amount;
	
	@JsonProperty("descrontion")
	private String descrontion;

	
	public transaction(String to, int amount, String descrontion) {
		super();
		this.to = to;
		this.amount = amount;
		this.descrontion = descrontion;
	}
	public transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getdescrontion() {
		return descrontion;
	}
	public void setdescrontion(String descrontion) {
		this.descrontion = descrontion;
	}
	@Override
	public String toString() {
		return "transaction [to=" + to + ", amount=" + amount + ", date=" + descrontion + "]";
	}
}