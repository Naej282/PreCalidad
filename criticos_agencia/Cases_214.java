package criticos_agencia;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import Constantes.Constantes;
import DataDrivenTesting.ReadExcelFile;

public class Cases_214 {

	int secDelay = 1000;

	private WebDriver driver;
	private ReadExcelFile readFile;
	private Process ffmpegProcess;
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		readFile = new ReadExcelFile();
		
		driver.get(Constantes.URL_AGENCIA);
	}

	@Test
	public void test() throws InterruptedException, IOException {
		
//		------------------------------------------Crear Pase ATM / PASE ATM A BOVEDA NORMAL en Agencia / ATM / Pases ATM----------------------------------------------------
		
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_214\\214.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//RUTA DEL EXCEL------------------------------------------------------------------------------------------------------
		
		String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
	    String CAJA = readFile.getCellValue(filepath, "CriticosAgencia", 9, 2);
	
		//INGRESAMOS EN EL MODULO DE AGENCIA----------------------------------------------------------------------------
        
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();	    Thread.sleep(secDelay);
		
		//INGRESAR EN LA PANTALLA DE ATM---------------------------------------------------------------------------------
		
		WebElement IngresarAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
		IngresarAtm.click();
		WebElement IngresarPasesDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
		IngresarPasesDeBoveda.click();	   Thread.sleep(secDelay);
		
		//CREAR PASE ATM--------------------------------------------------------------------------------------------------
		
		WebElement OpcionCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		OpcionCrear.click();	
		WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
		DesplegarDivisa.click();	 Thread.sleep(secDelay);
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();	
		WebElement DesplegarAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmCP-trigger-picker")));
		DesplegarAtm.click();	  Thread.sleep(secDelay);
		WebElement Atm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+CAJA+"']")));
		Atm.click();
		WebElement DesplegarTipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
		DesplegarTipoPase.click();	   Thread.sleep(secDelay);
		WebElement TipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase Atm a Boveda Normal']")));
		TipoPase.click();	  Thread.sleep(secDelay);		
		WebElement elementoCantidad100 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1037']")); 
        Actions doble = new Actions(driver);
        doble.doubleClick(elementoCantidad100).perform();	Thread.sleep(secDelay);
	        
        List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
        for (WebElement elemento : elementos) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                Thread.sleep(secDelay);
                actions.click(elemento).sendKeys("1").sendKeys(Keys.ENTER).perform();
              
            }
        }
	        
        WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1054-btnInnerEl")));
    	Aceptar.click();	 Thread.sleep(secDelay);
    	
    	WebElement Mensaje = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje = Mensaje.getText().trim();
        System.out.println(ObtenerMensaje);
        String ExpectativaTexto = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
    	
		WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	 	ConfirmarAceptar.click();
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
