package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Visualization
 */
@WebServlet("/visualization")
public class Visualization extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Visualization() {
        super();
    }

    private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         
        String nomeProjeto = request.getParameter("project");
 
        if(nomeProjeto != null){
        	this.irParaIniciarCriarConta(request, response);  	
        }  
    }
 
    private void irParaIniciarCriarConta(HttpServletRequest request, HttpServletResponse response){
         
    	String project = request.getParameter("project");
    	
        RequestDispatcher rd = null;
        
        rd = request.getRequestDispatcher("public/visualization.jsp");
         
        try {
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
     	processarRequisicao(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	processarRequisicao(request, response);
    }
}
