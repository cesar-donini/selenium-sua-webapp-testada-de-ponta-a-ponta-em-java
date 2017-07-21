package br.com.alura.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/home/donini/Selenium Driver/Firefox/geckodriver");
		System.setProperty("webdriver.chrome.driver","/home/donini/Selenium Driver/Chrome/chromedriver");
		searchCaelum(new FirefoxDriver());
		searchCaelum(new ChromeDriver());
	}

	private static void searchCaelum(WebDriver driver) {
		driver.get("http://www.google.com.br");
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Caelum");
		search.submit();
	}
	
}
