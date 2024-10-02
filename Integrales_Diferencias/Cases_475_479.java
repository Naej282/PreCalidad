package Integrales_Diferencias;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constantes.*;
import DataDrivenTesting.ReadExcelFile;

public class Cases_475_479 {

		int secDelay = 1000;
		private WebDriver driver;
		private ReadExcelFile readFile;
		private Process ffmpegProcess;
	
		@Before
		public void setUp() throws Exception {
			
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		readFile = new ReadExcelFile();
		driver.get(Constantes.URL_CENTRAL);
		}

	@Test
	public void test() throws IOException, InterruptedException {
		
	//  ----------  Saldar Diferencia Sobrante - Inventario ----------	
	// Excel - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
																		
		String filepath = "" + Constantes.RUTA_EXCEL + "\\MatrizIntegrales.xlsx";
																
		String TipoUnidad = readFile.getCellValue(filepath, "Cases", 31, 1);
		String Unidad = readFile.getCellValue(filepath, "Cases", 31, 2);														
		String TipoUnidadCierre = readFile.getCellValue(filepath, "General", 9, 1);
		String UnidadCierre = readFile.getCellValue(filepath, "General", 9, 2);								
		String TipoUnidadDiferencia = readFile.getCellValue(filepath, "General", 9, 1);
		String UnidadDiferencia = readFile.getCellValue(filepath, "General", 9, 2);
		String Banco = readFile.getCellValue(filepath, "General", 11, 2);
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
							
		String Modalidad ="//li[text()='Abono en Cuenta']";
		String Modalidad2 ="//li[text()='Contra Ingreso']";
		String Modalidad3 ="//li[text()='Entrega de Efectivo']";
		String Modalidad4 ="//li[text()='Cheque mismo Banco']";
		String Modalidad5 ="//li[text()='Cheque de otros Bancos']";
		 	
		
		// Cambio de Pestaña - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 	
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		String Central = Constantes.URL_CENTRAL;
																						

		// Obtener Fecha Actual - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
																						
		int DiaActual = LocalDate.now().getDayOfMonth();																					        			       
		String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);																		        
		System.out.println(DiaActualString);
																						
		//--------------Guardar la fecha y hora - Darle un formato - Volverlo un string para guardarlo----------------//

		LocalDate fechaActual = LocalDate.now();
    	LocalTime horaActual = LocalTime.now();
    	DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	String fechaFormateada = fechaActual.format(formatoFecha);
    	DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH-mm-ss");
    	String horaFormateada = horaActual.format(formatoHora);
    	String nombreArchivo = fechaFormateada.replace("/", "-") + "_" + horaFormateada + ".avi";
		System.out.println("Fecha y Hora (formato dd/MM/yyyy/HH/mm/ss): " + nombreArchivo);
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Integrales_Diferencia\\Cases_475_479\\"+nombreArchivo+"";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		// Captura - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
																		        
		String directorioCapturas = "" + Constantes.RUTA_CAPTURES + "\\Integrales_Diferencia\\Cases_475_479";
		String nombreArchivo1 = "Cierre Inicial.png";
		String captura1 = directorioCapturas + "/" + nombreArchivo1;	 	
		String nombreArchivo2 = "Abono en Cuenta.png";
		String captura2 = directorioCapturas + "/" + nombreArchivo2;
		String nombreArchivo3 = "Contra Ingreso.png";
		String captura3 = directorioCapturas + "/" + nombreArchivo3;	 	
		String nombreArchivo4 = "Entrega de Efectivo.png";
		String captura4 = directorioCapturas + "/" + nombreArchivo4;
		String nombreArchivo5 = "Cheque mismo Banco.png";
		String captura5 = directorioCapturas + "/" + nombreArchivo5;
		String nombreArchivo6 = "Entrega de Efectivo.png";
		String captura6 = directorioCapturas + "/" + nombreArchivo6;					 	
																			 	
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
					        
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);
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
		WebElement SeleccionarDivisaCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Constantes.DIVISA+"']")));
		SeleccionarDivisaCierre.click();
		WebElement ConsultarCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen86")));
		ConsultarCierre.click();
  
		WebElement SeleccionarDía = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
		SeleccionarDía.click();			         
		WebElement CerrarDía = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCerrarDia")));
		CerrarDía.click();
		WebElement MensajeConfirmacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1069")));
		MensajeConfirmacion.click();	 Thread.sleep(secDelay);
		
		WebElement BovedaDiferenciasSobrante = driver.findElement(By.id("bovedaEntradaCierre"));
   	    String BovedaDiferenciasSobranteString = BovedaDiferenciasSobrante.getAttribute("value");
   	    BovedaDiferenciasSobranteString = BovedaDiferenciasSobranteString.replace("." , "").replace("," , ".");
   	 	double BovedaDiferenciasSobranteDouble = Double.parseDouble(BovedaDiferenciasSobranteString);
     	System.out.println(BovedaDiferenciasSobranteDouble);
     	
     	WebElement SalidasRegularizacionesSobrante = driver.findElement(By.id("regularizacionSalidaCierre"));
   	    String SalidasRegularizacionesSobranteString = SalidasRegularizacionesSobrante.getAttribute("value");
   	    SalidasRegularizacionesSobranteString = SalidasRegularizacionesSobranteString.replace("." , "").replace("," , ".");
   	 	double SalidasRegularizacionesSobranteDouble = Double.parseDouble(SalidasRegularizacionesSobranteString);
     	System.out.println(SalidasRegularizacionesSobranteDouble);

	    File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo, new File(captura1));	Thread.sleep(secDelay);
   
	        
        // Pestaña Inventario - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 	       
	    js.executeScript("window.open(arguments[0]);", Central);	  
		Set<String> handles2 = driver.getWindowHandles();			    
		String InventarioCentral = (String) handles2.toArray()[handles2.size() - 1];
	    driver.switchTo().window(InventarioCentral);
	        
		WebElement loginCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginCentral.sendKeys(Constantes.USUARIO);
	    WebElement passwordCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordCentral.sendKeys(Constantes.CONTRASEÑA);	        Thread.sleep(secDelay);
	    WebElement enterCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterCentral.click();
	        
	    WebElement logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
	    logistica.click();
	    WebElement InventarioEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventarioEfectivo")));
	    InventarioEfectivo.click(); 	Thread.sleep(secDelay);
		         	    
	  	WebElement DesplegarTipoUnidadInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
	  	DesplegarTipoUnidadInventario.click();	   Thread.sleep(secDelay);
	  	List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	      for (WebElement option : options) {
	          if (option.getText().equals(TipoUnidad)) {
	              option.click();
	              break;
	               }
	           }		Thread.sleep(secDelay);
	  	WebElement DesplegarUnidadInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
	    DesplegarUnidadInventario.click(); 	   Thread.sleep(secDelay);
	    List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options2) {
            if (option.getText().equals(Unidad)) {
                option.click();
                break;
            
                }
            }		Thread.sleep(secDelay);
	  	WebElement DesplegarBovedaInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoBoveda-trigger-picker")));
	  	DesplegarBovedaInventario.click(); 	   Thread.sleep(secDelay);
	  	WebElement SeleccionarBovedaInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.BOVEDA+"']")));
	  	SeleccionarBovedaInventario.click();
	  	WebElement DesplegaDivisaInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
	  	DesplegaDivisaInventario.click();     Thread.sleep(secDelay);  	    
	  	WebElement SeleccionarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item'][text()='"+Constantes.DIVISA+"']")));
	  	SeleccionarDivisa.click();
	  	    
	  	WebElement ConsultarInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
	  	ConsultarInventario.click();	  	    
	  	WebElement DesplegarConsultaInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
	  	DesplegarConsultaInventario.click();	
		  	
	     		                	                          
        // Ajuste Sobrante - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        
	  	for (int i = 0; i < 6; i++) {
        WebElement AjusteInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajusteInventario-btnWrap")));
        AjusteInventario.click();
        WebElement DesplegarDenominaciónAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionSobrantesAjuste-trigger-picker")));
        DesplegarDenominaciónAjuste.click();
        List<WebElement> SeleccionarDenominacionFaltante = driver.findElements(By.xpath("//li[text()='"+Constantes.DENOMINACION_DIFERENCIA+"' or text()='BILLETES - 100,00000000']"));          
        for (WebElement SeleccionarDenominacionFaltantes : SeleccionarDenominacionFaltante ) {
    	SeleccionarDenominacionFaltantes.click();     Thread.sleep(secDelay);
        }
        WebElement DesplegarClasificaciónAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionSobrantesAjuste-trigger-picker")));
        DesplegarClasificaciónAjuste.click();
        WebElement SeleccionarClasificaciónAiuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.APTOS+"']")));
        SeleccionarClasificaciónAiuste.click();
        WebElement ColocarCantidadAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadSobrantesAjuste-inputEl")));
        ColocarCantidadAjuste.sendKeys("1");
        WebElement IncluirAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirAju2Ajuste-btnInnerEl")));
        IncluirAjuste.click();
        
        WebElement AceptarAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAjuste")));
        AceptarAjuste.click();     Thread.sleep(secDelay);
          	        
  		WebElement InformacionAjuste = driver.findElement(By.id("messagebox-1001-msg"));
  		String ObtenerMensajeAjuste = InformacionAjuste.getText().trim();
  		System.out.println(ObtenerMensajeAjuste);
  		String ExpectativaTextoAjuste = "Registro modificado exitosamente";
  		Assert.assertEquals(ObtenerMensajeAjuste, ExpectativaTextoAjuste);
	          
        WebElement MensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        MensajeInformativo.click();
	  	}
                     
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
	    WebElement SeleccionarTipoDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Sobrante']")));
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
	    
	 // Abono en Cuenta - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	      
        
	    WebElement NroCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuentaCuen-inputEl")));
	    NroCuenta.sendKeys("02147850");
	    WebElement NombreCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuentaCuen-inputEl")));
	    NombreCuenta.sendKeys("Prueba Automatizada");
	    WebElement PresionarIncluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacionCuen-btnWrap")));
	    PresionarIncluir.click();     Thread.sleep(secDelay);
	    WebElement PresionarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReg-btnWrap")));
	    PresionarAceptar.click();	  Thread.sleep(secDelay);
	        
	    WebElement InformacionDiferenciaSaldada = driver.findElement(By.id("messagebox-1001-msg"));
 		String ObtenerMensajeDiferencia = InformacionDiferenciaSaldada.getText().trim();
 		System.out.println(ObtenerMensajeDiferencia);
 		String ExpectativaTextoDiferencia = "Operación exitosa,"; 
	 	Assert.assertEquals(ObtenerMensajeDiferencia, ExpectativaTextoDiferencia);
	 	
	 	WebElement ConfirmarOperacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	 	ConfirmarOperacion.click();
	        
	 	// Validar Cierre de Unidades Abono en Cuenta- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -      	  
        
	 	js.executeScript("window.open(arguments[0]);", Constantes.URL_CENTRAL_CIERRE_DE_UNIDADES);	      
	    Set<String> handles3 = driver.getWindowHandles();
	    String PestañaCentral2 = (String) handles3.toArray()[handles3.size() - 1];
	    driver.switchTo().window(PestañaCentral2);
        
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
        WebElement SeleccionarDivisaCierre_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Constantes.DIVISA+"']")));
        SeleccionarDivisaCierre_Final.click();
        WebElement ConsultarCierr_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen86")));
        ConsultarCierr_Final.click();
        WebElement SeleccionarDía_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
        SeleccionarDía_Final.click();
        WebElement CerrarDía_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCerrarDia")));
        CerrarDía_Final.click();
        WebElement MensajeConfirmacion_Final = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1069")));
        MensajeConfirmacion_Final.click(); 	   Thread.sleep(secDelay);
        
        WebElement BovedaDiferenciasSobranteAbonoEnCuenta = driver.findElement(By.id("bovedaEntradaCierre"));
   	    String BovedaDiferenciasStringSobranteAbonoEnCuenta = BovedaDiferenciasSobranteAbonoEnCuenta.getAttribute("value");
   	    BovedaDiferenciasStringSobranteAbonoEnCuenta = BovedaDiferenciasStringSobranteAbonoEnCuenta.replace("." , "").replace("," , ".");
   	 	double BovedaDiferenciasDoubleSobranteAbonoEnCuenta = Double.parseDouble(BovedaDiferenciasStringSobranteAbonoEnCuenta);
     	System.out.println(BovedaDiferenciasDoubleSobranteAbonoEnCuenta);
     	Assert.assertEquals(BovedaDiferenciasDoubleSobranteAbonoEnCuenta, (BovedaDiferenciasSobranteDouble + 600), 0.000001);
     	
     	WebElement SalidasRegularizacionesSobranteAbonoEnCuenta = driver.findElement(By.id("regularizacionSalidaCierre"));
   	    String SalidasRegularizacionesStringSobranteAbonoEnCuenta = SalidasRegularizacionesSobranteAbonoEnCuenta.getAttribute("value");
   	    SalidasRegularizacionesStringSobranteAbonoEnCuenta = SalidasRegularizacionesStringSobranteAbonoEnCuenta.replace("." , "").replace("," , ".");
   	 	double SalidasRegularizacionesDoubleSobranteAbonoEnCuenta = Double.parseDouble(SalidasRegularizacionesStringSobranteAbonoEnCuenta);
     	System.out.println(SalidasRegularizacionesDoubleSobranteAbonoEnCuenta);
     	Assert.assertEquals(SalidasRegularizacionesDoubleSobranteAbonoEnCuenta, (SalidasRegularizacionesSobranteDouble), 0.000001);

        File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(archivo2, new File(captura2));
        	
    	//Saldamos la diferencia con Contra Ingreso------------------------------------------------------------------------------------------------------
    	
    	Set<String> handle2 = driver.getWindowHandles();
	    String PestañaCentral3 = (String) handle2.toArray()[handle2.size() - 2];
	    driver.switchTo().window(PestañaCentral3);
	    
	    WebElement SeleccionarDiferencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1011']")));
        SeleccionarDiferencia2.click();
        WebElement BotonSaldar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar-btnInnerEl")));
        BotonSaldar2.click(); 	 Thread.sleep(secDelay);

        WebElement DesplegarModalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
        DesplegarModalidad2.click();
        WebElement SeleccionarModalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Modalidad2)));
        SeleccionarModalidad2.click();
        WebElement MontoSaldar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
        MontoSaldar2.sendKeys("100");
        WebElement Descripción2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
        Descripción2.sendKeys("prueba");
        WebElement NroCuenta2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuentaCuen-inputEl")));
        NroCuenta2.sendKeys("02147850");
        WebElement NombreCuenta2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuentaCuen-inputEl")));
        NombreCuenta2.sendKeys("Prueba Automatizada");	              	        
        WebElement PresionarIncluir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacionCuen-btnWrap")));
        PresionarIncluir2.click();	  Thread.sleep(secDelay);     
        WebElement PresionarAceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReg-btnWrap")));
        PresionarAceptar2.click();     Thread.sleep(secDelay);
        
		WebElement InformacionDiferenciaSaldada2 = driver.findElement(By.id("messagebox-1001-msg"));
		String ObtenerMensajeDiferencia2 = InformacionDiferenciaSaldada2.getText().trim();
		System.out.println(ObtenerMensajeDiferencia2);
		String ExpectativaTextoDiferencia2 = "Operación exitosa,";
		Assert.assertEquals(ObtenerMensajeDiferencia2, ExpectativaTextoDiferencia2);
        
        WebElement ConfirmarOperacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
        ConfirmarOperacion2.click(); 	 Thread.sleep(secDelay);
        
        //Validamos el Cierre de Unidades con Contra Ingreso--------------------------------------------------------------------------------------
        
        js.executeScript("window.open(arguments[0]);", Constantes.URL_CENTRAL_CIERRE_DE_UNIDADES);	  
	    Set<String> handles4 = driver.getWindowHandles();
	    String PestañaCentral4 = (String) handles4.toArray()[handles4.size() - 1];
	    driver.switchTo().window(PestañaCentral4);
        
        WebElement DesplegarTipoUnidadCierre_Final2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
        DesplegarTipoUnidadCierre_Final2.click();
        WebElement SeleccionarTipoUnidadCierre_Final2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + TipoUnidadCierre + "']")));
        SeleccionarTipoUnidadCierre_Final2.click();
        WebElement DesplegarUnidadCierre_Final2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen60")));
        DesplegarUnidadCierre_Final2.click();
        WebElement SeleccionarUnidadCierre_Fina2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + UnidadCierre + "']")));
        SeleccionarUnidadCierre_Fina2.click();
        WebElement DesplegarDivisaCierre_Final2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen73")));
        DesplegarDivisaCierre_Final2.click();
        WebElement SeleccionarDivisaCierre_Final2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Constantes.DIVISA+"']")));
        SeleccionarDivisaCierre_Final2.click();
        WebElement ConsultarCierr_Final2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen86")));
        ConsultarCierr_Final2.click();
        WebElement SeleccionarDía_Final2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
        SeleccionarDía_Final2.click();
        WebElement CerrarDía_Final2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCerrarDia")));
        CerrarDía_Final2.click();
        WebElement MensajeConfirmacion_Final2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1069")));
        MensajeConfirmacion_Final2.click(); 	   Thread.sleep(secDelay);
        
        WebElement BovedaDiferenciasSobranteContraIngreso = driver.findElement(By.id("bovedaEntradaCierre"));
   	    String BovedaDiferenciasStringSobranteContraIngreso = BovedaDiferenciasSobranteContraIngreso.getAttribute("value");
   	    BovedaDiferenciasStringSobranteContraIngreso = BovedaDiferenciasStringSobranteContraIngreso.replace("." , "").replace("," , ".");
   	 	double BovedaDiferenciasDoubleSobranteContraIngreso = Double.parseDouble(BovedaDiferenciasStringSobranteContraIngreso);
     	System.out.println(BovedaDiferenciasDoubleSobranteContraIngreso);
     	Assert.assertEquals(BovedaDiferenciasDoubleSobranteContraIngreso, (BovedaDiferenciasSobranteDouble + 600), 0.000001);
     	
     	WebElement SalidasRegularizacionesSobranteContraIngreso = driver.findElement(By.id("regularizacionSalidaCierre"));
   	    String SalidasRegularizacionesStringSobranteContraIngreso = SalidasRegularizacionesSobranteContraIngreso.getAttribute("value");
   	    SalidasRegularizacionesStringSobranteContraIngreso = SalidasRegularizacionesStringSobranteContraIngreso.replace("." , "").replace("," , ".");
   	 	double SalidasRegularizacionesDoubleSobranteContraIngreso = Double.parseDouble(SalidasRegularizacionesStringSobranteContraIngreso);
     	System.out.println(SalidasRegularizacionesDoubleSobranteContraIngreso);
     	Assert.assertEquals(SalidasRegularizacionesDoubleSobranteContraIngreso, (SalidasRegularizacionesSobranteDouble), 0.000001);

        File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(archivo3, new File(captura3));
    	
    	//Saldamos la diferencia con Entrega de Efectivo-----------------------------------------------------------------------------------------
    	
    	Set<String> handle4 = driver.getWindowHandles();
	    String PestañaCentral7 = (String) handle4.toArray()[handle4.size() - 3];
	    driver.switchTo().window(PestañaCentral7);
	    
	    WebElement SeleccionarDiferencia4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1011']")));
        SeleccionarDiferencia4.click();
        WebElement BotonSaldar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar-btnInnerEl")));
        BotonSaldar4.click(); 	 Thread.sleep(secDelay);

        WebElement DesplegarModalidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
        DesplegarModalidad4.click();
        WebElement SeleccionarModalidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Modalidad3)));
        SeleccionarModalidad4.click();
        WebElement MontoSaldar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
        MontoSaldar4.sendKeys("100");
        WebElement Descripción4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
        Descripción4.sendKeys("prueba");
        
        WebElement Denominacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionEfec-trigger-picker")));
        Denominacion.click();
        List<WebElement> options3 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options3) {
            if (option.getText().equals(Constantes.DENOMINACION_DIFERENCIA)) {
                option.click();
                break;
            
                }
            }		Thread.sleep(secDelay);
            
        WebElement Cantidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEfec-inputEl")));
        Cantidad.sendKeys("1");
        
        WebElement Clasificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionEfec-trigger-picker")));
        Clasificacion.click();
        List<WebElement> options04 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options04) {
            if (option.getText().equals(Constantes.APTOS)) {
                option.click();
                break;
                }
            }		Thread.sleep(secDelay);
        
        WebElement PresionarIncluir4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacionEfec-btnInnerEl")));
        PresionarIncluir4.click();	  Thread.sleep(secDelay);     

        WebElement PresionarAceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReg-btnInnerEl")));
        PresionarAceptar4.click();     Thread.sleep(secDelay);
        
		WebElement InformacionDiferenciaSaldada4 = driver.findElement(By.id("messagebox-1001-msg"));
		String ObtenerMensajeDiferencia4 = InformacionDiferenciaSaldada4.getText().trim();
		System.out.println(ObtenerMensajeDiferencia4);
		String ExpectativaTextoDiferencia4 = "Operación exitosa,";
		Assert.assertEquals(ObtenerMensajeDiferencia4, ExpectativaTextoDiferencia4);
        
        WebElement ConfirmarOperacion4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
        ConfirmarOperacion4.click(); 	 Thread.sleep(secDelay);
        
        //Validamos el Cierre de Unidades con Entrega de Efectivo-----------------------------------------------------------------------------
        
        js.executeScript("window.open(arguments[0]);", Constantes.URL_CENTRAL_CIERRE_DE_UNIDADES);	  
	    
	    Set<String> handles6 = driver.getWindowHandles();
	    
	    String PestañaCentral8 = (String) handles6.toArray()[handles6.size() - 1];
	    driver.switchTo().window(PestañaCentral8);
        
        WebElement DesplegarTipoUnidadCierre_Final4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
        DesplegarTipoUnidadCierre_Final4.click();
        WebElement SeleccionarTipoUnidadCierre_Final4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + TipoUnidadCierre + "']")));
        SeleccionarTipoUnidadCierre_Final4.click();
        WebElement DesplegarUnidadCierre_Final4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen60")));
        DesplegarUnidadCierre_Final4.click();
        WebElement SeleccionarUnidadCierre_Fina4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + UnidadCierre + "']")));
        SeleccionarUnidadCierre_Fina4.click();
        WebElement DesplegarDivisaCierre_Final4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen73")));
        DesplegarDivisaCierre_Final4.click();
        WebElement SeleccionarDivisaCierre_Final4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Constantes.DIVISA+"']")));
        SeleccionarDivisaCierre_Final4.click();
        WebElement ConsultarCierr_Final4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen86")));
        ConsultarCierr_Final4.click();
        WebElement SeleccionarDía_Final4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
        SeleccionarDía_Final4.click();
        WebElement CerrarDía_Final4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCerrarDia")));
        CerrarDía_Final4.click();
        WebElement MensajeConfirmacion_Final4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1069")));
        MensajeConfirmacion_Final4.click(); 	   Thread.sleep(secDelay);

        WebElement BovedaDiferenciasReposicionEfectivoSobrante = driver.findElement(By.id("bovedaEntradaCierre"));
   	    String BovedaDiferenciasStringReposicionEfectivoSobrante = BovedaDiferenciasReposicionEfectivoSobrante.getAttribute("value");
   	    BovedaDiferenciasStringReposicionEfectivoSobrante = BovedaDiferenciasStringReposicionEfectivoSobrante.replace("." , "").replace("," , ".");
   	 	double BovedaDiferenciasDoubleReposicionEfectivoSobrante = Double.parseDouble(BovedaDiferenciasStringReposicionEfectivoSobrante);
     	System.out.println(BovedaDiferenciasDoubleReposicionEfectivoSobrante);
     	Assert.assertEquals(BovedaDiferenciasDoubleReposicionEfectivoSobrante, (BovedaDiferenciasSobranteDouble + 600), 0.000001);
     	
     	WebElement SalidasRegularizacionesReposicionEfectivoSobrante = driver.findElement(By.id("regularizacionSalidaCierre"));
   	    String SalidasRegularizacionesStringReposicionEfectivoSobrante = SalidasRegularizacionesReposicionEfectivoSobrante.getAttribute("value");
   	    SalidasRegularizacionesStringReposicionEfectivoSobrante = SalidasRegularizacionesStringReposicionEfectivoSobrante.replace("." , "").replace("," , ".");
   	 	double SalidasRegularizacionesDoubleReposicionEfectivoSobrante = Double.parseDouble(SalidasRegularizacionesStringReposicionEfectivoSobrante);
     	System.out.println(SalidasRegularizacionesDoubleReposicionEfectivoSobrante);
     	Assert.assertEquals(SalidasRegularizacionesDoubleReposicionEfectivoSobrante, (SalidasRegularizacionesSobranteDouble + 100), 0.000001);
        
        File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(archivo5, new File(captura4));
    	
    	//Saldamos la diferencia con Cheque mismo Banco--------------------------------------------------------------------------------------------------
    	
    	Set<String> handle6 = driver.getWindowHandles();
	    String PestañaCentral9 = (String) handle6.toArray()[handle6.size() - 4];
	    driver.switchTo().window(PestañaCentral9);
	    
	    WebElement SeleccionarDiferencia5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1011']")));
        SeleccionarDiferencia5.click();
        WebElement BotonSaldar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar-btnInnerEl")));
        BotonSaldar5.click(); 	 Thread.sleep(secDelay);

        WebElement DesplegarModalidad5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
        DesplegarModalidad5.click();
        WebElement SeleccionarModalidad5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Modalidad4)));
        SeleccionarModalidad5.click();
        WebElement MontoSaldar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
        MontoSaldar5.sendKeys("100");
        WebElement Descripción5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
        Descripción5.sendKeys("prueba");
        
        WebElement Banco1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("banco-trigger-picker")));
        Banco1.click();
        List<WebElement> options4 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options4) {
            if (option.getText().equals(Banco)) {
                option.click();
                break;
            
                }
            }		Thread.sleep(secDelay);
            
        WebElement NroDeCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuenta-inputEl")));
        NroDeCuenta.sendKeys("1000");
        WebElement Serial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("serial-inputEl")));
        Serial.sendKeys("1000");
        WebElement NombreDeLaCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuenta-inputEl")));
        NombreDeLaCuenta.sendKeys("1000");  Thread.sleep(secDelay); 
        WebElement PresionarIncluir5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacion-btnInnerEl")));
        PresionarIncluir5.click();	  Thread.sleep(secDelay);     
        WebElement PresionarAceptar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReg-btnInnerEl")));
        PresionarAceptar5.click();     Thread.sleep(secDelay);
       
		WebElement InformacionDiferenciaSaldada5 = driver.findElement(By.id("messagebox-1001-msg"));
		String ObtenerMensajeDiferencia5 = InformacionDiferenciaSaldada5.getText().trim();
		System.out.println(ObtenerMensajeDiferencia5);
		String ExpectativaTextoDiferencia5 = "Operación exitosa,";
		Assert.assertEquals(ObtenerMensajeDiferencia5, ExpectativaTextoDiferencia5);
        
        WebElement ConfirmarOperacion5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
        ConfirmarOperacion5.click(); 	 Thread.sleep(secDelay);
        
        //Validamos el Cierre de Unidades con Saldo Mismos Bancos-----------------------------------------------------------------------------------
        
        js.executeScript("window.open(arguments[0]);", Constantes.URL_CENTRAL_CIERRE_DE_UNIDADES);	  
	    Set<String> handles7 = driver.getWindowHandles();
	    String PestañaCentral10 = (String) handles7.toArray()[handles7.size() - 1];
	    driver.switchTo().window(PestañaCentral10);
        
        WebElement DesplegarTipoUnidadCierre_Final5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
        DesplegarTipoUnidadCierre_Final5.click();
        WebElement SeleccionarTipoUnidadCierre_Final5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + TipoUnidadCierre + "']")));
        SeleccionarTipoUnidadCierre_Final5.click();
        WebElement DesplegarUnidadCierre_Final5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen60")));
        DesplegarUnidadCierre_Final5.click();
        WebElement SeleccionarUnidadCierre_Fina5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + UnidadCierre + "']")));
        SeleccionarUnidadCierre_Fina5.click();
        WebElement DesplegarDivisaCierre_Final5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen73")));
        DesplegarDivisaCierre_Final5.click();
        WebElement SeleccionarDivisaCierre_Final5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Constantes.DIVISA+"']")));
        SeleccionarDivisaCierre_Final5.click();
        WebElement ConsultarCierr_Final5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen86")));
        ConsultarCierr_Final5.click();
        WebElement SeleccionarDía_Final5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
        SeleccionarDía_Final5.click();
        WebElement CerrarDía_Final5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCerrarDia")));
        CerrarDía_Final5.click();
        WebElement MensajeConfirmacion_Final5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1069")));
        MensajeConfirmacion_Final5.click(); 	   Thread.sleep(secDelay);

        WebElement BovedaDiferenciasSobranteChequeMismosBancos = driver.findElement(By.id("bovedaEntradaCierre"));
   	    String BovedaDiferenciasSobranteStringChequeMismosBancos = BovedaDiferenciasSobranteChequeMismosBancos.getAttribute("value");
   	    BovedaDiferenciasSobranteStringChequeMismosBancos = BovedaDiferenciasSobranteStringChequeMismosBancos.replace("." , "").replace("," , ".");
   	 	double BovedaDiferenciasSobranteDoubleChequeMismosBancos = Double.parseDouble(BovedaDiferenciasSobranteStringChequeMismosBancos);
     	System.out.println(BovedaDiferenciasSobranteDoubleChequeMismosBancos);
     	Assert.assertEquals(BovedaDiferenciasSobranteDoubleChequeMismosBancos, (BovedaDiferenciasSobranteDouble + 600), 0.000001);
     	
     	WebElement SalidasRegularizacionesSobranteChequeMismosBancos = driver.findElement(By.id("regularizacionSalidaCierre"));
   	    String SalidasRegularizacionesSobranteStringChequeMismosBancos = SalidasRegularizacionesSobranteChequeMismosBancos.getAttribute("value");
   	    SalidasRegularizacionesSobranteStringChequeMismosBancos = SalidasRegularizacionesSobranteStringChequeMismosBancos.replace("." , "").replace("," , ".");
   	 	double SalidasRegularizacionesSobranteDoubleChequeMismosBancos = Double.parseDouble(SalidasRegularizacionesSobranteStringChequeMismosBancos);
     	System.out.println(SalidasRegularizacionesSobranteDoubleChequeMismosBancos);
     	Assert.assertEquals(SalidasRegularizacionesSobranteDoubleChequeMismosBancos, (SalidasRegularizacionesSobranteDouble + 100), 0.000001);
        
        File archivo6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(archivo6, new File(captura5));
    	
    	//Saldamos la diferencia con Cheque de otros Bancos---------------------------------------------------------------------------------------------
    	
    	Set<String> handle7 = driver.getWindowHandles();
	    String PestañaCentral11 = (String) handle7.toArray()[handle7.size() - 5];
	    driver.switchTo().window(PestañaCentral11);
	    
	    WebElement SeleccionarDiferencia6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1011']")));
        SeleccionarDiferencia6.click();
        WebElement BotonSaldar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar-btnInnerEl")));
        BotonSaldar6.click(); 	 Thread.sleep(secDelay);

        WebElement DesplegarModalidad6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
        DesplegarModalidad6.click();
        WebElement SeleccionarModalidad6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Modalidad5)));
        SeleccionarModalidad6.click();
        WebElement MontoSaldar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
        MontoSaldar6.sendKeys("100");
        WebElement Descripción6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
        Descripción6.sendKeys("prueba");
        
        WebElement Banco2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("banco-trigger-picker")));
        Banco2.click();
        List<WebElement> options5 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options5) {
            if (option.getText().equals(Banco)) {
                option.click();
                break;
            
                }
            }		Thread.sleep(secDelay);
            
        WebElement NroDeCuenta2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuenta-inputEl")));
        NroDeCuenta2.sendKeys("1000");
        WebElement Serial2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("serial-inputEl")));
        Serial2.sendKeys("1000");
        WebElement NombreDeLaCuenta2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuenta-inputEl")));
        NombreDeLaCuenta2.sendKeys("1000");  Thread.sleep(secDelay); 
        WebElement PresionarIncluir6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacion-btnInnerEl")));
        PresionarIncluir6.click();	  Thread.sleep(secDelay);     
        WebElement PresionarAceptar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReg-btnInnerEl")));
        PresionarAceptar6.click();     Thread.sleep(secDelay);
       
		WebElement InformacionDiferenciaSaldada6 = driver.findElement(By.id("messagebox-1001-msg"));
		String ObtenerMensajeDiferencia6 = InformacionDiferenciaSaldada6.getText().trim();
		System.out.println(ObtenerMensajeDiferencia6);
		String ExpectativaTextoDiferencia6 = "Operación exitosa,";
		Assert.assertEquals(ObtenerMensajeDiferencia6, ExpectativaTextoDiferencia6);
		
        WebElement ConfirmarOperacion6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
        ConfirmarOperacion6.click(); 	 Thread.sleep(secDelay);
        
        //Validamos el Cierre de Unidades con Cheque de otros bancos-------------------------------------------------------------------------------------------
        
        js.executeScript("window.open(arguments[0]);", Constantes.URL_CENTRAL_CIERRE_DE_UNIDADES);	  
	    
	    Set<String> handles8 = driver.getWindowHandles();
	    
	    String PestañaCentral12 = (String) handles8.toArray()[handles8.size() - 1];
	    driver.switchTo().window(PestañaCentral12);
        
        WebElement DesplegarTipoUnidadCierre_Final6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
        DesplegarTipoUnidadCierre_Final6.click();
        WebElement SeleccionarTipoUnidadCierre_Final6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + TipoUnidadCierre + "']")));
        SeleccionarTipoUnidadCierre_Final6.click();
        WebElement DesplegarUnidadCierre_Final6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen60")));
        DesplegarUnidadCierre_Final6.click();
        WebElement SeleccionarUnidadCierre_Fina6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + UnidadCierre + "']")));
        SeleccionarUnidadCierre_Fina6.click();
        WebElement DesplegarDivisaCierre_Final6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen73")));
        DesplegarDivisaCierre_Final6.click();
        WebElement SeleccionarDivisaCierre_Final6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Constantes.DIVISA+"']")));
        SeleccionarDivisaCierre_Final6.click();
        WebElement ConsultarCierr_Final6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen86")));
        ConsultarCierr_Final6.click();
        WebElement SeleccionarDía_Final6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
        SeleccionarDía_Final6.click();
        WebElement CerrarDía_Final6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCerrarDia")));
        CerrarDía_Final6.click();
        WebElement MensajeConfirmacion_Final6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1069")));
        MensajeConfirmacion_Final6.click(); 	   Thread.sleep(secDelay);
        
        WebElement BovedaDiferenciasSobranteChequeOtrosBancos = driver.findElement(By.id("bovedaEntradaCierre"));
   	    String BovedaDiferenciasSobranteStringChequeOtrosBancos = BovedaDiferenciasSobranteChequeOtrosBancos.getAttribute("value");
   	    BovedaDiferenciasSobranteStringChequeOtrosBancos = BovedaDiferenciasSobranteStringChequeOtrosBancos.replace("." , "").replace("," , ".");
   	 	double BovedaDiferenciasSobranteDoubleChequeOtrossBancos = Double.parseDouble(BovedaDiferenciasSobranteStringChequeOtrosBancos);
     	System.out.println(BovedaDiferenciasSobranteDoubleChequeOtrossBancos);
     	Assert.assertEquals(BovedaDiferenciasSobranteDoubleChequeOtrossBancos, (BovedaDiferenciasSobranteDouble + 600), 0.000001);
     	
     	WebElement SalidasRegularizacionesSobranteChequeOtrosBancos = driver.findElement(By.id("regularizacionSalidaCierre"));
   	    String SalidasRegularizacionesSobranteStringChequeOtrosBancos = SalidasRegularizacionesSobranteChequeOtrosBancos.getAttribute("value");
   	    SalidasRegularizacionesSobranteStringChequeOtrosBancos = SalidasRegularizacionesSobranteStringChequeOtrosBancos.replace("." , "").replace("," , ".");
   	 	double SalidasRegularizacionesSobranteDoubleChequeOtrosBancos = Double.parseDouble(SalidasRegularizacionesSobranteStringChequeOtrosBancos);
     	System.out.println(SalidasRegularizacionesSobranteDoubleChequeOtrosBancos);
     	Assert.assertEquals(SalidasRegularizacionesSobranteDoubleChequeOtrosBancos, (SalidasRegularizacionesSobranteDouble + 100), 0.000001);

        File archivo7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(archivo7, new File(captura6));  
                
        Thread.sleep(secDelay);	
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
	    Thread.sleep(2000); 
	    if (ffmpegProcess != null) {
	        ffmpegProcess.destroy();
	        ffmpegProcess.waitFor();
	    }
	}
}