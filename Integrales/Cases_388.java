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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constantes.Constante_PreCalidad;
import DataDrivenTesting.ReadExcelFile;
import DataDrivenTesting.WriteExcelFile;

public class Cases_388 {
	
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
		
		// ----------- Admin Perfiles Agencia ----------
		
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		 	
		String Agencia = "http://192.168.2.214:8901/Agencia";
		String Central = "http://192.168.2.214:8901/Central";
		
		String directorioCapturas = ""+Constante_PreCalidad.RUTA_CAPTURES+"/Integrales/Cases 388";
		
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
	    Thread.sleep(secDelay);
	    WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enter.click();
	    
	    // Perfiles
	    
	    WebElement Perfiles = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profileMenu")));
	    Perfiles.click();
	    Thread.sleep(7000);
	    WebElement ImprimirPerfiles = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
	    ImprimirPerfiles.click();
	    Thread.sleep(5000);
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
	    WebElement SeleccionarUsuario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Jean Carrasco']")));
	    SeleccionarUsuario.click();
	    WebElement ModificarUsuario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	    ModificarUsuario.click();
	    Thread.sleep(secDelay);
	    WebElement SeleccionarGrupo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='CasesPruebasAgencia']")));
	    SeleccionarGrupo.click();
	    Thread.sleep(secDelay);
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
	    
	    // Central
	    		    		    		    
	    js.executeScript("window.open(arguments[0]);", Central);	  
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	    String Central1 = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(Central1);
	    
	    WebElement loginCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginCentral.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordCentral.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
	    WebElement enterCentral = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterCentral.click();
	    
	    Thread.sleep(secDelay);
	    File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo, new File(captura1));    
        Thread.sleep(secDelay);
        
        // Agencia
        
        js.executeScript("window.open(arguments[0]);", Agencia);	  
	    
	    Set<String> handle2 = driver.getWindowHandles();
	    
	    String Agencia2 = (String) handle2.toArray()[handle2.size() - 1];
	    driver.switchTo().window(Agencia2);
	    
	    WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);
	    WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterAgencia.click();
	    
	    WebElement Caja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
        Caja.click();
        WebElement PasesBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
        PasesBoveda.click();
        
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
	    
	    js1.executeScript("window.scrollBy(0,500)");

        WebElement CrearPaseBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
        CrearPaseBoveda.click();
                
        Thread.sleep(secDelay);
	    File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));    
        Thread.sleep(secDelay);
        
        WebElement AceptarMensajeAdvertencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarMensajeAdvertencia.click(); 
               
        WebElement BotonModificar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
        BotonModificar.click();
	     	           
        Thread.sleep(secDelay);
	    File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo3, new File(captura3));    
        Thread.sleep(secDelay);
        
        WebElement AceptarMensajeAdvertencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarMensajeAdvertencia2.click(); 
        
        WebElement BotonImprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
        BotonImprimir.click();
                
        WebElement BotonEliminar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("panelPapelera-innerCt")));
        BotonEliminar.click();
                
        // Pases ATM
        
        WebElement InicioAgencia  = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	    InicioAgencia .click();
        
        WebElement ATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
	    ATM.click();
	    WebElement PasesATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
	    PasesATM.click();
	    WebElement CrearPaseATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    CrearPaseATM.click();
	    
	    WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
	    DesplegarDivisa.click();
	    WebElement SelectDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	    SelectDivisa.click();
	    WebElement DesplegarATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atmCP-trigger-picker")));
	    DesplegarATM.click();
	    WebElement SelectATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='2220-ATM PA 4']")));
	    SelectATM.click();
	    WebElement DesplegarTipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPaseCP-trigger-picker")));
	    DesplegarTipoPase.click();
	    WebElement SelectTipoPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pase Boveda a Atm Normal']")));
	    SelectTipoPase.click();
	    Thread.sleep(secDelay);
	    
        WebElement elementoCantidadATM = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1037']")); 
        Actions ATM1 = new Actions(driver);
        ATM1.doubleClick(elementoCantidadATM).perform();	
	           	
        WebElement elementoColocarCantidadATM = driver.findElement(By.id("ext-element-12"));
        if (elementoColocarCantidadATM.isEnabled()) {
        	Actions actions = new Actions(driver);
         	actions.click(elementoColocarCantidadATM).sendKeys("1").sendKeys(Keys.ENTER).perform();
         	Thread.sleep(secDelay);
        }
        
        WebElement AceptarCreacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1054-btnWrap")));
	    AceptarCreacion.click();
	    WebElement aceptarCreacionPaseATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        aceptarCreacionPaseATM.click();
	    	    
	    WebElement SelectPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[data-boundview='gridview-1017']")));
        SelectPase.click();
        WebElement AvanzarPase = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarPase-btnWrap")));
        AvanzarPase.click();
        
        Thread.sleep(secDelay);
	    File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo4, new File(captura4));    
        Thread.sleep(secDelay);
        
        WebElement AceptarAdvertencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarAdvertencia.click();
	    
        WebElement BotonModificarATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
        BotonModificarATM.click();
        
        Thread.sleep(secDelay);
	    File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo5, new File(captura5));    
        Thread.sleep(secDelay);
        
        WebElement AceptarAdvertencia2= ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarAdvertencia2.click();
        
        WebElement BotonImprimirATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
        BotonImprimirATM.click();
               
        Thread.sleep(secDelay);
	    File archivo6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo6, new File(captura6));    
        Thread.sleep(secDelay);
        
        WebElement AceptarAdvertencia3= ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
        AceptarAdvertencia3.click();
        
        // arrastre de registro 
        
        WebElement draggableElement = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[data-boundview='gridview-1017']")));
        draggableElement.click();
        
        WebElement dropZone = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("panelPapelera-innerCt")));
        dropZone.click();
        
        Actions actions = new Actions(driver);
        
        actions.dragAndDrop(draggableElement, dropZone).build().perform();
            	    
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
	    WebElement SeleccionarUsuario2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Jean Carrasco']")));
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