package telran.people.test;

import java.util.function.Predicate;

import telran.people.Employee;
import telran.people.SalesPerson;
import telran.people.WageEmployee;

public class WageEmployeePredicate implements Predicate<Employee> {
	
	@Override
	public boolean test(Employee t) {
		
		return t instanceof WageEmployee;
	}

}
