package bridalwear;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bridalwear.Customer;
import bridalwear.MysqlUtils;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String creditcard = request.getParameter("creaditcard");
		String expired = request.getParameter("expired");
		Customer cus = new Customer();
		cus.setFirstName(firstname);
		cus.setLastName(lastname);
        cus.setEmail(email);
		cus.setMobile(mobile);
		cus.setAddress(address);
		cus.setStreet(street);
		cus.setCity(city);
		cus.setState(state);;
		cus.setCreditCard(creditcard);
		cus.setExpired(expired);
		
		String sql = cus.genInsertSql();
		MysqlUtils mysql = new MysqlUtils();
		try{
			mysql.insertBySql(sql);
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("  <html>  ");
		out.println("  <head>  ");
		out.println(" <title> Thank You </title> ");
		out.println("<link rel='stylesheet' type='text/css' href='css/style.css'/>");
		out.println("  </head>  ");
		out.println(" <body  >   ");
		//out.println("<div id ='page'>"); 
		out.println("<div id =header>");
		out.println(" <span>G</span><h1>-race Bridal Store</h1>  ");
		
		//out.println("<br>   ");
		//out.println(" <br>   ");
		out.println(" </div>   ");
		
		out.print("<div id= menu>");
		out.println(" <ul>   ");
		//out.println("<span style='font-size: 24px; color: #2689D0; float:left;'>");
		out.println("<li><a href='http://localhost:8080/GraceBridalStore/Home.html' class=active>Home</a></li> ");
		out.println("<li><a href='http://localhost:8080/GraceBridalStore/ProductServlet' class = active>Products</a></li> ");
		out.println("<li><a href='http://localhost:8080/GraceBridalStore/BuyServlet' class = active>Cart</a></li> ");
		out.println("<li><a href='http://localhost:8080/GraceBridalStore/ProductServlet' class = active>Shop Now</a></li> ");
		out.println("</ul>");
		out.println("</div>");
		out.print("<div id= content>");
		out.println("<div id=columnA>   ");
		out.println("<h2>Thank You for Buying with GraceBridal.</h2>");
		out.println("success,your order no is:"+cus.getNo());
		
		out.println("<br>  <br> ");
				out.println(" <br>  <br> ");
				out.println("<br>  <br> ");
				out.println(" <br>  <br> ");
		out.println("</div>");
		
		out.println("<div id='footer'>2015 Grace Bridal Designed by tatsmwash");
		out.println(" </div>   ");
	out.println(" </body>   ");
	out.println(" </html>   ");
		out.close();
	
	}
	

}
