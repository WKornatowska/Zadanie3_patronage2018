package com.intive.patronage.steps;

import com.intive.patronage.DriverFactory;
import com.intive.patronage.pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


    public class MyStepdefs  {

        WebDriver driver;
        DriverFactory driverFactory;
        AutomationPracticeHomePage homePage;
        AutomationPracticeAuthenticationPage authenticationPage;
        AutomationPracticeMyPersonalInformations personalInformations;
        AutomationPracticeProductPage productPage;
        AutomationPracticeShoppingCartSummary shoppingCartSummary;
        AutomationPracticeShippingPage shippingPage;
        AutomationPracticePaymentPage paymentPage;
        AutomationPracticeAddressPage addressPage;
        AutomationPracticeOrderConfirmationPage orderConfirmationPage;

        @Given("^I am on the authentication form page$")
        public void iAmOnTheAuthenticationFormPage() throws Throwable {
            driverFactory=new DriverFactory(driver);
            driverFactory.Setup();
            homePage=driverFactory.getHomePage();
            authenticationPage=homePage.getAuthenticationPage();
            authenticationPage.VerifyIfAuthenticationFormPageIsVisible();

        }

        @When("^I enter email address \"([^\"]*)\"$")
        public void iEnterEmailAddress(String arg0) throws Throwable {
            authenticationPage.InserEmailToCreateAccount(arg0);
        }

        @And("^I press CreateAnAccount button$")
        public void iPressCreateAnAccountButton() {
            authenticationPage.CreateAnAccount();
        }

        @Then("^I should see account create error message$")
        public void iShouldSeeAccountCreateErrorMessage() throws Throwable{
            authenticationPage.VerifyIfCreateAccountErrorIsDisplayed();
            driverFactory.destroyDriver();
        }

        @When("^I enter valid email address \"([^\"]*)\" and password \"([^\"]*)\"$")
        public void iEnterValidEmailAddressAndPassword(String arg0, String arg1) {
            authenticationPage.InsertDataToSignIn(arg0, arg1);
        }

        @And("^I press SignIn button$")
        public void iPressSignInButton() {
            authenticationPage.SignIn();
        }

        @Then("^My account page should be open$")
        public void myAccountPageShouldBeOpen() throws Throwable {
            authenticationPage.VeryfiyIfMyAccountPageIsVisible();
        }

        @And("^I should see My personal information button$")
        public void iShouldSeeMyPersonalInformationButton() throws Throwable {
            authenticationPage.VeryfiyIfMyPersonalInformationButtonIsVisible();
            driverFactory.destroyDriver();
        }

        @When("^I enter valid email address \"([^\"]*)\" and invalid password \"([^\"]*)\"$")
        public void iEnterValidEmailAddressAndInvalidPassword(String arg0, String arg1)  {
            authenticationPage.InsertDataToSignIn(arg0,arg1);
        }

        @Then("^I should see error message$")
        public void iShouldSeeErrorMessage() throws Throwable {
            authenticationPage.VeryfiyIfErrorMessageIsVisibile();
            driverFactory.destroyDriver();
        }

        @When("^I enter login \"([^\"]*)\" and password \"([^\"]*)\"$")
        public void iEnterLoginAndPassword(String arg0, String arg1) {
            authenticationPage.InsertDataToSignIn(arg0,arg1);
        }

        @When("^I enter \"([^\"]*)\" in EmailAdress field$")
        public void iEnterInEmailAdressField(String arg0) throws Throwable {
            authenticationPage.InsertEmailToSignIn(arg0);
        }


        @Then("^I should see error message Invalid email address$")
        public void iShouldSeeErrorMessageInvalidEmailAddress() throws Throwable {
            authenticationPage.VerifyIfEmailSynatxErrorIsDisplayed();
            driverFactory.destroyDriver();
        }

        @When("^I click MyPersonalInformation button$")
        public void iClickMyPersonalInformationButton() throws Throwable {
            authenticationPage.getMyPersonalInformations();
        }

        @Then("^I should see Your Personal Information form$")
        public void iShouldSeeYourPersonalInformationForm() throws Throwable {
            personalInformations.VerifyIfMyPersonalInformationsPageisDisplayed();
        }

        @And("^First name filed should be filled with name \"([^\"]*)\"$")
        public void firstNameFiledShouldBeFilledWithName(String arg0) throws Throwable {
             personalInformations.VerifyFirstNameField(arg0);
        }

        @And("^Last name filed should be filled with name \"([^\"]*)\"$")
        public void lastNameFiledShouldBeFilledWithName(String arg0) throws Throwable {
            personalInformations.VerifyEmailField(arg0);
        }

        @And("^E-mail address should be filled with email \"([^\"]*)\"$")
        public void eMailAddressShouldBeFilledWithEmail(String arg0) throws Throwable {
            personalInformations.VerifyEmailField(arg0);
            driverFactory.destroyDriver();
        }

        @When("^I press Home page button$")
        public void iPressHomePageButton() throws Throwable {
            authenticationPage.homePage();
        }

        @And("^I choose product$")
        public void iChooseProduct()  {
            productPage= homePage.getProductPage();
        }

        @And("^I press AddToCart button$")
        public void iPressAddToCartButton() {
            productPage.AddToCart();
        }

        @And("^I open Shopping Cart$")
        public void iOpenShoppingCart() throws Throwable {
            driverFactory.getHomePage();
            homePage.getShoppingCartSummary();
        }

        @And("^I am on  Shopping Cart Summary page$")
        public void iAmOnShoppingCartSummaryPage() throws Throwable {
            shoppingCartSummary.VerifyIfShoppingCartSummaryisDisplayed();
        }

        @And("^I press ProceedToCheckout button$")
        public void iPressProceedToCheckoutButton()  {
            shoppingCartSummary.getAddressPage();
        }

        @And("^I am on Addresses page$")
        public void iAmOnAddressesPage() throws Throwable {
            addressPage.VerifyIfAddressPageIsDisplayed();
        }

        @And("^I am on Shipping page$")
        public void iAmOnShippingPage() throws Throwable {
            addressPage.getShippingPage();
            shippingPage.VerifyIfShippingPageIsDisplayed();
        }

        @And("^I accept terms of service$")
        public void iAcceptTermsOfService()  {
            shippingPage.Agree();
        }

        @And("^I am on Payment page$")
        public void iAmOnPaymentPage()throws Throwable {
            shippingPage.getPaymentPage();
            shippingPage.VerifyIfShippingPageIsDisplayed();
        }

        @And("^I press Pay by check button$")
        public void iPressPayByCheckButton()  {
            paymentPage.Payment();
        }

        @And("^I confirm my order$")
        public void iConfirmMyOrder()  {
           paymentPage.getOrderConfirmationPage();
        }

        @Then("^I should see confirmation message$")
        public void iShouldSeeConfirmationMessage() throws Throwable {
            orderConfirmationPage.VerifyIfConfirmationMessageIsDisplayed();
            driverFactory.destroyDriver();
        }
    }



