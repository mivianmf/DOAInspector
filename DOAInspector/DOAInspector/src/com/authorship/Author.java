package com.authorship;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Author {

	private String nameAuthor;
	private ArrayList<DOA> filesOwner; 

	public Author(String nameAuthor) {
		this.nameAuthor = nameAuthor;
		filesOwner = new ArrayList<DOA>();
	}

	public void AddDoa(String fileName, Double doa) {
		this.filesOwner.add(new DOA(fileName, doa));
	}

	public ArrayList<DOA> getFilesOwner() {
		return filesOwner;
	}

	public String getNameAuthor() {
		return nameAuthor;
	}

	
	public int getWeight(){
		int weight = 0;
		
		for (DOA doa : filesOwner) {
			weight+= doa.getDoa();
		}
		
		return weight;
	}
	

	public String getJson(){

		String jsonDOA = "";

		if (this.filesOwner.size() > 0){
			jsonDOA = this.filesOwner.get(0).getJson();
			for (int i = 1; i < this.filesOwner.size(); i++) {
				jsonDOA +=","+filesOwner.get(i).getJson();
			}
		}
		return "{ \"name\": \""+this.nameAuthor+"\", \"children\":[" +jsonDOA+ "] }";
	}
}


