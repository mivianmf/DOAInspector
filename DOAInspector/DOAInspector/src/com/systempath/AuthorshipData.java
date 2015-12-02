package com.systempath;

public class AuthorshipData {

	private String name;
	private Integer doa;
	
	public AuthorshipData(String name, Integer doa) {
		super();
		this.name = name;
		this.doa = doa;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getDoa() {
		return doa;
	}
		
}
