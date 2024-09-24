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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constantes.Constante_PreCalidad;
import DataDrivenTesting.ReadExcelFile;
import DataDrivenTesting.WriteExcelFile;

public class Cases_455 {
	
	int secDelay = 2000;
	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
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
		
		driver.get("http://192.168.2.214:8901/Central/");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InterruptedException {
		
		// ---------- Parametro Pases Monedas Permitidas Taquilla ----------

		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String ventanaParametrosGenerales = "http://192.168.2.214:8901/Central/parametrosCentral.action";
		String ventanaAgencia = "http://192.168.2.214:8901/Agencia/";
		
		String directorioCapturas = "C:/Users/gsarmiento/Desktop/Cases Integrales - Automatización/Cases 455";
		
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
		
	 	String nombreArchivo3 = "3.png";
	 	String captura3 = directorioCapturas + "/" + nombreArchivo3;
	 	
	 	String nombreArchivo4 = "4.png";
	 	String captura4 = directorioCapturas + "/" + nombreArchivo4;
	 	
	 	String nombreArchivo5 = "5.png";
	 	String captura5 = directorioCapturas + "/" + nombreArchivo5;
	 	
	 	String nombreArchivo6 = "6.png";
	 	String captura6 = directorioCapturas + "/" + nombreArchivo6;
	 	
	 	String nombreArchivo7 = "7.png";
	 	String captura7 = directorioCapturas + "/" + nombreArchivo7;
	 	
	 	String nombreArchivo8 = "8.png";
	 	String captura8 = directorioCapturas + "/" + nombreArchivo8;

		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    login.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);	
	    WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enter.click();
	    
	    // 1-Divisas en el sistemas
	    
	    WebElement configuración = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
	    configuración.click();
	    WebElement Billetes_Momedas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billetesMonedas")));
	    Billetes_Momedas.click();
	    WebElement divisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Divisa")));
	    divisas.click();
	    Thread.sleep(secDelay);	
	    
	    File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo, new File(captura1));       
        Thread.sleep(secDelay);	
        
        // 2-Parametros
        
        js.executeScript("window.open(arguments[0]);", ventanaParametrosGenerales);	  
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	    String Envios = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(Envios);	 
	    	    
	    WebElement modificables = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-1026")));
	    modificables.click(); 	    
	    WebElement selectParametro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PASES_MONEDAS_PERMITIDAS_TAQUI']")));
	    selectParametro.click(); 
	    
	    WebElement modificar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	    modificar.click(); 	 
	    Thread.sleep(secDelay);	
	    File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));    	    
	    WebElement modificarValor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    Thread.sleep(secDelay);
	    String Valor = modificarValor.getAttribute("value");
	    Thread.sleep(secDelay);	    
	    System.out.println(Valor);
	    modificarValor.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
	    modificarValor.sendKeys("3");   
	    
	    File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo3, new File(captura3));    
        
        WebElement aceptarModificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnWrap")));
	    aceptarModificación.click(); 	    
	    WebElement aceptarMensajeConfirmación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	    aceptarMensajeConfirmación.click(); 
	    WebElement aceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    aceptarMensajeInformativo.click(); 
	    
	    // 4-Agencia
		
	    js.executeScript("window.open(arguments[0]);", ventanaAgencia);	  
	    
	    Set<String> handles2 = driver.getWindowHandles();
	    
	    String Agencia = (String) handles2.toArray()[handles2.size() - 1];
	    driver.switchTo().window(Agencia);	
	    
	    Thread.sleep(secDelay);	
	    WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);	
	    WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterAgencia.click();
	    	    
	    WebElement caja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
	    caja.click();
	    WebElement pasesBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
	    pasesBoveda.click();
	    
	    WebElement desplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
	    desplegarDivisa.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo4, new File(captura4));    
        
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
	    
	    js1.executeScript("window.scrollBy(0,500)");
        
	    WebElement crear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    crear.click();
	    WebElement desplegarDivisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
	    desplegarDivisas.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo5, new File(captura5)); 
        
        Thread.sleep(secDelay);
        WebElement cancelar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnWrap")));
        cancelar.click();
        
        // 5- Regresar Parametros
        
	    String volverParametros = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(volverParametros);	
	    
	    WebElement selectParametro2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PASES_MONEDAS_PERMITIDAS_TAQUI']")));
	    selectParametro2.click(); 
	    
	    WebElement modificar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	    modificar2.click(); 	 
	    Thread.sleep(secDelay);	
	       
	    WebElement regresarValor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    Thread.sleep(secDelay);
	    String Valor2 = regresarValor.getAttribute("value");
	    Thread.sleep(secDelay);	    
	    System.out.println(Valor2);
	    regresarValor.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
	    regresarValor.sendKeys(Valor);   
        
	    File archivo6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo6, new File(captura6));
        
	    Thread.sleep(secDelay);	   
        WebElement aceptarModificación2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnWrap")));
	    aceptarModificación2.click(); 	    
	    WebElement aceptarMensajeConfirmación2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	    aceptarMensajeConfirmación2.click(); 
	    WebElement aceptarMensajeInformativo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    aceptarMensajeInformativo2.click(); 
	    
	    String volverAgencia = (String) handles2.toArray()[handles2.size() - 1];
	    driver.switchTo().window(volverAgencia);	
	    
	    driver.navigate().refresh();
	    
	    WebElement desplegarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
	    desplegarDivisa2.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo7, new File(captura7));    
        
        JavascriptExecutor js11 = (JavascriptExecutor)driver;
	    
	    js11.executeScript("window.scrollBy(0,500)");
        
	    WebElement crear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    crear2.click();
	    WebElement desplegarDivisas2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
	    desplegarDivisas2.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo8, new File(captura8)); 
        
        Thread.sleep(secDelay);
        WebElement cancelar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnWrap")));
        cancelar2.click();
	     
	}
}