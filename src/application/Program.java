package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int taxPayers = sc.nextInt();
		
		for(int i=1; i<=taxPayers; i++) {
			System.out.println();
			System.out.println("Tax payer #" + i + " data:");
			
			System.out.print("Individual or company (i/c)? ");
			char typeAcconut = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Anual Income: ");
			double anualIncome = sc.nextDouble();
			
			if(typeAcconut == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else if(typeAcconut == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmplyee = sc.nextInt();
				
				list.add(new Company(name, anualIncome, numberOfEmplyee));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		Double totalTax = 0.0;
		for(TaxPayer acc : list) {
			System.out.println(acc.getName() + ": $ " + String.format("%.2f", acc.tax()));
			totalTax += acc.tax();
		}
		System.out.println();
		System.out.println("Total Taxes: $ " + totalTax);
		sc.close();

	}

}
