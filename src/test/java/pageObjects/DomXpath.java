package pageObjects;

public enum DomXpath {
    CELLS("//*[@id='ctl00_ctl00_ctl40_g_1be26573_8ec6_4953_ab6a_9075db5e43f3_TimesheetPartJSGridControl_rightpane_mainTable']/tbody/tr[2]/td"),
    SAVE_BTN("//*[@id='Ribbon.ContextualTabs.TiedMode.Home.Sheet.Save-Large']"),
    SEND_BTN("//*[@id='Ribbon.ContextualTabs.TiedMode.Home.Sheet.SubmitMenu-Large']"),
    SUBMIT_MENU("//*[@id='Ribbon.ContextualTabs.TiedMode.Home.Sheet.SubmitMenu.Menu']"),
    TURN_IN_FINAL(".//*[@id='Ribbon.ContextualTabs.TiedMode.Home.Sheet.SubmitTimesheet-Menu32']");

    private String dom;

    DomXpath(String s) {
        this.dom = s;
    }

    public String getDom() {
        return dom;
    }
}
