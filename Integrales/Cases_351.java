package Integrales;

import java.io.File;
import java.io.IOException;
import java.util.List;
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

public class Cases_351 {

	int secDelay = 1000;

	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://192.168.2.214:8901/Central/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException, IOException {
			
		//guardar 
		
		String directorioCapturas = "C:\\Users\\gsarmiento\\Desktop\\Cases Integrales - Automatización\\Cases 351";
		
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
	 	
	 	String nombreArchivo9 = "9.png";
	 	String captura9 = directorioCapturas + "/" + nombreArchivo9;
	 	
		String nombreArchivo10 = "10.png";
	 	String captura10 = directorioCapturas + "/" + nombreArchivo10;
	 	
	 	String nombreArchivo11 = "11.png";
	 	String captura11 = directorioCapturas + "/" + nombreArchivo11;
	 	
	 	String nombreArchivo12 = "12.png";
	 	String captura12 = directorioCapturas + "/" + nombreArchivo12;
		
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		 // Abrir central
        
    	
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
			login.sendKeys(Constante_PreCalidad.USUARIO);
		
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
			
			Thread.sleep(secDelay);
		
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
			logear.click();
			
			Thread.sleep(secDelay);
			
		WebElement Configuracion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
			Configuracion.click();
			
			Thread.sleep(secDelay);
			
		WebElement Generales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("generales")));
			Generales.click();
			
			Thread.sleep(secDelay);
			
		WebElement ParametroGeneral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("parametroGeneral")));
			ParametroGeneral.click();
			
			 WebElement modificables = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-1026")));
	         modificables.click();
	         
	        Thread.sleep(secDelay); 
	     	Thread.sleep(secDelay);
	     	
		    WebElement selectParametro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PASE_WF']")));
		    selectParametro.click(); 
	         
		WebElement ModificarParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
			ModificarParametroWF.click();
				
		WebElement ValorParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    Actions doble = new Actions(driver);
	    doble.doubleClick(ValorParametroWF).perform();	
			ValorParametroWF.sendKeys("0");
		
		WebElement AceptarModificarParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnInnerEl")));
			AceptarModificarParametroWF.click();
				
		WebElement ConfirmarModificarParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnEl")));
			ConfirmarModificarParametroWF.click();	
			
		WebElement AceptarMensajeParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
			AceptarMensajeParametroWF.click();
			
			Thread.sleep(secDelay);
			
		WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio.click();
						
		WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
			Logistica.click();
			
			Thread.sleep(secDelay);		
			
		WebElement InventarioEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventarioEfectivo")));
			InventarioEfectivo.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarTipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
			DesplegarTipoUnidad.click();
			
			Thread.sleep(secDelay);
			
		WebElement TipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agencia']")));
			TipoUnidad.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
			DesplegarUnidad.click();
			
			Thread.sleep(secDelay);
			
		WebElement Unidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1001-AG PA 2']")));
			Unidad.click();	
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarTipoBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoBoveda-trigger-picker")));
			DesplegarTipoBoveda.click();
			
			Thread.sleep(secDelay);
			
		WebElement TipoBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
			TipoBoveda.click();	
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			DesplegarDivisa.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa.click();
			
			Thread.sleep(secDelay);
			
		WebElement Colsultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
			Colsultar.click();
			
			Thread.sleep(secDelay);
			
		WebElement Desplegar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridview-1018")));
			Desplegar.click();
			

	        Thread.sleep(secDelay);
	        Thread.sleep(secDelay);
        
        
     // Capturar screenshot 1 y guardarlo en la carpeta
        File archivo1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo1, new File(captura1));
        
	        Thread.sleep(secDelay);
	        Thread.sleep(secDelay);
			
     // Abrir una nueva pestaña para agencia
        ((JavascriptExecutor)driver).executeScript("window.open()");

        String secondTab2 = driver.getWindowHandles().stream().skip(1).findFirst().get();
        driver.switchTo().window(secondTab2);
        
        driver.get("http://192.168.2.214:8901/Agencia/");
        
		//ingresar en el ambiente			
		
		WebElement login2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
			login2.sendKeys(Constante_PreCalidad.USUARIO);
		
		WebElement password2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			password2.sendKeys(Constante_PreCalidad.CONTRASEÑA);
			
			Thread.sleep(secDelay);
		
		WebElement logear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
			logear2.click();
			
			Thread.sleep(secDelay);
		
		//Ingresar en el apartado para crear el pase
		
		WebElement IngresarEnCaja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
			IngresarEnCaja.click();	
		
		WebElement IngresarPasesDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			IngresarPasesDeBoveda.click();
		
		WebElement OpcionCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
			OpcionCrear.click();
			
			Thread.sleep(secDelay);
			
		WebElement DespDivisa= ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
			DespDivisa.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa2.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarCaja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
			DesplegarCaja.click();
			
		WebElement Caja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 1']")));
			Caja.click();
			
			Thread.sleep(secDelay);
			
		WebElement DespModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
		    DespModalidad.click();

		    Thread.sleep(secDelay);
			
		WebElement Modalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal']")));
			Modalidad.click();
			
			Thread.sleep(secDelay);	
			
		WebElement DesplegarTipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
			DesplegarTipoPase.click();
			
			Thread.sleep(secDelay);	
			
		WebElement TipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase de Caja a Boveda']")));
			TipoPase.click();
		
		Thread.sleep(secDelay);	
			
		WebElement elementoCantidad100 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); 
	    Actions doble2 = new Actions(driver);
	    doble2.doubleClick(elementoCantidad100).perform();
	    
	    Thread.sleep(secDelay);
	    
	    List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
	
	    for (WebElement elemento : elementos) {
	        if (elemento.isEnabled()) {
	            Actions actions = new Actions(driver);
	            actions.click(elemento).sendKeys("1").sendKeys(Keys.ENTER).perform();
	        }
	    }
	
		WebElement AceptarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
		    AceptarPase.click();
		    
		    Thread.sleep(secDelay);
		    
		WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
		    ConfirmarAceptar.click();
		    
		    Thread.sleep(secDelay); 
		    
//			INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
		
			Set<String> handles = driver.getWindowHandles();
			
		// Iterar sobre los identificadores
        for (String handle : handles) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Central");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Agencia");
            }
            
        }
       		Thread.sleep(secDelay); 
        	
    	WebElement ConsultarInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
    		ConsultarInventario.click();

        	// Tomar la captura de pantalla después de que el elemento esté presente
        	File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo2, new File(captura2));
        	
        	Thread.sleep(secDelay); 
        	Thread.sleep(secDelay); 
        
//			INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
				
		Set<String> handles1 = driver.getWindowHandles();
		
		// Iterar sobre los identificadores
        for (String handle1 : handles1) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Agencia");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle1);
                System.out.println("Estás en la página de Central");
            }
            
        }
	            
        WebElement Inicio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio2.click();
        	
        	 Thread.sleep(secDelay);
        	
    	WebElement Cuadre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    		Cuadre.click();
    		
    		 Thread.sleep(secDelay);
    		
		WebElement AsientosContables = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
			AsientosContables.click();
			
			 Thread.sleep(secDelay);
			 
		 WebElement DesplegarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		 	DesplegarDivisa2.click();
		 	
		 	 Thread.sleep(secDelay);
		 	
	 	WebElement Divisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	 		Divisa3.click();
	 		
	 	WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
 			DesplegarFormato.click();
 			
		WebElement Formato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
			Formato.click();
 			
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
			Aceptar.click();
			
			 Thread.sleep(secDelay);
	
		 try {
			 
			 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
		    	Retro.click();
			    
			} catch (Exception e2) {
				 
				try {
					    driver.navigate().back();
					    
					    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
				    		Retro.click();
					    
					} catch (Exception e) {
						
					    e.printStackTrace();
					}
			}
	    	
	    	Thread.sleep(secDelay);
	    	
    	WebElement IngresarEnCaja2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
			IngresarEnCaja2.click();
			
			Thread.sleep(secDelay);
		
		WebElement IngresarPasesDeBoveda2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			IngresarPasesDeBoveda2.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisaConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
			DesplegarDivisaConsulta.click();
			
			Thread.sleep(secDelay);
			
		WebElement DivisaConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			DivisaConsulta.click();
			
		WebElement Consulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
			Consulta.click();
			
			Thread.sleep(secDelay);
			
		WebElement Estado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1013-titleEl")));
	    Actions doble3 = new Actions(driver);
	    doble3.doubleClick(Estado).perform();
			
		 WebElement SeleccionarElemento = driver.findElement(By.xpath("//*[@data-columnid='gridcolumn-1012']"));
		 	SeleccionarElemento.click();
		 	
		 	Thread.sleep(secDelay);
			
	 	WebElement Avanzar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarPase-btnEl")));
	 		Avanzar.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarAvanzar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnEl")));
	 		AceptarAvanzar.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarInformacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
	 		AceptarInformacion.click();	
	 		
	 		
//			INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
			
			Set<String> handles3 = driver.getWindowHandles();
			
		// Iterar sobre los identificadores
        for (String handle : handles3) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Central");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Agencia");
            }
            
        }
       		Thread.sleep(secDelay); 
        	
    	WebElement ConsultarInventario2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
    		ConsultarInventario2.click();

        	// Tomar la captura de pantalla después de que el elemento esté presente
        	File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo3, new File(captura3));
        	
        	Thread.sleep(secDelay); 
        	Thread.sleep(secDelay); 
        
//			INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
				
		Set<String> handles4 = driver.getWindowHandles();
		
		// Iterar sobre los identificadores
        for (String handle1 : handles4) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Agencia");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle1);
                System.out.println("Estás en la página de Central");
            }
            
        }
	            
        WebElement Inicio3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio3.click();
        	
        	 Thread.sleep(secDelay);
        	
    	WebElement Cuadre2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    		Cuadre2.click();
    		
    		 Thread.sleep(secDelay);
    		
		WebElement AsientosContables2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
			AsientosContables2.click();
			
			 Thread.sleep(secDelay);
			 
		 WebElement DesplegarDivisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		 	DesplegarDivisa3.click();
		 	
		 	 Thread.sleep(secDelay);
		 	
	 	WebElement Divisa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	 		Divisa4.click();
	 		
	 	WebElement DesplegarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
 			DesplegarFormato2.click();
 			
		WebElement Formato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
			Formato2.click();
 			
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
			Aceptar2.click();
			
			 Thread.sleep(secDelay);
	
			 try {
				 
				 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
			    	Retro.click();
				    
				} catch (Exception e2) {
					 
					try {
						    driver.navigate().back();
						    
						    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
					    		Retro.click();
						    
						} catch (Exception e) {
							
						    e.printStackTrace();
						}
				}
			 
			 Thread.sleep(secDelay);
		    	
    	WebElement IngresarEnCaja3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
			IngresarEnCaja3.click();
			
			Thread.sleep(secDelay);
		
		WebElement IngresarPasesDeBoveda3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			IngresarPasesDeBoveda3.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisaConsulta2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
			DesplegarDivisaConsulta2.click();
			
			Thread.sleep(secDelay);
			
		WebElement DivisaConsulta2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			DivisaConsulta2.click();
			
		WebElement Consulta2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
			Consulta2.click();
			
			Thread.sleep(secDelay);
			
		WebElement Estado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1013-titleEl")));
	    	Estado2.click();
	    	
		 WebElement SeleccionarElemento2 = driver.findElement(By.xpath("//*[@data-columnid='gridcolumn-1012']"));
		 	SeleccionarElemento2.click();
		 	
		 	Thread.sleep(secDelay);
			
	 	WebElement Avanzar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarPase-btnEl")));
	 		Avanzar2.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarAvanzar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnEl")));
	 		AceptarAvanzar2.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarInformacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
	 		AceptarInformacion2.click();	
	 		
	 		
//					INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
			
			Set<String> handles5 = driver.getWindowHandles();
			
		// Iterar sobre los identificadores
        for (String handle : handles5) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Central");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Agencia");
            }
            
        }
       		Thread.sleep(secDelay); 
        	
    	WebElement ConsultarInventario3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
    		ConsultarInventario3.click();

        	// Tomar la captura de pantalla después de que el elemento esté presente
        	File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo4, new File(captura4));
        	
        	Thread.sleep(secDelay); 
        	Thread.sleep(secDelay); 
        
//					INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
				
		Set<String> handles6 = driver.getWindowHandles();
		
		// Iterar sobre los identificadores
        for (String handle1 : handles6) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Agencia");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle1);
                System.out.println("Estás en la página de Central");
            }
            
        }
	            
        WebElement Inicio4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio4.click();
        	
        	 Thread.sleep(secDelay);
        	
    	WebElement Cuadre3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    		Cuadre3.click();
    		
    		 Thread.sleep(secDelay);
    		
		WebElement AsientosContables3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
			AsientosContables3.click();
			
			 Thread.sleep(secDelay);
			 
		 WebElement DesplegarDivisa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		 	DesplegarDivisa4.click();
		 	
		 	 Thread.sleep(secDelay);
		 	
	 	WebElement Divisa5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	 		Divisa5.click();
	 		
	 	WebElement DesplegarFormato3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
 			DesplegarFormato3.click();
 			
		WebElement Formato3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
			Formato3.click();
 			
		WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
			Aceptar3.click();
			
			 Thread.sleep(secDelay);
	
			 try {
				 
				 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
			    	Retro.click();
				    
				} catch (Exception e2) {
					 
					try {
						    driver.navigate().back();
						    
						    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
					    		Retro.click();
						    
						} catch (Exception e) {
							
						    e.printStackTrace();
						}
				}			

// HASTA AQUI LLEGA LA PRUEBA CON PASE DE CAJA A BOVEDA
	
			 WebElement IngresarEnCaja4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
				IngresarEnCaja4.click();	
			
			WebElement IngresarPasesDeBoveda4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
				IngresarPasesDeBoveda4.click();
			
			WebElement OpcionCrear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
				OpcionCrear2.click();
				
				Thread.sleep(secDelay);
				
			WebElement DespDivisa2= ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
				DespDivisa2.click();
				
				Thread.sleep(secDelay);
				
			WebElement Divisa6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
				Divisa6.click();
				
				Thread.sleep(secDelay);
				
			WebElement DesplegarCaja2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
				DesplegarCaja2.click();
				
			WebElement Caja2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 1']")));
				Caja2.click();
				
				Thread.sleep(secDelay);
				
			WebElement DespModalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
			    DespModalidad2.click();

			    Thread.sleep(secDelay);
				
			WebElement Modalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal']")));
				Modalidad2.click();
				
			WebElement DesplegarTipoPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
				DesplegarTipoPase2.click();
				
				Thread.sleep(secDelay);	
				
			WebElement TipoPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase de Boveda a Caja']")));
				TipoPase2.click();
			
			Thread.sleep(secDelay);	
				
			WebElement elementoCantidad2 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); 
		    Actions doble4 = new Actions(driver);
		    doble4.doubleClick(elementoCantidad2).perform();
		    
		    Thread.sleep(secDelay);
		    
		    List<WebElement> elementos2 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
		
		    for (WebElement elemento : elementos2) {
		        if (elemento.isEnabled()) {
		            Actions actions = new Actions(driver);
		            actions.click(elemento).sendKeys("1").sendKeys(Keys.ENTER).perform();
		        }
		    }
		
			WebElement AceptarPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
			    AceptarPase2.click();
			    
			    Thread.sleep(secDelay);
			    
			WebElement ConfirmarAceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
			    ConfirmarAceptar2.click();
			    
			    Thread.sleep(secDelay); 
			    
//				INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
			
				Set<String> handles2 = driver.getWindowHandles();
				
			// Iterar sobre los identificadores
	        for (String handle : handles2) {
	            // Cambiar a la ventana deseada según la URL
	            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
	                // Realizar acciones en la segunda página
	                System.out.println("Estás en la página de Central");
	            } else {
	                // Cambiar a la primera página
	                driver.switchTo().window(handle);
	                System.out.println("Estás en la página de Agencia");
	            }
	            
	        }
	       		Thread.sleep(secDelay); 
	        	
	    	WebElement ConsultarInventario4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
	    		ConsultarInventario4.click();

	        	// Tomar la captura de pantalla después de que el elemento esté presente
	        	File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        	FileUtils.copyFile(archivo5, new File(captura5));
	        	
	        	Thread.sleep(secDelay); 
	        	Thread.sleep(secDelay); 
	        
//				INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
					
			Set<String> handles7 = driver.getWindowHandles();
			
			// Iterar sobre los identificadores
	        for (String handle1 : handles7) {
	            // Cambiar a la ventana deseada según la URL
	            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
	                // Realizar acciones en la segunda página
	                System.out.println("Estás en la página de Agencia");
	            } else {
	                // Cambiar a la primera página
	                driver.switchTo().window(handle1);
	                System.out.println("Estás en la página de Central");
	            }
	            
	        }
		            
	        WebElement Inicio5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	        	Inicio5.click();
	        	
	        	 Thread.sleep(secDelay);
	        	
	    	WebElement Cuadre4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
	    		Cuadre4.click();
	    		
	    		 Thread.sleep(secDelay);
	    		
			WebElement AsientosContables4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
				AsientosContables4.click();
				
				 Thread.sleep(secDelay);
				 
			 WebElement DesplegarDivisa5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
			 	DesplegarDivisa5.click();
			 	
			 	 Thread.sleep(secDelay);
			 	
		 	WebElement Divisa7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		 		Divisa7.click();
		 		
		 	WebElement DesplegarFormato4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
	 			DesplegarFormato4.click();
	 			
			WebElement Formato4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
				Formato4.click();
	 			
			WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
				Aceptar4.click();
				
				 Thread.sleep(secDelay);
		
			 try {
				 
				 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
			    	Retro.click();
				    
				} catch (Exception e2) {
					 
					try {
						    driver.navigate().back();
						    
						    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
					    		Retro.click();
						    
						} catch (Exception e) {
							
						    e.printStackTrace();
						}
				}
		    	
		    	Thread.sleep(secDelay);
		    	
	    	WebElement IngresarEnCaja5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
				IngresarEnCaja5.click();
				
				Thread.sleep(secDelay);
			
			WebElement IngresarPasesDeBoveda5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
				IngresarPasesDeBoveda5.click();
				
				Thread.sleep(secDelay);
				
			WebElement DesplegarDivisaConsulta4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
				DesplegarDivisaConsulta4.click();
				
				Thread.sleep(secDelay);
				
			WebElement DivisaConsulta3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
				DivisaConsulta3.click();
				
			WebElement Consulta3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
				Consulta3.click();
				
				Thread.sleep(secDelay);
				
			WebElement Estado3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1013-titleEl")));
		    Actions doble5 = new Actions(driver);
		    doble5.doubleClick(Estado3).perform();
				
			 WebElement SeleccionarElemento3 = driver.findElement(By.xpath("//*[@data-columnid='gridcolumn-1012']"));
			 	SeleccionarElemento3.click();
			 	
			 	Thread.sleep(secDelay);
				
		 	WebElement Avanzar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarPase-btnEl")));
		 		Avanzar3.click();
		 		
		 		Thread.sleep(secDelay);
		 		
	 		WebElement AceptarAvanzar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnEl")));
		 		AceptarAvanzar3.click();
		 		
		 		Thread.sleep(secDelay);
		 		
	 		WebElement AceptarInformacion3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		 		AceptarInformacion3.click();	
		 		
		 		
//				INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
				
				Set<String> handles8 = driver.getWindowHandles();
				
			// Iterar sobre los identificadores
	        for (String handle : handles8) {
	            // Cambiar a la ventana deseada según la URL
	            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
	                // Realizar acciones en la segunda página
	                System.out.println("Estás en la página de Central");
	            } else {
	                // Cambiar a la primera página
	                driver.switchTo().window(handle);
	                System.out.println("Estás en la página de Agencia");
	            }
	            
	        }
	       		Thread.sleep(secDelay); 
	        	
	    	WebElement ConsultarInventario5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
	    		ConsultarInventario5.click();

	        	// Tomar la captura de pantalla después de que el elemento esté presente
	        	File archivo6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        	FileUtils.copyFile(archivo6, new File(captura6));
	        	
	        	Thread.sleep(secDelay); 
	        	Thread.sleep(secDelay); 
	        
//				INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
					
			Set<String> handles9 = driver.getWindowHandles();
			
			// Iterar sobre los identificadores
	        for (String handle1 : handles9) {
	            // Cambiar a la ventana deseada según la URL
	            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
	                // Realizar acciones en la segunda página
	                System.out.println("Estás en la página de Agencia");
	            } else {
	                // Cambiar a la primera página
	                driver.switchTo().window(handle1);
	                System.out.println("Estás en la página de Central");
	            }
	            
	        }
		            
	        WebElement Inicio6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	        	Inicio6.click();
	        	
	        	 Thread.sleep(secDelay);
	        	
	    	WebElement Cuadre6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
	    		Cuadre6.click();
	    		
	    		 Thread.sleep(secDelay);
	    		
			WebElement AsientosContables6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
				AsientosContables6.click();
				
				 Thread.sleep(secDelay);
				 
			 WebElement DesplegarDivisa6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
			 	DesplegarDivisa6.click();
			 	
			 	 Thread.sleep(secDelay);
			 	
		 	WebElement Divisa8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		 		Divisa8.click();
		 		
		 	WebElement DesplegarFormato6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
	 			DesplegarFormato6.click();
	 			
			WebElement Formato6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
				Formato6.click();
	 			
			WebElement Aceptar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
				Aceptar6.click();
				
				 Thread.sleep(secDelay);
		
				 try {
					 
					 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
				    	Retro.click();
					    
					} catch (Exception e2) {
						 
						try {
							    driver.navigate().back();
							    
							    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
						    		Retro.click();
							    
							} catch (Exception e) {
								
							    e.printStackTrace();
							}
					}
				 
				 Thread.sleep(secDelay);
			    	
	    	WebElement IngresarEnCaja6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
				IngresarEnCaja6.click();
				
				Thread.sleep(secDelay);
			
			WebElement IngresarPasesDeBoveda6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
				IngresarPasesDeBoveda6.click();
				
				Thread.sleep(secDelay);
				
			WebElement DesplegarDivisaConsulta6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
				DesplegarDivisaConsulta6.click();
				
				Thread.sleep(secDelay);
				
			WebElement DivisaConsulta6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
				DivisaConsulta6.click();
				
			WebElement Consulta6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
				Consulta6.click();
				
				Thread.sleep(secDelay);
				
			WebElement Estado6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1013-titleEl")));
		    	Estado6.click();
		    	
			 WebElement SeleccionarElemento6 = driver.findElement(By.xpath("//*[@data-columnid='gridcolumn-1012']"));
			 	SeleccionarElemento6.click();
			 	
			 	Thread.sleep(secDelay);
				
		 	WebElement Avanzar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarPase-btnEl")));
		 		Avanzar6.click();
		 		
		 		Thread.sleep(secDelay);
		 		
	 		WebElement AceptarAvanzar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnEl")));
		 		AceptarAvanzar6.click();
		 		
		 		Thread.sleep(secDelay);
		 		
	 		WebElement AceptarInformacion6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		 		AceptarInformacion6.click();	
		 		
		 		
//						INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
				
				Set<String> handles10 = driver.getWindowHandles();
				
			// Iterar sobre los identificadores
	        for (String handle : handles10) {
	            // Cambiar a la ventana deseada según la URL
	            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
	                // Realizar acciones en la segunda página
	                System.out.println("Estás en la página de Central");
	            } else {
	                // Cambiar a la primera página
	                driver.switchTo().window(handle);
	                System.out.println("Estás en la página de Agencia");
	            }
	            
	        }
	       		Thread.sleep(secDelay); 
	        	
	    	WebElement ConsultarInventario7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
	    		ConsultarInventario7.click();

	        	// Tomar la captura de pantalla después de que el elemento esté presente
	        	File archivo7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        	FileUtils.copyFile(archivo7, new File(captura7));
	        	
	        	Thread.sleep(secDelay); 
	        	Thread.sleep(secDelay); 
	        
//						INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
					
			Set<String> handles11 = driver.getWindowHandles();
			
			// Iterar sobre los identificadores
	        for (String handle1 : handles11) {
	            // Cambiar a la ventana deseada según la URL
	            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
	                // Realizar acciones en la segunda página
	                System.out.println("Estás en la página de Agencia");
	            } else {
	                // Cambiar a la primera página
	                driver.switchTo().window(handle1);
	                System.out.println("Estás en la página de Central");
	            }
	            
	        }
		            
	        WebElement Inicio8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	        	Inicio8.click();
	        	
	        	 Thread.sleep(secDelay);
	        	
	    	WebElement Cuadre8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
	    		Cuadre8.click();
	    		
	    		 Thread.sleep(secDelay);
	    		
			WebElement AsientosContables8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
				AsientosContables8.click();
				
				 Thread.sleep(secDelay);
				 
			 WebElement DesplegarDivisa8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
			 	DesplegarDivisa8.click();
			 	
			 	 Thread.sleep(secDelay);
			 	
		 	WebElement Divisa9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		 		Divisa9.click();
		 		
		 	WebElement DesplegarFormato9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
	 			DesplegarFormato9.click();
	 			
			WebElement Formato9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
				Formato9.click();
	 			
			WebElement Aceptar9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
				Aceptar9.click();
				
				 Thread.sleep(secDelay);
		
				 try {
					 
					 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
				    	Retro.click();
					    
					} catch (Exception e2) {
						 
						try {
							    driver.navigate().back();
							    
							    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
						    		Retro.click();
							    
							} catch (Exception e) {
								
							    e.printStackTrace();
							}
					}
// HASTA AQUI LLEGA LA PRUEBA CON PASE DE BOVEDA A CAJA
				 
		 WebElement IngresarEnCaja7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
			IngresarEnCaja7.click();	
		
		WebElement IngresarPasesDeBoveda7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			IngresarPasesDeBoveda7.click();
		
		WebElement OpcionCrear7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
			OpcionCrear7.click();
			
			Thread.sleep(secDelay);
			
		WebElement DespDivisa7= ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
			DespDivisa7.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa10.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarCaja3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
			DesplegarCaja3.click();
			
		WebElement Caja3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 1']")));
			Caja3.click();
			
			Thread.sleep(secDelay);
			
		WebElement DespModalidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
		    DespModalidad3.click();

		    Thread.sleep(secDelay);
			
		WebElement Modalidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cierre']")));
			Modalidad3.click();
			
	
		WebElement AceptarPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
		    AceptarPase3.click();
		    
		    Thread.sleep(secDelay);
		    
		WebElement ConfirmarAceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
		    ConfirmarAceptar3.click();
		    
		    Thread.sleep(secDelay); 
		    
//					INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
		
			Set<String> handles12 = driver.getWindowHandles();
			
		// Iterar sobre los identificadores
        for (String handle : handles12) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Central");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Agencia");
            }
            
        }
       		Thread.sleep(secDelay); 
        	
    	WebElement ConsultarInventario6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
    		ConsultarInventario6.click();

        	// Tomar la captura de pantalla después de que el elemento esté presente
        	File archivo8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo8, new File(captura8));
        	
        	Thread.sleep(secDelay); 
        	Thread.sleep(secDelay); 
        
//					INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
				
		Set<String> handles13 = driver.getWindowHandles();
		
		// Iterar sobre los identificadores
        for (String handle1 : handles13) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Agencia");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle1);
                System.out.println("Estás en la página de Central");
            }
            
        }
	            
        WebElement Inicio7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio7.click();
        	
        	 Thread.sleep(secDelay);
        	
    	WebElement Cuadre7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    		Cuadre7.click();
    		
    		 Thread.sleep(secDelay);
    		
		WebElement AsientosContables7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
			AsientosContables7.click();
			
			 Thread.sleep(secDelay);
			 
		 WebElement DesplegarDivisa7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		 	DesplegarDivisa7.click();
		 	
		 	 Thread.sleep(secDelay);
		 	
	 	WebElement Divisa11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	 		Divisa11.click();
	 		
	 	WebElement DesplegarFormato7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
 			DesplegarFormato7.click();
 		
		WebElement Formato7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
			Formato7.click();
 			
		WebElement Aceptar7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
			Aceptar7.click();
			
			 Thread.sleep(secDelay);
	
		 try {
			 
			 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
		    	Retro.click();
			    
			} catch (Exception e2) {
				 
				try {
					    driver.navigate().back();
					    
					    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
				    		Retro.click();
					    
					} catch (Exception e) {
						
					    e.printStackTrace();
					}
			}
	    	
	    	Thread.sleep(secDelay);
	    	
    	WebElement IngresarEnCaja8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
			IngresarEnCaja8.click();
			
			Thread.sleep(secDelay);
		
		WebElement IngresarPasesDeBoveda8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			IngresarPasesDeBoveda8.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisaConsulta8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
			DesplegarDivisaConsulta8.click();
			
			Thread.sleep(secDelay);
			
		WebElement DivisaConsulta8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			DivisaConsulta8.click();
			
		WebElement Consulta8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
			Consulta8.click();
			
			Thread.sleep(secDelay);
			
			WebElement Estado7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1013-titleEl")));
		    Actions doble6 = new Actions(driver);
		    doble6.doubleClick(Estado7).perform();
			
		 WebElement SeleccionarElemento8 = driver.findElement(By.xpath("//*[@data-columnid='gridcolumn-1012']"));
		 	SeleccionarElemento8.click();
		 	
		 	Thread.sleep(secDelay);
			
	 	WebElement Avanzar8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarPase-btnEl")));
	 		Avanzar8.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarAvanzar8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnEl")));
	 		AceptarAvanzar8.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarInformacion8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
	 		AceptarInformacion8.click();	
	 		
	 		
//					INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
			
			Set<String> handles14 = driver.getWindowHandles();
			
		// Iterar sobre los identificadores
        for (String handle : handles14) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Central");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Agencia");
            }
            
        }
       		Thread.sleep(secDelay); 
        	
    	WebElement ConsultarInventario8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
    		ConsultarInventario8.click();

        	// Tomar la captura de pantalla después de que el elemento esté presente
        	File archivo9 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo9, new File(captura9));
        	
        	Thread.sleep(secDelay); 
        	Thread.sleep(secDelay); 
        
//					INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
				
		Set<String> handles15 = driver.getWindowHandles();
		
		// Iterar sobre los identificadores
        for (String handle1 : handles15) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Agencia");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle1);
                System.out.println("Estás en la página de Central");
            }
            
        }
	            
        WebElement Inicio9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio9.click();
        	
        	 Thread.sleep(secDelay);
        	
    	WebElement Cuadre9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    		Cuadre9.click();
    		
    		 Thread.sleep(secDelay);
    		
		WebElement AsientosContables9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
			AsientosContables9.click();
			
			 Thread.sleep(secDelay);
			 
		 WebElement DesplegarDivisa9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		 	DesplegarDivisa9.click();
		 	
		 	 Thread.sleep(secDelay);
		 	
	 	WebElement Divisa12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	 		Divisa12.click();
	 		
	 	WebElement DesplegarFormato8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
 			DesplegarFormato8.click();
 			
		WebElement Formato8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
			Formato8.click();
 			
		WebElement Aceptar8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
			Aceptar8.click();
			
			 Thread.sleep(secDelay);
	
			 try {
				 
				 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
			    	Retro.click();
				    
				} catch (Exception e2) {
					 
					try {
						    driver.navigate().back();
						    
						    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
					    		Retro.click();
						    
						} catch (Exception e) {
							
						    e.printStackTrace();
						}
				}
			 
			 Thread.sleep(secDelay);
		    	
    	WebElement IngresarEnCaja9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
			IngresarEnCaja9.click();
			
			Thread.sleep(secDelay);
		
		WebElement IngresarPasesDeBoveda9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			IngresarPasesDeBoveda9.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisaConsulta9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
			DesplegarDivisaConsulta9.click();
			
			Thread.sleep(secDelay);
			
		WebElement DivisaConsulta9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			DivisaConsulta9.click();
			
		WebElement Consulta9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
			Consulta9.click();
			
			Thread.sleep(secDelay);
			
		WebElement Estado9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1013-titleEl")));
	    	Estado9.click();
	    	
	    	Thread.sleep(secDelay);
	    	
		 WebElement SeleccionarElemento9 = driver.findElement(By.xpath("//*[@data-columnid='gridcolumn-1012']"));
		 	SeleccionarElemento9.click();
		 	
		 	Thread.sleep(secDelay);
			
	 	WebElement Avanzar9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarPase-btnEl")));
	 		Avanzar9.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarAvanzar9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnEl")));
	 		AceptarAvanzar9.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarInformacion9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
	 		AceptarInformacion9.click();	
	 		
	 		
//							INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
			
			Set<String> handles16 = driver.getWindowHandles();
			
		// Iterar sobre los identificadores
        for (String handle : handles16) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Central");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Agencia");
            }
            
        }
       		Thread.sleep(secDelay); 
        	
    	WebElement ConsultarInventario9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
    		ConsultarInventario9.click();

        	// Tomar la captura de pantalla después de que el elemento esté presente
        	File archivo10 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo10, new File(captura10));
        	
        	Thread.sleep(secDelay); 
        	Thread.sleep(secDelay); 
        
//							INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
				
		Set<String> handles17 = driver.getWindowHandles();
		
		// Iterar sobre los identificadores
        for (String handle1 : handles17) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Agencia");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle1);
                System.out.println("Estás en la página de Central");
            }
            
        }
	            
        WebElement Inicio10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio10.click();
        	
        	 Thread.sleep(secDelay);
        	
    	WebElement Cuadre10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    		Cuadre10.click();
    		
    		 Thread.sleep(secDelay);
    		
		WebElement AsientosContables10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
			AsientosContables10.click();
			
			 Thread.sleep(secDelay);
			 
		 WebElement DesplegarDivisa10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		 	DesplegarDivisa10.click();
		 	
		 	 Thread.sleep(secDelay);
		 	
	 	WebElement Divisa13 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	 		Divisa13.click();
	 		
	 	WebElement DesplegarFormato10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
 			DesplegarFormato10.click();
 			
		WebElement Formato10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
			Formato10.click();
 			
		WebElement Aceptar10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
			Aceptar10.click();
			
			 Thread.sleep(secDelay);
	
			 try {
				 
				 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
			    	Retro.click();
				    
				} catch (Exception e2) {
					 
					try {
						    driver.navigate().back();
						    
						    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
					    		Retro.click();
						    
						} catch (Exception e) {
							
						    e.printStackTrace();
						}
				}
			 
//	FIN PASES APERTURA 
			 
			 
		 WebElement IngresarEnCaja10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
			IngresarEnCaja10.click();	
		
		WebElement IngresarPasesDeBoveda10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			IngresarPasesDeBoveda10.click();
		
		WebElement OpcionCrear10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
			OpcionCrear10.click();
			
			Thread.sleep(secDelay);
			
		WebElement DespDivisa10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
			DespDivisa10.click();
			
			Thread.sleep(secDelay);
			
		WebElement Divisa14 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			Divisa14.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarCaja4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
			DesplegarCaja4.click();
			
		WebElement Caja4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 1']")));
			Caja4.click();
			
			Thread.sleep(secDelay);
			
		WebElement DespModalidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
		    DespModalidad4.click();

		    Thread.sleep(secDelay);
			
		WebElement Modalidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Apertura']")));
			Modalidad4.click();
			
	
		WebElement AceptarPase4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
		    AceptarPase4.click();
		    
		    Thread.sleep(secDelay);
		    
		WebElement ConfirmarAceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
		    ConfirmarAceptar4.click();
		    
		    Thread.sleep(secDelay); 
		    
//						INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
		
			Set<String> handles18 = driver.getWindowHandles();
			
		// Iterar sobre los identificadores
        for (String handle : handles18) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Central");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Agencia");
            }
            
        }
       		Thread.sleep(secDelay); 
        	
    	WebElement ConsultarInventario10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
    		ConsultarInventario10.click();

        	// Tomar la captura de pantalla después de que el elemento esté presente
        	File archivo11 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo11, new File(captura11));
        	
        	Thread.sleep(secDelay); 
        	Thread.sleep(secDelay); 
        
//						INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
				
		Set<String> handles19 = driver.getWindowHandles();
		
		// Iterar sobre los identificadores
        for (String handle1 : handles19) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Agencia");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle1);
                System.out.println("Estás en la página de Central");
            }
            
        }
	            
        WebElement Inicio11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio11.click();
        	
        	 Thread.sleep(secDelay);
        	
    	WebElement Cuadre5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    		Cuadre5.click();
    		
    		 Thread.sleep(secDelay);
    		
		WebElement AsientosContables11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
			AsientosContables11.click();
			
			 Thread.sleep(secDelay);
			 
		 WebElement DesplegarDivisa11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		 	DesplegarDivisa11.click();
		 	
		 	 Thread.sleep(secDelay);
		 	
	 	WebElement Divisa15 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	 		Divisa15.click();
	 		
	 	WebElement DesplegarFormato11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
 			DesplegarFormato11.click();
 		
		WebElement Formato11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
			Formato11.click();
 			
		WebElement Aceptar11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
			Aceptar11.click();
			
			 Thread.sleep(secDelay);
	
		 try {
			 
			 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
		    	Retro.click();
			    
			} catch (Exception e2) {
				 
				try {
					    driver.navigate().back();
					    
					    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
				    		Retro.click();
					    
					} catch (Exception e) {
						
					    e.printStackTrace();
					}
			}
	    	
	    	Thread.sleep(secDelay);
	    	
    	WebElement IngresarEnCaja11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
			IngresarEnCaja11.click();
			
			Thread.sleep(secDelay);
		
		WebElement IngresarPasesDeBoveda11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			IngresarPasesDeBoveda11.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisaConsulta11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
			DesplegarDivisaConsulta11.click();
			
			Thread.sleep(secDelay);
			
		WebElement DivisaConsulta11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			DivisaConsulta11.click();
			
		WebElement Consulta11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
			Consulta11.click();
			
			Thread.sleep(secDelay);
			
			WebElement Estado11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1013-titleEl")));
		    Actions doble11 = new Actions(driver);
		    doble11.doubleClick(Estado11).perform();
			
		 WebElement SeleccionarElemento11 = driver.findElement(By.xpath("//*[@data-columnid='gridcolumn-1012']"));
		 	SeleccionarElemento11.click();
		 	
		 	Thread.sleep(secDelay);
			
	 	WebElement Avanzar11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarPase-btnEl")));
	 		Avanzar11.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarAvanzar11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnEl")));
	 		AceptarAvanzar11.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarInformacion11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
	 		AceptarInformacion11.click();	
	 		
	 		
//						INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
			
			Set<String> handles20 = driver.getWindowHandles();
			
		// Iterar sobre los identificadores
        for (String handle : handles20) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Central");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Agencia");
            }
            
        }
       		Thread.sleep(secDelay); 
        	
    	WebElement ConsultarInventario11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
    		ConsultarInventario11.click();

        	// Tomar la captura de pantalla después de que el elemento esté presente
        	File archivo12 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo12, new File(captura12));
        	
        	Thread.sleep(secDelay); 
        	Thread.sleep(secDelay); 
        
//						INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
			
		Set<String> handles21 = driver.getWindowHandles();
		
		// Iterar sobre los identificadores
        for (String handle1 : handles21) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Agencia");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle1);
                System.out.println("Estás en la página de Central");
            }
            
        }
	            
        WebElement Inicio12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio12.click();
        	
        	 Thread.sleep(secDelay);
        	
    	WebElement Cuadre12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    		Cuadre12.click();
    		
    		 Thread.sleep(secDelay);
    		
		WebElement AsientosContables12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
			AsientosContables12.click();
			
			 Thread.sleep(secDelay);
			 
		 WebElement DesplegarDivisa12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		 	DesplegarDivisa12.click();
		 	
		 	 Thread.sleep(secDelay);
		 	
	 	WebElement Divisa16 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	 		Divisa16.click();
	 		
	 	WebElement DesplegarFormato12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
 			DesplegarFormato12.click();
 			
		WebElement Formato12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
			Formato12.click();
 			
		WebElement Aceptar12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
			Aceptar12.click();
			
			 Thread.sleep(secDelay);
	
			 try {
				 
				 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
			    	Retro.click();
				    
				} catch (Exception e2) {
					 
					try {
						    driver.navigate().back();
						    
						    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
					    		Retro.click();
						    
						} catch (Exception e) {
							
						    e.printStackTrace();
						}
				}
			 
			 Thread.sleep(secDelay);
		    	
    	WebElement IngresarEnCaja12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
			IngresarEnCaja12.click();
			
			Thread.sleep(secDelay);
		
		WebElement IngresarPasesDeBoveda12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
			IngresarPasesDeBoveda12.click();
			
			Thread.sleep(secDelay);
			
		WebElement DesplegarDivisaConsulta12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
			DesplegarDivisaConsulta12.click();
			
			Thread.sleep(secDelay);
			
		WebElement DivisaConsulta12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
			DivisaConsulta12.click();
			
		WebElement Consulta12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
			Consulta12.click();
			
			Thread.sleep(secDelay);
			
		WebElement Estado12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1013-titleEl")));
	    	Estado12.click();
	    	
		 WebElement SeleccionarElemento12 = driver.findElement(By.xpath("//*[@data-columnid='gridcolumn-1012']"));
		 	SeleccionarElemento12.click();
		 	
		 	Thread.sleep(secDelay);
			
	 	WebElement Avanzar12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarPase-btnEl")));
	 		Avanzar12.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarAvanzar12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnEl")));
	 		AceptarAvanzar12.click();
	 		
	 		Thread.sleep(secDelay);
	 		
 		WebElement AceptarInformacion12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
	 		AceptarInformacion12.click();	
	 		
	 		
//								INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
			
			Set<String> handles22 = driver.getWindowHandles();
			
		// Iterar sobre los identificadores
        for (String handle : handles22) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Central/inventarioCentral.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Central");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Agencia");
            }
            
        }
       		Thread.sleep(secDelay); 
        	
    	WebElement ConsultarInventario12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
    		ConsultarInventario12.click();

        	// Tomar la captura de pantalla después de que el elemento esté presente
        	File archivo15 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo15, new File(captura2));
        	
        	Thread.sleep(secDelay); 
        	Thread.sleep(secDelay); 
        
//								INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA		
				
		Set<String> handles23 = driver.getWindowHandles();
		
		// Iterar sobre los identificadores
        for (String handle1 : handles23) {
            // Cambiar a la ventana deseada según la URL
            if (driver.getCurrentUrl().equals("http://192.168.2.20:8901/Agencia/pasesBoveda.action")) {
                // Realizar acciones en la segunda página
                System.out.println("Estás en la página de Agencia");
            } else {
                // Cambiar a la primera página
                driver.switchTo().window(handle1);
                System.out.println("Estás en la página de Central");
            }
            
        }
	            
        WebElement Inicio13 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        	Inicio13.click();
        	
        	 Thread.sleep(secDelay);
        	
    	WebElement Cuadre13 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    		Cuadre13.click();
    		
    		 Thread.sleep(secDelay);
    		
		WebElement AsientosContables13 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
			AsientosContables13.click();
			
			 Thread.sleep(secDelay);
			 
		 WebElement DesplegarDivisa13 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		 	DesplegarDivisa13.click();
		 	
		 	 Thread.sleep(secDelay);
		 	
	 	WebElement Divisa17 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	 		Divisa17.click();
	 		
	 	WebElement DesplegarFormato13 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
 			DesplegarFormato13.click();
 			
		WebElement Formato13 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
			Formato13.click();
 			
		WebElement Aceptar13 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
			Aceptar13.click();
			
			 Thread.sleep(secDelay);
	
			 try {
				 
				 WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
			    	Retro.click();
				    
				} catch (Exception e2) {
					 
					try {
						    driver.navigate().back();
						    
						    WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
					    		Retro.click();
						    
						} catch (Exception e) {
							
						    e.printStackTrace();
						}
				}
	
	}
	
}