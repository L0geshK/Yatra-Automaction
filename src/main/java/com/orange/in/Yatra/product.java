package com.orange.in.Yatra;

import org.openqa.selenium.WebElement;

public class product {
	private String productname;
	private String price;
	private WebElement addToCardButton;
	private WebElement productLink;

	public product(String productname, String price, WebElement addToCardButton, WebElement productLink) {
		super();
		this.productname = productname;
		this.price = price;
		this.addToCardButton = addToCardButton;
		this.productLink = productLink;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public WebElement getAddToCardButton() {
		return addToCardButton;
	}

	public void setAddToCardButton(WebElement addToCardButton) {
		this.addToCardButton = addToCardButton;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public void setProductLink(WebElement productLink) {
		this.productLink = productLink;
	}

	@Override
	public String toString() {
		return "product [productname=" + productname + ", price=" + price + ", addToCardButton=" + addToCardButton
				+ ", productLink=" + productLink + "]";
	}

}
