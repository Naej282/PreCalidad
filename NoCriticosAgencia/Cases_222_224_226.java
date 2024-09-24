package NoCriticosAgencia;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constantes.*;
import DataDrivenTesting.ReadExcelFile;
public class Cases_222_224_226 {
	int secDelay = 1000;
	private WebDriver driver;
	private ReadExcelFile readFile;
	private Process ffmpegProcess;
	
	@Before
	public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(Constantes.URL_AGENCIA);
	readFile = new ReadExcelFile();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		
		//-------------CREAR ARQUEO DE ATM, CONSULTA DE ARQUEO DE ATM,IMPRIMIR CONSULTA DE ARQUEO DE ATM--------//

		LocalDate fechaActual = LocalDate.now();
		LocalTime horaActual = LocalTime.now();
		
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaFormateada = fechaActual.format(formatoFecha);
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH-mm-ss");
		String horaFormateada = horaActual.format(formatoHora);
		
		String nombreArchivo = fechaFormateada.replace("/", "-") + "_" + horaFormateada + ".avi";
		System.out.println("Fecha y Hora (formato dd/MM/yyyy/HH/mm/ss): " + nombreArchivo);
		
		//------------------------------Iniciar grabación de pantalla usando ffmpeg-----------------------------//
		
	    String outputFile = ""+Constantes.RUTA_CAPTURES+"\\NoCriticosAgencia\\Case_222_224_226\\"+nombreArchivo+"";
	    String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 "
	    									+ "-video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" "
	    									+ "-offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
	    ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
	//--------------------------------------------------EXCEL-----------------------------------------------//
		
		String filepath = ""+Constantes.RUTA_EXCELE+"\\CasesIntegrales.xlsx";	
		String ATM = readFile.getCellValue(filepath, "No_Criticos_Agencia", 2, 2);
		
		
		
		String directorioCapturas = ""+Constantes.RUTA_CAPTURES+"\\NoCriticosAgencia\\Case_222_224_226";
	    String nombreArchivo1 = "222.png";
	    String captura = directorioCapturas + "/" + nombreArchivo1;
	    String nombreArchivo2 = "224.png";
	    String captura1 = directorioCapturas + "/" + nombreArchivo2;
		
	//---------------------------------------INGRESAMOS EN AGENCIA.-------------------------------------//
	    
	    WebDriverWait ewait = new WebDriverWait(driver,10);
	    
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);			
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
			
	//---------------------------------------ENTRAMOS A DIFERENCIAS.------------------------------------//
		
		WebElement ATM1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
	    ATM1.click();	Thread.sleep(secDelay);    	    
		WebElement ArqueoATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("arqueo")));
		ArqueoATM.click();		Thread.sleep(secDelay);
		
	//------------------------------------------CREAR AARQUEOP ATM.-------------------------------------//
		
		WebElement CrearATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		CrearATM.click();		Thread.sleep(secDelay);			
		WebElement DesplegarATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmCrear-trigger-picker")));
		DesplegarATM.click();		Thread.sleep(secDelay);			
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options) {
	      if (option.getText().equals(ATM)) {
	          option.click();
	          break;	            
	          }
	    }		Thread.sleep(secDelay);										
		WebElement DesplegarDivisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
		DesplegarDivisas.click();	Thread.sleep(secDelay);
		List<WebElement> options1 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options1) {
	      if (option.getText().equals(""+Constantes.DIVISA+"")) {
	          option.click();
	          break;	            
	          }
	    }		Thread.sleep(secDelay);									
		WebElement SecuenciaInicialCinta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("secuenciaInicialCintaCrear-inputEl")));
		SecuenciaInicialCinta.sendKeys("1");							
		WebElement SecuanciaFinalCinta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("secuenciaFinalCintaCrear-inputEl")));
		SecuanciaFinalCinta.sendKeys("2");											
		WebElement RetiroCintaAuditoria = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retiroCintaCrear-inputEl")));
		RetiroCintaAuditoria.click();										
		WebElement AgregoDeInsumos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agregoInsumosCrear-inputEl")));
		AgregoDeInsumos.click();										
		WebElement PruebaDeDispositivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pruebaDispositivosCrear-inputEl")));
		PruebaDeDispositivo.click();									
		WebElement RetiroDeBilletesRechazados = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retiroBilletesRechazadosCrear-inputEl")));
		RetiroDeBilletesRechazados.click();									
			
	//-----------------------------------------------DISPENSADO.----------------------------------------//
		
		WebElement DesplegarClasificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionDispensado-trigger-picker")));
		DesplegarClasificación.click();		Thread.sleep(secDelay);
		List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options2) {
	      if (option.getText().equals("Aptos")) {
	          option.click();
	          break;	            
	          }
	    }		Thread.sleep(secDelay);
		WebElement DesplegarDenominación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionDispensado-trigger-picker")));
		DesplegarDenominación.click();		Thread.sleep(secDelay);								
		List<WebElement> options3 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options3) {
	      if (option.getText().equals(""+Constantes.DENOMINACION+"")) {
	          option.click();
	          break;	            
	          }
	    }		Thread.sleep(secDelay);
		WebElement Cantidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadDetalleDispensado-inputEl")));
		Cantidad.sendKeys("5");
		WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirDetallesDispensado")));
		Incluir.click();									
			
	//------------------------------------------------REMANETE--------------------------------------//
		
		WebElement DesplegarClasifición1 = driver.findElement(By.id("clasificacionRemanente-trigger-picker"));
	    DesplegarClasifición1.click();		Thread.sleep(secDelay);
	    
	 //------------------------------Espera a que las opciones sean visibles-----------------------//
	    
	    List<WebElement> options4 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    
	 //---------------Itera sobre las opciones y selecciona la que coincida con el texto------------//
	    
	    for (WebElement option : options4) {
	      if (option.getText().equals("Aptos")) {
	          option.click();
	          break;
	          }
	    }		Thread.sleep(secDelay);
	    WebElement Denominación1 = driver.findElement(By.id("denominacionRemanente-trigger-picker"));
	    Denominación1.click();		Thread.sleep(secDelay);
	    List<WebElement> options5 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options5) {
	      if (option.getText().equals(""+Constantes.DENOMINACION+"")) {
	          option.click();
	          break;	            
	          }
	    }		Thread.sleep(secDelay);
		WebElement Cantidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadDetalleRemanente-inputEl")));
		Cantidad1.sendKeys("5");																			
		WebElement Incluir1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirDetallesRemanente")));
		Incluir1.click();
			
	//-----------------------------------------------AÑADIDO----------------------------------------//
		
		WebElement DesplegarClasificación2 = driver.findElement(By.id("clasificacionANadido-trigger-picker"));
	    DesplegarClasificación2.click();	Thread.sleep(secDelay);
	    List<WebElement> options6 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options6) {
	      if (option.getText().equals("Aptos")) {
	          option.click();
	          break;
	          }
	    }		Thread.sleep(secDelay);		
	    WebElement Denominación2 = driver.findElement(By.id("denominacionANadido-trigger-picker"));
	    Denominación2.click();		Thread.sleep(secDelay);	        
	    List<WebElement> options7 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options7) {
	      if (option.getText().equals(""+Constantes.DENOMINACION+"")) {
	    	  option.click();
	          break;	            
	          }
	    }		Thread.sleep(secDelay);
		WebElement Cantidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadDetalleANadido-inputEl")));
		Cantidad2.sendKeys("30");										
		WebElement Incluir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirDetallesANadido")));
		Incluir2.click();	
		WebElement Observaciones = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("observacionesCrear-inputEl")));
		Observaciones.sendKeys("Ninguna");		Thread.sleep(secDelay);
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1118")));
		Aceptar.click();	Thread.sleep(secDelay);		
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1051")));
		Aceptar2.click();
		WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1051")));
		Aceptar3.click();		Thread.sleep(secDelay);Thread.sleep(secDelay);
		
			File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(archivo, new File(captura));		Thread.sleep(secDelay);

		WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1050")));
		Aceptar4.click();
			
	//----------------------------------------------224 CONSULTAR ATM.-----------------------------------//
		
		WebElement Divisa = driver.findElement(By.id("divisasArqueo-inputWrap"));
	    Divisa.click();		Thread.sleep(secDelay);	        
	    List<WebElement> options8 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options8) {
	      if (option.getText().equals(""+Constantes.DIVISA+"")) {
	    	  option.click();
	          break;	            
	      	  }
	    }		Thread.sleep(secDelay);
		WebElement ATM3 = driver.findElement(By.id("atmArqueo-inputWrap"));
	     ATM3.click();		Thread.sleep(secDelay);
	    List<WebElement> options9 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));	        
	    for (WebElement option : options9) {
	      if (option.getText().equals(ATM)) {
	    	  option.click();
	          break;	            
	          }
	    }		Thread.sleep(secDelay);
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
		Consultar.click();		Thread.sleep(secDelay);
		
			File archivo1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(archivo1, new File(captura1));		Thread.sleep(secDelay);
			
	//----------------------------------------226 IMPRIMIR SONCULTA DE ARQUEO ATM.-------------------------//
		
		WebElement Imprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir.click();		Thread.sleep(secDelay);		
		WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato.click();		Thread.sleep(secDelay);		
		WebElement Formato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		Formato.click();									
		WebElement Aceptar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1154")));
		Aceptar6.click();													
		WebElement Imprimir1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir1.click();		Thread.sleep(secDelay);		
		WebElement DesplegarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato2.click(); Thread.sleep(secDelay);		
		WebElement Formato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
		Formato2.click();										
		WebElement Aceptar7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1154")));
		Aceptar7.click();	Thread.sleep(secDelay);
		}	
	
		@After
		public void tearDown() throws Exception {
			
		//----------------------------------------------Cerrar el navegador--------------------------------------//
			
		Thread.sleep(3000);
		if (driver != null) {
		    driver.quit();
		}
		//-------------------------Asegúrate de que todas las tareas pendientes han finalizado-------------------//
		
		//---------------------------------Espera de 1 segundo (puedes ajustar este valor)-----------------------//
		
		Thread.sleep(2000);
		
		//-----------------------------------------Detener la grabación de pantalla------------------------------//
		
		if (ffmpegProcess != null) {
		    ffmpegProcess.destroy();
		    ffmpegProcess.waitFor();
		    
		 //-----------------------------Esperar a que el proceso FFmpeg se detenga completamente------------------//
		    
		    }
	 	}
	}