package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    String element1 = "//input[@id='user-name']";
    String element2 = "//input[@id='password']";
    String element3 = "//*[@id=\"login-button\"]";
    String element4 = "//h3[@data-test='error']";
    String element5 = "//div[@class='app_logo']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void navigateToPage() {
        navigateTo("https://www.saucedemo.com/");
    }
    public void sendUser(String value) {
        this.write(element1, value);
    }
    public void sendPass(String value) {
        this.write(element2, value);
    }
    public void clickSubmit(){
        this.clickElement(element3);
    }
    public boolean textValidate(){
        return this.textValidate(element4);
    }
    public void emptyField1() {
        this.emptyField1(element1);
    }
    public void emptyField2() {
        this.emptyField2(element2);
    }
    public boolean textValidate2(){
        return this.textValidate(element5);
    }
}
