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

public class Cases_277 {

	int secDelay = 2000;
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
		
//		-----------------------------------Avance a estado alterno de Remesas en Agencia / Control de Remesas / Envíos-------------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_277\\277.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//RUTA EXCEL--------------------------------------------------------------------------------------------
		
		 String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
		 String TipoUnidadEmisora = readFile.getCellValue(filepath, "CriticosAgencia", 20, 1);
		 String	UnidadEmisora = readFile.getCellValue(filepath, "CriticosAgencia", 20, 2);
		 String	Transporte = readFile.getCellValue(filepath, "CriticosAgencia", 20, 5);

		//GENERAMOS UN NUMERO ALEATORIO--------------------------------------------------------------------------
		
		Random random = new Random();
		int GenerarNumeroAleatorio = random.nextInt(200001 - 100000) + 100000;
		String NumeroAleatorio = String.valueOf(GenerarNumeroAleatorio);
				
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
		
		//PROCEDEMOS A CREAR LA REMESA-----------------------------------------------------------------------------
		
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
		
		WebElement elementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1115']")); 
	    Actions doble = new Actions(driver);
	    doble.doubleClick(elementoCantidad).perform();		Thread.sleep(secDelay);
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
        String ObtenerMensaje = Mensaje.getText().trim();	Thread.sleep(secDelay);
        System.out.println(ObtenerMensaje);
        String ExpectativaTexto = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
    	
		WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
	 	ConfirmarAceptar.click();	  Thread.sleep(secDelay);
			
	 	//INGRESAMOS EN EL AMBIENTE DE CENTRAL----------------------------------------------------------------------------------
			 	
	 	((JavascriptExecutor)driver).executeScript("window.open()");
			
	    String secondTab = driver.getWindowHandles().stream().skip(1).findFirst().get();
	    driver.switchTo().window(secondTab);   
	    driver.get(Constantes.URL_CENTRAL);
	    
	    WebElement loginCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		loginCentral.sendKeys(Constantes.USUARIO);	
		WebElement PasswordCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		PasswordCentral.sendKeys(Constantes.CONTRASEÑA);		Thread.sleep(secDelay);
		WebElement LogearCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		LogearCentral.click();	   Thread.sleep(secDelay);
		
		//INGRESAR EN EL APARTADO DE ENVIO---------------------------------------------------------------------------------------
		
		WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("img-menu")));
		Logistica.click();				
		WebElement AdministracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
		AdministracionEfectivo.click();						
		WebElement Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
		Envio.click();	   Thread.sleep(secDelay);
		
		//CONSULTAMOS LA REMESA
			
		WebElement Filtros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros.click();	 Thread.sleep(secDelay);	
		WebElement NumeroDeServicioInput = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		NumeroDeServicioInput.click();
		NumeroDeServicioInput.sendKeys(NumeroAleatorio);
		WebElement ConsultarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
		ConsultarRemesa.click();	 Thread.sleep(secDelay);
		
		//PROCEDEMOS A AVANZAR LA REMESA----------------------------------------------------------------------------------------------
							
		//Avanzamos a Aprovado 
		
		WebElement SeleccionRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1117']")));
		SeleccionRemesa.click();	 Thread.sleep(secDelay);	
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
		AceptarInformacion.click();		Thread.sleep(secDelay);			
		
		WebElement QuitarDesplegar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tool-1113-toolEl")));
		QuitarDesplegar.click();	 Thread.sleep(secDelay);			
		WebElement Filtros2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros2.click();	  Thread.sleep(secDelay);			
		WebElement ConsultarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnInnerEl")));
		ConsultarRemesa2.click();	  Thread.sleep(secDelay);		
		
		//Avanzamos a Despachado
		
		WebElement SeleccionarRemesa3 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1065']"));
		SeleccionarRemesa3.click();		Thread.sleep(secDelay);				
		WebElement AvanzarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnEl")));
		AvanzarRemesa2.click();					
		WebElement AceptarAvanzarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnEl")));
		AceptarAvanzarRemesa2.click();
		WebElement ConfirmacionAvanzarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnWrap")));
		ConfirmacionAvanzarRemesa.click();	   Thread.sleep(secDelay);
		
		WebElement Mensaje3 = driver.findElement(By.id("messagebox-1027-msg"));
        String ObtenerMensaje3 = Mensaje3.getText().trim();
        System.out.println(ObtenerMensaje3);
        String ExpectativaTexto3 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje3, ExpectativaTexto3);
		
		WebElement InformacionAvanzarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		InformacionAvanzarRemesa.click();
				
		//INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA-------------------------------------------------------------
				
		Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (driver.getCurrentUrl().equals(""+Constantes.URL_AGENCIA+"enviosControl.action")) {
                System.out.println("Estás en la página de Agencia");
            } else {
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Central");
            }
        }		Thread.sleep(secDelay);
	        
        WebElement Filtros1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros1.click();				
		WebElement Receptor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadRConsulta-inputEl")));
		Receptor.click();	  Thread.sleep(secDelay);
		WebElement input1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		input1.click();		Thread.sleep(secDelay);
		input1.sendKeys(NumeroAleatorio);		Thread.sleep(secDelay);			
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnInnerEl")));
		Consultar.click();	   Thread.sleep(secDelay);
				
		//Avanzamos a Atracado
				
		WebElement SeleccionarRemesa4 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa4.click();		Thread.sleep(secDelay);			
		WebElement AvanzarEstadoAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnEl")));
		AvanzarEstadoAlterno.click();			
		WebElement DesplegarEstadoAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
		DesplegarEstadoAlterno.click();		Thread.sleep(secDelay);
		WebElement EstadoAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Atracado']")));
		EstadoAlterno.click();
		WebElement AceptarEstadoAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnEl")));
		AceptarEstadoAlterno.click();	  Thread.sleep(secDelay);
		
		WebElement Mensaje4 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje4 = Mensaje4.getText().trim();
        System.out.println(ObtenerMensaje4);
        String ExpectativaTexto4 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje4, ExpectativaTexto4);
		
		WebElement InformacionAceptarEstadoAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
		InformacionAceptarEstadoAlterno.click();	 Thread.sleep(secDelay);
		
		//Reversamos a Despachado
		
		WebElement Filtros3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros3.click();	  Thread.sleep(secDelay);			
		WebElement Consultar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnInnerEl")));
		Consultar1.click();		Thread.sleep(secDelay);			
		WebElement SeleccionarRemesa5 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa5.click();		Thread.sleep(secDelay);	
		WebElement Reversar = driver.findElement(By.id("reversar-btnEl"));
		Reversar.click();	
		WebElement AceptarReversar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnEl")));
		AceptarReversar.click();     Thread.sleep(secDelay);
		
		WebElement Mensaje5 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje5 = Mensaje5.getText().trim();
        System.out.println(ObtenerMensaje5);
        String ExpectativaTexto5 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje5, ExpectativaTexto5);
		
		WebElement AceptarInformacion3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarInformacion3.click();
		WebElement Filtros5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros5.click();	  Thread.sleep(secDelay);
		WebElement Consultar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnInnerEl")));
		Consultar3.click();		Thread.sleep(secDelay);
			
		//Avanzamos a Devuelto
			
		WebElement SeleccionarRemesa6 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa6.click();		Thread.sleep(secDelay);
		WebElement AvanzarEstadoAlterno2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnEl")));
		AvanzarEstadoAlterno2.click();	   Thread.sleep(secDelay);	
		WebElement DesplegarEstadoAlterno2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
		DesplegarEstadoAlterno2.click();	 Thread.sleep(secDelay);	
		WebElement EstadoAlterno2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Devuelto']")));
		EstadoAlterno2.click();		Thread.sleep(secDelay);	
		WebElement AceptarEstadoAlterno2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnEl")));
		AceptarEstadoAlterno2.click();     Thread.sleep(secDelay);
		
		WebElement Mensaje6 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje6 = Mensaje6.getText().trim();Thread.sleep(secDelay);
        System.out.println(ObtenerMensaje6);
        String ExpectativaTexto6 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje6, ExpectativaTexto6);
        
		WebElement InformacionAceptarEstadoAlterno2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
		InformacionAceptarEstadoAlterno2.click();	  Thread.sleep(secDelay);
		
		WebElement Filtros4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros4.click();Thread.sleep(secDelay);
		WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnInnerEl")));
		Consultar2.click();		Thread.sleep(secDelay);
		
		//Reversamos a Despachado
		
		WebElement SeleccionarRemesa7 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa7.click();		Thread.sleep(secDelay);	
		WebElement Reversar2 = driver.findElement(By.id("reversar-btnEl"));
		Reversar2.click();	
		WebElement AceptarReversar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnEl")));
		AceptarReversar2.click();     Thread.sleep(secDelay);
		
		WebElement Mensaje7 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje7 = Mensaje7.getText().trim();
        System.out.println(ObtenerMensaje7);
        String ExpectativaTexto7 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje7, ExpectativaTexto7);
        
		WebElement AceptarInformacion01 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarInformacion01.click();	  Thread.sleep(secDelay);

		//Avanzamos a Recibido
		
		WebElement Filtros6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros6.click();	  Thread.sleep(secDelay);	
		WebElement Consultar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnInnerEl")));
		Consultar4.click();		Thread.sleep(secDelay);	
		WebElement SeleccionarRemesa8 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa8.click();		Thread.sleep(secDelay);
		WebElement AvanzarEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnEl")));
		AvanzarEstado.click();	   Thread.sleep(secDelay);
		WebElement AceptarAvanzarEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnEl")));
		AceptarAvanzarEstado.click();     Thread.sleep(secDelay);
		
		WebElement Mensaje8 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje8 = Mensaje8.getText().trim();
        System.out.println(ObtenerMensaje8);
        String ExpectativaTexto8 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje8, ExpectativaTexto8);
		
		WebElement AceptarInformacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarInformacion2.click();
			
		//Avanzamos a Confirmado Ajuste Faltante
			
		WebElement Filtros7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros7.click();		
		WebElement Consultar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnInnerEl")));
		Consultar5.click();		Thread.sleep(secDelay);		
		WebElement SeleccionarRemesa9 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa9.click();		Thread.sleep(secDelay);
		WebElement AvanzarEstadoAlterno3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnEl")));
		AvanzarEstadoAlterno3.click();     Thread.sleep(secDelay);
		WebElement DesplegarEstadoAlterno3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
		DesplegarEstadoAlterno3.click();	 Thread.sleep(secDelay);		
		WebElement EstadoAlterno3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Confirmado Ajuste Faltante']")));
		EstadoAlterno3.click();		Thread.sleep(secDelay);			
		WebElement AceptarEstadoAlterno3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnEl")));
		AceptarEstadoAlterno3.click();	
		WebElement DesplegarDenominacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantes-trigger-picker")));
		DesplegarDenominacion.click();	   Thread.sleep(secDelay);			
		WebElement Denominacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DENOMINACION+"']")));
		Denominacion.click();
		WebElement DesplegarTipoClasificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoClasificacionFaltantes-trigger-picker")));
		DesplegarTipoClasificacion.click();		Thread.sleep(secDelay);		
		WebElement TipoClasificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.APTOS+"']")));
		TipoClasificacion.click();		
		WebElement Cantidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantes-inputEl")));
		Cantidad.click();
		Thread.sleep(secDelay);
		Cantidad.sendKeys("1");	
		WebElement Incluir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1063-btnEl")));
		Incluir2.click();	  Thread.sleep(secDelay);			
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar-btnWrap")));
		Aceptar2.click();     Thread.sleep(secDelay);
		
		WebElement Mensaje10 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje10 = Mensaje10.getText().trim();
        System.out.println(ObtenerMensaje10);
        String ExpectativaTexto10 = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje10, ExpectativaTexto10);
		
		WebElement AceptarInformacion5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarInformacion5.click();	 Thread.sleep(secDelay);		
		
		WebElement Filtros8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros8.click();	  Thread.sleep(secDelay);				
		WebElement Consultar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnInnerEl")));
		Consultar6.click();		Thread.sleep(secDelay);
		
		//Reversamos para Recibido
		
		WebElement SeleccionarRemesa10 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa10.click();	 Thread.sleep(secDelay);		
		WebElement Reversar3 = driver.findElement(By.id("reversar-btnEl"));
		Reversar3.click();			
		WebElement AceptarReversar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnEl")));
		AceptarReversar3.click();     Thread.sleep(secDelay);
		
		WebElement Mensaje11 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje11 = Mensaje11.getText().trim();Thread.sleep(secDelay);
        System.out.println(ObtenerMensaje11);
        String ExpectativaTexto11 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje11, ExpectativaTexto11);
		
		WebElement AceptarInformacion4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarInformacion4.click();	 Thread.sleep(secDelay);
					
		WebElement Filtros9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros9.click();	  Thread.sleep(secDelay);			
		WebElement Consultar7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnInnerEl")));
		Consultar7.click();		Thread.sleep(secDelay);
				
		//Avanzamos a Confirmado Ajuste Sobrante
				
		WebElement SeleccionarRemesa11 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa11.click();	 Thread.sleep(secDelay);	
		WebElement AvanzarEstadoAlterno4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnEl")));
		AvanzarEstadoAlterno4.click();
		WebElement DesplegarEstadoAlterno4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
		DesplegarEstadoAlterno4.click();	 Thread.sleep(secDelay);		
		WebElement EstadoAlterno4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Confirmado Ajuste Sobrante']")));
		EstadoAlterno4.click();		Thread.sleep(secDelay);		
		WebElement AceptarEstadoAlterno4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnEl")));
		AceptarEstadoAlterno4.click();	   Thread.sleep(secDelay);
		
		WebElement DenominacionSobrantes = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionSobrantes-trigger-picker")));
		DenominacionSobrantes.click();	   Thread.sleep(secDelay);
		List<WebElement> options4 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options4) {
            if (option.getText().equals(Constantes.DENOMINACION)) {
                option.click();
                break;
            
	            }
	        };Thread.sleep(secDelay);
	        
        WebElement TipoClasificacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoClasificacionSobrantes-trigger-picker")));
		TipoClasificacion2.click();	   Thread.sleep(secDelay);
		List<WebElement> options5 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options5) {
            if (option.getText().equals(Constantes.APTOS)) {
                option.click();
                break;
            
	            }
	        };Thread.sleep(secDelay);
				

		WebElement Cantidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadSobrantes-inputEl")));
		Cantidad2.click();
		Thread.sleep(secDelay);
		Cantidad2.sendKeys("1");			
		WebElement Incluir3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1052-btnEl")));
		Incluir3.click();	  Thread.sleep(secDelay);			
		WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar-btnWrap")));
		Aceptar3.click();     Thread.sleep(secDelay);
		
		WebElement Mensaje12 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje12 = Mensaje12.getText().trim();
        System.out.println(ObtenerMensaje12);
        String ExpectativaTexto12 = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje12, ExpectativaTexto12);
		
		WebElement AceptarInformacion6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarInformacion6.click();	 Thread.sleep(secDelay);
		
		driver.navigate().refresh();Thread.sleep(secDelay);
				
		WebElement Filtros10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros10.click();	   Thread.sleep(secDelay);
		WebElement Receptor2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadRConsulta-inputEl")));
		Receptor2.click();
		WebElement NumeroDeServicioInput2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		NumeroDeServicioInput2.click();
		NumeroDeServicioInput2.sendKeys(NumeroAleatorio);
		WebElement Consultar8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1086-btnInnerEl")));
		Consultar8.click();		Thread.sleep(secDelay);
		
		//Reversamos a Recibido
		
		WebElement SeleccionarRemesa12 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa12.click();	 Thread.sleep(secDelay);
		WebElement Reversar4 = driver.findElement(By.id("reversar-btnEl"));
		Reversar4.click();		
		WebElement AceptarReversar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnEl")));
		AceptarReversar4.click();     Thread.sleep(secDelay);
		
		WebElement Mensaje13 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje13 = Mensaje13.getText().trim();
        System.out.println(ObtenerMensaje13);
        String ExpectativaTexto13 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje13, ExpectativaTexto13);
		
		WebElement AceptarInformacion7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarInformacion7.click();	 Thread.sleep(secDelay);		
				
		//Avanzamos a Confimado Ajuste Detalle

		WebElement Filtros11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros11.click();	   Thread.sleep(secDelay);			
		WebElement Consultar9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1086-btnInnerEl")));
		Consultar9.click();		Thread.sleep(secDelay);	
		
		WebElement SeleccionarRemesa13 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa13.click();	 Thread.sleep(secDelay);			
		WebElement AvanzarEstadoAlterno5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnEl")));
		AvanzarEstadoAlterno5.click();				
		WebElement DesplegarEstadoAlterno5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
		DesplegarEstadoAlterno5.click();	 Thread.sleep(secDelay);				
		WebElement EstadoAlterno5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Confirmado Ajuste Detalle']")));
		EstadoAlterno5.click();		Thread.sleep(secDelay);
		WebElement AceptarEstadoAlterno5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnInnerEl")));
		AceptarEstadoAlterno5.click();        
       //Ajuste Detalle Sobrante
		
		WebElement DenominacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionSobrantes-trigger-picker")));
		DenominacionSobrante.click();
		List<WebElement> options6 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options6) {
            if (option.getText().equals(Constantes.DENOMINACION2)) {
                option.click();
                break;
            
	            }
	        };Thread.sleep(secDelay);
       		 
        WebElement ClasificacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoClasificacionSobrantes-trigger-picker")));
		ClasificacionSobrante.click();	   Thread.sleep(secDelay);
		List<WebElement> options7 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options7) {
            if (option.getText().equals(Constantes.APTOS)) {
                option.click();
                break;
            
	            }
	        };Thread.sleep(secDelay);
    		 
		WebElement Cantidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadSobrantes-inputEl")));
		Cantidad3.click();		Thread.sleep(secDelay);
		Cantidad3.sendKeys("2");		
		WebElement Incluir4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1052-btnEl")));
		Incluir4.click();	  Thread.sleep(secDelay);

		//Ajuste Destalle Faltante
				
				
		WebElement DenominacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantes-trigger-picker")));
		DenominacionFaltante.click();
		List<WebElement> options8 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options8) {
            if (option.getText().equals(Constantes.DENOMINACION)) {
                option.click();
                break;
            
	            }
	        };Thread.sleep(secDelay);

        WebElement ClasificacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoClasificacionFaltantes-trigger-picker")));
		ClasificacionFaltante.click();	   Thread.sleep(secDelay);
		List<WebElement> options9 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options9) {
            if (option.getText().equals(Constantes.APTOS)) {
                option.click();
                break;
            
	            }
	        };Thread.sleep(secDelay);
	    		 
		WebElement Cantidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantes-inputEl")));
		Cantidad4.click();
		Thread.sleep(secDelay);
		Cantidad4.sendKeys("1");
					
		WebElement Incluir5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1063-btnEl")));
		Incluir5.click();	  Thread.sleep(secDelay);			
		WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar-btnWrap")));
		Aceptar4.click();     Thread.sleep(secDelay);
		
		WebElement Mensaje15 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje15 = Mensaje15.getText().trim();
        System.out.println(ObtenerMensaje15);
        String ExpectativaTexto15 = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje15, ExpectativaTexto15);
		
		WebElement AceptarInformacion8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarInformacion8.click();	 Thread.sleep(secDelay);		
		
		WebElement Filtros12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros12.click();	   Thread.sleep(secDelay);				
		WebElement Consultar10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1086-btnInnerEl")));
		Consultar10.click();	 Thread.sleep(secDelay);
		
		//Reversamos a Recibido
		
		WebElement SeleccionarRemesa14 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa14.click();	 Thread.sleep(secDelay);
		WebElement Reversar5 = driver.findElement(By.id("reversar-btnEl"));
		Reversar5.click();			
		WebElement AceptarReversar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnEl")));
		AceptarReversar5.click();     Thread.sleep(secDelay);
		
		WebElement Mensaje16 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje16 = Mensaje16.getText().trim(); Thread.sleep(secDelay);
        System.out.println(ObtenerMensaje16);
        String ExpectativaTexto16 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje16, ExpectativaTexto16);
						
		WebElement AceptarInformacion9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarInformacion9.click();
        		
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
