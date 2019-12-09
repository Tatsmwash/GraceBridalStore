package bridalwear;

import java.util.List;

public class Buy {
	private String productImage;
	private String productCode;
	private String productName;
	private Integer quantity;
	private Double price;
	private Double total;
	private Double totalCost;
	
public Buy(){
		
	}

	public Buy( Double total, String productCode, String productName,
			int quantity, Double price,Double totalCost) {
		super();
		
		this. total =  total;
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.totalCost = totalCost;
		
	}
	
	public Buy(List<?> shopCart, int i) {
		// TODO Auto-generated constructor stub
	}

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
    public Double getPrice(){
		return price;
	}
    public void setPrice(Double price) {
    	this.price = price;
    }
    public Integer getQuantity(){
		return quantity;
	}
    public void setQuantity(Integer quantity) {
    	this.quantity = quantity;
    }
    public Double getTotal(){
		return total;
	}
    public void setTotal(Double total) {
    	this.total = total;
    }
    public Double getTotalCost(){
		return totalCost;
	}
    public void setTotalCost(Double totalCost) {
    	this.totalCost = totalCost;
    }
    public String getProductImage() {
    	return productImage;
    }
    public void setProductImage(String productImage) {
    	this.productImage = productImage;
    }
}
