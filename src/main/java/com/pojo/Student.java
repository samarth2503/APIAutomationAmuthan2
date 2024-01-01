package com.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder(setterPrefix = "set",buildMethodName = "build")
public class Student {
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	
	public static StudentBuilder1 builder()
	{
		return new StudentBuilder1();
	}
	
	public static class StudentBuilder1{
		
		private int id;
		private String firstname;
		private String lastname;
		private String email;
		
		public Student build()
		{
			return new Student(this.id,this.firstname,this.lastname,this.email);
		}
		
		public StudentBuilder1 setId(int id) {
			this.id = id;
			return this;
		}

		public StudentBuilder1 setFirstname(String firstname) {
			this.firstname = firstname;
			return this;
		}

		public StudentBuilder1 setLastname(String lastname) {
			this.lastname = lastname;
			return this;
		}

		public StudentBuilder1 setEmail(String email) {
			this.email = email;
			return this;
		}
		
	}

}
