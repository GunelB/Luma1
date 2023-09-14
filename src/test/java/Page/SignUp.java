package Page;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignUp extends CommonMethods {

public SignUp (){
    PageFactory.initElements(Driver.getDriver(),this);
}


    @FindBy(linkText = "Sign In")
    private WebElement HomePageSignIn;

    @FindBy(id = "email")
    private WebElement userEmail;

    @FindBy(id = "pass")
    private WebElement userPassword;

    @FindBy(id = "send2")
    private WebElement signUpButton;

    @FindBy(xpath = "(//span[@class='logged-in']) [1]")
    private WebElement welcomeMessage;

    @FindBy(xpath = "(//div[@class='messages'])[1]")
    private WebElement errorMessage;
    @FindBy(id = "email-error")
    private WebElement nullEmailMessage;

    @FindBy(id = "pass-error")
    private WebElement nullPasswordMessage;




/*
Scenario:  SignUp Page Successful Login
    Given the end-user lands on homepage
    When  the end-user clicks on sign in button
    Then  the end-user enters correct credentials
    And   the end-user gets welcome message
 */

    public void SignInButton() {

        Driver.getDriver().findElement((By) HomePageSignIn).click();

    }
    public void homePageLandOn(){
        Driver.getDriver().get(ConfigReader.getProperties("url"));

    }

    public void loginToSystem(String userName, String password) {

        Driver.getDriver().findElement((By) userEmail).sendKeys(userName);
        Driver.getDriver().findElement((By) userPassword).sendKeys(password);
        Driver.getDriver().findElement((By)signUpButton).click();

    }

    public void welcomeMessage() {
        Assert.assertEquals(Driver.getDriver().findElement((By) welcomeMessage).
                getText(), "Welcome, " + ConfigReader.getProperties("user_nameAndLastName") + "!");

    }

    public void nullEmailMessage() {
        Assert.assertEquals(Driver.getDriver().findElement((By) nullEmailMessage)
                .getText(), ConfigReader.getProperties("null_credential_message"));

    }

    public void nullPasswordMessage() {
        Assert.assertEquals(Driver.getDriver().findElement((By) nullPasswordMessage)
                .getText(), ConfigReader.getProperties("null_credential_message"));

    }

    public void ErrorMessage() {
        Assert.assertEquals(Driver.getDriver().findElement((By) errorMessage)
                .getText(), ConfigReader.getProperties("error_message"));
    }
}