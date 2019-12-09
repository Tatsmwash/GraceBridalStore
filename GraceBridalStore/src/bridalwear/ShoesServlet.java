package bridalwear;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Servlet implementation class GownSevlet
 */
public class ShoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private String productFile;
     private List products = new ArrayList();
     private static int count=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException{
    	productFile= getInitParameter("productFile");
    	String path = getServletContext().getRealPath("/");
    	File file = new File(path + File.separator + "myfiles" + File.separator + productFile);
    	BufferedReader reader = null;
    	try{
    		reader = new BufferedReader(new FileReader(file));
    		String tempString = null;
    		int line = 1;
    		while ((tempString = reader.readLine())!= null) {
    			String[] allInfos = tempString.split("\\,");
    			products.add(allInfos);
    			line++;
     		}
    		reader.close();
    	} catch (IOException e){
    		e.printStackTrace();
    	}finally {
    		
    	if(reader !=null){
    		try{
    			reader.close();
    		}catch(IOException e1){
    	}
    }
    }
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("  <html>  ");
		out.println("  <head>  ");
		out.println(" <title> Shoes </title> ");
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
		out.println("<h2>Welcome to Grace Bridal Store</h2>");
		
		out.print("<TABLE  BORDER=0 id=tats >");
		out.println("<TR >");
		
		for(int i=0;i<products.size();i++){
			
			String[] oneProduct=(String[])products.get(i);
			
			out.println("&nbsp; &nbsp;&nbsp; &nbsp;<TD>&nbsp; &nbsp;&nbsp; &nbsp;");
			
			
			out.println("<a href='http://localhost:8080/GraceBridalStore/ProductDeal' class = active><img src='images/"+oneProduct[3]+"'/><br>QUICK VIEW</a><br>");
			
//			out.println("ProductCode:"+oneProduct[0]+"<br>");
//			out.println("ProductName:"+oneProduct[1]+"<br>");
//			out.println("ProductPrice:"+oneProduct[2]+"<br>");
			
			out.println("</TD>"); count++;
			if(count==4){out.println("</TR>"); count=0;}
			
			}
		//out.println("</TR>");
		out.println("</TABLE>");
		out.println("</div>");
		
		out.println("</div>");
		
			out.println("<div id='footer'>2015 Grace Bridal Designed by tatsmwash");
			out.println(" </div>   ");
			//out.println(" </div>   ");
			out.println(" </body>   ");
			
			
			out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
