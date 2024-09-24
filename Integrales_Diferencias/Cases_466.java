package Integrales_Diferencias;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
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
import DataDrivenTesting.WriteExcelFile;

public class Cases_466 {

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
		
		
		//  ----------  Saldar Diferencia Sobrante - Entrega de Efectivo - AG / CDA ----------	
		
		
		// Excel - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
										
		String filepath = "" + Constante_PreCalidad.RUTA_EXCEL + "\\MatrizIntegrales.xlsx";
								
		String TipoUnidadReceptora = readFile.getCellValue(filepath, "Cases", 22, 3);
		String UnidadReceptora = readFile.getCellValue(filepath, "Cases", 22, 4);
		String EmpresaTransportista = readFile.getCellValue(filepath, "Cases", 22, 5);
								
		String TipoUnidadCierre = readFile.getCellValue(filepath, "General", 9, 1);
		String UnidadCierre = readFile.getCellValue(filepath, "General", 9, 2);
				
		String TipoUnidadDiferencia = readFile.getCellValue(filepath, "General", 9, 1);
		String UnidadDiferencia = readFile.getCellValue(filepath, "General", 9, 2);
			
			
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		String Modalidad ="//li[text()='Entrega de Efectivo']";
		
		 	
		// Cambio de Pestaña - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 	
		JavascriptExecutor js = (JavascriptExecutor) driver;	
												 	
		String Agencia = Constante_PreCalidad.URL_AGENCIA;
		String Central = Constante_PreCalidad.URL_CENTRAL;
												

		// Obtener Fecha Actual - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
												
		int DiaActual = LocalDate.now().getDayOfMonth();			
											        			       
		String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
												        
		System.out.println(DiaActualString);
												
													
		// Captura - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
								        
		String directorioCapturas =  "" + Constante_PreCalidad.RUTA_CAPTURES + "\\Cases 466";
									 	
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
	    	FileUtils.copyFile(archivo, new File(captura1));	Thread.sleep(secDelay);
	        
	    	
	    // Cambio Agencia - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	        
		js.executeScript("window.open(arguments[0]);", Agencia);	  
			    
		Set<String> handles = driver.getWindowHandles();
						    
		String PestañaAgencia = (String) handles.toArray()[handles.size() - 1];
		    driver.switchTo().window(PestañaAgencia);
						    
		WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
		WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA);			Thread.sleep(secDelay);
		WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		enterAgencia.click();
						    
		WebElement ControlRemesas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remesas")));
		ControlRemesas.click();
		WebElement Envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Envios")));
		Envios.click();  
										
		WebElement CrearEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
		CrearEnvio.click();
							
		WebElement cTipoEnviar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emisorCrear-inputEl")));
		cTipoEnviar.click();	    
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
		cSeleccionarTipoEnvio.click(); 	   Thread.sleep(secDelay);
						    
		WebElement cBotonSiguiente = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnWrap")));
		cBotonSiguiente.click();     Thread.sleep(secDelay);
							
		WebElement cDesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
		cDesplegarDivisa.click();	 Thread.sleep(secDelay);	
		WebElement cElementoDolar = driver.findElement(By.xpath("//li[text()='Dólar']"));
		cElementoDolar.click();
					        
		Random rand = new Random();
		int numeroAleatorio = rand.nextInt(1000000) + 1000000000;
		String numeroTexto = Integer.toString(numeroAleatorio);
		WebElement numeroServicioAleatorio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl"))); 
		numeroServicioAleatorio.sendKeys(String.valueOf(numeroTexto)); 
		System.out.println("El Cataporte es: " + numeroTexto);		    Thread.sleep(secDelay);
					        		   		     	
		WebElement cBotonIncluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear-btnWrap")));
		cBotonIncluir.click(); 	   Thread.sleep(secDelay);
		WebElement cDesplegarTipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvaseCrear-trigger-picker")));
		cDesplegarTipoEnvase.click();
		WebElement cSeleccionarTipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bolsa']")));
		cSeleccionarTipoEnvase.click();
		WebElement cDesplegarTipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
		cDesplegarTipoPieza.click();
		WebElement cSeleccionarTipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete']")));
		cSeleccionarTipoPieza.click();
		WebElement cColocarCantidadEnvases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
		cColocarCantidadEnvases.sendKeys("1");
		WebElement cBotonIncluirEnvases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear-btnWrap")));
		cBotonIncluirEnvases.click();
		WebElement cColocarNumeroPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
		cColocarNumeroPlomos.sendKeys("1");
		WebElement cBotonIncluirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnIconEl")));
		cBotonIncluirPlomos.click(); 	 Thread.sleep(secDelay);  
	        
	    WebElement cElementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1115']")); //En 2.6 es 1163 y en 2.5 es 1161 // 1161
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
	    		   	        
	    WebElement mensajeConfirmacionRemesa = driver.findElement(By.id("container-1003-innerCt"));
	    	String texto = mensajeConfirmacionRemesa.getText();
	    	System.out.println("La creacion Fue: " + texto);
	    		    
	    WebElement MensajeCreacionRemesa = driver.findElement(By.id("messagebox-1001-msg"));
	    	String ObtenerMensaje = MensajeCreacionRemesa.getText().trim();
	    	System.out.println(ObtenerMensaje);
	    	String ExpectativaTexto = "Registro creado exitosamente";
	    		         	
	    	Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
	    		        
	    WebElement cAceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    cAceptarMensajeInformativo.click();
	    		    
	    driver.navigate().refresh();
	    		
	    		              
	    // Mensaje Creacion Remesa - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	            
	    String mensajeInformativo = texto;
	    	writeFile.writeCellValue(filepath, "Cases", 22, 7, mensajeInformativo);	
	    	    	 	
	    	        
	    //Mensaje Cataporte Remesa - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	    	    	 	
	    String Cataporte =  numeroTexto;
	    	writeFile.writeCellValue(filepath, "Cases", 22, 8, Cataporte);
	    	       	
	    	       	
	    // Cambio Pestaña - Cemtral - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	       
	       		       	           	       		        
		js.executeScript("window.open(arguments[0]);", Central);	  
			    
		Set<String> handles2 = driver.getWindowHandles();
						    
		String ModuloCentral = (String) handles2.toArray()[handles2.size() - 1];
		    driver.switchTo().window(ModuloCentral);
					        
		WebElement loginCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		loginCentral.sendKeys(Constante_PreCalidad.USUARIO);
		WebElement passwordCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		passwordCentral.sendKeys(Constante_PreCalidad.CONTRASEÑA); 	     Thread.sleep(secDelay);
		WebElement enterCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		enterCentral.click();
					        
		WebElement logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
		logistica.click();
		WebElement administracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
		administracionEfectivo.click();
		WebElement enviosCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
		enviosCentral.click();
	        
		// Avance Aprobado Remesa Central - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        
		String nroServicio = readFile.getCellValue(filepath, "Cases", 22, 8);
							    
		WebElement filtrosCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
		filtrosCentral.click();
		WebElement campoNroServicioCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		campoNroServicioCentral.sendKeys(nroServicio);         Thread.sleep(secDelay);
		WebElement consultarFiltrosCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
		consultarFiltrosCentral.click();     Thread.sleep(secDelay);
							        
		WebElement seleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		seleccionarRemesa.click();     Thread.sleep(secDelay);
		WebElement botonAvanzarEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		botonAvanzarEstadoAprobado.click();     Thread.sleep(secDelay);
		WebElement AvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		AvanceEstadoAprobado.click();     Thread.sleep(secDelay);

		WebElement MensajeConfirmacionAprobado = driver.findElement(By.id("messagebox-1027-msg"));
				String MensajeAprobado = MensajeConfirmacionAprobado.getText();
				System.out.println("Avance: " + MensajeAprobado);
							               
		WebElement InformacionAvanceAprobado = driver.findElement(By.id("messagebox-1027-msg"));
				String ObtenerMensajeAprobado = InformacionAvanceAprobado.getText().trim();
				System.out.println(ObtenerMensajeAprobado);
				String ExpectativaTextoAprobado = "Registro modificado exitosamente";
						         
				Assert.assertEquals(ObtenerMensajeAprobado, ExpectativaTextoAprobado);	
						                              
		WebElement AceptarAvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		AceptarAvanceEstadoAprobado.click();    
							          
		String MensajeInformativoAprobado =  MensajeAprobado;
				writeFile.writeCellValue(filepath, "Cases", 22, 9, MensajeInformativoAprobado);
	        
		// Cambio Agencia - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	        	
		String AgenciaDespacho = (String) handles2.toArray()[handles2.size() - 2];
			driver.switchTo().window(AgenciaDespacho);	
							     
						     		
		// Buscar Remesa Agencia - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
				     	   		               
		WebElement Filtros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
		Filtros.click();
		WebElement CampoNroServicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		CampoNroServicio.sendKeys(nroServicio); 	        Thread.sleep(secDelay);
		WebElement ConsultarFiltros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1086-btnWrap")));
		ConsultarFiltros.click(); 	  Thread.sleep(secDelay);	
						        
		WebElement SeleccionarRemesaAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
		SeleccionarRemesaAprobado.click();     Thread.sleep(secDelay);
		WebElement BotonAvanzarEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		BotonAvanzarEstadoDespachado.click();   	 Thread.sleep(secDelay);
		WebElement AvanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		AvanceEstadoDespachado.click();     Thread.sleep(secDelay);
		WebElement ConfirmarAvanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
		ConfirmarAvanceEstadoDespachado.click();     Thread.sleep(secDelay);
					          
		WebElement MensajeConfirmacionDespachado = driver.findElement(By.id("messagebox-1001-msg"));
			String MensajeDespachado = MensajeConfirmacionDespachado.getText();
			System.out.println("Avance: " + MensajeDespachado);	Thread.sleep(secDelay);
					          
		WebElement InformacionAvanceDespachado = driver.findElement(By.id("messagebox-1001-msg"));
			String ObtenerMensajeDespachado = InformacionAvanceDespachado.getText().trim();
			System.out.println(ObtenerMensajeDespachado);
			String ExpectativaTextoDespachado = "Registro modificado exitosamente";
				        
			Assert.assertEquals(ObtenerMensajeDespachado, ExpectativaTextoDespachado);	
					          
		WebElement AceptarAvanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
		AceptarAvanceEstadoDespachado.click();     Thread.sleep(secDelay);
					          
		String MensajeInformativoDespachado =  MensajeDespachado;
			writeFile.writeCellValue(filepath, "Cases", 22, 10, MensajeInformativoDespachado);
			
	        
		// Cambio Central - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	        
		String CentralRecibido = (String) handles2.toArray()[handles2.size() - 1];
			driver.switchTo().window(CentralRecibido);	
					     			
					     		
		// Avance Recibido - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
				     		
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
		Consultar.click();	   Thread.sleep(secDelay);

		WebElement SeleccionarRemesaDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		SeleccionarRemesaDespachado.click();     Thread.sleep(secDelay);
		WebElement BotonAvanzarEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		BotonAvanzarEstadoRecibido.click();     Thread.sleep(secDelay);
		WebElement AvanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		AvanceEstadoRecibido.click();     Thread.sleep(secDelay);
			              
		WebElement MensajeConfirmacionRecibido = driver.findElement(By.id("messagebox-1027-msg"));
			String MensajeRecibido = MensajeConfirmacionRecibido.getText();
			System.out.println("Avance: " + MensajeRecibido);	Thread.sleep(secDelay);
			          	    	 
		WebElement InformacionAvanceRecibido = driver.findElement(By.id("messagebox-1027-msg"));
			String ObtenerMensajeRecibido = InformacionAvanceRecibido.getText().trim();
			System.out.println(ObtenerMensajeRecibido);
			String ExpectativaTextoRecibido = "Registro modificado exitosamente";
			    
			Assert.assertEquals(ObtenerMensajeRecibido, ExpectativaTextoRecibido);	
			           	    	 
		WebElement AceptarAvanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		AceptarAvanceEstadoRecibido.click();
			 	        
		String MensajeInformativoRecibido =  MensajeRecibido;
			writeFile.writeCellValue(filepath, "Cases", 22, 11, MensajeInformativoRecibido);
                
			
		// Avamce Sobrante - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            
		WebElement SeleccionarRemesaAvanveAlternoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		SeleccionarRemesaAvanveAlternoSobrante.click();     Thread.sleep(secDelay);
		        
		WebElement BotonAvanceAlternoRemesaSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnInnerEl")));
		BotonAvanceAlternoRemesaSobrante.click();
		WebElement DesplegarAvanzarEstadoAlternoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
		DesplegarAvanzarEstadoAlternoSobrante.click();
		WebElement SeleccionarAvanzarEstadoAlternoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Confirmado Ajuste Sobrante']")));
		SeleccionarAvanzarEstadoAlternoSobrante.click();
		WebElement AceptarAvanzarEstadoAlternoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnInnerEl")));
		AceptarAvanzarEstadoAlternoSobrante.click();     Thread.sleep(secDelay);
		                
		WebElement DesplegarDenominacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionSobrantesAjuste-trigger-picker")));
		DesplegarDenominacionSobrante.click();     Thread.sleep(secDelay);
		WebElement SeleccionarDenominacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BILLETES - 100,000']")));          
		SeleccionarDenominacionSobrante.click();     Thread.sleep(secDelay);
		WebElement DesplegarClasificaciónSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionSobrantesAjuste-trigger-picker")));
		DesplegarClasificaciónSobrante.click();
		WebElement SeleccionarClasificacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
		SeleccionarClasificacionSobrante.click();
		WebElement EscribirCantidadSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadSobrantesAjuste-inputEl")));
		EscribirCantidadSobrante.sendKeys("1");
		WebElement IncluirSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirSobrantesAjuste-btnWrap")));
		IncluirSobrante.click();
		WebElement AceptarSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAjuste-btnInnerEl")));
		AceptarSobrante.click();     Thread.sleep(secDelay);
		                   
		WebElement MensajeConfirmacionSobrante = driver.findElement(By.id("messagebox-1027-msg"));
		    String MensajeSobrante = MensajeConfirmacionSobrante.getText();
		    System.out.println("Avance: " + MensajeSobrante);
		           
		WebElement InformacionAvanceFaltante = driver.findElement(By.id("messagebox-1027-msg"));
		    String ObtenerMensajeFaltante = InformacionAvanceFaltante.getText().trim();
		    System.out.println(ObtenerMensajeFaltante);
		    String ExpectativaTextoFaltante = "Registro modificado exitosamente";
		         
		    Assert.assertEquals(ObtenerMensajeFaltante, ExpectativaTextoFaltante);	
		            
		WebElement AceptarAvanceAlternoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		AceptarAvanceAlternoSobrante.click();
		          	
		String MensajeInformativoSobrante =  MensajeSobrante;
			writeFile.writeCellValue(filepath, "Cases", 22, 16, MensajeInformativoSobrante);
			
            
		// Retroceder a Diferencias - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            
		WebElement RetrocederEnvios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
		RetrocederEnvios.click();
		                              
		WebElement Diferencias = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
		Diferencias.click();
		      
		WebElement DesplegarTipoUnidadDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
		DesplegarTipoUnidadDiferencia.click(); 	   Thread.sleep(secDelay);
		WebElement SeleccionarTipoUnidadDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + TipoUnidadDiferencia + "']")));
		SeleccionarTipoUnidadDiferencia.click();
		WebElement DesplegarUnidadDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadEmisora-trigger-picker")));
		DesplegarUnidadDiferencia.click(); 	   Thread.sleep(secDelay);
		WebElement SeleccionarUnidadDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + UnidadDiferencia + "']")));
		SeleccionarUnidadDiferencia.click();
		WebElement DesplegarTipoConsultaDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
		DesplegarTipoConsultaDiferencia.click();	 Thread.sleep(secDelay);
		WebElement SeleccionarTipoConsultaDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
		SeleccionarTipoConsultaDiferencia.click();
		WebElement DesplegarTipoDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
		DesplegarTipoDiferencia.click(); 	 Thread.sleep(secDelay);
		WebElement SeleccionarTipoDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Sobrante']")));
		SeleccionarTipoDiferencia.click();
		WebElement DesplegarOrigenDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
		DesplegarOrigenDiferencia.click(); 	   Thread.sleep(secDelay);
		WebElement SeleccionarOrigenDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='REMESA']")));
		SeleccionarOrigenDiferencia.click();
		        
		WebElement ConsultarDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("consultar-btnWrap")));
		ConsultarDiferencia.click();
			        
		WebElement SeleccionarDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1011']")));
		SeleccionarDiferencia.click();
		WebElement BotonSaldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar-btnInnerEl")));
		BotonSaldar.click(); 	 Thread.sleep(secDelay);
			        
		WebElement DesplegarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
		DesplegarModalidad.click();
		WebElement SeleccionarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Modalidad)));
		SeleccionarModalidad.click();
		WebElement MontoSaldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
		MontoSaldar.sendKeys("100");
		WebElement Descripción = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
		Descripción.sendKeys("prueba");
	        	        
	    // Entrega de Efectivo - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	      
	        
		WebElement DesplegarDenominación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionEfec-trigger-picker")));
		DesplegarDenominación.click();
		WebElement SeleccionarDenominación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BILLETES - 100,000']")));
		SeleccionarDenominación.click();
		WebElement CantidadPiezas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEfec-inputEl")));
		CantidadPiezas.sendKeys("1");
		WebElement DesplegarClasificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionEfec-trigger-picker")));
		DesplegarClasificación.click();
		WebElement SeleccionarClasificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
		SeleccionarClasificacion.click();	                       	        
		WebElement PresionarIncluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacionEfec-btnWrap")));
		PresionarIncluir.click();	  Thread.sleep(secDelay);
		        
		WebElement PresionarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReg-btnWrap")));
	    PresionarAceptar.click();     Thread.sleep(secDelay);
	        
	    WebElement InformacionDiferenciaSaldada = driver.findElement(By.id("messagebox-1001-msg"));
			String ObtenerMensajeDiferencia = InformacionDiferenciaSaldada.getText().trim();
			System.out.println(ObtenerMensajeDiferencia);
			String ExpectativaTextoDiferencia = "Operación exitosa,";
			
			Assert.assertEquals(ObtenerMensajeDiferencia, ExpectativaTextoDiferencia);
	        
	    WebElement ConfirmarOperacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	    ConfirmarOperacion.click();
	    
	    
	    // Validar Cierre de Unidades - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -      	  
        
	 	WebElement BotonRetroceder = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
	 	BotonRetroceder.click();
	 	WebElement CierreUnidadesFinal = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Image1")));
	 	CierreUnidadesFinal.click();
	 	 	        
	 	WebElement DesplegarTipoUnidadCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
	 	DesplegarTipoUnidadCierre_Final.click();
	 	WebElement SeleccionarTipoUnidadCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + TipoUnidadCierre + "']")));
	 	SeleccionarTipoUnidadCierre_Final.click();
	 	WebElement DesplegarUnidadCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen60")));
	 	DesplegarUnidadCierre_Final.click();
	 	WebElement SeleccionarUnidadCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + UnidadCierre + "']")));
	 	SeleccionarUnidadCierre_Final.click();
	 	WebElement DesplegarDivisaCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen73")));
	 	DesplegarDivisaCierre_Final.click();
	 	WebElement SeleccionarDivisaCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dólar']")));
	 	SeleccionarDivisaCierre_Final.click();
	 	WebElement ConsultarCierr_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen86")));
	 	ConsultarCierr_Final.click();
	 	WebElement SeleccionarDía_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
	 	SeleccionarDía_Final.click();
	 	WebElement CerrarDía_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCerrarDia")));
	 	CerrarDía_Final.click();
	 	WebElement MensajeConfirmacion_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1069")));
	 	MensajeConfirmacion_Final.click(); 	   Thread.sleep(secDelay);

	    File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(archivo2, new File(captura2));
	        
	        Thread.sleep(secDelay);		
	}
}