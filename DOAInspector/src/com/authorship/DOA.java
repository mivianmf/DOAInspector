package com.authorship;

public class DOA {
	
	public String name;
	public double doa;
	
	/*
	 * O paramatro nome pode ser o nome de um arquivo ou nome de um autor
	 * O valor de doa sempre ser� referente 
	 */
	public DOA(String name, double doa) {
		this.name = name;
		this.doa = doa;
	}	
	
	public double getDoa() {
		return doa;
	}
	
	public String getName() {
		return name;
	}
	
	public String getJson(){
		return "{ \"name\":\""+this.name+"\", \"size\":"+(this.doa*1000)+"}";
	}
}
