package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        this.driver = BasePage.initializeDriver(browser);
        this.loginPage = new LoginPage(this.driver);
    }

    @Given("^El usuario está en la página de inicio de sesión$")
    public void navigate() {
        this.loginPage.navigateToPage();
    }

    @When("El usuario ingresa la contraseña {string}")
    public void enterData(String contraseña) {
        this.loginPage.sendPass(contraseña);
    }

    @When("El usuario ingresa el nombre de usuario {string}")
    public void enterData2(String usuario) {
        this.loginPage.sendUser(usuario);
    }

    @And("Borra los campos de contraseña")
    public void emptyFields2() throws InterruptedException {
        this.loginPage.emptyField2();
    }

    @And("Borra los campos de usuario")
    public void emptyFields1() throws InterruptedException {
        this.loginPage.emptyField1();
    }

    @And("^El usuario hace clic en el botón de Login")
    public void clickEntrar() {
        this.loginPage.clickSubmit();
    }


    @Then("^El sistema debe mostrar el mensaje de error se requiere nombre de usuario$")
    public void messagevalidation() {
        this.loginPage.textValidate();
    }

    @Then("^El sistema debe mostrar el mensaje de error se requiere contraseña")
    public void messagevalidation2() {
        Assert.assertTrue(loginPage.textValidate());
    }

    @When("El usuario ingresa el nombre de usuario {string} y contraseña {string}")
    public void enterData3(String usuario, String contraseña) {
        this.loginPage.sendUser(usuario);
        this.loginPage.sendPass(contraseña);
    }

    @Then("^El sistema debe mostrar el mensaje de Swag labs")
    public void messagevalidation3() {
        Assert.assertTrue(loginPage.textValidate2());
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
