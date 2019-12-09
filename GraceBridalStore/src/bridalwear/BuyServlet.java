package bridalwear;


import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bridalwear.Buy;

/**
 * Servlet implementation class BuyServlet
 */
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int count=0;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productImage = request.getParameter("productImage");
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productPrice = request.getParameter("productPrice");
		HttpSession session=request.getSession();
		List shopCart=(List)session.getAttribute("shopCart");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("  <html>  ");
		out.println("  <head>  ");
		out.println(" <title> Cart </title> ");
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
		if(null==productCode||"".equals(productCode)){
			out.println("<center><h2><font color='#2689D0'>Please select product</font></h2></center>");
		}else{
			out.println("<TABLE BORDER=1  background-color=#6495ed   margin-left= auto margin-right= auto >");
			out.println("<thead><tr>");
			out.println("<th border= 3px groove padding= 5px></th>");
			out.println("&nbsp; &nbsp;&nbsp; &nbsp;<th border= 3px groove padding= 9px>Image</th>");
			out.println("&nbsp; &nbsp;&nbsp; &nbsp;<th border= 3px groove padding= 9px>Code</th>");
			out.println("&nbsp; &nbsp;&nbsp; &nbsp;<th border= 3px groove padding= 9px>Name</th>");
			out.println("&nbsp; &nbsp;&nbsp; &nbsp;<th border= 3px groove padding= 9px>Quantity</th>");
			
			out.println("<th border= 3px groove padding= 9px>Price</th>");
			out.println("<th border= 3px groove padding= 9px>Total</th>");
			out.println("</tr></thead>");
			if(null==shopCart||shopCart.size()<=0){
				shopCart = new ArrayList();
			}
			boolean flag =false;
			for(int i=0;i<shopCart.size();i++){
				Buy bi=(Buy)shopCart.get(i);
				
				if(bi.getProductCode().equals(productCode)){
					bi.setProductImage(bi.getProductImage());
					bi.setQuantity(bi.getQuantity()+1);
					
					bi.setTotal(bi.getPrice()*bi.getQuantity());
					
					flag=true;
					
				}
				break;
				}
			
				if(!flag){
					Buy bi = new Buy();
					bi.setProductImage(productImage);
					
					bi.setProductCode(productCode);
					
					bi.setProductName(productName);
					
					bi.setPrice(new Double(productPrice));
					
					bi.setQuantity(1);
					
					bi.setTotal(bi.getPrice()*bi.getQuantity());
					
					shopCart.add(bi);
					
					
				}
				session.setAttribute("shopCart", shopCart);
				
			}
		
		
		out.println("<TR >");
		//out.println("<TD>");
		//out.println("<ul>");
		for(int i=0;i<shopCart.size();i++){
			//out.println("</TD>");
			//out.println("<TD>");
			Buy bi=(Buy)shopCart.get(i);
			//out.println("</TD>");
			//out.println("<TD >");
			out.println("<form method ='get'  >");
			out.println("<TD border= 3pxgroove padding= 5px><input type='checkbox' name='shopCart' value='shopCart'/></TD><TD border= 3pxgroove padding= 5px><img src ='images/"  + bi.getProductImage()+"'/></TD > <TD border= 3px groove padding= 5px><br>"+ bi.getProductCode()+"</TD >&nbsp; &nbsp;&nbsp; &nbsp; <TD border= 3px groove padding= 5px><br>" + bi.getProductName() +"</TD> <TD border= 3px groove padding= 5px><br>" + bi.getQuantity()+ "</TD> <TD border= 3px groove padding= 5px><br>" + bi.getPrice()+"</TD> <TD border= 3px groove padding= 5px><br>" + bi.getTotal()+"</TD><br>");
			//out.println("</TD>"); 
			count++;
			if(count==1){out.println("</TR>"); count=0;}
			
			String items[] = request.getParameterValues( "shopCart" );
			  
	        if ( items != null ) {
	             
	            for ( int i1=0; i1 < items.length; i1++ ) {
	                 
	                out.println( "<INPUT TYPE=hidden NAME=shopCart VALUE='" + items[i1] + "'>" );
	                 
	            }
	        }
		}
		out.println("</form>");
		//out.println("</TR>");
		
		out.println("</TABLE>");
		out.println("<p class= bold green>");
		out.println("<br><a href='ProductServlet'>Click to Continue </a> ");
		out.println("</p>");
		out.println("<form method ='get' action = ' http://localhost:8080/GraceBridalStore/Checkout.jsp' >");
		out.println("<p><input type = 'submit' value = 'Check Out' /></p>");
		out.println("</form>");
		out.println("</div>");
		
		out.println("</div>");
		
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
//		HttpSession session=request.getSession(true);
//		RequestDispatcher dispatcher;
//		
//	
		// if session does not exist, forward to index.html
//	      if ( session == null ) {
//         dispatcher = 
//            request.getRequestDispatcher( "/index.html" );
//         dispatcher.forward( request, response );
//	      }
	      
	      // session exists, get cart HashMap and book to add
//      @SuppressWarnings("unchecked")
//		Map<String,Buy> cart =  (Map<String,Buy>) session.getAttribute( "cart" );
//	      
//	      List<?> shopCart=(List<?>)session.getAttribute("shopCart");
		// if cart does not exist, create it
	      // if cart does not exist, create it
//      if ( cart == null ) {
//	         cart = new HashMap<String,Buy>();
//	         
//	         // set session attribute "cart"
//
//	         session.setAttribute("shopCart", shopCart);
//	      }
	      
	      // determine if book is in cart
//	      Buy cartItem =  cart.get( ((Buy) shopCart).getProductCode() );
	      
	      // If book is already in cart, update its quantity.
	      // Otherwise, create an entry in the cart.
//	      if ( cartItem != null ) 
//	         cartItem.setQuantity( cartItem.getQuantity() + 1 );
//	      else 
//	         cart.put( ((Buy) shopCart).getProductCode(), new Buy( shopCart, 1 ) );
//	      
	      // send the user to viewCart.jsp
//	      dispatcher = 
//	         request.getRequestDispatcher( "/checkout.jsp" );
//	      dispatcher.forward( request, response );
//		
	}

}
