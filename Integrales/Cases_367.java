package Integrales;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
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

public class Cases_367 {

	int secDelay = 2000;
	private WebDriver driver;
	private ReadExcelFile readFile;
	
	

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		readFile = new ReadExcelFile();
		
		driver.get(Constante_PreCalidad.URL_CENTRAL);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InterruptedException {
		
		
		//Bloque de codigo para Cambiar de pantalla--------------------------------------------
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String Agencia = "http://192.168.2.214:8901/Agencia/"; 
		String Central = "http://192.168.2.214:8901/Central/";
		
		//Bloque de codigo para tomar captures--------------------------------------------------
		
		String directorioCapturas = ""+Constante_PreCalidad.RUTA_CAPTURES+"\\Cases_346";
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
		
		//Bloque de codigo para generar un numero ramdom-----------------------------------------
	 	
		Random random = new Random();
		int GenerarNumeroAleatorio = random.nextInt(20001 - 10000) + 100000;
		String NumeroAleatorio = String.valueOf(GenerarNumeroAleatorio);
		int GenerarNumeroAleatorio2 = random.nextInt(20001 - 10000) + 100000;
		String NumeroAleatorio2 = String.valueOf(GenerarNumeroAleatorio2);
		
		//Bloque de codigo de excel----------------------------------------------------------------
				
		String filepath = ""+Constante_PreCalidad.RUTA_EXCEL+"//MatrizIntegrales.xlsx";
		
		String TipoUnidadEmisora = readFile.getCellValue(filepath, "Cases", 60, 1);
		String UnidadEmisora = readFile.getCellValue(filepath, "Cases", 60, 2);
		String TipoUnidadReceptora = readFile.getCellValue(filepath, "Cases", 60, 3);
		String UnidadReceptora = readFile.getCellValue(filepath, "Cases", 60, 4);
		String EmpresaTransportista = readFile.getCellValue(filepath, "Cases", 60, 5);
		String UnidadEmisoraFiltros = readFile.getCellValue(filepath, "General", 5, 3);
		
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		//--------------------------------------- Remesa CDA a AG ----------------------------------------------------
        
        WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        login.sendKeys(Constante_PreCalidad.USUARIO);
        WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
        WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
        enter.click();	   Thread.sleep(secDelay);
        
        //Ingresamos en el modulo de central-----------------------------------------------------------------------------
        
        WebElement logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
        logistica.click();
        WebElement administracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
        administracionEfectivo.click();
        WebElement Envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
        Envios.click();
        
        //creamos la remesa----------------------------------------------------------------------------------------------
        
        WebElement Crear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
        Crear.click();	   Thread.sleep(secDelay);
        
        
        
        WebElement DesplegarTipoUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadEmisoraCrear-trigger-picker")));
        DesplegarTipoUnidadEmisora.click();		Thread.sleep(secDelay);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options) {
            if (option.getText().equals(TipoUnidadEmisora)) {
                option.click();
                break;
            
                }
            }		Thread.sleep(secDelay);
        
    	WebElement DesplegarUnidadEmisora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadEmisoraCrear-trigger-picker")));
    	DesplegarUnidadEmisora2.click();		Thread.sleep(secDelay);
		List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options2) {
            if (option.getText().equals(UnidadEmisora)) {
                option.click();
                break;
            
                }
            };		Thread.sleep(secDelay);
        
        WebElement DesplegarTipoUnidadReceptora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadReceptoraCrear-trigger-picker")));
        DesplegarTipoUnidadReceptora.click();		Thread.sleep(secDelay);
		List<WebElement> options3 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options3) {
            if (option.getText().equals(TipoUnidadReceptora)) {
                option.click();
                break;
            
                }
            }		Thread.sleep(secDelay);
            
        WebElement DesplegarUnidadReceptora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadReceptoraCrear-trigger-picker")));
        DesplegarUnidadReceptora.click();		Thread.sleep(secDelay);
		List<WebElement> options4 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options4) {
            if (option.getText().equals(UnidadReceptora)) {
                option.click();
                break;
            
                }
            }		Thread.sleep(secDelay);
        
        WebElement DesplegarEmpresaTransportista = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transportistaCrear-trigger-picker")));	Thread.sleep(secDelay);
        DesplegarEmpresaTransportista.click();
		List<WebElement> options5 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options5) {
            if (option.getText().equals(EmpresaTransportista)) {
                option.click();
                break;
            
                }
            };
        
        
        WebElement Siguiente = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnInnerEl")));
        Siguiente.click();
        WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
        Thread.sleep(secDelay);
        DesplegarDivisa.click();
        WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constante_PreCalidad.DIVISA+"']")));
        Divisa.click();
        WebElement NumeroDeComprobante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl")));
        NumeroDeComprobante.click();
        Thread.sleep(secDelay);
        NumeroDeComprobante.sendKeys(NumeroAleatorio);
        
        //Verificar si el elemento está habilitado-----------------------------------------------------------------------------------------------------
        
        WebElement Localizador = driver.findElement(By.id("destinoCrear-inputEl"));
	    if (Localizador.isEnabled()) {
        System.out.println("El elemento está habilitado.");
        WebElement DesplegarDestino = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("destinoCrear-trigger-picker")));
    	DesplegarDestino.click();	  Thread.sleep(secDelay);
		WebElement Destino = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Boveda']")));
		Destino.click();
	    } else {
	        System.out.println("El elemento está deshabilitado.");
	    }    
	    WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear")));
    	Incluir.click();
    	WebElement DesplegarTipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvaseCrear-trigger-picker")));
	 	DesplegarTipoEnvase.click();	 Thread.sleep(secDelay);	
	 	WebElement TipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOLSA']")));
		TipoEnvase.click();
		WebElement DesplegarTipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
		DesplegarTipoPieza.click();		Thread.sleep(secDelay);	
	 	WebElement TipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billetes']")));
 		TipoPieza.click();
		WebElement CantidadInput = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
		CantidadInput.click();	   Thread.sleep(secDelay);
		CantidadInput.sendKeys("1");
		WebElement IncluirEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear-btnInnerEl")));
		IncluirEnvase.click();	
		WebElement AñadirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
		AñadirPlomos.click();	  Thread.sleep(secDelay);
		AñadirPlomos.sendKeys("1");		
		WebElement IncluirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnInnerEl")));
		IncluirPlomos.click();	
		WebElement elementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1163']")); 
	    Actions doble = new Actions(driver);
	    doble.doubleClick(elementoCantidad).perform();		Thread.sleep(secDelay);
	    
	    List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
	    for (WebElement elemento2 : elementos) {
	        if (elemento2.isEnabled()) {
	            Actions actions = new Actions(driver);
	            Thread.sleep(secDelay);
	            actions.click(elemento2).sendKeys("1").sendKeys(Keys.ENTER).perform();
	        }
	    }		Thread.sleep(secDelay);
	    	
    	WebElement DesplegarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
        DesplegarDivisa2.click();
        WebElement Divisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constante_PreCalidad.DIVISA+"']")));
        Divisa2.click();
        WebElement NumeroDeComprobante2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl")));
        NumeroDeComprobante2.click();
        NumeroDeComprobante2.sendKeys(NumeroAleatorio2);
	        
	    //Verificar si el elemento está habilitado--------------------------------------------------------------------------------------------------------
	        
        WebElement Localizador2 = driver.findElement(By.id("destinoCrear-inputEl"));
	        
	    if (Localizador2.isEnabled()) {
        System.out.println("El elemento está habilitado.");	        
        WebElement DesplegarDestino2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("destinoCrear-trigger-picker")));
    	DesplegarDestino2.click();	   Thread.sleep(secDelay);
		WebElement Destino2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Boveda']")));
		Destino2.click();
		    } else {
		        System.out.println("El elemento está deshabilitado.");
		    }
		    
	    WebElement Incluir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear")));
	    Incluir2.click();	        
    	WebElement DesplegarTipoEnvase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvaseCrear-trigger-picker")));
	 	DesplegarTipoEnvase2.click();	  Thread.sleep(secDelay);		    	
	 	WebElement TipoEnvase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOLSA']")));
		TipoEnvase2.click();				
		WebElement DesplegarTipoPieza2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
		DesplegarTipoPieza2.click();	 Thread.sleep(secDelay);
	 	WebElement TipoPieza2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billetes']")));
 		TipoPieza2.click();	
		WebElement CantidadInput2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
		CantidadInput2.click();		Thread.sleep(secDelay);
		CantidadInput2.sendKeys("1");	
		WebElement IncluirEnvase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear-btnInnerEl")));
		IncluirEnvase2.click();
		WebElement AñadirPlomos2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
		AñadirPlomos2.click();	   Thread.sleep(secDelay);
		AñadirPlomos2.sendKeys("1");			
		WebElement IncluirPlomos2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnInnerEl")));
		IncluirPlomos2.click();		
		WebElement elementoCantidad1003 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1163']")); 
	    Actions doble1 = new Actions(driver);
	    doble1.doubleClick(elementoCantidad1003).perform();		Thread.sleep(secDelay);    
	    List<WebElement> elementos2 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
	    for (WebElement elemento2 : elementos2) {
	        if (elemento2.isEnabled()) {
	            Actions actions = new Actions(driver);
	            Thread.sleep(secDelay);
	            actions.click(elemento2).sendKeys("1").sendKeys(Keys.ENTER).perform();
	        }
	    }		Thread.sleep(secDelay);
	    
	    WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar1-btnInnerEl")));
	    Aceptar.click();	 Thread.sleep(secDelay);
	    WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	 	ConfirmarAceptar.click();
		 	
	 	//Visualizar el inventario emisor----------------------------------------------------------------------------------------------
        
	    js.executeScript("window.open(arguments[0]);", Central);	  
	    Set<String> handles = driver.getWindowHandles();
	    String Agencia1 = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(Agencia1);
	    
	    //Ingresamos en el modulo de Central---------------------------------------------------------------------------------------------
		
  		WebElement login2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login2.sendKeys(Constante_PreCalidad.USUARIO);
  		WebElement password2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password2.sendKeys(Constante_PreCalidad.CONTRASEÑA);	
		WebElement enter2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
        enter2.click();
  			
		WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
		Logistica.click();
		WebElement InventarioDeEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventarioEfectivo")));
		InventarioDeEfectivo.click();
		WebElement DesplegarTipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
		DesplegarTipoUnidad.click();	 Thread.sleep(secDelay);
		WebElement TipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+TipoUnidadReceptora+"']")));
		TipoUnidad.click();		Thread.sleep(secDelay);
		WebElement DesplegarUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
		DesplegarUnidad.click();	 Thread.sleep(secDelay);	
		WebElement Unidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+UnidadReceptora+"']")));
		Unidad.click();
		WebElement DesplegarTipoBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoBoveda-trigger-picker")));
		DesplegarTipoBoveda.click();	 Thread.sleep(secDelay);	
		WebElement Boveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
		Boveda.click();		Thread.sleep(secDelay);	
		WebElement Desplegardivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		Desplegardivisa.click();	 Thread.sleep(secDelay);
		WebElement Divisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constante_PreCalidad.DIVISA+"']")));
		Divisa3.click();	 Thread.sleep(secDelay);	
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar.click();	
 		WebElement DesplegarDenominacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
		DesplegarDenominacion.click();
		
		//Guardamos el monto del inventario receptor----------------------------------------------------------------------------------------------
	 	
		WebElement CantidadDenominacion_100_Receptor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
  		String Cantidad_100_Receptor = CantidadDenominacion_100_Receptor.getText();
  		Cantidad_100_Receptor = Cantidad_100_Receptor.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Solicitado_Receptor = Double.parseDouble(Cantidad_100_Receptor);
  		System.out.println(ObtenerPiezasDenominacion_100_Solicitado_Receptor);
		
			File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo, new File(captura1));	Thread.sleep(secDelay);Thread.sleep(secDelay);
	        
        //Visualizar el inventario emisor--------------------------------------------------------------------
	        
        js.executeScript("window.open(arguments[0]);", Agencia);	  
	    Set<String> handles2 = driver.getWindowHandles();    
	    String Agencia2 = (String) handles2.toArray()[handles2.size() - 1];
	    driver.switchTo().window(Agencia2);
		
  		WebElement login3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login3.sendKeys(Constante_PreCalidad.USUARIO);
  		WebElement password3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password3.sendKeys(Constante_PreCalidad.CONTRASEÑA);	
		WebElement enter3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
        enter3.click();	
        WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    	CuadreDeAgencia.click();	
		WebElement InventarioDeEfectivo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
		InventarioDeEfectivo2.click();	
		WebElement DesplegarTipoBoveda2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
		DesplegarTipoBoveda2.click();	  Thread.sleep(secDelay);	
		WebElement Boveda2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
		Boveda2.click();	 Thread.sleep(secDelay);	
		WebElement Desplegardivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		Desplegardivisa2.click();	  Thread.sleep(secDelay);	
		WebElement Divisa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constante_PreCalidad.DIVISA+"']")));
		Divisa4.click();	 Thread.sleep(secDelay);	
		WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar2.click();	
 		WebElement DesplegarDenominacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
		DesplegarDenominacion2.click();
 		
		//guardamos el monto existente en el emisor-----------------------------------------------------------------------------------
		
		WebElement CantidadDenominacion_100_emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1018']"));
  		String Cantidad_100_Emisor = CantidadDenominacion_100_emisor.getText();
  		Cantidad_100_Emisor = Cantidad_100_Emisor.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Solicitado_Emisor = Double.parseDouble(Cantidad_100_Emisor);
  		System.out.println(ObtenerPiezasDenominacion_100_Solicitado_Emisor);
		
			File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo3, new File(captura2));	Thread.sleep(secDelay);Thread.sleep(secDelay);
  		
	   //PANTALLA DE ENVIO------------------------------------------------------------------------------------------------------------------
	        
		String Inicio = (String) handles2.toArray()[handles2.size() - 3];
	    driver.switchTo().window(Inicio);	Thread.sleep(secDelay);
		 	
	 	WebElement Consultar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar3.click();		Thread.sleep(secDelay); 		
 		WebElement Filtros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnInnerEl")));
		Filtros.click();	 Thread.sleep(secDelay);
		WebElement DesplegarEstados = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estadoConsulta-trigger-picker")));
		DesplegarEstados.click();	  Thread.sleep(secDelay);    	
		WebElement Estados = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Solicitado']")));
 		Estados.click();	 Thread.sleep(secDelay);	
	 	WebElement DesplegarTipoUnidad02 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoAgrupacionConsulta-trigger-picker")));
	 	DesplegarTipoUnidad02.click();	  Thread.sleep(secDelay);
	 	List<WebElement> options6 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options6) {
            if (option.getText().equals(TipoUnidadEmisora)) {
                option.click();
                break;
                }
        }	Thread.sleep(secDelay);
	 	
	 	WebElement DesplegarNombre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreAgrupacionConsulta-trigger-picker")));
	 	DesplegarNombre.click();	  Thread.sleep(secDelay);
	 	List<WebElement> options7 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options7) {
            if (option.getText().equals(UnidadEmisoraFiltros)) {
                option.click();
                break;
                }
        }	Thread.sleep(secDelay);
        WebElement ConsultarFiltros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1224-btnInnerEl")));
	 	ConsultarFiltros.click();
 		WebElement Estado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
 		Estado.click();	
 		WebElement Estado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
 		Estado2.click();
 		WebElement seleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1117']")));
	    seleccionarRemesa.click();
	    Thread.sleep(secDelay);
	    Actions actions = new Actions(driver);
	    //Mantener presionada la tecla Shift y presionar la tecla flecha hacia abajo----------------------------------------------------------
	    actions.keyDown(Keys.SHIFT)
		        .sendKeys(Keys.ARROW_DOWN)
		        .keyUp(Keys.SHIFT)
		        .perform();
	    
	    WebElement AvanceMasivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanceMasivo-btnInnerEl")));
	    AvanceMasivo.click();
	    WebElement AceptarAvanceMasivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanceMasivo-btnInnerEl")));
	    AceptarAvanceMasivo.click();
	    WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    Aceptar2.click();
	    
	    //INVENTARIO RECEPTOR-----------------------------------------------------------------------------------------------------------------------
	    
	    String VisualizarInventarioReceptor = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(VisualizarInventarioReceptor);
	    
		WebElement Consultar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar4.click();		Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Receptor2 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Receptor2 = CantidadDenominacion_100_Receptor2.getText();
  		Cantidad_100_Receptor2 = Cantidad_100_Receptor2.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Aprobado_Receptor = Double.parseDouble(Cantidad_100_Receptor2);
  		System.out.println(ObtenerPiezasDenominacion_100_Aprobado_Receptor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Aprobado_Receptor, ObtenerPiezasDenominacion_100_Solicitado_Receptor, 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado aprobado (Inventario emisor)");
	 		
  		//INVENTARIO EMISOR------------------------------------------------------------------------------------------------------------------------
	    
		 String VisualizarInventarioEmisor = (String) handles2.toArray()[handles2.size() - 1];
		 driver.switchTo().window(VisualizarInventarioEmisor);
 		WebElement Consultar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar5.click();		Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Emisor2 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1018']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Emisor2 = CantidadDenominacion_100_Emisor2.getText();
  		Cantidad_100_Emisor2 = Cantidad_100_Emisor2.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Aprobado_Emisor = Double.parseDouble(Cantidad_100_Emisor2);
  		System.out.println(ObtenerPiezasDenominacion_100_Aprobado_Emisor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Aprobado_Emisor, ObtenerPiezasDenominacion_100_Solicitado_Emisor, 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado aprobado (Inventario receptor)");
 		
  		//PANTALLA DE ENVIOS-------------------------------------------------------------------------------------------------------------------------
  		
 		String Envios2 = (String) handles2.toArray()[handles2.size() - 3];
 		driver.switchTo().window(Envios2); 
		WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tool-1113-toolEl")));
	 	Retro.click();	
	 	WebElement Filtros2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnInnerEl")));
		Filtros2.click();	   Thread.sleep(secDelay);
		WebElement DesplegarEstados2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estadoConsulta-trigger-picker")));
		DesplegarEstados2.click();	   Thread.sleep(secDelay);
	 	WebElement Estados2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aprobado']")));
 		Estados2.click();	  Thread.sleep(secDelay);	
	 	WebElement ConsultarFiltros2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1224-btnInnerEl")));
	 	ConsultarFiltros2.click();
 		WebElement Estado3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
 		Estado3.click();	
 		WebElement Estado4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
 		Estado4.click();
 		WebElement seleccionarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1117']")));
	    seleccionarRemesa2.click();		Thread.sleep(secDelay);
	    Actions actions2 = new Actions(driver);
	 // Mantener presionada la tecla Shift y presionar la tecla flecha hacia abajo------------------------------------------------------------------------
	    actions2.keyDown(Keys.SHIFT)
		        .sendKeys(Keys.ARROW_DOWN)
		        .keyUp(Keys.SHIFT)
		        .perform();
	    
	    WebElement AvanceMasivo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanceMasivo-btnInnerEl")));
	    AvanceMasivo2.click();
	    WebElement AceptarAvanceMasivo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanceMasivo-btnInnerEl")));
	    AceptarAvanceMasivo2.click();
	    WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    Aceptar3.click();
	    
	    //INVENTARIO RECEPTOR---------------------------------------------------------------------------------------------------------------------------------
		 	
 		String VisualizarInventarioReceptor2 = (String) handles.toArray()[handles.size() - 1];
 	    driver.switchTo().window(VisualizarInventarioReceptor2);
 		WebElement Consultar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar6.click();		Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Receptor3 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Receptor3 = CantidadDenominacion_100_Receptor3.getText();
  		Cantidad_100_Receptor3 = Cantidad_100_Receptor3.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Despachado_Receptor = Double.parseDouble(Cantidad_100_Receptor3);
  		System.out.println(ObtenerPiezasDenominacion_100_Despachado_Receptor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Despachado_Receptor, (ObtenerPiezasDenominacion_100_Aprobado_Receptor), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Despachado (Inventario emisor)");
 	 		
  		//INVENTARIO RECEPTOR---------------------------------------------------------------------------------------------------------------------------------	
 	    
 		String VisualizarInventarioEmisor2 = (String) handles2.toArray()[handles2.size() - 1];
 		driver.switchTo().window(VisualizarInventarioEmisor2);    
  		WebElement Consultar7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar7.click();		Thread.sleep(secDelay);
  		
 		WebElement CantidadDenominacion_100_Emisor3 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1018']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Emisor3 = CantidadDenominacion_100_Emisor3.getText();
  		Cantidad_100_Emisor3 = Cantidad_100_Emisor3.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Despachado_Emisor = Double.parseDouble(Cantidad_100_Emisor3);
  		System.out.println(ObtenerPiezasDenominacion_100_Despachado_Emisor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Despachado_Emisor, (ObtenerPiezasDenominacion_100_Aprobado_Emisor - 2 ), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Despachado (Inventario Receptor)");
  		
  		//PANTALLA ENVIO--------------------------------------------------------------------------------------------------------------------------------------
  		
  		String Envios3 = (String) handles2.toArray()[handles2.size() - 3];
 		driver.switchTo().window(Envios3); 
 		WebElement Retro2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tool-1113-toolEl")));
	 	Retro2.click();
 	 	WebElement Filtros3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnInnerEl")));
		Filtros3.click();	  Thread.sleep(secDelay);
 		WebElement DesplegarEstados3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estadoConsulta-trigger-picker")));
		DesplegarEstados3.click();	   Thread.sleep(secDelay);
 	 	WebElement Estados3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Despachado']")));
 		Estados3.click();	  Thread.sleep(secDelay);
 	 	WebElement ConsultarFiltros3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1224-btnInnerEl")));
 	 	ConsultarFiltros3.click();
  		WebElement Estado5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
  		Estado5.click();	
  		WebElement Estado6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
  		Estado6.click();
  		WebElement seleccionarRemesa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1117']")));
	    seleccionarRemesa3.click();		Thread.sleep(secDelay);
	    Actions actions3 = new Actions(driver);
	    //Mantener presionada la tecla Shift y presionar la tecla flecha hacia abajo----------------------------------------------------------------------------
	    actions3.keyDown(Keys.SHIFT)
		        .sendKeys(Keys.ARROW_DOWN)
		        .keyUp(Keys.SHIFT)
		        .perform();
	    
	    WebElement AvanceMasivo3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanceMasivo-btnInnerEl")));
	    AvanceMasivo3.click();
	    WebElement AceptarAvanceMasivo3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanceMasivo-btnInnerEl")));
	    AceptarAvanceMasivo3.click();
	    WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    Aceptar4.click();
	    
	    //INVENTARIO RECEPTOR-------------------------------------------------------------------------------------------------------------------------------------
	 	
 		String VisualizarInventarioReceptor3 = (String) handles.toArray()[handles.size() - 1];
 	    driver.switchTo().window(VisualizarInventarioReceptor3);

 		WebElement Consultar8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar8.click();		Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Receptor4 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Receptor4 = CantidadDenominacion_100_Receptor4.getText();
  		Cantidad_100_Receptor4 = Cantidad_100_Receptor4.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Recibido_Receptor = Double.parseDouble(Cantidad_100_Receptor4);
  		System.out.println(ObtenerPiezasDenominacion_100_Recibido_Receptor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Recibido_Receptor, (ObtenerPiezasDenominacion_100_Despachado_Receptor + 2), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado recibido (Inventario emisor)");
 	 		
  		//INVENTARIO EMISOR------------------------------------------------------------------------------------------------------------------------------------	
 	    
 		String VisualizarInventarioEmisor3 = (String) handles2.toArray()[handles2.size() - 1];
		driver.switchTo().window(VisualizarInventarioEmisor3);
  		WebElement Consultar9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar9.click();		Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Emisor4 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1018']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Emisor4 = CantidadDenominacion_100_Emisor4.getText();
  		Cantidad_100_Emisor4 = Cantidad_100_Emisor4.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Recibido_Emisor = Double.parseDouble(Cantidad_100_Emisor4);
  		System.out.println(ObtenerPiezasDenominacion_100_Recibido_Emisor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Recibido_Emisor, (ObtenerPiezasDenominacion_100_Despachado_Emisor), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado recibido (Inventario Receptor)");
  		
  		//PANTALLA ENVIO------------------------------------------------------------------------------------------------------------------------------------------
  		
  		String Envios4 = (String) handles2.toArray()[handles2.size() - 3];
 		driver.switchTo().window(Envios4); 
 		WebElement Retro3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tool-1113-toolEl")));
	 	Retro3.click();
 	 	WebElement Filtros4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnInnerEl")));
		Filtros4.click();     Thread.sleep(secDelay);
 		WebElement DesplegarEstados4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estadoConsulta-trigger-picker")));
		DesplegarEstados4.click();	   Thread.sleep(secDelay);
 	 	WebElement Estados4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Recibido']")));
 		Estados4.click();	  Thread.sleep(secDelay);	
 	 	WebElement ConsultarFiltros4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1224-btnInnerEl")));
 	 	ConsultarFiltros4.click();
  		WebElement Estado7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
  		Estado7.click();	
  		WebElement Estado8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
  		Estado8.click();
  		WebElement seleccionarRemesa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1117']")));
	    seleccionarRemesa4.click();		Thread.sleep(secDelay);
	    Actions actions4 = new Actions(driver);
	    //Mantener presionada la tecla Shift y presionar la tecla flecha hacia abajo--------------------------------------------------------------------------
	    actions4.keyDown(Keys.SHIFT)
		        .sendKeys(Keys.ARROW_DOWN)
		        .keyUp(Keys.SHIFT)
		        .perform();
	    
	    WebElement AvanceMasivo4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanceMasivo-btnInnerEl")));
	    AvanceMasivo4.click();
	    WebElement AceptarAvanceMasivo4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanceMasivo-btnInnerEl")));
	    AceptarAvanceMasivo4.click();
	    WebElement Aceptar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    Aceptar5.click();
	    
	    //INVENTARIO RECEPTOR-----------------------------------------------------------------------------------------------------------------------------------
	 	
 		String VisualizarInventarioReceptor4 = (String) handles.toArray()[handles.size() - 1];
 	    driver.switchTo().window(VisualizarInventarioReceptor4);    
 		WebElement Consultar10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar10.click();	 Thread.sleep(secDelay);
 	 	
 		WebElement CantidadDenominacion_100_Receptor5 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Receptor5 = CantidadDenominacion_100_Receptor5.getText();
  		Cantidad_100_Receptor5 = Cantidad_100_Receptor5.replace(".", "");
  		double ObtenerPiezasDenominacion_100_ConfirmadoSinAjustes_Receptor = Double.parseDouble(Cantidad_100_Receptor5);
  		System.out.println(ObtenerPiezasDenominacion_100_ConfirmadoSinAjustes_Receptor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_ConfirmadoSinAjustes_Receptor, (ObtenerPiezasDenominacion_100_Recibido_Receptor), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Confirmado Sin Ajustes (Inventario emisor)");
 	 		
  		//INVENTARIO EMISOR----------------------------------------------------------------------------------------------------------------------------------	
 	    
 		String VisualizarInventarioEmisor4 = (String) handles2.toArray()[handles2.size() - 1];
 		driver.switchTo().window(VisualizarInventarioEmisor4);    
  		WebElement Consultar11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar11.click();	 Thread.sleep(secDelay);
  		
 		WebElement CantidadDenominacion_100_Emisor5 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1018']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_emisor5 = CantidadDenominacion_100_Emisor5.getText();
  		Cantidad_100_emisor5 = Cantidad_100_emisor5.replace(".", "");
  		double ObtenerPiezasDenominacion_100_ConsfirmadoSinAjustes_Receptor = Double.parseDouble(Cantidad_100_emisor5);
  		System.out.println(ObtenerPiezasDenominacion_100_ConsfirmadoSinAjustes_Receptor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_ConsfirmadoSinAjustes_Receptor, (ObtenerPiezasDenominacion_100_Recibido_Emisor), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Confirmado Sin Ajustes (Inventario Receptor)");
 		
	}

}
