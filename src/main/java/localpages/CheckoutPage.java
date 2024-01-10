package localpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage{
    @FindBy(id = "firstName")
    private WebElement firstNameInput;
    @FindBy(id = "lastName")
    private WebElement lastNameInput;
    @FindBy(id = "username")
    private WebElement userNameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "address")
    private WebElement address1Input;
    @FindBy(id = "address2")
    private WebElement address2Input;
    @FindBy(id = "country")
    private WebElement countryInput;
    @FindBy(id = "state")
    private WebElement stateInput;
    @FindBy(id = "zip")
    private WebElement zipInput;



    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return false;
    }
    public void selectCountry(String country) {
        select(countryInput, country);
    }
    public void selectState(String state) {
        select(stateInput, state);
    }
}
