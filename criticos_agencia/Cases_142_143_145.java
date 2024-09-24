package criticos_agencia;

import java.io.IOException;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constantes.Constantes;
import DataDrivenTesting.ReadExcelFile;

public class Cases_142_143_145 {

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
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_142_143_145\\142_143_145.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//RUTA EXCEL-----------------------------------------------------------------------------------------------------------------------
		
		String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
	    String ATM = readFile.getCellValue(filepath, "CriticosAgencia", 4, 2);
		
		//BLOQUE DE CODIGO PARA SELECCIONAR EL DIA ACTUAL EN EL CALENDARIO-----------------------------------------------------------------
		
		int DiaActual = LocalDate.now().getDayOfMonth();			
        System.out.println(DiaActual);
        String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
        System.out.println(DiaActualString);
		
		//INGRESAMOS EN EL MODULO DE AGENCIA------------------------------------------------------------------------------------------------
		
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
			
        WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();	 	Thread.sleep(secDelay);
		
		//PROCEDEMOS A CERRAR LA CAJA SI LA MISMA SE ENCUENTRA ABIERTA-----------------------------------------------------------------------
		
		WebElement IngresarEnCaja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
		IngresarEnCaja.click();	
		WebElement IngresarPasesDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
		IngresarPasesDeBoveda.click();
		WebElement OpcionCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		OpcionCrear.click();
		WebElement DespTipoDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
		DespTipoDivisa.click();
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();
		WebElement DespCaja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
		DespCaja.click();
		WebElement Caja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ATM+"']")));
		Caja.click();	  Thread.sleep(secDelay);
		WebElement DespModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
		DespModalidad.click();
		
		// VERIFICAMOS SI LA CAJA YA SE ENCUENTRA CERRADA SI ES ASI SOLO SALDRA UN MENSAJE, SI NO PROCEDERA A CERRARSE------------------------
		
			try {
			WebElement Modalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cierre']")));
		    	Modalidad.click();
	
		    WebElement AceptarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnInnerEl")));
		    	AceptarPase.click();
	
		    WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
		    	ConfirmarAceptar.click();
			} catch (Exception e) {
				System.out.println("Las cajas ya se encontraban cerradas");
			}
		
		//ABRIMOS UNA NUEVA PESTAÑA EN EL MODULO DE AGENCIA-------------------------------------------------------------------------------------
        
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
				
		//INGRESAMOS EN EL APARTADO DE CIERRE DE UNIDADES---------------------------------------------------------------------------------------
				
			WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
			CuadreDeAgencia.click();
			WebElement CierreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cierre")));
			CierreDeAgencia.click();
					
					
		//SE REALIZA UN CIERRE (CASES 145)-------------------------------Cierre de día. Cierre de Agencia / Módulo Agencia------------------------------------
					
			WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
			DesplegarDivisa.click();
			WebElement Divisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+Constantes.DIVISA+"']")));
			Divisa2.click();	 
			WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen60")));
			Consultar.click();	   Thread.sleep(secDelay);			
			WebElement seleccionarDía = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
	        seleccionarDía.click();		Thread.sleep(secDelay);	        
		    WebElement CerrarDia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCierre")));
	    	CerrarDia.click();	   Thread.sleep(secDelay);
		    WebElement ConfirmarCerrarDia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1065")));
	    	ConfirmarCerrarDia.click(); 	
		    WebElement AceptarCerrarDia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1061")));
	    	AceptarCerrarDia.click(); 	  Thread.sleep(secDelay);
	    	
	    	WebElement Mensaje = driver.findElement(By.cssSelector(".ext-mb-text"));
	        String ObtenerMensaje = Mensaje.getText().trim();
	        System.out.println(ObtenerMensaje);
	        String ExpectativaTexto = "Registro creado exitosamente";
	        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
	    	
	    	WebElement AceptarMensaje = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1064")));
	    	AceptarMensaje.click();		Thread.sleep(secDelay);
			    
	    //VIZUALIZAR EL DETALLE DEL DIA (CASES 142)--------------------------Consulta Cierre de Agencia / Módulo Agencia------------------------------------------------
			    	
		    WebElement seleccionarDía2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable dia-cerrado'][text()='"+  DiaActualString +"']")));
	        seleccionarDía2.click();	 Thread.sleep(secDelay);        
		    WebElement Detalle = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionDetalles")));
	    	Detalle.click();	 Thread.sleep(secDelay);
	    	
	    	WebElement Mensaje2 = driver.findElement(By.cssSelector(".x-window-header-text"));
	        String ObtenerMensaje2 = Mensaje2.getText().trim();
	        System.out.println(ObtenerMensaje2);
	        String ExpectativaTexto2 = "Detalles de Cierre";
	        Assert.assertEquals(ObtenerMensaje2, ExpectativaTexto2);
	    	
		    WebElement Cancelar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1073")));
	    	Cancelar.click();
	    	
	   //IMPRIMIMOS EL DIA (CASES 143)-------------------------------- Imprimir Cierre de Agencia / Módulo Agencia------------------------------------------------
			    	
		    WebElement Imprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
	    	Imprimir.click();	
		    WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen450")));
	    	DesplegarFormato.click();Thread.sleep(secDelay);  
		    WebElement FormatoPDF = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PDF']")));
			FormatoPDF.click();
			WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar")));
			Aceptar.click();
			WebElement Imprimir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
	    	Imprimir2.click();	   Thread.sleep(secDelay);
			WebElement DesplegarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen450")));
	    	DesplegarFormato2.click(); 	   Thread.sleep(secDelay);
		    WebElement FormatoPDF2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='XLSX']")));
			FormatoPDF2.click();
			WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar")));
			Aceptar2.click();	   
		}
		@After
		public void tearDown() throws Exception {
			Thread.sleep(3000);
//		    if (driver != null) {
//		        driver.quit();
//		    }
		    Thread.sleep(2000); 
		    if (ffmpegProcess != null) {
		        ffmpegProcess.destroy();
		        ffmpegProcess.waitFor();
		    }
	}
}
