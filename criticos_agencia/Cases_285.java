package criticos_agencia;

import java.io.IOException;
import java.util.List;
import java.util.Random;
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

public class Cases_285 {

	int secDelay = 1000;
	private WebDriver driver;
	private By DesplegarUnidadReceptora = By.id("unidadCrear-trigger-picker");
	private Process ffmpegProcess;
	private ReadExcelFile readFile;
	
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
		
//		-------------------------Reverso de Remesas en Agencia (estado Solicitado) / Control de Remesas / Envíos--------------------------
		
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_285\\285.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//GENERAMOS UN NUMERO ALEATORIO--------------------------------------------------------------------------
		Random random = new Random();
		int GenerarNumeroAleatorio = random.nextInt(200001 - 100000) + 100000;
		String NumeroAleatorio = String.valueOf(GenerarNumeroAleatorio);
		
		//RUTA EXCEL--------------------------------------------------------------------------------------------
		
		String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
		String TipoUnidadEmisora = readFile.getCellValue(filepath, "CriticosAgencia", 22, 1);
		String	UnidadEmisora = readFile.getCellValue(filepath, "CriticosAgencia", 22, 2);
		String	Transporte = readFile.getCellValue(filepath, "CriticosAgencia", 22, 5);
				
		//INGRESAMOS EN EL MODULO DE AGENCIA----------------------------------------------------------------------
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
		
		//INGRESAMOS EN EL APARTADO DE ENVIOS------------------------------------------------------------------
		
		WebElement ControlRemesas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remesas")));
		ControlRemesas.click();		
		WebElement Envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Envios")));
		Envios.click();
		
		//CREAMOS LA REMESA--------------------------------------------------------------------------------------
			
		WebElement CrearRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
		CrearRemesa.click();	 Thread.sleep(secDelay);
		
		WebElement DesplegarTipoUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadCrear-trigger-picker")));
		DesplegarTipoUnidadEmisora.click();		Thread.sleep(secDelay);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options) {
            if (option.getText().equals(TipoUnidadEmisora)) {
                option.click();
                break;
            
                }
            }		Thread.sleep(secDelay);
		
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
            };
			
            WebElement DesplegarEmpresaTransportista = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transportistaCrear-trigger-picker")));
    		DesplegarEmpresaTransportista.click();
    		List<WebElement> options3 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
            for (WebElement option : options3) {
                if (option.getText().equals(Transporte)) {
                    option.click();
                    break;
                
                    }
                }
			
		WebElement DesplegarTipoEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvioCrear-trigger-picker")));
		DesplegarTipoEnvio.click();		Thread.sleep(secDelay);
		WebElement TipoEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal - Urbano']")));
		TipoEnvio.click();
			
		WebElement Siguiente = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnInnerEl")));
		Siguiente.click();	   Thread.sleep(secDelay);
			
		WebElement DesplegarDivisaEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
		DesplegarDivisaEnvio.click();	  Thread.sleep(secDelay);		
		WebElement DivisaEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		DivisaEnvio.click();
		WebElement NumeroDeServicio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl")));
		NumeroDeServicio2.click();	   Thread.sleep(secDelay);
		NumeroDeServicio2.sendKeys(NumeroAleatorio);
			
	    WebElement Localizador = driver.findElement(By.id("destinoCrear-inputEl"));
	    if (Localizador.isEnabled()) {
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
	 	DesplegarTipoEnvase.click();	 Thread.sleep(secDelay);	
	 	WebElement TipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bolsa']")));
		TipoEnvase.click();	
		WebElement DesplegarTipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
		DesplegarTipoPieza.click();		Thread.sleep(secDelay);	
	 	WebElement TipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete']")));
 		TipoPieza.click();
		WebElement CantidadInput = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
		CantidadInput.click();	   Thread.sleep(secDelay);
		CantidadInput.sendKeys("1");
		WebElement IncluirEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear-btnEl")));
		IncluirEnvase.click();
		WebElement AñadirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
		AñadirPlomos.click();	  Thread.sleep(secDelay);
		AñadirPlomos.sendKeys("1");		
		WebElement IncluirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnEl")));
		IncluirPlomos.click();	
		WebElement elementoCantidad1002 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1115']")); 
	    Actions doble2 = new Actions(driver);
	    doble2.doubleClick(elementoCantidad1002).perform();		Thread.sleep(secDelay);
	    List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));	
	    for (WebElement elemento2 : elementos) {
	        if (elemento2.isEnabled()) {
	            Actions actions = new Actions(driver);
	            Thread.sleep(secDelay);
	            actions.click(elemento2).sendKeys("1").sendKeys(Keys.ENTER).perform();
	        }
	    }		Thread.sleep(secDelay);
	    
	    WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1133-btnWrap")));
    	Aceptar.click();	 Thread.sleep(secDelay);
	    
    	WebElement Mensaje = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje = Mensaje.getText().trim();
        System.out.println(ObtenerMensaje);
        String ExpectativaTexto = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
    	
		WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	 	ConfirmarAceptar.click();	  Thread.sleep(secDelay); 	
	 	WebElement Filtro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
	 	Filtro.click();	 	Thread.sleep(secDelay);
	 	WebElement Receptor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadRConsulta-inputEl")));
 		Receptor.click();	 	
	 	WebElement NroDeServicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
 		NroDeServicio.click();
 		NroDeServicio.sendKeys(NumeroAleatorio);	Thread.sleep(secDelay);	
 		WebElement Filtrar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnWrap")));
		Filtrar.click();	 Thread.sleep(secDelay);
		
		//REVERSAR LA REMESA EN ESTADO SOLICITADO-------------------------------------------------------------------------------------
		
		WebElement SeleccionarRemesa = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa.click();	   Thread.sleep(secDelay);
		WebElement Reversar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnEl")));
		Reversar.click();	  Thread.sleep(secDelay);
		
		WebElement Mensaje2 = driver.findElement(By.id("messagebox-1001-msg"));
		Thread.sleep(secDelay);
        String ObtenerMensaje2 = Mensaje2.getText().trim();
        System.out.println(ObtenerMensaje2);
        String ExpectativaTexto2 = "La remesa esta en un estado inicial, no se puede aplicar un reverso.";
        Assert.assertEquals(ObtenerMensaje2, ExpectativaTexto2);
		
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		Aceptar2.click();
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
