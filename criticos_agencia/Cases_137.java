package criticos_agencia;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constantes.Constantes;
import DataDrivenTesting.ReadExcelFile;

public class Cases_137 {
	
	int secDelay = 1000;

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
		
//		---------------------------------------------------------Apertura de Caja / Crear pase de Apertura-----------------------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_137\\137.avi";
        String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
        ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
        
		//RUTA EXCEL---------------------------------------------------------------------------------------
		String filepath = ""+Constantes.RUTA_EXCELJ+"//MatrizCriticosAgencia.xlsx";				
		String ATM = readFile.getCellValue(filepath,"CriticosAgencia", 1, 2);		
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		 //ABRIR CENTRAL------------------------------------------------------------------------------------
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
		
		//CAMBIAR PARAMETRO WF-------------------------------------------------------------------------------
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
		
		 //ABRIR AGENCIA--------------------------------------------------------------------------------------
        ((JavascriptExecutor)driver).executeScript("window.open()");
        String secondTab2 = driver.getWindowHandles().stream().skip(1).findFirst().get();
        driver.switchTo().window(secondTab2);
        driver.get(Constantes.URL_AGENCIA);		
		
		WebElement login2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login2.sendKeys(Constantes.USUARIO);
		WebElement password2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password2.sendKeys(Constantes.CONTRASEÑA);
		WebElement logear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear2.click();	 Thread.sleep(secDelay);
				
		//INGRESAR EN EL APARTADO DE PASES----------------------------------------------------------------------
		WebElement IngresarEnCaja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
		IngresarEnCaja.click();
		WebElement IngresarPasesDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
		IngresarPasesDeBoveda.click();
		WebElement OpcionCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		OpcionCrear.click();
				
		//CREAR LA APERTURA--------------------------------------------------------------------------------------
		WebElement DespTipoDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
		DespTipoDivisa.click();
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();
		WebElement DespCaja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
		DespCaja.click();
		WebElement Caja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ATM+"']")));
		Caja.click();	  Thread.sleep(secDelay);
				
		try {
		    WebElement DespModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
		    DespModalidad.click();     Thread.sleep(secDelay);
		    WebElement Modalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Apertura']")));
		    Modalidad.click();     Thread.sleep(secDelay);
		    WebElement AceptarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
		    AceptarPase.click();	 Thread.sleep(secDelay);
		    WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
		    ConfirmarAceptar.click();
		} catch (Exception e) {
			    
			WebElement Modalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cierre']")));
		    Modalidad.click();
		    WebElement AceptarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
		    AceptarPase.click();
		    WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
		    ConfirmarAceptar.click();
		    WebElement OpcionCrear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
			OpcionCrear2.click();
			WebElement DespTipoDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
			DespTipoDivisa2.click();
			WebElement Divisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
			Divisa2.click();
			WebElement DespCaja2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
			DespCaja2.click();
			WebElement Caja2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ATM+"']")));
			Caja2.click();
			WebElement DespModalidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
		    DespModalidad3.click();		Thread.sleep(secDelay);
		    WebElement Modalidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Apertura']")));
		    Modalidad3.click();		Thread.sleep(secDelay);
		    WebElement AceptarPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
		    AceptarPase3.click();	  Thread.sleep(secDelay);
		    
		    WebElement Mensaje2 = driver.findElement(By.id("messagebox-1001-msg"));
	        String ObtenerMensaje2 = Mensaje2.getText().trim();
	        System.out.println(ObtenerMensaje2);
	        String ExpectativaTexto2 = "Registro creado exitosamente";
	        Assert.assertEquals(ObtenerMensaje2, ExpectativaTexto2);
	        
		    WebElement ConfirmarAceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
		    ConfirmarAceptar3.click();	   Thread.sleep(secDelay);
		    
		    WebElement Desplegar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
		    Desplegar.click();	   Thread.sleep(secDelay);
		    List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	        for (WebElement option : options2) {
	            if (option.getText().equals(Constantes.DIVISA)) {
	                option.click();
	                break;
	            
	                }
	            };
		    
		    WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		    Consultar.click();
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

	

