package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility{
	 
	private static final By PRODUCT_LISTING_TITLE_LOCATER = By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCT_LIST_NAME = By.xpath("//h5[@itemprop=\"name\"]/a");
	
	ProductDetailPage productDetailPage;
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	
   public String getResultTitle() {
	   return getVisibleText(PRODUCT_LISTING_TITLE_LOCATER);
   }
   
   public boolean isSearchTermPresentInProductList(String searchTerm){
	   scrollToElement(PRODUCT_LISTING_TITLE_LOCATER);
	  List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
	   List<String> productName = getAllVisibleTexts(ALL_PRODUCT_LIST_NAME);
	   
	  boolean result = productName.stream().anyMatch(name -> keywords.stream().anyMatch
			   (keyword -> name.toLowerCase().contains(keyword.toLowerCase())));
	  return result;
   }
   
   public ProductDetailPage clickOnProductAt(int index) {
	  clickOn(getAllElements(ALL_PRODUCT_LIST_NAME).get(index));
	  
	  ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
	  return productDetailPage;
   }
  
}
