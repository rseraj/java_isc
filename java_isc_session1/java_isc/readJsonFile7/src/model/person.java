package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class person {
	
	@JsonProperty("namee")
	private String name;
	
	@JsonProperty("ages")
	private int age;
	
	//@JsonIgnore
	private String email;
	
	@JsonProperty("pesontype")
	private Description type;
	
	public person(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Description getType() {
		return type;
	}

	public void setType(Description type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "person [name=" + name + ", age=" + age + ", email=" + email + ", type=" + type + "]";
	}

	
}
