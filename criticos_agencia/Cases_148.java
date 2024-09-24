package criticos_agencia;


import java.io.IOException;
import java.time.LocalDate;
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

import java.util.List;

public class Cases_148 {

	int secDelay = 2000;

	private WebDriver driver;
	private ReadExcelFile readFile;
	private Process ffmpegProcess;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constantes.URL_CENTRAL);
		readFile = new ReadExcelFile();
		
	}

	@Test
	public void test() throws InterruptedException, IOException {
		
//		------------------------------------------------------Crear Pase de Caja en Agencia / Caja / Pases de Bóveda 2.2------------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_148\\148.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//RUTA EXCEL-----------------------------------------------------------------------------------------------------------------------------------------
		
		 String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
		 String ATM = readFile.getCellValue(filepath, "CriticosAgencia", 5, 2);
			
		//BLOQUE DE CODIGO PARA SELECCIONAR EL DIA ACTUAL EN EL CALENDARIO------------------------------------------------------------------------------------
		
		int DiaActual = LocalDate.now().getDayOfMonth();						
        System.out.println(DiaActual);
        String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
        System.out.println(DiaActualString);
		
        //INGRESAMOS EN EL MODULO CENTRAL----------------------------------------------------------------------------------------------------------------------
        
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear4.click();	 Thread.sleep(secDelay);
		
		//CAMBIAMOS EL PASE WF---------------------------------------------------------------------------------------------------------------------------------
		
		WebElement Configuracion4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
    	Configuracion4.click();
	    WebElement Generales4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("generales")));
        Generales4.click();
	    WebElement ParametrosGenerales4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("parametroGeneral")));
        ParametrosGenerales4.click();
	    WebElement modificables4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-1026")));
        modificables4.click();	   Thread.sleep(secDelay);
     	WebElement ParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PASE_WF']")));
 		ParametroWF.click();
		WebElement ModificarParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
		ModificarParametroWF.click();
		WebElement ValorParametroWF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    Actions doble3 = new Actions(driver);
	    doble3.doubleClick(ValorParametroWF).perform();	
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
		
		//INGRESAMOS EN EL MODULO DE AGENCIA-------------------------------------------------------------------------------------------------------------------
			
        ((JavascriptExecutor)driver).executeScript("window.open()");	
        String secondTab = driver.getWindowHandles().stream().skip(1).findFirst().get();
        driver.switchTo().window(secondTab);
        driver.get(Constantes.URL_AGENCIA);
		WebElement login2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login2.sendKeys(Constantes.USUARIO);		
		WebElement password2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password2.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
					
		//PROCEDEMOS A CREAR LOS PASE--------------------------------------------------------------------------------------------------------------------------
					
		WebElement IngresarEnCaja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
		IngresarEnCaja.click();			
		WebElement IngresarPasesDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
		IngresarPasesDeBoveda.click();	   Thread.sleep(secDelay);
		WebElement OpcionCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		OpcionCrear.click();
					
		//CREAMOS UN PASE DE APERTURA--------------------------------------------------------------------------------------------------------------------------
					
		WebElement DespTipoDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
		DespTipoDivisa.click();		Thread.sleep(secDelay);
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();
		WebElement DespCaja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
		DespCaja.click();	  Thread.sleep(secDelay);
		WebElement Caja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ATM+"']")));
		Caja.click();	  Thread.sleep(secDelay);
		WebElement DespModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
	    DespModalidad.click();	   
		WebElement Modalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Apertura']")));
	    Modalidad.click();
		WebElement AceptarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
	    AceptarPase.click();
		WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	    ConfirmarAceptar.click();	  Thread.sleep(secDelay);
	    
		//REALIZAMOS UN PASE DE CAJA A BOVEDA------------------------------------------------------------------------------------------------------------------
					    
		WebElement OpcionCrear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		OpcionCrear2.click();		
		WebElement DespTipoDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
		DespTipoDivisa2.click();	 Thread.sleep(secDelay);
		WebElement Divisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa2.click();
		WebElement DespCaja2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
		DespCaja2.click();	   Thread.sleep(secDelay);
		WebElement Caja2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ATM+"']")));
		Caja2.click();
		WebElement DespModalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
	    DespModalidad2.click();		Thread.sleep(secDelay);
		WebElement Modalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal']")));
	    Modalidad2.click();
		WebElement DesplegarTipoPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
		DesplegarTipoPase2.click();		Thread.sleep(secDelay);
		WebElement TipoPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase de Caja a Boveda']")));
		TipoPase2.click();	   Thread.sleep(secDelay);			
		WebElement elementoCantidad100 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); 
        Actions doble = new Actions(driver);
        doble.doubleClick(elementoCantidad100).perform();	Thread.sleep(secDelay);		        
        List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
        for (WebElement elemento : elementos) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elemento).sendKeys("1").sendKeys(Keys.ENTER).perform();
            }
        }
		WebElement AceptarPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
	    AceptarPase2.click();
		WebElement ConfirmarAceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	    ConfirmarAceptar2.click();
					
		//PASE DE BOVEDA A CAJA--------------------------------------------------------------------------------------------------------------------------------
				  
		WebElement OpcionCrear3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		OpcionCrear3.click();	
		WebElement DespTipoDivisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
		DespTipoDivisa3.click();	 Thread.sleep(secDelay);
		WebElement Divisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa3.click();	 Thread.sleep(secDelay);
		WebElement DespCaja3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
		DespCaja3.click();
		WebElement Caja3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ATM+"']")));
		Caja3.click();		
		WebElement DespModalidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
	    DespModalidad3.click();		Thread.sleep(secDelay);
		WebElement Modalidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal']")));
	    Modalidad3.click();
		WebElement DesplegarTipoPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
		DesplegarTipoPase3.click();		Thread.sleep(secDelay);
		WebElement TipoPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase de Boveda a Caja']")));
		TipoPase3.click();	   Thread.sleep(secDelay);		
		WebElement elementoCantidad101 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); 
        Actions doble2 = new Actions(driver);
        doble2.doubleClick(elementoCantidad101).perform();	Thread.sleep(secDelay);		        
        List<WebElement> elementos2 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
        for (WebElement elemento2 : elementos2) {
            if (elemento2.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elemento2).sendKeys("1").sendKeys(Keys.ENTER).perform();
            }
        }	

		WebElement AceptarPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
	    AceptarPase3.click();
		WebElement ConfirmarAceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	    ConfirmarAceptar3.click();	   Thread.sleep(secDelay);
				
		//REALIZAMOS UN PASE DE CIERRE-------------------------------------------------------------------------------------------------------------------------
				    
		WebElement OpcionCrear4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		OpcionCrear4.click();		
		WebElement DespTipoDivisa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
		DespTipoDivisa4.click();	 Thread.sleep(secDelay);
		WebElement Divisa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa4.click();	
		WebElement DespCaja4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
		DespCaja4.click();	   Thread.sleep(secDelay);
		WebElement Caja4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ATM+"']")));
		Caja4.click();
		WebElement DespModalidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
	    DespModalidad4.click();		Thread.sleep(secDelay);
		WebElement Modalidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cierre']")));
	    Modalidad4.click();
		WebElement AceptarPase4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
	    AceptarPase4.click();	  Thread.sleep(secDelay);
	    
	    WebElement Mensaje2 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje2 = Mensaje2.getText().trim();
        System.out.println(ObtenerMensaje2);
        String ExpectativaTexto2 = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje2, ExpectativaTexto2);
	    
		WebElement ConfirmarAceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	    ConfirmarAceptar4.click();
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
