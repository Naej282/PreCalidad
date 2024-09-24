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

public class Cases_340 {
	
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
		
		// ---------- Paramettro Pases Monedas Permitidas ATM ----------

		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String ventanaParametrosGenerales = "http://192.168.2.214:8901/Central/parametrosCentral.action";
		String ventanaAgencia = "http://192.168.2.214:8901/Agencia/";
		
		String directorioCapturas = "C:/Users/gsarmiento/Desktop/Cases Integrales - Automatización/Cases 340";
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
	 	
	 	String nombreArchivo9 = "9.png";
	 	String captura9 = directorioCapturas + "/" + nombreArchivo9;
	 	
	 	String nombreArchivo10 = "10.png";
	 	String captura10 = directorioCapturas + "/" + nombreArchivo10;
	 	
	 	String nombreArchivo11 = "11.png";
	 	String captura11 = directorioCapturas + "/" + nombreArchivo11;
	 	
	 	String nombreArchivo12 = "12.png";
	 	String captura12 = directorioCapturas + "/" + nombreArchivo12;
	 	
		String nombreArchivo13 = "13.png";
	 	String captura13 = directorioCapturas + "/" + nombreArchivo13;
	 	
		String nombreArchivo14 = "14.png";
	 	String captura14 = directorioCapturas + "/" + nombreArchivo14;
	 	
		String nombreArchivo15 = "15.png";
	 	String captura15 = directorioCapturas + "/" + nombreArchivo15;
	 	
		String nombreArchivo16 = "16.png";
	 	String captura16 = directorioCapturas + "/" + nombreArchivo16;
	 	
		String nombreArchivo17 = "17.png";
	 	String captura17 = directorioCapturas + "/" + nombreArchivo17;
	 	
		String nombreArchivo18 = "18.png";
	 	String captura18 = directorioCapturas + "/" + nombreArchivo18;

		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    login.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);	
	    WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enter.click();
	    
	    // 1-Divisas en el sistemas
	    
	    WebElement configuración = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/configuracion.jpg']")));
	    configuración.click();
	    WebElement Billetes_Momedas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billetesMonedas")));
	    Billetes_Momedas.click();
	    WebElement divisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Divisa")));
	    divisas.click();
	    Thread.sleep(secDelay);	
	    
	    File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo, new File(captura1));       
        Thread.sleep(secDelay);	
        
        // 2-Parametros
        
        js.executeScript("window.open(arguments[0]);", ventanaParametrosGenerales);	  
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	    String Envios = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(Envios);	 
	    
	    
	    WebElement modificables = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-1026")));
	    modificables.click(); 	    
	    WebElement selectParametro = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PASES_MONEDAS_PERMITIDAS_ATM']")));
	    selectParametro.click(); 
	    
	    WebElement modificar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	    modificar.click(); 	 
	    Thread.sleep(secDelay);	
	    File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));    	    
	    WebElement modificarValor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    Thread.sleep(secDelay);
	    String Valor = modificarValor.getAttribute("value");
	    Thread.sleep(secDelay);	    
	    System.out.println(Valor);
	    modificarValor.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
	    modificarValor.sendKeys("3");   
	    
	    File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo3, new File(captura3));    
        
        WebElement aceptarModificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnWrap")));
	    aceptarModificación.click(); 	    
	    WebElement aceptarMensajeConfirmación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	    aceptarMensajeConfirmación.click(); 
	    WebElement aceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    aceptarMensajeInformativo.click(); 
	    
	    // 4-Agencia Pases ATM
		
	    js.executeScript("window.open(arguments[0]);", ventanaAgencia);	  
	    
	    Set<String> handles2 = driver.getWindowHandles();
	    
	    String Agencia = (String) handles2.toArray()[handles2.size() - 1];
	    driver.switchTo().window(Agencia);	
	    
	    Thread.sleep(secDelay);	
	    WebElement loginAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    loginAgencia.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement passwordAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    passwordAgencia.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    Thread.sleep(secDelay);	
	    WebElement enterAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enterAgencia.click();
	    	    
	    WebElement ATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("atm")));
	    ATM.click();
	    WebElement pasesATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
	    pasesATM.click();
	    
	    WebElement desplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
	    desplegarDivisa.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo4, new File(captura4));    
        
	    WebElement crear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    crear.click();
	    WebElement desplegarDivisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
	    desplegarDivisas.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo5, new File(captura5)); 
        
        Thread.sleep(secDelay);
        WebElement cancelar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1057-btnWrap")));
        cancelar.click();
        
        WebElement regresar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
	    regresar.click();
	    
	    // 5-Efectivo ATM 
	    
	    WebElement efectivoATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efectivo")));
	    efectivoATM.click();
	    Thread.sleep(secDelay);	  
	    WebElement desplegarDivisaEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
	    desplegarDivisaEfectivo.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo6, new File(captura6));
        Thread.sleep(secDelay);		        
        
        WebElement regresar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
	    regresar2.click();
	    
	    // 6-Arqueo ATM
	    
	    WebElement arqueoATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("arqueo")));
	    arqueoATM.click();
	    Thread.sleep(secDelay);		     
	    WebElement desplegarDivisaArqueo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasArqueo-trigger-picker")));
	    desplegarDivisaArqueo.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo7, new File(captura7));    
        
        WebElement crearArqueo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    crearArqueo.click();
	    Thread.sleep(secDelay);		      
	    WebElement desplegarDivisasArqueo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
	    desplegarDivisasArqueo.click();		 
	    
	    Thread.sleep(secDelay);	
	    File archivo8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo8, new File(captura8)); 
	    Thread.sleep(secDelay);	
        
	    WebElement cancelar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1121-btnWrap")));
        cancelar2.click();
        
        WebElement regresar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
	    regresar3.click();
        
	    // 7-Diferencia ATM
	    
	    WebElement diferenciaATM = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencia")));
	    diferenciaATM.click();
	    Thread.sleep(secDelay);		        
	    WebElement desplegarDivisaDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
	    desplegarDivisaDiferencia.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo9 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo9, new File(captura9)); 
	    Thread.sleep(secDelay);	
	    
	    WebElement crearDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    crearDiferencia.click();
	    Thread.sleep(secDelay);	
	    WebElement desplegarDivisasDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaDC-trigger-picker")));
	    desplegarDivisasDiferencia.click();		 
	    
	    Thread.sleep(secDelay);	
	    File archivo10 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo10, new File(captura10)); 

        WebElement cancelar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1050-btnWrap")));
        cancelar3.click();
        
        WebElement regresar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
	    regresar4.click();
        
        // 8-Regresar Parametros
	    	    	        
	    String volverParametros = (String) handles.toArray()[handles.size() - 1];
	    driver.switchTo().window(volverParametros);	
	    
	    WebElement selectParametro2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PASES_MONEDAS_PERMITIDAS_ATM']")));
	    selectParametro2.click(); 
	    
	    WebElement modificar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionModificar")));
	    modificar2.click(); 	 
	    Thread.sleep(secDelay);	
	       
	    WebElement regresarValor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorModificar-inputEl")));
	    Thread.sleep(secDelay);
	    String Valor2 = regresarValor.getAttribute("value");
	    Thread.sleep(secDelay);	    
	    System.out.println(Valor2);
	    regresarValor.sendKeys(Keys.chord(Keys.CONTROL, "a"));	
	    regresarValor.sendKeys(Valor);   
	    
	    File archivo11 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo11, new File(captura11)); 
        		   	        
	    Thread.sleep(secDelay);	   
        WebElement aceptarModificación2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1035-btnWrap")));
	    aceptarModificación2.click(); 	    
	    WebElement aceptarMensajeConfirmación2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1006-btnWrap")));
	    aceptarMensajeConfirmación2.click(); 
	    WebElement aceptarMensajeInformativo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnWrap")));
	    aceptarMensajeInformativo2.click(); 
	    
	    // 9-Validar Cambio Pases ATM
	    
	    String volverAgencia = (String) handles2.toArray()[handles2.size() - 1];
	    driver.switchTo().window(volverAgencia);	
	    
	    Thread.sleep(secDelay);	 
	    WebElement pasesATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pasesDeBoveda")));
	    pasesATM2.click();
	    Thread.sleep(secDelay);	
	    WebElement desplegarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
	    desplegarDivisa2.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo12 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo12, new File(captura12));    
        
	    WebElement crear2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    crear2.click();
	    WebElement desplegarDivisas2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaCP-trigger-picker")));
	    desplegarDivisas2.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo13 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo13, new File(captura13)); 
        
        Thread.sleep(secDelay);
        WebElement cancelar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1057-btnWrap")));
        cancelar4.click();
        
        WebElement regresar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
	    regresar5.click();
	    
	    // 5-Efectivo ATM 
	    
	    WebElement efectivoATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efectivo")));
	    efectivoATM2.click();
	    Thread.sleep(secDelay);	
	    WebElement desplegarDivisaEfectivo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
	    desplegarDivisaEfectivo2.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo14 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo14, new File(captura14));
        Thread.sleep(secDelay);		        
        
        WebElement regresar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
	    regresar6.click();
	    
	    // 6-Arqueo ATM
	    
	    WebElement arqueoATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("arqueo")));
	    arqueoATM2.click();
	    Thread.sleep(secDelay);	
	    WebElement desplegarDivisaArqueo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasArqueo-trigger-picker")));
	    desplegarDivisaArqueo2.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo15 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo15, new File(captura15));    
        
        WebElement crearArqueo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    crearArqueo2.click();
	    Thread.sleep(secDelay);	
	    WebElement desplegarDivisasArqueo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
	    desplegarDivisasArqueo2.click();		 
	    
	    Thread.sleep(secDelay);	
	    File archivo16 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo16, new File(captura16)); 
	    Thread.sleep(secDelay);	
        
	    WebElement cancelar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1121-btnWrap")));
        cancelar5.click();
        
        WebElement regresar7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
	    regresar7.click();
        
	    // 7-Diferencia ATM
	    
	    WebElement diferenciaATM2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencia")));
	    diferenciaATM2.click();
	    Thread.sleep(secDelay);	
	    WebElement desplegarDivisaDiferencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisasPases-trigger-picker")));
	    desplegarDivisaDiferencia2.click();
	    
	    Thread.sleep(secDelay);	
	    File archivo17 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo17, new File(captura17)); 
	    Thread.sleep(secDelay);	
	    
	    WebElement crearDiferencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCrear")));
	    crearDiferencia2.click();
	    Thread.sleep(secDelay);	
	    WebElement desplegarDivisasDiferencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaDC-trigger-picker")));
	    desplegarDivisasDiferencia2.click();		 
	    
	    Thread.sleep(secDelay);	
	    File archivo18 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo18, new File(captura18)); 

        WebElement cancelar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1050-btnWrap")));
        cancelar6.click();
	    		   		    	    
	}
}