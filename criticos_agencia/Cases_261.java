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
import Constantes.Constantes;
import DataDrivenTesting.ReadExcelFile;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Cases_261 {

	int secDelay = 1000;
	private WebDriver driver;
	private By DesplegarUnidadReceptora = By.id("unidadCrear-trigger-picker");
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
		
//		-------------------------------------- Eliminar Remesas en Agencia / Control de Remesas / Envíos---------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_261\\261.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//GENERAMOS UN NUMERO ALEATORIO--------------------------------------------------------------------------
		Random random = new Random();
		int GenerarNumeroAleatorio = random.nextInt(150001 - 80000) + 8000;
		String NumeroAleatorio2 = String.valueOf(GenerarNumeroAleatorio);
		
		//RUTA EXCEL--------------------------------------------------------------------------------------------
		 String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
		 String TipoUnidadEmisora = readFile.getCellValue(filepath, "CriticosAgencia", 18, 1);
		 String	UnidadEmisora = readFile.getCellValue(filepath, "CriticosAgencia", 18, 2);
		 String	Transporte = readFile.getCellValue(filepath, "CriticosAgencia", 18, 5);
				
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		//INGRESAMOS EN EL MODULO DE AGENCIA----------------------------------------------------------------------
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
		
		//INGRESAMOS EN EL APARTADO DE ENVIOS-----------------------------------------------------------------------
		WebElement ControlRemesas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remesas")));
		ControlRemesas.click();	
		WebElement Envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Envios")));
		Envios.click();
		

		//CREAMOS UN SEGUNDO ENVIO POR PARA REALIZAR EL CASES-------------------------------------------------------	
		WebElement CrearRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
		CrearRemesa.click();	  Thread.sleep(secDelay);	
		WebElement DesplegarTipoUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadCrear-trigger-picker")));
		DesplegarTipoUnidadEmisora.click();	 Thread.sleep(secDelay);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options) {
            if (option.getText().equals(TipoUnidadEmisora)) {
                option.click();
                break;
            
                }
            }
		
		WebElement elemento = driver.findElement(DesplegarUnidadReceptora);
	 	elemento.click();
	 	WebElement DesplegarUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadCrear-trigger-picker")));
 		DesplegarUnidadEmisora.click();		Thread.sleep(secDelay);
 		List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options2) {
            if (option.getText().equals(UnidadEmisora)) {
                option.click();
                break;
            
                }
            }
			
		WebElement DesplegarEmpresaTransportista2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transportistaCrear-trigger-picker")));
		DesplegarEmpresaTransportista2.click();		Thread.sleep(secDelay);
		List<WebElement> options3 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options3) {
            if (option.getText().equals(Transporte)) {
                option.click();
                break;
            
                }
            }
			
		WebElement DesplegarTipoEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvioCrear-trigger-picker")));
		DesplegarTipoEnvio.click();	 Thread.sleep(secDelay);
		WebElement TipoEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal - Urbano']")));
		TipoEnvio.click();
		WebElement Siguiente = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnInnerEl")));
		Siguiente.click();
		WebElement DesplegarDivisaEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
		DesplegarDivisaEnvio.click();	  Thread.sleep(secDelay);	
		WebElement DivisaEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		DivisaEnvio.click();
		WebElement NumeroDeServicio3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl")));
		NumeroDeServicio3.click();	   Thread.sleep(secDelay);
		NumeroDeServicio3.sendKeys(NumeroAleatorio2);
        WebElement Localizador2 = driver.findElement(By.id("destinoCrear-inputEl"));
        if (Localizador2.isEnabled()) {
            System.out.println("El elemento está habilitado.");
            WebElement DesplegarDestino = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("destinoCrear-trigger-picker")));
        	DesplegarDestino.click();	  Thread.sleep(secDelay);	
			WebElement Destino = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Boveda']")));
			Destino.click();
        } else {
            System.out.println("El elemento está deshabilitado.");
        }
	        
        WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear-btnInnerEl")));
    	Incluir.click();   
    	WebElement DesplegarTipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvaseCrear-trigger-picker")));
	 	DesplegarTipoEnvase.click();	  Thread.sleep(secDelay);   	
	 	WebElement TipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bolsa']")));
		TipoEnvase.click();
		WebElement DesplegarTipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
		DesplegarTipoPieza.click();	 Thread.sleep(secDelay);	
	 	WebElement TipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete']")));
 		TipoPieza.click();
 		WebElement CantidadInput = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
		CantidadInput.click();		Thread.sleep(secDelay);
		CantidadInput.sendKeys("1");		
		WebElement IncluirEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear-btnEl")));
		IncluirEnvase.click();	
		WebElement AñadirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
		AñadirPlomos.click();	   Thread.sleep(secDelay);
		AñadirPlomos.sendKeys("1");
		WebElement IncluirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnEl")));
		IncluirPlomos.click();
		WebElement elementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1115']")); 
        Actions doble = new Actions(driver);
        doble.doubleClick(elementoCantidad).perform();		Thread.sleep(secDelay);    
        List<WebElement> elementos1 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
        for (WebElement elemento3 : elementos1) {
            if (elemento3.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elemento3).sendKeys("1").sendKeys(Keys.ENTER).perform();
            }
        }		Thread.sleep(secDelay);    
        WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1133-btnWrap")));
    	Aceptar2.click();	  Thread.sleep(secDelay);
    	
    	WebElement Mensaje = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje = Mensaje.getText().trim();
        System.out.println(ObtenerMensaje);
        String ExpectativaTexto = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
    	
		WebElement ConfirmarAceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	 	ConfirmarAceptar2.click();	   Thread.sleep(secDelay);
	 	WebElement ConsultarTodos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
		ConsultarTodos.click();		Thread.sleep(secDelay);	
		
	 	//ELIMINAMOS LAS REMESAS CREADAS
		WebElement ArrastrarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
		ArrastrarRemesa.click();
        WebElement Papelera = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("panelPapelera-innerCt")));
    	Papelera.click();
        Actions actions = new Actions(driver);
        actions.dragAndDrop(ArrastrarRemesa, Papelera).build().perform();
            
        WebElement ConfirmarEliminacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
    	ConfirmarEliminacion.click();	  Thread.sleep(secDelay);	
        
    	WebElement Mensaje2 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje2 = Mensaje2.getText().trim();
        System.out.println(ObtenerMensaje2);
        String ExpectativaTexto2 = "Registro eliminado exitosamente";
        Assert.assertEquals(ObtenerMensaje2, ExpectativaTexto2);
    	
        WebElement aceptarEliminacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
    	aceptarEliminacion.click();		Thread.sleep(secDelay);			
    	WebElement RadiobuttomEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emisor-inputEl")));
		RadiobuttomEmisor.click();	
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
		Consultar.click();	   Thread.sleep(secDelay);	
		
		WebElement ArrastrarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
		ArrastrarRemesa2.click();
        WebElement Papelera2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("panelPapelera-innerCt")));
    	Papelera2.click();
        Actions actions2 = new Actions(driver);
        actions2.dragAndDrop(ArrastrarRemesa2, Papelera2).build().perform();
        
        WebElement ConfirmarEliminacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
		ConfirmarEliminacion2.click();	   Thread.sleep(secDelay);	
		
		WebElement Mensaje3 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje3 = Mensaje3.getText().trim();
        System.out.println(ObtenerMensaje3);
        String ExpectativaTexto3 = "Registro eliminado exitosamente";
        Assert.assertEquals(ObtenerMensaje3, ExpectativaTexto3);
    
	    WebElement aceptarEliminacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
    	aceptarEliminacion2.click();
	    	
    	WebElement RadiobuttomReceptor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("receptor-inputEl")));
		RadiobuttomReceptor.click();	
		WebElement Consultar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnEl")));
		Consultar5.click();		Thread.sleep(secDelay);

		WebElement ArrastrarRemesa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
		ArrastrarRemesa3.click();
        WebElement Papelera3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("panelPapelera-innerCt")));
    	Papelera3.click();
        Actions actions3 = new Actions(driver);
        actions3.dragAndDrop(ArrastrarRemesa3, Papelera3).build().perform();
        
        WebElement ConfirmarEliminacion5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
		ConfirmarEliminacion5.click();
	    WebElement aceptarEliminacion5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
    	aceptarEliminacion5.click();
			
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
