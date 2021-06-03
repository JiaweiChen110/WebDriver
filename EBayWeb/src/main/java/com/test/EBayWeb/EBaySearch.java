package com.test.EBayWeb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EBaySearch {
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
		wd.get(s);
		wd.findElement(By.id("gh-ac")).sendKeys(i);
		wd.findElement(By.id("gh-btn")).click();
		
		WebElement WebElement = wd.findElement(By.id("srp-river-results"));
        // Create an IList and intialize it with all the elements of div under div with **class as facetContainerDiv**
        List<WebElement> itemNames = WebElement.findElements(By.className("s-item__title"));
        List<WebElement> itemPrices = WebElement.findElements(By.className("s-item__price"));
        
        for (int k = 0; k < itemNames.size(); k++)
        {
        // Check the check boxes based on index
        	WriteToFile.saveToTextFile(itemNames.get(k).getText() + " - " + itemPrices.get(k).getText(), "EBayItems.txt");
//            System.out.println(itemNames.get(k).getText() + " - " + itemPrices.get(k).getText());
        }
        
        wd.quit();
	}

}
