package com.systempath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class DataVisualization {

	private String fileName;
	private Tree<AuthorshipData> tree;
	private StringBuilder project_json ;

	public DataVisualization(String fileName) {
		this.fileName = fileName;
		this.getTreePath();	
	}

	public String getJson() {
		project_json = new StringBuilder("");
		this.getJson(tree.getRoot());
		project_json = project_json.deleteCharAt(project_json.length()-1);
		return this.project_json.toString();
	}

	public void getTreePath() {

		try {

			BufferedReader read = new BufferedReader(new FileReader("/home/mivian/files/" + fileName+".txt"));
			String[] splitedLine = new String[4];
			String[] path;
			String author;
			Double DOA;
			Node<AuthorshipData> root = new Node(new AuthorshipData(fileName, -1));
			this.tree = new Tree(root);
			Node<AuthorshipData> leaf;
			Node<AuthorshipData> aux;
			AuthorshipData auxiliar;
			int i = 0;

			while (read.ready()) {

				splitedLine = read.readLine().split(",");
				path = splitedLine[1].split("/");
				author = splitedLine[2];
				DOA = Double.parseDouble(splitedLine[3]);

				root = tree.getRoot();

				i = 0;

				while (i < path.length) {

					auxiliar = new AuthorshipData(path[i], -1);
					leaf = new Node(auxiliar);
					aux = this.getChild(root, leaf);

					if (aux == null) {// inserir novo nodo na arvore
						leaf.setParent(root);
						root.addChild(leaf);
						root = leaf;

					} else {
						root = aux;
					}
					i++;
				}

				auxiliar = new AuthorshipData(author, DOA.intValue());
				leaf = new Node(auxiliar);
				leaf.setParent(root);
				root.addChild(leaf);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException io) {
			io.printStackTrace();

		}

	}

	public void printPreOrder() {

		ArrayList<Node<AuthorshipData>> lista = tree.getPreOrderTraversal();

		for (Node<AuthorshipData> node : lista) {
			System.out.println("File: " + node.getData().getName() + " DOA: "
					+ (node.getData().getDoa()));
		}

	}

	private void getJson(Node <AuthorshipData> root){
		
		ArrayList<Node<AuthorshipData>> children = (ArrayList<Node<AuthorshipData>>) root.getChildren();
		
		if(children.isEmpty()){
			project_json.append("{ \"name\":\""+root.getData().getName()+"\", \"value\":"+root.getData().getDoa()+", \"url\":\"http://dcc.ufmg.br/dcc/\"},");
		}
		else{
			project_json.append("{ \"name\":\""+root.getData().getName()+"\", \"children\": [");
			for (Node<AuthorshipData> node : children) {
				getJson(node);
			}
			if(project_json.charAt(project_json.length()-1) == ','){
				project_json.deleteCharAt(project_json.length()-1);
			}
			project_json.append("]},");
		}
	}

	public Node<AuthorshipData> getChild(Node<AuthorshipData> root, Node<AuthorshipData> child) {

		ArrayList<Node<AuthorshipData>> children = (ArrayList<Node<AuthorshipData>>) root.getChildren();

		for (Node<AuthorshipData> node : children) {
			if ((node.getData().getName()).equalsIgnoreCase(child.getData().getName())
					&& node.getData().getDoa() == child.getData().getDoa())
				return node;

		}
		return null;

	}

}
