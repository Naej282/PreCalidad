package Integrales;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constantes.Constante_PreCalidad;
import DataDrivenTesting.ReadExcelFile;
import DataDrivenTesting.WriteExcelFile;

public class Cases_510 {

	int secDelay = 2000;
	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
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
		
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		String filepath = "C:\\Users\\gsarmiento\\Desktop\\Cases Integrales - Automatización\\CasesIntegrales.xlsx";
		
		String TipoUnidadEmisora = readFile.getCellValue(filepath, "Hoja1", 22, 1);
		String UnidadEmisora = readFile.getCellValue(filepath, "Hoja1", 22, 2);
		String TipoUnidadReceptora = readFile.getCellValue(filepath, "Hoja1", 22, 3);
		String UnidadReceptora = readFile.getCellValue(filepath, "Hoja1", 22, 4);
		String EmpresaTransportista = readFile.getCellValue(filepath, "Hoja1", 22, 5);
		
        JavascriptExecutor js = (JavascriptExecutor) driver;		 	
		String Agencia = "http://192.168.2.214:8901/Agencia/";
		String Central = "http://192.168.2.214:8901/Central/";
				
		// Captura
        
	 	String directorioCapturas = "C:/Users/gsarmiento/Desktop/Cases Integrales - Automatización/Cases 510";
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
	 	
	 	String Modalidad ="//li[text()='Abono en Cuenta']";
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constante_PreCalidad.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
		WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		enter.click();
		
		WebElement Configuracion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
        Configuracion.click();
        WebElement Generales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("generales")));
        Generales.click();
        WebElement ParametrosGenerales = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("parametroGeneral")));
        ParametrosGenerales.click();
        
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
	    
	    js1.executeScript("window.scrollBy(0,500)");
        
        // Validar Parametro
	    
        WebElement selectParametro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='MODO_DE_REGULARIZACION']")));
	    selectParametro.click(); 
	    Thread.sleep(secDelay);
	    
	    File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo, new File(captura1));
        
        WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	    Inicio.click(); 
        
	    WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
  	    Logistica.click();	
  	    WebElement administracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
  	    administracionEfectivo.click();
  	    WebElement enviosCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
  	    enviosCentral.click();
  	    
  	    // Crear Remesa
  	    
  	    WebElement crearenvios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
	    crearenvios.click();
	    
	    WebElement desplegarTipoUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadEmisoraCrear-trigger-picker")));
	    desplegarTipoUnidadEmisora.click();
	    WebElement campoTipoUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadEmisoraCrear-inputEl")));
	    campoTipoUnidadEmisora.click();
	    Thread.sleep(secDelay);
	    WebElement escribirTipoUnidadEmisora = driver.findElement(escribirTipoUnidadEmisoraLocator);
	    escribirTipoUnidadEmisora.sendKeys(TipoUnidadEmisora);
	    escribirTipoUnidadEmisora.sendKeys(Keys.ENTER);
		Thread.sleep(secDelay);
		WebElement desplegarUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadEmisoraCrear-trigger-picker")));
		desplegarUnidadEmisora.click();
		Thread.sleep(secDelay);
		WebElement escribirUnidadEmisora = driver.findElement(escribirUnidadEmisoraLocator);
		escribirUnidadEmisora.sendKeys(UnidadEmisora);
	    escribirUnidadEmisora.sendKeys(Keys.ENTER);
	    Thread.sleep(secDelay);
	    WebElement desplegarTipoUnidadReceptora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadReceptoraCrear-trigger-picker")));
	    desplegarTipoUnidadReceptora.click();
	    WebElement escribirTipoUnidadReceptora = driver.findElement(escribirTipoUnidadReceptoraLocator);
	    escribirTipoUnidadReceptora.sendKeys(TipoUnidadReceptora);
	    escribirTipoUnidadReceptora.sendKeys(Keys.ENTER);
	    Thread.sleep(secDelay);
	    WebElement escribirUnidadReceptora = driver.findElement(escribirUnidadReceptoraLocator);
	    escribirUnidadReceptora.sendKeys(UnidadReceptora);
	    escribirUnidadReceptora.sendKeys(Keys.ENTER);
	    Thread.sleep(secDelay);
	    WebElement escribirEmpresaTransportista = driver.findElement(escribirEmpresaTransportistaLocator);
	    escribirEmpresaTransportista.sendKeys(EmpresaTransportista);
	    escribirEmpresaTransportista.sendKeys(Keys.ENTER);
	    WebElement botonSiguiente = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnWrap")));
	    botonSiguiente.click();
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
        WebElement seleccionarTipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOLSA']")));
        seleccionarTipoEnvase.click();
        WebElement desplegarTipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
        desplegarTipoPieza.click();
        WebElement seleccionarTipoPieza = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billetes']")));
        seleccionarTipoPieza.click();
        WebElement colocarCantidadEnvases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
        colocarCantidadEnvases.sendKeys("1");
        WebElement botonIncluirEnvases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear-btnWrap")));
        botonIncluirEnvases.click();
        WebElement colocarNumeroPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
        colocarNumeroPlomos.sendKeys("1");
        WebElement botonIncluirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnIconEl")));
        botonIncluirPlomos.click();
         
        WebElement elementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1163']")); //En 2.6 es 1163 y en 2.5 es 1161
        Actions doble = new Actions(driver);
        doble.doubleClick(elementoCantidad).perform();	
		
        List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));
        boolean elementoEncontrado = false;
        for (WebElement elemento : elementos) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elementoCantidad).sendKeys("2").sendKeys(Keys.ENTER).perform();
                elementoEncontrado = true;
                break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
            }
        }
        if (!elementoEncontrado) {
            System.out.println("Ninguno de los elementos está habilitado.");
            // Puedes manejar esta situación según tus necesidades, por ejemplo, lanzar una excepción
            
        }
        
        Thread.sleep(secDelay);
        
        WebElement aceptarCreacionRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar1-btnWrap")));
        aceptarCreacionRemesa.click();
        Thread.sleep(secDelay);
    	        
        WebElement mensajeConfirmacion = driver.findElement(By.id("container-1029-innerCt"));
        String texto = mensajeConfirmacion.getText();
        System.out.println("La creacion Fue: " + texto);
    
    
        Thread.sleep(secDelay);
        WebElement aceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
        aceptarMensajeInformativo.click();
    
        driver.navigate().refresh();
        
        //Mensaje Creacion Remesa
        
        String mensajeInformativo = texto;
     	 writeFile.writeCellValue(filepath, "Hoja1", 22, 7, mensajeInformativo);	
         
     	//Mensaje Cataporte Remesa	
     	 	
     	String cataporte1 =  numeroTexto;
        writeFile.writeCellValue(filepath, "Hoja1", 22, 8, cataporte1);
        
        //Avance de Remesa
    	
        String nroServicio = readFile.getCellValue(filepath, "Hoja1", 22, 8);
            
        WebElement filtros2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
        filtros2.click();
        WebElement campoNroServicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
        campoNroServicio.sendKeys(nroServicio);
        Thread.sleep(secDelay);
        WebElement consultarFiltros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
        consultarFiltros.click();
        Thread.sleep(secDelay);
	     	 
        WebElement seleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesa.click();
        Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoSolicitado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoSolicitado.click();  
        Thread.sleep(secDelay);
        WebElement avanceEstadoSolicitado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoSolicitado.click();

        Thread.sleep(secDelay);
        WebElement mensajeConfirmacion2 = driver.findElement(By.id("messagebox-1027-msg"));
        String avance3 = mensajeConfirmacion2.getText();
        System.out.println("Avance: " + avance3);
                 
        WebElement aceptarAvanceEstado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstado2.click();    
            
        String mensajeInformativo1 =  avance3;
        	writeFile.writeCellValue(filepath, "Hoja1", 22, 9, mensajeInformativo1);
            
        WebElement seleccionarRemesaAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesaAprobado.click();
        Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoAprobado.click();  
        Thread.sleep(secDelay);
        WebElement avanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoAprobado.click();
        Thread.sleep(secDelay);
        WebElement confirmarAvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnEl")));
        confirmarAvanceEstadoAprobado.click();
        Thread.sleep(secDelay);
           
        WebElement mensajeConfirmacionAprobado = driver.findElement(By.id("messagebox-1027-msg"));
        String avance4 = mensajeConfirmacionAprobado.getText();
        System.out.println("Avance: " + avance4);
            
        WebElement aceptarAvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstadoAprobado.click();
        Thread.sleep(secDelay);
            
        String mensajeInformativo2 =  avance4;
        writeFile.writeCellValue(filepath, "Hoja1", 22, 10, mensajeInformativo2);
        
        // Cambio al modulo de Agencia
        
        js.executeScript("window.open(arguments[0]);", Agencia);	  
	    
	    Set<String> handles2 = driver.getWindowHandles();
	    
	    String AgenciaAvanceRemesa = (String) handles2.toArray()[handles2.size() - 1];
	    driver.switchTo().window(AgenciaAvanceRemesa);
	    
	    WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
	    WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterAgencia.click();
        
	    WebElement ControlRemesas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remesas")));
	    ControlRemesas.click();
	    WebElement enviosAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Envios")));
	    enviosAgencia.click();  
	    	       	    
 	    WebElement filtrosAgecia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnInnerEl")));
 	    filtrosAgecia.click();
 	    Thread.sleep(secDelay);
 	    WebElement radioButtonReceptor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadRConsulta-inputEl")));
 	    radioButtonReceptor.click();
 	    WebElement campoNroServicioAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
 	    campoNroServicioAgencia.sendKeys(nroServicio);
 	    Thread.sleep(secDelay);
        WebElement consultarFiltroAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1086-btnInnerEl")));
        consultarFiltroAgencia.click();
        Thread.sleep(secDelay);
 	    
        WebElement seleccionarRemesaDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
        seleccionarRemesaDespachado.click();
        Thread.sleep(secDelay);
        WebElement botonAvanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanceEstadoRecibido.click();  
        Thread.sleep(secDelay);
        WebElement avanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoRecibido.click();

        Thread.sleep(secDelay);
        WebElement mensajeConfirmacionRecibido = driver.findElement(By.id("messagebox-1001-msg"));
        String Recibido = mensajeConfirmacionRecibido.getText();
        System.out.println("Avance: " + Recibido);
                 
        WebElement aceptarAvanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
        aceptarAvanceEstadoRecibido.click();    
        
        String mensajeInformativoRecibido =  Recibido;
    		writeFile.writeCellValue(filepath, "Hoja1", 22, 11, mensajeInformativoRecibido);
        
    	WebElement seleccionarRemesaRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
        seleccionarRemesaRecibido.click();
        Thread.sleep(secDelay);
        WebElement botonAvanceEstadoAlternoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnWrap")));
        botonAvanceEstadoAlternoRecibido.click();  
        Thread.sleep(secDelay);
        WebElement desplegarAvanceEstadoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
        desplegarAvanceEstadoFaltante.click();
        WebElement seleccionarEstadoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Confirmado Ajuste Sobrante']")));
        seleccionarEstadoFaltante.click();
        WebElement avanceEstadoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnInnerEl")));
        avanceEstadoFaltante.click();
        
        WebElement desplegarDenominacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionSobrantes-trigger-picker")));
        desplegarDenominacionSobrante.click();
        WebElement SeleccionarDenominacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));
        SeleccionarDenominacionSobrante.click();
        WebElement desplegarTipoClasificacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoClasificacionSobrantes-trigger-picker")));
        desplegarTipoClasificacionSobrante.click();
        WebElement SeleccionarTipoClasificacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
        SeleccionarTipoClasificacionSobrante.click();
        WebElement colocarCantidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadSobrantes-inputEl")));
        colocarCantidad2.sendKeys("1");
        WebElement incluirDatosSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1052-btnWrap")));
        incluirDatosSobrante.click();
        WebElement aceptarDatosSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar-btnInnerEl")));
        aceptarDatosSobrante.click();
        WebElement aceptarCreacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
        aceptarCreacionSobrante.click();
                                 
        WebElement inicioAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        inicioAgencia.click();
        
        WebElement Diferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
        Diferencia.click();
        Thread.sleep(secDelay);
        
        WebElement desplegarTipoConsultaDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
        desplegarTipoConsultaDiferencia.click();
        Thread.sleep(secDelay);
        WebElement seleccionarTipoConsultaDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
        seleccionarTipoConsultaDiferencia.click();
        WebElement desplegarTipoDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
        desplegarTipoDiferencia.click();
        Thread.sleep(secDelay);
        WebElement seleccionarTipoDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Sobrante']")));
        seleccionarTipoDiferencia.click();
        WebElement desplegarOrigenDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
        desplegarOrigenDiferencia.click();
        Thread.sleep(secDelay);
        WebElement seleccionarOrigenDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='REMESA']")));
        seleccionarOrigenDiferencia.click();
        WebElement consultarDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041-btnWrap")));
        consultarDiferencia.click();
        
        WebElement seleccionarDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1026']")));
        seleccionarDiferencia.click();
        WebElement botonSaldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar-btnInnerEl")));
        botonSaldar.click();
        Thread.sleep(secDelay);
        
        WebElement desplegarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
        desplegarModalidad.click();
        WebElement seleccionarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Modalidad)));
        seleccionarModalidad.click();
        WebElement MontoSaldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
        MontoSaldar.sendKeys("100");
        WebElement Descripción = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
        Descripción.sendKeys("prueba");
        	        
        // Cargo en Cuenta
        
        WebElement NroCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuentaCuen-inputEl")));
        NroCuenta.sendKeys("02147850");
        WebElement nombreCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuentaCuen-inputEl")));
        nombreCuenta.sendKeys("Prueba Automatizada");
        WebElement presionarIncluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacionCuen-btnWrap")));
        presionarIncluir.click();
        Thread.sleep(secDelay);
        
        File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));
        
        WebElement presionarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarSald-btnWrap")));
        presionarAceptar.click();
        
        WebElement confirmarOperacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        confirmarOperacion.click();	
        	
	}
}
