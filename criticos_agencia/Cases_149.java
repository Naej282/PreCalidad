package criticos_agencia;

import java.io.IOException;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constantes.Constantes;

public class Cases_149 {

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
		
//		-----------------------------------------------------Consulta Asiento Contables / Modulo Agencia------------------------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_149\\149.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//BLOQUE DE CODIGO PARA SELECCIONAR EL DIA ACTUAL EN EL CALENDARIO------------------------------------------------------------------------------------
		
		int DiaActual = LocalDate.now().getDayOfMonth();						
        System.out.println(DiaActual);
        String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
        System.out.println(DiaActualString);
		
		//INGRESAR EN EL MODULO CENTRAL
        
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
			
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
				
		//IMPRIMIR ASIENTOS CONTABLES
				
		WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
		CuadreDeAgencia.click();
		WebElement AsientosContables = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		AsientosContables.click();
		WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		DesplegarDivisa.click();	 Thread.sleep(secDelay);	 
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();
		WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato.click();	  Thread.sleep(secDelay);	 
		WebElement Formato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		Formato.click();	 Thread.sleep(secDelay);	
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
		Aceptar.click();   
		WebElement AsientosContables2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		AsientosContables2.click();		
		WebElement DesplegarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaImprimir-trigger-picker")));
		DesplegarDivisa2.click();	  Thread.sleep(secDelay);	 
		WebElement Divisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa2.click();
		WebElement DesplegarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato2.click();	   Thread.sleep(secDelay);	 
		WebElement Formato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
		Formato2.click();Thread.sleep(secDelay);	
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1012-btnEl")));
		Aceptar2.click();

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
