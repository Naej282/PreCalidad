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
import java.util.Comparator;
import java.util.List;

import Constantes.Constantes;

public class Cases_239 {
	
	int secDelay = 1000;

	private WebDriver driver;
	private Process ffmpegProcess;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constantes.URL_AGENCIA);
	}

	@Test
	public void test() throws InterruptedException, IOException {
		
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
//		----------------------------------- Consultas y Reportes - Auxiliar de Movimiento en AGENCIA / Cuadre de Agencia / Consultas--------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_239\\239.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//INGRESAMOS EN EL MODULO AGENCIA----------------------------------------------------------------------------
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
		
		//IMPRIMIMOS EL REPORTE DE AUXILIAR DE MOVIMIENTO------------------------------------------------------------- 
		
		WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
		CuadreDeAgencia.click();
		WebElement Consultas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("consultas")));
		Consultas.click();	   Thread.sleep(secDelay);
		WebElement DesplegarReportes = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reporteReportConsult-trigger-picker")));
		DesplegarReportes.click();	   Thread.sleep(secDelay);
		WebElement Reportes = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Auxiliar de Movimiento']")));
		Reportes.click();
		WebElement DesplegarDivisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaReportConsult-trigger-picker")));
		DesplegarDivisas.click();	  Thread.sleep(secDelay);
		WebElement Divisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisas.click();
		WebElement DesplegarVariantes = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("campo1ReportConsult-inputEl")));
		DesplegarVariantes.click();	  Thread.sleep(secDelay);
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options) {
            if (option.getText().equals("Dólar")) {
                option.click();
                break;
                }
            }	
			
		WebElement Imprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir.click();		
		WebElement PDF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar-btnEl")));
		PDF.click();	 Thread.sleep(secDelay);
		WebElement Imprimir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir2.click();
		WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoReportConsult-trigger-picker")));
		DesplegarFormato.click();     Thread.sleep(secDelay);
		WebElement Formato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
		Formato.click();	 Thread.sleep(secDelay);
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar-btnEl")));
		Aceptar.click();	
			
		//COLOCAMOS LA RUTA DE DESCARGAS-----------------------------------------------------------------------------
        String rutaCarpetaDescargas = "C:\\Users\\jcarrasco\\Downloads";
        String rutaCarpetaDestino = "C:\\Users\\jcarrasco\\Desktop\\automaticas\\Criticos_Agencia\\Cases_239";
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
