package entities;

import java.text.ParseException;
import java.util.Date;

public class Installment {
	
	private Date date;
	private Double value;
	
	public Installment() {
	}

	public Installment(Date date, Double value) throws ParseException {
		this.date = date;
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}
