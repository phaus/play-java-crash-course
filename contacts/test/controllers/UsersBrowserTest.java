package controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.WebClient;

import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.test.Helpers;
import play.test.TestBrowser;
import play.test.WithBrowser;

public class UsersBrowserTest extends WithBrowser {
	
    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }
    
    public static class CustomHtmlUnitDriver extends HtmlUnitDriver {
        @Override
        public WebClient getWebClient() {
            return super.getWebClient();
        }
    }

    @Override
    protected TestBrowser provideBrowser(int port) {
        // Here you need to create the TestBrowser for the class above.
        TestBrowser browser = Helpers.testBrowser(CustomHtmlUnitDriver.class, port);
        CustomHtmlUnitDriver driver = (CustomHtmlUnitDriver)browser.getDriver();
        WebClient client = driver.getWebClient();

        // do whatever you want with the WebClient

        return browser;
    }
    
    @Test
    public void runInBrowser() {
        browser.goTo("/");
        assertNotNull(browser.$("title").text());
    }
}
