package Integrales;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constantes.Constante_PreCalidad;
import DataDrivenTesting.ReadExcelFile;
import DataDrivenTesting.WriteExcelFile;

public class Cases_354 {
	
	int secDelay = 2000;
	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	private By DesplegarUnidadReceptora = By.id("unidadCrear-trigger-picker");
	private By escribirTipoUnidadEmisoraLocator = By.id("tipoUnidadEmisoraCrear-inputEl");
	private By escribirUnidadEmisoraLocator = By.id("unidadEmisoraCrear-inputEl");				
	private By escribirTipoUnidadReceptoraLocator = By.id("tipoUnidadReceptoraCrear-inputEl");	
	private By escribirUnidadReceptoraLocator = By.id("unidadReceptoraCrear-inputEl");
	private By escribirEmpresaTransportistaLocator = By.id("transportistaCrear-inputEl");

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		
		driver.get("http://192.168.2.214:8901/Agencia/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InterruptedException {
		
		// ---------- Prueba en los campos Montos Pases de Caja ----------
		
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		String directorioCapturas = "C:/Users/gsarmiento/Desktop/Cases Integrales - Automatización/Cases 354";
		
	 	String nombreArchivo1 = "Advertencia.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "Pase.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
		
	    WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
	    WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterAgencia.click();
	    
	    WebElement Caja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
	    Caja.click();
	    WebElement PasesBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
	    PasesBoveda.click();
	    
	    // Desplazar Scroll
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    js.executeScript("window.scrollBy(0,500)");
	
	    
	    // Crear Pases
	    
	    Thread.sleep(secDelay);
	    
	    WebElement CrearPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    CrearPase.click();
	    
	    Thread.sleep(secDelay);
	    
	    WebElement desplegarDivisaTaquilla = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
        desplegarDivisaTaquilla.click();
        WebElement seleccionarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
        seleccionarDivisa.click();
        WebElement desplegarTaquilla = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
        desplegarTaquilla.click();
        WebElement seleccionarTaquilla = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 1']")));
        seleccionarTaquilla.click();
        Thread.sleep(secDelay);
        WebElement desplegarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
        desplegarModalidad.click();
        WebElement seleccionarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal']")));
        seleccionarModalidad.click();
        Thread.sleep(secDelay);
        WebElement desplegarTipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
        desplegarTipoPase.click();
        WebElement seleccionarTipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase de Caja a Boveda']")));
        seleccionarTipoPase.click();
        Thread.sleep(secDelay);
        
        WebElement elementoCantidadTaquilla = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); //En 2.6 es 1163 y en 2.5 es 1161
        Actions Taquilla = new Actions(driver);
        Taquilla.doubleClick(elementoCantidadTaquilla).perform();	
	           	
        WebElement elementoColocarCantidad = driver.findElement(By.id("textfield-1086-inputEl"));
        if (elementoColocarCantidad.isEnabled()) {
        	Actions actions = new Actions(driver);
         	actions.click(elementoColocarCantidad).sendKeys("2").sendKeys(Keys.ENTER).perform();
         	Thread.sleep(secDelay);
        }
        
        WebElement Denominación_50 = driver.findElement(By.xpath("//div[text()='50,000']"));
        
        Actions actions = new Actions(driver);
            
        actions.moveToElement(Denominación_50).perform();

        Denominación_50.click(); 	
        
        actions.sendKeys(Denominación_50, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys("3").sendKeys(Keys.ENTER).build().perform();
        
        WebElement Denominación_20 = driver.findElement(By.xpath("//div[text()='20,000']"));
        
        Actions actions2 = new Actions(driver);
            
        actions2.moveToElement(Denominación_20).perform();

        Denominación_20.click(); 	
        
        actions2.sendKeys(Denominación_20, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys("4").sendKeys(Keys.ENTER).build().perform();
        
        WebElement Denominación_10 = driver.findElement(By.xpath("//div[text()='10,000']"));
        
        Actions actions3 = new Actions(driver);
            
        actions3.moveToElement(Denominación_10).perform();

        Denominación_10.click(); 	
        
        actions3.sendKeys(Denominación_10, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys("0.2").sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(secDelay);
        
	    File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo, new File(captura1));
        
        WebElement AceptarMsjInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarMsjInformativo.click();
                                      
        WebElement aceptarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
        aceptarPase.click();
        WebElement aceptarCreacionPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));           
        aceptarCreacionPase.click();
       
        
        // Crear Pases 2 Dolar - Cierre
        
        Thread.sleep(secDelay);
        
        WebElement CrearPaseCierreDolar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    CrearPaseCierreDolar.click();
	    
	    WebElement desplegarDivisaTaquilla2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
        desplegarDivisaTaquilla2.click();
        WebElement seleccionarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
        seleccionarDivisa2.click();
        Thread.sleep(secDelay);
        WebElement desplegarTaquilla2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
        desplegarTaquilla2.click();
        Thread.sleep(secDelay);
        WebElement seleccionarTaquilla2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 1']")));
        seleccionarTaquilla2.click();
        Thread.sleep(secDelay);
        WebElement desplegarModalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
        desplegarModalidad2.click();
        WebElement seleccionarModalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal']")));
        seleccionarModalidad2.click();
        Thread.sleep(secDelay);
        WebElement desplegarTipoPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
        desplegarTipoPase2.click();
        WebElement seleccionarTipoPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase de Caja a Boveda']")));
        seleccionarTipoPase2.click();
        Thread.sleep(secDelay);
       
        WebElement elementoCantidadTaquilla2 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); //En 2.6 es 1163 y en 2.5 es 1161
        Actions Taquilla2 = new Actions(driver);
        Taquilla2.doubleClick(elementoCantidadTaquilla2).perform();	
	           	
        WebElement elementoColocarCantidad2 = driver.findElement(By.id("textfield-1086-inputEl"));
        if (elementoColocarCantidad2.isEnabled()) {
        	Actions actions5 = new Actions(driver);
         	actions5.click(elementoColocarCantidad2).sendKeys("2").sendKeys(Keys.ENTER).perform();
         	Thread.sleep(secDelay);
        }
        
        WebElement Denominación_50_2 = driver.findElement(By.xpath("//div[text()='50,000']"));
        
        Actions actions5 = new Actions(driver);
            
        actions5.moveToElement(Denominación_50_2).perform();

        Denominación_50_2.click(); 	
        
        actions5.sendKeys(Denominación_50_2, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys("3").sendKeys(Keys.ENTER).build().perform();
        
        WebElement Denominación_20_2 = driver.findElement(By.xpath("//div[text()='20,000']"));
        
        Actions actions6 = new Actions(driver);
            
        actions6.moveToElement(Denominación_20_2).perform();

        Denominación_20_2.click(); 	
        
        actions6.sendKeys(Denominación_20_2, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys("4").sendKeys(Keys.ENTER).build().perform();
        
        WebElement Denominación_10_2 = driver.findElement(By.xpath("//div[text()='10,000']"));
        
        Actions actions7 = new Actions(driver);
            
        actions7.moveToElement(Denominación_10_2).perform();

        Denominación_10_2.click(); 	
        
        actions7.sendKeys(Denominación_10_2, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys(",-#$/=").sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(secDelay);
                                                   
        WebElement aceptarPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
        aceptarPase2.click();
        WebElement aceptarCreacionPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));           
        aceptarCreacionPase2.click();
	    
        driver.navigate().refresh();
        
        // Crear Pases 3 - Bolivar Soberano
               	    
	    WebElement CrearPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    CrearPase2.click();

	    WebElement desplegarDivisaTaquilla3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
        desplegarDivisaTaquilla3.click();
        WebElement seleccionarDivisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bolívar Soberano']")));
        seleccionarDivisa3.click();
        WebElement desplegarTaquilla3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
        desplegarTaquilla3.click();
        WebElement seleccionarTaquilla3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 2']")));
        seleccionarTaquilla3.click();
        Thread.sleep(secDelay);
        WebElement desplegarModalidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
        desplegarModalidad3.click();
        WebElement seleccionarModalidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal']")));
        seleccionarModalidad3.click();
        Thread.sleep(secDelay);
        WebElement desplegarTipoPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
        desplegarTipoPase3.click();
        WebElement seleccionarTipoPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase de Caja a Boveda']")));
        seleccionarTipoPase3.click();
        Thread.sleep(secDelay);
      
        WebElement elementoCantidadTaquilla3 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); //En 2.6 es 1163 y en 2.5 es 1161
        Actions Taquilla3 = new Actions(driver);
        Taquilla3.doubleClick(elementoCantidadTaquilla3).perform();	
	           	
        WebElement elementoColocarCantidad3 = driver.findElement(By.id("textfield-1086-inputEl"));
        if (elementoColocarCantidad3.isEnabled()) {
        	Actions actions8 = new Actions(driver);
         	actions8.click(elementoColocarCantidad3).sendKeys("2").sendKeys(Keys.ENTER).perform();
         	Thread.sleep(secDelay);
        }
        
        WebElement Denominación_50_3 = driver.findElement(By.xpath("//div[text()='50,000']"));
        
        Actions actions8 = new Actions(driver);
            
        actions8.moveToElement(Denominación_50_3).perform();

        Denominación_50_3.click(); 	
        
        actions8.sendKeys(Denominación_50_3, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys("3").sendKeys(Keys.ENTER).build().perform();
        
        WebElement Denominación_20_3 = driver.findElement(By.xpath("//div[text()='20,000']"));
        
        Actions actions9 = new Actions(driver);
            
        actions9.moveToElement(Denominación_20_3).perform();

        Denominación_20_3.click(); 	
        
        actions9.sendKeys(Denominación_20_3, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys("4").sendKeys(Keys.ENTER).build().perform();
        
        WebElement Denominación_10_3 = driver.findElement(By.xpath("//div[text()='10,000']"));
        
        Actions actions10 = new Actions(driver);
            
        actions10.moveToElement(Denominación_10_3).perform();

        Denominación_10_3.click(); 	
        
        actions10.sendKeys(Denominación_10_3, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys(",-#$/=").sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(secDelay);
               
        WebElement aceptarPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
        aceptarPase3.click();
        WebElement aceptarCreacionPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));           
        aceptarCreacionPase3.click();
	    
        driver.navigate().refresh();
        
        // Crear Pases 2  Bolivar Soberano - cierre
        
	    js.executeScript("window.scrollBy(0,500)");
	    
        WebElement CrearPaseCierrePD = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    CrearPaseCierrePD.click();
	    
	    WebElement desplegarDivisaTaquilla4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
        desplegarDivisaTaquilla4.click();
        WebElement seleccionarDivisa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bolívar Soberano']")));
        seleccionarDivisa4.click();
        WebElement desplegarTaquilla4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
        desplegarTaquilla4.click();
        WebElement seleccionarTaquilla4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 2']")));
        seleccionarTaquilla4.click();
        Thread.sleep(secDelay);
        WebElement desplegarModalidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
        desplegarModalidad4.click();
        WebElement seleccionarModalidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cierre']")));
        seleccionarModalidad4.click();
        Thread.sleep(secDelay);
      
        WebElement elementoCantidadTaquilla4 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); //En 2.6 es 1163 y en 2.5 es 1161
        Actions TaquillaCierre = new Actions(driver);
        TaquillaCierre.doubleClick(elementoCantidadTaquilla4).perform();	
	           	
        WebElement elementoColocarCantidad4 = driver.findElement(By.id("textfield-1084-inputEl"));
        if (elementoColocarCantidad4.isEnabled()) {
        	Actions actions11 = new Actions(driver);
         	actions11.click(elementoColocarCantidad4).sendKeys("2").sendKeys(Keys.ENTER).perform();
         	Thread.sleep(secDelay);
        }
        
        WebElement Denominación_50_4 = driver.findElement(By.xpath("//div[text()='50,000']"));
        
        Actions actions4 = new Actions(driver);
            
        actions4.moveToElement(Denominación_50_4).perform();

        Denominación_50_4.click(); 	
        
        actions4.sendKeys(Denominación_50_4, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys("3").sendKeys(Keys.ENTER).build().perform();
        
        WebElement Denominación_20_4 = driver.findElement(By.xpath("//div[text()='20,000']"));
        
        Actions actions12 = new Actions(driver);
            
        actions12.moveToElement(Denominación_20_4).perform();

        Denominación_20_4.click(); 	
        
        actions12.sendKeys(Denominación_20_4, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys("4").sendKeys(Keys.ENTER).build().perform();
        
        WebElement Denominación_10_4 = driver.findElement(By.xpath("//div[text()='10,000']"));
        
        Actions actions13 = new Actions(driver);
            
        actions13.moveToElement(Denominación_10_4).perform();

        Denominación_10_4.click(); 	
        
        actions13.sendKeys(Denominación_10_4, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys(",-#$/=").sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(secDelay);
               
        WebElement aceptarPase4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
        aceptarPase4.click();
        WebElement aceptarCreacionPase4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));           
        aceptarCreacionPase4.click();
                
		
	}
}