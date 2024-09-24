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

public class Cases_346 {

	int secDelay = 2000;
	private WebDriver driver;
	private ReadExcelFile readFile;
	private By escribirTipoUnidadReceptoraLocator = By.id("tipoUnidadReceptoraCrear-inputEl");
	private By escribirUnidadEmisoraLocator = By.id("unidadReceptoraCrear-inputEl");
	private By TransportistaLocator = By.id("transportistaCrear-inputEl");
	
	

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
		
//------------------------------------ Crear Remesas y Avanzar Masivamente, evaluar afectación inventarios (Centro de Acopio - Agencia) en Central/ Logística / Administración de Efectivo/ Envíos (Case Integral)--------------------------------
		
		
		//Variables utilizadas para el cambio de pestalla---------------------------------------------------
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String Agencia = Constante_PreCalidad.URL_AGENCIA; 
		String Central = Constante_PreCalidad.URL_CENTRAL;
		
		//bloque de codigo para las captures-----------------------------------------------------------------
		
		String directorioCapturas = ""+Constante_PreCalidad.RUTA_CAPTURES+"//Integrales//Cases 346";
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
	 	
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
		
		//generar un numero random---------------------------------------------------------------
		Random random = new Random();
		int GenerarNumeroAleatorio = random.nextInt(20001 - 10000) + 100000;
		String NumeroAleatorio = String.valueOf(GenerarNumeroAleatorio);
		int GenerarNumeroAleatorio2 = random.nextInt(20001 - 10000) + 100000;
		String NumeroAleatorio2 = String.valueOf(GenerarNumeroAleatorio2);
		
		//Realizamos una Remesa de CDA a AG----------------------------------------------------------
				
		String filepath = ""+Constante_PreCalidad.RUTA_EXCEL+"\\MatrizIntegrales.xlsx";
		
		String TipoUnidadEmisora = readFile.getCellValue(filepath, "Cases", 58, 1);
		String UnidadEmisora = readFile.getCellValue(filepath, "Cases", 58, 2);
		String TipoUnidadReceptora = readFile.getCellValue(filepath, "Cases", 58, 3);
		String UnidadReceptora = readFile.getCellValue(filepath, "Cases", 58, 4);
		String EmpresaTransportista = readFile.getCellValue(filepath, "Cases", 58, 5);
		String UnidadEmisoraFiltros = readFile.getCellValue(filepath, "Cases", 7, 3);
		
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		//Ingresamos en el modulo central--------------------------------------------------------------
        
        WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        login.sendKeys(Constante_PreCalidad.USUARIO);
        WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
        WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
        enter.click();
        Thread.sleep(secDelay);
        
        //Ingresamos en el apartado de envios---------------------------------------------------------------------
        
        WebElement logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
        logistica.click();
        WebElement administracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
        administracionEfectivo.click();
        WebElement Envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
        Envios.click();
        
        //Creamos la remesa-----------------------------------------------------------------------------------------
        
        WebElement Crear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
        Crear.click();	   Thread.sleep(secDelay);
        
        WebElement DesplegarTipoUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadEmisoraCrear-trigger-picker")));
        DesplegarTipoUnidadEmisora.click();
        WebElement TipoUnidadEmisora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+TipoUnidadEmisora+"']")));
        TipoUnidadEmisora2.click();		Thread.sleep(secDelay);
        WebElement DesplegarUnidadEmisora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadEmisoraCrear-trigger-picker")));
        DesplegarUnidadEmisora2.click();
        WebElement UnidadEmisora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+UnidadEmisora+"']")));
        UnidadEmisora2.click();		Thread.sleep(secDelay);
 
        WebElement escribirTipoUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(escribirTipoUnidadReceptoraLocator));	Thread.sleep(secDelay);
        escribirTipoUnidadEmisora.sendKeys(TipoUnidadReceptora);
        escribirTipoUnidadEmisora.sendKeys(Keys.ENTER);
            
        WebElement escribirUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(escribirUnidadEmisoraLocator));	Thread.sleep(secDelay);
        escribirUnidadEmisora.sendKeys(UnidadReceptora);
        escribirUnidadEmisora.sendKeys(Keys.ENTER);
        
        WebElement Transportista = ewait.until(ExpectedConditions.visibilityOfElementLocated(TransportistaLocator));	Thread.sleep(secDelay);
        Transportista.sendKeys(EmpresaTransportista);
        Transportista.sendKeys(Keys.ENTER);		Thread.sleep(secDelay);
        
        WebElement Siguiente = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnInnerEl")));
        Siguiente.click();
        
        WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
									 Thread.sleep(secDelay);
        DesplegarDivisa.click();
        WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constante_PreCalidad.DIVISA+"']")));
        Divisa.click();
        
        WebElement NumeroDeComprobante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl")));
        NumeroDeComprobante.click();	 Thread.sleep(secDelay);
        NumeroDeComprobante.sendKeys(NumeroAleatorio);
        
        //Verificar si el elemento está habilitado--------------------------------------------------------------------------
        
        WebElement Localizador = driver.findElement(By.id("destinoCrear-inputEl"));
	    if (Localizador.isEnabled()) {
	        System.out.println("El elemento está habilitado.");
        WebElement DesplegarDestino = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("destinoCrear-trigger-picker")));
    	DesplegarDestino.click(); 	  Thread.sleep(secDelay);
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
		DesplegarTipoPieza.click();Thread.sleep(secDelay);
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
				
		WebElement elementoCantidad1002 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1163']")); 
	    Actions doble2 = new Actions(driver);
	    doble2.doubleClick(elementoCantidad1002).perform();		Thread.sleep(secDelay);
	    
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
	        
        //Verificar si el elemento está habilitado--------------------------------------------------------------------
	        
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
	    Actions doble = new Actions(driver);
	    doble.doubleClick(elementoCantidad1003).perform();	Thread.sleep(secDelay);
		    
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
		 	
	   //Visualizamos el inventario emisor-------------------------------------------------------------------------
        
	    js.executeScript("window.open(arguments[0]);", Central);	  
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	    String Agencia1 = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(Agencia1);
		
	    //Ingresamos en el modulo de agencia------------------------------------------------------------------------
	    
  		WebElement login2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login2.sendKeys(Constante_PreCalidad.USUARIO);
  		WebElement password2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password2.sendKeys(Constante_PreCalidad.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement enter2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
        enter2.click();
        
		WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
		Logistica.click();
		WebElement InventarioDeEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventarioEfectivo")));
		InventarioDeEfectivo.click();	  Thread.sleep(secDelay);	
		WebElement DesplegarTipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
		DesplegarTipoUnidad.click();	 Thread.sleep(secDelay);	
		WebElement TipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Centro de Acopio']")));
		TipoUnidad.click();		Thread.sleep(secDelay);	
		WebElement DesplegarUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
		DesplegarUnidad.click();	 Thread.sleep(secDelay);	
		WebElement Unidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+UnidadEmisora+"']")));
		Unidad.click();		Thread.sleep(secDelay);
		WebElement DesplegarTipoBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoBoveda-trigger-picker")));
		DesplegarTipoBoveda.click();	 Thread.sleep(secDelay);	
		WebElement Boveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
		Boveda.click();		Thread.sleep(secDelay);	
		WebElement Desplegardivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		Desplegardivisa.click();	 Thread.sleep(secDelay);
		WebElement Divisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		Divisa3.click();	 Thread.sleep(secDelay);
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
	 	Consultar.click();	   Thread.sleep(secDelay);	
	 	WebElement desplegarConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
	 	desplegarConsulta.click();
	 	
	 	//Guardamos el monto del inventario emisor 
	 	
		WebElement CantidadDenominacion_100_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
  		String Cantidad_100_Emisor = CantidadDenominacion_100_Emisor.getText();
  		Cantidad_100_Emisor = Cantidad_100_Emisor.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Solicitado_Emisor = Double.parseDouble(Cantidad_100_Emisor);
  		System.out.println(ObtenerPiezasDenominacion_100_Solicitado_Emisor);

			File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo, new File(captura1));	Thread.sleep(secDelay);Thread.sleep(secDelay);
	        
        //Visualizamos el inventario receptor--------------------------------------------------------------------
	        
        js.executeScript("window.open(arguments[0]);", Agencia);	  
	    Set<String> handles2 = driver.getWindowHandles();
	    String Agencia2 = (String) handles2.toArray()[handles2.size() - 1];
	    driver.switchTo().window(Agencia2);
		
	    //Ingresamos en el apartado de agencia-------------------------------------------------------------------
	    
  		WebElement login3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login3.sendKeys(Constante_PreCalidad.USUARIO);
  		WebElement password3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password3.sendKeys(Constante_PreCalidad.CONTRASEÑA);	Thread.sleep(secDelay);	
		WebElement enter3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
        enter3.click();
  		
        //Ingresamos en el apartado de inventarios----------------------------------------------------------------
        
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
		WebElement Divisa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		Divisa4.click();	 Thread.sleep(secDelay);	
		WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar2.click();
	 	WebElement desplegarConsulta2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
		desplegarConsulta2.click();
		
		//guardamos el monto existente en el receptor-----------------------------------------------------------------------------------
		
		WebElement CantidadDenominacion_100_Receptor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1018']"));
  		String Cantidad_100_Receptor = CantidadDenominacion_100_Receptor.getText();
  		Cantidad_100_Receptor = Cantidad_100_Receptor.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Solicitado_Receptor = Double.parseDouble(Cantidad_100_Receptor);
  		System.out.println(ObtenerPiezasDenominacion_100_Solicitado_Receptor);
 			
			File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo3, new File(captura2));	Thread.sleep(secDelay);Thread.sleep(secDelay);
  		
        //PANTALLA DE ENVIO----------------------------------------------------------------------------------------------------------
	        
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
	 	List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options) {
            if (option.getText().equals(TipoUnidadEmisora)) {
                option.click();
                break;
                }
        }	Thread.sleep(secDelay);
	 	
	 	WebElement DesplegarNombre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreAgrupacionConsulta-trigger-picker")));
	 	DesplegarNombre.click();	  Thread.sleep(secDelay);
	 	List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options2) {
            if (option.getText().equals(UnidadEmisoraFiltros)) {
                option.click();
                break;
                }
        }	Thread.sleep(secDelay);
	 	
	 	WebElement ConsultarFiltros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1226-btnInnerEl")));
	 	ConsultarFiltros.click();
 		WebElement Estado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
 		Estado.click();	
 		WebElement Estado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
 		Estado2.click();
 		
 		//Avanzamos la remesa------------------------------------------------------------------------------------------
 		
 		WebElement seleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1117']")));
	    seleccionarRemesa.click();
	    Thread.sleep(secDelay);
	    Actions actions = new Actions(driver);
	    
	    //Mantener presionada la tecla Shift y presionar la tecla flecha hacia abajo-------------------------------------------------------------------------
	    
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
	    
	    //INVENTARIO EMISOR--------------------------------------------------------------------------------
	    
	    String VisualizarInventarioEmisor = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(VisualizarInventarioEmisor);
		WebElement Consultar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar4.click();		Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Emisor2 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Emisor2 = CantidadDenominacion_100_Emisor2.getText();
  		Cantidad_100_Emisor2 = Cantidad_100_Emisor2.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Aprobado_Emisor = Double.parseDouble(Cantidad_100_Emisor2);
  		System.out.println(ObtenerPiezasDenominacion_100_Aprobado_Emisor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Aprobado_Emisor, ObtenerPiezasDenominacion_100_Solicitado_Emisor, 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado aprobado (Inventario emisor)");
	 		
			File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(archivo2, new File(captura2));	Thread.sleep(secDelay);Thread.sleep(secDelay);
	 		
		//INVENTARIO RECEPTOR----------------------------------------------------------------------------------
	    
		 String VisualizarInventarioReceptor = (String) handles2.toArray()[handles2.size() - 1];
		 driver.switchTo().window(VisualizarInventarioReceptor);
	 	    
 		WebElement Consultar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar5.click();		Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Receptor2 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1018']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Receptor2 = CantidadDenominacion_100_Receptor2.getText();
  		Cantidad_100_Receptor2 = Cantidad_100_Receptor2.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Aprobado_Receptor = Double.parseDouble(Cantidad_100_Receptor2);
  		System.out.println(ObtenerPiezasDenominacion_100_Aprobado_Receptor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Aprobado_Receptor, ObtenerPiezasDenominacion_100_Solicitado_Receptor, 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado aprobado (Inventario receptor)");
 	 		
			File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(archivo4, new File(captura4));	Thread.sleep(secDelay);Thread.sleep(secDelay);
 		
		//PANTALLA DE ENVIOS----------------------------------------------------------------------------------
 		
 		String Envios2 = (String) handles2.toArray()[handles2.size() - 3];
		driver.switchTo().window(Envios2);
		 
		WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tool-1113-toolEl")));
		Retro.click(); 	
	 	WebElement Filtros2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnInnerEl")));
		Filtros2.click();	  Thread.sleep(secDelay);	
		WebElement DesplegarEstados2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estadoConsulta-trigger-picker")));
		DesplegarEstados2.click();	   Thread.sleep(secDelay);
	 	WebElement Estados2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aprobado']")));
 		Estados2.click();	  Thread.sleep(secDelay);	
	 	WebElement ConsultarFiltros2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1226-btnInnerEl")));
	 	ConsultarFiltros2.click();
 		WebElement Estado3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1065-titleEl")));
 		Estado3.click();	
 		WebElement Estado4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1065-titleEl")));
 		Estado4.click();
 		WebElement seleccionarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1117']")));
	    seleccionarRemesa2.click();		Thread.sleep(secDelay);
	    Actions actions2 = new Actions(driver);

	    //Mantener presionada la tecla Shift y presionar la tecla flecha hacia abajo-----------------------------------------
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
	    
	    //INVENTARIO EMISOR---------------------------------------------------------------------------------------------------
		 	
 		String VisualizarInventarioEmisor2 = (String) handles.toArray()[handles.size() - 1];
 	    driver.switchTo().window(VisualizarInventarioEmisor2);
 	    
 		
 		WebElement Consultar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar6.click();		Thread.sleep(secDelay);
 	 		
 		WebElement CantidadDenominacion_100_Emisor3 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Emisor3 = CantidadDenominacion_100_Emisor3.getText();
  		Cantidad_100_Emisor3 = Cantidad_100_Emisor3.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Despachado_Emisor = Double.parseDouble(Cantidad_100_Emisor3);
  		System.out.println(ObtenerPiezasDenominacion_100_Despachado_Emisor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Despachado_Emisor, (ObtenerPiezasDenominacion_100_Aprobado_Emisor - 2), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Despachado (Inventario emisor)");
 	 		
 	  		File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 	  		FileUtils.copyFile(archivo5, new File(captura5));	Thread.sleep(secDelay);Thread.sleep(secDelay);
 	 		
 	 	//INVENTARIO RECEPTOR-------------------------------------------------------------------------------------------------	
 	    
 		String VisualizarInventarioReceptor2 = (String) handles2.toArray()[handles2.size() - 1];
 		driver.switchTo().window(VisualizarInventarioReceptor2);	
 	 	    
  		WebElement Consultar7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar7.click();		Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Receptor3 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1018']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Receptor3 = CantidadDenominacion_100_Receptor3.getText();
  		Cantidad_100_Receptor3 = Cantidad_100_Receptor3.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Despachado_Receptor = Double.parseDouble(Cantidad_100_Receptor3);
  		System.out.println(ObtenerPiezasDenominacion_100_Despachado_Receptor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Despachado_Receptor, (ObtenerPiezasDenominacion_100_Aprobado_Receptor), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Despachado (Inventario Receptor)");
  	 		
			File archivo6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(archivo6, new File(captura6));	Thread.sleep(secDelay);Thread.sleep(secDelay);
  		
		//PANTALLA ENVIO----------------------------------------------------------------------------------------------------
  		
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
 	 	WebElement ConsultarFiltros3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1226-btnInnerEl")));
 	 	ConsultarFiltros3.click();	
  		WebElement Estado5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
  		Estado5.click();	
  		WebElement Estado6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
  		Estado6.click();
  		WebElement seleccionarRemesa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1117']")));
	    seleccionarRemesa3.click();		Thread.sleep(secDelay);
	    
	    Actions actions3 = new Actions(driver);

	    //Mantener presionada la tecla Shift y presionar la tecla flecha hacia abajo--------------------------------------
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
	    
	    //INVENTARIO EMISOR-------------------------------------------------------------------------------------------------
	 	
 		 String VisualizarInventarioEmisor3 = (String) handles.toArray()[handles.size() - 1];
 	    driver.switchTo().window(VisualizarInventarioEmisor3);
 	    
 		
 		WebElement Consultar8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar8.click();		Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Emisor4 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Emisor4 = CantidadDenominacion_100_Emisor4.getText();
  		Cantidad_100_Emisor4 = Cantidad_100_Emisor4.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Recibido_Emisor = Double.parseDouble(Cantidad_100_Emisor4);
  		System.out.println(ObtenerPiezasDenominacion_100_Recibido_Emisor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Recibido_Emisor, (ObtenerPiezasDenominacion_100_Despachado_Emisor), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado recibido (Inventario emisor)");
 	 		
	 		File archivo7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo7, new File(captura7));	Thread.sleep(secDelay);Thread.sleep(secDelay);
 	 		
 		//INVENTARIO RECEPTOR------------------------------------------------------------------------------------------------	
 	    
 		 String VisualizarInventarioReceptor3 = (String) handles2.toArray()[handles2.size() - 1];
 		 driver.switchTo().window(VisualizarInventarioReceptor3);
 	 	    
  		WebElement Consultar9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar9.click();		Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Receptor4 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1018']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Receptor4 = CantidadDenominacion_100_Receptor4.getText();
  		Cantidad_100_Receptor4 = Cantidad_100_Receptor4.replace(".", "");
  		double ObtenerPiezasDenominacion_100_Recibido_Receptor = Double.parseDouble(Cantidad_100_Receptor4);
  		System.out.println(ObtenerPiezasDenominacion_100_Recibido_Receptor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Recibido_Receptor, (ObtenerPiezasDenominacion_100_Despachado_Receptor + 2), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado recibido (Inventario Receptor)");
  	 		
			File archivo8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(archivo8, new File(captura8));	Thread.sleep(secDelay);Thread.sleep(secDelay);
  		
	    //PANTALLA ENVIO-----------------------------------------------------------------------------------------------------
  		
	  		String Envios4 = (String) handles2.toArray()[handles2.size() - 3];
	 		driver.switchTo().window(Envios4);
	 		
 		WebElement Retro3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tool-1113-toolEl")));
	 	Retro3.click(); 	
 	 	WebElement Filtros4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnInnerEl")));
		Filtros4.click();	  Thread.sleep(secDelay);
 		WebElement DesplegarEstados4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estadoConsulta-trigger-picker")));
		DesplegarEstados4.click();	   Thread.sleep(secDelay);    	
 	 	WebElement Estados4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Recibido']")));
 		Estados4.click();	  Thread.sleep(secDelay);
 	 	WebElement ConsultarFiltros4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1226-btnInnerEl")));
 	 	ConsultarFiltros4.click();
  		WebElement Estado7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
  		Estado7.click();	
  		WebElement Estado8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1066-titleEl")));
  		Estado8.click();
		 	
  		WebElement seleccionarRemesa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1117']")));
	    seleccionarRemesa4.click();		Thread.sleep(secDelay);
	    
	    Actions actions4 = new Actions(driver);
	    //Mantener presionada la tecla Shift y presionar la tecla flecha hacia abajo---------------------------------------------------
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
	    
	    //INVENTARIO EMISOR------------------------------------------------------------------------------------------------------------
	 	
 		String VisualizarInventarioEmisor4 = (String) handles.toArray()[handles.size() - 1];
 	    driver.switchTo().window(VisualizarInventarioEmisor4);
 		WebElement Consultar10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar10.click();	 Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Emisor5 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Emisor5 = CantidadDenominacion_100_Emisor5.getText();
  		Cantidad_100_Emisor5 = Cantidad_100_Emisor5.replace(".", "");
  		double ObtenerPiezasDenominacion_100_ConfirmadoSinAjustes_Emisor = Double.parseDouble(Cantidad_100_Emisor5);
  		System.out.println(ObtenerPiezasDenominacion_100_ConfirmadoSinAjustes_Emisor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_ConfirmadoSinAjustes_Emisor, (ObtenerPiezasDenominacion_100_Recibido_Emisor), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Confirmado Sin Ajustes (Inventario emisor)");
 	 		
	 		File archivo9 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo9, new File(captura9));	Thread.sleep(secDelay);Thread.sleep(secDelay);
 	 		
        //INVENTARIO RECEPTOR----------------------------------------------------------------------------------------------------------	
 	    
 		 String VisualizarInventarioReceptor4 = (String) handles2.toArray()[handles2.size() - 1];
 		 driver.switchTo().window(VisualizarInventarioReceptor4);
 	 	    
  		WebElement Consultar11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
 		Consultar11.click();	 Thread.sleep(secDelay);
 		
 		WebElement CantidadDenominacion_100_Receptor5 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1018']"));
 		Thread.sleep(secDelay);
  		String Cantidad_100_Receptor5 = CantidadDenominacion_100_Receptor5.getText();
  		Cantidad_100_Receptor5 = Cantidad_100_Receptor5.replace(".", "");
  		double ObtenerPiezasDenominacion_100_ConsfirmadoSinAjustes_Receptor = Double.parseDouble(Cantidad_100_Receptor5);
  		System.out.println(ObtenerPiezasDenominacion_100_ConsfirmadoSinAjustes_Receptor);
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_ConsfirmadoSinAjustes_Receptor, (ObtenerPiezasDenominacion_100_Recibido_Receptor), 0.000001);
  		System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Confirmado Sin Ajustes (Inventario Receptor)");
  	 	
	 		File archivo10 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo10, new File(captura10));		Thread.sleep(secDelay);Thread.sleep(secDelay);	 		
	}
}
