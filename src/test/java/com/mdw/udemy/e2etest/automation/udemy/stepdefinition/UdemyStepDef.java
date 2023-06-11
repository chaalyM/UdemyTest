package com.mdw.udemy.e2etest.automation.udemy.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mdw.udemy.e2etest.automation.udemy.pageobjects.UdemyPage;
import com.mdw.udemy.e2etest.automation.utils.CommunMethod;
import com.mdw.udemy.e2etest.automation.utils.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class UdemyStepDef {
	public WebDriver driver;
	public CommunMethod communMethod = new CommunMethod ();
	public UdemyPage udemyPage = new UdemyPage();
public UdemyStepDef () {
	driver = Setup.driver;
	PageFactory.initElements(driver,UdemyPage.class);
}

@Given("I am on the Udemy homepage")
public void openUdemyHomePage() throws Throwable {
	communMethod.openUrlWithConfigFile("URL");
}

@When("Je clique sur se connecter")
public void je_clique_sur_se_connecter() {
	udemyPage.clickConnect();
}

@When("Je saisie  l'Email {string}")
public void je_saisie_l_email(String string) {
	udemyPage.setMail(string);
}

@When("Je saisie le MDP {string}")
public void je_saisie_le_mdp(String string) {
	udemyPage.setPassword(string);
}

@When("Je clique sur s'identifier")
public void je_clique_sur_s_identifier() {
	udemyPage.clickLogin();
}

@When("I search for the course {string}")
public void searchForCourse(String string) throws Throwable {
	udemyPage.searchCourse(string);
}

@Then("I should see relevant courses for {string} in the search results")
public void verifyCourseDisplayed(String string) {
   
	String courseTxt = udemyPage.isCourseDisplayed(string);
	Assert.assertTrue(courseTxt.contains(string));
}


@When("I select a course at random from the search results")
public void selectRandomCourse() {
    // Code to select a course at random from the search results
}

@When("I click on the Enroll Now button")
public void clickEnrollNowButton() {
	udemyPage.clickEnrollNowButton();
}

@Then("I should see the enrollment success message")
public void verifyEnrollmentSuccessful() {
    boolean isEnrollmentSuccessful = udemyPage.isEnrollmentSuccessful();
    Assert.assertTrue("Enrollment was not successful", isEnrollmentSuccessful);
}

}
