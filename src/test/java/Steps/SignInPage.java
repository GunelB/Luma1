package Steps;

import Page.SignUp;
import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends CommonMethods {

    SignUp signUp;
    String userEmail;
    String userPassword;
    public SignInPage (){

        signUp=new SignUp();
        userEmail= ConfigReader.getProperties("user_email");
        userPassword= ConfigReader.getProperties("user_password");



    }
    @Given("the end-user lands on sign in page")
    public void the_end_user_lands_on_sign_in_page() {
        signUp.homePageLandOn();
    }
    @When("the end-user clicks on sign in button")
    public void the_end_user_clicks_on_sign_in_button() {
        signUp.homePageLandOn();
    }
    @Then("the end-user enters correct credentials")
    public void the_end_user_enters_correct_credentials() {
        signUp.homePageLandOn();
    }
    @Then("the end-user gets welcome message")
    public void the_end_user_gets_welcome_message() {

    }


    @Given("the end-user lands on homepage")
    public void the_end_user_lands_on_homepage() {


    }
    @When("the end-user clicks on sign in button")
    public void the_end_user_clicks_on_sign_in_button() {
     signUp.SignInButton();

    }
    @Then("the end-user enters correct credentials")
    public void the_end_user_enters_correct_credentials() {
    signUp.loginToSystem(userEmail,userPassword);

    }
    @Then("the end-user gets welcome message")
    public void the_end_user_gets_welcome_message() {
    signUp.welcomeMessage();
    }

    @Then("the end-user enters invalid password,valid username")
    public void the_end_user_enters_invalid_password_valid_username() {

    }
    @Then("the end-user gets error message")
    public void the_end_user_gets_error_message() {

    }
    @Then("the end-user enters valid password,invalid username")
    public void the_end_user_enters_valid_password_invalid_username() {

    }

    @Then("the end-user enters null password, null username")
    public void the_end_user_enters_null_password_null_username() {

    }
    @Then("the end-user gets required field message")
    public void the_end_user_gets_required_field_message() {

    }

    @Then("the end-user enters null password, valid username")
    public void the_end_user_enters_null_password_valid_username() {

    }


    @Then("the end-user enters valid password, null username")
    public void the_end_user_enters_valid_password_null_username() {

    }

    }







