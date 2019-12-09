<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Detail</title>
<link rel='stylesheet' type='text/css' href='css/style.css'/>
</head>
<body>
<div id =header>
<span>G</span><h1>-race Bridal Store</h1> 
</div> 

<div id= menu>
 
 		
 		<ul>  
		<li><a href="http://localhost:8080/GraceBridalStore/Home.html" class=active>Home</a></li> 
		<li><a href='http://localhost:8080/GraceBridalStore/ProductServlet' class = active>Products</a></li> 
		<li><a href='http://localhost:8080/GraceBridalStore/BuyServlet' class = active>Cart</a></li> 
		<li><a href='http://localhost:8080/GraceBridalStore/ProductServlet' class = active>Shop Now</a></li> 
		</ul>
		
		</div>
		<div id= content>
		<div id=columnA>  
		<h2>View Details and Click Products to View More Details</h2>
<jsp:useBean id="ProductDeal" class="bridalwear.Products" scope="request" >

  <jsp:setProperty name="ProductDeal" property="productImage" />
  <jsp:setProperty name="ProductDeal" property="productCode" /> 
  <jsp:setProperty name="ProductDeal" property="productPrice"  />
  
</jsp:useBean>

<table width="400" border="1" align="center" cellpadding="1" cellspacing="0" >
<tr>
<td rowspan="2"> &nbsp; <img src='images/<jsp:getProperty property="productImage" name="ProductDeal"/>'/></td>
<td>&nbsp;<jsp:getProperty property="productCode" name="ProductDeal"/></td>
</tr>


<tr>

<td>&nbsp;<jsp:getProperty property="productPrice" name="ProductDeal"/></td>
</tr>



</table>
</div>
		<br>
		<br>
		<br>
		<br>
		</div>
		
			<div id='footer'>2015 Grace Bridal Designed by tatsmwash
			 </div>   
		 
</body>
</html>