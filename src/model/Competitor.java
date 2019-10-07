package model;

public class Competitor {
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthDay;
	private Competitor next;
	private Competitor previous;
	
	public Competitor(String id, String firstName, String lastName, String email, String gender, String country,
			String photo, String birthDay) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthDay = birthDay;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public Competitor getNext() {
		return next;
	}

	public void setNext(Competitor next) {
		this.next = next;
	}

	public Competitor getPrevious() {
		return previous;
	}

	public void setPrevious(Competitor previous) {
		this.previous = previous;
	}
	
	@Override
	public String toString() {
		return id + "," + firstName + "," + lastName + "," + email
				+ "," + gender + "," + country + "," + photo + "," + birthDay;
	}
	
	public void addCompetitor(Competitor c) {
		c.setNext(this);
		setPrevious(c);
	}
	
	public Competitor findCompetitor(String idCompetitor) {
		if(id.compareTo(idCompetitor) != 0 && next != null) {
			return next.findCompetitor(idCompetitor);
		}
		if(id.compareTo(idCompetitor) != 0) {
			return null;
		}
		return this;
	}
}
