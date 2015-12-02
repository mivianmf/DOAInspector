package com.systempath;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BuildPath {

	public static void main(String[] args) {
		
		String nomeProjeto = "ActiveAdmin";
		String caminho = "/home/mivian/workspace/DOAInspector/WebContent/resources/json/";
		
		DataVisualization data = new DataVisualization(nomeProjeto);
	
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter (caminho+""+nomeProjeto+"_json.json"));
			String json = data.getJson();
			out.write(json);
			out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
