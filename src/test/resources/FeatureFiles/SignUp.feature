Feature: Sign in Page


  Scenario:  SignUp Page Successful Login
    Given the end-user lands on sign in page
    When  the end-user clicks on sign in button
    Then  the end-user enters correct credentials
    And   the end-user gets welcome message
    ##And   the end-user gets welcome message-- burda bug var galiba



  Scenario:  SignUp Page Invalid  Login With Invalid Password, Valid Username
    Given the end-user lands on sign in page
    When  the end-user clicks on sign in button
    Then  the end-user enters invalid password,valid username
    And   the end-user gets error message


  Scenario:  SignUp Page Invalid  Login With Valid Password, Invalid Username
    Given the end-user lands on sign in page
    When  the end-user clicks on sign in button
    Then  the end-user enters valid password,invalid username
    And   the end-user gets error message

  Scenario:  SignUp Page Invalid  Login With Null Credentials
    Given the end-user lands on sign in page
    When  the end-user clicks on sign in button
    Then  the end-user enters null password, null username
    And   the end-user gets required fields message

  Scenario:  SignUp Page Invalid  Login With Null Password and Valid Username
    Given the end-user lands on sign in page
    When  the end-user clicks on sign in button
    Then  the end-user enters null password, valid username
    And   the end-user gets required password field message

  Scenario:  SignUp Page Invalid  Login With Null Username and Valid Password
    Given the end-user lands on sign in page
    When  the end-user clicks on sign in button
    Then  the end-user enters valid password, null username
    And   the end-user gets required username field message


