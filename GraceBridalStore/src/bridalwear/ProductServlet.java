package bridalwear;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.servlet.*;


/**
 * Servlet implementation class ProductServLet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private static int count=0;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		List catalog = (List) context.getAttribute("catalog");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("  <html>  ");
		out.println("  <head>  ");
		out.println(" <title> Products </title> ");
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
		out.println("<h2>Enjoying your Shopping</h2>");
		
		out.print("<TABLE  BORDER=0 id=tats >");
		out.println("<TR >");
		
		
		for (int i=0; i < catalog.size(); i++) {
			out.println("<TD>");	
			Products p = (Products)catalog.get(i);
			out.println("</TD>");
			out.println("<TD>");
			out.println("<a href='http://localhost:8080/GraceBridalStore/ProductDeal' class = active>");
			out.println("</a>");
			out.println(p.display());
			
			out.println("</TD>");
			
			
			out.println("</TD>"); count++;
			if(count==4){out.println("</TR>"); count=0;}
		}
		out.println("");
		
	
		//out.println("</TR>");
		out.println("</TABLE>");
		out.println("</div>");
		
		out.println("</div>");
		out.println("<br>");
			out.println("<div id='footer'>2015 Grace Bridal Designed by tatsmwash");
			out.println(" </div>   ");
		out.println(" </body>   ");
		
		
		out.println(" </html>   ");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
