package model;

public class Viewer implements Comparable<Viewer>{
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthDay;
	private Viewer left;
	private Viewer right;
	
	public Viewer(String id, String firstName, String lastName, String email, String gender, String country,
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

	public Viewer getLeft() {
		return left;
	}

	public void setLeft(Viewer left) {
		this.left = left;
	}

	public Viewer getRight() {
		return right;
	}

	public void setRight(Viewer right) {
		this.right = right;
	}
	
	public void addViewer(Viewer v) {
		if(compareTo(v) > 0) {
			if(left == null) {
				left = v;
			}
			else {
				left.addViewer(v);
			}
		}
		else if(compareTo(v) < 0) {
			if(right == null) {
				right = v;
			}
			else {
				right.addViewer(v);
			}
		}
	}

	@Override
	public int compareTo(Viewer o) {
		return id.compareTo(o.id);
	}
	
	public Viewer findViewer(String idViewer) {
		if(id.compareTo(idViewer) == 0) {
			return this;
		}
		else if(id.compareTo(idViewer) > 0) {
			return left.findViewer(idViewer);
		}
		return right.findViewer(idViewer);
	}

	@Override
	public String toString() {
		return id + "," + firstName + "," + lastName + "," + email
				+ "," + gender + "," + country + "," + photo + "," + birthDay;
	}
	
	public String findCountry(String theCountry) {
		String msg = "";
		if(country.equals(theCountry)) {
			msg += toString()+"\n";
			msg += "|_________";
			if(left != null && left.country.equals(theCountry)) {
				msg += left.toString();
			}
			msg += "\n";
			msg += "|_________";
			if(right != null && right.country.equals(theCountry)) {
				msg += right.toString();
			}
			msg += "\n";
		}
		if(left != null) {
			msg += left.findCountry(theCountry);
		}
		if(right != null) {
			msg += right.findCountry(theCountry);
		}
		return msg;
	}
}
