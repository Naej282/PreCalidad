package criticos_agencia;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
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


public class Cases_198 {

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
		
//		--------------------------------------------- Modificar Pase en Agencia / Caja / Pases de Bóveda--------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_198\\198.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//RUTA DEL EXCEL------------------------------------------------------------------------------------------------------
		
		String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
	    String CAJA = readFile.getCellValue(filepath, "CriticosAgencia", 8, 2);
		
		//BLOQUE DE CODIGO PARA SELECCIONAR EL DIA ACTUAL EN EL CALENDARIO----------------------------------------------------
		
		int DiaActual = LocalDate.now().getDayOfMonth();				
        System.out.println(DiaActual);
        String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
        System.out.println(DiaActualString);

	 	WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
					
		//INGRESAR EN EL MODULO CENTRAL---------------------------------------------------------------------------------------
		    	
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);		
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);	
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
		
		//CAMBIAR EL PARAMETRO WF---------------------------------------------------------------------------------------------
		
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
		Actions doble2 = new Actions(driver);
		doble2.doubleClick(ValorParametroWF).perform();	Thread.sleep(secDelay);
		ValorParametroWF.sendKeys("0");
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
					
		//INGRESAR EN EL MODULO DE AGENCIA------------------------------------------------------------------------------------------
			        
		((JavascriptExecutor)driver).executeScript("window.open()");

        String secondTab = driver.getWindowHandles().stream().skip(1).findFirst().get();
        driver.switchTo().window(secondTab);
        driver.get(Constantes.URL_AGENCIA);
		
		WebElement login2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login2.sendKeys(Constantes.USUARIO);
		WebElement password2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password2.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear2.click();	 Thread.sleep(secDelay);
				
		//INGRESAR EN EL APARTADO PARA CREAR UN PASE---------------------------------------------------------------------------------
				
		WebElement IngresarEnCaja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
		IngresarEnCaja.click();
		WebElement IngresarPasesDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
		IngresarPasesDeBoveda.click();	
		WebElement OpcionCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		OpcionCrear.click();
				
		//CREAR EL PASE--------------------------------------------------------------------------------------------------------------
				
		WebElement DespTipoDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
		DespTipoDivisa.click();		Thread.sleep(secDelay);
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();
		WebElement DespCaja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
		DespCaja.click(); 	  Thread.sleep(secDelay);
		WebElement Caja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+CAJA+"']")));
		Caja.click();	  Thread.sleep(secDelay);
			
		try {
		    WebElement DespModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
		    DespModalidad.click();	   Thread.sleep(secDelay);
		    WebElement Modalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal']")));
		    Modalidad.click();    	
			WebElement DespModalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
	    	DespModalidad2.click();		Thread.sleep(secDelay);
		    WebElement TipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase de Boveda a Caja']")));
			TipoPase.click();	  Thread.sleep(secDelay);
				
			WebElement elementoCantidad100 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); 
	        Actions doble = new Actions(driver);
	        doble.doubleClick(elementoCantidad100).perform();	Thread.sleep(secDelay);
    
	        List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
	        for (WebElement elemento : elementos) {
	            if (elemento.isEnabled()) {
	                Actions actions = new Actions(driver);
	                actions.click(elemento).sendKeys("3").sendKeys(Keys.ENTER).perform();
	            }
	        }
		        
	        WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
        	Aceptar.click();
			WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
		 	ConfirmarAceptar.click();	  Thread.sleep(secDelay);
				 	 
			//SI LA CAJA SE ENCUENTRA CERRADA
			} catch (Exception e) {
				
			    WebElement Modalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Apertura']")));
		    	Modalidad.click();   	
		    	WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
	        	Aceptar.click();
				WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
			 	ConfirmarAceptar.click();	
			 	WebElement Estado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1013-titleEl")));
		 	 	Actions doble3 = new Actions(driver);
		 		doble3.doubleClick(Estado).perform();	 	
		 		WebElement SeleccionarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1013']")));
				SeleccionarPase.click();	 	
	 			WebElement Avanzar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarPase-btnWrap")));
				Avanzar.click();
				WebElement AceptarAvance = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1076-btnEl")));
				AceptarAvance.click();
				WebElement AceptarMensaje = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
				AceptarMensaje.click();
				WebElement Estado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1013-titleEl")));
				Estado2.click();
				WebElement SeleccionarPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1013']")));
				SeleccionarPase2.click();
	 			WebElement Avanzar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarPase-btnWrap")));
				Avanzar2.click();
				WebElement AceptarAvance2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1076-btnWrap")));
				AceptarAvance2.click();
				WebElement AceptarMensaje2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
				AceptarMensaje2.click();
			 	WebElement OpcionCrear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
		 		OpcionCrear2.click();
						
				//CREAR EL PASE--------------------------------------------------------------------------------------------------------------------------------------
						
				WebElement DespTipoDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
				DespTipoDivisa2.click();	 Thread.sleep(secDelay);
				WebElement Divisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
				Divisa2.click();	
				WebElement DespCaja2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
				DespCaja2.click();	   Thread.sleep(secDelay);
				WebElement Caja2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+CAJA+"']")));
				Caja2.click();	   Thread.sleep(secDelay);	
				WebElement DespModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
			    DespModalidad.click();	   Thread.sleep(secDelay);
			    WebElement Modalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal']")));
			    Modalidad2.click();    
			    WebElement DespTipoDivisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
				DespTipoDivisa3.click();	 Thread.sleep(secDelay);
				WebElement Divisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
				Divisa3.click();
				WebElement DespCaja3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
				DespCaja3.click();	   Thread.sleep(secDelay);
				WebElement Caja3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+CAJA+"']")));
				Caja3.click();    	
				WebElement DespModalidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
		    	DespModalidad3.click();		Thread.sleep(secDelay);
			    WebElement TipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase de Boveda a Caja']")));
				TipoPase.click();	  Thread.sleep(secDelay);
				WebElement elementoCantidad100 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); 
		        Actions doble = new Actions(driver);
		        doble.doubleClick(elementoCantidad100).perform();	Thread.sleep(secDelay);
		        
		        List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31'], [id^='ext-element-'][id$='32'], [id^='ext-element-'][id$='33'], [id^='ext-element-'][id$='34'], [id^='ext-element-'][id$='35'], [id^='ext-element-'][id$='36'], [id^='ext-element-'][id$='37'], [id^='ext-element-'][id$='38'], [id^='ext-element-'][id$='39'], [id^='ext-element-'][id$='40'], [id^='ext-element-'][id$='41'], [id^='ext-element-'][id$='42'], [id^='ext-element-'][id$='43'], [id^='ext-element-'][id$='44'], [id^='ext-element-'][id$='45'], [id^='ext-element-'][id$='46'], [id^='ext-element-'][id$='47'], [id^='ext-element-'][id$='48']"));
		        for (WebElement elemento : elementos) {
		            if (elemento.isEnabled()) {
		                Actions actions = new Actions(driver);
		                actions.click(elemento).sendKeys("1").sendKeys(Keys.ENTER).perform();
		            }
		        }
		        WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
	        	Aceptar2.click();
				WebElement ConfirmarAceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
			 	ConfirmarAceptar2.click();			
			}
			
			WebElement Estado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gridcolumn-1013-titleEl")));
	 	 	Actions doble3 = new Actions(driver);
	 		doble3.doubleClick(Estado).perform();
			
	 		WebElement SeleccionarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1013']")));
 			SeleccionarPase.click();
			WebElement Modificar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
			Modificar.click();	   Thread.sleep(secDelay);
			WebElement elementoCantidad100 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1052']"));
	        Actions doble = new Actions(driver);
	        doble.doubleClick(elementoCantidad100).perform();
	        doble.doubleClick(elementoCantidad100).perform();	Thread.sleep(secDelay);
				
			List<WebElement> elementos2 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31'], [id^='ext-element-'][id$='32'], [id^='ext-element-'][id$='33'], [id^='ext-element-'][id$='34'], [id^='ext-element-'][id$='35'], [id^='ext-element-'][id$='36'], [id^='ext-element-'][id$='37'], [id^='ext-element-'][id$='38'], [id^='ext-element-'][id$='39'], [id^='ext-element-'][id$='40'], [id^='ext-element-'][id$='41'], [id^='ext-element-'][id$='42'], [id^='ext-element-'][id$='43'], [id^='ext-element-'][id$='44'], [id^='ext-element-'][id$='45'], [id^='ext-element-'][id$='46'], [id^='ext-element-'][id$='47'], [id^='ext-element-'][id$='48']"));
	        for (WebElement elemento2 : elementos2) {
	            if (elemento2.isEnabled()) {
	                Actions actions2 = new Actions(driver);
	                actions2.sendKeys(Keys.BACK_SPACE).sendKeys("1").sendKeys(Keys.ENTER).perform();
	            }
	        }
	        
	        WebElement AceptarModificar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1079-btnWrap")));
        	AceptarModificar.click();	  Thread.sleep(secDelay);
	        	
        	WebElement Mensaje2 = driver.findElement(By.id("messagebox-1001-msg"));
            String ObtenerMensaje2 = Mensaje2.getText().trim();
            System.out.println(ObtenerMensaje2);
            String ExpectativaTexto2 = "Registro modificado exitosamente";
            Assert.assertEquals(ObtenerMensaje2, ExpectativaTexto2);	
        	
        	WebElement AceptarModificarMensaje = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        	AceptarModificarMensaje.click();
	        	
        	//CAMBIAR EL PARAMETRO WF
		    	
        	((JavascriptExecutor)driver).executeScript("window.open()");

	        String secondTab2 = driver.getWindowHandles().stream().skip(1).findFirst().get();
	        driver.switchTo().window(secondTab2);
	        driver.get(Constantes.URL_CENTRAL);
	        
        	WebElement login3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
			login3.sendKeys(Constantes.USUARIO);
			WebElement password3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			password3.sendKeys(Constantes.CONTRASEÑA);			
			WebElement logear3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
			logear3.click();	 Thread.sleep(secDelay);
			
			WebElement Configuracion3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
        	Configuracion3.click();
	        WebElement Generales3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("generales")));
	        Generales3.click();
	        WebElement ParametrosGenerales3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("parametroGeneral")));
	        ParametrosGenerales3.click();
	        WebElement modificables3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-1026")));
            modificables3.click();	   Thread.sleep(secDelay);     
            WebElement ParametroWF2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PASE_WF']")));
      		ParametroWF2.click();     
     		WebElement ModificarParametroWF3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
 			ModificarParametroWF3.click();
 			WebElement ValorParametroWF3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
 	        Actions doble4 = new Actions(driver);
 	        doble4.doubleClick(ValorParametroWF3).perform();
        	Thread.sleep(secDelay);
			ValorParametroWF3.sendKeys("1");
			WebElement AceptarModificarParametroWF3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnInnerEl")));
			AceptarModificarParametroWF3.click();
			WebElement ConfirmarModificarParametroWF3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnEl")));
			ConfirmarModificarParametroWF3.click();		Thread.sleep(secDelay);
				
			WebElement Mensaje3 = driver.findElement(By.id("messagebox-1001-msg"));
            String ObtenerMensaje3 = Mensaje3.getText().trim();
            System.out.println(ObtenerMensaje3);
            String ExpectativaTexto3 = "Registro modificado exitosamente";
            Assert.assertEquals(ObtenerMensaje3, ExpectativaTexto3);
			
			WebElement AceptarMensajeParametroWF3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
			AceptarMensajeParametroWF3.click();
	        
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
