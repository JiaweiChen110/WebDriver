package com.test.EBayWebTest;

import org.junit.jupiter.api.Test;

import com.test.EBayWeb.EBaySearch;

public class EBaySearchTest {
	
	public void SearchLink() {
		System.out.println("Testing searchLink");
		EBaySearch.searchLink("https://www.ebay.com/");
	}
	
	public void SearchThisItem() {
		EBaySearch.searchThisItem("https://www.ebay.com/", "iphone");
	}
	
}
