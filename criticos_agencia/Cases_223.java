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
import DataDrivenTesting.ReadExcelFile;

public class Cases_223 {

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
		
//		---------------------------------------Consultar Pases de ATM en Agencia / ATM / Pases de ATM--------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_223\\223.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//RUTA DEL EXCEL------------------------------------------------------------------------------------------------------
		
		String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
	    String ATM = readFile.getCellValue(filepath, "CriticosAgencia", 12, 2);
		
		//BLOQUE DE CODIGO PARA SELECCIONAR EL DIA ACTUAL EN EL CALENDARIO----------------------------------------------------
		
		int DiaActual = LocalDate.now().getDayOfMonth();					
        System.out.println(DiaActual);
        String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
        System.out.println(DiaActualString);
        
	 	WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
	
	 	//INGRESAMOS EN EL MODULO AGENCIA-------------------------------------------------------------------------------------
	 	
		WebElement login2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login2.sendKeys(Constantes.USUARIO);
		WebElement password2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password2.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear2.click();	 Thread.sleep(secDelay);
			
		//CONSULTAMOS LOS PASES ATM--------------------------------------------------------------------------------------------
		
		WebElement IngresarAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
		IngresarAtm.click();
		WebElement IngresarPasesDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
		IngresarPasesDeBoveda.click();	   Thread.sleep(secDelay);	
		WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
		DesplegarDivisa.click();	 Thread.sleep(secDelay);
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();
		WebElement DesplegarATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmPases-trigger-picker")));
		DesplegarATM.click();	  Thread.sleep(secDelay);
		WebElement ATM1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ATM+"']")));
		ATM1.click();
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		Consultar.click();		
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
