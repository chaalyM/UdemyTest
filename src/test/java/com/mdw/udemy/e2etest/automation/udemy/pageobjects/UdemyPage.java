package com.mdw.udemy.e2etest.automation.udemy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mdw.udemy.e2etest.automation.utils.Setup;

public class UdemyPage {
	public static WebDriver driver; 
	public UdemyPage() {
		driver = Setup.driver;
	}
	final static String Connect = "body.udemy:nth-child(2) div.ud-main-content-wrapper:nth-child(1) div.ud-app-loader.ud-component--header-v6--header.ud-header.ud-app-loaded:nth-child(1) div.ud-text-sm.header--header--1SLKV.header--flex-middle--2QeVR div.header--gap-auth-button--vj50D:nth-child(8) > a.ud-btn.ud-btn-medium.ud-btn-secondary.ud-heading-sm" ;
	final static String MAIL = "form-group--1" ;
	final static String PASSWORD = "form-group--3";
	final static String LOGIN = "body.udemy:nth-child(2) div.ud-main-content-wrapper:nth-child(1) div.ud-main-content:nth-child(3) div.ud-app-loader.ud-component--auth--app.ud-app-loaded div.ud-container.helpers--auth-container--3onqZ form:nth-child(5) button.ud-btn.ud-btn-large.ud-btn-brand.ud-heading-md.helpers--auth-submit-button--2K2dh:nth-child(4) > span:nth-child(1)";
	
	@FindBy(how = How.CSS, using = Connect )
	public static WebElement connect;
	
	@FindBy(how = How.ID, using = MAIL )
	public static WebElement mail;
	
	
	@FindBy(how = How.ID, using = PASSWORD )
	public static WebElement password;
	
	@FindBy(how = How.CSS, using = LOGIN )
	public static WebElement login;
	
	public void clickConnect() {
		connect.click();
	}
	
	public void setMail(String email) {
		mail.sendKeys(email);
	}
	
	public void setPassword(String psw) {
		password.sendKeys(psw);
	}
	public void clickLogin() {
		login.click();
	}
	
    public void searchCourse(String courseName) {
    	
		WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.clear();
        searchInput.sendKeys(courseName);
        searchInput.submit();
    }

    public String isCourseDisplayed(String courseName) {
        WebElement courseLink = driver.findElement(By.partialLinkText(courseName));
        return courseLink.getText();
    }
    
    public void clickEnrollNowButton() {
        WebElement enrollNowButton = driver.findElement(By.xpath("//button[text()='Enroll Now']"));
        enrollNowButton.click();
    }
    
    public boolean isEnrollmentSuccessful() {
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Enrollment Successful')]"));
        return successMessage.isDisplayed();
    }
}