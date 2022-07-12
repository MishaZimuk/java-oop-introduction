package telran.people.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.people.Employee;
import telran.people.Person;
import telran.people.SalesPerson;
import telran.people.WageEmployee;

class PersonTests {

	@Test
	void personTest() {
		long id = 342484367;
		int birthYear = 1990;
		String email = "user@gmail.com";
		Person misha = new Person(id, birthYear, email);
		assertTrue(misha.getBirthYear() == birthYear);
		assertTrue(misha.getEmail().equals(email));
		misha.setEmail("admin@gmail.com");
		assertTrue(misha.getEmail().equals("admin@gmail.com"));
	}
	@Test
	void employeeTest() {
		long id = 342484366;
		int birthYear = 1990;
		String email = "user@gmail.com";
		int basicSalary = 5300;
		Employee vasya = new Employee(id, birthYear, email, basicSalary);
		assertTrue(vasya.computePay() == basicSalary);
		assertTrue(vasya.getEmail().equals(email));
		int superMegaSalary = 5350;
		vasya.setBasicSalary(superMegaSalary);
		assertTrue(vasya.computePay() == 5350);
	}
	@Test
	void wageEmployeeTest() {
		long id = 342484365;
		int birthYear = 1990;
		String email = "user@gmail.com";
		int basicSalary = 5300;
		int wage = 30;
		int hours = 40;
		WageEmployee arkadiy = new WageEmployee(id, birthYear, email, basicSalary, wage, hours);
		assertFalse(arkadiy.computePay() == basicSalary);
		assertTrue(arkadiy.computePay() == 6500);
		int superMegaSalary = 5350;
		int wageForSpecialist = 32;
		int workaholicHours = 41;
		arkadiy.setBasicSalary(superMegaSalary);
		arkadiy.setWage(wageForSpecialist);
		arkadiy.setHours(workaholicHours);
		assertTrue(arkadiy.computePay() == superMegaSalary+wageForSpecialist*workaholicHours);
	}
	@Test
	void saleEmployeeTest() {
		long id = 342484364;
		int birthYear = 1990;
		String email = "user@gmail.com";
		int basicSalary = 5300;
		int sales = 20000;
		int percentPay = 5;
		SalesPerson igor = new SalesPerson(id, birthYear, email, basicSalary, sales, percentPay);
		assertFalse(igor.computePay() == basicSalary);
		assertTrue(igor.computePay() == basicSalary+sales*percentPay/100);
		int superMegaSalary = 5350;
		int professionalsSale = 100000;
		int percentPayForBestSalesman = 8;
		igor.setBasicSalary(superMegaSalary);
		igor.setSales(professionalsSale);
		igor.setPercentPay(percentPayForBestSalesman);
		assertTrue(igor.computePay() == superMegaSalary+professionalsSale*percentPayForBestSalesman/100);
	}
}
