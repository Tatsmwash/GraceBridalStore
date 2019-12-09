package bridalwear;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bridalwear.Products;

/**
 * Servlet implementation class ProductDeal
 */
public class ProductDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(Htt        pServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String productCode = request.getParameter("productCode");
		String productImage = request.getParameter("productImage");
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productPrice = request.getParameter("productPrice");
		//HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		String catalogFileName = context.getInitParameter("fileName");
		
		InputStream is = null;
		BufferedReader catReader = null;
		Products p = new Products();
		
		out.println("  <html>  ");
		out.println("  <head>  ");
		out.println(" <title> Detail  </title> ");
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
		out.println("<h2>Shopping Cart</h2>");
		
	try{
		is = context.getResourceAsStream(catalogFileName);
		catReader= new BufferedReader(new InputStreamReader(is));
		List<Products> catalog = new ArrayList<Products>();
//			URL fileName = new URL("http://localhost:8080/GraceBridalStore/web.xml");
//			SAXBuilder builder = new SAXBuilder();
//			Document addressBook =builder.build(fileName);
//			Element root = addressBook.getRootElement();
//			List catalog = root.getChildren("catalog");
		
		for (int i=0; i < catalog.size(); i++) {
			if(p.getProductCode().equals(productCode)){
				p.setProductImage(productImage);
				p.setProductCode(productCode);
				p.setProductName(productName);
				
				p.setProductPrice(new Double(productPrice));
				catalog.add(p);
			}
			context.setAttribute("catalog", catalog);
				break;				
				}
				
			
	
	}catch(Exception e){
		e.printStackTrace();
//			
	}
		request.setAttribute("ProductDeal", p);
		RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
		rd.forward(request, response);
		
		out.println("</div>");
		
		out.println("</div>");
		
			out.println("<div id='footer'>2015 Grace Bridal Designed by tatsmwash");
			out.println(" </div>   ");
		out.println(" </body>   ");
		out.println(" </html>   ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productImage = request.getParameter("productImage");
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productPrice = request.getParameter("productPrice");
		//HttpSession session=request.getSession();
		
		ServletContext context = getServletContext();
		String catalogFileName = context.getInitParameter("fileName");
		
		InputStream is = null;
		BufferedReader catReader = null;
		Products p = new Products();
	try{
		is = context.getResourceAsStream(catalogFileName);
		catReader= new BufferedReader(new InputStreamReader(is));
		List<Products> catalog = new ArrayList<Products>();
//			URL fileName = new URL("http://localhost:8080/GraceBridalStore/web.xml");
//			SAXBuilder builder = new SAXBuilder();
//			Document addressBook =builder.build(fileName);
//			Element root = addressBook.getRootElement();
//			List catalog = root.getChildren("catalog");
		
		for (int i=0; i < catalog.size(); i++) {
			if(p.getProductCode().equals(productCode)){
				p.setProductImage(productImage);
				p.setProductCode(productCode);
				p.setProductName(productName);
				
				p.setProductPrice(new Double(productPrice));
				catalog.add(p);
			}
			context.setAttribute("catalog", catalog);
				break;				
				}
				
			
	
	}catch(Exception e){
		e.printStackTrace();
//			
	}
	
	
	
		request.setAttribute("ProductDeal", p);
		RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
		rd.forward(request, response);
		
		
		
		
		
	}

	}


