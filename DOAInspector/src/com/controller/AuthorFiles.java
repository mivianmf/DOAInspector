package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map; 
import java.util.Comparator; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.authorship.*;

/**
 * Servlet implementation class AuthorFiles
 */
@WebServlet("/author_files")
public class AuthorFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthorFiles() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String authorName = request.getParameter("author");
			String nomeProjeto = request.getParameter("project");
			CreateTableAuthorShip data = new CreateTableAuthorShip(nomeProjeto);
			Map<String,Author> map = data.getAuthors();
			
			Author author = map.get(authorName.replace("_", " "));
			
			ArrayList<DOA> doa = author.getFilesOwner();
			
			Collections.sort (doa, new Comparator() {  
	            public int compare(Object o1, Object o2) {  
	                DOA p1 = (DOA) o1;  
	                DOA p2 = (DOA) o2;  
	                return p1.doa < p2.doa ? +1 : (p1.doa > p2.doa ? -1 : 0);  
	            }  
	        });  
			
			request.setAttribute("DOAlist", doa);
		
			RequestDispatcher rd = null;
	        rd = request.getRequestDispatcher("public/author_files.jsp");
			rd.forward(request, response);
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
