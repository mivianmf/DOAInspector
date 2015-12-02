package com.authorship;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class CreateTableAuthorShip {

	private Map<String, Author> authors;
	private String project;

	public CreateTableAuthorShip(String nameFileSystem) throws FileNotFoundException {
		this.readFile(nameFileSystem);
		this.project = nameFileSystem;
	}

	public void readFile(String nameFileSystem) throws FileNotFoundException {
		BufferedReader read = new BufferedReader(new FileReader("/home/mivian/git/DOAInspector/DOAInspector/files/" + nameFileSystem + ".txt"));
		authors = new HashMap<String, Author>();
		String[] aux = new String[4];
		String[] auxFileName;
		String fileName, authorName;
		Double doaValue;

		try {

			while (read.ready()) {
				aux = read.readLine().split(",");
				auxFileName = (aux[1].split("/"));
				fileName = auxFileName[auxFileName.length - 1];
				authorName = aux[2];
				doaValue = Double.parseDouble(aux[3]);

				this.createAuthorsMap(authorName, fileName, doaValue);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createAuthorsMap(String authorName, String fileName, Double doaValue) {
		Author author = null;

		if (!authors.containsKey(authorName)) {
			author = new Author(authorName);
			author.AddDoa(fileName, doaValue);
			authors.put(authorName, author);
		} else {
			author = authors.get(authorName);
			author.AddDoa(fileName, doaValue);
		}
	}

	public String getAuthorsJson() {
		StringBuilder jsonAuthors = new StringBuilder("[");

		Object[] authors = this.authors.values().toArray();

		for (int i = 0; i < authors.length; i++) {

			jsonAuthors.append("{text:\"" + ((Author) authors[i]).getNameAuthor() + "\", weight: "
					+ ((Author) authors[i]).getWeight() + ", link: {href: \"author_files?project=" + this.project
					+ "&author=" + (((Author) authors[i]).getNameAuthor()).replaceAll(" ", "_")
					+ "\", target: \"_parent\"}},");
		}

		jsonAuthors = jsonAuthors.deleteCharAt(jsonAuthors.length() - 1);

		jsonAuthors.append("]");

		return jsonAuthors.toString();
	}

	public ArrayList<String> getAuthorsSelectize() {

		ArrayList<String> authorsList = new ArrayList<String>();
		Object[] authors = this.authors.values().toArray();

		for (int i = 0; i < authors.length; i++) {
			authorsList.add(((Author)authors[i]).getNameAuthor());
			
		}
		return authorsList;
	}

	public Map<String, Author> getAuthors() {

		return this.authors;
	}
}
