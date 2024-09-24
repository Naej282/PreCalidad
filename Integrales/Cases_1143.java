package Integrales;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
import Constantes.Constantes;
import DataDrivenTesting.ReadExcelFile;
import DataDrivenTesting.WriteExcelFile;

import java.util.List;

public class Cases_1143 {
	
	int secDelay = 1000;

	private WebDriver driver;
	private By searchBoxLocator = By.id("tipoUnidadReceptoraCrear-inputEl");
	private By searchBoxLocator2 = By.id("unidadReceptoraCrear-inputEl");
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.2.214:8901/Central/");
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		
	}
	
	@Test
	public void cases1143() throws IOException, InterruptedException {
		
		// modificar unidad en cierre urgente
		
		//  ---------- Verificación del monto cierre ----------
				
		//guardar 
		
		String directorioCapturas = ""+Constantes.RUTA_CAPTURES+"\\Integrales\\Cases 1143";
	 	String nombreArchivo1 = "1.png";
	 	String captura1 = directorioCapturas + "/" + nombreArchivo1;
	 	
	 	String nombreArchivo2 = "2.png";
	 	String captura2 = directorioCapturas + "/" + nombreArchivo2;
	 	
	 	String nombreArchivo3 = "3.png";
	 	String captura3 = directorioCapturas + "/" + nombreArchivo3;
		
		//Para generar un numero random
		Random random = new Random();
		int GenerarNumeroAleatorio = random.nextInt(15001 - 8000) + 8000;
		
		String NumeroAleatorio = String.valueOf(GenerarNumeroAleatorio);
		
		String NumeroDeServicio = NumeroAleatorio;
		
		//Para las cantidades en los montos
		int GenerarCantidad = (1);
		
		String Cantidad = String.valueOf(GenerarCantidad);
		
				
		//para seleccionar el dia actual
		
		int DiaActual = LocalDate.now().getDayOfMonth();			
        			
        System.out.println(DiaActual);
        
        String DiaActualString = (DiaActual < 10) ? "0" + DiaActual : String.valueOf(DiaActual);
        
        System.out.println(DiaActualString);
        
		
		//ingresar en el ambiente
        
		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
	
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constante_PreCalidad.USUARIO);
		
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	     Thread.sleep(secDelay);
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();
		
		//ingresar en cierre de unidades
		WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("img-menu")));
		Logistica.click();
		
		WebElement AdminEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
		AdminEfectivo.click();
		
		WebElement CierreUnidades = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Image1")));
		CierreUnidades.click();
		
		//realizar acciones en cierre de unidades 
		
		WebElement DespTipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
		DespTipoUnidad.click();
		
		WebElement TipUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Agencia']")));
		TipUnidad.click();
		
		WebElement Unidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen60")));
		Unidad.click();
		
		WebElement NumUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='1110-AG PA 3']")));
		NumUnidad.click();
		
		WebElement DespTipoDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen73")));
		DespTipoDivisa.click();
		
		
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dólar']")));
		Divisa.click();
		
		
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen86")));
		Consultar.click();
		
		WebElement seleccionarDía = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
        seleccionarDía.click();
        
        WebElement Cerrardía = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCerrarDia")));
        Cerrardía.click();
        
        WebElement CerrardíaSi = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1069")));
        CerrardíaSi.click();
        
        Thread.sleep(secDelay);
        Thread.sleep(secDelay);
        
        
        // Capturar screenshot 1 y guardarlo en la carpeta
        
        File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo2, new File(captura2));
        
        Thread.sleep(secDelay);
        Thread.sleep(secDelay);
        
        
        WebElement MensajeCancelar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1066")));
        MensajeCancelar.click();
        
        Thread.sleep(secDelay);
        
        WebElement retroceder = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
        retroceder.click();
        
        //envio paso 1
        
        WebElement envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
        envio.click();
        
        WebElement Crearenvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
        Crearenvio.click();
        
        WebElement DesplegarEnvTipUniEmi = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadEmisoraCrear-trigger-picker")));
        DesplegarEnvTipUniEmi.click();
        
        Thread.sleep(secDelay);
        
        WebElement EnvTipUnidadEmi = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agencia']")));
		EnvTipUnidadEmi.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarEnvUniemi = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadEmisoraCrear-trigger-picker")));
		DesplegarEnvUniemi.click();
		
		Thread.sleep(secDelay);
		
		WebElement EnvUnidadEmi = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1001-AG PA 2']")));
		EnvUnidadEmi.click();
				
		/*probando excel*/
		
        String filepath = ""+Constantes.RUTA_EXCELE+"\\CasesIntegrales.xlsx";
				
		String TipoDeUnidadReceptora = readFile.getCellValue(filepath, "Hoja1", 31, 3);
		String UnidadReceptora = readFile.getCellValue(filepath, "Hoja1", 31, 4);
							
		WebElement DesplegarTipEnvUnirec = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadReceptoraCrear-trigger-picker")));
		DesplegarTipEnvUnirec.click();
		
		Thread.sleep(secDelay);
		
		WebElement inputTipEnvUniemi = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadReceptoraCrear-inputEl")));
		inputTipEnvUniemi.click();
		
		WebElement Enter = driver.findElement(searchBoxLocator);
		Enter.sendKeys(TipoDeUnidadReceptora);
		Enter.sendKeys(Keys.ENTER);
		
		
		WebElement DesplegarEnvioUnidadreceptora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadReceptoraCrear-trigger-picker")));
		DesplegarEnvioUnidadreceptora.click();
		
		Thread.sleep(secDelay);
		
		
		WebElement inputEnvUniemi = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadReceptoraCrear-inputEl")));
		inputEnvUniemi.click();
		
		WebElement EnterRec = driver.findElement(searchBoxLocator2);
		EnterRec.sendKeys(UnidadReceptora);
		EnterRec.sendKeys(Keys.ENTER);
		
		/*Termina el excel*/
		
		WebElement DesplegarEnvTransp = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transportistaCrear-trigger-picker")));
		DesplegarEnvTransp.click();
		
		Thread.sleep(secDelay);
		
		WebElement EnvTransp = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Servicio Panamericano']")));
		EnvTransp.click();
		
		WebElement Siguiente = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnInnerEl")));
		Siguiente.click();
		
		/*Envio paso 2*/
		
		WebElement DesplegarDivisaEnv = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
		DesplegarDivisaEnv.click();
		
		WebElement DivisaEnv = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		DivisaEnv.click();
		
		WebElement ClickInputServicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl")));
		ClickInputServicio.click();
		
		ClickInputServicio.sendKeys(NumeroAleatorio);
		
		WebElement IncluirRemesasCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear")));
		IncluirRemesasCrear.click();
		
		  Thread.sleep(secDelay);
		
		WebElement DesplegarTipoEnvaseCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvaseCrear-trigger-picker")));
		DesplegarTipoEnvaseCrear.click();
		
		WebElement TipoEnvaseCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOLSA']")));
		TipoEnvaseCrear.click();
		
		WebElement DesplegarTipoPiezaCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
		DesplegarTipoPiezaCrear.click();
		
		WebElement TipoPiezaCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billetes']")));
		TipoPiezaCrear.click();
		
		WebElement ClickCantidadEnvases = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
		ClickCantidadEnvases.click();
		
		ClickCantidadEnvases.sendKeys(Cantidad);
		
		WebElement IncluirEnvasesCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear")));
		IncluirEnvasesCrear.click();
		
		  Thread.sleep(secDelay);
		
		WebElement NumeroCrearInput = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
		NumeroCrearInput.click();
		
		NumeroCrearInput.sendKeys(Cantidad);
		
		WebElement IncluirPlomosCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear")));
		IncluirPlomosCrear.click();
		
	    Thread.sleep(secDelay);
		
		WebElement elementoCantidad100 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1163']")); 
        Actions doble = new Actions(driver);
        doble.doubleClick(elementoCantidad100).perform();
        
        Thread.sleep(secDelay);
        
        List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));

        boolean elementoEncontrado = false;
        
        Thread.sleep(secDelay);

        for (WebElement elemento : elementos) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elemento).sendKeys("1").sendKeys(Keys.ENTER).perform();
                elementoEncontrado = true;
                break; // Salir del bucle una vez que se realiza la acción en el primer elemento habilitado
            }
        }

        if (!elementoEncontrado) {
            System.out.println("Ninguno de los elementos está habilitado.");
            
            // Puedes manejar esta situación según tus necesidades, por ejemplo, lanzar una excepción
        }
        
        Thread.sleep(secDelay);
        
        WebElement AceptarCrear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar1-btnWrap")));
        AceptarCrear.click();
        
        Thread.sleep(secDelay);
		
		WebElement AceptarMensajeAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		AceptarMensajeAceptar.click();
		
		//solicitado a aprobado
		
		WebElement BtnFiltros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		BtnFiltros.click();
		
		WebElement NroServicioConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		NroServicioConsulta.click();
		
		Thread.sleep(secDelay);
		
		NroServicioConsulta.sendKeys(NumeroAleatorio);
		
		WebElement NroServicioConsultaAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1224-btnInnerEl")));
		NroServicioConsultaAceptar.click();
		
		WebElement SeleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-row-checker")));
		SeleccionarRemesa.click();
		
		Thread.sleep(secDelay);
		
		WebElement AvanzarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		AvanzarRemesa.click();
		
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		Aceptar.click();
		
		WebElement ConfirmarAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		ConfirmarAceptar.click();
		
		
		
		//aprobado a despachado
		
		WebElement SeleccionarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-row-checker")));
		SeleccionarRemesa2.click();
		
		Thread.sleep(secDelay);
		Thread.sleep(secDelay);
		
		WebElement AvanzarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		AvanzarRemesa2.click();
		
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		Aceptar2.click();
		
		WebElement AceptarSi = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnEl")));
		AceptarSi.click();
		
		WebElement ConfirmarAceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		ConfirmarAceptar2.click();
		
		Thread.sleep(secDelay);
		
		//despachado a devuelto
		
		WebElement SeleccionarRemesa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-row-checker")));
		SeleccionarRemesa3.click();
		
		Thread.sleep(secDelay);
		
		WebElement AvanzarEstadoAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno")));
		AvanzarEstadoAlterno.click();
		
		WebElement DesplegarTiposAvanceEstadoAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
		DesplegarTiposAvanceEstadoAlterno.click();
		
		WebElement TiposAvanceEstadoAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Devuelto']")));
		TiposAvanceEstadoAlterno.click();
		
		WebElement AceptarAvanzarEstadoAlterno = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnEl")));
		AceptarAvanzarEstadoAlterno.click();
		
		WebElement ConfirmarAceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		ConfirmarAceptar3.click();
		
		//devuelto a recibido emisor 
		
		Thread.sleep(secDelay);
		
		WebElement SeleccionarRemesa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-row-checker")));
		SeleccionarRemesa4.click();
		
		Thread.sleep(secDelay);
		
		WebElement AvanzarRemesa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		AvanzarRemesa3.click();
		
		WebElement aceptarAvanzarNomal = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnEl")));
		aceptarAvanzarNomal.click();
		
		WebElement ConfirmarAceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		ConfirmarAceptar4.click();
		
		WebElement retroceder2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
        retroceder2.click();
        
        //volvemos a ingresar en cierre de unidades
		
        WebElement CierreUnidades2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Image1")));
		CierreUnidades2.click();
		
		//realizar acciones en cierre de unidades 
		
		WebElement DespTipoUnidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen47")));
		DespTipoUnidad2.click();
		
		WebElement TipUnidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Agencia']")));
		TipUnidad2.click();
		
		WebElement Unidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen60")));
		Unidad2.click();
		
		WebElement NumUnidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='1001-AG PA 2']")));
		NumUnidad2.click();
		
		WebElement DespTipoDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen73")));
		DespTipoDivisa2.click();
		
		WebElement Divisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Dólar']")));
		Divisa2.click();
		
		WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen86")));
		Consultar2.click();
		
		WebElement seleccionarDía2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sameMonth x-unselectable'][text()='"+  DiaActualString +"']")));
        seleccionarDía2.click();
        
        WebElement Cerrardía2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionCerrarDia")));
        Cerrardía2.click();
        
        WebElement CerrardíaSi2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1069")));
        CerrardíaSi2.click();
        
        Thread.sleep(secDelay);
        Thread.sleep(secDelay);
        
        // Capturar screenshot 1 y guardarlo en la carpeta
        
        File archivo3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo3, new File(captura2));
        
        Thread.sleep(secDelay);
        Thread.sleep(secDelay);
		
        WebElement MensajeCancelar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1066")));
        MensajeCancelar2.click();
        
        Thread.sleep(secDelay);
        
        WebElement retroceder3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retro")));
        retroceder3.click();
        
        //auxiliar de movimiento
        
        WebElement AuxiliarMovimiento = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auxiliarMovimiento")));
        AuxiliarMovimiento.click();
        
        Thread.sleep(secDelay);
        
        WebElement DesplegarTipoUnidadAuxiliar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
        DesplegarTipoUnidadAuxiliar.click();
        
        Thread.sleep(secDelay);
		
		WebElement TipoUnidadAuxiliar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Agencia']")));
		TipoUnidadAuxiliar.click();
        
		WebElement DesplegarDivisaAuxiliar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		DesplegarDivisaAuxiliar.click();
        
		Thread.sleep(secDelay);
		
		WebElement DivisaAuxiliar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
		DivisaAuxiliar.click();
				
		Thread.sleep(secDelay);
			
		WebElement DesplegarConsolidarAuxiliar = driver.findElement(By.id("consolidar-trigger-picker"));
        DesplegarConsolidarAuxiliar.click();
        
        // Espera a que las opciones sean visibles
        List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        
        // Itera sobre las opciones y selecciona la que coincida con el texto
        for (WebElement option : options2) {
            if (option.getText().equals("Dólar")) {
                option.click();
                break;
            
                }
            }
		
		WebElement DesplegarUnidadAuxiliar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
		DesplegarUnidadAuxiliar.click();
		
		Thread.sleep(secDelay);
		
		WebElement UnidadAuxiliar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1001-AG PA 2']")));
		UnidadAuxiliar.click();
		
		WebElement ConsultarAuxiliar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		ConsultarAuxiliar.click();
		
		Thread.sleep(secDelay);
        Thread.sleep(secDelay);
        
        // Capturar screenshot 1 y guardarlo en la carpeta
        
        File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(archivo4, new File(captura3));
    		 		
		
	}
	
}
