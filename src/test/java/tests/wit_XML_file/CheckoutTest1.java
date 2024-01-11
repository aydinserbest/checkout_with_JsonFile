package tests.wit_XML_file;

import localpages.CheckoutPage;
import localpages.CheckoutTestData;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.AbstractTest;
import util.Config;
import util.Constants;
import util.JsonUtil;

import static org.testng.Assert.assertTrue;

public class CheckoutTest1 extends AbstractTest {
    private CheckoutTestData testData;

    @BeforeSuite
    public void setupConfig() {
        Config.initialize();
    }

    @BeforeTest
    @Parameters("testDataPath")
    public void setParameters(String testDataPath) {
        log.info("Test data path received: " + testDataPath);
        this.testData = JsonUtil.getTestData(testDataPath, CheckoutTestData.class);
    }

    @Test
    public void userRegistration() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.visit(Config.get(Constants.URL));
        checkoutPage.isAt();
        checkoutPage.fillCheckoutForm(testData);

        assertTrue(driver.getCurrentUrl().contains("paymentMethod=on"), "Form not sent");


    }
}
