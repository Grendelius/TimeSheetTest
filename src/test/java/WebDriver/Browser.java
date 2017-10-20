package WebDriver;

import static com.codeborne.selenide.Configuration.*;

public class Browser {
    public static void chromeSetUp() {
        browser = "chrome";
        timeout = 8000;
        clickViaJs = true;
        pollingInterval = 250;
        collectionsPollingInterval = 500;
        holdBrowserOpen = false;
    }

    public static void fireFoxSetUp() {
        timeout = 5000;
        clickViaJs = true;
        pollingInterval = 200;
        collectionsPollingInterval = 450;
        holdBrowserOpen = false;
    }
}
