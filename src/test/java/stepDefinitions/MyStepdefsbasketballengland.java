package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class MyStepdefsbasketballengland {
    private WebDriver driver;
    @Given("I have entered date of birth {string}")
    public void iHaveEnteredDateOfBirth(String date) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        WebElement field = driver.findElement(By.id("dp"));
        field.sendKeys(date);
        Thread.sleep(2000);
    }

    @And("I have entered first name {string}")
    public void iHaveEnteredFirstName(String name) throws InterruptedException {
        WebElement field = driver.findElement(By.name("Forename"));
        field.click();
        field.sendKeys(name);
        Thread.sleep(2000);
    }

    @And("I have entered last name {string}")
    public void iHaveEnteredLastName(String lastname) throws InterruptedException {
        WebElement field = driver.findElement(By.name("Surname"));
        field.sendKeys(lastname);
        Thread.sleep(2000);
    }

    @And("I have entered email {string} and confirmed email {string}")
    public void iHaveEnteredEmailAndConfirmedEmail(String email, String confirmEmail) throws InterruptedException {
        WebElement field = driver.findElement(By.name("EmailAddress"));
        field.sendKeys(email);
        WebElement confirmField = driver.findElement(By.id("member_confirmemailaddress"));
        confirmField.sendKeys(confirmEmail);
        assertEquals(email,confirmEmail);
        Thread.sleep(2000);
    }

    @And("I have entered password {string} and confirmed password {string}")
    public void iHaveEnteredPasswordAndConfirmedPassword(String password, String confirmPassword) throws InterruptedException {
        WebElement field = driver.findElement(By.name("Password"));
        field.sendKeys(password);
        WebElement confirmField = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        confirmField.sendKeys(confirmPassword);
        Thread.sleep(2000);
    }

    @And("I have checked terms and condition")
    public void iHaveCheckedTermsAndCondition() {
        WebElement field = driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > label > span.box"));
        field.click();
    }
    @And("I have not checked terms and condition")
    public void iHaveNotCheckedTermsAndCondition() {
    }
    @And("I have checked over {int} or person with parental responsibility")
    public void iHaveCheckedOverOrParentalResposibility(int arg0) {
        WebElement field = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[2]/label/span[3]"));
        field.click();
    }
    @And("I have checked code of conduct")
    public void iHaveCheckedCodeOfConduct() {
        WebElement field = driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(7) > label > span.box"));
        field.click();
    }

    @When("I press the join button")
    public void iPressTheJoinButton() {
        WebElement button = driver.findElement(By.cssSelector("#signup_form > div.form-actions.noborder > input"));
        button.click();
    }

    @Then("I am registered and get the text {string}")
    public void iAmRegistered(String expected) {
        WebElement registered = driver.findElement(By.cssSelector("body > div > div.page-content-wrapper > div > h2"));
        String actual = registered.getText();
        assertEquals(expected, actual);
        driver.close();
    }

    @Then("I am not registered and get the error text {string}")
    public void iAmNotRegisteredAndGetTheErrorText(String expected) {

        if (expected.equals("Last Name is required")) {
            WebElement error = driver.findElement(By.cssSelector("#signup_form > div:nth-child(6) > div:nth-child(2) > div > span > span"));
            String actual = error.getText();
            assertEquals(expected, actual);
        } else if (expected.equals("Password did not match")) {
            WebElement error = driver.findElement(By.cssSelector("#signup_form > div:nth-child(9) > div > div.row > div:nth-child(2) > div > span > span"));
            String actual = error.getText();
            assertEquals(expected, actual);
        } else if (expected.equals("You must confirm that you have read and accepted our Terms and Conditions")) {
            WebElement error = driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > span > span"));
            String actual = error.getText();
            assertEquals(expected, actual);
        }
        driver.close();
    }

}
