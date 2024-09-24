package criticos_agencia;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.junit.After;
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
import Constantes.Constantes;
import DataDrivenTesting.ReadExcelFile;

public class Cases_230_235 {

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
		
//		------------------- Consultar Efectivo ATM en AGENCIA /ATM / Efectivo ATM--------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_230_235\\230_235.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//BLOQUE DE CODIGO PARA SELECCIONAR EL DIA ACTUAL EN EL CALENDARIO----------------------------------------------------
		
		int DiaActual = LocalDate.now().getDayOfMonth();						
        System.out.println(DiaActual);
        String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
        System.out.println(DiaActualString);
        
        //RUTA DEL EXCEL------------------------------------------------------------------------------------------------------
		
  		String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
  	    String ATM = readFile.getCellValue(filepath, "CriticosAgencia", 14, 2);
        
	 	WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
	
	 	//INGRESAMOS EN EL MODULO AGENCIA-------------------------------------------------------------------------------------
		
	 	WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
		
		//INGRESAMOS EN EFECTIVO ATM------------------------------------------------------------------------------------------
			
		WebElement IngresarAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
		IngresarAtm.click();
		WebElement EfectivoAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efectivo")));
		EfectivoAtm.click();	 Thread.sleep(secDelay);
			
		WebElement DesplegarAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmEfectivo-trigger-picker")));
		DesplegarAtm.click();	  Thread.sleep(secDelay);
		WebElement Atm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ATM+"']")));
		Atm.click();
		WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		DesplegarDivisa.click();	 Thread.sleep(secDelay);
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();	
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
		Consultar.click();	   Thread.sleep(secDelay);
	
		// CASES 235 ---------------------------------------- Imprimir Consulta de Efectivo ATM en AGENCIA /ATM / Efectivo ATM--------------------------------------------
			
		WebElement Imprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir.click();
		WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato.click();	  Thread.sleep(secDelay);
		WebElement Formato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		Formato.click();
		WebElement AceptarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1030-btnWrap")));
		AceptarFormato.click();		Thread.sleep(secDelay);
		WebElement Imprimir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir2.click();	
		WebElement DesplegarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato2.click();	   Thread.sleep(secDelay);
		WebElement Formato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
		Formato2.click();	  Thread.sleep(secDelay);
		WebElement AceptarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1030-btnWrap")));
		AceptarFormato2.click();	 Thread.sleep(secDelay);
			
		//RUTA DE DESCARGAS------------------------------------------------------------------------------------------------------------------
		
        String rutaCarpetaDescargas = "C:\\Users\\jcarrasco\\Downloads";
        String rutaCarpetaDestino = "C:\\Users\\jcarrasco\\Desktop\\automaticas\\Criticos_Agencia\\Cases_230";
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
