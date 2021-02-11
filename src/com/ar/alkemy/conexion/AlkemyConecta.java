package com.ar.alkemy.conexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlkemyConecta
 */
@WebServlet("/AlkemyConecta")
public class AlkemyConecta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlkemyConecta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/proyecto_alkemy?useSSL=false";

		String usuario = "root";

		String contra = "1234";
		
		String driver="com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out =response.getWriter();
			
			out.print("Nombre de la base de datos: "+ jdbcUrl);
			
			Class.forName(driver);
			
			Connection miConexion=DriverManager.getConnection(jdbcUrl, usuario, contra);
			
			out.print("Conectado!");
			
			miConexion.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
