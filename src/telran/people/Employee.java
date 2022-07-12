package telran.people;

public class Employee extends Person {
private int basicSalary;
public Employee(long id, int birthYear, String email, int basicSalary){
	super(id, birthYear, email);
	setBasicSalary(basicSalary);
}
public void setBasicSalary(int basicSalary) {
	if(basicSalary<0) {
		basicSalary = 0;
	}
	this.basicSalary = basicSalary;
}
public int computePay() {
	return this.basicSalary;
}
}
