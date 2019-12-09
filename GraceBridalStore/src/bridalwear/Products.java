package bridalwear;

public class Products {
	private String productCode;
	private String productName;
	private String productImage;
	private Double productPrice;
	
	public String getProductCode(){
		return productCode;
	}
    public void setProductCode(String productCode) {
    	this.productCode = productCode;
    }
    public String getProductName() {
    	return productName;
    }
    public void setProductName(String productName) {
    	this.productName = productName;
    }
    public String getProductImage() {
    	return productImage;
    }
    public void setProductImage(String productImage) {
    	this.productImage = productImage;
    }
    public Double getProductPrice() {
    	return productPrice;
    }
    public void setProductPrice(Double productPrice) {
    	this.productPrice = productPrice;
    }
	public String display() {
		
		String s = "";
		
		s="<li style='float:left'>";
		s+="<a href='http://localhost:8080/GraceBridalStore/ProductDeal' class = active><img src ='images/" + this.productImage  +  "'/></a><br/>";
		s+="ProductCode:" + this.productCode + "<br/>";
		s+="ProductName:" + this.productName + "<br/>";
		s+="ProductPrice:$" + this.productPrice + "<br/>";
		s+="<a href='BuyServlet?productImage="+this.productImage+"&productCode="+this.productCode+"&productPrice="+this.productPrice+"&productName="+this.productName+"'>Add to Cart</a><br/>";
		return s;
	}
	
}
