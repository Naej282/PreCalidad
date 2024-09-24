package Integrales;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constantes.Constante_PreCalidad;
import DataDrivenTesting.ReadExcelFile;
import DataDrivenTesting.WriteExcelFile;

public class Cases_438_454 {
	
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
		
		driver.get(Constante_PreCalidad.URL_CENTRAL);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InterruptedException {
		
		//  ----------  Remesa Centro de Acopio a Banco Central  ----------			
		
		
		// Excel - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		String filepath =  "" + Constante_PreCalidad.RUTA_EXCEL + "\\MatrizIntegrales.xlsx";
							
		String TipoUnidadEmisora_Envio = readFile.getCellValue(filepath, "Cases", 6, 1);
		String UnidadEmisora_Envio = readFile.getCellValue(filepath, "Cases", 6, 2);
		String TipoUnidadReceptora_Envio = readFile.getCellValue(filepath, "Cases", 6, 3);
		String UnidadReceptora_Envio = readFile.getCellValue(filepath, "Cases", 6, 4);
		String EmpresaTransportista = readFile.getCellValue(filepath, "Cases", 6, 5);
												
		String TipoUnidadEmisora_Inventario = readFile.getCellValue(filepath, "General", 9, 1);
		String UnidadEmisora_Inventario = readFile.getCellValue(filepath, "General", 9, 2);
		String TipoUnidadReceptora_Inventario = readFile.getCellValue(filepath, "General", 10, 1);
		String UnidadReceptora_Inventario = readFile.getCellValue(filepath, "General", 10, 2);
								
		String TipoUnidadEmisora_Consulta = readFile.getCellValue(filepath, "General", 9, 1);
		String UnidadEmisora_Consulta = readFile.getCellValue(filepath, "General", 9, 3);
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		int Monto = 4;
		double Diferencia = 1;		
		String DiferenciaString = String.format("%.0f", Diferencia);
		
		
		// Cambio de Pestaña - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
					
		String InventarioEmisor = Constante_PreCalidad.URL_CENTRAL;		
		String Central_Envios = Constante_PreCalidad.URL_CENTRAL_ENVIO;
									

		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -			
			 				 
		 WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
	 	       
		 WebElement Login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		 Login.sendKeys(Constante_PreCalidad.USUARIO);
		 WebElement Password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		 Password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
		 WebElement Enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		 Enter.click();
		 
		 
		// Validar Asientos Contables - Inicio - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		 
		 WebElement Consultas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/consultas.jpg']")));
		 Consultas.click();    Thread.sleep(secDelay);
		 
		 WebElement ConsultasGenerales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("consultasGenerales")));
		 ConsultasGenerales.click();    Thread.sleep(secDelay);
		    	             	  
		 WebElement DesplegarReporInicial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reporteReportConsult-trigger-picker")));
		 DesplegarReporInicial.click();
		 WebElement SeleccionarReportes_Inicial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#boundlist-1021-listEl > li:nth-child(3)")));
		 SeleccionarReportes_Inicial.click();     Thread.sleep(secDelay);

		 WebElement DesplegarTipoUnidad_Inicial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoAgrupacionReportConsult-trigger-picker")));
		 DesplegarTipoUnidad_Inicial.click();     Thread.sleep(secDelay);
		 WebElement SeleccionarTipoUnidad_Inicial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + TipoUnidadEmisora_Consulta + "']")));
		 SeleccionarTipoUnidad_Inicial.click();     Thread.sleep(secDelay);	

		 WebElement DesplegarUnidad_Inicial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreAgrupacionReportConsult-trigger-picker")));
		 DesplegarUnidad_Inicial.click();     Thread.sleep(secDelay);
		 WebElement SeleccionarUnidad_Inicial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + UnidadEmisora_Consulta + "']")));
		 SeleccionarUnidad_Inicial.click();     Thread.sleep(secDelay);

		 WebElement DesplegarDivisas_Inicial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaReportConsult-trigger-picker")));
		 DesplegarDivisas_Inicial.click();     Thread.sleep(secDelay);
		 WebElement SeleccionarDivisa_Inicial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		 SeleccionarDivisa_Inicial.click();     Thread.sleep(secDelay);

		 WebElement IconoImprimir_Inicial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		 IconoImprimir_Inicial.click();     Thread.sleep(secDelay);
		    	             	  	
		 WebElement AceptarImprimir_Inicial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		 AceptarImprimir_Inicial.click(); 
		 
		 try {
	        	
	            WebElement InicioAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	        	InicioAgencia.click();   
	            
	        } catch (AssertionError e) {
	        	
	        	   driver.navigate().refresh();
	               WebElement InicioAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	           	   InicioAgencia.click();  
	        }
		 
		 
     
		 // Consulta Inventario Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -			
		    
		 js.executeScript("window.open(arguments[0]);", InventarioEmisor);	  
		    
		 Set<String> handles = driver.getWindowHandles();
		    
		 String InventarioInicialEmisor = (String) handles.toArray()[handles.size() - 1];
		 	driver.switchTo().window(InventarioInicialEmisor);
		 
		 WebElement LoginCentral_InventarioEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		LoginCentral_InventarioEmisor.sendKeys(Constante_PreCalidad.USUARIO);
		WebElement PasswordCentral_InventarioEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		PasswordCentral_InventarioEmisor.sendKeys(Constante_PreCalidad.CONTRASEÑA);		Thread.sleep(secDelay);
		WebElement EnterCentral_InventarioEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		EnterCentral_InventarioEmisor.click();	   Thread.sleep(secDelay);
    	   		 
		WebElement Logistica_InventarioEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
		Logistica_InventarioEmisor.click();
		WebElement InventarioEfectivo_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventarioEfectivo")));
		InventarioEfectivo_Emisor.click();	   Thread.sleep(secDelay);
		  	    	     	    
		WebElement DesplegarTipoUnidadEmisora_Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
		DesplegarTipoUnidadEmisora_Inventario.click();	  Thread.sleep(secDelay);	
		WebElement SeleccionarTipoUnidadEmisora_Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + TipoUnidadEmisora_Inventario + "']")));
		SeleccionarTipoUnidadEmisora_Inventario.click();     Thread.sleep(secDelay);		  	 	
		WebElement DesplegarUnidadEmisora_Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
		DesplegarUnidadEmisora_Inventario.click();	   Thread.sleep(secDelay);
		WebElement SeleccionarUnidadEmisora_Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + UnidadEmisora_Inventario + "']")));
		SeleccionarUnidadEmisora_Inventario.click();	 Thread.sleep(secDelay);	
		WebElement DesplegarBovedaEmisora_Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoBoveda-trigger-picker")));
		DesplegarBovedaEmisora_Inventario.click();	   Thread.sleep(secDelay);
		WebElement SeleccionarBovedaEmisora_Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
		SeleccionarBovedaEmisora_Inventario.click();	 Thread.sleep(secDelay);	
		WebElement DesplegaDivisaEmisora_Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		DesplegaDivisaEmisora_Inventario.click();     Thread.sleep(secDelay);
        WebElement SeleccionarDivisaEmisora_Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + Constante_PreCalidad.DIVISA + "']")));
		SeleccionarDivisaEmisora_Inventario.click();
	     
		WebElement ConsultarInventarioEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		ConsultarInventarioEmisor.click();
		
		WebElement DesplegarConsultaInventarioEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
		DesplegarConsultaInventarioEmisor.click();	     
		  	     
		WebElement CantidadDenominacion_100_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
	    	String Cantidad_100_Emisor = CantidadDenominacion_100_Emisor.getText();
	    	Cantidad_100_Emisor = Cantidad_100_Emisor.replace(".", "");
	    	double ObtenerPiezasDenominacion_100_Solicitado_Emisor = Double.parseDouble(Cantidad_100_Emisor);
	    	System.out.println(Cantidad_100_Emisor);

	    String ConsultaCantidad_100_Emisor =  Cantidad_100_Emisor;
			writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 1, ConsultaCantidad_100_Emisor);
    	 
    	 
    	 // Envio Central - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -			 
    	            	
         String Inicio = (String) handles.toArray()[handles.size() - 2];
 	     	driver.switchTo().window(Inicio);
 	    
 	     WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
 	     Logistica.click();
 	     WebElement AdministracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
 	     AdministracionEfectivo.click();
 	     WebElement Envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
 	     Envios.click();       
 		
 	    WebElement Crearenvios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
	    Crearenvios.click();
	    
	    WebElement cDesplegarTipoUnidadEmisora_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadEmisoraCrear-trigger-picker")));
	    cDesplegarTipoUnidadEmisora_Envio.click();
	    WebElement cCampoTipoUnidadEmisora_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadEmisoraCrear-inputEl")));
	    cCampoTipoUnidadEmisora_Envio.click();     Thread.sleep(secDelay);
	    WebElement cEscribirTipoUnidadEmisora_Envio = driver.findElement(escribirTipoUnidadEmisoraLocator);
	    cEscribirTipoUnidadEmisora_Envio.sendKeys(TipoUnidadEmisora_Envio);
	    cEscribirTipoUnidadEmisora_Envio.sendKeys(Keys.ENTER);		Thread.sleep(secDelay);
		WebElement cDesplegarUnidadEmisora_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadEmisoraCrear-trigger-picker")));
		cDesplegarUnidadEmisora_Envio.click();	   Thread.sleep(secDelay);
		WebElement cEscribirUnidadEmisora_Envio = driver.findElement(escribirUnidadEmisoraLocator);
		cEscribirUnidadEmisora_Envio.sendKeys(UnidadEmisora_Envio);
	    cEscribirUnidadEmisora_Envio.sendKeys(Keys.ENTER);	    Thread.sleep(secDelay);
	    WebElement cDesplegarTipoUnidadReceptora_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadReceptoraCrear-trigger-picker")));
	    cDesplegarTipoUnidadReceptora_Envio.click();	 
	    WebElement cEscribirTipoUnidadReceptora_Envio = driver.findElement(escribirTipoUnidadReceptoraLocator);
	    cEscribirTipoUnidadReceptora_Envio.sendKeys(TipoUnidadReceptora_Envio);
	    cEscribirTipoUnidadReceptora_Envio.sendKeys(Keys.ENTER);	    Thread.sleep(secDelay);
	    WebElement cEscribirUnidadReceptora = driver.findElement(escribirUnidadReceptoraLocator);
	    cEscribirUnidadReceptora.sendKeys(UnidadReceptora_Envio);
	    cEscribirUnidadReceptora.sendKeys(Keys.ENTER);	    Thread.sleep(secDelay);
	    WebElement cEscribirEmpresaTransportista = driver.findElement(escribirEmpresaTransportistaLocator);
	    cEscribirEmpresaTransportista.sendKeys(EmpresaTransportista);
	    cEscribirEmpresaTransportista.sendKeys(Keys.ENTER);
	    
	    WebElement cBotonSiguiente_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnWrap")));
	    cBotonSiguiente_Envio.click();
	    
	    WebElement cDesplegarDivisa_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
	    cDesplegarDivisa_Envio.click();
	    WebElement cSeleccionarDivisa_Envio = driver.findElement(By.xpath("//li[text()='Dólar']"));
	    cSeleccionarDivisa_Envio.click();
	        
	    Random rand = new Random();
	    int numeroAleatorio_Cataporte = rand.nextInt(1000000) + 1000000000;
	    String NumeroTexto = Integer.toString(numeroAleatorio_Cataporte);
	    WebElement NumeroServicioAleatorio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl"))); 
	    NumeroServicioAleatorio.sendKeys(String.valueOf(NumeroTexto)); 
	    System.out.println("El Cataporte es: " + NumeroTexto);
	        
	    WebElement destinoDesplegar = driver.findElement(By.id("destinoCrear-trigger-picker"));
    		if (destinoDesplegar.isEnabled()) {
    			destinoDesplegar.click();
    		} else {
    		
    		}
    		Thread.sleep(secDelay);

    	try {
    		WebElement destinoSeleccionar = driver.findElement(By.xpath("//li[text()='Boveda']"));
    		destinoSeleccionar.click();
    	} catch (NoSuchElementException e){
    		
    	}
     
    	Thread.sleep(secDelay);
	     
    	WebElement cBotonIncluir_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear-btnWrap")));
        cBotonIncluir_Envio.click();     Thread.sleep(secDelay);

        WebElement cDesplegarTipoEnvase_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvaseCrear-trigger-picker")));
        cDesplegarTipoEnvase_Envio.click();
        WebElement cSeleccionarTipoEnvase_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOLSA']")));
        cSeleccionarTipoEnvase_Envio.click();
        WebElement cDesplegarTipoPieza_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
        cDesplegarTipoPieza_Envio.click();
        WebElement cSeleccionarTipoPieza_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billetes']")));
        cSeleccionarTipoPieza_Envio.click();
        WebElement cColocarCantidadEnvases_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
        cColocarCantidadEnvases_Envio.sendKeys("1");
         
        WebElement cBotonIncluirEnvases_Emvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear-btnWrap")));
        cBotonIncluirEnvases_Emvio.click();
         
        WebElement cImputNumeroPlomos_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
        cImputNumeroPlomos_Envio.sendKeys("1");
         
        WebElement cBotonIncluirPlomos_Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnIconEl")));
        cBotonIncluirPlomos_Envio.click();     Thread.sleep(secDelay);
         
        WebElement ElementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1163']")); //En 2.6 es 1163 y en 2.5 es 1161
        Actions doble = new Actions(driver);
        doble.doubleClick(ElementoCantidad).perform();	Thread.sleep(secDelay);
			
	    List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));
	    boolean elementoEncontrado = false;
	    for (WebElement elemento : elementos) {
	         if (elemento.isEnabled()) {
	             Actions actions = new Actions(driver);
	             actions.click(ElementoCantidad).sendKeys((String.valueOf(Monto))).sendKeys(Keys.ENTER).perform();
	             elementoEncontrado = true;
	             break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
	         }
	     }
	     if (!elementoEncontrado) {
	         System.out.println("Ninguno de los elementos está habilitado.");
	         
	         
	     } Thread.sleep(secDelay);	     	     
	     
	    WebElement cAceptarCreacionEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar1-btnWrap")));
	    cAceptarCreacionEnvio.click();     Thread.sleep(secDelay);
	  	        
	    WebElement cMensajeCreacionEnvio = driver.findElement(By.id("messagebox-1027-msg"));
	    	String CreacionEnvio = cMensajeCreacionEnvio.getText(); 
	    	System.out.println("La creacion Fue: " + CreacionEnvio);	Thread.sleep(secDelay);
	    	
	    WebElement MensajeCreacionRemesa = driver.findElement(By.id("messagebox-1027-msg"));
	    	String ObtenerMensaje = MensajeCreacionRemesa.getText().trim();
	    	System.out.println(ObtenerMensaje);
	    	String ExpectativaTexto = "Registro creado exitosamente";

	    	Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
	     
	    WebElement cAceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
	    cAceptarMensajeInformativo.click();
	   
	    driver.navigate().refresh();
	    
	     
	    // Mensaje Creacion Remesa - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	        
	    String MensajeInformativo = CreacionEnvio;
		 	writeFile.writeCellValue(filepath, "Cases", 6, 7, MensajeInformativo);	
	    	 	
	        
	    //Mensaje Cataporte Remesa - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	 
	    	 	
		String Cataporte =  NumeroTexto;
	       	writeFile.writeCellValue(filepath, "Cases", 6, 8, Cataporte);	        Thread.sleep(secDelay);
	    	
	    	
	    //Avance de Remesa
	    	
	    String NroServicio = readFile.getCellValue(filepath, "Cases", 6, 8);
	        
	    WebElement Filtros_Central = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
	    Filtros_Central.click();
	    WebElement CampoNroServicio_Central = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
	    CampoNroServicio_Central.sendKeys(NroServicio);	     Thread.sleep(secDelay);

	    WebElement ConsultarFiltros_Central = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
	    ConsultarFiltros_Central.click();	   Thread.sleep(secDelay);
	     	        
	    WebElement SeleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	    SeleccionarRemesa.click();	    Thread.sleep(secDelay);

	    WebElement BotonAvanzarEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
	    BotonAvanzarEstadoAprobado.click();     Thread.sleep(secDelay);	     
	    WebElement AvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
	    AvanceEstadoAprobado.click();     Thread.sleep(secDelay);

	    WebElement MensajeConfirmacionAprobado = driver.findElement(By.id("messagebox-1027-msg"));
			String MensajeAprobado = MensajeConfirmacionAprobado.getText();
			System.out.println("Avance: " + MensajeAprobado);	Thread.sleep(secDelay);
	
		WebElement InformacionAvanceAprobado = driver.findElement(By.id("messagebox-1027-msg"));
			String ObtenerMensajeAprobado = InformacionAvanceAprobado.getText().trim();
			System.out.println(ObtenerMensajeAprobado);
			String ExpectativaTextoAprobado = "Registro modificado exitosamente";
	
			Assert.assertEquals(ObtenerMensajeAprobado, ExpectativaTextoAprobado);	
	               
		WebElement AceptarAvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		AceptarAvanceEstadoAprobado.click();    
	          
		String MensajeInformativoAprobado =  MensajeAprobado;
			writeFile.writeCellValue(filepath, "Cases", 6, 9, MensajeInformativoAprobado);    		Thread.sleep(secDelay);	
			
	        	
	    // Inventario Aprobado - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	        		    	        	
	    String InventarioAprobado_Emisor = (String) handles.toArray()[handles.size() - 1];
	      	driver.switchTo().window(InventarioAprobado_Emisor);	
	    	    
	    WebElement CosultarInventarioAprobado_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    CosultarInventarioAprobado_Emisor.click();     Thread.sleep(secDelay);
	    	   	
	    WebElement CantidadDenominacion_100_Aprobado_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
			String Aprobado_Emisor = CantidadDenominacion_100_Aprobado_Emisor.getText();
			Aprobado_Emisor = Aprobado_Emisor.replace(".", "");
			double ObtenerPiezasDenominacion_100_Aprobado_Emisor = Double.parseDouble(Aprobado_Emisor);
			System.out.println(ObtenerPiezasDenominacion_100_Aprobado_Emisor);
				
			Assert.assertEquals(ObtenerPiezasDenominacion_100_Aprobado_Emisor, ObtenerPiezasDenominacion_100_Solicitado_Emisor, 0.000001);
	    		    		    	    	
		String ConsultaCantidad_100_Aprobado_Emisor =  Aprobado_Emisor;
			writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 2, ConsultaCantidad_100_Aprobado_Emisor); Thread.sleep(secDelay);
			
	      	
	    // Volver a Central - Remesa Aprobada - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	      	
	    String RemesaAprobada_Central = (String) handles.toArray()[handles.size() - 2];
	 	  	driver.switchTo().window(RemesaAprobada_Central);	Thread.sleep(secDelay);
	 	  	
	      
	 	// Avance Remesa a Despachado - Central -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 	  	
	 	WebElement SeleccionarRemesaAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	    SeleccionarRemesaAprobado.click();     Thread.sleep(secDelay);
	  
	    WebElement BotonAvanzarEstadoDespachada = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
	    BotonAvanzarEstadoDespachada.click();     Thread.sleep(secDelay);
	    WebElement AvanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
	    AvanceEstadoDespachado.click();	 Thread.sleep(secDelay);

	    WebElement ConfirmarAvanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnWrap")));
	    ConfirmarAvanceEstadoDespachado.click();     Thread.sleep(secDelay);
	    	          
	    WebElement MensajeConfirmacionDespachado = driver.findElement(By.id("messagebox-1027-msg"));
			String MensajeDespachado = MensajeConfirmacionDespachado.getText();
			System.out.println("Avance: " + MensajeDespachado);	

		WebElement InformacionAvanceDespachado = driver.findElement(By.id("messagebox-1027-msg"));
			String ObtenerMensajeDespachado = InformacionAvanceDespachado.getText().trim();
			System.out.println(ObtenerMensajeDespachado);
			String ExpectativaTextoDespachado = "Registro modificado exitosamente";
		
			Assert.assertEquals(ObtenerMensajeDespachado, ExpectativaTextoDespachado);	
  
		WebElement AceptarAvanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
		AceptarAvanceEstadoDespachado.click();     Thread.sleep(secDelay);

		String MensajeInformativoDespachado =  MensajeDespachado;
			writeFile.writeCellValue(filepath, "Cases", 6, 10, MensajeInformativoDespachado);        	Thread.sleep(secDelay);
	       
	        
		// Inventario Despachado - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -      
				     	
	    String InventarioDespachado_Emisor = (String) handles.toArray()[handles.size() - 1];
		 	 driver.switchTo().window(InventarioDespachado_Emisor);
	  	  
		WebElement CosultarInventarioDespachado_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
		CosultarInventarioDespachado_Emisor.click();	 Thread.sleep(secDelay);
			    
		WebElement CantidadDenominacion_100_Despachado_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
		 	String Despachado_Emisor = CantidadDenominacion_100_Despachado_Emisor.getText();
		 	Despachado_Emisor = Despachado_Emisor.replace(".", "");
		 	double ObtenerPiezasDenominacion_100_Despachado_Emisor = Double.parseDouble(Despachado_Emisor);
		 	System.out.println(ObtenerPiezasDenominacion_100_Despachado_Emisor);
		 			
		 	Assert.assertEquals(ObtenerPiezasDenominacion_100_Despachado_Emisor, (ObtenerPiezasDenominacion_100_Aprobado_Emisor - Monto), 0.000001);
		 	    		    		    		    	 	     
		String ConsultaCantidad_100_Despachado_Emisor =  Despachado_Emisor;
			writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 3, ConsultaCantidad_100_Despachado_Emisor);	    	Thread.sleep(secDelay);	
		 	
		 	
		// Volver a Central - Remesa Despachada - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	 	
	      	
		String RemesaDespachada = (String) handles.toArray()[handles.size() - 2];
			driver.switchTo().window(RemesaDespachada);		Thread.sleep(secDelay);
		 	
		 	
		// Avanzar Remesa a Recibido - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	 	
		 	
		WebElement SeleccionarRemesaDespachada = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		SeleccionarRemesaDespachada.click();     Thread.sleep(secDelay);

		WebElement BotonAvanzarEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        BotonAvanzarEstadoRecibido.click();     Thread.sleep(secDelay);
        WebElement AvanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        AvanceEstadoRecibido.click();     Thread.sleep(secDelay);
		         
        WebElement MensajeConfirmacionRecibido = driver.findElement(By.id("messagebox-1027-msg"));
			String MensajeRecibido = MensajeConfirmacionRecibido.getText();
			System.out.println("Avance: " + MensajeRecibido);

		WebElement InformacionAvanceRecibido = driver.findElement(By.id("messagebox-1027-msg"));
			String ObtenerMensajeRecibido = InformacionAvanceRecibido.getText().trim();
			System.out.println(ObtenerMensajeRecibido);
			String ExpectativaTextoRecibido = "Registro modificado exitosamente";

			Assert.assertEquals(ObtenerMensajeRecibido, ExpectativaTextoRecibido);	
		      	    	 
        WebElement AceptarAvanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        AceptarAvanceEstadoRecibido.click();
		          
		String MensajeInformativoRecibido =  MensajeRecibido;
			writeFile.writeCellValue(filepath, "Cases", 6, 11, MensajeInformativoRecibido);    		Thread.sleep(secDelay);
		 	
		 
		// Inventario Recibido - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	     	
		String InventarioRecibido_Emisor = (String) handles.toArray()[handles.size() - 1];
	    	driver.switchTo().window(InventarioRecibido_Emisor);
		  	  
	    WebElement CosultarInventarioRecibido_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
		CosultarInventarioRecibido_Emisor.click();	   Thread.sleep(secDelay);
		      	     
		WebElement CantidadDenominacion_100_Recibido_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
		    String Recibido_Emisor = CantidadDenominacion_100_Recibido_Emisor.getText();
		    Recibido_Emisor = Recibido_Emisor.replace(".", "");
		    double ObtenerPiezasDenominacion_100_Recibido_Emisor = Double.parseDouble(Recibido_Emisor);
		    System.out.println(ObtenerPiezasDenominacion_100_Recibido_Emisor);
		    	
	 	    Assert.assertEquals(ObtenerPiezasDenominacion_100_Recibido_Emisor, ObtenerPiezasDenominacion_100_Despachado_Emisor, 0.000001);
	 	    	 	     
	 	String ConsultaCantidad_100_Recibido_Emisor =  Recibido_Emisor;
	 		writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 4, ConsultaCantidad_100_Recibido_Emisor);	    	Thread.sleep(secDelay);	
		  	
		  	
	 	// Cambio Central - Remesa Recibida - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
		  	
		String RemesaRecibida = (String) handles.toArray()[handles.size() - 2];
          	driver.switchTo().window(RemesaRecibida);		 Thread.sleep(secDelay);
		  
		  
        // Avance Remesa a Confirmado Sin Ajuste - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	  
       	             
        WebElement SeleccionarRemesaRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        SeleccionarRemesaRecibido.click();     Thread.sleep(secDelay);

        WebElement BotonAvanzarEstadoConfirmado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        BotonAvanzarEstadoConfirmado.click();     Thread.sleep(secDelay);
            
        WebElement AvanceEstadoConfirmado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        AvanceEstadoConfirmado.click();     Thread.sleep(secDelay);
           
        WebElement MensajeConfirmacionConfirmado = driver.findElement(By.id("messagebox-1027-msg"));
    		String MensajeConfirmado = MensajeConfirmacionConfirmado.getText();
    		System.out.println("Avance: " + MensajeConfirmado);
        
    	WebElement InformacionAvanceConfirmado = driver.findElement(By.id("messagebox-1027-msg"));
    		String ObtenerMensajeConfirmado = InformacionAvanceConfirmado.getText().trim();
    		System.out.println(ObtenerMensajeConfirmado);
    		String ExpectativaTextoConfirmado = "Registro modificado exitosamente";

    		Assert.assertEquals(ObtenerMensajeConfirmado, ExpectativaTextoConfirmado);	
          	
        WebElement AceptarAvanceEstadoConfirmado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        AceptarAvanceEstadoConfirmado.click();
          	
        String MensajeInformativoConfirmado =  MensajeConfirmado;
    		writeFile.writeCellValue(filepath, "Cases", 6, 12, MensajeInformativoConfirmado); 			Thread.sleep(secDelay);  
    		
        
    	// Inventario Confirmado - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	  
          		     	
  		String InventarioConfirmado_Emisor = (String) handles.toArray()[handles.size() - 1];
  	      	driver.switchTo().window(InventarioConfirmado_Emisor);
  		  	  
  	    WebElement ConsultaInventarioConfirmado_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
  	    ConsultaInventarioConfirmado_Emisor.click();	 Thread.sleep(secDelay);
  	    
  	    WebElement CantidadDenominacion_100_Confirmado_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
  			String Confirmado_Emisor = CantidadDenominacion_100_Confirmado_Emisor.getText();
  			Confirmado_Emisor = Confirmado_Emisor.replace(".", "");
  			double ObtenerPiezasDenominacion_100_Confirmado_Emisor = Double.parseDouble(Confirmado_Emisor);
  			System.out.println(ObtenerPiezasDenominacion_100_Confirmado_Emisor);
  			
  		Assert.assertEquals(ObtenerPiezasDenominacion_100_Confirmado_Emisor, ObtenerPiezasDenominacion_100_Recibido_Emisor, 0.000001);
       
  		String ConsultaCantidad_100_Confirmado_Emisor =  Confirmado_Emisor;
  			writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 5, ConsultaCantidad_100_Confirmado_Emisor);         Thread.sleep(secDelay); 
  			
  		  	
  		// Cambio Central - Remesa Confirmada - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	  	 
		  	
  		String RemesaConfirmada = (String) handles.toArray()[handles.size() - 2];
            	driver.switchTo().window(RemesaConfirmada);				Thread.sleep(secDelay);
            	
  		  	
        // Reverso Confirmado Sin Ajuste - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	  	 	
	    	
        WebElement SeleccionarRemesaConfirmadoSinAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        SeleccionarRemesaConfirmadoSinAjuste.click();     Thread.sleep(secDelay);

        WebElement BotonReversarConfirmadoSinAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
        BotonReversarConfirmadoSinAjuste.click();
                
        WebElement ReversoEstadoConfirmadoSinAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
        ReversoEstadoConfirmadoSinAjuste.click();     Thread.sleep(secDelay);
                 
        WebElement MensajeReversoConfirmado = driver.findElement(By.id("messagebox-1027-msg"));
        	String Mensaje_Reverso_Confirmado = MensajeReversoConfirmado.getText();
        	System.out.println("Avance: " + Mensaje_Reverso_Confirmado);
        				    
        WebElement Informacion_ReversoConfirmado = driver.findElement(By.id("messagebox-1027-msg"));
        	String ObtenerMensaje_ReversoConfirmado = Informacion_ReversoConfirmado.getText().trim();
        	System.out.println(ObtenerMensaje_ReversoConfirmado);
        	String ExpectativaTexto_ReversoConfirmado = "Registro modificado exitosamente";

        	Assert.assertEquals(ObtenerMensaje_ReversoConfirmado, ExpectativaTexto_ReversoConfirmado);	
              	 
        WebElement AceptarReversoEstadoConfirmado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        AceptarReversoEstadoConfirmado.click();
              	
        String MensajeInformativo_ReversoConfirmado =  Mensaje_Reverso_Confirmado;
        	writeFile.writeCellValue(filepath, "Cases", 6, 13, MensajeInformativo_ReversoConfirmado); 			Thread.sleep(secDelay);  
        	
	      
        // Inventario Reverso Confirmado - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -		
	     	
  		String InventarioReversoConfirmado_Emisor = (String) handles.toArray()[handles.size() - 1];
  	    	driver.switchTo().window(InventarioReversoConfirmado_Emisor);
  		  	  
  	    WebElement CosultarInventarioReversoConfirmado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
  		CosultarInventarioReversoConfirmado.click();     Thread.sleep(secDelay); 
  	  	     
  		WebElement CantidadDenominacion_100_Reverso_Confirmado_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
  		    String ReversoConfirmado_Emisor = CantidadDenominacion_100_Reverso_Confirmado_Emisor.getText();
  		    ReversoConfirmado_Emisor = ReversoConfirmado_Emisor.replace(".", "");
  		    double ObtenerPiezasDenominacion_100_Reverso_Confirmado_Emisor = Double.parseDouble(ReversoConfirmado_Emisor);
  		    System.out.println(ObtenerPiezasDenominacion_100_Reverso_Confirmado_Emisor);
  		    	
  		    Assert.assertEquals(ObtenerPiezasDenominacion_100_Reverso_Confirmado_Emisor, ObtenerPiezasDenominacion_100_Confirmado_Emisor, 0.000001);
  		     
  		String ConsultaCantidad_100_Reverso_Confirmado_Emisor =  ReversoConfirmado_Emisor;
  		    writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 6, ConsultaCantidad_100_Reverso_Confirmado_Emisor);	    Thread.sleep(secDelay);
  		    
  		  	
  		// Volver a Central - Remesa Recibida - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -		
		  	
    	String EnvioReversoConfirmado = (String) handles.toArray()[handles.size() - 2];
          	driver.switchTo().window(EnvioReversoConfirmado);		
    	  	  	
          	
        // Reverso Recibido - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
          		    	
        WebElement SeleccionarRemesaReversoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
   	    SeleccionarRemesaReversoRecibido.click();   	Thread.sleep(secDelay);

   	    WebElement BotonReversarRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnInnerEl")));
   	    BotonReversarRecibido.click();
   	    WebElement ReversoEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
   	    ReversoEstadoRecibido.click();   	 Thread.sleep(secDelay);

   	    WebElement MensajeReversoRecibido = driver.findElement(By.id("messagebox-1027-msg"));
   	    	String Mensaje_Reverso_Recibido = MensajeReversoRecibido.getText();
   	    	System.out.println("Reverso: " + Mensaje_Reverso_Recibido);		Thread.sleep(secDelay);
   	    	
   	    WebElement Informacion_ReversoRecibido = driver.findElement(By.id("messagebox-1027-msg"));
   	    	String ObtenerMensaje_ReversoRecibido = Informacion_ReversoRecibido.getText().trim();
   	    	System.out.println(ObtenerMensaje_ReversoRecibido);
   	    	String ExpectativaTexto_ReversoRecibido = "Registro modificado exitosamente";
   	    	
   	    	Assert.assertEquals(ObtenerMensaje_ReversoRecibido, ExpectativaTexto_ReversoRecibido);	
 	    
		WebElement AceptarReversoEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		AceptarReversoEstadoRecibido.click();
 	
		String MensajeInformativo_ReversoRecibido =  Mensaje_Reverso_Recibido;
			writeFile.writeCellValue(filepath, "Cases", 6, 18, MensajeInformativo_ReversoRecibido);
	    
  	      
		// Inventario Reverso Recibido - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	     	
  		String InventarioReversoRecibido_Emisor = (String) handles.toArray()[handles.size() - 1];
  	      	driver.switchTo().window(InventarioReversoRecibido_Emisor);
  		  	  
  	  	WebElement CosultarInventarioReversoRecibido_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
        CosultarInventarioReversoRecibido_Emisor.click();
         	     
        WebElement CantidadDenominacion_100_ReversoRecibido_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
    		String ReversoRecibido_Emisor = CantidadDenominacion_100_ReversoRecibido_Emisor.getText();
    		ReversoRecibido_Emisor = ReversoRecibido_Emisor.replace(".", "");
    		double ObtenerPiezasDenominacion_100_Reverso_Recibido_Emisor = Double.parseDouble(ReversoRecibido_Emisor);
	    	System.out.println(ObtenerPiezasDenominacion_100_Reverso_Recibido_Emisor);
	    	
	    	Assert.assertEquals(ObtenerPiezasDenominacion_100_Reverso_Recibido_Emisor, ObtenerPiezasDenominacion_100_Reverso_Confirmado_Emisor, 0.000001);
         	     
	    String ConsultaCantidad_100_ReversoRecibido_Emisor =  ReversoRecibido_Emisor;
       	    writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 7, ConsultaCantidad_100_ReversoRecibido_Emisor);        Thread.sleep(secDelay);
       	    
  		  	
       	// Volver Central - Remesa Despachada - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	     
		  	
      	String EnvioReversoRecibido = (String) handles.toArray()[handles.size() - 2];
            driver.switchTo().window(EnvioReversoRecibido);			
            	
  		  	
        // Avance Devuelto - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	     	
 		  	
  		WebElement SeleccionarRemesaAvanceDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	    SeleccionarRemesaAvanceDevuelto.click();     Thread.sleep(secDelay);
	     
	    WebElement BotonAvanceAlternoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnInnerEl")));
        BotonAvanceAlternoDevuelto.click();
        
        WebElement DesplegarEstadoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
        DesplegarEstadoDevuelto.click();
        WebElement SeleccionarEstadoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item'][text()='Devuelto']")));
        SeleccionarEstadoDevuelto.click();
        
        WebElement AceptarEstadoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnInnerEl")));
        AceptarEstadoDevuelto.click();     Thread.sleep(secDelay);

        WebElement MensajeAvanceEstadoDevuelto = driver.findElement(By.id("messagebox-1027-msg"));
 			String Mensaje_Avance_Devuelto = MensajeAvanceEstadoDevuelto.getText();
 			System.out.println("Avance: " + Mensaje_Avance_Devuelto);		Thread.sleep(secDelay);
 	
 		WebElement Informacion_AvanceDevuelto = driver.findElement(By.id("messagebox-1027-msg"));
  			String ObtenerMensaje_AvanceDevuelto = Informacion_AvanceDevuelto.getText().trim();
  			System.out.println(ObtenerMensaje_AvanceDevuelto);
  			String ExpectativaTexto_AvanceDevuelto = "Registro modificado exitosamente";
  	
  			Assert.assertEquals(ObtenerMensaje_AvanceDevuelto, ExpectativaTexto_AvanceDevuelto);	
      	 
        WebElement AceptarAvanceEstadoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        AceptarAvanceEstadoDevuelto.click();
      	
        String MensajeInformativo_AvanceDevuelto =  Mensaje_Avance_Devuelto;
			writeFile.writeCellValue(filepath, "Cases", 6, 19, MensajeInformativo_AvanceDevuelto);
	    	
	    	
		// Inventario Devuelto - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	     	
	  	String InventarioDevuelto_Emisor = (String) handles.toArray()[handles.size() - 1];
	  		driver.switchTo().window(InventarioDevuelto_Emisor);
	  		  	  
	  	WebElement CosultarInventarioDevuelto_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    CosultarInventarioDevuelto_Emisor.click();     Thread.sleep(secDelay);
	         	     
	    WebElement CantidadDenominacion_100_Devuelto_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
	 		String Devuelto_Emisor = CantidadDenominacion_100_Devuelto_Emisor.getText();
	 		Devuelto_Emisor = Devuelto_Emisor.replace(".", "");
	 		double ObtenerPiezasDenominacion_100_Devuelto_Emisor = Double.parseDouble(Devuelto_Emisor);
	 		System.out.println(ObtenerPiezasDenominacion_100_Devuelto_Emisor);
	 		
	 		Assert.assertEquals(ObtenerPiezasDenominacion_100_Devuelto_Emisor, ObtenerPiezasDenominacion_100_Reverso_Recibido_Emisor, 0.000001);
		    	      	     
	 	String ConsultaCantidad_100_Devuelto_Emisor =  Devuelto_Emisor;
	 		writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 8, ConsultaCantidad_100_Devuelto_Emisor);        Thread.sleep(secDelay);
	 		
  		  	
	  	// Volver a Central - Remesa Devuelta
		  	
	  	String EnvioDevuelto = (String) handles.toArray()[handles.size() - 2];
	  	  	driver.switchTo().window(EnvioDevuelto);			
	            	
	  		  	
	  	// Avance Recibido Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	    	
	  	WebElement SeleccionarRemesaDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	    SeleccionarRemesaDevuelto.click();     Thread.sleep(secDelay);
	        
	    WebElement BotonAvanceEstadoRecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
	    BotonAvanceEstadoRecibidoEmisor.click();     Thread.sleep(secDelay);
	        
	    WebElement AvanceEstadoRecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
	    AvanceEstadoRecibidoEmisor.click();     Thread.sleep(secDelay);

	    WebElement MensajeAvanceEstadoRecibidoEmisor = driver.findElement(By.id("messagebox-1027-msg"));
			String Mensaje_Avance_RecibidoEmisor = MensajeAvanceEstadoRecibidoEmisor.getText();
			System.out.println("Avance: " + Mensaje_Avance_RecibidoEmisor);		Thread.sleep(secDelay);
		
		WebElement InformacionAvanceRecibidoEmisor = driver.findElement(By.id("messagebox-1027-msg"));
			String ObtenerMensajeRecibidoEmisor = InformacionAvanceRecibidoEmisor.getText().trim();
			System.out.println(ObtenerMensajeRecibidoEmisor);
			String ExpectativaTextoRecibidoEmisor = "Registro modificado exitosamente";
			
			Assert.assertEquals(ObtenerMensajeRecibidoEmisor, ExpectativaTextoRecibidoEmisor);	
	      	 
	    WebElement AceptarAvanceEstadoRecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    AceptarAvanceEstadoRecibidoEmisor.click();
	      	
		String MensajeInformativoRecibidoEmisor =  Mensaje_Avance_RecibidoEmisor;
	    	writeFile.writeCellValue(filepath, "Cases", 6, 20, MensajeInformativoRecibidoEmisor);
		  	
		  	
	    // Inventario Recibido Emisor - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	     	
		String InventarioRecibidoEmisor_Emisor = (String) handles.toArray()[handles.size() - 1];
		 	driver.switchTo().window(InventarioRecibidoEmisor_Emisor);
		  		  	  
		WebElement CosultaInventarioRecibidoEmisor_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    CosultaInventarioRecibidoEmisor_Emisor.click();     Thread.sleep(secDelay);	
	         	     
	    WebElement CantidadDenominacion_100_RecibidoEmisor_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
	    	String RecibidoEmisor_Emisor = CantidadDenominacion_100_RecibidoEmisor_Emisor.getText();
	    	RecibidoEmisor_Emisor = RecibidoEmisor_Emisor.replace(".", "");
	    	double ObtenerPiezasDenominacion_100_RecibidoEmisor_Emisor = Double.parseDouble(RecibidoEmisor_Emisor);
	    	System.out.println(ObtenerPiezasDenominacion_100_RecibidoEmisor_Emisor);
		    
	    	Assert.assertEquals(ObtenerPiezasDenominacion_100_RecibidoEmisor_Emisor, (ObtenerPiezasDenominacion_100_Devuelto_Emisor + Monto), 0.000001);
	         	     
	    String ConsultaCantidad_100_RecibidoEmisor_Emisor =  RecibidoEmisor_Emisor;
	    	writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 9, ConsultaCantidad_100_RecibidoEmisor_Emisor);        Thread.sleep(secDelay); 
	    	
	    	
	    // Volver Central - Remesa Recibida Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -		
		  	
		String RecibidoEmisor = (String) handles.toArray()[handles.size() - 2];
		 	driver.switchTo().window(RecibidoEmisor);		 Thread.sleep(secDelay);	
		 	
		 	
		// Avance Remesa Confirmado Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -		
	    	
		WebElement SeleccionarRemesaRecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		SeleccionarRemesaRecibidoEmisor.click();     Thread.sleep(secDelay);

		WebElement BotonAvanceEstadoConfirmadoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		BotonAvanceEstadoConfirmadoEmisor.click();
		        
		WebElement AvanceEstadoConfirmadoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		AvanceEstadoConfirmadoEmisor.click();     Thread.sleep(secDelay);

		WebElement MensajeAvanceEstadoConfirmadoEmisor = driver.findElement(By.id("messagebox-1027-msg"));
			String Mensaje_Avance_ConfirmadoEmisor = MensajeAvanceEstadoConfirmadoEmisor.getText();
			System.out.println("Avance: " + Mensaje_Avance_ConfirmadoEmisor);	Thread.sleep(secDelay);
				
		WebElement InformacionAvanceConfirmadoEmisor = driver.findElement(By.id("messagebox-1027-msg"));
			String ObtenerMensajeConfirmadoEmisor = InformacionAvanceConfirmadoEmisor.getText().trim();
			System.out.println(ObtenerMensajeConfirmadoEmisor);
			String ExpectativaTextoConfirmadoEmisor = "Registro modificado exitosamente";

			Assert.assertEquals(ObtenerMensajeConfirmadoEmisor, ExpectativaTextoConfirmadoEmisor);	
		      	 
        WebElement AceptarAvanceEstadoConfirmadoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		AceptarAvanceEstadoConfirmadoEmisor.click();
		      	
		String MensajeInformativoConfirmadoEmisor =  Mensaje_Avance_ConfirmadoEmisor;
			writeFile.writeCellValue(filepath, "Cases", 6, 21, MensajeInformativoConfirmadoEmisor);
			
		 	
		// Inventario Confirmado Emisor - Emisor  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	     	
	    String InventarioConfirmadoEmisor_Emisor = (String) handles.toArray()[handles.size() - 1];
			driver.switchTo().window(InventarioConfirmadoEmisor_Emisor);
			  		  	  
		WebElement CosultarInventarioConfirmadoEmisor_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    CosultarInventarioConfirmadoEmisor_Emisor.click();     Thread.sleep(secDelay);
	               	     
	    WebElement CantidadDenominacion_100_ConfirmadoEmisor_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
			String ConfirmadoEmisor_Emisor = CantidadDenominacion_100_ConfirmadoEmisor_Emisor.getText();
		    ConfirmadoEmisor_Emisor = ConfirmadoEmisor_Emisor.replace(".", "");
		    double ObtenerPiezasDenominacion_100_ConfirmadoEmisor_Emisor = Double.parseDouble(ConfirmadoEmisor_Emisor);
		    System.out.println(ObtenerPiezasDenominacion_100_ConfirmadoEmisor_Emisor);
		    	
		    Assert.assertEquals(ObtenerPiezasDenominacion_100_ConfirmadoEmisor_Emisor, ObtenerPiezasDenominacion_100_RecibidoEmisor_Emisor, 0.000001);	
		         	     
		String ConsultaCantidad_100_ConfirmadoEmisor_Emisor =  ConfirmadoEmisor_Emisor;
		    writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 10, ConsultaCantidad_100_ConfirmadoEmisor_Emisor);        Thread.sleep(secDelay);  
		    
		 	
		// Volver Central - Remesa Recibido Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -		
		  	
	    String ConfirmadoEmisor = (String) handles.toArray()[handles.size() - 2];
	     	driver.switchTo().window(ConfirmadoEmisor);	     Thread.sleep(secDelay);	
	     	
	     	
	    // Reverso Remesa Confirmado Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -		
          	
	    WebElement SeleccionarRemesaConfirmadoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	    SeleccionarRemesaConfirmadoEmisor.click();     Thread.sleep(secDelay);

	    WebElement BotonReversoEstadoConfirmadoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
	    BotonReversoEstadoConfirmadoEmisor.click();
	         
	    WebElement ReversoEstadoConfirmadoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	    ReversoEstadoConfirmadoEmisor.click();     Thread.sleep(secDelay);

	    WebElement MensajeReversoEstadoConfirmadoEmisor = driver.findElement(By.id("messagebox-1027-msg"));
	 	 	String Mensaje_Reverso_ConfirmadoEmisor = MensajeReversoEstadoConfirmadoEmisor.getText();
	 	 	System.out.println("Avance: " + Mensaje_Reverso_ConfirmadoEmisor);		Thread.sleep(secDelay);
	   	 
	 	WebElement Informacion_ReversoConfirmadoEmisor = driver.findElement(By.id("messagebox-1027-msg"));
	 		String ObtenerMensaje_ReversoConfirmadoEmisor = Informacion_ReversoConfirmadoEmisor.getText().trim();
	 		System.out.println(ObtenerMensaje_ReversoConfirmadoEmisor);
	 		String ExpectativaTexto_ReversoConfirmadoEmisor = "Registro modificado exitosamente";
	 	
	 		Assert.assertEquals(ObtenerMensaje_ReversoConfirmadoEmisor, ExpectativaTexto_ReversoConfirmadoEmisor);	
	           	 
	    WebElement AceptarReversoEstadoConfirmadoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    AceptarReversoEstadoConfirmadoEmisor.click();
	           	
	    String MensajeInformativo_ReversoConfirmadoEmisor =  Mensaje_Reverso_ConfirmadoEmisor;
	    	writeFile.writeCellValue(filepath, "Cases", 6, 22, MensajeInformativo_ReversoConfirmadoEmisor);	
	    	
	       		
	    // Inventario Reverso Confirmado Emisor - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	     	
	    String InventarioReversoConfirmadoEmisor_Emisor = (String) handles.toArray()[handles.size() - 1];
	     	driver.switchTo().window(InventarioReversoConfirmadoEmisor_Emisor);
	             	  
	    WebElement CosultarInventarioReversoConfirmadoEmisor_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    CosultarInventarioReversoConfirmadoEmisor_Emisor.click();     Thread.sleep(secDelay);
	                 	     
	    WebElement CantidadDenominacion_100_ReversoConfirmadoEmisor_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
	        String Reverso_ConfirmadoEmisor_Emisor = CantidadDenominacion_100_ReversoConfirmadoEmisor_Emisor.getText();
	        Reverso_ConfirmadoEmisor_Emisor = Reverso_ConfirmadoEmisor_Emisor.replace(".", "");
	        double ObtenerPiezasDenominacion_100_ReversoConfirmadoEmisor_Emisor = Double.parseDouble(Reverso_ConfirmadoEmisor_Emisor);
	        System.out.println(ObtenerPiezasDenominacion_100_ReversoConfirmadoEmisor_Emisor);
		    
	        Assert.assertEquals(ObtenerPiezasDenominacion_100_ReversoConfirmadoEmisor_Emisor, ObtenerPiezasDenominacion_100_ConfirmadoEmisor_Emisor, 0.000001);	
	             	     
	    String ConsultaCantidad_100_ReversoConfirmadoEmisor_Emisor =  Reverso_ConfirmadoEmisor_Emisor;
	    	writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 11, ConsultaCantidad_100_ReversoConfirmadoEmisor_Emisor);        Thread.sleep(secDelay);
	    	
	     	
	    // Volver Central - Remesa Recibisa Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -		
		  	
		String ReversoConfirmadoEmisor = (String) handles.toArray()[handles.size() - 2];
			 driver.switchTo().window(ReversoConfirmadoEmisor);		     Thread.sleep(secDelay);
	     	
	     	
		// Reverso - Remesa Recibido Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -				
          	
		WebElement SeleccionarRemesa_Reversar_RecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		SeleccionarRemesa_Reversar_RecibidoEmisor.click();     Thread.sleep(secDelay);
		
		WebElement BotonReversarRecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
		BotonReversarRecibidoEmisor.click();
		        
		WebElement ReversoEstadoRecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
		ReversoEstadoRecibidoEmisor.click();     Thread.sleep(secDelay);
		
		WebElement MensajeReversoRecibidoEmisor = driver.findElement(By.id("messagebox-1027-msg"));
			String Mensaje_Reverso_RecibidoEmisor = MensajeReversoRecibidoEmisor.getText();
		    System.out.println("Avance: " + Mensaje_Reverso_RecibidoEmisor);	Thread.sleep(secDelay);
		    	
		WebElement Informacion_ReversoRecibidoEmisor = driver.findElement(By.id("messagebox-1027-msg"));
			String ObtenerMensaje_ReversoRecibidoEmisor = Informacion_ReversoRecibidoEmisor.getText().trim();
			System.out.println(ObtenerMensaje_ReversoRecibidoEmisor);
			String ExpectativaTexto_ReversoRecibidoEmisor = "Registro modificado exitosamente";
			
			Assert.assertEquals(ObtenerMensaje_ReversoRecibidoEmisor, ExpectativaTexto_ReversoRecibidoEmisor);	
		                  	 
		WebElement AceptarReversoEstadoRecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		AceptarReversoEstadoRecibidoEmisor.click();
		                  	
		String MensajeInformativo_ReversoRecibidoEmisor =  Mensaje_Reverso_RecibidoEmisor;
			writeFile.writeCellValue(filepath, "Cases", 6, 23, MensajeInformativo_ReversoRecibidoEmisor);	
			
		     	
		// Inventario Reverso Recibido Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -					
		     	
		String InventarioReversoRecibidoEmisor_Emisor = (String) handles.toArray()[handles.size() - 1];
			driver.switchTo().window(InventarioReversoRecibidoEmisor_Emisor);
			             	  
		WebElement CosultarInventarioReversoRecibidoEmisor_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
        CosultarInventarioReversoRecibidoEmisor_Emisor.click();  Thread.sleep(secDelay);
          	
        WebElement CantidadDenominacion_100_ReversoRecibidoEmisor_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
        	String Reverso_RecibidoEmisor_Emisor = CantidadDenominacion_100_ReversoRecibidoEmisor_Emisor.getText();
            Reverso_RecibidoEmisor_Emisor = Reverso_RecibidoEmisor_Emisor.replace(".", "");
            double ObtenerPiezasDenominacion_100_ReversoRecibidoEmisor_Emisor = Double.parseDouble(Reverso_RecibidoEmisor_Emisor);
        	System.out.println(ObtenerPiezasDenominacion_100_ReversoRecibidoEmisor_Emisor);
        	
        	Assert.assertEquals(ObtenerPiezasDenominacion_100_ReversoRecibidoEmisor_Emisor, (ObtenerPiezasDenominacion_100_ReversoConfirmadoEmisor_Emisor - Monto), 0.000001);	
                         	     
        String ConsultaCantidad_100_ReversoRecibidoEmisor_Emisor =  Reverso_RecibidoEmisor_Emisor;
        	writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 12, ConsultaCantidad_100_ReversoRecibidoEmisor_Emisor);         Thread.sleep(secDelay);
        	
			     	
        // Volver Central - Reverso a Remesa Devuelto - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	      
			 	  	
		String ReversoRecibidoEmisor = (String) handles.toArray()[handles.size() - 2];
	    	driver.switchTo().window(ReversoRecibidoEmisor);			Thread.sleep(secDelay);	
			 	
			 	
	    // Reverso Remesa Devuelto - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	          	
	    WebElement SeleccionarRemesa_Reversar_Devuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	    SeleccionarRemesa_Reversar_Devuelto.click();     Thread.sleep(secDelay);
	        
	    WebElement BotonReversarDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
	    BotonReversarDevuelto.click();
	        
	    WebElement ReversoEstadoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	    ReversoEstadoDevuelto.click();     Thread.sleep(secDelay);
	        
	    WebElement MensajeReversoDevuelto = driver.findElement(By.id("messagebox-1027-msg"));
	   		String Mensaje_Reverso_Devuelto = MensajeReversoDevuelto.getText();
	   		System.out.println("Avance: " + Mensaje_Reverso_Devuelto);
	   	     
		WebElement Informacion_ReversoDevuelto = driver.findElement(By.id("messagebox-1027-msg"));
	  		String ObtenerMensaje_ReversoDevuelto = Informacion_ReversoDevuelto.getText().trim();
	  		System.out.println(ObtenerMensaje_ReversoDevuelto);
	  		String ExpectativaTexto_ReversoDevuelto = "Registro modificado exitosamente";
	  		
	  		Assert.assertEquals(ObtenerMensaje_ReversoDevuelto, ExpectativaTexto_ReversoDevuelto);	
	                     	 
	    WebElement AceptarReversoEstadoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    AceptarReversoEstadoDevuelto.click();
	                     	
	    String MensajeInformativo_Reverso_Devuelto =  Mensaje_Reverso_Devuelto;
	     	writeFile.writeCellValue(filepath, "Cases", 6, 24, MensajeInformativo_Reverso_Devuelto);
	     	
			 	
	  	// Consulta Reverso Inventario Devuelto - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
			     	
		String InventarioReversoDevuelto_Emisor = (String) handles.toArray()[handles.size() - 1];
			driver.switchTo().window(InventarioReversoDevuelto_Emisor);
					             	  
		WebElement CosultarInventarioReversoDevuelto_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    CosultarInventarioReversoDevuelto_Emisor.click();     Thread.sleep(secDelay);
	             	
	    WebElement CantidadDenominacion_100_ReversoDevuelto_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
	     	String Reverso_Devuelto_Emisor = CantidadDenominacion_100_ReversoDevuelto_Emisor.getText();
	     	Reverso_Devuelto_Emisor = Reverso_Devuelto_Emisor.replace(".", "");
	     	double ObtenerPiezasDenominacion_100_ReversoDevuelto_Emisor = Double.parseDouble(Reverso_Devuelto_Emisor);
	     	System.out.println(ObtenerPiezasDenominacion_100_ReversoDevuelto_Emisor);
	     	
	     	Assert.assertEquals(ObtenerPiezasDenominacion_100_ReversoDevuelto_Emisor, ObtenerPiezasDenominacion_100_ReversoRecibidoEmisor_Emisor, 0.000001);	
	                      	     
	    String ConsultaCantidad_100_ReversoDevuelto_Emisor =  Reverso_Devuelto_Emisor;
	    	writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 13, ConsultaCantidad_100_ReversoDevuelto_Emisor);         Thread.sleep(secDelay);  
			 	
					     	
	    // Volver Central - Remesa Despachada - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
					 	  	
		String AvanceAtracado = (String) handles.toArray()[handles.size() - 2];
			driver.switchTo().window(AvanceAtracado);	
			
	     	
		// Avance al Estado Atracado - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	    	
		WebElement SeleccionarRemesaAvanceAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	    SeleccionarRemesaAvanceAtracado.click();     Thread.sleep(secDelay);	

	    WebElement BotonAvanceAlternoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnInnerEl")));
	    BotonAvanceAlternoAtracado.click();
	          
	    WebElement DesplegarEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
	    DesplegarEstadoAtracado.click();
	    WebElement SeleccionarEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item x-boundlist-item-over'][text()='Atracado']"))); 
	    SeleccionarEstadoAtracado.click();
	          
	    WebElement AceptarEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnInnerEl")));
	    AceptarEstadoAtracado.click();     Thread.sleep(secDelay);
	    
	    WebElement MensajeAvanceEstadoAtracado = driver.findElement(By.id("messagebox-1027-msg"));
	  		String Mensaje_Avance_Atracado = MensajeAvanceEstadoAtracado.getText();
	  		System.out.println("Avance: " + Mensaje_Avance_Atracado);
	  	
	  	WebElement Informacion_Avance_Atracado = driver.findElement(By.id("messagebox-1027-msg"));
	  		String ObtenerMensaje_Avance_Atracado = Informacion_Avance_Atracado.getText().trim();
	  		System.out.println(ObtenerMensaje_Avance_Atracado);
	  		String ExpectativaTexto_Avance_Atracado = "Registro modificado exitosamente";
	      		
	  		Assert.assertEquals(ObtenerMensaje_Avance_Atracado, ExpectativaTexto_Avance_Atracado);	
	      	 
	    WebElement AceptarAvanceEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    AceptarAvanceEstadoAtracado.click();
	      	
	    String MensajeInformativo_Avance_Atracado =  Mensaje_Avance_Atracado;
	    	writeFile.writeCellValue(filepath, "Cases", 3, 25, MensajeInformativo_Avance_Atracado);
		    
		    
	    // Consulta Inventario Atracado - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	     	
		String InventarioAtracado_Emisor = (String) handles.toArray()[handles.size() - 1];
			driver.switchTo().window(InventarioAtracado_Emisor);
					             	  
		WebElement CosultarInventarioAtracado_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    CosultarInventarioAtracado_Emisor.click();     Thread.sleep(secDelay);
	         	
	    WebElement CantidadDenominacion_100_Atracado_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
	        String Avance_Atracado_Emisor = CantidadDenominacion_100_Atracado_Emisor.getText();
	        Avance_Atracado_Emisor = Avance_Atracado_Emisor.replace(".", "");
	        double ObtenerPiezasDenominacion_100_Atracado_Emisor = Double.parseDouble(Avance_Atracado_Emisor);
	        System.out.println(ObtenerPiezasDenominacion_100_Atracado_Emisor);
	  	    
	        Assert.assertEquals(ObtenerPiezasDenominacion_100_Atracado_Emisor, ObtenerPiezasDenominacion_100_ReversoDevuelto_Emisor, 0.000001);
	                      	     
	    String ConsultaCantidad_100_Avance_Atracado_Emisor =  Avance_Atracado_Emisor;
	        writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 14, ConsultaCantidad_100_Avance_Atracado_Emisor);          Thread.sleep(secDelay);  
			 	
			 	
		// Volver a Central - Remesa Recibido Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
		 	  	
		String ReversoAtracado = (String) handles.toArray()[handles.size() - 2];
			driver.switchTo().window(ReversoAtracado);	 	
			 	
			
	    // Reverso Estado Atracado - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	      
	    WebElement SeleccionarRemesaReversoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	    SeleccionarRemesaReversoAtracado.click();     Thread.sleep(secDelay);
	        
	    WebElement BotonReversarAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
	    BotonReversarAtracado.click();
	        
	    WebElement ReversoEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	    ReversoEstadoAtracado.click();     Thread.sleep(secDelay);
	          
	    WebElement MensajeReversoEstadoAtracado = driver.findElement(By.id("messagebox-1027-msg"));
	  		String Mensaje_Reverso_Atracado = MensajeReversoEstadoAtracado.getText();
	  		System.out.println("Reverso: " + Mensaje_Reverso_Atracado);
	  	
	  	WebElement Informacion_Reverso_Atracado = driver.findElement(By.id("messagebox-1027-msg"));
	  		String ObtenerMensaje_Reverso_Atracado = Informacion_Reverso_Atracado.getText().trim();
	  		System.out.println(ObtenerMensaje_Reverso_Atracado);
	  		String ExpectativaTexto_Reverso_Atracado = "Registro modificado exitosamente";
	 	
	  		Assert.assertEquals(ObtenerMensaje_Reverso_Atracado, ExpectativaTexto_Reverso_Atracado);	
	        		      	 
	    WebElement AceptarReversoEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    AceptarReversoEstadoAtracado.click();
	          
	    String MensajeInformativo_Reverso_Atracado =  Mensaje_Reverso_Atracado;
	        writeFile.writeCellValue(filepath, "Cases", 6, 26, MensajeInformativo_Reverso_Atracado);	
	        	
	      		    
	    // Consulta Inventario Reverso Atracado - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	     	
		String InventarioReversoAtracado_Emisor = (String) handles.toArray()[handles.size() - 1];
	 		driver.switchTo().window(InventarioReversoAtracado_Emisor);
					             	  
	 	WebElement CosultarInventarioReversoAtracado_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    CosultarInventarioReversoAtracado_Emisor.click();     Thread.sleep(secDelay);
	          	                        	     
	    WebElement CantidadDenominacion_100_ReversoAtracado_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
	    	 	String Reverso_Atracado_Emisor = CantidadDenominacion_100_ReversoAtracado_Emisor.getText();
	    	 	Reverso_Atracado_Emisor = Reverso_Atracado_Emisor.replace(".", "");
	    	 	double ObtenerPiezasDenominacion_100_ReversoAtracado_Emisor = Double.parseDouble(Reverso_Atracado_Emisor);
	    	 	System.out.println(ObtenerPiezasDenominacion_100_ReversoAtracado_Emisor);
	    	 		
	    	 	Assert.assertEquals(ObtenerPiezasDenominacion_100_ReversoAtracado_Emisor, ObtenerPiezasDenominacion_100_Atracado_Emisor, 0.000001);
	                   	     
	    String ConsultaCantidad_100_Reverso_Atracado_Emisor =  Reverso_Atracado_Emisor;
	    	writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 15, ConsultaCantidad_100_Reverso_Atracado_Emisor);          Thread.sleep(secDelay); 
			 	
			 	
	    // Volver Central - Remesa Atracada - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	 
		 	  	
		String RemesaReversadaAtracada = (String) handles.toArray()[handles.size() - 2];
			driver.switchTo().window(RemesaReversadaAtracada);	 	
			
	      
		// Reverso Estado Despachado - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
		      
		WebElement SeleccionarRemesaReversoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	    SeleccionarRemesaReversoDespachado.click();     Thread.sleep(secDelay);

	    WebElement BotonReversarDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
	    BotonReversarDespachado.click();    
	        
	    WebElement ReversoEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	    ReversoEstadoDespachado.click();
	        
	    WebElement BotonConfirmarReversarDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnInnerEl")));
	    BotonConfirmarReversarDespachado.click();     Thread.sleep(secDelay);
	          
	    WebElement MensajeReversoEstadoDespachado = driver.findElement(By.id("messagebox-1027-msg"));
	 		String Mensaje_Reverso_Despachado = MensajeReversoEstadoDespachado.getText();
	 		System.out.println("Reverso: " + Mensaje_Reverso_Despachado);	Thread.sleep(secDelay);
		
	 	WebElement Informacion_Reverso_Despachado = driver.findElement(By.id("messagebox-1027-msg"));
	 		String ObtenerMensaje_Reverso_Despachado = Informacion_Reverso_Despachado.getText().trim();
	 		System.out.println(ObtenerMensaje_Reverso_Despachado);
	 		String ExpectativaTexto_Reverso_Despachado = "Registro modificado exitosamente";
	 		
	 		Assert.assertEquals(ObtenerMensaje_Reverso_Despachado, ExpectativaTexto_Reverso_Despachado);	
	      	 
	    WebElement AceptarReversoEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    AceptarReversoEstadoDespachado.click();
	      	
	    String MensajeInformativo_Reverso_Despachado =  Mensaje_Reverso_Despachado;
	   		writeFile.writeCellValue(filepath, "Cases", 6, 27, MensajeInformativo_Reverso_Despachado);
	   		
	      
	   	// Inventario Reverso Despachado - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
		     	
		String InventarioReversoDespachado_Emisor = (String) handles.toArray()[handles.size() - 1];
	 		driver.switchTo().window(InventarioReversoDespachado_Emisor);
						             	  
	 	WebElement CosultarInventarioReversoDespachado_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    CosultarInventarioReversoDespachado_Emisor.click();     Thread.sleep(secDelay);
	             	                            	     
	    WebElement CantidadDenominacion_100_ReversoDespachado_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
	    	String Reverso_Despachado_Emisor = CantidadDenominacion_100_ReversoDespachado_Emisor.getText();
	    	Reverso_Despachado_Emisor = Reverso_Despachado_Emisor.replace(".", "");
	    	double ObtenerPiezasDenominacion_100_ReversoDespachado_Emisor = Double.parseDouble(Reverso_Despachado_Emisor);
	    	System.out.println(ObtenerPiezasDenominacion_100_ReversoDespachado_Emisor);
	    		
	    	Assert.assertEquals(ObtenerPiezasDenominacion_100_ReversoDespachado_Emisor, (ObtenerPiezasDenominacion_100_ReversoAtracado_Emisor + Monto), 0.000001);
	                          	     
	    String ConsultaCantidad_100_Reverso_Despachado_Emisor =  Reverso_Despachado_Emisor;
	    	writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 16, ConsultaCantidad_100_Reverso_Despachado_Emisor);          Thread.sleep(secDelay); 
				 	
				 	
	    // Volver Central - Remesa Aprobada - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	  	
			  	
		String ReversoAprobado = (String) handles.toArray()[handles.size() - 2];
			driver.switchTo().window(ReversoAprobado);	 	
				      	
				 	
		// Reverso Estado Aprobado - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	 
			      
		WebElement SeleccionarRemesaReversoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		SeleccionarRemesaReversoAprobado.click();     Thread.sleep(secDelay);

		WebElement BotonReversarAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
		BotonReversarAprobado.click();
		        
		WebElement ReversoEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
		ReversoEstadoAprobado.click();     Thread.sleep(secDelay);
		        
		WebElement MensajeReversoEstadoAprobado = driver.findElement(By.id("messagebox-1027-msg"));
		  	String Mensaje_Reverso_Aprobado = MensajeReversoEstadoAprobado.getText();
		  	System.out.println("Reverso: " + Mensaje_Reverso_Aprobado);		Thread.sleep(secDelay);
			
		WebElement Informacion_Reverso_Aprobado = driver.findElement(By.id("messagebox-1027-msg"));
		  	String ObtenerMensaje_Reverso_Aprobado = Informacion_Reverso_Aprobado.getText().trim();
		  	System.out.println(ObtenerMensaje_Reverso_Aprobado);
		  	String ExpectativaTexto_Reverso_Aprobado = "Registro modificado exitosamente";
		 	
		  	Assert.assertEquals(ObtenerMensaje_Reverso_Aprobado, ExpectativaTexto_Reverso_Aprobado);	
		               
		WebElement AceptarReversoEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
		AceptarReversoEstadoAprobado.click();     Thread.sleep(secDelay);
		                                   	          	
		String MensajeInformativo_Reverso_Aprobado =  Mensaje_Reverso_Aprobado;
		  writeFile.writeCellValue(filepath, "Cases", 6, 28, MensajeInformativo_Reverso_Aprobado);
				 	
				 	
		// Inventario Reverso Aprobado - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
			     	
		String InventarioReversoAprobado_Emisor = (String) handles.toArray()[handles.size() - 1];
			driver.switchTo().window(InventarioReversoAprobado_Emisor);
							             	  
		WebElement CosultarInventarioReversoAprobado_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    CosultarInventarioReversoAprobado_Emisor.click();     Thread.sleep(secDelay);
	                 	                                	     
	    WebElement CantidadDenominacion_100_ReversoAprobado_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
	    	String Reverso_Aprobado_Emisor = CantidadDenominacion_100_ReversoAprobado_Emisor.getText();
	    	Reverso_Aprobado_Emisor = Reverso_Aprobado_Emisor.replace(".", "");
	    	double ObtenerPiezasDenominacion_100_ReversoAprobado_Emisor = Double.parseDouble(Reverso_Aprobado_Emisor);
	     	System.out.println(ObtenerPiezasDenominacion_100_ReversoAprobado_Emisor);
	     	
	     	Assert.assertEquals(ObtenerPiezasDenominacion_100_ReversoAprobado_Emisor, ObtenerPiezasDenominacion_100_ReversoDespachado_Emisor, 0.000001);
	                              	     
	    String ConsultaCantidad_100_Reverso_Aprobado_Emisor =  Reverso_Aprobado_Emisor;
	     	writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 17, ConsultaCantidad_100_Reverso_Aprobado_Emisor);
					 	
					 	
	    // Volver a Central - Remesa Solicitada - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	   
					  	
	    String RemesaReversadaSolicitada = (String) handles.toArray()[handles.size() - 2];
			driver.switchTo().window(RemesaReversadaSolicitada);	 	
					 	
					 	
		// Reverso Estado Solicitado - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	     
					      
		WebElement SeleccionarRemesaReversoSolicitado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	    SeleccionarRemesaReversoSolicitado.click();     Thread.sleep(secDelay);

	    WebElement BotonReversarSolicitado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
	    BotonReversarSolicitado.click();
	        
	    WebElement MensajeReversoEstadoSolicitado = driver.findElement(By.id("messagebox-1027-msg"));
	    	String Mensaje_Reverso_Solicitado = MensajeReversoEstadoSolicitado.getText();
	    	System.out.println("Reverso: " + Mensaje_Reverso_Solicitado);	Thread.sleep(secDelay);
	    
	    WebElement Informacion_Reverso_Solicitado = driver.findElement(By.id("messagebox-1027-msg"));
	 		String ObtenerMensaje_Reverso_Solicitado = Informacion_Reverso_Solicitado.getText().trim();
	 		System.out.println(ObtenerMensaje_Reverso_Solicitado);
	 		String ExpectativaTexto_Reverso_Solicitado = "La remesa esta en un estado inicial, no se puede aplicar un reverso.";
	 	
	 		Assert.assertEquals(ObtenerMensaje_Reverso_Solicitado, ExpectativaTexto_Reverso_Solicitado);	
	                
	    WebElement AceptarReversoEstadoSolicitado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
	    AceptarReversoEstadoSolicitado.click();     Thread.sleep(secDelay);
	                   	                      	
	    String MensajeInformativo_Reverso_Solicitado =  Mensaje_Reverso_Solicitado;
	 		writeFile.writeCellValue(filepath, "Cases", 6, 29, MensajeInformativo_Reverso_Solicitado);          	
						 		
					 	
	 	// Inventario Reverso Solicitado - Emisor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	     	
		String InventarioFinalEmisor = (String) handles.toArray()[handles.size() - 1];
			driver.switchTo().window(InventarioFinalEmisor);
					             	  
		WebElement CosultarInventarioFinal_Emisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    CosultarInventarioFinal_Emisor.click();     Thread.sleep(secDelay);
	                     	                                    	     
	    WebElement CantidadDenominacion_100_Final_Emisor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1015']"));
	    	String InventarioFinal_Emisor = CantidadDenominacion_100_Final_Emisor.getText();
	    	InventarioFinal_Emisor = InventarioFinal_Emisor.replace(".", "");
	    	double ObtenerPiezasDenominacion_100_SolicitadoFinal_Emisor = Double.parseDouble(InventarioFinal_Emisor);
	    	System.out.println(ObtenerPiezasDenominacion_100_SolicitadoFinal_Emisor);
	   	     
	   	    Assert.assertEquals(ObtenerPiezasDenominacion_100_SolicitadoFinal_Emisor, ObtenerPiezasDenominacion_100_ReversoAprobado_Emisor, 0.000001);
	                                	     
	   	String ConsultaCantidad_100_IventarioFinal_Emisor =  InventarioFinal_Emisor;
	   	    writeFile.writeCellValue(filepath, "Cases 438 - 454", 1, 18, ConsultaCantidad_100_IventarioFinal_Emisor);	
	   	    

	   	// Consultas Gerenciales - Generar Asientos Contables Final - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	   
			
	    String ConsultaGemerales = (String) handles.toArray()[handles.size() - 2];
	    	driver.switchTo().window(ConsultaGemerales);                          	
	                  	
	    WebElement InicioCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	    InicioCentral.click();
	    	             	  
	    WebElement Consulta_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/consultas.jpg']")));
	    Consulta_Final.click();
	    	             	  
	    WebElement ConsultaGenerakes_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"consultasGenerales\"]")));
	    ConsultaGenerakes_Final.click();     Thread.sleep(secDelay);
	    	             	  
	    WebElement DesplegarReportes_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reporteReportConsult-trigger-picker")));
	    DesplegarReportes_Final.click();
	    WebElement SeleccionarReportes_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#boundlist-1021-listEl > li:nth-child(3)")));
	    SeleccionarReportes_Final.click();     Thread.sleep(secDelay);

	    WebElement DesplegarTipoUnidad_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoAgrupacionReportConsult-trigger-picker")));
	    DesplegarTipoUnidad_Final.click();     Thread.sleep(secDelay);
	    WebElement SeleccionarTipoUnidad_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + TipoUnidadEmisora_Consulta + "']")));
	    SeleccionarTipoUnidad_Final.click();     Thread.sleep(secDelay);	

	    WebElement DesplegarUnidad_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreAgrupacionReportConsult-trigger-picker")));
	    DesplegarUnidad_Final.click();     Thread.sleep(secDelay);
	    WebElement SeleccionarUnidad_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + UnidadEmisora_Consulta + "']")));
	    SeleccionarUnidad_Final.click();     Thread.sleep(secDelay);

	    WebElement DesplegarDivisas_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaReportConsult-trigger-picker")));
	    DesplegarDivisas_Final.click();     Thread.sleep(secDelay);
	    WebElement SeleccionarDivisa_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	    SeleccionarDivisa_Final.click();     Thread.sleep(secDelay);

	    WebElement IconoImprimir_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
	    IconoImprimir_Final.click();     Thread.sleep(secDelay);
	    	             	  	
	    WebElement AceptarImprimir_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    AceptarImprimir_Final.click();      	    
	   	    
	   	    
	   	    
	   	    
	}
}