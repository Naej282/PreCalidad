package Integrales_Diferencias;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class Cases_496 {

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
		
		
		//  ----------  Saldar Diferencia Faltante -  Cheque de otros Bancos - Inventario ----------	
	 	
	 	
		// Excel - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
															 																	
		String filepath =  "" + Constante_PreCalidad.RUTA_EXCEL + "\\MatrizIntegrales.xlsx";
													 						
		String TipoUnidadReceptora = readFile.getCellValue(filepath, "Cases", 52, 1);
		String UnidadReceptora = readFile.getCellValue(filepath, "Cases", 52, 2);
		String EmpresaTransportista = readFile.getCellValue(filepath, "Cases", 52, 5);
															 				
		String TipoUnidadCierre = readFile.getCellValue(filepath, "General", 5, 1);
		String UnidadCierre = readFile.getCellValue(filepath, "General", 5, 2);
			
		String Banco = readFile.getCellValue(filepath, "General", 11, 3);
									
																			 											 									
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		String Modalidad ="//li[text()='Cheque de otros Bancos']";
		 	
		 	
		// Cambio de Pestaña - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		 	
		JavascriptExecutor js = (JavascriptExecutor) driver;	
										 																							 	
		String Agencia = Constante_PreCalidad.URL_AGENCIA;
		String Central = Constante_PreCalidad.URL_CENTRAL;
										 																							

		// Obtener Fecha Actual - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
										 																							
		int DiaActual = LocalDate.now().getDayOfMonth();			
										 																						        			       
		String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
										 																							        
		System.out.println(DiaActualString);
										 																							
										 																								
		// Captura - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
										 																			        
		String directorioCapturas =  "" + Constante_PreCalidad.RUTA_CAPTURES + "\\Cases 496";
										 																				 	
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
			
	        
		// Pestaña Inventario - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		        
		js.executeScript("window.open(arguments[0]);", Agencia);	  
									    
		Set<String> handles2 = driver.getWindowHandles();
										    
		String InventarioAgencia = (String) handles2.toArray()[handles2.size() - 1];
				driver.switchTo().window(InventarioAgencia);
									        
		WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
		WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA); 		    Thread.sleep(secDelay);	 
		WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		enterAgencia.click();
									        
		WebElement CuadreAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
		CuadreAgencia.click();
		WebElement Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
		Inventario.click();	  	Thread.sleep(secDelay);
									        	        
		WebElement DesplegarBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
		DesplegarBoveda.click();	 Thread.sleep(secDelay);
		WebElement SeleccionarBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
		SeleccionarBoveda.click();
		WebElement DesplegaDivisaInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		DesplegaDivisaInventario.click();	  	Thread.sleep(secDelay);
		WebElement SeleccionarDivisaInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		SeleccionarDivisaInventario.click();
									  	    
		WebElement ConsultarInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		ConsultarInventario.click();
									  	    
		WebElement DesplegarConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
		DesplegarConsulta.click();	   
		
	     		                	                          
		// Ajuste Faltante - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  	    
		WebElement AjusteInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda-btnWrap")));
	    AjusteInventario.click();     Thread.sleep(secDelay);
	    WebElement DesplegarDenominaciónAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
	    DesplegarDenominaciónAjuste.click();
		WebElement SeleccionarDenominaciónAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));
		SeleccionarDenominaciónAjuste.click();
		WebElement DesplegarClasificaciónAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
		DesplegarClasificaciónAjuste.click();
		WebElement SeleccionarClasificaciónAiuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
		SeleccionarClasificaciónAiuste.click();
		WebElement ColocarCantidadAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantesAjuste-inputEl")));
		ColocarCantidadAjuste.sendKeys("1");	Thread.sleep(secDelay);
			          
		WebElement incluirAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1097-btnWrap")));
		incluirAjuste.click();     Thread.sleep(secDelay);
			          
		WebElement AceptarAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1110-btnWrap")));
		AceptarAjuste.click();     Thread.sleep(secDelay);
			          	        
		WebElement InformacionAjuste = driver.findElement(By.id("messagebox-1001-msg"));
			String ObtenerMensajeAjuste = InformacionAjuste.getText().trim();
			System.out.println(ObtenerMensajeAjuste);
			String ExpectativaTextoAjuste = "Registro creado exitosamente";
			      	
			Assert.assertEquals(ObtenerMensajeAjuste, ExpectativaTextoAjuste);
			          
	    WebElement MensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
		MensajeInformativo.click();
			    
                     
		// Retroceder a Diferencias - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	              
		WebElement inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		inicio.click();
			                       
		WebElement Diferencias = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
		Diferencias.click();	 Thread.sleep(secDelay);
			            
		WebElement DesplegarTipoConsultaDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
		DesplegarTipoConsultaDiferencia.click(); 	 Thread.sleep(secDelay);
		WebElement SeleccionarTipoConsultaDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
		SeleccionarTipoConsultaDiferencia.click();
		WebElement DesplegarTipoDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
		DesplegarTipoDiferencia.click(); 	 Thread.sleep(secDelay);
		WebElement SeleccionarTipoDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Faltante']")));
		SeleccionarTipoDiferencia.click();
		WebElement DesplegarOrigenDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
		DesplegarOrigenDiferencia.click(); 	   Thread.sleep(secDelay);
		WebElement SeleccionarOrigenDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOVEDA']")));
		SeleccionarOrigenDiferencia.click();
			      	      
		WebElement ConsultarDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041-btnWrap")));
		ConsultarDiferencia.click();
				        
		WebElement SeleccionarDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1026']")));
		SeleccionarDiferencia.click();
				        
		WebElement BotonSaldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar-btnInnerEl")));
		BotonSaldar.click(); 	        Thread.sleep(secDelay);
				        
		WebElement DesplegarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
		DesplegarModalidad.click();
		WebElement SeleccionarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Modalidad)));
		SeleccionarModalidad.click();
		WebElement MontoSaldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
		MontoSaldar.sendKeys("100");
		WebElement Descripción = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
		Descripción.sendKeys("prueba");
				
	        	        
	    // Cheque de otros Bancos - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -   
		        
		WebElement DesplegarBanco = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("banco-trigger-picker")));
		DesplegarBanco.click();
		WebElement SeleccionarBanco = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + Banco + "']")));
		SeleccionarBanco.click();
		WebElement NumeroCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuenta-inputEl")));
		NumeroCuenta.sendKeys("123456");
		WebElement Serial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("serial-inputEl")));
		Serial.sendKeys("123456789");	 
		WebElement NombreDeCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuenta-inputEl")));
		NombreDeCuenta.sendKeys("Automatización");
			                    
		WebElement PresionarIncluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacion-btnWrap")));
		PresionarIncluir.click();     Thread.sleep(secDelay);
			                    
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
		        
		WebElement BotonRetroceder = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
		BotonRetroceder.click();
				 
		WebElement CuadreAgencia_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
		CuadreAgencia_Final.click();
		WebElement CierreAgencia_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cierre")));
		CierreAgencia_Final.click();
		        	       
		WebElement DesplegarDivisaCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
		DesplegarDivisaCierre_Final.click();
		WebElement seleccionarDivisaCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dólar']")));
		seleccionarDivisaCierre_Final.click();
		WebElement ConsultarCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
		ConsultarCierre_Final.click();
		WebElement SeleccionarDíaCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
		SeleccionarDíaCierre_Final.click();
		WebElement CerrarDíaCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCierre")));
		CerrarDíaCierre_Final.click();
		WebElement MensajeConfirmacionCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1067")));
		MensajeConfirmacionCierre_Final.click();	 Thread.sleep(secDelay);

		File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(archivo2, new File(captura2));	Thread.sleep(secDelay);
			
	}
}