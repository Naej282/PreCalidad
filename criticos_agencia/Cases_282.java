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

public class Cases_282 {

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
		
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
		
//		---------------------------Modificar Remesas en Agencia / Control de Remesas / Envíos------------------------------
		
		//RUTA PARA GRABAR LA PANTALLA--------------------------------------------------------------------
		
		String outputFile = ""+Constantes.RUTA_CAPTURES+"\\Criticos_Agencia\\Cases_282\\282.avi";
		String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 -video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" -offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
		ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//GENERAMOS UN NUMERO ALEATORIO--------------------------------------------------------------------------
		
		Random random = new Random();
		int GenerarNumeroAleatorio = random.nextInt(20001 - 10000) + 10000;
		String NumeroAleatorio = String.valueOf(GenerarNumeroAleatorio);
				
		//RUTA EXCEL--------------------------------------------------------------------------------------------
		
		String filepath = ""+Constantes.RUTA_EXCELJ+"\\MatrizCriticosAgencia.xlsx";	
		String TipoUnidadEmisora = readFile.getCellValue(filepath, "CriticosAgencia", 21, 1);
		String	UnidadEmisora = readFile.getCellValue(filepath, "CriticosAgencia", 21, 2);
		String	Transporte = readFile.getCellValue(filepath, "CriticosAgencia", 21, 5);
		
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
		NumeroDeServicio2.click();	    Thread.sleep(secDelay);
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
		WebElement SeleccionarRemesa = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa.click();		Thread.sleep(secDelay);
		WebElement Modificar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
		Modificar.click();	   Thread.sleep(secDelay);
			
		WebElement DesplegarEmpresaTransportista2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transportistaModificarE-trigger-picker")));
		DesplegarEmpresaTransportista2.click();
		List<WebElement> options4 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options4) {
            if (option.getText().equals(Transporte)) {
                option.click();
                break;
            
                }
            }		
						 
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1180-btnEl")));
		Aceptar2.click();	  Thread.sleep(secDelay);
		
		WebElement Mensaje1 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje1 = Mensaje1.getText().trim();
        System.out.println(ObtenerMensaje1);
        String ExpectativaTexto1 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje1, ExpectativaTexto1);
		
		WebElement AceptarInformacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarInformacion.click();
			
		//INGRESAMOS EN CENTRAL----------------------------------------------------------------------------------------------------------
		
		((JavascriptExecutor)driver).executeScript("window.open()");
	    String secondTab = driver.getWindowHandles().stream().skip(1).findFirst().get();
	    driver.switchTo().window(secondTab);
	    driver.get(Constantes.URL_CENTRAL);

		WebElement login2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login2.sendKeys(Constantes.USUARIO);	
		WebElement password2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password2.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);	
		WebElement logear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear2.click();	 Thread.sleep(secDelay);
		
		//INGRESAMOS EN EL APARTADO DE ENVIOS--------------------------------------------------------------------------------------------
		
		WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("img-menu")));
		Logistica.click();
		WebElement AdministracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
		AdministracionEfectivo.click();
		WebElement Envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
		Envio.click();	   Thread.sleep(secDelay);
		
		WebElement Filtros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros.click();	 Thread.sleep(secDelay);	
		WebElement NumeroDeServicioInput = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		NumeroDeServicioInput.click();
		NumeroDeServicioInput.sendKeys(NumeroAleatorio);	Thread.sleep(secDelay);
		WebElement ConsultarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
		ConsultarRemesa.click();	 Thread.sleep(secDelay);
		
		WebElement SeleccionRemesa = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1117']"));
		SeleccionRemesa.click();
		WebElement SeleccionarRemesa2 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1117']"));
	    Actions doble3 = new Actions(driver);
	    doble3.doubleClick(SeleccionarRemesa2).perform();		Thread.sleep(secDelay);
		
		WebElement AvanzarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnEl")));
		AvanzarRemesa.click();	   Thread.sleep(secDelay);	
		WebElement AceptarAvanzarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnEl")));
		AceptarAvanzarRemesa.click();	  Thread.sleep(secDelay);
		
		WebElement Mensaje2 = driver.findElement(By.id("messagebox-1027-msg"));
        String ObtenerMensaje2 = Mensaje2.getText().trim();
        System.out.println(ObtenerMensaje2);
        String ExpectativaTexto2 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje2, ExpectativaTexto2);
		
		WebElement AceptarInformacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		AceptarInformacion2.click();	 Thread.sleep(secDelay);
			
		//INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA
			
		Set<String> handles = driver.getWindowHandles();		
        for (String handle : handles) {
            if (driver.getCurrentUrl().equals(""+Constantes.URL_AGENCIA+"enviosControl.action")) {
                System.out.println("Estás en la página de Agencia");
            } else {
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Central");
            }
        }	Thread.sleep(secDelay);
	        
        WebElement Filtros1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros1.click();	
		WebElement Filtrar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnWrap")));
		Filtrar2.click();	  Thread.sleep(secDelay);		
	 			
		WebElement SeleccionarRemesa3 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa3.click();		Thread.sleep(secDelay);
		WebElement Modificar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
		Modificar2.click();		Thread.sleep(secDelay);
		
		WebElement Mensaje02 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje02 = Mensaje02.getText().trim();
        System.out.println(ObtenerMensaje02);
        String ExpectativaTexto02 = "No se puede modificar el envio en el estado en el que se encuentra";
        Assert.assertEquals(ObtenerMensaje02, ExpectativaTexto02);
        
		WebElement AceptarMensaje = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarMensaje.click();
				
		//INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA
				
		Set<String> handles2 = driver.getWindowHandles();	
		for (String handle : handles2) {
            if (driver.getCurrentUrl().equals(""+Constantes.URL_CENTRAL+"envioCentral.action")) {
                System.out.println("Estás en la página de Agencia");
            } else {
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Central");
            }
        }		Thread.sleep(secDelay);
			
        WebElement SeleccionarRemesa4 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1117']"));
		SeleccionarRemesa4.click();		Thread.sleep(secDelay);	
		WebElement AvanzarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnEl")));
		AvanzarRemesa2.click();		Thread.sleep(secDelay);
		WebElement AceptarAvanzarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnEl")));
		AceptarAvanzarRemesa2.click();	   Thread.sleep(secDelay);	
		WebElement AceptarConfirmacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnEl")));
		AceptarConfirmacion.click();	 Thread.sleep(secDelay);
		
		WebElement Mensaje3 = driver.findElement(By.id("messagebox-1027-msg"));
        String ObtenerMensaje3 = Mensaje3.getText().trim();
        System.out.println(ObtenerMensaje3);
        String ExpectativaTexto3 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje3, ExpectativaTexto3);
		
		WebElement Aceptarinformacion3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		Aceptarinformacion3.click();	 Thread.sleep(secDelay);
			
		//INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA---------------------------------------------------------
			
		Set<String> handles3 = driver.getWindowHandles();	
        for (String handle : handles3) {
            if (driver.getCurrentUrl().equals(""+Constantes.URL_AGENCIA+"enviosControl.action")) {
                System.out.println("Estás en la página de Agencia");
            } else {
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Central");
            }
        }
        WebElement Filtros2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros2.click();	
		WebElement Filtrar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnWrap")));
		Filtrar3.click();	  Thread.sleep(secDelay);		
				
		WebElement SeleccionarRemesa5 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa5.click();		Thread.sleep(secDelay);	
		WebElement Modificar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
		Modificar3.click();		Thread.sleep(secDelay);
		
		WebElement Mensaje03 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje03 = Mensaje03.getText().trim();
        System.out.println(ObtenerMensaje03);
        String ExpectativaTexto03 = "No se puede modificar el envio en el estado en el que se encuentra";
        Assert.assertEquals(ObtenerMensaje03, ExpectativaTexto03);
		
		WebElement AceptarMensaje2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarMensaje2.click();
			
		//INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA--------------------------------------------------------------------
			
		Set<String> handles4 = driver.getWindowHandles();
        for (String handle : handles4) {
            if (driver.getCurrentUrl().equals(""+Constantes.URL_CENTRAL+"envioCentral.action")) {
                System.out.println("Estás en la página de Agencia");
            } else {
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Central");
            }
        }		Thread.sleep(secDelay);
		
	    WebElement SeleccionarRemesa6 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1117']"));
		SeleccionarRemesa6.click();		Thread.sleep(secDelay);
		WebElement AvanzarRemesa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnEl")));
		AvanzarRemesa3.click();		Thread.sleep(secDelay);	
		WebElement AceptarAvanzarRemesa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnEl")));
		AceptarAvanzarRemesa3.click();	   Thread.sleep(secDelay);
		
		WebElement Mensaje4 = driver.findElement(By.id("messagebox-1027-msg"));
        String ObtenerMensaje4 = Mensaje4.getText().trim();
        System.out.println(ObtenerMensaje4);
        String ExpectativaTexto4 = "Registro modificado exitosamente";
        Assert.assertEquals(ObtenerMensaje4, ExpectativaTexto4);
		
		WebElement Aceptarinformacion4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		Aceptarinformacion4.click();	 Thread.sleep(secDelay);
			
		//INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA--------------------------------------------------------------------
			
		Set<String> handles5 = driver.getWindowHandles();
	    for (String handle : handles5) {
	        if (driver.getCurrentUrl().equals(""+Constantes.URL_AGENCIA+"enviosControl.action")) {
	            System.out.println("Estás en la página de Agencia");
	        } else {
	            driver.switchTo().window(handle);
	            System.out.println("Estás en la página de Central");
	        }
	    }
	    
	    WebElement Filtros3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros3.click();	
		WebElement Filtrar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnWrap")));
		Filtrar4.click();	  Thread.sleep(secDelay);				
		WebElement SeleccionarRemesa7 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1034']"));
		SeleccionarRemesa7.click();		Thread.sleep(secDelay);	
		WebElement Modificar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
		Modificar4.click();		Thread.sleep(secDelay);	
		WebElement AceptarMensaje3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		AceptarMensaje3.click();
			
		//INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE CENTRAL Y BUSCAMOS LA REMESA----------------------------------------------------------------------
			
		Set<String> handles6 = driver.getWindowHandles();
        for (String handle : handles6) {
            if (driver.getCurrentUrl().equals(""+Constantes.URL_CENTRAL+"envioCentral.action")) {
                System.out.println("Estás en la página de Agencia");
            } else {
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Central");
            }
        }		Thread.sleep(secDelay);
		
	    WebElement SeleccionarRemesa8 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1117']"));
		SeleccionarRemesa8.click();		Thread.sleep(secDelay);	
		WebElement AvanzarRemesa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnEl")));
		AvanzarRemesa4.click();		Thread.sleep(secDelay);	
		WebElement AceptarAvanzarRemesa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnEl")));
		AceptarAvanzarRemesa4.click();	   Thread.sleep(secDelay);	
		WebElement Aceptarinformacion5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		Aceptarinformacion5.click();	 Thread.sleep(secDelay);
			
		//INGRESAMOS NUEVAMENTE EN EL AMBIENTE DE AGENCIA Y BUSCAMOS LA REMESA------------------------------------------------------------------------
			
		Set<String> handles7 = driver.getWindowHandles();
        for (String handle : handles7) {
            if (driver.getCurrentUrl().equals(""+Constantes.URL_CENTRAL+"enviosControl.action")) {
                System.out.println("Estás en la página de Agencia");
            } else {
                driver.switchTo().window(handle);
                System.out.println("Estás en la página de Central");
            }
        }
        
        WebElement Retro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tool-1113-toolEl")));
        Retro.click();
        WebElement Filtros4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		Filtros4.click();	
		WebElement Filtrar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnInnerEl")));
		Filtrar5.click();	  Thread.sleep(secDelay);					
		WebElement SeleccionarRemesa9 = driver.findElement(By.cssSelector("[data-columnid='gridcolumn-1117']"));
		SeleccionarRemesa9.click();		Thread.sleep(secDelay);		
		WebElement Modificar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
		Modificar5.click();		Thread.sleep(secDelay);	
		
		WebElement Mensaje04 = driver.findElement(By.id("messagebox-1027-msg"));
        String ObtenerMensaje04 = Mensaje04.getText().trim();
        System.out.println(ObtenerMensaje04);
        String ExpectativaTexto04 = "El Envio no puede ser modificado porque al menos una de sus Remesas ha pasado por un estado que ha levantado al menos un evento.";
        Assert.assertEquals(ObtenerMensaje04, ExpectativaTexto04);
		
		WebElement AceptarMensaje4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		AceptarMensaje4.click();			 	
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
