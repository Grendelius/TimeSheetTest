package pageObjects;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class TimeSheetTable {

    private List<SelenideElement> cells = $$x(DomXpath.CELLS.getDom()); //ячейки рабочей недели
    private SelenideElement saveBtn = $x(DomXpath.SAVE_BTN.getDom());   //кнопка "сохранить"
    private SelenideElement sendBtn = $x(DomXpath.SEND_BTN.getDom());   //кнопка "отправить"
    private SelenideElement submitMenu = $x(DomXpath.SUBMIT_MENU.getDom());    //меню выбора подтверждений
    private SelenideElement finalizedBtn = $x(DomXpath.TURN_IN_FINAL.getDom()); //отправить TimeSheet

    public void searchAndInput() {
        cells.stream().skip(1).limit(5).forEach(selenideElement ->
                actions().moveToElement(selenideElement).doubleClick().sendKeys("8h").build().perform());
    }

    public void clickSaveBtn(){
        $(saveBtn).waitUntil(enabled, 1000).click();
    }

    public void clickSubmitBtnAndSendTimeSheet() {
        $(sendBtn).waitUntil(enabled, 1000).click();
        $(submitMenu).waitUntil(enabled, 1000);
        $(finalizedBtn).waitUntil(enabled, 1000).click();
        switchTo().frame($x("//*[@class='ms-dlgFrame']"));
        actions().moveToElement($x("//*[@id='ctl00_ctl00_PlaceHolderMain_idOkButton']"))
                .doubleClick().pause(Duration.ofSeconds(1)).build().perform();
        $("#s4-bodyContainer").waitUntil(enabled, 2000);
    }
}

