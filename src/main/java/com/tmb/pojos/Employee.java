package com.tmb.pojos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder(setterPrefix = "set")
@Getter
public class Employee {
	
	private int id;
	private String firstname;
	private String lastname;
	
}
