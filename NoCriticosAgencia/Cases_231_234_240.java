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
public class Cases_231_234_240 {
	int secDelay = 1200;
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
		
		//---CREAR DIFERERNCIAS ATM,CINSULTAR DIFERENCIAS ATM, IMPRIMIR CONSULTAS DIFERENCIAS ATM.---//
		
		LocalDate fechaActual = LocalDate.now();
		LocalTime horaActual = LocalTime.now();
		
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaFormateada = fechaActual.format(formatoFecha);
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH-mm-ss");
		String horaFormateada = horaActual.format(formatoHora);
		
		String nombreArchivo = fechaFormateada.replace("/", "-") + "_" + horaFormateada + ".avi";
		System.out.println("Fecha y Hora (formato dd/MM/yyyy/HH/mm/ss): " + nombreArchivo);
		
		//--------------------------INICIAR GRABACIÓN DE PANTALLA USANDO FFMPEG----------------------//
		
	    String outputFile = ""+Constantes.RUTA_CAPTURES+"\\NoCriticosAgencia\\Case_231_234_240\\"+nombreArchivo+"";
	    String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 "
	    									+ "-video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" "
	    									+ "-offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
	    										ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
			
		//------------------------------------------EXCEL-------------------------------------------//
			
		String filepath = ""+Constantes.RUTA_EXCELE+"\\CasesIntegrales.xlsx";	
		String ATM = readFile.getCellValue(filepath, "No_Criticos_Agencia", 1, 2);
		
		//-------------------------------------ESPERA EXPLICITA------------------------------------//
		
		WebDriverWait ewait = new WebDriverWait(driver,10);
	
		String directorioCapturas = ""+Constantes.RUTA_CAPTURES+"\\NoCriticosAgencia\\Case_231_234_240";
		String nombreArchivo1 = "231.png";
	    String captura = directorioCapturas + "/" + nombreArchivo1;
	    String nombreArchivo2 = "234.png";
	    String captura1 = directorioCapturas + "/" + nombreArchivo2;
		
		//------------------------------------INGRESAMOS EN AGENCIA---------------------------------//
	    
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);			
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
			
	    //--------------------------------------231 ENTRAMOS A ATM-----------------------------------//
		
		WebElement ATM1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
	    ATM1.click();	Thread.sleep(secDelay);    	    
		WebElement DiferenciaATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencia")));
		DiferenciaATM.click();		Thread.sleep(secDelay);
		
		//--------------------------------------CREAR DIFERENCIA ATM----------------------------------//
		
		WebElement Crear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		Crear.click();		Thread.sleep(secDelay);
		WebElement DesplegarTipoBóveda = driver.findElement(By.id("tipoBovedaDC-inputEl"));
	    DesplegarTipoBóveda.click();		Thread.sleep(secDelay);
	    List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options) {
	      if (option.getText().equals("Bóveda Disponible")) {
	          option.click();
	          break;
	          }
	    }
		WebElement DesplegarTipoDiferencia = driver.findElement(By.id("tipoDiferenciaDC-inputEl"));
	        DesplegarTipoDiferencia.click();	Thread.sleep(secDelay);
	    List<WebElement> options1 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options1) {
	      if (option.getText().equals("Faltante")) {
	          option.click();
	          break;
	          }
	     }						
		WebElement DesplegarATM = driver.findElement(By.id("atmDC-inputEl"));
	    DesplegarATM.click();		Thread.sleep(secDelay);
	    List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options2) {
	      if (option.getText().equals(""+ATM+"")) {
	          option.click();
	          break;
	         }
	     }					
		WebElement DesplegarDivisa = driver.findElement(By.id("divisaDC-inputEl"));
	    DesplegarDivisa.click();	Thread.sleep(secDelay);
	    List<WebElement> options3 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options3) {
	      if (option.getText().equals(""+Constantes.DIVISA+"")) {
	          option.click();
	          break;
	          }
	    }																					
		WebElement DesplegarClasifición = driver.findElement(By.id("clasificacionDC-inputEl"));
	    DesplegarClasifición.click();		Thread.sleep(secDelay);
	    List<WebElement> options4 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options4) {
	      if (option.getText().equals("Aptos")) {
	          option.click();
	          break;
	          }
	    }																			
		WebElement DesplegarDenominación = driver.findElement(By.id("denominacionDC-trigger-picker"));
	     DesplegarDenominación.click();		Thread.sleep(secDelay);
	    List<WebElement> options5 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options5) {
	      if (option.getText().equals("Billete - 100,000")) {
	          option.click();
	          break;
	          }
	     }								
	    WebElement Cantidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadDC-inputEl")));
		Cantidad.sendKeys("2");
	    WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1042")));
	    Incluir.click();
	    WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1047-btnEl")));
		Aceptar.click();		Thread.sleep(secDelay);Thread.sleep(secDelay);
		
			File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(archivo, new File(captura));		Thread.sleep(secDelay);
		
		WebElement Aceptar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005")));
		Aceptar1.click();		Thread.sleep(secDelay);
			
		//-----------------------------------234 CONSULTAR DIFERENCIA ATM EN AGENCIA---------------------------//
		
		WebElement DesplegarAtm = driver.findElement(By.id("codATM-inputEl"));
	    DesplegarAtm.click();		Thread.sleep(secDelay);
	    List<WebElement> options6 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options6) {
	      if (option.getText().equals(""+ATM+"")) {
	          option.click();
	          break;
	          }
	    }		Thread.sleep(secDelay);	
	    WebElement DesplegarDivisa1 = driver.findElement(By.id("divisasPases-inputEl"));
		DesplegarDivisa1.sendKeys(""+Constantes.DIVISA+"");			Thread.sleep(secDelay);			
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
		Consultar.click();		Thread.sleep(secDelay);Thread.sleep(secDelay);
		
			File archivo1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(archivo1, new File(captura1));	Thread.sleep(secDelay);
			
		WebElement TablaDiferencia = driver.findElement(By.id("gridview-1020"));
		String ObtenerTabla = TablaDiferencia.getText().trim();
			System.out.println(ObtenerTabla);
		
		//-----------------------------------------240 IMPRIMIMOS LA DIFERENCIA--------------------------------//
		
		WebElement Imprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir.click();		Thread.sleep(secDelay);
		WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato.click();		Thread.sleep(secDelay);		
		List<WebElement> options7 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options7) {
	      if (option.getText().equals("PDF")) {
	          option.click();
	          break;
	          }
	    }		Thread.sleep(secDelay);											
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1073")));
		Aceptar2.click();															
		WebElement Imprimir1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir1.click();		Thread.sleep(secDelay);		
		WebElement DesplegarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato2.click();		Thread.sleep(secDelay);		
		List<WebElement> options8 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options8) {
	      if (option.getText().equals("XLSX")) {
	          option.click();
	          break;
	          }
	    }		Thread.sleep(secDelay);															
		WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1073")));
		Aceptar3.click();		Thread.sleep(secDelay);
		}
	
	@After
	public void tearDown() throws Exception {
		
	    //--------------------------------------------Cerrar el navegador-----------------------------------//
		Thread.sleep(3000);
	    if (driver != null) {
	        driver.quit();
	    }
	    
	    //-----------------------Asegúrate de que todas las tareas pendientes han finalizado.----------------//
	    
	    //-------------------------------Espera de 1 segundo (puedes ajustar este valor).--------------------//
	    
	    Thread.sleep(2000);
	    
	    //--------------------------------------Detener la grabación de pantalla------------------------------//
	    
	    if (ffmpegProcess != null) {
	        ffmpegProcess.destroy();
	        ffmpegProcess.waitFor(); 
	        
	    //----------------------------Esperar a que el proceso FFmpeg se detenga completamente----------------//		 
	    	}
 		}
	}
