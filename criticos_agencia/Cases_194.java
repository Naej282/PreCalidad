package criticos_agencia;

import java.io.File;
import java.io.IOException;
import java.util.List;
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

public class Cases_194 {

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
		
//		------------------------------------------------- Inventario - Ajustar Bóveda (Detalle) / Módulo Agencia---------------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_194\\194.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//MONTO DE LA DIFERENCIA---------------------------------------------------------------------------------------------------
	 	 
	 	int Cantidad = 1;
	 	int Cantidad2 = 2;
		        
        //TOMA DE EVIDENCIAS--------------------------------------------------------------------------------------------------
		String directorioCapturas = ""+Constantes.RUTA_EXCELE+"\\Criticos_Agencia\\Cases_194";
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
		
		//INGRESAR EN EL MODULO DE AGENCIA-------------------------------------------------------------------------------------
        
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
	
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
				
		//INGRESAMOS EN EL INVENTARIO------------------------------------------------------------------------------------------
				
		WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
		CuadreDeAgencia.click();
		WebElement inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
		inventario.click();		Thread.sleep(secDelay);
		WebElement DesplegarTipoDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
		DesplegarTipoDeBoveda.click();	   Thread.sleep(secDelay);
		WebElement TipoDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
		TipoDeBoveda.click(); 
	    WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
    	DesplegarDivisa.click();	 Thread.sleep(secDelay);
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();			
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		Consultar.click();		
		WebElement DesplegarConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
  	    DesplegarConsulta.click();	   Thread.sleep(secDelay);
  	    
  	    WebElement CantidadInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[data-recordindex='0'] td[data-columnid='gridcolumn-1018']")));
	  	String ObtenerCantidadInventario = CantidadInventario.getText().trim();
	  	ObtenerCantidadInventario = ObtenerCantidadInventario.replace(".", "");
	  	double ObtenerCantidadInventarioInt = Double.parseDouble(ObtenerCantidadInventario);
	  	System.out.println(ObtenerCantidadInventarioInt);	Thread.sleep(secDelay);
	  	
	  	WebElement CantidadInventario2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[data-recordindex='1'] td[data-columnid='gridcolumn-1018']")));
	  	String ObtenerCantidadInventario2 = CantidadInventario2.getText().trim();
	  	ObtenerCantidadInventario2 = ObtenerCantidadInventario2.replace(".", "");
	  	double ObtenerCantidadInventarioInt2 = Double.parseDouble(ObtenerCantidadInventario2);
	  	System.out.println(ObtenerCantidadInventarioInt2);	
  	
        File archivo1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo1, new File(captura1));	Thread.sleep(secDelay);
        
        //REALIZAMOS UN AJUSTE DE DETALLE
        
        WebElement AjustarBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda-btnEl")));
    	AjustarBoveda.click();
    	WebElement DesplegarDenominacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionSobrantesAjuste-trigger-picker")));
		DesplegarDenominacion.click();	   Thread.sleep(secDelay);
		WebElement Denominacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DENOMINACION+"']")));
		Denominacion.click();	
		WebElement DesplegarClasificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionSobrantesAjuste-trigger-picker")));
		DesplegarClasificacion.click();	 	Thread.sleep(secDelay);
		WebElement Clasificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
		Clasificacion.click();
		WebElement Cantidad02 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadSobrantesAjuste-inputEl")));
		Cantidad02.click();
		Thread.sleep(secDelay);
		Cantidad02.sendKeys(""+Cantidad+"");
		WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1087-btnWrap")));
		Incluir.click();
		WebElement DesplegarDenominacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
		DesplegarDenominacion2.click();     Thread.sleep(secDelay);
	       List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	       for (WebElement option : options2) {
	           if (option.getText().equals(Constantes.DENOMINACION2)) {
	               option.click();
	               break;        
	           }
	       }	Thread.sleep(secDelay);
        		
       WebElement DesplegarClasificacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
		DesplegarClasificacion2.click();     Thread.sleep(secDelay);
	       List<WebElement> options3 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	       for (WebElement option : options3) {
	           if (option.getText().equals("Aptos")) {
	               option.click();
	               break;        
	           }
	       }	Thread.sleep(secDelay);
        			
		WebElement Cantidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantesAjuste-inputEl")));
		Cantidad3.click();
		Thread.sleep(secDelay);
		Cantidad3.sendKeys(""+Cantidad2+"");
		WebElement Incluir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1097-btnWrap")));
		Incluir2.click();	  Thread.sleep(secDelay);	
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1110-btnWrap")));
		Aceptar.click();	 Thread.sleep(secDelay);
		
		WebElement Mensaje2 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje2 = Mensaje2.getText().trim();
        System.out.println(ObtenerMensaje2);
        String ExpectativaTexto2 = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje2, ExpectativaTexto2);
		
		WebElement AceptarMensaje = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarMensaje.click();		Thread.sleep(secDelay);
		
		WebElement CantidadInventario3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1018']")));
	  	String ObtenerCantidadInventario3 = CantidadInventario3.getText().trim();
	  	ObtenerCantidadInventario3 = ObtenerCantidadInventario3.replace(".", "");
	  	double ObtenerCantidadInventarioInt3 = Double.parseDouble(ObtenerCantidadInventario3);
	  	System.out.println(ObtenerCantidadInventarioInt3);	Thread.sleep(secDelay);
	  	Assert.assertEquals(ObtenerCantidadInventarioInt3, (ObtenerCantidadInventarioInt + Cantidad), 0.00001);
	  	
	  	
	  	WebElement CantidadInventario4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[data-recordindex='1'] td[data-columnid='gridcolumn-1018']")));
	  	String ObtenerCantidadInventario4 = CantidadInventario4.getText().trim();
	  	ObtenerCantidadInventario4 = ObtenerCantidadInventario4.replace(".", "");
	  	double ObtenerCantidadInventarioInt4 = Double.parseDouble(ObtenerCantidadInventario4);
	  	System.out.println(ObtenerCantidadInventarioInt4);
	  	Assert.assertEquals(ObtenerCantidadInventarioInt4, (ObtenerCantidadInventarioInt2 - Cantidad2), 0.00001);
				
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
