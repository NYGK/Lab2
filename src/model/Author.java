package model;

public class Author {
	private String aaa;
	private String AuthorID;
	private String Name;
	private String Age;
	private String Country;
	public String getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public boolean equals(Author th)
	{
		if(this.AuthorID.equals(th.AuthorID) & this.Age.equals(th.Age)& this.Country.equals(th.Country)&this.Name.equals(th.Name))
			return true;
		else
			return false;
	}
	
	
}
