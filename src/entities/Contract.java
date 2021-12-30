package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import services.PayPal;
import services.PaymentService;

public class Contract {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer accountNumber;
	private Date date;
	protected Double totalValue;
	
	private List<Installment> installments = new ArrayList<>();
	private PaymentService pS = new PayPal();
	
	public Contract() {
	}

	public Contract(Integer accountNumber, Date date, Double totalValue) {
		this.accountNumber = accountNumber;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	private Date payday(int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, + month);
		return cal.getTime();
	}
	
	public double installments(int quantity, boolean check) throws ParseException {
		if (check == true) {
			for (int i=1; i<=quantity; i++) {
				installments.add(new Installment(payday(i), pS.payment(totalValue / quantity, quantity)[i - 1]));
			}
		}
		return totalValue / quantity;
	}
	
	@Override
	public String toString() {
		for (Installment x : installments) {
			System.out.println(sdf.format(x.getDate()) + " - " + String.format("%,.2f", x.getValue()));
		} 
		return "";
	}

}
