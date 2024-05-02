package stepdefinitions;

import Util.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.*;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private  WebDriver driver;

/*
    @Given("I have entered {int} into the calculator")
    public void i_have_entered_into_the_calculator(int number) {
        if (firstNumber == 0)
            firstNumber = number;
        else
            secondNumber = number;
    }
    @When("I press add")
    public void i_press_add() {
        result = firstNumber + secondNumber;
    }
    @Then("the result should be {int} on the screen")
    public void the_result_should_be_on_the_screen(int expectedResult) {
        assertEquals(expectedResult, result);
    }
*/

    @Given("I open the heroku app")
    public void i_open_the_heroku_app() {
        driver = WebDriverManager.getDriver(); // Get WebDriver instance
        driver.get("https://automationfrontend-5af24080d517.herokuapp.com/login/");
    }

    @When("I login with invalid credentials")
    public void i_login_with_invalid_credentials() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for 10 seconds
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=':R19talaf6:']")));

        WebElement username=driver.findElement(By.xpath("//input[@id=':R19talaf6:']"));
        WebElement password=driver.findElement(By.id("auth-login-v2-password"));
        WebElement loginButton=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        username.sendKeys("admin@gmail.com");
        password.sendKeys("12345");
        loginButton.click();

        //WebElement searchBox = driver.findElement(By.name("q"));
       // searchBox.sendKeys(searchTerm);
       // searchBox.submit();

    }

    @Then("I should see an invalid error message")
    public void i_should_see_an_invalid_error_message() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for 10 seconds
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'MuiFormHelperText-root') and contains(@class, 'Mui-error') and contains(@class, 'MuiFormHelperText-sizeSmall') and contains(@class, 'MuiFormHelperText-contained')]")));

        String ExpectedResult="Email or Password is invalid";
       // WebElement errorMessage=driver.findElement(By.xpath("//p[contains(@class, 'MuiFormHelperText-root') and contains(@class, 'Mui-error') and contains(@class, 'MuiFormHelperText-sizeSmall') and contains(@class, 'MuiFormHelperText-contained')]"));
        String getErrorMessage=errorMessage.getText();
        assertEquals(ExpectedResult,getErrorMessage);
    }

    @Given("I visit the heroku app")
    public void i_visit_the_heroku_app() {
        driver = WebDriverManager.getDriver(); // Get WebDriver instance
        driver.get("https://automationfrontend-5af24080d517.herokuapp.com/login/");
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {

        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for 10 seconds
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=':R19talaf6:']")));

        WebElement username=driver.findElement(By.xpath("//input[@id=':R19talaf6:']"));
        WebElement password=driver.findElement(By.id("auth-login-v2-password"));
        WebElement loginButton=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        username.sendKeys("admin@gmail.com");
        password.sendKeys("admin@123");
        loginButton.click();


        //WebElement searchBox = driver.findElement(By.name("q"));
        // searchBox.sendKeys(searchTerm);
        // searchBox.submit();

    }

     
    @And("I add a record")
    public void i_add_a_record() {
        // Logic to add a record...
        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for 10 seconds
        WebElement addagency = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='__next']/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/button[1]")));

        WebElement name = driver.findElement(By.xpath("//input[@id=':r3:']"));

       WebElement email = driver.findElement(By.xpath("//input[@id=':r4:']"));
        WebElement address = driver.findElement(By.xpath("//input[@id=':r5:']"));
        WebElement phone = driver.findElement(By.xpath("//input[@id=':r6:']"));
        WebElement saveButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));


        addagency.click();

        String Name= RandomStringUtils.randomAlphanumeric(17).toUpperCase();
        name.sendKeys(Name);

        String Email=RandomStringUtils.randomAlphanumeric(17).toUpperCase()+"@gmail.com";
        email.sendKeys(Email);

        address.sendKeys("123 Address");

phone.sendKeys("+923431234455");

saveButton.click();


    }

@Then("Success Message is validated")
    public void success_message_is_validated()
{
    String SuccessMessage = "Agency has been successfully Created";

    WebDriverWait wait = new WebDriverWait(driver, 5); // Wait for 10 seconds
    WebElement successMessagetext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Agency has been successfully Created')]")));

    String successMassagecontent=successMessagetext.getText();
    assertEquals(SuccessMessage,successMassagecontent);

}


}

