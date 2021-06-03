package com.test.EBayWeb;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TargetSearch {
	public static void searchLink(String s) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\alph_\\Downloads\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get(s);
		System.out.println(wd.getTitle());
		wd.quit();
	}
	
	public static void searchThisItem(String s, String i) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\alph_\\Downloads\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
//		JavascriptExecutor js = (JavascriptExecutor) wd;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wd.get(s);
		wd.findElement(By.id("search")).sendKeys(i);
		wd.findElement(By.className("SearchInputButton-sc-1opoijs-0")).click();
		
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JavascriptExecutor js = ((JavascriptExecutor) wd);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
        // Create an IList and intialize it with all the elements of div under div with **class as facetContainerDiv**
        List<WebElement> itemNames = wd.findElements(By.xpath("//li[@data-test = 'list-entry-product-card']"));

        for (int k = 0; k < itemNames.size(); k++)
        {
        // Check the check boxes based on index
        	String[] str = itemNames.get(k).getText().split("\\n");
        	String price ="";
        	for (String x:str) {
        		if (x.charAt(0)=='$') {
        			price = x;
        		}
        	}
        	WriteToFile.saveToTextFile(str[0] + " - " + price, "TargetItem.txt");
//            System.out.println(itemNames.get(k).getText() + " - " + itemPrices.get(k).getText());
        }
//        
        wd.quit();
	}
}
