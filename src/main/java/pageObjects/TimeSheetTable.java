package pageObjects;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class TimeSheetTable {

    private List<SelenideElement> cells = $$x(DomXpath.CELLS.getDom()); //ячейки рабочей недели
    private SelenideElement saveBtn = $x(DomXpath.SAVE_BTN.getDom());   //кнопка "сохранить"
    private SelenideElement sendBtn = $x(DomXpath.SEND_BTN.getDom());   //кнопка "отправит"
    private SelenideElement submitMenu = $x(DomXpath.SUBMIT_MENU.getDom());    //меню выбора подтверждений
    private SelenideElement finalizedBtn = $x(DomXpath.TURN_IN_FINAL.getDom()); //отправить TimeSheet
    private SelenideElement parrentIframe = $x(DomXpath.COM_IFRAME_PARENT.getDom()); //iframe-родитель окна комментирования
    private SelenideElement childIframe = $x(DomXpath.COM_IFRAME_CHILD.getDom()); //iframe-child окна комментирования

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
        executeJavaScript("__doPostBack('ctl00$ctl00$PlaceHolderMain$idOkButton','return WebForm_OnSubmit();')");
        $("#s4-bodyContainer").waitUntil(enabled, 2000);

    }
}

