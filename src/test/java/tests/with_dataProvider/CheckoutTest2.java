package tests.with_dataProvider;

import localpages.CheckoutPage;
import localpages.CheckoutTestData;
import org.testng.annotations.*;
import tests.AbstractTest;
import util.Config;
import util.Constants;
import util.JsonUtil;

import static org.testng.Assert.assertTrue;

public class CheckoutTest2 extends AbstractTest {

    @BeforeSuite
    public void setupConfig() {
        Config.initialize();
    }
    @DataProvider(name = "CheckoutData")
    public Object[][] provideTestData() {
        CheckoutTestData testData1 = JsonUtil.getTestData("test-data/data.json", CheckoutTestData.class);
        CheckoutTestData testData2 = JsonUtil.getTestData("test-data/data2.json", CheckoutTestData.class);

        return new Object[][] {
                { testData1 },
                { testData2 }
        };
    }

    @Test(dataProvider = "CheckoutData")
    public void userRegistration(CheckoutTestData testData) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.visit(Config.get(Constants.URL));
        checkoutPage.isAt();
        checkoutPage.fillCheckoutForm(testData);

        assertTrue(driver.getCurrentUrl().contains("paymentMethod=on"), "Form not sent");


    }
}
