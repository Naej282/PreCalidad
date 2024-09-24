package Integrales;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

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

public class Cases_383 {
	
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
		
		// Ajuste Inventario Faltante CDA
		
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		 	
		String Agencia = "http://192.168.2.214:8901/Agencia/";
		
		String directorioCapturas = "C:/Users/gsarmiento/Desktop/Cases Integrales - Automatización/Cases 383";
		
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
	 	
	 	String nombreArchivo3 = "3.png";
	 	String captura3 = directorioCapturas + "/" + nombreArchivo3;
		
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
  	    WebElement seleccionarTipoUnidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Centro de Acopio']")));
  	    seleccionarTipoUnidad1.click();
  	 	Thread.sleep(secDelay);
  	    WebElement desplegarUnidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
        desplegarUnidad1.click();
        Thread.sleep(secDelay);
  	    WebElement seleccionarUnidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1105-CDA PA 3']")));
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
  	    
  	    // Ajuste Faltante
        
  	    
        WebElement AjustarInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajusteInventario-btnWrap")));
        AjustarInventario.click();  	    
        Thread.sleep(secDelay);
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
	    File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));    
  	    Thread.sleep(secDelay);
  	    
  	    WebElement aceptarAjusteBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAjuste-btnWrap")));
	    aceptarAjusteBoveda.click();
	    WebElement aceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    aceptarMensajeInformativo.click();
	    
	    Thread.sleep(secDelay);
	    File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo3, new File(captura3));    
  	    Thread.sleep(secDelay);
	    
  	 	WebElement botonImprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
	    botonImprimir.click();
	 	WebElement desplegarFormmato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
	    desplegarFormmato.click();
	    WebElement seleccionarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
	    seleccionarFormato.click();
	    WebElement aceptarImprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1115-btnWrap")));
	    aceptarImprimir.click();
	    
	    WebElement botonImprimir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
	    botonImprimir2.click();
	 	WebElement desplegarFormmato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
	    desplegarFormmato2.click();
	    WebElement seleccionarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
	    seleccionarFormato2.click();
	    WebElement aceptarImprimir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1115-btnWrap")));
	    aceptarImprimir2.click();
	    	    
	}
}
