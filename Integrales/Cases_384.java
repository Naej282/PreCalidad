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

public class Cases_384 {
	
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
		
		// ---------- Ajuste Inventario Faltante en Agencia ----------
		
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		 	
		String Agencia = "http://192.168.2.214:8901/Agencia/";
		
		String directorioCapturas = "C:/Users/gsarmiento/Desktop/Cases Integrales - Automatización/Cases 384";
		
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
	 	
	 	String nombreArchivo3 = "3.png";
	 	String captura3 = directorioCapturas + "/" + nombreArchivo3;
	 	
	 	String nombreArchivo4 = "4.png";
	 	String captura4 = directorioCapturas + "/" + nombreArchivo4;
	 	
	 	String nombreArchivo55 = "5.png";
	 	String captura5 = directorioCapturas + "/" + nombreArchivo55;
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    login.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enter.click();
	    
	    WebElement logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
        logistica.click();
	    WebElement inventarioEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventarioEfectivo")));
        inventarioEfectivo.click();
        
        Thread.sleep(secDelay);
        WebElement desplegarTipoUnidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
  	    desplegarTipoUnidad1.click();
  	    Thread.sleep(secDelay);
  	    WebElement seleccionarTipoUnidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agencia']")));
  	    seleccionarTipoUnidad1.click();
  	 	Thread.sleep(secDelay);
  	    WebElement desplegarUnidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
        desplegarUnidad1.click();
        Thread.sleep(secDelay);
  	    WebElement seleccionarUnidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1001-AG PA 2']")));
  	    seleccionarUnidad1.click();
  	    Thread.sleep(secDelay);
  	    WebElement desplegarBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoBoveda-trigger-picker")));
  	    desplegarBoveda.click();
  	    Thread.sleep(secDelay);
  	    WebElement seleccionarBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
  	    seleccionarBoveda.click();
  	    WebElement desplegaDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
  	    desplegaDivisa.click();
  	    Thread.sleep(secDelay);
  	    WebElement seleccionarDivisa1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item'][text()='Dólar']")));
  	    seleccionarDivisa1.click();
  	    WebElement consultarInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
  	    consultarInventario.click();
  	    WebElement desplegarConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
  	    desplegarConsulta.click();
  	    
  	    Thread.sleep(secDelay);
	    File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo, new File(captura1));    
        Thread.sleep(secDelay);
        
        // Cambio Agencia
        
        js.executeScript("window.open(arguments[0]);", Agencia);	  
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	    String Agencia1 = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(Agencia1);
	    
		WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterAgencia.click();
	    
	    WebElement cuadreAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
	    cuadreAgencia.click();
	    WebElement iventarioAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
	    iventarioAgencia.click();
	    
 	    Thread.sleep(secDelay);
	    WebElement desplegarBoveda1Agencia= ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
	    desplegarBoveda1Agencia.click();
  	    Thread.sleep(secDelay);
  	    WebElement seleccionarBovedaAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
  	    seleccionarBovedaAgencia.click();
  	    WebElement desplegaDivisaAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
  	    desplegaDivisaAgencia.click();
  	    Thread.sleep(secDelay);
  	    WebElement seleccionarDivisaAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item'][text()='Dólar']")));
  	    seleccionarDivisaAgencia.click();
  	    WebElement consultarInventarioAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
  	    consultarInventarioAgencia.click();
  	    WebElement desplegarConsultaAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
  	    desplegarConsultaAgencia.click();
  	    Thread.sleep(secDelay);
  	      	    
	    File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));     	
        
        String Central = (String) handles.toArray()[handles.size() - 2];
	    driver.switchTo().window(Central);
				
	    Thread.sleep(secDelay);
        WebElement ajustarInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajusteInventario-btnWrap")));
  	    ajustarInventario.click();
  	    
  	    // Ajuste Faltante
  	    	     	    
  	    WebElement desplegarDenominaciónFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
 	    desplegarDenominaciónFaltante.click();
 	    WebElement seleccionarDenominaciónFaltante1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BILLETES - 100,000']")));
	    seleccionarDenominaciónFaltante1.click();
	    WebElement desplegarClasificacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
 	    desplegarClasificacionFaltante.click();
 	    WebElement seleccionarClasificaciónFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
	    seleccionarClasificaciónFaltante.click();
	    WebElement colocarCantidadFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantesAjuste-inputEl")));
	    colocarCantidadFaltante.sendKeys("1");
	    WebElement incluirFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirAjuste1Ajuste-btnWrap")));
	    incluirFaltante.click();   
	    
	    Thread.sleep(secDelay);
	    File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo3, new File(captura3));    
  	    Thread.sleep(secDelay);
  	    
  	    WebElement aceptarAjusteBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAjuste-btnWrap")));
	    aceptarAjusteBoveda.click();
	    WebElement aceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    aceptarMensajeInformativo.click();
	    
	    Thread.sleep(secDelay);
	    File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo4, new File(captura4));    
  	    Thread.sleep(secDelay);
	    
  	 	WebElement botonImprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
	    botonImprimir.click();
	 	WebElement desplegarFormmato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
	    desplegarFormmato.click();
	    WebElement seleccionarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
	    seleccionarFormato.click();
	    WebElement aceptarImprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1115-btnWrap")));
	    aceptarImprimir.click();
	    
        String Agencia2 = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(Agencia2);
	    Thread.sleep(secDelay);
	    
	    WebElement consultarAgencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    consultarAgencia2.click();
	    
	    Thread.sleep(secDelay);	    
	    File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo5, new File(captura5));    
  	    Thread.sleep(secDelay);
  	    
  	    WebElement botonImprimirAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
	    botonImprimirAgencia.click();
	 	WebElement desplegarFormmatoAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
	    desplegarFormmatoAgencia.click();
	    WebElement seleccionarFormatoAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
	    seleccionarFormatoAgencia.click();
	    WebElement aceptarImprimirAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1118-btnWrap")));
	    aceptarImprimirAgencia.click();
	    
	}
}