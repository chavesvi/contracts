package services;

public class PayPal implements PaymentService {

	@Override
	public Double[] payment(double installment, int quantity) {
		Double[] installmentAmount = new Double[quantity];
		double installment2;
		for (int i=1; i<=quantity; i++) {
			installment2 = installment + (installment * 1 / 100) * i;
			installment2 += installment2 * 2 / 100;
			installmentAmount[i-1] = installment2; 
		}	
		return installmentAmount;
	}
	
	
}
