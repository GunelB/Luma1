package Page;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class SignUp extends CommonMethods {
    public String userEmail =ConfigReader.getProperties("user_email");
    public String savedUserPassword=ConfigReader.getProperties("user_password");
    public Faker faker = new Faker();
public SignUp (){
    PageFactory.initElements(Driver.getDriver(),this);

}



    @FindBy(xpath = "//ul[@class='header links'] //li[2]//a")
    private WebElement SignInButton;

    @FindBy(id = "email")
    private WebElement UserName;

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

public void homePageLandOn(){
    Driver.getDriver().get(ConfigReader.getProperties("url"));

}
    public void SignInButton() {
    Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    SignInButton.click();
    }


    public void loginToSystem(String userName, String password) {

      UserName.sendKeys(userName);
         userPassword.sendKeys(password);
        clickWithWait( signUpButton);

    }

    public void welcomeMessage() {
    setWaitTime();
        Assert.assertEquals(Driver.getDriver().findElement((By) welcomeMessage).
                getText(),  ConfigReader.getProperties("Message") );

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