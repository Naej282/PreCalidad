package Integrales_Diferencias;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
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

public class Cases_474 {

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
		
		
		//  ----------  Saldar Diferencia Faltante - Cheque mismo Banco - Inventario ----------	
		
		
		// Excel - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
																	
			String filepath = "" + Constante_PreCalidad.RUTA_EXCEL + "\\MatrizIntegrales.xlsx";
															
			String TipoUnidad = readFile.getCellValue(filepath, "Cases", 30, 1);
			String Unidad = readFile.getCellValue(filepath, "Cases", 30, 2);
			String EmpresaTransportista = readFile.getCellValue(filepath, "Cases", 30, 5);
															
			String TipoUnidadCierre = readFile.getCellValue(filepath, "General", 9, 1);
			String UnidadCierre = readFile.getCellValue(filepath, "General", 9, 2);
										
			String TipoUnidadDiferencia = readFile.getCellValue(filepath, "General", 9, 1);
			String UnidadDiferencia = readFile.getCellValue(filepath, "General", 9, 2);
			
			String Banco = readFile.getCellValue(filepath, "General", 11, 2);
			
			
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
																			        
			String directorioCapturas =  "" + Constante_PreCalidad.RUTA_CAPTURES + "\\Cases 474";
																				 	
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
    
	        	
	        	 // Pestaña Inventario - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		 	       
			    js.executeScript("window.open(arguments[0]);", Central);	  
				    
				Set<String> handles2 = driver.getWindowHandles();
				    
				String InventarioCentral = (String) handles2.toArray()[handles2.size() - 1];
				    driver.switchTo().window(InventarioCentral);
			        
				WebElement loginCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
			    loginCentral.sendKeys(Constante_PreCalidad.USUARIO);
			    WebElement passwordCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			    passwordCentral.sendKeys(Constante_PreCalidad.CONTRASEÑA);	        Thread.sleep(secDelay);
			    WebElement enterCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
			    enterCentral.click();
			        
			    WebElement logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
			    logistica.click();
			    WebElement InventarioEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventarioEfectivo")));
			    InventarioEfectivo.click(); 	Thread.sleep(secDelay);
			         	    
			  	WebElement DesplegarTipoUnidadInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
			  	DesplegarTipoUnidadInventario.click();	   Thread.sleep(secDelay);
			  	WebElement SeleccionarTipoUnidadInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + TipoUnidad + "']")));
			  	SeleccionarTipoUnidadInventario.click();   	Thread.sleep(secDelay);	
			  	WebElement DesplegarUnidadInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
			    DesplegarUnidadInventario.click(); 	   Thread.sleep(secDelay);
			  	WebElement SeleccionarUnidadInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + Unidad + "']")));
			  	SeleccionarUnidadInventario.click(); 	 Thread.sleep(secDelay);
			  	WebElement DesplegarBovedaInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoBoveda-trigger-picker")));
			  	DesplegarBovedaInventario.click(); 	   Thread.sleep(secDelay);
			  	WebElement SeleccionarBovedaInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constante_PreCalidad.BOVEDA+"']")));
			  	SeleccionarBovedaInventario.click();
			  	WebElement DesplegaDivisaInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			  	DesplegaDivisaInventario.click();     Thread.sleep(secDelay);  	    
			  	WebElement SeleccionarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item'][text()='Dólar']")));
			  	SeleccionarDivisa.click();
			  	    
			  	WebElement ConsultarInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
			  	ConsultarInventario.click();
			  	    
			  	WebElement DesplegarConsultaInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
			  	DesplegarConsultaInventario.click();	
			  	
	     		                	                          
			  	 // Ajuste Faltante - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	            
			  	WebElement AjusteInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajusteInventario-btnWrap")));
		        AjusteInventario.click();
		        WebElement DesplegarDenominaciónAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
		        DesplegarDenominaciónAjuste.click();
		        WebElement SeleccionarDenominaciónAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BILLETES - 100,000']")));
		        SeleccionarDenominaciónAjuste.click();
		        WebElement DesplegarClasificaciónAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
		        DesplegarClasificaciónAjuste.click();
		        WebElement SeleccionarClasificaciónAiuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
		        SeleccionarClasificaciónAiuste.click();
		        WebElement ColocarCantidadAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantesAjuste-inputEl")));
		        ColocarCantidadAjuste.sendKeys("1");
		        WebElement incluirAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirAjuste1Ajuste-btnWrap")));
		        incluirAjuste.click();
		          
		        WebElement AceptarAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAjuste")));
		        AceptarAjuste.click();     Thread.sleep(secDelay);
		          	        
		  		WebElement InformacionAjuste = driver.findElement(By.id("messagebox-1001-msg"));
		      		String ObtenerMensajeAjuste = InformacionAjuste.getText().trim();
		      		System.out.println(ObtenerMensajeAjuste);
		      		String ExpectativaTextoAjuste = "Registro modificado exitosamente";

		      		Assert.assertEquals(ObtenerMensajeAjuste, ExpectativaTextoAjuste);
		          
		        WebElement MensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
		        MensajeInformativo.click();
		        
                     
		     // Retroceder a Diferencias - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	            
		        WebElement Retroceder = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
		        Retroceder.click();
		          
		        WebElement AdministracionEfectivo_Diferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
		        AdministracionEfectivo_Diferencia.click();
		          
		        WebElement Diferencias = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
		        Diferencias.click();
		    
			    WebElement DesplegarTipoUnidadDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
			    DesplegarTipoUnidadDiferencia.click(); 	   Thread.sleep(secDelay);

			    WebElement SeleccionarTipoUnidadDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + TipoUnidadDiferencia + "']")));
			    SeleccionarTipoUnidadDiferencia.click(); 	 Thread.sleep(secDelay);	        Thread.sleep(secDelay);
			    WebElement DesplegarUnidadDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadEmisora-trigger-picker")));
			    DesplegarUnidadDiferencia.click(); 	   Thread.sleep(secDelay);
			    WebElement SeleccionarUnidadDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + UnidadDiferencia + "']")));
			    SeleccionarUnidadDiferencia.click();
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
			        
			    WebElement ConsultarDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("consultar-btnWrap")));
			    ConsultarDiferencia.click();
			        
			    WebElement SeleccionarDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1011']")));
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
			    
	        	        
	        // Cheque de otro Banco - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	        
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