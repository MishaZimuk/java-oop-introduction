package telran.people;

public class Person {
private long id;
private int birthYear;
private String email;
public Person(long id, int birthYear, String email) {
	this.id = id;
	this.birthYear = birthYear;
	setEmail(email);
}
public void setEmail(String email) {
	if(email.length()<1) {
		email = "without email";
	}
	this.email = email;
}
public long getId() {
	return this.id;
}
public int getBirthYear() {
	return this.birthYear;
}
public String getEmail() {
	return this.email;
}
}
