package Integrales_Diferencias;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
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
import org.openqa.selenium.NoSuchElementException;
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

public class Cases_482 {
	
	int secDelay = 3000;

	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	private By CantidadDenominacion_100 = By.cssSelector("td[data-columnid='gridcolumn-1014']");
	private By DesplegarUnidadReceptora = By.id("unidadCrear-trigger-picker");

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
		
		
		//  ----------  Saldar Diferencia Faltante - Contra Castigo - CDA / AG ----------	
		 
		 
		// Excel - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		 																	
		String filepath =  "" + Constante_PreCalidad.RUTA_EXCEL + "\\MatrizIntegrales.xlsx";
		 						
		String TipoUnidadReceptora = readFile.getCellValue(filepath, "Cases", 38, 1);
		String UnidadReceptora = readFile.getCellValue(filepath, "Cases", 38, 2);
		String EmpresaTransportista = readFile.getCellValue(filepath, "Cases", 38, 5);
		 				
		String TipoUnidadCierre = readFile.getCellValue(filepath, "General", 5, 1);
		String UnidadCierre = readFile.getCellValue(filepath, "General", 5, 2);
		 				
		 									
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		 
	 	String Modalidad ="//li[text()='Contra Castigo']";
	 	 
	 	 
	 	// Cambio de Pestaña - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 	
	 	JavascriptExecutor js = (JavascriptExecutor) driver;	
	 	 							 																							 	
	 	String Agencia = Constante_PreCalidad.URL_AGENCIA;
	 	String Central = Constante_PreCalidad.URL_CENTRAL_ENVIO;
	 	 							 																							

	 	// Obtener Fecha Actual - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 	 							 																							
	 	int DiaActual = LocalDate.now().getDayOfMonth();			
	 	 							 																						        			       
	 	String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
	 	 							 																							        
	 	System.out.println(DiaActualString);
	 	 							 																							
	 	 							 																								
	 	// Captura - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 	 							 																			        
	 	String directorioCapturas =  "" + Constante_PreCalidad.RUTA_CAPTURES + "\\Cases 482";
	 	 							 																				 	
	 	String nombreArchivo1 = "Cierre Inicial.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	 						 																				 	
	 	String nombreArchivo2 = "Cierre Final.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
	 								 																				 	
	 	 							 																				 	
	 	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	 	WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
        
        WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        login.sendKeys(Constante_PreCalidad.USUARIO);
        WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
        WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
        enter.click();
        
        
        // Cierre de Unidades - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        
        WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
 		Logistica.click();
 		WebElement AdministracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
 		AdministracionEfectivo.click();
 		WebElement CierreUnidades = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Image1")));
 		CierreUnidades.click();
         
 		WebElement DesplegarTipoUnidadCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
 		DesplegarTipoUnidadCierre.click();
 		WebElement SeleccionarTipoUnidadCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + TipoUnidadCierre + "']")));
 		SeleccionarTipoUnidadCierre.click();
 		WebElement DesplegarUnidadCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen60")));
 		DesplegarUnidadCierre.click();
 		WebElement SeleccionarUnidadCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + UnidadCierre + "']")));
 		SeleccionarUnidadCierre.click();
 		WebElement DesplegarDivisaCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen73")));
 		DesplegarDivisaCierre.click();
 		WebElement SeleccionarDivisaCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dólar']")));
 		SeleccionarDivisaCierre.click();
 		
 		WebElement ConsultarCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen86")));
 		ConsultarCierre.click();
         
 		WebElement SeleccionarDía = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
 		SeleccionarDía.click();
 											         
 		WebElement CerrarDía = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCerrarDia")));
 		CerrarDía.click();
 									
 		WebElement MensajeConfirmacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1069")));
 		MensajeConfirmacion.click();	 Thread.sleep(secDelay);
        	        
        File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo, new File(captura1));        Thread.sleep(secDelay);
        	   	        
     
        // Cambio Agencia - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	        
    	js.executeScript("window.open(arguments[0]);", Agencia);	  
    			    
    	Set<String> handles = driver.getWindowHandles();
    			    
    	String PestañaAgencia = (String) handles.toArray()[handles.size() - 1];
    		driver.switchTo().window(PestañaAgencia);
    			    
    	WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
    	loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
    	WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    	passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA); 		    Thread.sleep(secDelay);	 
    	WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
    	enterAgencia.click();
    		        
    	WebElement ControlRemesas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remesas")));
    	ControlRemesas.click();
    	WebElement Envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Envios")));
    	Envios.click();  
    	
		
    	// Crear Remesa - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
    	WebElement CrearEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
    	CrearEnvio.click();
    	   
    	WebElement cDesplegarTipoUnidadReceptora1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadCrear-trigger-picker")));
    	cDesplegarTipoUnidadReceptora1.click();
    	WebElement cSeleccionarTipoUnidadReceptora1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + TipoUnidadReceptora + "']")));
    	cSeleccionarTipoUnidadReceptora1.click(); 	  Thread.sleep(secDelay);	
    	WebElement cDesplegarUnidadReceptoraEnvio = driver.findElement(DesplegarUnidadReceptora);
    	cDesplegarUnidadReceptoraEnvio.click(); 
    	WebElement cDesplegarUnidadReceptora1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadCrear")));
    	cDesplegarUnidadReceptora1.click();  	Thread.sleep(secDelay);
    	WebElement cSeleccionarUnidadReceptora1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + UnidadReceptora + "']")));
    	cSeleccionarUnidadReceptora1.click();	  Thread.sleep(secDelay);
    	WebElement cDesplegarTipoEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvioCrear-trigger-picker")));
    	cDesplegarTipoEnvio.click();  
    	WebElement cSeleccionarTipoEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal - Urbano']")));
    	cSeleccionarTipoEnvio.click();
    			    
    	Random rand = new Random();
    	int numeroAleatorio_Observacion = rand.nextInt(1000000) + 1000000000;
    	String Observacion = Integer.toString(numeroAleatorio_Observacion);
    	WebElement NumeroObservacionAleatorio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("observacionCrear-inputEl"))); 
    	NumeroObservacionAleatorio.sendKeys(String.valueOf(Observacion)); 
    	System.out.println("La observacion es: " + Observacion);	Thread.sleep(secDelay);
    			    
    	WebElement cBotonSiguiente = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnWrap")));
    	cBotonSiguiente.click();     Thread.sleep(secDelay);
    			    
    	WebElement cDesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
    	cDesplegarDivisa.click();	 Thread.sleep(secDelay);	  
    	WebElement cElementoDolar = driver.findElement(By.xpath("//li[text()='Dólar']"));
    	cElementoDolar.click();
    			    
    	WebElement DesplegarDestino = driver.findElement(By.id("destinoCrear-trigger-picker"));
    		if (DesplegarDestino.isEnabled()) {
    		DesplegarDestino.click();
    		} else {
    		}
    			    
    	Thread.sleep(secDelay);

    		try {
    		WebElement SeleccionarDestino = driver.findElement(By.xpath("//li[text()='Boveda']"));
    		SeleccionarDestino.click();
    		} catch (NoSuchElementException e){
    		}
    			     
    	Thread.sleep(secDelay);
    			    	
    	WebElement BotonIncluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear-btnWrap")));
    	BotonIncluir.click();	  Thread.sleep(secDelay);   
    		        
    	WebElement cElementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1115']")); 
    	Actions doble = new Actions(driver);
    	doble.doubleClick(cElementoCantidad).perform();	
    				
    	List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));
    	boolean elementoEncontrado = false;
    	for (WebElement elemento : elementos) {
    		if (elemento.isEnabled()) {
    		  Actions actions = new Actions(driver);
    		  actions.click(cElementoCantidad).sendKeys("2").sendKeys(Keys.ENTER).perform();
    		  elementoEncontrado = true;
    		  break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
    		  }
    		}
    		if (!elementoEncontrado) {
    		System.out.println("Ninguno de los elementos está habilitado.");
    		// Puedes manejar esta situación según tus necesidades, por ejemplo, lanzar una excepción
    		            
    		}
    		        
    	Thread.sleep(secDelay);
    		        
    	WebElement cAceptarCreacionRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1133-btnWrap")));
    	cAceptarCreacionRemesa.click(); 	   Thread.sleep(secDelay);
    		   	        
    	WebElement cMensajeConfirmacionRemesa = driver.findElement(By.id("container-1003-innerCt"));
    		String Texto = cMensajeConfirmacionRemesa.getText();
    		System.out.println("La creacion Fue: " + Texto); 	        Thread.sleep(secDelay);
    		        
    	WebElement MensajeCreacionRemesa = driver.findElement(By.id("messagebox-1001-msg"));
    		 String ObtenerMensaje = MensajeCreacionRemesa.getText().trim();
    		 System.out.println(ObtenerMensaje);
    		 String ExpectativaTexto = "Registro creado exitosamente";

    		 Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
    		   	   
    	WebElement cAceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
    	cAceptarMensajeInformativo.click();
    		   	   
    	driver.navigate().refresh();
    	        
    	              
    	// Mensaje Creacion Remesa - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    	        
    	String mensajeInformativo = Texto;
    		writeFile.writeCellValue(filepath, "Cases", 38, 7, mensajeInformativo);	
    	    	 	
    	    	
    	//Mensaje Cataporte Remesa	
    	 	 	
    	String NroObservacion =  Observacion;
    		writeFile.writeCellValue(filepath, "Cases", 38, 8, NroObservacion);
    	        	
    	        	
    	// Cambio Pestaña - Cemtral - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -		
    	
    	js.executeScript("window.open(arguments[0]);", Central);	  
	    
	    Set<String> handles2 = driver.getWindowHandles();
    	
    	String Central1 = (String) handles2.toArray()[handles2.size() - 1];
		    driver.switchTo().window(Central1);
        
		Thread.sleep(secDelay);    	 	
      
		WebElement ConsultaCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
        ConsultaCentral.click();
        
     // --------------- Desplegar campo observacion ---------------
        
        
	    // Mover Cursor a la Columna Codigo Remesa - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		    
	    WebElement CampoCodigoRemesa = driver.findElement(By.id("gridcolumn-1065-titleEl"));
	        
	    Actions actions = new Actions(driver);
	        
	    actions.moveToElement(CampoCodigoRemesa).perform();
	       
	    CampoCodigoRemesa.click();	        Thread.sleep(secDelay);  
	        
	    WebElement DesplegarCamposColumnaCodigoRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1065-triggerEl")));
	    DesplegarCamposColumnaCodigoRemesa.click();
	        
		     	    
	    // Mover Cursor en la Lista Desplegable - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		    
	    WebElement ListaColumnas = driver.findElement(By.id("menuitem-1158"));
	        
	    Actions actions2 = new Actions(driver);
	        
	    actions2.moveToElement(ListaColumnas).perform();	        Thread.sleep(secDelay); 
	        	                        
	    WebElement CheckboxObservaciones = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menucheckitem-1134-checkEl")));
	    CheckboxObservaciones.click();
	        
	    WebElement ClickTituloRemesas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title-1116-textEl")));
	    ClickTituloRemesas.click();		Thread.sleep(secDelay);  
	        	        
	        
	    // Seleccionar Remesa por Observacion - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	        
	        
	    WebElement BuscarObservacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='"+ Observacion +"']")));
	    BuscarObservacion.click(); 	   Thread.sleep(secDelay);  
	    
        
	    // Avance Remesa Estado Aprobado  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        
        WebElement botonAvanzarEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoAprobado.click();     Thread.sleep(secDelay);
        WebElement AvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        AvanceEstadoAprobado.click();     Thread.sleep(secDelay);

        WebElement mensajeConfirmacionAprobado = driver.findElement(By.id("messagebox-1027-msg"));
        	String MensajeAprobado = mensajeConfirmacionAprobado.getText();
        	System.out.println("Avance: " + MensajeAprobado);
        	
	    WebElement InformacionAvanceAprobado = driver.findElement(By.id("messagebox-1027-msg"));
        	String ObtenerMensajeAprobado = InformacionAvanceAprobado.getText().trim();
        	System.out.println(ObtenerMensajeAprobado);
        	String ExpectativaTextoAprobado = "Registro modificado exitosamente";

        	Assert.assertEquals(ObtenerMensajeAprobado, ExpectativaTextoAprobado);	
        		               
        WebElement AceptarAvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        AceptarAvanceEstadoAprobado.click();    
          
        String MensajeInformativoAprobado =  MensajeAprobado;
        	writeFile.writeCellValue(filepath, "Cases", 38, 9, MensajeInformativoAprobado);        	Thread.sleep(secDelay); 
        	
        	
        // Modificar Renesa Aprobada - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        	
    	WebElement SeleccionarCampoObservacionRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='x-grid-cell x-grid-td x-grid-cell-gridcolumn-1075 x-unselectable']//div[contains(@class,'x-grid-cell-inner')][normalize-space()='"+ Observacion +"']")));
    	SeleccionarCampoObservacionRemesa.click();	Thread.sleep(secDelay);  
    	 	 	     	   
    	WebElement CerrarDetalleRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tool-1113")));
    	CerrarDetalleRemesa.click();   	 Thread.sleep(secDelay); 	
    	 	            
    	actions.sendKeys(SeleccionarCampoObservacionRemesa, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT).click().build().perform();	        Thread.sleep(secDelay);
    	         	      	                
    	WebElement Modificar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='images/crup/Modificar.png']")));
    	Modificar.click();     Thread.sleep(secDelay);
    	                
    	Random rand2 = new Random();
    	int numeroAleatorio_Cataporte = rand2.nextInt(1000000) + 1000000000;
    	String NumeroTexto = Integer.toString(numeroAleatorio_Cataporte);
    	WebElement NumeroServicioAleatorio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioModificar-inputEl"))); 
    	NumeroServicioAleatorio.sendKeys(String.valueOf(NumeroTexto)); 
    	System.out.println("El Cataporte es: " + NumeroTexto);		    Thread.sleep(secDelay);
    		    		    
    	WebElement mDesplegarTipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvaseModificar-trigger-picker")));
    	mDesplegarTipoEnvase.click();
    	WebElement mSeleccionarTipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOLSA']")));
    	mSeleccionarTipoEnvase.click();
    	WebElement mDesplegarTipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaModificar-trigger-picker")));
    	mDesplegarTipoPieza.click();
    	WebElement mSeleccionarTipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billetes']")));
    	mSeleccionarTipoPieza.click();
    	WebElement mColocarCantidadEnvases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseModificar-inputEl")));
    	mColocarCantidadEnvases.sendKeys("1");
    	WebElement mBotonIncluirEnvases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesModificar-btnIconEl")));
    	mBotonIncluirEnvases.click();
    	WebElement mColocarNumeroPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroModificar-inputEl")));
    	mColocarNumeroPlomos.sendKeys("1");
    	WebElement mBotonIncluirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosModificar-btnInnerEl")));
    	mBotonIncluirPlomos.click(); 	 Thread.sleep(secDelay);  
    	        
    	WebElement mAceptarModificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1169-btnWrap")));
    	mAceptarModificacion.click();     Thread.sleep(secDelay);  
    	        
    	WebElement InformacionModificacion = driver.findElement(By.id("messagebox-1027-msg"));
    		String ObtenerMensajeModificacion = InformacionModificacion.getText().trim();
    		System.out.println(ObtenerMensajeModificacion);
    		String ExpectativaTextoModificacion = "Registro modificado exitosamente";
    			    
    		Assert.assertEquals(ObtenerMensajeModificacion, ExpectativaTextoModificacion);
    	        
    	WebElement aceptarMensajeModifi = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
    	aceptarMensajeModifi.click(); 
    	    
        
    	// Mensaje Cataporte Remesa	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	        
    	String Cataporte =  NumeroTexto;
    	    writeFile.writeCellValue(filepath, "Cases", 38, 8, Cataporte);
    	        	
    	String NroServicio = readFile.getCellValue(filepath, "Cases", 38, 8);
    	    
        
    	// Avanzar Remesa a Despachado - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            
    	WebElement FiltrosCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
    	FiltrosCentral.click();
    	WebElement CampoNroServicioCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
    	CampoNroServicioCentral.sendKeys(NroServicio); 	        Thread.sleep(secDelay);
    	WebElement ConsultarFiltrosCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1195-btnWrap")));
    	ConsultarFiltrosCentral.click();		        Thread.sleep(secDelay);
    	    	     	 
    	WebElement SeleccionarRemesaAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1117']")));
    	SeleccionarRemesaAprobado.click();     Thread.sleep(secDelay);
    	WebElement BotonAvanzarEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
    	BotonAvanzarEstadoDespachado.click();   	 Thread.sleep(secDelay);
    	WebElement AvanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
    	AvanceEstadoDespachado.click();     Thread.sleep(secDelay);
    	WebElement ConfirmarAvanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnWrap")));
    	ConfirmarAvanceEstadoDespachado.click();     Thread.sleep(secDelay);
    	          
    	WebElement MensajeConfirmacionDespachado = driver.findElement(By.id("messagebox-1027-msg"));
    	String MensajeDespachado = MensajeConfirmacionDespachado.getText();
    	System.out.println("Avance: " + MensajeDespachado);	Thread.sleep(secDelay);
    	        	
    	WebElement InformacionAvanceDespachado = driver.findElement(By.id("messagebox-1027-msg"));
    		String ObtenerMensajeDespachado = InformacionAvanceDespachado.getText().trim();
    	    System.out.println(ObtenerMensajeDespachado);
    	    String ExpectativaTextoDespachado = "Registro modificado exitosamente";

    	    Assert.assertEquals(ObtenerMensajeDespachado, ExpectativaTextoDespachado);	
    	          
    	WebElement AceptarAvanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
    	AceptarAvanceEstadoDespachado.click();     Thread.sleep(secDelay);
    	          
    	String MensajeInformativoDespachado =  MensajeDespachado;
    		writeFile.writeCellValue(filepath, "Cases", 38, 10, MensajeInformativoDespachado);
    	        	
        
    	// Cambio Agencia - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    	        	
    	String AgenciaDespacho = (String) handles2.toArray()[handles2.size() - 2];
    	   	driver.switchTo().window(AgenciaDespacho);	
    	    			
    	    			
    	// Buscar Remesa Agencia - Avanzar Remesa a Recibido - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    	    	        
    	WebElement FiltrosAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
    	FiltrosAgencia.click();
    	WebElement CheckboxReceptor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadRConsulta-inputEl")));
    	CheckboxReceptor.click();
    	WebElement CampoNroServicioAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
    	CampoNroServicioAgencia.sendKeys(NroServicio); 	        Thread.sleep(secDelay);
    	    				
    	WebElement ConsultarFiltrosAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1086-btnWrap")));
    	ConsultarFiltrosAgencia.click(); 	        Thread.sleep(secDelay);	
    	    		        
    	WebElement SeleccionarRemesaDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
    	SeleccionarRemesaDespachado.click();     Thread.sleep(secDelay);
    	WebElement BotonAvanzarEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
    	BotonAvanzarEstadoRecibido.click();     Thread.sleep(secDelay);
    	WebElement AvanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
    	AvanceEstadoRecibido.click();     Thread.sleep(secDelay);
    	    	            
    	WebElement MensajeConfirmacionRecibido = driver.findElement(By.id("messagebox-1001-msg"));
    		String MensajeRecibido = MensajeConfirmacionRecibido.getText();
    		System.out.println("Avance: " + MensajeRecibido);	Thread.sleep(secDelay);
    	    	            	
    	WebElement InformacionAvanceRecibido = driver.findElement(By.id("messagebox-1001-msg"));
    		String ObtenerMensajeRecibido = InformacionAvanceRecibido.getText().trim();
    	    System.out.println(ObtenerMensajeRecibido);
    	    String ExpectativaTextoRecibido = "Registro modificado exitosamente";
    	    
    	    Assert.assertEquals(ObtenerMensajeRecibido, ExpectativaTextoRecibido);	
    	    	          	    	 
    	WebElement AceptarAvanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
    	AceptarAvanceEstadoRecibido.click();
    	    		        
    	String MensajeInformativoRecibido =  MensajeRecibido;
    		writeFile.writeCellValue(filepath, "Cases", 38, 11, MensajeInformativoRecibido);
    	    	            	
        
    	// Avance Remesa a Confirmado Ajuste Faltante - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    	    	    	        
    	WebElement SeleccionarRemesaRecibida = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
    	SeleccionarRemesaRecibida.click();	   Thread.sleep(secDelay);
    	WebElement BotonAvanceAlternoEstadoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnWrap")));
    	BotonAvanceAlternoEstadoFaltante.click();  	  Thread.sleep(secDelay);
    	WebElement DesplegarEstadosAlternos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
    	DesplegarEstadosAlternos.click();  	  Thread.sleep(secDelay);
    	WebElement SelectFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Confirmado Ajuste Faltante']")));
    	SelectFaltante.click();	        	        	        	        
    	WebElement avanceEstado_Faltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnWrap")));
    	avanceEstado_Faltante.click();	    Thread.sleep(secDelay);
    	    	                  
    	WebElement DesplegarDenominacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantes-trigger-picker")));
    	DesplegarDenominacionFaltante.click();     Thread.sleep(secDelay);
    	WebElement SeleccionarDenominacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));          
    	SeleccionarDenominacionFaltante.click();     Thread.sleep(secDelay);
    	WebElement DesplegarClasificaciónFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoClasificacionFaltantes-trigger-picker")));
    	DesplegarClasificaciónFaltante.click();
    	WebElement SeleccionarClasificacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
    	SeleccionarClasificacionFaltante.click();
    	WebElement EscribirCantidadFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantes-inputEl")));
    	EscribirCantidadFaltante.sendKeys("1");            Thread.sleep(secDelay);

    	WebElement IncluirFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1063-btnWrap")));
    	IncluirFaltante.click();     Thread.sleep(secDelay);
    	    	                     
    	WebElement AceptarAjusteFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar-btnWrap")));
    	AceptarAjusteFaltante.click();     Thread.sleep(secDelay);
    	    	                      
    	WebElement MensajeConfirmacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("messagebox-1001-msg")));
    		String MensajeFaltante = MensajeConfirmacionFaltante.getText();
    		System.out.println("Avance: " + MensajeFaltante);	Thread.sleep(secDelay);
    	    	                      
    	WebElement InformacionAvanceFaltante = driver.findElement(By.id("messagebox-1001-msg"));
    		String ObtenerMensajeFaltante = InformacionAvanceFaltante.getText().trim();
    	    System.out.println(ObtenerMensajeFaltante);
    	    String ExpectativaTextoFaltante = "Registro creado exitosamente";
    	    	                  	
    	    Assert.assertEquals(ObtenerMensajeFaltante, ExpectativaTextoFaltante);	
    	    	                                                                           	        	        	        
    	WebElement AceptarAvanceEstadoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
    	AceptarAvanceEstadoFaltante.click();	 Thread.sleep(secDelay);	        
    	    	          	                
    	String MensajeInformativoEstadoFaltante =  MensajeFaltante;
    		writeFile.writeCellValue(filepath, "Cases", 38, 14, MensajeInformativoEstadoFaltante);	Thread.sleep(secDelay);
    	    	                  		
    	    	                  		    
    	// Pantalla Diferencia - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    	    	                		
    	WebElement InicioAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
    	InicioAgencia.click();
    	    	                                
    	WebElement Diferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
    	Diferencia.click();     Thread.sleep(secDelay);
    	    	                                
    	WebElement DesplegarTipoConsultaDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
    	DesplegarTipoConsultaDiferencia.click();	 Thread.sleep(secDelay);
    	WebElement SeleccionarTipoConsultaDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
    	SeleccionarTipoConsultaDiferencia.click();
    	WebElement DesplegarTipoDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
    	DesplegarTipoDiferencia.click();	 Thread.sleep(secDelay);
    	WebElement SeleccionarTipoDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Faltante']")));
    	SeleccionarTipoDiferencia.click();
    	WebElement DesplegarOrigenDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
    	DesplegarOrigenDiferencia.click();	   Thread.sleep(secDelay);
    	WebElement SeleccionarOrigenDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='REMESA']")));
    	SeleccionarOrigenDiferencia.click();
    	    	                    	        
    	WebElement ConsultarDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041-btnWrap")));
    	ConsultarDiferencia.click();
    	    	                    	        
    	WebElement SeleccionarDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1026']")));
    	SeleccionarDiferencia.click();
    	    	                    	        
    	WebElement BotonSaldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar-btnWrap")));
    	BotonSaldar.click();	 Thread.sleep(secDelay);
    	    	                    	        
    	WebElement DesplegarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
    	DesplegarModalidad.click();
    	WebElement SeleccionarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Modalidad)));
    	SeleccionarModalidad.click();
    	WebElement MontoSaldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
    	MontoSaldar.sendKeys("100");
    	WebElement Descripción = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
    	Descripción.sendKeys("prueba");
    	    	                    	        
        	        
        // Contra Castigo- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    	    	                    	        
    	WebElement NroCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuentaCuen-inputEl")));
    	NroCuenta.sendKeys("02147850");
    	WebElement nombreCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuentaCuen-inputEl")));
    	nombreCuenta.sendKeys("Prueba Automatizada");
    	    	                    	        
    	WebElement PresionarIncluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacionCuen-btnWrap")));
    	PresionarIncluir.click();	  Thread.sleep(secDelay);

    	WebElement PresionarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarSald-btnWrap")));
    	PresionarAceptar.click();     Thread.sleep(secDelay);
    	    	                    	        
    	WebElement InformacionDiferenciaSaldada = driver.findElement(By.id("messagebox-1001-msg"));
    		String ObtenerMensajeDiferencia = InformacionDiferenciaSaldada.getText().trim();
    	    System.out.println(ObtenerMensajeDiferencia);
    	    String ExpectativaTextoDiferencia = "Registro creado exitosamente";
    	    	                    			
    	    Assert.assertEquals(ObtenerMensajeDiferencia, ExpectativaTextoDiferencia);
    	    	                    	        
    	WebElement ConfirmarOperacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
    	ConfirmarOperacion.click();
    	    	                    	        
        
    	  // Validar Cierre de Unidades - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -   
    	    	                    	        
    	  WebElement VolverInicioAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
    	  VolverInicioAgencia.click();
    	    	                    	        
    	  WebElement CuadreAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
    	  CuadreAgencia.click();
    	  WebElement CierreAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cierre")));
    	  CierreAgencia.click();     Thread.sleep(secDelay);
    	    	                    	                   
    	  WebElement DesplegarDivisaCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
    	  DesplegarDivisaCierre_Final.click();
    	  WebElement SeleccionarDivisaCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dólar']")));
    	  SeleccionarDivisaCierre_Final.click();
    	    	                    	        
    	  WebElement ConsultarCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
    	  ConsultarCierre_Final.click();
    	    	                    	          	                    	        
    	  WebElement SeleccionarDía_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
    	  SeleccionarDía_Final.click();
    	    	                    	        
    	  WebElement CerrarDía_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCierre")));
    	  CerrarDía_Final.click();
    	    	                    	        
    	  WebElement MensajeConfirmacion_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1067")));
    	  MensajeConfirmacion_Final.click();	   Thread.sleep(secDelay);
        	        
        File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo2, new File(captura2));
        
	}
}