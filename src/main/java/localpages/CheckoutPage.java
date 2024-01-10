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
    @FindBy(id = "cc-name")
    private WebElement cardNameInput;
    @FindBy(id = "cc-number")
    private WebElement cardNumberInput;
    @FindBy(id = "cc-expiration")
    private WebElement cardExpirationDate;
    @FindBy(id = "cc-cvv")
    private WebElement cardCVV;
    @FindBy(css = ".w-100.btn.btn-primary.btn-lg")
    private WebElement submitButton;




    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return isDisplayed(firstNameInput);
    }
    public void selectCountry(String country) {
        select(countryInput, country);
    }
    public void selectState(String state) {
        select(stateInput, state);
    }
    public void fillCheckoutForm(CheckoutTestData data) {
        type(firstNameInput, data.firstName());
        type(lastNameInput, data.lastName());
        type(userNameInput, data.username());
        type(emailInput, data.email());
        type(address1Input, data.address1());
        type(address2Input, data.address2());
        selectCountry(data.country());
        selectState(data.state());
        type(zipInput, data.ZIP());
        type(cardNameInput, data.cardName());
        type(cardNumberInput, data.cardNumber());
        type(cardExpirationDate, data.cardExpiration());
        type(cardCVV, data.cardCVV());
        clickOnElement(submitButton);
    }

}
