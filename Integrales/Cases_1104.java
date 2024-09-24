package Integrales;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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

public class Cases_1104 {
	
	int secDelay = 2000;
	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		
		driver.get("http://192.168.2.214:8901/Central/");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InterruptedException {
		
		// ---------- Cambiar Parametro Etiq Nro Servicio ----------
		
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String ventanaEnvio = "http://192.168.2.214:8901/Central/envioCentral.action";
		
		String directorioCapturas = "C:/Users/gsarmiento/Desktop/Cases Integrales - Automatización/Cases 1104";
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    login.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enter.click();
	    
	    WebElement configuración = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
	    configuración.click();
	    WebElement generales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("generales")));
	    generales.click();
	    WebElement parametrosGenerales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("parametroGeneral")));
	    parametrosGenerales.click(); 	    
	    WebElement modificables = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-1026")));
	    modificables.click(); 	    
	    
	    // Modificar Parametro
	    
	    WebElement selectParametro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='ETIQUETA_NRO_SERVICIO']")));
	    selectParametro.click(); 
	    
	    WebElement modificar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	    modificar.click(); 	 
	    WebElement modificarValor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    Thread.sleep(secDelay);
	    String Valor = modificarValor.getAttribute("value");
	    Thread.sleep(secDelay);	    
	    System.out.println(Valor);
	    modificarValor.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
	    modificarValor.sendKeys("Prueba");    
	    
	    File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo, new File(captura1));
	    
	    Thread.sleep(secDelay);	    
	    WebElement aceptarModificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnWrap")));
	    aceptarModificación.click(); 	    
	    WebElement aceptarMensajeConfirmación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	    aceptarMensajeConfirmación.click(); 
	    WebElement aceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    aceptarMensajeInformativo.click(); 
	    
	    // Envios
	    
	    js.executeScript("window.open(arguments[0]);", ventanaEnvio);	  
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	    String Envios = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(Envios);	 
	    
	    // Mover Cursor
	    
        WebElement campoCodigoRemesa = driver.findElement(By.id("gridcolumn-1079"));
        
        Actions actions = new Actions(driver);
        
        actions.moveToElement(campoCodigoRemesa).perform();

        campoCodigoRemesa.click();
	     	    
        File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));
	    
	    Thread.sleep(secDelay);	
	    
	    String parametros = (String) handles.toArray()[handles.size() - 2];
	    driver.switchTo().window(parametros);	
	    
	    WebElement selectParametro1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='ETIQUETA_NRO_SERVICIO']")));
	    selectParametro1.click(); 
	    WebElement modificar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	    modificar1.click(); 	 
	    WebElement modificarValor1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    Thread.sleep(secDelay);
	    String Valor1 = modificarValor1.getAttribute("value");
	    Thread.sleep(secDelay);	    
	    System.out.println(Valor1);
	    modificarValor1.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
	    modificarValor1.sendKeys(Valor);    
	    Thread.sleep(secDelay);	    
	    WebElement aceptarModificación1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnWrap")));
	    aceptarModificación1.click(); 	    
	    WebElement aceptarMensajeConfirmación1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	    aceptarMensajeConfirmación1.click(); 
	    WebElement aceptarMensajeInformativo1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    aceptarMensajeInformativo1.click(); 
	    
	    
	    
	    
	    
	    /*Thread.sleep(secDelay);	 
	    WebElement validarCampo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-ref='titleEl']")));
	    Thread.sleep(secDelay);	  
	    String ValorCampo = validarCampo.getAttribute("value");
	    System.out.println(ValorCampo); 
	    Thread.sleep(secDelay);	 */
	    
	 //   /span[@class='x-column-header-text']
	    	    	   		
	}
}