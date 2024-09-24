package criticos_agencia;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
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

public class Cases_273 {

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
		
//		-------------------------------- Avance de Estado de Remesas en Agencia / Control de Remesas / Envíos--------------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_273\\273.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//RUTA EXCEL--------------------------------------------------------------------------------------------
		
		 String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
		 String TipoUnidadEmisora = readFile.getCellValue(filepath, "CriticosAgencia", 19, 1);
		 String	UnidadEmisora = readFile.getCellValue(filepath, "CriticosAgencia", 19, 2);
		 String	Transporte = readFile.getCellValue(filepath, "CriticosAgencia", 19, 5);
		
		//GENERAMOS UN NUMERO ALEATORIO--------------------------------------------------------------------------
		
		Random random = new Random();
		int GenerarNumeroAleatorio = random.nextInt(150001 - 80000) + 80000;
		String NumeroAleatorio = String.valueOf(GenerarNumeroAleatorio);
			
		
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
		//INGRESAMOS EN EL MODULO DE AGENCIA----------------------------------------------------------------------
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);

		//INGRESAMOS EN EL APARTADO DE ENVIOS----------------------------------------------------------------------
		
		WebElement ControlRemesas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remesas")));
		ControlRemesas.click();	
		WebElement Envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Envios")));
		Envios.click();
		
		//PROCEDEMOS A CREAR LA REMESA-----------------------------------------------------------------------------
		
		WebElement CrearRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
		CrearRemesa.click();	 Thread.sleep(secDelay);
		WebElement TipoEnviar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emisorCrear-inputEl")));
		TipoEnviar.click();
		
		//INGRESAMOS EN EL APARTADO DE ENVIOS-----------------------------------------------------------------------
		
		WebElement DesplegarTipoUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadCrear-trigger-picker")));
		DesplegarTipoUnidadEmisora.click();		Thread.sleep(secDelay);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options) {
            if (option.getText().equals(TipoUnidadEmisora)) {
                option.click();
                break;
            
                }
            }		Thread.sleep(secDelay);
		
		WebElement elemento2 = driver.findElement(DesplegarUnidadReceptora);
	 	elemento2.click();
	 	
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
		WebElement NumeroDeServicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl")));
		NumeroDeServicio.click();	   Thread.sleep(secDelay);
		NumeroDeServicio.sendKeys(NumeroAleatorio);
				
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
		WebElement elementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1115']")); 
	    Actions doble = new Actions(driver);
	    doble.doubleClick(elementoCantidad).perform();		Thread.sleep(secDelay);
	    List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30'], [id^='ext-element-'][id$='31']"));
	    for (WebElement elemento : elementos) {
	        if (elemento.isEnabled()) {
	            Actions actions = new Actions(driver);
	            actions.click(elemento).sendKeys("1").sendKeys(Keys.ENTER).perform();
	        }
	    }		Thread.sleep(secDelay);
	    
	    WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1133-btnWrap")));
    	Aceptar.click();	 Thread.sleep(secDelay);
		WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	 	ConfirmarAceptar.click();	  Thread.sleep(secDelay);
			
	 	//INGRESAMOS EN EL MODULO DE CENTRAL
	        
	    ((JavascriptExecutor)driver).executeScript("window.open()");
		
	    String secondTab = driver.getWindowHandles().stream().skip(1).findFirst().get();
	    driver.switchTo().window(secondTab);	    
	    driver.get(Constantes.URL_CENTRAL);

		WebElement loginCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		loginCentral.sendKeys(Constantes.USUARIO);		
		WebElement PasswordCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		PasswordCentral.sendKeys(Constantes.CONTRASEÑA);		Thread.sleep(secDelay);		
		WebElement logearCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logearCentral.click();	 Thread.sleep(secDelay);		
		
		//INGRESAMOS EN EL APARTADO DE ENVIO
		
		WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("img-menu")));
		Logistica.click();			
		WebElement AdministracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
		AdministracionEfectivo.click();				
		WebElement Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
		Envio.click();	   Thread.sleep(secDelay);
		
		//PRECEDEMOS A AVANZAR LAS REMESAS
				
		WebElement Filtros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros.click();	 Thread.sleep(secDelay);	
		WebElement NumeroDeServicioInput = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		NumeroDeServicioInput.click();
		NumeroDeServicioInput.sendKeys(NumeroAleatorio);
		WebElement ConsultarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
		ConsultarRemesa.click();	 Thread.sleep(secDelay);	
		WebElement SeleccionRemesa = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1068']"));
		SeleccionRemesa.click();		
		WebElement AvanzarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnEl")));
		AvanzarRemesa.click();	   Thread.sleep(secDelay);
		WebElement AceptarAvanzarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnEl")));
		AceptarAvanzarRemesa.click();	  Thread.sleep(secDelay);
		
		WebElement Mensaje2 = driver.findElement(By.id("messagebox-1027-msg"));
        String ObtenerMensaje2 = Mensaje2.getText().trim();
        System.out.println(ObtenerMensaje2);
        String ExpectativaTexto2 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje2, ExpectativaTexto2);
		
		WebElement AceptarInformacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		AceptarInformacion.click();
		
		//INGRESAMOS EN LA PESTAÑA ABIERTA DE CENTRAL
		
		Set<String> handles = driver.getWindowHandles();		
        for (String handle : handles) {
            if (driver.getCurrentUrl().equals(""+Constantes.URL_AGENCIA+"enviosControl.action")) {
                System.out.println("Estás en la página de Agencia");
            } else {
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Central");
            }
        }		Thread.sleep(secDelay);
	    	
        WebElement Consultas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
		Consultas.click();    		
		WebElement Filtros2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros2.click();	  Thread.sleep(secDelay);   
		WebElement Input = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		Input.click();
		Input.sendKeys(NumeroAleatorio);	Thread.sleep(secDelay);		
		WebElement Consulta2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnInnerEl")));
		Consulta2.click();	   Thread.sleep(secDelay);	
		WebElement SeleccionarRemesa2 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa2.click();		Thread.sleep(secDelay);
		WebElement AvanzarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnEl")));
		AvanzarRemesa2.click();		
		WebElement AceptarAvanzarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnEl")));
		AceptarAvanzarRemesa2.click();	
		WebElement ConfirmacionAvanzarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
		ConfirmacionAvanzarRemesa.click();	   Thread.sleep(secDelay);
			
		WebElement Mensaje = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje = Mensaje.getText().trim();
        System.out.println(ObtenerMensaje);
        String ExpectativaTexto = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
		
		WebElement InformacionAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
		InformacionAceptar.click();	
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