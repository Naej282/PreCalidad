package Integrales;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constantes.Constante_PreCalidad;
import DataDrivenTesting.ReadExcelFile;
import DataDrivenTesting.WriteExcelFile;

public class Cases_387 {
	
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
		
		driver.get("http://192.168.2.214:8901/AdmonPerfiles/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InterruptedException {
		
		// ---------- Admin Perfiles Central ----------
		
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		 	
		String Agencia = "http://192.168.2.214:8901/Agencia";
		String Central = "http://192.168.2.214:8901/Central";
		
		String directorioCapturas = "C:/Users/gsarmiento/Desktop/Cases Integrales - Automatización/Cases 387";
		
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
	 	
	 	String nombreArchivo3 = "3.png";
	 	String captura3 = directorioCapturas + "/" + nombreArchivo3;
	 	
	 	String nombreArchivo4 = "4.png";
	 	String captura4 = directorioCapturas + "/" + nombreArchivo4;
	 	
	 	String nombreArchivo5 = "5.png";
	 	String captura5 = directorioCapturas + "/" + nombreArchivo5;
	 	
		String nombreArchivo6 = "6.png";
	 	String captura6 = directorioCapturas + "/" + nombreArchivo6;
	 	
		String nombreArchivo7 = "7.png";
	 	String captura7 = directorioCapturas + "/" + nombreArchivo7;
	 	
		String nombreArchivo8 = "8.png";
	 	String captura8 = directorioCapturas + "/" + nombreArchivo8;
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    login.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enter.click();
	    
	    // Perfiles
	    
	    WebElement Perfiles = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profileMenu")));
	    Perfiles.click();
	    Thread.sleep(secDelay);
	    WebElement ImprimirPerfiles = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
	    ImprimirPerfiles.click();
	    Thread.sleep(secDelay);
	    WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formato-trigger-picker")));
	    DesplegarFormato.click();
	    WebElement SeleccionarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
	    SeleccionarFormato.click();
	    WebElement AceptarImprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1027-btnWrap")));
	    AceptarImprimir.click();
	       		    
	    WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	    Inicio.click();
	    
	    // Usuarios Internos
	    
	    WebElement UsuarioInternos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userMenu")));
	    UsuarioInternos.click();
	    Thread.sleep(secDelay);
	    WebElement SeleccionarUsuario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Guillermo Sarmiento']")));
	    SeleccionarUsuario.click();
	    WebElement ModificarUsuario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	    ModificarUsuario.click();
	    Thread.sleep(secDelay);
	    WebElement SeleccionarGrupo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='CasesPruebasCentral']")));
	    SeleccionarGrupo.click();
	    WebElement AceptarModificacionUsuario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1046-btnWrap")));
	    AceptarModificacionUsuario.click();
	    WebElement AceptarMensaje = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	    AceptarMensaje.click();
	    WebElement AceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    AceptarMensajeInformativo.click();
	    
	    WebElement SalirAplicación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("salir")));
	    SalirAplicación.click();
	    WebElement SalirAplicaciónAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	    SalirAplicaciónAceptar.click();
	    
	    // Agemcia
	    		    		    		    
	    js.executeScript("window.open(arguments[0]);", Agencia);	  
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	    String Agencia1 = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(Agencia1);
	    
	    WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
	    WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterAgencia.click();
	    
	    Thread.sleep(secDelay);
	    File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo, new File(captura1));    
        Thread.sleep(secDelay);
        
        // Central
        
        js.executeScript("window.open(arguments[0]);", Central);	  
	    
	    Set<String> handle2 = driver.getWindowHandles();
	    
	    String Central2 = (String) handle2.toArray()[handle2.size() - 1];
	    driver.switchTo().window(Central2);
	    
	    WebElement loginCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginCentral.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordCentral.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
	    WebElement enterCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterCentral.click();
	    
	    WebElement logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
        logistica.click();
        WebElement AdministraciónEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
        AdministraciónEfectivo.click();
        WebElement Envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
        Envios.click();
        
        WebElement Filtros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
        Filtros.click();
        Thread.sleep(secDelay);
        
        WebElement DesplegarEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estadoConsulta-trigger-picker")));
        DesplegarEstado.click();
        Thread.sleep(secDelay);
        Thread.sleep(secDelay);
        Thread.sleep(secDelay);
  	    WebElement SeleccopmarEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aprobado']")));
  	    SeleccopmarEstado.click();
  	  Thread.sleep(secDelay);        
        WebElement ConsultarFiltros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
        ConsultarFiltros.click();	       
        
        WebElement seleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesa.click();
        Thread.sleep(secDelay);
        WebElement AvanzarEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        AvanzarEstado.click();  
       
        Thread.sleep(secDelay);
	    File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));    
        Thread.sleep(secDelay);
        
        WebElement AceptarMensajeAdvertencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
        AceptarMensajeAdvertencia.click(); 
	     	    
        WebElement BotónAvanceAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnWrap")));
        BotónAvanceAlterno.click();
        
        Thread.sleep(secDelay);
	    File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo3, new File(captura3));    
        Thread.sleep(secDelay);
        
        WebElement AceptarMensajeAdvertencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
        AceptarMensajeAdvertencia2.click();
        
        WebElement BotónReversar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
        BotónReversar.click();
        
        Thread.sleep(secDelay);
		File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(archivo4, new File(captura4));    
	    Thread.sleep(secDelay);
	           
	    WebElement AceptarReverso = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnWrap")));
        AceptarReverso.click();
	    
        WebElement AceptarMensajeAdvertencia3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
        AceptarMensajeAdvertencia3.click();
        
        WebElement CrearRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
        CrearRemesa.click();
        
        WebElement AceptarMensajeAdvertencia4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
        AceptarMensajeAdvertencia4.click();
        
        // Unidades
        
        WebElement InicioCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	    InicioCentral.click();
        
        WebElement configuración = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
	    configuración.click();
	    WebElement Unidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad")));
	    Unidad.click();
	    WebElement Unidades = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Unidad")));
	    Unidades.click();
	    WebElement ConsultarUnidades = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnWrap")));
	    ConsultarUnidades.click();
	    
	    // Modificar Unidades
        
        WebElement seleccionarUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='AG PA 2']")));
        seleccionarUnidad.click();
        WebElement modificarUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
        modificarUnidad.click();
        
        WebElement campoDirección = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("direccionModificar-inputEl")));
	    Thread.sleep(secDelay);
	    String Valor = campoDirección.getAttribute("value");
	    Thread.sleep(secDelay);	    
	    System.out.println(Valor);
	    campoDirección.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
	    campoDirección.sendKeys("ccs");    
        
	    WebElement aceptarModificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarModificar-btnWrap")));
        aceptarModificación.click();
        WebElement confirmacionModificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
        confirmacionModificación.click();
        
        Thread.sleep(secDelay);
 		File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		FileUtils.copyFile(archivo5, new File(captura5));    
 		Thread.sleep(secDelay);
        
        WebElement aceptarMsjInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        aceptarMsjInformativo.click();
	    
        // Crear Unidades
        
        WebElement crearUnidades = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
	    crearUnidades.click();
        
        Thread.sleep(secDelay);
 		File archivo6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		FileUtils.copyFile(archivo6, new File(captura6));    
 		Thread.sleep(secDelay);
 		
 		WebElement aceptarAdvertenciaUnidades = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    aceptarAdvertenciaUnidades.click();
	    
	    // AdminPerfiles - Regreso
	    
	    String AdminPerfiles = (String) handles.toArray()[handles.size() - 2];
	    driver.switchTo().window(AdminPerfiles);
	    
	    WebElement login2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    login2.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement password2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    password2.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    WebElement enter2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enter2.click();
        
	    WebElement configuracion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("configurationMenu")));
	    configuracion.click();
	    WebElement selectConfiguracion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='COD_TIPO_PERIODO']")));
	    selectConfiguracion.click();
	    WebElement modificarConfig = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	    modificarConfig.click();
	    
        Thread.sleep(secDelay);
 		File archivo7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		FileUtils.copyFile(archivo7, new File(captura8));    
 		Thread.sleep(secDelay);
 		
 		WebElement aceptarAdvertenciaConfig = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    aceptarAdvertenciaConfig.click();
	    
	    WebElement imprimirConfig = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
	    imprimirConfig.click();
 		
        Thread.sleep(secDelay);
 		File archivo8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		FileUtils.copyFile(archivo8, new File(captura8));    
 		Thread.sleep(secDelay);
 		
 		WebElement aceptarAdvertenciaConfig2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    aceptarAdvertenciaConfig2.click();
        
	    WebElement inicioAdmonPerfiles = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	    inicioAdmonPerfiles.click();
	    
	    WebElement UsuariosInternos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userMenu")));
	    UsuariosInternos.click();
	    WebElement SeleccionarUsuario2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Guillermo Sarmiento']")));
	    SeleccionarUsuario2.click();
	    WebElement ModificarUsuario2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	    ModificarUsuario2.click();
	    Thread.sleep(secDelay);
	    WebElement SeleccionarGrupo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Acceso Total']")));
	    SeleccionarGrupo2.click();
	    WebElement AceptarModificacionUsuario2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1046-btnWrap")));
	    AceptarModificacionUsuario2.click();
	    WebElement AceptarMensaje2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	    AceptarMensaje2.click();
	    WebElement AceptarMensajeInformativo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    AceptarMensajeInformativo2.click();
	    	      
	}
}