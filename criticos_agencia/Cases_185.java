package criticos_agencia;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
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
import Constantes.Constantes;

public class Cases_185 {

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
		
//		-------------------------------------- Reclasificación de Inventario entre Bóvedas / Módulo Agencia--------------------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_185\\185.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//BLOQUE DE CODIGO PARA SELECCIONAR EL DIA ACTUAL EN EL CALENDARIO-----------------------------------------------------------
		
		int DiaActual = LocalDate.now().getDayOfMonth();					
        System.out.println(DiaActual);
        String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
        System.out.println(DiaActualString);
		        
        //TOMA DE EVIDENCIAS--------------------------------------------------------------------------------------------------------
		
        String directorioCapturas = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_185";
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
	 	String nombreArchivo3 = "3.png";
	 	String captura3 = directorioCapturas + "/" + nombreArchivo3;
	 	String nombreArchivo4 = "4.png";
	 	String captura4 = directorioCapturas + "/" + nombreArchivo4;
		
		//INGRESAMOS EN EL MODULO DE AGENCIA-------------------------------------------------------------------------------------------
        
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
	
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
				
		//Ingresar en el apartado cuadre de agencia
				
		WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
		CuadreDeAgencia.click();
		WebElement inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
		inventario.click();		Thread.sleep(secDelay);
		WebElement DesplegarTipoDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
		DesplegarTipoDeBoveda.click();	   Thread.sleep(secDelay);
		WebElement TipoDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.BOVEDA+"']")));
		TipoDeBoveda.click();
	    WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
    	DesplegarDivisa.click();	 Thread.sleep(secDelay);
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		Consultar.click();	   Thread.sleep(secDelay);	
		WebElement DesplegarConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
  	    DesplegarConsulta.click();
					
        File archivo1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo1, new File(captura1));	Thread.sleep(secDelay);
		        
        WebElement DesplegarTipoDeBoveda2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
		DesplegarTipoDeBoveda2.click();		Thread.sleep(secDelay);
		WebElement TipoDeBoveda2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.BOVEDA2+"']")));
		TipoDeBoveda2.click();
		WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		Consultar2.click();		Thread.sleep(secDelay);
		        
        File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));	Thread.sleep(secDelay);
		        
        WebElement OpcionReclasificarEntreBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionReclasificarDifBovedas")));
    	OpcionReclasificarEntreBoveda.click();    	
    	
    	WebElement DesplegarTipoBovedaOrigen = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoBovedaOrigenDifBovedas-inputEl")));
    	DesplegarTipoBovedaOrigen.click();     Thread.sleep(secDelay);
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options) {
            if (option.getText().equals(Constantes.BOVEDA)) {
                option.click();
                break;        
                }
            }
		WebElement TipoBovedaDestino = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoBovedaDestinoDifBovedas-inputEl")));
		TipoBovedaDestino.click();	   Thread.sleep(secDelay);
        List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options2) {
            if (option.getText().equals(Constantes.BOVEDA2)) {
                option.click();
                break;
                }
            }
		WebElement DesplegarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaDifBovedas-inputEl")));
		DesplegarDivisa2.click();	  Thread.sleep(secDelay);
        List<WebElement> options3 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options3) {
            if (option.getText().equals("Dólar")) {
                option.click();
                break;
                }
            }		
    	WebElement InputTipoClaficacionActual = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoClasificacionAnteriorDifBovedas-inputEl")));
    	InputTipoClaficacionActual.click();		Thread.sleep(secDelay);
        List<WebElement> options4 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options4) {
            if (option.getText().equals(Constantes.APTOS)) {
                option.click();
                break;
                }
            }  		
		WebElement DesplegarDenominaciones = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionDifBovedas-trigger-picker")));
		DesplegarDenominaciones.click();	 Thread.sleep(secDelay);
		WebElement Denominaciones = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DENOMINACION+"']")));
		Denominaciones.click();
		
		WebElement DesplegarTipoDeClasificacionNueva = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoClasificacionNuevaDifBovedas-inputEl")));
		DesplegarTipoDeClasificacionNueva.click();
        List<WebElement> options5 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options5) {
            if (option.getText().equals("No Aptos")) {
                option.click();
                break;
                }
            }			
		WebElement DesplegarCantidadReclasificar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadNewDifBovedas-inputEl")));
		DesplegarCantidadReclasificar.click();
		DesplegarCantidadReclasificar.sendKeys("1");
		WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1072-btnWrap")));
		Incluir.click();
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1117-btnEl")));
		Aceptar2.click();	  Thread.sleep(secDelay);
		
		WebElement Mensaje = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje = Mensaje.getText().trim();
        System.out.println(ObtenerMensaje);
        String ExpectativaTexto = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
		
		WebElement AceptarMensaje = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarMensaje.click();		Thread.sleep(secDelay);
			         
        File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo3, new File(captura3));
		        
        WebElement DesplegarTipoDeBoveda3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
		DesplegarTipoDeBoveda3.click();		Thread.sleep(secDelay);
		WebElement TipoDeBoveda3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.BOVEDA+"']")));
		TipoDeBoveda3.click();		
		WebElement Consultar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		Consultar3.click();		
        WebElement Clasificacion2 = driver.findElement(By.id("gridcolumn-1012-textEl")); 
        Clasificacion2.click();		Thread.sleep(secDelay);
				
		File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo4, new File(captura4));				
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
