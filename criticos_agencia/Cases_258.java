package criticos_agencia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Comparator;
import Constantes.Constantes;


public class Cases_258 {

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
		
//		----------------------------------------- Imprimir Consulta de Remesas en Agencia / Control de Remesas / Envíos ------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_258\\258.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//INGRESAMOS EN EL MODULO DE AGENCIA----------------------------------------------------------------------
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
		
		//INGRESAMOS EN EL APARTADO DE ENVIOS-----------------------------------------------------------------------
		
		WebElement ControlRemesas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remesas")));
		ControlRemesas.click();	
		WebElement Envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Envios")));
		Envios.click();
		
		//CONSULTAMOS LAS REMESAS QUE HAY EN EL SISTEMA Y LAS IMPRIMIMOS---------------------------------------------
		
		WebElement ConsultarTodos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
		ConsultarTodos.click();		Thread.sleep(secDelay);
		WebElement SeleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1034-textEl")));
		SeleccionarRemesa.click();
		WebElement Imprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir.click();	  Thread.sleep(secDelay);
		WebElement DesplegarSeleccion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reporte-trigger-picker")));
		DesplegarSeleccion.click();	  Thread.sleep(secDelay);	
		WebElement FormatoSeleccion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Carta porte']")));
		FormatoSeleccion.click();
		WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato.click();	  Thread.sleep(secDelay);	
		WebElement FormatoEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		FormatoEnvio.click();
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1077-btnEl")));
		Aceptar.click();		
		WebElement Imprimir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir2.click();	   Thread.sleep(secDelay);
		WebElement DesplegarSeleccion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reporte-trigger-picker")));
		DesplegarSeleccion2.click();	  Thread.sleep(secDelay);	
		WebElement FormatoSeleccion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Carta porte']")));
		FormatoSeleccion2.click();
		WebElement DesplegarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato2.click();	   Thread.sleep(secDelay);	
		WebElement FormatoEnvio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
		FormatoEnvio2.click();
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1077-btnEl")));
		Aceptar2.click();	  Thread.sleep(secDelay);
			
		//REALIZAMOS LA BUSQUEDA DE LOS EMISORES------------------------------------------------------------------------
			
		WebElement RadiobuttomEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emisor-inputEl")));
		RadiobuttomEmisor.click();	
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
		Consultar.click();	   Thread.sleep(secDelay);	
		WebElement SeleccionarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1034-textEl")));
		SeleccionarRemesa2.click();
		WebElement Imprimir3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir3.click();	   Thread.sleep(secDelay);
		WebElement DesplegarSeleccion3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reporte-trigger-picker")));
		DesplegarSeleccion3.click();	  Thread.sleep(secDelay);	
		WebElement FormatoSeleccion3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Carta porte']")));
		FormatoSeleccion3.click();
		WebElement DesplegarFormato3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato3.click();	   Thread.sleep(secDelay);	
		WebElement DivisaEnvio3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		DivisaEnvio3.click();	
		WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1077-btnEl")));
		Aceptar3.click();	
		WebElement Imprimir4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir4.click();	   Thread.sleep(secDelay);
		WebElement DesplegarSeleccion4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reporte-trigger-picker")));
		DesplegarSeleccion4.click();	  Thread.sleep(secDelay);	
		WebElement FormatoSeleccion4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Carta porte']")));
		FormatoSeleccion4.click();
		WebElement DesplegarFormato4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato4.click();	   Thread.sleep(secDelay);		
		WebElement DivisaEnvio4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
		DivisaEnvio4.click();
		WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1077-btnEl")));
		Aceptar4.click();	  Thread.sleep(secDelay);
		
		//REALIZAMOS LAS BUSQUEDAS DE LOS RECEPTORES-----------------------------------------------------------------------
		
		WebElement RadiobuttomReceptor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("receptor-inputEl")));
		RadiobuttomReceptor.click();	
		WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
		Consultar2.click();		Thread.sleep(secDelay);
		WebElement SeleccionarRemesa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1034-textEl")));
		SeleccionarRemesa3.click();	
		WebElement Imprimir5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir5.click();	   Thread.sleep(secDelay);
		WebElement DesplegarSeleccion5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reporte-trigger-picker")));
		DesplegarSeleccion5.click();	  Thread.sleep(secDelay);	
		WebElement FormatoSeleccion5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Carta porte']")));
		FormatoSeleccion5.click();
		WebElement DesplegarFormato5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato5.click();	   Thread.sleep(secDelay);
		WebElement DivisaEnvio5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		DivisaEnvio5.click();
		WebElement Aceptar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1077-btnEl")));
		Aceptar5.click();	
		WebElement Imprimir6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir6.click();	   Thread.sleep(secDelay);
		WebElement DesplegarSeleccion6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reporte-trigger-picker")));
		DesplegarSeleccion6.click();	  Thread.sleep(secDelay);	
		WebElement FormatoSeleccion6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Carta porte']")));
		FormatoSeleccion6.click();
		WebElement DesplegarFormato6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato6.click();	   Thread.sleep(secDelay);	
		WebElement DivisaEnvio6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
		DivisaEnvio6.click();
		WebElement Aceptar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1077-btnEl")));
		Aceptar6.click();     Thread.sleep(secDelay);
			
        String rutaCarpetaDescargas = "C:\\Users\\jcarrasco\\Downloads";
        String rutaCarpetaDestino = "C:\\Users\\jcarrasco\\Desktop\\automaticas\\Criticos_Agencia\\Cases_258";
        File carpetaDescargas = new File(rutaCarpetaDescargas);
        File[] archivos = carpetaDescargas.listFiles();
	    
        if (archivos != null && archivos.length > 0) {
  
            Arrays.sort(archivos, new Comparator<File>() {
                @Override
                public int compare(File file1, File file2) {
                    return Long.compare(file1.lastModified(), file2.lastModified());
                }
            });

	        
        int startIndex = Math.max(0, archivos.length - 6); 
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
