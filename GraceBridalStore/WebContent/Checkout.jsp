<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
   <title>CheckOut</title>

   <link rel = "stylesheet" href = "css/style.css" 
      type = "text/css" />
</head>

<body>
<div id="header">
	<span>G</span><h1>-raceBridalStore</h1>
	
</div>
<div id="menu">
	<ul>
		
		
		<li><a href="http://localhost:8080/GraceBridalStore/Home.html" class="active">Home</a></li>
	<li><a href="http://localhost:8080/GraceBridalStore/ProductServlet" class="active" >Products</a></li>
		<li><a href="http://localhost:8080/GraceBridalStore/BuyServlet" class="active" >Cart</a></li>
		<li><a href="http://localhost:8080/GraceBridalStore/ProductServlet" class="active" >Shop Now</a></li>
		
	</ul>
</div>
<div id="content">
	<div id="columnA">
		<h2>Customer Details</h2>
		

   
   <form action="CustomerServlet" method="post">

      <p style = "font-weight: bold">Please Enter Details.</p>

      <!-- table of form elements -->
      <table>  
         <tr>
            <td class = "right bold">First name:</td>       

            <td>
               <input type = "text" name = "firstname" 
                  size = "25" />
            </td>
         </tr>

         <tr>
            <td class = "right bold">Last name:</td>

            <td>
               <input type = "text" name = "lastname" 
                  size = "25" />
            </td>
         </tr>
         <tr>
            <td class = "right bold">Email:</td>

            <td>
               <input type = "text" name = "email" size = "25" />
            </td>
         </tr>
          <tr>
            <td class = "right bold">Mobile #:</td>

            <td>
              

               <input type = "text" name = "mobile" size = "12" />
            </td>
         </tr> 
          
			<tr>
            <td class = "right bold">Address:</td>

            <td>
               <input type = "text" name = "address" size = "25" />
            </td>
         </tr>
          
			
         <tr>
            <td class = "right bold">Street:</td>

            <td>
               <input type = "text" name = "street" size = "25" />
            </td>
         </tr>

         <tr>
            <td class = "right bold">City:</td>

            <td>
               <input type = "text" name = "city" size = "15" />
            </td>
         </tr>

         <tr>
            <td class = "right bold">State:</td>

            <td>
               <input type = "text" name = "state" size = "5" />
            </td>
         </tr>
         <tr>
            <td class = "right bold">Credit Card #:</td>

            <td>
               <input type = "text" name = "creditcard" 
                  size = "25" />  
            </td>
         </tr>

         <tr>
            <td class = "right bold">Expiration Date (mm/yy):</td>

            <td>
               <input type = "text" name = "expired"  size = "5" /> 
            </td>
         </tr>        
      </table>
      <p><input type = "submit" value = "Submit" /></p>
   </form>
   </div> 
<br/>
 <br/>
 <br/>
<br/>
</div>

<div id="footer"><br/>
<br/>
<br/>

<br/>
 <br/>
	2015 Grace Bridal            Designed by tatsmwash designs
</div>
</body>

</html>