package com.shoaib.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighlightElementByJsExecutor {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");

		WebElement email = driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']"));
		WebElement password = driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']"));

		WebElement create_Account = driver.findElement(By.xpath("//a[@class='oZoRPi']"));
		flash(create_Account, driver); //called flash method
	}

	//Flash method is created
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver); //driver is casted to Javascript Executor
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 1000; i++) {
			changecolor("rgb(0,200,0)", element, driver);
			changecolor(bgcolor, element, driver);
		}
	}
    //Change Color method is created to change the color while flashing
	public static void changecolor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
	}

}
