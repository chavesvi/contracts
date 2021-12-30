package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		String d = sc.next();
		Date date = sdf.parse(d);
		System.out.print("Contract value: ");
		double value = sc.nextDouble();
		Contract c = new Contract(number, date, value);
		
		System.out.print("Enter number of installments: ");
		int quantity = sc.nextInt();
		c.installments(quantity, true);
		
		System.out.println("Installments:");
		System.out.println(c);
		
		sc.close();

	}

}
