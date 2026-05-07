package pages;
// Importaciones necesarias para el funcionamiento de Selenium y la configuración del WebDriver.
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// Definición de la clase BasePage
public class BasePage {
    // Definición de variables protegidas para WebDriver, WebDriverWait y Actions
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    // Constructor de la clase BasePage que inicializa las variables con el WebDriver pasado como argumento
    public BasePage(WebDriver driver) {
        // Asigna el WebDriver recibido al campo 'driver' de la clase
        this.driver = driver;
        // Inicializa WebDriverWait con un tiempo de espera de 30 segundos
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Inicializa Actions para realizar acciones avanzadas del usuario
        this.actions = new Actions(driver);
        // Inicializa los elementos de la página usando PageFactory
        PageFactory.initElements(driver, this);
        // Maximiza la ventana del navegador
    }
    // Método estático que inicializa y configura el WebDriver
    public static WebDriver initializeDriver(String browserName) {
        WebDriver driver;

        // Usamos switch para inicializar el navegador correcto basado en el parámetro
        switch (browserName) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                // firefoxOptions.addArguments("--headless"); // Opcional
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();

                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                // edgeOptions.addArguments("--headless"); // Opcional
                System.setProperty("webdriver.edge.driver", "src/test/resources/driver/msedgedriver.exe");
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
                break;

            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                // chromeOptions.addArguments("--headless");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;
        }
        return driver;
    }

    // Método que navega a la URL especificada usando el WebDriver
    public void navigateTo(String url) {
        driver.get(url);
    }
    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public Boolean textValidate(String locator) {
        return find(locator).isDisplayed();
    }

    public void write(String locator, String texto) {
        find(locator).sendKeys(texto);
    }
    public void emptyField1(String locator) {
        find(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        find(locator).sendKeys(Keys.DELETE);
    }
    public void emptyField2(String locator) {
        find(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        find(locator).sendKeys(Keys.DELETE);
    }
}

