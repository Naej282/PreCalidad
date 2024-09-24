package criticos_agencia;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constantes.Constantes;
import DataDrivenTesting.ReadExcelFile;

import java.io.IOException;
import java.util.List;

public class Cases_139 {

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
		driver.get(Constantes.URL_CENTRAL);
		
	}
	

	@Test
	public void test() throws InterruptedException, IOException {
		
//		----------------------------------- Crear Pase Atm / PASE BOVEDA A ATM NORMAL en AGENCIA/ATM/Pases ATM------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_139\\139.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//RUTA EXCEL--------------------------------------------------------------------------------------
		
		String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
	    String ATM = readFile.getCellValue(filepath, "CriticosAgencia", 3, 2);
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		//INGRESAMOS EN EL MODULO CENTRAL------------------------------------------------------------------
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
		
		//CAMBIANDO PARAMETRO WF----------------------------------------------------------------------------
		
		WebElement Configuracion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
    	Configuracion.click();	
	    WebElement Generales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("generales")));
        Generales.click();
	    WebElement ParametrosGenerales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("parametroGeneral")));
        ParametrosGenerales.click();     
	    WebElement modificables = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-1026")));
        modificables.click();	  Thread.sleep(secDelay);
     	WebElement ParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PASE_WF']")));
 		ParametroWF.click();     
		WebElement ModificarParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
		ModificarParametroWF.click();
		WebElement ValorParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    Actions doble = new Actions(driver);
	    doble.doubleClick(ValorParametroWF).perform();	
		ValorParametroWF.sendKeys("1");
		WebElement AceptarModificarParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnInnerEl")));
		AceptarModificarParametroWF.click();
		WebElement ConfirmarModificarParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnEl")));
		ConfirmarModificarParametroWF.click();	   Thread.sleep(secDelay);
		
		WebElement Mensaje = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje = Mensaje.getText().trim();
        System.out.println(ObtenerMensaje);
        String ExpectativaTexto = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
        
		WebElement AceptarMensajeParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarMensajeParametroWF.click();	
		
		//INGRESAMOS EN EL MODULO CENTRAL EN UNA NUEVA PESTAÑA--------------------------------------------------
		
        ((JavascriptExecutor)driver).executeScript("window.open()");

        String secondTab = driver.getWindowHandles().stream().skip(1).findFirst().get();
        driver.switchTo().window(secondTab);
        driver.get(Constantes.URL_AGENCIA);
        
		WebElement login2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login2.sendKeys(Constantes.USUARIO);
		WebElement password2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password2.sendKeys(Constantes.CONTRASEÑA);
		WebElement logear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear2.click();	 Thread.sleep(secDelay);
		
		//REALIZAMOS UN PASE ATM
		
		WebElement IngresarAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
		IngresarAtm.click();
		WebElement IngresarPasesDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
		IngresarPasesDeBoveda.click();
		WebElement OpcionCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		OpcionCrear.click();
		WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
		DesplegarDivisa.click();
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();
		WebElement DesplegarAtm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmCP-trigger-picker")));
		DesplegarAtm.click();
		WebElement Atm = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ATM+"']")));
		Atm.click();
		WebElement DesplegarTipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
		DesplegarTipoPase.click();
		WebElement TipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase Boveda a Atm Normal']")));
		TipoPase.click();	  Thread.sleep(secDelay);
				
		WebElement elementoCantidad2 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1037']")); 
	    Actions doble2 = new Actions(driver);
	    doble2.doubleClick(elementoCantidad2).perform();Thread.sleep(secDelay);
	        
        List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
        for (WebElement elemento : elementos) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elemento).sendKeys("1").sendKeys(Keys.ENTER).perform();
              
            }
        }
	        
        WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1054-btnInnerEl")));
    	Aceptar.click();	 Thread.sleep(secDelay);
    	
    	WebElement Mensaje2 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje2 = Mensaje2.getText().trim();
        System.out.println(ObtenerMensaje2);
        String ExpectativaTexto2 = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje2, ExpectativaTexto2);
        
		WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	 	ConfirmarAceptar.click();	  Thread.sleep(secDelay);Thread.sleep(secDelay);
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
