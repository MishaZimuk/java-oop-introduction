package telran.people;

public class Person implements Comparable<Person>{
	private long id;
	private int birthYear;
	private String email;
	
	public Person(long id, int birthYear, String email) {
		this.id = id;
		this.birthYear = birthYear;
		setEmail(email);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		//TODO check email with possible IllegalArgumentException throwing
		//Regex simplified <first part>@<second part>
		// <first part> - letter, digit, dot, dash
		//second part - letter, dot
		if (!(email.split("@")[0].matches("(\\w|\\.|-)+")) || !(email.split("@")[1].matches("[A-Za-z.-]+"))) {
			throw new IllegalArgumentException(String.format("%s - wrong email, "
					+ "should be string@string", email));
		}
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public int getBirthYear() {
		return birthYear;
	}
	@Override
	public int compareTo(Person o) {
		
		return Long.compare(this.id, o.id);
	}
	
	

}