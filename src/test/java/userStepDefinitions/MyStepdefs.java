package userStepDefinitions;

import WebDriver.Browser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pageObjects.TimeSheetTable;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {

    @Given("^Идем на веб-сайт проекта компании project.bellintegrator.ru$")
    public void openTimeSheet() {
//        System.setProperty("webdriver.chromedriver", "test/resources/chromedriver.exe");
        Browser.chromeSetUp();
        open("https://project.bellintegrator.ru/PWA/default.aspx");
    }

    @When("^вводим свой логин: (.*) и вводим свой пароль: (.*)$")
    public void logIn(String login, String password) {
        $("#username").sendKeys(login);
        $("#password").setValue(password).submit();
    }

    @And("^нажимаем на поле \"Manage TimeSheets\"$")
    public void clickMT() {
        $(By.linkText("Manage Timesheets")).click();
    }

    @And("^нажимаем на поле \"click to Create\" или поле \"My TimeSheet\"$")
    public TimeSheetTable chooseTimeSheet() {
        $("#GridDataRow > td:nth-child(1) > a").click();
        $("#s4-bodyContainer").waitUntil(enabled, 3000);
        return page(TimeSheetTable.class);
    }

    @And("^вводим значение \"8\" в ячейки-дни крайней рабочей недели$")
    public void cellsInput() {
        new TimeSheetTable().searchAndInput();
    }

    @And("^нажимаем на кнопку \"Save\"$")
    public void saveTimeSheet() {
        (new TimeSheetTable()).clickSaveBtn();
    }

    @Then("^отправляем заполненный TimeSheet$")
    public void sendTimeSheet() {
        (new TimeSheetTable()).clickSubmitBtnAndSendTimeSheet();
    }
}