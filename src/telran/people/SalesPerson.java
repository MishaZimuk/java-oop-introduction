package telran.people;

public class SalesPerson extends Employee {
	private int sales;
	private int percentPay;
	private static int minPercentPay = 0;
	private static int maxPercentPay = 100;

	public SalesPerson(long id, int birthYear, String email, int basicSalary, int sales, int percentPay) {
		super(id, birthYear, email, basicSalary);
		setSales(sales);
		setPercentPay(percentPay);
	}
	public static int getMinPercentPay() {
		return minPercentPay;
	}


	public static void setMinPercentPay(int minPercentPay) {
		SalesPerson.minPercentPay = minPercentPay;
	}
	
	public static int getMaxPercentPay() {
		return maxPercentPay;
	}


	public static void setMaxPercentPay(int maxPercentPay) {
		SalesPerson.maxPercentPay = maxPercentPay;
	}
	

	public void setSales(int sales) {
		this.sales = sales;
	}

	public void setPercentPay(int percentPay) {
		//TODO
		// check percent value  according to possible percent value
		if (percentPay < minPercentPay || percentPay > maxPercentPay) {
			throw new IllegalArgumentException(String.format("%d - wrong percent pay, "
					+ "should be in range [%d - %d]", percentPay,
					minPercentPay, maxPercentPay));
		}
		this.percentPay = percentPay;
	}

	@Override
	public int computePay() {
		return super.computePay() + sales * percentPay / 100;
	}

}