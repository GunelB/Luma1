package Steps;

import Page.SignUp;
import Utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends CommonMethods {
    SignUp signUp = new SignUp();

    @Given("the end-user lands on sign in page")
    public void the_end_user_lands_on_sign_in_page() {
        signUp.homePageLandOn();

    }

    @When("the end-user clicks on sign in button")
    public void the_end_user_clicks_on_sign_in_button() {
        signUp.SignInButton();
    }

    @Then("the end-user enters correct credentials")
    public void the_end_user_enters_correct_credentials() {
        signUp.loginToSystem(signUp.userEmail, signUp.savedUserPassword);

    }

    @Then("the end-user gets welcome message")
    public void the_end_user_gets_welcome_message() {
        signUp.welcomeMessage();

    }

    @Then("the end-user enters invalid password,valid username")
    public void the_end_user_enters_invalid_password_valid_username() {
        signUp.loginToSystem(signUp.userEmail, signUp.faker.internet().password());
    }

    @Then("the end-user gets error message")
    public void the_end_user_gets_error_message() {
        signUp.ErrorMessage();

    }

    @Then("the end-user enters valid password,invalid username")
    public void the_end_user_enters_valid_password_invalid_username() {
        signUp.loginToSystem(signUp.faker.internet().emailAddress(), signUp.savedUserPassword);
    }

    @Then("the end-user enters null password, null username")
    public void the_end_user_enters_null_password_null_username() {
        signUp.loginToSystem("", "");
    }

    @Then("the end-user gets required fields message")
    public void the_end_user_gets_required_fields_message() {
        signUp.nullEmailMessage();
        signUp.nullPasswordMessage();

    }


    @Then("the end-user enters null password, valid username")
    public void the_end_user_enters_null_password_valid_username() {
        signUp.loginToSystem(signUp.userEmail, "");
    }

    @Then("the end-user gets required password field message")
    public void the_end_user_gets_required_password_field_message() {
        signUp.nullPasswordMessage();

    }

    @Then("the end-user enters valid password, null username")
    public void the_end_user_enters_valid_password_null_username() {
    }

    @Then("the end-user gets required username field message")
    public void the_end_user_gets_required_username_password_field_message() {
        signUp.nullEmailMessage();

    }
}







