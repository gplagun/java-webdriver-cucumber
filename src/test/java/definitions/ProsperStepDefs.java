package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Prosper;
import pages.ProsperCustomRate;
import pages.SsnPage;

import static support.TestContext.getData;
import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;


public class ProsperStepDefs {
    @Given ("^I go to Prosper page object$")
    public void iGoToProsperPageObject() {
        new Prosper().open();
    }

    @When ("^I click \"([^\"]*)\"$")
    public void iClick(String page) throws Throwable {
        Prosper prosper = new Prosper();
        prosper.clickCheckYourRate();

    }

    @And ("^I fill out loan data fields$")
    public void iFillOutLoanDataFields() throws Throwable{
        ProsperCustomRate customRate = new ProsperCustomRate();
        customRate.fillLoanAmount(getData("amount"));
        customRate.selectLoanPurpose(getData("value"));
        Thread.sleep(3000);
    }

    @And ("^I fill out personal information fields$")
    public void iFillOutPersonalInformationFields() throws Throwable{
        ProsperCustomRate customRate = new ProsperCustomRate();
        customRate.fillFirstName(getData("fName"));
        customRate.fillLastName(getData("lName"));
        customRate.fillDateOfBirth(getData("date"));
        customRate.fillZipCode(getData("zip"));
        customRate.fillHomeAddress(getData("address"));
        customRate.fillCity(getData("city"));
        customRate.selectState(getData("state"));
        customRate.fillMonthlyPayment(getData("payment"));
    }

    @And ("^I fill out income information fields$")
    public void iFillOutIncomeInformationFields()throws Throwable {
        ProsperCustomRate customRate = new ProsperCustomRate();
        customRate.selectEmploymentStatus(getData("empStatus"));
        customRate.fillYearlyIncome(getData("income"));
        customRate.fillAdditionalIncome(getData("addincome"));
    }

    @And ("^I fill out contact information$")
    public void iFillOutContactInformation() throws Throwable{
        ProsperCustomRate customRate = new ProsperCustomRate();
        customRate.fillContactPhone(getData("phone"));
        customRate.selectToggleButton();
    }

    @And ("^I fill out email and password$")
    public void iFillOutEmailAndPassword() throws Throwable {
        ProsperCustomRate customRate = new ProsperCustomRate();
        customRate.fillEmail(getData("email"));
        customRate.createPassword(getData("password"));
//
//        if (customRate.isModalDisplayed()) {
//            customRate.fillModalPassword(getData("password"));
//            customRate.clickModalBtnSubmit();
//        }

            Thread.sleep(3000);

    }

    @And ("^I check electronic signature$")
    public void iCheckElectronicSignature() throws Throwable {
        ProsperCustomRate customRate = new ProsperCustomRate();
        customRate.checkAthorization();
    }

    @And ("^I submit custom rate form$")
    public void iSubmitCustomRateForm() throws Throwable {
        ProsperCustomRate customRate = new ProsperCustomRate();
        customRate.clickViewOffer();
    }

    @Then ("^I verify that SSN page is loaded$")
    public void iVerifyThatSSNPageIsLoaded() throws Throwable {
        SsnPage ssnPage = new SsnPage();
        assertThat(ssnPage.ssnPromptHeader().contains("Social Security Number"));
        assertThat(ssnPage.isSsnInputIsDisplayed()).isTrue();
    }
}
