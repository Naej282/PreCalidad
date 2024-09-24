package Integrales;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constantes.Constante_PreCalidad;
import DataDrivenTesting.ReadExcelFile;
import DataDrivenTesting.WriteExcelFile;

public class Cases_368 {
	
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
		
		// ---------- Parametro Generales Miles ES ----------
		
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constante_PreCalidad.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
		WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		enter.click();
				
		WebElement Configuracion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
        Configuracion.click();
        WebElement Generales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("generales")));
        Generales.click();
        WebElement ParametrosGenerales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("parametroGeneral")));
        ParametrosGenerales.click();
        WebElement modificables = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-1026")));
	    modificables.click(); 
            
        // Validar Parametro
	    
        WebElement selectParametro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PAIS_MONTO']")));
	    selectParametro.click(); 
	    
	    WebElement modificar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	    modificar.click(); 	 
	    Thread.sleep(secDelay);
	    WebElement modificarValor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    String Valor = modificarValor.getAttribute("value");
	    System.out.println(Valor);
	    
	    WebElement cerrarModificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1036-btnWrap")));
	    cerrarModificacion.click(); 
	    
	    WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	    Inicio.click(); 
	    
	    // Validacion Inventario Central
	    
	    WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
  	    Logistica.click();	    	     	  
	    WebElement InventarioEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventarioEfectivo")));
	    InventarioEfectivo.click(); 
	    Thread.sleep(secDelay);

	    WebElement desplegarTipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
  	    desplegarTipoUnidad.click();	
  	    WebElement seleccionarTipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agencia']")));
	    seleccionarTipoUnidad.click();	
	    Thread.sleep(secDelay);
	    
	    WebElement desplegarUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
  	    desplegarUnidad.click();	
  	    WebElement seleccionarUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1001-AG PA 2']")));
	    seleccionarUnidad.click();	
	    Thread.sleep(secDelay);

	    WebElement desplegarTipoBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoBoveda-trigger-picker")));
  	    desplegarTipoBoveda.click();	
  	    WebElement seleccionarTipoBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
	    seleccionarTipoBoveda.click();	
	    Thread.sleep(secDelay);

	    WebElement desplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
  	    desplegarDivisa.click();	
  	    WebElement seleccionarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	    seleccionarDivisa.click();	
	    
	    WebElement consultarInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    consultarInventario.click();	
	    
	    WebElement desplegarInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
	    desplegarInventario.click();
	    Thread.sleep(secDelay);
	    
	    // Imprimir Montos Disponible
	    
	    List<WebElement> MontoDisponible = driver.findElements(By.xpath("//td[@data-columnid='Monto Disponible']/div"));
  	      	    
  	  	for (int i =0; i<MontoDisponible.size();i++) {
  		  
  	  		System.out.println(MontoDisponible.get(i).getText());
  		    		  
  	  	}
  	    
  	  	WebElement Inicio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	    Inicio2.click();
	    
  	  	// Validar Indicadores de Gestion
  	    	  
	    WebElement Consulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/consultas.jpg']")));
  	    Consulta.click();
  	    WebElement IndicadoresGestion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("indicadoresGestion")));
	    IndicadoresGestion.click();
	    Thread.sleep(secDelay);
	    
	    // Imprimir Montos (expresado en Divisa)
	    
	    List<WebElement> Monto = driver.findElements(By.xpath("//td[@data-columnid='gridcolumn-1012']/div"));
  	      	    
  	  	for (int i =0; i<Monto.size();i++) {
  		  
  	  		System.out.println(Monto.get(i).getText());
  		    		  
  	  	}
  	    
  	  
  		driver.get("http://192.168.2.214:8901/Agencia/");
  	  	
  		WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
		WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA);
		WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		enterAgencia.click();
		
		// Validar Inventario Agencia
		
		WebElement CuadreAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
		CuadreAgencia.click();
		WebElement Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
		Inventario.click();
		Thread.sleep(secDelay);
		
		WebElement desplegarTipoBovedaAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
		desplegarTipoBovedaAgencia.click();
		WebElement seleccionarTipoBovedaAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
		seleccionarTipoBovedaAgencia.click();
		Thread.sleep(secDelay);
		
		WebElement desplegarDivisaAgemcia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		desplegarDivisaAgemcia.click();
		WebElement seleccionarDivisaAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		seleccionarDivisaAgencia.click();
		
		WebElement ConsultarInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
		ConsultarInventario.click();
		
		WebElement desplegarInventarioAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
		desplegarInventarioAgencia.click();
		Thread.sleep(secDelay);
		
		// Imprimir Montos Disponible
	    
	    List<WebElement> MontoDisponibleAgencia = driver.findElements(By.xpath("//td[@data-columnid='Monto Disponible']/div"));
  	      	    
  	  	for (int i =0; i<MontoDisponibleAgencia.size();i++) {
  		  
  	  		System.out.println(MontoDisponibleAgencia.get(i).getText());
  		    		  
  	  	}
		 
		 		
	}
}
