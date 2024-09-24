package Integrales;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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

public class Cases_358 {

	int secDelay = 1000;
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://192.168.2.214:8901/Agencia/");
		}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException, IOException {
		
		// ---------- Pase ATM a Boveda Normal ----------
		
		//guardar 
		
		String directorioCapturas = "C:\\Users\\gsarmiento\\Desktop\\Cases Integrales - Automatización\\Cases 358";
		
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
	 	
	 	String nombreArchivo9 = "7.png";
	 	String captura9 = directorioCapturas + "/" + nombreArchivo9;
		
				
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constante_PreCalidad.USUARIO);
		
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
			
		Thread.sleep(secDelay);
		
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();
			
		WebElement ATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
		ATM.click();
			
		WebElement EfectivoAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efectivo")));
		EfectivoAtm.click();
			
		Thread.sleep(secDelay);
			
		WebElement DesplegarAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmEfectivo-trigger-picker")));
		DesplegarAtm.click();
			
		Thread.sleep(secDelay);
			
		WebElement TipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1003-ATM PA 1']")));
		TipoUnidad.click();
			
		Thread.sleep(secDelay);
			
		WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		DesplegarDivisa.click();
			
		Thread.sleep(secDelay);
			
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		Divisa.click();
			
			Thread.sleep(secDelay);
			
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
		Consultar.click();
			
		Thread.sleep(secDelay);
		Thread.sleep(secDelay);
			
		// Capturar screenshot 1 y guardarlo en la carpeta
		
        File archivo1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo1, new File(captura1));	
       
	    Thread.sleep(secDelay);
	    Thread.sleep(secDelay);
        
        WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        Inicio.click();	
        	
    	WebElement ATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
		ATM2.click();
		
		WebElement PasesAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
		PasesAtm.click();
			
		Thread.sleep(secDelay);
			
		WebElement CrearPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		CrearPase.click();
			
		Thread.sleep(secDelay);
			
		WebElement DesplegarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
		DesplegarDivisa2.click();
			
		Thread.sleep(secDelay);
			
		WebElement Divisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		Divisa2.click();
			
		Thread.sleep(secDelay);
		Thread.sleep(secDelay);
			
		// Capturar screenshot 1 y guardarlo en la carpeta
		
        File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));	
       
	        Thread.sleep(secDelay);
	        Thread.sleep(secDelay);
			
		WebElement Cancelar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1055-btnInnerEl")));
			Cancelar.click();
			
			Thread.sleep(secDelay);
			
		WebElement Inicio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio2.click();
			
			Thread.sleep(secDelay);
		
		WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
			CuadreDeAgencia.click();
		
		WebElement Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
			Inventario.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarTipoDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
			DesplegarTipoDeBoveda.click();
			
			Thread.sleep(secDelay);
			
		WebElement TipoDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
			TipoDeBoveda.click();	
				
		WebElement DesplagarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			DesplagarDivisa.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa3.click();
			
		WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
			Consultar2.click();
			
			Thread.sleep(secDelay);
			
	    WebElement DesplegarMonto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
	    	DesplegarMonto.click();
	    
			Thread.sleep(secDelay);
			Thread.sleep(secDelay);
			
		// Capturar screenshot 1 y guardarlo en la carpeta
        File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo3, new File(captura3));	
       
	        Thread.sleep(secDelay);
	        Thread.sleep(secDelay);
	        
        WebElement Inicio3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio3.click();
			
			Thread.sleep(secDelay);
			
		WebElement ATM3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
			ATM3.click();
		
		WebElement PasesAtm2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			PasesAtm2.click();
			
			Thread.sleep(secDelay);
			
		WebElement CrearPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
			CrearPase2.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
			DesplegarDivisa3.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa4.click();
			
		WebElement DesplegarAtm2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmCP-trigger-picker")));
			DesplegarAtm2.click();	
			
			Thread.sleep(secDelay);

		WebElement Atm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1003-ATM PA 1']")));
			Atm.click();	
			
		WebElement DesplegarTipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
			DesplegarTipoPase.click();
			
			Thread.sleep(secDelay);

		WebElement TipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase Atm a Boveda Normal']")));
			TipoPase.click();
			
			Thread.sleep(secDelay);
			
		WebElement elementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1037']")); 
	    Actions doble = new Actions(driver);
	    doble.doubleClick(elementoCantidad).perform();
	    
	    	Thread.sleep(secDelay);
	    
	    List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
	
	    for (WebElement elemento : elementos) {
	        if (elemento.isEnabled()) {
	            Actions actions = new Actions(driver);
	            actions.click(elemento).sendKeys("1").sendKeys(Keys.ENTER).perform();
	        }
	    }
	    
	    	Thread.sleep(secDelay);
		 
	    WebElement AceptarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1054-btnInnerEl")));
	    	AceptarPase.click();
	    	
	    	Thread.sleep(secDelay);
	    
    	WebElement AceptarInformacionPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
	    	AceptarInformacionPase.click();
	    	
	    	Thread.sleep(secDelay);
	    	
    	//REPETIMOS CODIGO
	    	
    	WebElement Inicio4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio4.click();
			
			Thread.sleep(secDelay);
	    	
		WebElement CuadreDeAgencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
			CuadreDeAgencia2.click();
		
		WebElement Inventario2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
			Inventario2.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarTipoDeBoveda2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
			DesplegarTipoDeBoveda2.click();
			
			Thread.sleep(secDelay);
			
		WebElement TipoDeBoveda2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
			TipoDeBoveda2.click();	
				
		WebElement DesplagarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			DesplagarDivisa2.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa5.click();
			
		WebElement Consultar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
			Consultar3.click();
			
			Thread.sleep(secDelay);
			
			WebElement DesplegarMontos2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
			DesplegarMontos2.click();	
			
			Thread.sleep(secDelay);
			Thread.sleep(secDelay);
			
		// Capturar screenshot 1 y guardarlo en la carpeta
			
        File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo4, new File(captura4));	
       
	        Thread.sleep(secDelay);
	        Thread.sleep(secDelay);
	    	
        WebElement Inicio5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio5.click();	 
	        
        WebElement ATM4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
			ATM4.click();
			
		WebElement EfectivoAtm2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efectivo")));
			EfectivoAtm2.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarAtm3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmEfectivo-trigger-picker")));
			DesplegarAtm3.click();
			
			Thread.sleep(secDelay);
			
		WebElement TipoUnidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1003-ATM PA 1']")));
			TipoUnidad4.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			DesplegarDivisa4.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa6.click();
			
			Thread.sleep(secDelay);
			
		WebElement Consultar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
			Consultar4.click();
			
			Thread.sleep(secDelay);
			Thread.sleep(secDelay);
			
		// Capturar screenshot 1 y guardarlo en la carpeta
			
        File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo5, new File(captura5));	
       
	        Thread.sleep(secDelay);
	        Thread.sleep(secDelay);
        
        //FINALIZAMOS  
	    	
        WebElement Inicio6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio6.click();	 
	        
        WebElement ATM5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
			ATM5.click();
			
		WebElement PasesAtm3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			PasesAtm3.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisaPases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
			DesplegarDivisaPases.click();
			
			Thread.sleep(secDelay);
		   
		WebElement Divisa7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa7.click();
		
		WebElement DesplegarAtmPases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmPases-trigger-picker")));
			DesplegarAtmPases.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1003-ATM PA 1']")));
			Divisa8.click();
			
			Thread.sleep(secDelay);
			
		WebElement Consultar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
			Consultar5.click();
			
			Thread.sleep(secDelay);
			
		WebElement Estado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1012-titleEl")));
	    Actions doble3 = new Actions(driver);
	    doble3.doubleClick(Estado).perform();
	    
	    	Thread.sleep(secDelay);
			
		 WebElement Numero = driver.findElement(By.cssSelector("[data-columnid='numero']"));
		 	Numero.click();
		 	
		 	Thread.sleep(secDelay);
		
	 	WebElement Avanzar = driver.findElement(By.id("avanzarPase-btnInnerEl"));
	 		Avanzar.click();
	 		
 		WebElement AceptarAvanzar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1058-btnInnerEl")));
 			AceptarAvanzar.click();
 			
 			Thread.sleep(secDelay);
		
		WebElement AceptarInformacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
			AceptarInformacion.click();
 			
			//REPETIMOS CODIGO
	    	
    	WebElement Inicio7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio7.click();
			
			Thread.sleep(secDelay);
	    	
		WebElement CuadreDeAgencia3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
			CuadreDeAgencia3.click();
		
		WebElement Inventario3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
			Inventario3.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarTipoDeBoveda3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
			DesplegarTipoDeBoveda3.click();
			
			Thread.sleep(secDelay);
			
		WebElement TipoDeBoveda3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
			TipoDeBoveda3.click();	
				
		WebElement DesplagarDivisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			DesplagarDivisa3.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa9.click();
			
		WebElement Consultar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
			Consultar6.click();
			
			Thread.sleep(secDelay);
			
			WebElement DesplegarMontos3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
			DesplegarMontos3.click();	
			
			Thread.sleep(secDelay);
			Thread.sleep(secDelay);
			
		// Capturar screenshot 1 y guardarlo en la carpeta
        File archivo6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo6, new File(captura6));	
       
	        Thread.sleep(secDelay);
	        Thread.sleep(secDelay);
	    	
        WebElement Inicio8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio8.click();	 
	        
        WebElement ATM6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
			ATM6.click();
			
		WebElement EfectivoAtm3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efectivo")));
			EfectivoAtm3.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarAtm4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmEfectivo-trigger-picker")));
			DesplegarAtm4.click();
			
			Thread.sleep(secDelay);
			
		WebElement TipoUnidad5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1003-ATM PA 1']")));
			TipoUnidad5.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisa5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			DesplegarDivisa5.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa10.click();
			
			Thread.sleep(secDelay);
			
		WebElement Consultar7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
			Consultar7.click();
			
			Thread.sleep(secDelay);
			Thread.sleep(secDelay);
			
		// Capturar screenshot 1 y guardarlo en la carpeta
        File archivo7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo7, new File(captura7));	
       
	        Thread.sleep(secDelay);
	        Thread.sleep(secDelay);
	        
	        //FINALIZAMOS 
	        
        WebElement Inicio9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio9.click();	 
	        
        WebElement ATM7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
			ATM7.click();
			
		WebElement PasesAtm4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			PasesAtm4.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisaPases2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
			DesplegarDivisaPases2.click();
			
			Thread.sleep(secDelay);
		   
		WebElement Divisa11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa11.click();
		
		WebElement DesplegarAtmPases2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmPases-trigger-picker")));
			DesplegarAtmPases2.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1003-ATM PA 1']")));
			Divisa12.click();
			
			Thread.sleep(secDelay);
			
		WebElement Consultar8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
			Consultar8.click();
			
			Thread.sleep(secDelay);
			
		WebElement Estado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1012-titleEl")));
			Estado2.click();
	    
	    	Thread.sleep(secDelay);
			
		 WebElement Numero2 = driver.findElement(By.cssSelector("[data-columnid='numero']"));
		 	Numero2.click();
		 	
		 	Thread.sleep(secDelay);
		
	 	WebElement Avanzar2 = driver.findElement(By.id("avanzarPase-btnInnerEl"));
	 		Avanzar2.click();
	 		
 		WebElement AceptarAvanzar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1058-btnInnerEl")));
 			AceptarAvanzar2.click();
 			
 			Thread.sleep(secDelay);
		
		WebElement AceptarInformacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
			AceptarInformacion2.click();
 			
			//REPETIMOS CODIGO
	    	
    	WebElement Inicio10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio10.click();
			
			Thread.sleep(secDelay);
	    	
		WebElement CuadreDeAgencia4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
			CuadreDeAgencia4.click();
		
		WebElement Inventario4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
			Inventario4.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarTipoDeBoveda4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
			DesplegarTipoDeBoveda4.click();
			
			Thread.sleep(secDelay);
			
		WebElement TipoDeBoveda4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
			TipoDeBoveda4.click();	
				
		WebElement DesplagarDivisa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			DesplagarDivisa4.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa13 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa13.click();
			
		WebElement Consultar9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
			Consultar9.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarMontos4 =ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
			DesplegarMontos4.click();	
			
			Thread.sleep(secDelay);
			Thread.sleep(secDelay);
			
		// Capturar screenshot 1 y guardarlo en la carpeta
        File archivo8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo8, new File(captura8));	
       
	        Thread.sleep(secDelay);
	        Thread.sleep(secDelay);
	    	
        WebElement Inicio11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio11.click();	 
	        
        WebElement ATM8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
			ATM8.click();
			
		WebElement EfectivoAtm4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efectivo")));
			EfectivoAtm4.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarAtm5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmEfectivo-trigger-picker")));
			DesplegarAtm5.click();
			
			Thread.sleep(secDelay);
			
		WebElement TipoUnidad6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1003-ATM PA 1']")));
			TipoUnidad6.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisa6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			DesplegarDivisa6.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa14 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa14.click();
			
			Thread.sleep(secDelay);
			
		WebElement Consultar10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
			Consultar10.click();
			
			Thread.sleep(secDelay);
			Thread.sleep(secDelay);
			
		// Capturar screenshot 1 y guardarlo en la carpeta
        File archivo9 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo9, new File(captura9));	
       
	        Thread.sleep(secDelay);
	        Thread.sleep(secDelay);
	    	
        WebElement Inicio12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio12.click();
        	
    	WebElement CuadreDeAgencia5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    		CuadreDeAgencia5.click();
    		
		WebElement AsientosContables = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
			AsientosContables.click();
			
			 Thread.sleep(secDelay);
		
		 WebElement DesplegarDivisa7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		 	DesplegarDivisa7.click();
		 	
		 	Thread.sleep(secDelay);
		 	
	 	WebElement Divisa15 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa15.click();
			
		WebElement DesplegarDivisa8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		 	DesplegarDivisa8.click();
		 	
		 	Thread.sleep(secDelay);
		 	
	 	WebElement Divisa16 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
			Divisa16.click();	
		 	
			Thread.sleep(secDelay);
			
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnInnerEl")));
			Aceptar.click();
       	
	        //FINALIZAMOS  			
	}

}
