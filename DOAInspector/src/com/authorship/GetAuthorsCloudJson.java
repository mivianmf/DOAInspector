package com.authorship;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.systempath.DataVisualization;

public class GetAuthorsCloudJson {

	public static void main(String[] args) {
		
		String nomeProjeto = "ActiveAdmin";
		String caminho = "/home/mivian/workspace/DOAInspector/WebContent/resources/json/";
		
		try {
			CreateTableAuthorShip data = new CreateTableAuthorShip(nomeProjeto);
			BufferedWriter out = new BufferedWriter(new FileWriter (caminho+""+nomeProjeto+"_json_authors.json"));
			String x = data.getAuthorsJson();
			out.write(x);
			out.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
