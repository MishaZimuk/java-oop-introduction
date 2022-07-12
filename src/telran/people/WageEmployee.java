package telran.people;

public class WageEmployee extends Employee {
private int wage;
private int hours;
public WageEmployee(long id, int birthYear, String email, int basicSalary, int wage, int hours) {
	super(id, birthYear, email, basicSalary);
	setWage(wage);
	setHours(hours);
}
public void setWage(int wage) {
	if(wage<0) {
		wage = -wage;
	}
	this.wage = wage;
}
public void setHours(int hours) {
	if(hours<0) {
		hours = -hours;
	}
	this.hours = hours;
}
@Override
public int computePay() {
	return super.computePay() +this.wage*this.hours;
}
}
