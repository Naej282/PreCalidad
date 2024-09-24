package criticos_agencia;

import java.io.IOException;
import java.time.LocalDate;
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
import Constantes.Constantes;

public class Cases_146 {

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
		
//		---------------------------------------------------- Abrir día. Cierre de Agencia / Módulo Agencia------------------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
			String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_146\\146.avi";
			String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
			ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//BLOQUE DE CODIGO PARA SELECCIONAR EL DIA ACTUAL EN EL CALENDARIO--------------------------------------------------------
		
			int DiaActual = LocalDate.now().getDayOfMonth();				
	        System.out.println(DiaActual);
	        String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
	        System.out.println(DiaActualString);
		
		//INGRESAMOS EN EL MODULO DE AGENCIA--------------------------------------------------------------------------------------
        
			WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
			WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
			login.sendKeys(Constantes.USUARIO);
			WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
			WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
			logear.click();		Thread.sleep(secDelay);
				
		//INGRESAMOS EN EL CIERRE DE UNIDADES--------------------------------------------------------------------------------------
				
			WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
			CuadreDeAgencia.click();
			WebElement CierreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cierre")));
			CierreDeAgencia.click();
					
		//PROCEDEMOS A ABRIR EL DIA CERRADO EN EL CASES ANTERIOR-------------------------------------------------------------------- 
					
			WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
			DesplegarDivisa.click();
			WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Constantes.DIVISA+"']")));
			Divisa.click();		Thread.sleep(secDelay);
			WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen60")));
			Consultar.click();
			WebElement seleccionarDía2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable dia-cerrado'][text()='"+  DiaActualString +"']")));
	        seleccionarDía2.click();	 Thread.sleep(secDelay);
		    WebElement Abrir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionAbrir")));
			Abrir.click();	   Thread.sleep(secDelay);
			
			WebElement Mensaje = driver.findElement(By.cssSelector(".ext-mb-text"));
	        String ObtenerMensaje = Mensaje.getText().trim();
	        System.out.println(ObtenerMensaje);
	        String ExpectativaTexto = "Apertura realizada exitosamente";
	        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
			
			WebElement AceptarAbrir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1064")));
			AceptarAbrir.click();
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
