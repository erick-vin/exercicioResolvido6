package entities;

public class Individual extends TaxPayer{
	
	private Double healthExpenditures;
	
	public Individual() {
	}
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}
	
	public Double getHealthExpenditures() {
		return healthExpenditures;
	}
	
	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {
		double totalTax;
		if (getAnualIncome() < 2000) {
			totalTax = (getAnualIncome() * 0.15) - (healthExpenditures * 0.5); 
		}
		else {
			totalTax = (getAnualIncome() * 0.25) - (healthExpenditures * 0.5);
		}
		return totalTax;
	}
}
