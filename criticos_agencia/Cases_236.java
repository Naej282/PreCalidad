package criticos_agencia;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Random;
import Constantes.Constantes;
import DataDrivenTesting.ReadExcelFile;

public class Cases_236 {

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
		
//		------------------------------------Consultas y Reportes - Arqueo Consolidado de ATM en AGENCIA / Cuadre de Agencia / Consultas--------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_236\\236.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//GENERAR UN NUMERO ALEATORIO----------------------------------------------------------------------------------------
		
		Random random = new Random();
		int GenerarNumeroAleatorio = random.nextInt(15001 - 8000) + 8000;		
		String NumeroAleatorio = String.valueOf(GenerarNumeroAleatorio);
		
		//BLOQUE DE CODIGO PARA SELECCIONAR EL DIA ACTUAL EN EL CALENDARIO----------------------------------------------------
		
		int DiaActual = LocalDate.now().getDayOfMonth();						
	    System.out.println(DiaActual);
	    String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
	    System.out.println(DiaActualString);
	    
	    //RUTA DEL EXCEL------------------------------------------------------------------------------------------------------
		
  		String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
  	    String ATM = readFile.getCellValue(filepath, "CriticosAgencia", 15, 2);
        
	 	WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
	
	 	//INGRESAMOS EN EL MODULO AGENCIA-------------------------------------------------------------------------------------
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
		
		//INGRESAMOS EN EL MODULO DE ARQUEO ATM
		
		WebElement IngresarAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
		IngresarAtm.click();
		WebElement Arqueo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("arqueo")));
		Arqueo.click();		Thread.sleep(secDelay);
		
		//CREAMOS UN ARQUEO
		
		WebElement CrearArqueo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		CrearArqueo.click();	 Thread.sleep(secDelay);
		WebElement DesplegarAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmCrear-trigger-picker")));
		DesplegarAtm.click();
		WebElement Atm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ATM+"']")));
		Atm.click();
		WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
		DesplegarDivisa.click();	 Thread.sleep(secDelay);
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();		
		WebElement SecuenciaInicial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("secuenciaInicialCintaCrear-inputEl")));
		SecuenciaInicial.click();	  Thread.sleep(secDelay);
		SecuenciaInicial.sendKeys(NumeroAleatorio);
		WebElement SecuenciaFinal = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("secuenciaFinalCintaCrear-inputEl")));
		SecuenciaFinal.click();		Thread.sleep(secDelay);
		SecuenciaFinal.sendKeys(NumeroAleatorio);
		WebElement DesplegarClasificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionANadido-trigger-picker")));
		DesplegarClasificacion.click();		Thread.sleep(secDelay);	
		WebElement Clasificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.APTOS+"']")));
		Clasificacion.click();	
		WebElement DesplegarDenominacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionANadido-trigger-picker")));
		DesplegarDenominacion.click();	   Thread.sleep(secDelay);	
		WebElement Denominacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DENOMINACION+"']")));
		Denominacion.click();		
		WebElement Cantidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadDetalleANadido-inputEl")));
		Cantidad.click();
		Thread.sleep(secDelay);
		Cantidad.sendKeys("1");
		WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirDetallesANadido")));
		Incluir.click();
		WebElement Observacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("observacionesCrear-inputEl")));
		Observacion.click();
		Thread.sleep(secDelay);
		Observacion.sendKeys("Prueba Automatica");
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1118-btnWrap")));
		Aceptar.click();
		WebElement Confirmacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1051-btnEl")));
		Confirmacion.click();
		WebElement Confirmacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1051-btnWrap")));
		Confirmacion2.click();	   Thread.sleep(secDelay);
			
		WebElement Mensaje = driver.findElement(By.id("messagebox-1046-msg"));
        String ObtenerMensaje = Mensaje.getText().trim();
        System.out.println(ObtenerMensaje);
        String ExpectativaTexto = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);	
			
		WebElement Informacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1050-btnWrap")));
		Informacion.click();	 Thread.sleep(secDelay);
		WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio.click();
		WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
		CuadreDeAgencia.click();	 Thread.sleep(secDelay);
		WebElement Consultas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("consultas")));
		Consultas.click();	   Thread.sleep(secDelay);
		WebElement DesplegarReportes = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reporteReportConsult-trigger-picker")));
		DesplegarReportes.click();	   Thread.sleep(secDelay);	
		WebElement Reportes = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Arqueo Consolidado de ATM']")));
		Reportes.click();
		WebElement DesplegarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaReportConsult-trigger-picker")));
		DesplegarDivisa2.click(); 	  Thread.sleep(secDelay);	
		WebElement Divisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa2.click();	 Thread.sleep(secDelay);	
		WebElement Imprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir.click(); 	  Thread.sleep(secDelay);	
		WebElement AceptarPDF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar-btnWrap")));
		AceptarPDF.click();		Thread.sleep(secDelay);
		WebElement Imprimir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir2.click();
		WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoReportConsult-trigger-picker")));
		DesplegarFormato.click();	  Thread.sleep(secDelay);
		WebElement Formato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
		Formato.click();	 Thread.sleep(secDelay);
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar-btnWrap")));
		Aceptar2.click();	  Thread.sleep(secDelay);
			
	    String rutaCarpetaDescargas = "C:\\Users\\jcarrasco\\Downloads";
	    String rutaCarpetaDestino = "C:\\Users\\jcarrasco\\Desktop\\automaticas\\Criticos_Agencia\\Cases_236";
        File carpetaDescargas = new File(rutaCarpetaDescargas);
        File[] archivos = carpetaDescargas.listFiles();
        if (archivos != null && archivos.length > 0) {
            Arrays.sort(archivos, new Comparator<File>() {
                @Override
                public int compare(File file1, File file2) {
                    return Long.compare(file1.lastModified(), file2.lastModified());
                }
            }); 
            int startIndex = Math.max(0, archivos.length - 2); 
            for (int i = startIndex; i < archivos.length; i++) {
                File archivo = archivos[i];
                try {
                    Files.move(archivo.toPath(), new File(rutaCarpetaDestino, archivo.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Se movió el archivo '" + archivo.getName() + "' a la carpeta destino.");
                } catch (Exception e) {
                    System.out.println("Error al mover el archivo '" + archivo.getName() + "': " + e.getMessage());
                }
            }
        } else {
            System.out.println("No hay archivos en la carpeta de descargas.");
        }	
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
