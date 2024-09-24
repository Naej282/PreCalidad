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

public class Cases_355 {
	
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
		
		driver.get("http://192.168.2.214:8901/Central/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InterruptedException {
	
			// ---------- Flujo Pase WF ----------
	
			WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			String Agencia = "http://192.168.2.214:8901/Agencia/";
			String Central = "http://192.168.2.214:8901/Central/";
			
			String directorioCapturas = "C:/Users/gsarmiento/Desktop/Cases Integrales - Automatización/Cases 355";
			
		 	String nombreArchivo1 = "ValorParametro.png";
		 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
		 	
		 	String nombreArchivo2 = "PaseConfirmado.png";
		 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
		 	
		 	String nombreArchivo3 = "CambioParametro_0.png";
		 	String captura3 = directorioCapturas + "/" + nombreArchivo3;
		 	
		 	String nombreArchivo4 = "PaseSolicitado.png";
		 	String captura4 = directorioCapturas + "/" + nombreArchivo4;
		 	
		 	String nombreArchivo5 = "CambioParametro_1.png";
		 	String captura5 = directorioCapturas + "/" + nombreArchivo5;
			
			WebElement loginCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		    loginCentral.sendKeys(Constante_PreCalidad.USUARIO);
		    WebElement passwordCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		    passwordCentral.sendKeys(Constante_PreCalidad.CONTRASEÑA);
		    Thread.sleep(secDelay);
		    WebElement enterCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		    enterCentral.click();
		    
		    WebElement configuración = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
		    configuración.click();
	        WebElement Generales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("generales")));
	        Generales.click();
	        WebElement ParametrosGenerales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("parametroGeneral")));
	        ParametrosGenerales.click();
	        WebElement Modificables = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-1026-btnWrap")));
	        Modificables.click();
	        
	        // Configurar Parametro
	        
	        WebElement Presolicitud = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PASE_WF']")));
	        Presolicitud.click();
	        WebElement ModificarPresolicitud = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	        ModificarPresolicitud.click();
		    Thread.sleep(secDelay);
		    
		    File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo, new File(captura1));
		    
		    /*WebElement AceptarModificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnWrap")));
	        AceptarModificación.click();
	        WebElement ConfirmarModificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	        ConfirmarModificación.click();
	        WebElement AceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	        AceptarMensajeInformativo.click();*/
	        
	        // Cambio Agencia - Pases
	        
	        js.executeScript("window.open(arguments[0]);", Agencia);	  
		    
		    Set<String> handles = driver.getWindowHandles();
		    
		    String ModuloAgencia = (String) handles.toArray()[handles.size() - 1];
		    driver.switchTo().window(ModuloAgencia);	 
	        
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
	        
		    // Crear Pases - Confirmado
		    
		    JavascriptExecutor js1 = (JavascriptExecutor)driver;
		    
		    js1.executeScript("window.scrollBy(0,500)");
		    
		    WebElement CrearPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		    CrearPase.click();

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
	        
	        WebElement aceptarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
	        aceptarPase.click();
	        WebElement aceptarCreacionPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	        aceptarCreacionPase.click();
	        
		    File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo2, new File(captura2));
	        
	        // Volver a Central - Parametro
	        
	        String VolveCentral = (String) handles.toArray()[handles.size() - 2];
		    driver.switchTo().window(VolveCentral);
	        
		    WebElement ModificarValor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
		    Thread.sleep(secDelay);
		    String Valor = ModificarValor.getAttribute("value");
		    Thread.sleep(secDelay);	    
		    System.out.println(Valor);
		    ModificarValor.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
		    ModificarValor.sendKeys("0"); 
		    
		    File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo3, new File(captura3));
		    
		    WebElement AceptarModificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnWrap")));
	        AceptarModificación.click();
	        WebElement ConfirmarModificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	        ConfirmarModificación.click();
	        WebElement AceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	        AceptarMensajeInformativo.click();
	        
	        // Volver a Agencia - Pase Solicitado
	        
	        String VolveAgencia = (String) handles.toArray()[handles.size() - 1];
		    driver.switchTo().window(VolveAgencia);
		   	    
		    WebElement CrearPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		    CrearPase2.click();

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
	        	Actions actions = new Actions(driver);
	         	actions.click(elementoColocarCantidad2).sendKeys("2").sendKeys(Keys.ENTER).perform();
	         	Thread.sleep(secDelay);
	        }
	        
	        WebElement aceptarPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
	        aceptarPase2.click();
	        WebElement aceptarCreacionPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	        aceptarCreacionPase2.click();
	        
		    File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo4, new File(captura4));
	        
	        // Volver a Central - Parametro
	        
	        String VolveCentral2 = (String) handles.toArray()[handles.size() - 2];
		    driver.switchTo().window(VolveCentral2);
		    
		    WebElement Presolicitud2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PASE_WF']")));
	        Presolicitud2.click();
	        WebElement ModificarPresolicitud2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	        ModificarPresolicitud2.click();
		    Thread.sleep(secDelay);
	        
		    WebElement ModificarValor2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
		    Thread.sleep(secDelay);	    
		    ModificarValor2.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
		    ModificarValor2.sendKeys(Valor); 
		    Thread.sleep(secDelay);
		    
		    File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo5, new File(captura5));
		    
		    WebElement AceptarModificación2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnWrap")));
	        AceptarModificación2.click();
	        WebElement ConfirmarModificación2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	        ConfirmarModificación2.click();
	        WebElement AceptarMensajeInformativo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	        AceptarMensajeInformativo2.click();
	        
	}
}