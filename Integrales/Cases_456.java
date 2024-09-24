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


public class Cases_456 {

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
		
		//	- - - - - - - - - - - - - - Auxiliar de Movimiento - - - - - - - - - - - - - -
		
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		 int intentos = 3;
		 int i=1;
		 int u=1;
		
		// Día Anterior
		
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaAnterior = fechaActual.minusDays(1);
        int diaAnterior = fechaAnterior.getDayOfMonth();
           
        System.out.println(diaAnterior);
        
        String DiaAnterior = (diaAnterior < 10) ? "0" + diaAnterior : String.valueOf(diaAnterior);
        
        System.out.println(DiaAnterior);
                
	 	String directorioCapturas = "C:/Users/gsarmiento/Desktop/Cases Integrales - Automatización/Cases 456";
	 	
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
        
        JavascriptExecutor js = (JavascriptExecutor) driver;		 	
		String Agencia = "http://192.168.2.214:8901/Agencia/";
		String Central = "http://192.168.2.214:8901/Central/";
        
	    String filepath = "C:\\Users\\gsarmiento\\Desktop\\Cases Integrales - Automatización\\CasesIntegrales.xlsx";
		
		String TipoUnidadEmisora = readFile.getCellValue(filepath, "Hoja1", 3, 1);
		String UnidadEmisora = readFile.getCellValue(filepath, "Hoja1", 3, 2);
		String TipoUnidadReceptora = readFile.getCellValue(filepath, "Hoja1", 3, 3);
		String UnidadReceptora = readFile.getCellValue(filepath, "Hoja1", 3, 4);
		String EmpresaTransportista = readFile.getCellValue(filepath, "Hoja1", 3, 5);
                
	    WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    login.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enter.click();
	   
	    // Consulta Día Cerrado
	     
	    WebElement logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
  	    logistica.click();
  	    WebElement administracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
  	    administracionEfectivo.click();
  	    WebElement cierreDeUnidades = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Image1\"]")));
  	    cierreDeUnidades.click();
  	    
  	    WebElement desplegarTipoUnidadCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
  	    desplegarTipoUnidadCierre.click();
  	    WebElement seleccionarTipoUnidadCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Agencia']")));
  	    seleccionarTipoUnidadCierre.click();
  	    WebElement desplegarUnidadCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen60")));
  	    desplegarUnidadCierre.click();
  	    WebElement seleccionarUnidadCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='1001-AG PA 2']")));
	    seleccionarUnidadCierre.click();
	    WebElement desplegarDivisaCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen73")));
  	    desplegarDivisaCierre.click();
	    WebElement seleccionarDivisaCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dólar']")));
	    seleccionarDivisaCierre.click();
	    WebElement consultarCierre = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen86")));
	    consultarCierre.click();
	    Thread.sleep(secDelay);   	
  	    
	    WebElement seleccionarDía = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+  DiaAnterior +"']")));
        seleccionarDía.click();
	    
        WebElement campo = driver.findElement(By.xpath("//td[text()='"+ DiaAnterior +"']"));
	    
	    String claseDelCampo = campo.getAttribute("class");
	    if (claseDelCampo.equals("sameMonth x-unselectable")) {   
            campo.click();    
            Thread.sleep(secDelay);  
            WebElement seleccionarCerrarDia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCerrarDia")));
            seleccionarCerrarDia.click();
            WebElement aceptarCerrarDia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1065")));
            aceptarCerrarDia.click();
    	    Thread.sleep(secDelay);   	
            WebElement aceptarValidacionCerrarDia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1068")));
            aceptarValidacionCerrarDia.click();
            System.out.println("No esta cerrado el dìa anterior");
        } else {
            // La clase deseada no está presente, realiza otras acciones o simplemente imprime un mensaje
            System.out.println("El dìa esta cerrado correctamente.");
        }
	    
	    WebElement exitCierreUnidades = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
	    exitCierreUnidades.click();
	    WebElement envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
	    envios.click();
	    
	    // Primera Remesa
	    
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
        WebElement seleccionarTipoEnvase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA']")));
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
        
        Thread.sleep(secDelay); //
         
        WebElement elementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1163']")); //En 2.6 es 1163 y en 2.5 es 1161 // 1161
        Actions doble = new Actions(driver);
        doble.doubleClick(elementoCantidad).perform();	
        
        Thread.sleep(secDelay); //
		
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
     	 	writeFile.writeCellValue(filepath, "Hoja1", 3, 7, mensajeInformativo);	
         
     	//Mensaje Cataporte Remesa	
     	 	
     	String cataporte1 =  numeroTexto;
        	writeFile.writeCellValue(filepath, "Hoja1", 3, 8, cataporte1);
        	
        //Avance de Remesa
        	
        String nroServicio = readFile.getCellValue(filepath, "Hoja1", 3, 8);
            
        WebElement filtros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
        filtros.click();
        WebElement campoNroServicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
        campoNroServicio.sendKeys(nroServicio);
        Thread.sleep(secDelay);
        WebElement consultarFiltros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
        consultarFiltros.click();
        Thread.sleep(secDelay);
	     	 
        WebElement seleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesa.click();
        Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoSolicitado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnWrap")));
        botonAvanzarEstadoSolicitado.click();  
        Thread.sleep(secDelay);
        WebElement avanceEstadoSolicitado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoSolicitado.click();

        Thread.sleep(secDelay);
        WebElement mensajeConfirmacion1 = driver.findElement(By.id("messagebox-1027-msg"));
        String avance1 = mensajeConfirmacion1.getText();
        System.out.println("Avance: " + avance1);
                 
        WebElement aceptarAvanceEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstado.click();    
            
        String mensajeInformativo2 =  avance1;
        	writeFile.writeCellValue(filepath, "Hoja1", 3, 9, mensajeInformativo2);
            
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
        String avance2 = mensajeConfirmacionAprobado.getText();
        System.out.println("Avance: " + avance2);
            
        WebElement aceptarAvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstadoAprobado.click();
        Thread.sleep(secDelay);
            
        String mensajeInformativo3 =  avance2;
        writeFile.writeCellValue(filepath, "Hoja1", 3, 10, mensajeInformativo3);
        
        // Cambio al modulo de Agencia
        
        js.executeScript("window.open(arguments[0]);", Agencia);	  
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	    String AgenciaAvanceRemesa1 = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(AgenciaAvanceRemesa1);
	    
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
    		writeFile.writeCellValue(filepath, "Hoja1", 3, 11, mensajeInformativoRecibido);
        
    	WebElement seleccionarRemesaRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
        seleccionarRemesaRecibido.click();
        Thread.sleep(secDelay);
        WebElement botonAvanceEstadoAlternoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnWrap")));
        botonAvanceEstadoAlternoRecibido.click();  
        Thread.sleep(secDelay);
        WebElement desplegarAvanceEstadoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
        desplegarAvanceEstadoFaltante.click();
        WebElement seleccionarEstadoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Confirmado Ajuste Faltante']")));
        seleccionarEstadoFaltante.click();
        WebElement avanceEstadoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnInnerEl")));
        avanceEstadoFaltante.click();
        
        Thread.sleep(secDelay);
        
        WebElement desplegarDenominacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantes-trigger-picker")));
        desplegarDenominacionFaltante.click();
        WebElement SeleccionarDenominacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));
        SeleccionarDenominacionFaltante.click();
        WebElement desplegarTipoClasificacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoClasificacionFaltantes-trigger-picker")));
        desplegarTipoClasificacionFaltante.click();
        WebElement SeleccionarTipoClasificacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
        SeleccionarTipoClasificacionFaltante.click();
        WebElement colocarCantidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantes-inputEl")));
        colocarCantidad.sendKeys("1");
        WebElement incluirDatosFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1063-btnInnerEl")));
        incluirDatosFaltante.click();
        WebElement aceptarDatosFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar-btnInnerEl")));
        aceptarDatosFaltante.click();
        WebElement aceptarCreacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
        aceptarCreacionFaltante.click();
        
        // Volver a Central
                  
	    String central = (String) handles.toArray()[handles.size() - 2];
	    driver.switchTo().window(central);
        	   
	    driver.navigate().refresh();
	     	      	                                       
        // Segunda Remesa
               
        WebElement crearenvios2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
	    crearenvios2.click();
	    WebElement desplegarTipoUnidadEmisora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadEmisoraCrear-trigger-picker")));
	    desplegarTipoUnidadEmisora2.click();
	    WebElement campoTipoUnidadEmisora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadEmisoraCrear-inputEl")));
	    campoTipoUnidadEmisora2.click();
	    Thread.sleep(secDelay);
	    WebElement escribirTipoUnidadEmisora2 = driver.findElement(escribirTipoUnidadEmisoraLocator);
	    escribirTipoUnidadEmisora2.sendKeys(TipoUnidadEmisora);
	    escribirTipoUnidadEmisora2.sendKeys(Keys.ENTER);
		Thread.sleep(secDelay);
		WebElement desplegarUnidadEmisora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadEmisoraCrear-trigger-picker")));
		desplegarUnidadEmisora2.click();
		Thread.sleep(secDelay);
		WebElement escribirUnidadEmisora2 = driver.findElement(escribirUnidadEmisoraLocator);
		escribirUnidadEmisora2.sendKeys(UnidadEmisora);
	    escribirUnidadEmisora2.sendKeys(Keys.ENTER);
	    Thread.sleep(secDelay);
	    WebElement desplegarTipoUnidadReceptora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadReceptoraCrear-trigger-picker")));
	    desplegarTipoUnidadReceptora2.click();
	    WebElement escribirTipoUnidadReceptora2 = driver.findElement(escribirTipoUnidadReceptoraLocator);
	    escribirTipoUnidadReceptora2.sendKeys(TipoUnidadReceptora);
	    escribirTipoUnidadReceptora2.sendKeys(Keys.ENTER);
	    Thread.sleep(secDelay);
	    WebElement escribirUnidadReceptora2 = driver.findElement(escribirUnidadReceptoraLocator);
	    escribirUnidadReceptora2.sendKeys(UnidadReceptora);
	    escribirUnidadReceptora2.sendKeys(Keys.ENTER);
	    Thread.sleep(secDelay);
	    WebElement escribirEmpresaTransportista2 = driver.findElement(escribirEmpresaTransportistaLocator);
	    escribirEmpresaTransportista2.sendKeys(EmpresaTransportista);
	    escribirEmpresaTransportista2.sendKeys(Keys.ENTER);
	    WebElement botonSiguiente2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnWrap")));
	    botonSiguiente2.click();
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
        WebElement seleccionarTipoEnvase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA']")));
        seleccionarTipoEnvase2.click();
        WebElement desplegarTipoPieza2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
        desplegarTipoPieza2.click();
        WebElement seleccionarTipoPieza2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billetes']")));
        seleccionarTipoPieza2.click();
        WebElement colocarCantidadEnvases2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
        colocarCantidadEnvases2.sendKeys("1");
        WebElement botonIncluirEnvases2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear-btnWrap")));
        botonIncluirEnvases2.click();
        WebElement colocarNumeroPlomos2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
        colocarNumeroPlomos2.sendKeys("1");
        WebElement botonIncluirPlomos2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnIconEl")));
        botonIncluirPlomos2.click();
        
        Thread.sleep(secDelay); //
         
        WebElement elementoCantidad2 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1163']")); //En 2.6 es 1163 y en 2.5 es 1161
        Actions doble2 = new Actions(driver);
        doble2.doubleClick(elementoCantidad2).perform();	
        
        Thread.sleep(secDelay);
		
        List<WebElement> elementos2 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));
        boolean elementoEncontrado2 = false;
        for (WebElement elemento : elementos2) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elementoCantidad2).sendKeys("2").sendKeys(Keys.ENTER).perform();
                elementoEncontrado2 = true;
                break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
            }
        }
        if (!elementoEncontrado2) {
            System.out.println("Ninguno de los elementos está habilitado.");
            // Puedes manejar esta situación según tus necesidades, por ejemplo, lanzar una excepción
        }
         
        Thread.sleep(secDelay);
        WebElement aceptarCreacionRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar1-btnWrap")));
        aceptarCreacionRemesa2.click();
        Thread.sleep(secDelay);
    	        
        WebElement mensajeConfirmacion2 = driver.findElement(By.id("container-1029-innerCt"));
        String texto2 = mensajeConfirmacion2.getText();
        System.out.println("La creacion Fue: " + texto2);
    
    
        Thread.sleep(secDelay);
        WebElement aceptarMensajeInformativo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
        aceptarMensajeInformativo2.click();
    
        driver.navigate().refresh();
                  
        //Mensaje Creacion Remesa
         
        String mensajeInformativo4 = texto2;
     	 	writeFile.writeCellValue(filepath, "Hoja1", 4, 7, mensajeInformativo4);	
         
     	//Mensaje Cataporte Remesa	
     	 	
     	String cataporte2 =  numeroTexto2;
        	writeFile.writeCellValue(filepath, "Hoja1", 4, 8, cataporte2);
        	
        //Avance de Remesa
        	
        String nroServicio2 = readFile.getCellValue(filepath, "Hoja1", 4, 8);
            
        WebElement filtros2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
        filtros2.click();
        WebElement campoNroServicio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
        campoNroServicio2.sendKeys(nroServicio2);
        Thread.sleep(secDelay);
        WebElement consultarFiltros22 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
        consultarFiltros22.click();
        Thread.sleep(secDelay);
	     	 
        WebElement seleccionarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesa2.click();
        Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoSolicitado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoSolicitado2.click();  
        Thread.sleep(secDelay);
        WebElement avanceEstadoSolicitado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoSolicitado2.click();

        Thread.sleep(secDelay);
        WebElement mensajeConfirmacion3 = driver.findElement(By.id("messagebox-1027-msg"));
        String avance3 = mensajeConfirmacion3.getText();
        System.out.println("Avance: " + avance3);
                 
        WebElement aceptarAvanceEstado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstado2.click();    
            
        String mensajeInformativo6 =  avance3;
        	writeFile.writeCellValue(filepath, "Hoja1", 4, 9, mensajeInformativo6);
            
        WebElement seleccionarRemesaAprobado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesaAprobado2.click();
        Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoAprobado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoAprobado2.click();  
        Thread.sleep(secDelay);
        WebElement avanceEstadoAprobado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoAprobado2.click();
        Thread.sleep(secDelay);
        WebElement confirmarAvanceEstadoAprobado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnEl")));
        confirmarAvanceEstadoAprobado2.click();
        Thread.sleep(secDelay);
           
        WebElement mensajeConfirmacionAprobado2 = driver.findElement(By.id("messagebox-1027-msg"));
        String avance4 = mensajeConfirmacionAprobado2.getText();
        System.out.println("Avance: " + avance4);
            
        WebElement aceptarAvanceEstadoAprobado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstadoAprobado2.click();
        Thread.sleep(secDelay);
            
        String mensajeInformativo7 =  avance4;
        writeFile.writeCellValue(filepath, "Hoja1", 4, 10, mensajeInformativo7);
        
        // Cambio al modulo de Agencia
        
        js.executeScript("window.open(arguments[0]);", Agencia);	  
	    
	    Set<String> handles2 = driver.getWindowHandles();
	    
	    String AgenciaAvanceRemesa2 = (String) handles2.toArray()[handles2.size() - 1];
	    driver.switchTo().window(AgenciaAvanceRemesa2);
	    
	    WebElement loginAgencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginAgencia2.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordAgencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordAgencia2.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
	    WebElement enterAgencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterAgencia2.click();
        
	    WebElement ControlRemesas2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remesas")));
	    ControlRemesas2.click();
	    WebElement enviosAgencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Envios")));
	    enviosAgencia2.click();  
	    	       	    
 	    WebElement filtrosAgecia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnInnerEl")));
 	    filtrosAgecia2.click();
 	    Thread.sleep(secDelay);
 	    WebElement radioButtonReceptor2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadRConsulta-inputEl")));
 	    radioButtonReceptor2.click();
 	    WebElement campoNroServicioAgencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
 	    campoNroServicioAgencia2.sendKeys(nroServicio2);
 	    Thread.sleep(secDelay);
        WebElement consultarFiltroAgencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1086-btnInnerEl")));
        consultarFiltroAgencia2.click();
        Thread.sleep(secDelay);
 	    
        WebElement seleccionarRemesaDespachado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
        seleccionarRemesaDespachado2.click();
        Thread.sleep(secDelay);
        WebElement botonAvanceEstadoRecibido2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanceEstadoRecibido2.click();  
        Thread.sleep(secDelay);
        WebElement avanceEstadoRecibido2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoRecibido2.click();

        Thread.sleep(secDelay);
        WebElement mensajeConfirmacionRecibido2 = driver.findElement(By.id("messagebox-1001-msg"));
        String Recibido2 = mensajeConfirmacionRecibido2.getText();
        System.out.println("Avance: " + Recibido2);
                 
        WebElement aceptarAvanceEstadoRecibido2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
        aceptarAvanceEstadoRecibido2.click();    
        
        String mensajeInformativoRecibido2 =  Recibido2;
    		writeFile.writeCellValue(filepath, "Hoja1", 4, 11, mensajeInformativoRecibido2);
    		
            Thread.sleep(secDelay);
        
    	WebElement seleccionarRemesaRecibido2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1034']")));
        seleccionarRemesaRecibido2.click();
        Thread.sleep(secDelay);
        WebElement botonAvanceEstadoAlternoRecibido2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnWrap")));
        botonAvanceEstadoAlternoRecibido2.click();  
        Thread.sleep(secDelay);
        WebElement desplegarAvanceEstadoFaltante2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
        desplegarAvanceEstadoFaltante2.click();
        WebElement seleccionarEstadoFaltante2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Confirmado Ajuste Sobrante']")));
        seleccionarEstadoFaltante2.click();
        WebElement avanceEstadoFaltante2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnInnerEl")));
        avanceEstadoFaltante2.click();
        
        Thread.sleep(secDelay); //
        
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
        Thread.sleep(secDelay);
        WebElement aceptarDatosSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar-btnWrap")));
        aceptarDatosSobrante.click();
        WebElement aceptarCreacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnInnerEl")));
        aceptarCreacionSobrante.click();
        
                              
        WebElement inicioAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        inicioAgencia.click();
        
        // Creacion Pases de Bóveda Apertura
        
        WebElement caja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
        caja.click();
        WebElement pasesDeBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
        pasesDeBoveda.click();
        
        WebElement creacionPases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
        creacionPases.click();
        WebElement desplegarDivisaTaquilla = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
        desplegarDivisaTaquilla.click();
        WebElement seleccionarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
        seleccionarDivisa.click();
        WebElement desplegarTaquilla = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
        desplegarTaquilla.click();
        WebElement seleccionarTaquilla = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 1']")));
        seleccionarTaquilla.click();
        Thread.sleep(secDelay);
        WebElement desplegarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
        desplegarModalidad.click();
        Thread.sleep(secDelay);
        WebElement seleccionarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Apertura']")));
        seleccionarModalidad.click();
        Thread.sleep(secDelay);
        WebElement aceptarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
        aceptarPase.click();
        WebElement aceptarCreacionPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        aceptarCreacionPase.click();
        
        // Pase Caja a Bóveda
        
        driver.navigate().refresh();
        
        WebElement creacionPases2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
        creacionPases2.click();
        WebElement desplegarDivisaTaquilla2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
        desplegarDivisaTaquilla2.click();
        WebElement seleccionarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
        seleccionarDivisa2.click();
        WebElement desplegarTaquilla2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
        desplegarTaquilla2.click();
        WebElement seleccionarTaquilla2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 1']")));
        seleccionarTaquilla2.click();
        Thread.sleep(secDelay);
        WebElement desplegarModalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
        desplegarModalidad2.click();
        WebElement seleccionarModalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal']")));
        seleccionarModalidad2.click();
        Thread.sleep(secDelay);
        WebElement desplegarTipoPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
        desplegarTipoPase2.click();
        Thread.sleep(secDelay);
        WebElement seleccionarTipoPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase de Caja a Boveda']")));
        seleccionarTipoPase2.click();
        Thread.sleep(secDelay);
        
        WebElement elementoCantidadTaquilla2 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); //En 2.6 es 1163 y en 2.5 es 1161
        Actions Taquilla2 = new Actions(driver);
        Taquilla2.doubleClick(elementoCantidadTaquilla2).perform();	
	           	
        List<WebElement> elementos3 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));
        boolean elementoEncontrado3 = false;
        for (WebElement elemento : elementos3) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elementoCantidadTaquilla2).sendKeys("2").sendKeys(Keys.ENTER).perform();
                elementoEncontrado3 = true;
                break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
            }
        }
        if (!elementoEncontrado3) {
            System.out.println("Ninguno de los elementos está habilitado.");
            // Puedes manejar esta situación según tus necesidades, por ejemplo, lanzar una excepción
            
        }
        
        WebElement aceptarPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
        aceptarPase2.click();
        WebElement aceptarCreacionPase2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        aceptarCreacionPase2.click();
        
        // Pase Bóveda a Caja
        
        driver.navigate().refresh();
        
        WebElement creacionPases3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
        creacionPases3.click();
        WebElement desplegarDivisaTaquilla3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
        desplegarDivisaTaquilla3.click();
        WebElement seleccionarDivisa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
        seleccionarDivisa3.click();
        WebElement desplegarTaquilla3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
        desplegarTaquilla3.click();
        WebElement seleccionarTaquilla3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 1']")));
        seleccionarTaquilla3.click();
        Thread.sleep(secDelay);
        WebElement desplegarModalidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
        desplegarModalidad3.click();
        WebElement seleccionarModalidad3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Normal']")));
        seleccionarModalidad3.click();
        Thread.sleep(secDelay);
        WebElement desplegarTipoPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
        desplegarTipoPase3.click();
        WebElement seleccionarTipoPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase de Boveda a Caja']")));
        seleccionarTipoPase3.click();
        Thread.sleep(secDelay);
        
        WebElement elementoCantidadTaquilla3 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); 
        Actions Taquilla3 = new Actions(driver);
        Taquilla3.doubleClick(elementoCantidadTaquilla3).perform();	
	           	
        List<WebElement> elementos4 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));
        boolean elementoEncontrado4 = false;
        for (WebElement elemento : elementos4) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elementoCantidadTaquilla3).sendKeys("2").sendKeys(Keys.ENTER).perform();
                elementoEncontrado4 = true;
                break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
            }
        }
        if (!elementoEncontrado4) {
            System.out.println("Ninguno de los elementos está habilitado.");
            // Puedes manejar esta situación según tus necesidades, por ejemplo, lanzar una excepción
            
        }
        
        WebElement aceptarPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
        aceptarPase3.click();
        WebElement aceptarCreacionPase3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        aceptarCreacionPase3.click();
        
        // Pase de Cierre
        
        driver.navigate().refresh();
        
        WebElement creacionPases4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
        creacionPases4.click();
        WebElement desplegarDivisaTaquilla4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
        desplegarDivisaTaquilla4.click();
        WebElement seleccionarDivisa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
        seleccionarDivisa4.click();
        WebElement desplegarTaquilla4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminalCP-trigger-picker")));
        desplegarTaquilla4.click();
        WebElement seleccionarTaquilla4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA AUTOMATIZADA 1']")));
        seleccionarTaquilla4.click();
        Thread.sleep(secDelay);
        WebElement desplegarModalidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadCP-trigger-picker")));
        desplegarModalidad4.click();
        WebElement seleccionarModalidad4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cierre']")));
        seleccionarModalidad4.click();
        Thread.sleep(secDelay);
              
        WebElement elementoCantidadTaquilla4 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1040']")); 
        Actions Taquilla4 = new Actions(driver);
        Taquilla4.doubleClick(elementoCantidadTaquilla4).perform();	
	           	
        List<WebElement> elementos5 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));
        boolean elementoEncontrado5 = false;
        for (WebElement elemento : elementos5) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elementoCantidadTaquilla4).sendKeys("2").sendKeys(Keys.ENTER).perform();
                elementoEncontrado5 = true;
                break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
            }
        }
        if (!elementoEncontrado5) {
            System.out.println("Ninguno de los elementos está habilitado.");
            // Puedes manejar esta situación según tus necesidades, por ejemplo, lanzar una excepción
            
        }
        
        WebElement aceptarPase4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1059-btnWrap")));
        aceptarPase4.click();
        WebElement aceptarCreacionPase4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        aceptarCreacionPase4.click();
        
        // Regresa Menu
        
        WebElement menu = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
        menu.click();
        
        WebElement ATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
        ATM.click();
        WebElement PasesATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
        PasesATM.click();
        
        // Pase Bóveda a ATM
        
        WebElement crearPaseATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
        crearPaseATM.click();
        WebElement desplegarDivisaATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
        desplegarDivisaATM.click();
        WebElement seleccionarDivisaATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
        seleccionarDivisaATM.click();
        WebElement desplegarATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmCP-trigger-picker")));
        desplegarATM.click();
        WebElement seleccionarATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1003-ATM PA 1']")));
        seleccionarATM.click();
        WebElement desplegarTipoPaseATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
        desplegarTipoPaseATM.click();
        WebElement seleccionarTipoPaseATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase Boveda a Atm Normal']")));
        seleccionarTipoPaseATM.click();
        Thread.sleep(secDelay);
        
        WebElement elementoCantidadATM = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1037']")); 
        Actions ATM1 = new Actions(driver);
        ATM1.doubleClick(elementoCantidadATM).perform();	
	           	
        List<WebElement> elementos6 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));
        boolean elementoEncontrado6 = false;
        for (WebElement elemento : elementos6) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elementoCantidadATM).sendKeys("2").sendKeys(Keys.ENTER).perform();
                elementoEncontrado6 = true;
                break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
            }
        }
        if (!elementoEncontrado6) {
            System.out.println("Ninguno de los elementos está habilitado.");
            // Puedes manejar esta situación según tus necesidades, por ejemplo, lanzar una excepción
            
        }
        
        WebElement aceptarPaseATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1054-btnWrap")));
        aceptarPaseATM.click();
        WebElement aceptarCreacionPaseATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        aceptarCreacionPaseATM.click();
        
        // Pase ATM a Bóveda
        
        driver.navigate().refresh();
        
        WebElement crearPaseATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
        crearPaseATM2.click();
        WebElement desplegarDivisaATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
        desplegarDivisaATM2.click();
        WebElement seleccionarDivisaATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
        seleccionarDivisaATM2.click();
        WebElement desplegarATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmCP-trigger-picker")));
        desplegarATM2.click();
        WebElement seleccionarATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1003-ATM PA 1']")));
        seleccionarATM2.click();
        WebElement desplegarTipoPaseATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
        desplegarTipoPaseATM2.click();
        WebElement seleccionarTipoPaseATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase Atm a Boveda Normal']")));
        seleccionarTipoPaseATM2.click();
        Thread.sleep(secDelay);
        
        WebElement elementoCantidadATM2 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1037']")); 
        Actions ATM2 = new Actions(driver);
        ATM2.doubleClick(elementoCantidadATM2).perform();	
	           	
        List<WebElement> elementos7 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));
        boolean elementoEncontrado7 = false;
        for (WebElement elemento : elementos7) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elementoCantidadATM2).sendKeys("2").sendKeys(Keys.ENTER).perform();
                elementoEncontrado7 = true;
                break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
            }
        }
        if (!elementoEncontrado7) {
            System.out.println("Ninguno de los elementos está habilitado.");
            // Puedes manejar esta situación según tus necesidades, por ejemplo, lanzar una excepción
            
        }
        
        WebElement aceptarPaseATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1054-btnWrap")));
        aceptarPaseATM2.click();
        WebElement aceptarCreacionPaseATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        aceptarCreacionPaseATM2.click();
        
        // Auxiliar Movimiento
        
        driver.get("http://192.168.2.214:8901/Central/");
        
        WebElement login3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    login3.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement password3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    password3.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
	    WebElement enter3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enter3.click();
        
	    WebElement logistica3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
  	    logistica3.click();
  	    WebElement administracionEfectivo3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
  	    administracionEfectivo3.click();
  	    WebElement auxiliarMovimiento = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auxiliarMovimiento")));
	    auxiliarMovimiento.click();
	    
	    WebElement desplegarTipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
	    desplegarTipoUnidad.click();
	    Thread.sleep(secDelay);
	    WebElement seleccionarTipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Centro de Acopio']")));
	    seleccionarTipoUnidad.click();
	    Thread.sleep(secDelay);
	    WebElement desplegarUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
	    desplegarUnidad.click();
	    Thread.sleep(secDelay);
	    WebElement seleccionarUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1105-CDA PA 3']")));
	    seleccionarUnidad.click();
	    WebElement desplegarDivisa_A = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
	    desplegarDivisa_A.click();
	    WebElement seleccionarDivisa_A = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	    seleccionarDivisa_A.click();
	    WebElement desplegarConsolidar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("consolidar-trigger-picker")));
	    desplegarConsolidar.click();
	    Thread.sleep(secDelay);
	    WebElement seleccionarConsolidar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#boundlist-1069-listEl > li:nth-child(2)")));
	    seleccionarConsolidar.click();
	    WebElement consultarAuxiliar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    consultarAuxiliar1.click();
	    Thread.sleep(secDelay);
	    
	    File archivo1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo1, new File(captura1));
        
        Thread.sleep(secDelay);
	    driver.navigate().refresh();
	    
	    WebElement desplegarTipoUnidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
	    desplegarTipoUnidad2.click();
	    Thread.sleep(secDelay);
	    WebElement seleccionarTipoUnidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agencia']")));
	    seleccionarTipoUnidad2.click();
	    Thread.sleep(secDelay);
	    WebElement desplegarUnidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
	    desplegarUnidad2.click();
	    WebElement seleccionarUnidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1001-AG PA 2']")));
	    seleccionarUnidad2.click();
	    WebElement desplegarDivisa_A2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
	    desplegarDivisa_A2.click();
	    WebElement seleccionarDivisa_A2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	    seleccionarDivisa_A2.click();
	    WebElement desplegarConsolidar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("consolidar-trigger-picker")));
	    desplegarConsolidar2.click();
	    WebElement seleccionarConsolidar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"boundlist-1071-listEl\"]/li[2]")));
	    seleccionarConsolidar2.click();
	    WebElement consultarAuxiliar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    consultarAuxiliar2.click();
	    Thread.sleep(secDelay);
	    
	    File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));
	    
        	
        
	}   
}
