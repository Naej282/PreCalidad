package Integrales;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constantes.Constante_PreCalidad;
import DataDrivenTesting.ReadExcelFile;
import DataDrivenTesting.WriteExcelFile;

public class Cases_356 {
	
	int secDelay = 2000;
	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	private By DesplegarUnidadReceptora = By.id("unidadCrear-trigger-picker");
	private By escribirTipoUnidadEmisoraLocator = By.id("tipoUnidadEmisoraCrear-inputEl");
	private By escribirUnidadEmisoraLocator = By.id("unidadEmisoraCrear-inputEl");				
	private By escribirTipoUnidadReceptoraLocator = By.id("tipoUnidadReceptoraCrear-inputEl");	
	private By escribirUnidadReceptoraLocator = By.id("unidadReceptoraCrear-inputEl");
	private By escribirEmpresaTransportistaLocator = By.id("transportistaCrear-inputEl");

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		
		driver.get("http://192.168.2.214:8901/Central/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InterruptedException {
		
		// ---------- Pre solicitado ----------
		
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
						
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String Agencia = "http://192.168.2.214:8901/Agencia/";
		String Central = "http://192.168.2.214:8901/Central/";
		
		String directorioCapturas = "C:/Users/gsarmiento/Desktop/Cases Integrales - Automatización/Cases 356";
		
	 	String nombreArchivo1 = "CambioParametroSi.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "ReversarAgencia.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
	 	
		String nombreArchivo3 = "AvanceAlternoAgencia.png";
	 	String captura3 = directorioCapturas + "/" + nombreArchivo3;
	 	
		String nombreArchivo4 = "AvanceNormalAgencia.png";
	 	String captura4 = directorioCapturas + "/" + nombreArchivo4;
	 	
	 	String nombreArchivo5 = "AvanceNormalCentral.png";
	 	String captura5 = directorioCapturas + "/" + nombreArchivo5;
	 	
	 	String nombreArchivo6 = "AvanceAlternoCentral.png";
	 	String captura6 = directorioCapturas + "/" + nombreArchivo6;
	 	
	 	String nombreArchivo7 = "AvanceMasivoCentral.png";
	 	String captura7 = directorioCapturas + "/" + nombreArchivo7;
	 	
	 	String nombreArchivo8 = "ReversoCentral.png";
	 	String captura8 = directorioCapturas + "/" + nombreArchivo8;
	 	
		String nombreArchivo9 = "CambioParametroNo.png";
	 	String captura9 = directorioCapturas + "/" + nombreArchivo9;
	 	
		String nombreArchivo10 = "RemesaSolicitado.png";
	 	String captura10 = directorioCapturas + "/" + nombreArchivo10;
		
		WebElement loginCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginCentral.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordCentral.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
	    WebElement enterCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterCentral.click();
	    
	    WebElement configuración = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
	    configuración.click();
        WebElement Generales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("generales")));
        Generales.click();
        WebElement ParametrosGenerales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("parametroGeneral")));
        ParametrosGenerales.click();
        WebElement Modificables = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-1026-btnWrap")));
        Modificables.click();
        
        // Configurar Parametro
        
        WebElement Presolicitud = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PRESOLICITUD']")));
        Presolicitud.click();
        WebElement ModificarPresolicitud = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
        ModificarPresolicitud.click();
        
        WebElement ModificarValor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    Thread.sleep(secDelay);
	    String Valor = ModificarValor.getAttribute("value");
	    Thread.sleep(secDelay);	    
	    System.out.println(Valor);
	    ModificarValor.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
	    ModificarValor.sendKeys("SI"); 
	    
	    File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo, new File(captura1));
	    
	    WebElement AceptarModificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnWrap")));
        AceptarModificación.click();
        WebElement ConfirmarModificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
        ConfirmarModificación.click();
        WebElement AceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarMensajeInformativo.click();
        
        // Cambio Agencia - Remesa
        
        js.executeScript("window.open(arguments[0]);", Agencia);	  
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	    String ModuloAgencia = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(ModuloAgencia);	 
        
	    WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
	    WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterAgencia.click();
	    
	    WebElement ControlRemesas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remesas")));
	    ControlRemesas.click();
	    WebElement EnviosAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Envios")));
	    EnviosAgencia.click();
	    
	    WebElement crearenvios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
	    crearenvios.click(); 
	    WebElement desplegarTipoUnidadReceptora1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadCrear-trigger-picker")));
	    desplegarTipoUnidadReceptora1.click();
	    WebElement seleccionarTipoUnidadReceptora1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agencia']")));
	    seleccionarTipoUnidadReceptora1.click();
	    Thread.sleep(secDelay);	  
	    WebElement desplegarUnidadReceptoraEnvio = driver.findElement(DesplegarUnidadReceptora);
	    desplegarUnidadReceptoraEnvio.click(); 
	    WebElement desplegarUnidadReceptora1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadCrear")));
	    desplegarUnidadReceptora1.click();  
	    Thread.sleep(secDelay);
	    WebElement seleccionarUnidadReceptora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1100 - AG PA 1']")));
	    seleccionarUnidadReceptora.click();
	    Thread.sleep(secDelay);
	    WebElement desplegarTransportista = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transportistaCrear-trigger-picker")));
	    desplegarTransportista.click();  
	    WebElement seleccionarTransportista = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='TRANSPORTISTA PA 1']")));
	    seleccionarTransportista.click();
	    Thread.sleep(secDelay);
	    WebElement desplegarTipoEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvioCrear-trigger-picker")));
	    desplegarTipoEnvio.click();  
	    WebElement seleccionarTipoEnvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pos. Propia']")));
	    seleccionarTipoEnvio.click();
	    
	    WebElement botonSiguiente = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnWrap")));
	    botonSiguiente.click();
	    Thread.sleep(secDelay);
	    
	    WebElement desplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
	    desplegarDivisa.click();
	    WebElement elementoDolar = driver.findElement(By.xpath("//li[text()='Dólar']"));
	    elementoDolar.click();
	        
	    Random rand = new Random();
	    int numeroAleatorio = rand.nextInt(1000000) + 1000000000;
	    String numeroTexto = Integer.toString(numeroAleatorio);
	    WebElement numeroServicioAleatorio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl"))); 
	    numeroServicioAleatorio.sendKeys(String.valueOf(numeroTexto)); 
	    System.out.println("El Cataporte es: " + numeroTexto);
	        
	    WebElement destinoDesplegar = driver.findElement(By.id("destinoCrear-trigger-picker"));
	    if (destinoDesplegar.isEnabled()) {
	       	destinoDesplegar.click();
	    } else {
	    }
	    Thread.sleep(secDelay);

	    try {
	    WebElement destinoSeleccionar = driver.findElement(By.xpath("//li[text()='Boveda']"));
	    destinoSeleccionar.click();
	    } catch (NoSuchElementException e){
	    }
	     
	    Thread.sleep(secDelay);
	     
	    WebElement botonIncluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear-btnWrap")));
        botonIncluir.click();
        Thread.sleep(secDelay);
        WebElement desplegarTipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvaseCrear-trigger-picker")));
        desplegarTipoEnvase.click();
        WebElement seleccionarTipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bolsa']")));
        seleccionarTipoEnvase.click();
        WebElement desplegarTipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
        desplegarTipoPieza.click();
        WebElement seleccionarTipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete']")));
        seleccionarTipoPieza.click();
        WebElement colocarCantidadEnvases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
        colocarCantidadEnvases.sendKeys("1");
        WebElement botonIncluirEnvases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear-btnWrap")));
        botonIncluirEnvases.click();
        WebElement colocarNumeroPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
        colocarNumeroPlomos.sendKeys("1");
        WebElement botonIncluirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnIconEl")));
        botonIncluirPlomos.click();
        
        WebElement elementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1115']")); //En 2.6 es 1163 y en 2.5 es 1161
        Actions doble = new Actions(driver);
        doble.doubleClick(elementoCantidad).perform();
        
        List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));
        boolean elementoEncontrado = false;
        for (WebElement elemento : elementos) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elementoCantidad).sendKeys("4").sendKeys(Keys.ENTER).perform();
                elementoEncontrado = true;
                break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
            }
        }
        if (!elementoEncontrado) {
            System.out.println("Ninguno de los elementos está habilitado.");
            // Puedes manejar esta situación según tus necesidades, por ejemplo, lanzar una excepción
            
        }
        	        	   	
        WebElement Denominación_50 = driver.findElement(By.xpath("//div[text()='50,000']"));
            
        Actions actions2 = new Actions(driver);
            
        actions2.moveToElement(Denominación_50).perform();

        Denominación_50.click(); 	
        
        actions2.sendKeys(Denominación_50, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys("10").sendKeys(Keys.ENTER).build().perform();
        
        Thread.sleep(secDelay);
        WebElement aceptarCreacionRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1133-btnWrap")));
        aceptarCreacionRemesa.click();
        Thread.sleep(secDelay);
   	        
        WebElement mensajeConfirmacion = driver.findElement(By.id("container-1003-innerCt"));
        String texto = mensajeConfirmacion.getText();
        System.out.println("La creacion Fue: " + texto);
     
        Thread.sleep(secDelay);
        WebElement aceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        aceptarMensajeInformativo.click();

        // Buscar Remesa Agencia
       	         
        WebElement filtros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
        filtros.click();       
        WebElement Agrupacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadRConsulta-inputEl")));
        Agrupacion.click();
        WebElement campoNroServicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
        campoNroServicio.sendKeys(numeroTexto);
        Thread.sleep(secDelay);
        WebElement consultarFiltros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1174-btnWrap")));
        consultarFiltros.click();
        Thread.sleep(secDelay);
        
        WebElement SelectRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
        SelectRemesa.click();
        
        WebElement BotonReversar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
        BotonReversar.click();
        Thread.sleep(secDelay);
        
	    File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));
        
        WebElement AceptarMsjInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarMsjInformativo.click();
        
        WebElement BotonAvanceAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnWrap")));
        BotonAvanceAlterno.click();
        Thread.sleep(secDelay);
        
        File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo3, new File(captura3));
               
        WebElement AceptarMsjInformativo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarMsjInformativo2.click();
        
        WebElement BotonAvanceEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnWrap")));
        BotonAvanceEstado.click();
        Thread.sleep(secDelay);
        
        File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo4, new File(captura4));
        
        WebElement AceptarMsjInformativo3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarMsjInformativo3.click();
        
        // Cambio Central - Remesa
        
        js.executeScript("window.open(arguments[0]);", Central);	  
	    
	    Set<String> handles2 = driver.getWindowHandles();
	    
	    String ModuloCentral = (String) handles2.toArray()[handles2.size() - 1];
	    driver.switchTo().window(ModuloCentral);
        
	    WebElement loginCentral2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginCentral2.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordCentral2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordCentral2.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
	    WebElement enterCentral2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterCentral2.click();
        
	    WebElement logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
	    logistica.click();
	    WebElement administracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
	    administracionEfectivo.click();
	    WebElement envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
	    envios.click(); 
	    
	    WebElement filtrosCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
        filtrosCentral.click();
        WebElement campoNroServicioCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
        campoNroServicioCentral.sendKeys(numeroTexto);
        Thread.sleep(secDelay);
        WebElement consultarFiltrosCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
        consultarFiltrosCentral.click();
        Thread.sleep(secDelay);
        
        WebElement seleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesa.click();
        Thread.sleep(secDelay);
        WebElement botonAvance = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvance.click();
        Thread.sleep(secDelay);
	    
        File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo5, new File(captura5));
        
        WebElement AceptarMsjInformativo4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
        AceptarMsjInformativo4.click();
        
        WebElement botonAvanceAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnWrap")));
        botonAvanceAlterno.click();
        Thread.sleep(secDelay);
        
        File archivo6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo6, new File(captura6));
               
        WebElement AceptarMsjInformativo5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
        AceptarMsjInformativo5.click();
        
        WebElement botonAvanceMasivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanceMasivo-btnWrap")));
        botonAvanceMasivo.click();
        Thread.sleep(secDelay);
        
        File archivo7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo7, new File(captura7));
               
        WebElement AceptarMsjInformativo6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
        AceptarMsjInformativo6.click();
                
        WebElement BotonReversar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
        BotonReversar1.click();
        Thread.sleep(secDelay);
        
	    File archivo8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo8, new File(captura8));
        
        WebElement AceptarMsjInformativo7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
        AceptarMsjInformativo7.click();
        
        // Cambio Agencia - Remesa
        
        String VolveAgencia = (String) handles2.toArray()[handles2.size() - 2];
	    driver.switchTo().window(VolveAgencia);
        
	    WebElement BotonAutorizarSolicitud = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autorizarSolicitud-btnWrap")));
        BotonAutorizarSolicitud.click();
        
        WebElement desplegarAvanzarEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
        desplegarAvanzarEstado.click();
        
        WebElement seleccionarEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Solicitado']")));
        seleccionarEstado.click();
        
        WebElement aceptarSolicitud = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAutorizarSolicitud-btnWrap")));
        aceptarSolicitud.click();
              
        WebElement confirmarModificacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        confirmarModificacion.click();
        Thread.sleep(secDelay);
        
        WebElement SelectRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
        SelectRemesa2.click();
        
        WebElement botonAvanceAlterno2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnWrap")));
        botonAvanceAlterno2.click();
        
        WebElement AceptarAvanceAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnWrap")));
        AceptarAvanceAlterno.click();
        
        WebElement AceptarRechazo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarRechazo.click();
        Thread.sleep(secDelay);
        
        WebElement SelectRemesa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
        SelectRemesa3.click();	   Thread.sleep(secDelay);
        
        WebElement BotonReversar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
        BotonReversar3.click();	    Thread.sleep(secDelay);
        
        WebElement AceptarRerverso = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnWrap")));
        AceptarRerverso.click();
        
        WebElement ConfirmarReverso = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        ConfirmarReverso.click();
        Thread.sleep(secDelay);
        
        WebElement SelectRemesa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
        SelectRemesa4.click();
        
        WebElement BotonAutorizarSolicitud2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autorizarSolicitud-btnWrap")));
        BotonAutorizarSolicitud2.click();
        
        WebElement desplegarAvanzarEstado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
        desplegarAvanzarEstado2.click();
        
        WebElement seleccionarEstado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Rechazado']")));
        seleccionarEstado2.click();
        
        WebElement aceptarSolicitud2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAutorizarSolicitud-btnWrap")));
        aceptarSolicitud2.click();
              
        WebElement confirmarModificacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        confirmarModificacion2.click();
        Thread.sleep(secDelay);
        
        // Cambio Central - Parametros
        
        String VolverCentral = (String) handles2.toArray()[handles2.size() - 3];
	    driver.switchTo().window(VolverCentral);
        
	    WebElement Presolicitud2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PRESOLICITUD']")));
        Presolicitud2.click();
        WebElement ModificarPresolicitud2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
        ModificarPresolicitud2.click();
        
        WebElement ModificarValor2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    Thread.sleep(secDelay);	 
	    ModificarValor2.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
	    ModificarValor2.sendKeys(Valor); 
	    Thread.sleep(secDelay);
	    
	    File archivo9 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo9, new File(captura9));
        
	    WebElement AceptarModificación2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnWrap")));
        AceptarModificación2.click();
        WebElement ConfirmarModificación2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
        ConfirmarModificación2.click();
        WebElement AceptarMensajeInformativo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarMensajeInformativo2.click();
	    
        driver.navigate().refresh();
        
              
        // Cambio Agencia - Remesa 2
        
	    String ModuloAgencia2 = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(ModuloAgencia2);	 
	    
	    driver.navigate().refresh();
	    
	    WebElement crearenvios2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
	    crearenvios2.click(); 
	    WebElement desplegarTipoUnidadReceptora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadCrear-trigger-picker")));
	    desplegarTipoUnidadReceptora2.click();
	    WebElement seleccionarTipoUnidadReceptora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agencia']")));
	    seleccionarTipoUnidadReceptora2.click();
	    Thread.sleep(secDelay);	  
	    WebElement desplegarUnidadReceptoraEnvio2 = driver.findElement(DesplegarUnidadReceptora);
	    desplegarUnidadReceptoraEnvio2.click(); 
	    WebElement desplegarUnidadReceptora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadCrear")));
	    desplegarUnidadReceptora2.click();  
	    Thread.sleep(secDelay);
	    WebElement seleccionarUnidadReceptora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1100 - AG PA 1']")));
	    seleccionarUnidadReceptora2.click();
	    Thread.sleep(secDelay);
	    WebElement desplegarTransportista2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transportistaCrear-trigger-picker")));
	    desplegarTransportista2.click();  
	    WebElement seleccionarTransportista2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='TRANSPORTISTA PA 1']")));
	    seleccionarTransportista2.click();
	    Thread.sleep(secDelay);
	    WebElement desplegarTipoEnvio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvioCrear-trigger-picker")));
	    desplegarTipoEnvio2.click();  
	    WebElement seleccionarTipoEnvio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pos. Propia']")));
	    seleccionarTipoEnvio2.click();
	    
	    WebElement botonSiguiente2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnWrap")));
	    botonSiguiente2.click();
	    Thread.sleep(secDelay);
	    
	    WebElement desplegarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
	    desplegarDivisa2.click();
	    WebElement elementoDolar2 = driver.findElement(By.xpath("//li[text()='Dólar']"));
	    elementoDolar2.click();
	        
	    Random rand2 = new Random();
	    int numeroAleatorio2 = rand2.nextInt(1000000) + 1000000000;
	    String numeroTexto2 = Integer.toString(numeroAleatorio2);
	    WebElement numeroServicioAleatorio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl"))); 
	    numeroServicioAleatorio2.sendKeys(String.valueOf(numeroTexto2)); 
	    System.out.println("El Cataporte es: " + numeroTexto2);
	        
	    WebElement destinoDesplegar2 = driver.findElement(By.id("destinoCrear-trigger-picker"));
	    if (destinoDesplegar2.isEnabled()) {
	       	destinoDesplegar2.click();
	    } else {
	    }
	    Thread.sleep(secDelay);

	    try {
	    WebElement destinoSeleccionar = driver.findElement(By.xpath("//li[text()='Boveda']"));
	    destinoSeleccionar.click();
	    } catch (NoSuchElementException e){
	    }
	     
	    Thread.sleep(secDelay);
	     
	    WebElement botonIncluir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear-btnWrap")));
        botonIncluir2.click();
        Thread.sleep(secDelay);
        WebElement desplegarTipoEnvase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvaseCrear-trigger-picker")));
        desplegarTipoEnvase2.click();
        WebElement seleccionarTipoEnvase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bolsa']")));
        seleccionarTipoEnvase2.click();
        WebElement desplegarTipoPieza2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
        desplegarTipoPieza2.click();
        WebElement seleccionarTipoPieza2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete']")));
        seleccionarTipoPieza2.click();
        WebElement colocarCantidadEnvases2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
        colocarCantidadEnvases2.sendKeys("1");
        WebElement botonIncluirEnvases2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear-btnWrap")));
        botonIncluirEnvases2.click();
        WebElement colocarNumeroPlomos2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
        colocarNumeroPlomos2.sendKeys("1");
        WebElement botonIncluirPlomos2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnIconEl")));
        botonIncluirPlomos2.click();
        
        WebElement elementoCantidad2 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1115']")); //En 2.6 es 1163 y en 2.5 es 1161
        Actions doble2 = new Actions(driver);
        doble2.doubleClick(elementoCantidad2).perform();
        
        List<WebElement> elementos2 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));
        boolean elementoEncontrado2 = false;
        for (WebElement elemento : elementos2) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elementoCantidad2).sendKeys("4").sendKeys(Keys.ENTER).perform();
                elementoEncontrado2 = true;
                break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
            }
        }
        if (!elementoEncontrado2) {
            System.out.println("Ninguno de los elementos está habilitado.");
            // Puedes manejar esta situación según tus necesidades, por ejemplo, lanzar una excepción
            
        }
        	        	       	
        WebElement Denominación_50_2 = driver.findElement(By.xpath("//div[text()='50,000']"));
            
        Actions actions3 = new Actions(driver);
            
        actions3.moveToElement(Denominación_50_2).perform();

        Denominación_50_2.click(); 	
        
        actions3.sendKeys(Denominación_50_2, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ENTER).sendKeys("10").sendKeys(Keys.ENTER).build().perform();
        
        Thread.sleep(secDelay);
        WebElement aceptarCreacionRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1133-btnWrap")));
        aceptarCreacionRemesa2.click();
        Thread.sleep(secDelay);
   	        
        WebElement mensajeConfirmacion2 = driver.findElement(By.id("container-1003-innerCt"));
        String texto2 = mensajeConfirmacion2.getText();
        System.out.println("La creacion Fue: " + texto2);
   
        Thread.sleep(secDelay);
        WebElement aceptarMensajeInformativo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        aceptarMensajeInformativo2.click();
        Thread.sleep(secDelay);

	    File archivo10 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo10, new File(captura10));
               
        
	}
}
