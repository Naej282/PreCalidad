package criticos_agencia;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constantes.Constantes;

public class Cases_188 {

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
		
//		-------------------------------------------- Inventario - Ajustar Bóveda (Faltante) / Módulo Agencia---------------------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
			String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_188\\188.avi";
			String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
			ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		        
        //TOMA DE EVIDENCIAS--------------------------------------------------------------------------------------------------  
			String directorioCapturas = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_188";
		 	String nombreArchivo1 = "1.png";
		 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
		 	String nombreArchivo2 = "2.png";
		 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
		 	
	 	//MONTO DE LA DIFERENCIA---------------------------------------------------------------------------------------------------
	 	 
	 	int Cantidad = 1;
		
		//INGRESAMOS EN EL MODULO DE AGENCIA----------------------------------------------------------------------------------
        
			WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
			WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
			login.sendKeys(Constantes.USUARIO);
			WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
			password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
			WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
			logear.click();		Thread.sleep(secDelay);
				
		//INGRESAMOS EN EL INVENTARIO-------------------------------------------------------------------------------------------
				
			WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
			CuadreDeAgencia.click();
			WebElement inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
			inventario.click();
			WebElement DesplegarTipoDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
			DesplegarTipoDeBoveda.click();	   Thread.sleep(secDelay);
			WebElement TipoDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
			TipoDeBoveda.click();
		    WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
	    	DesplegarDivisa.click();	 Thread.sleep(secDelay);
			WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
			Divisa.click();
			WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
			Consultar.click();     Thread.sleep(secDelay);
			WebElement DesplegarConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
	  	    DesplegarConsulta.click();	   Thread.sleep(secDelay);
	  	    
	  	    WebElement CantidadInventario = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1018']"));
	  	  	String ObtenerCantidadInventario = CantidadInventario.getText().trim();
	  	  	ObtenerCantidadInventario = ObtenerCantidadInventario.replace(".", "");
	  	  	double ObtenerCantidadInventarioInt = Double.parseDouble(ObtenerCantidadInventario);
	      	System.out.println(ObtenerCantidadInventarioInt);
					
	        File archivo1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo1, new File(captura1));	Thread.sleep(secDelay);
		        
	        //REALIZAMOS UN AJUSTE FALTANTE----------------------------------------------------------------------------------------
	        
	        WebElement AjustarBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda-btnEl")));
        	AjustarBoveda.click();
        	WebElement DesplegarDenominacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
    		DesplegarDenominacion.click();	   Thread.sleep(secDelay);
    		WebElement Denominacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DENOMINACION+"']")));
			Denominacion.click();	
			WebElement DesplegarClasificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
			DesplegarClasificacion.click();		Thread.sleep(secDelay);
    		WebElement Clasificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.APTOS	+"']")));
			Clasificacion.click();
			WebElement Cantidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantesAjuste-inputEl")));
			Cantidad2.click();
			Thread.sleep(secDelay);
			Cantidad2.sendKeys(""+Cantidad+"");
			WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1097-btnWrap")));
			Incluir.click();	 Thread.sleep(secDelay);
			WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1110-btnWrap")));
			Aceptar.click();	 Thread.sleep(secDelay);
			
			WebElement Mensaje = driver.findElement(By.id("messagebox-1001-msg"));
	        String ObtenerMensaje = Mensaje.getText().trim();
	        System.out.println(ObtenerMensaje);
	        String ExpectativaTexto = "Registro creado exitosamente";
	        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
			
			WebElement AceptarMensaje = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
			AceptarMensaje.click();		Thread.sleep(secDelay);
			
			WebElement CantidadInventario2 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1018']"));
	  	  	String ObtenerCantidadInventario2 = CantidadInventario2.getText().trim();
	  	  	ObtenerCantidadInventario2 = ObtenerCantidadInventario2.replace(".", "");
	  	  	double ObtenerCantidadInventarioInt2 = Double.parseDouble(ObtenerCantidadInventario2);
	      	System.out.println(ObtenerCantidadInventarioInt2);
	      	Assert.assertEquals(ObtenerCantidadInventarioInt2, (ObtenerCantidadInventarioInt - Cantidad), 0.00001);
	      	
			File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(archivo2, new File(captura2));   
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
