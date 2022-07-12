package telran.people;

public class SalesPerson extends Employee {
private int sales;
private int percentPay;
public SalesPerson(long id, int birthYear, String email, int basicSalary, int sales, int percentPay) {
	super(id, birthYear, email, basicSalary);
	setSales(sales);
	setPercentPay(percentPay);
}
public void setSales(int sales) {
	if(sales<0) {
		sales = -sales;
	}
	this.sales = sales;
}
public void setPercentPay(int percentPay) {
	if(percentPay<0) {
		percentPay= -percentPay;
	}
	this.percentPay = percentPay;
}
@Override
public int computePay() {
	return super.computePay() + payForSales();
}
private int payForSales() {
	return this.sales*this.percentPay/100;
}
}
