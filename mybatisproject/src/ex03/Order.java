package ex03;

import java.util.Date;
import java.util.List;

public class Order {
	public List<OrderLine> ordered;
	Customer customer;

	private Date dateReceived;
	private boolean isPrepaid;
	private String number;
	private Money price;

	public void close() {

	}

	public void dispatch() {
	}

}
