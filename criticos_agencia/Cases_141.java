package criticos_agencia;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import org.junit.After;
import Constantes.Constantes;


public class Cases_141 {

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
		
//		--------------------------------------------------Imprimir Consulta Pases de Bóveda / Módulo Agencia----------------------------------------------
    
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_141\\141.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
	
		//INGRESAMOS EN EL MODULO AGENCIA----------------------------------------------------------------------------
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
				
		//CONSULTAMOS E IMPRIMIMOS LOS PASES ATM QUE HAY EN EL SISTEMA------------------------------------------------
				
		WebElement IngresarEnCaja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
		IngresarEnCaja.click();
		WebElement IngresarPasesDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
		IngresarPasesDeBoveda.click();			
		WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
		DesplegarDivisa.click();			
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();		
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		Consultar.click();	   Thread.sleep(secDelay);		
		WebElement Imprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir.click();
		WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato.click();	  Thread.sleep(secDelay);		
		WebElement FormatoPDF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		FormatoPDF.click();
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnInnerEl")));
		Aceptar.click();	 Thread.sleep(secDelay);
		WebElement Imprimir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir2.click();
		WebElement DesplegarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato2.click();	   Thread.sleep(secDelay);
		WebElement FormatoXLSX = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
		FormatoXLSX.click();
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1062-btnInnerEl")));
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


