package Integrales;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constantes.Constante_PreCalidad;
import DataDrivenTesting.ReadExcelFile;
import DataDrivenTesting.WriteExcelFile;

public class Cases_1102 {

	int secDelay = 3000;

	private WebDriver driver;
	private By searchBoxLocator = By.id("tipoUnidadReceptoraCrear-inputEl");
	private By searchBoxLocator2 = By.id("unidadReceptoraCrear-inputEl");
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		
		driver.get("http://192.168.2.214:8901/Central/");
	}
	
	@Test
	public void cases1143() throws IOException, InterruptedException {
		
		//  ---------- Validar la traza de avance y reverso de una remesa de Centro Acopio a Oficina ----------		 

		
		//Para generar un numero random
		
		Random random = new Random();
		int GenerarNumeroAleatorio = random.nextInt(15001 - 8000) + 8000;
		
		String NumeroAleatorio = String.valueOf(GenerarNumeroAleatorio);
		
		String NumeroDeServicio = NumeroAleatorio;
		
		//Para las cantidades en los montos
		
		int GenerarCantidad = (1);
		
		String Cantidad = String.valueOf(GenerarCantidad);
		
		//ingresar en el ambiente
        
  		WebDriverWait ewait = new WebDriverWait(driver,20); //Espera Explícita
  	
  		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
  		login.sendKeys(Constante_PreCalidad.USUARIO);
  		
  		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
  		password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
		Thread.sleep(secDelay);
  		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
  		logear.click();
  		
  		WebElement Logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("img-menu")));
  		Logistica.click();
  		
  		WebElement AdminEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
  		AdminEfectivo.click();
		  
		//envio paso 1
		  
		WebElement envio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
		envio.click();
		  
	    WebElement Crearenvio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
		Crearenvio.click();
        
        Thread.sleep(secDelay);
        
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
		
        String filepath = "C:\\Users\\gsarmiento\\Desktop\\Cases Integrales - Automatización\\CasesIntegrales.xlsx";
				
		String TipoDeUnidadReceptora = readFile.getCellValue(filepath, "Hoja1", 35, 1);
		String UnidadReceptora = readFile.getCellValue(filepath, "Hoja1", 35, 2);
					
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
		
/*		// Encontrar el elemento que quieres verificar
		
	    WebElement Localizador = driver.findElement(By.id("destinoCrear-trigger-picker"));
	
	    // Verificar si el elemento está habilitado
	    
	    if (Localizador.isEnabled()) {
	        System.out.println("El elemento está habilitado.");
	        
        WebElement DesplegarDestino = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("destinoCrear-trigger-picker")));
        	DesplegarDestino.click();
			
		Thread.sleep(secDelay);
		
		WebElement Destino = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Boveda']")));
			Destino.click();
	        
	    } else {
	        System.out.println("El elemento está deshabilitado.");
	    }
		*/
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
		
		Thread.sleep(secDelay);
		
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
        Thread.sleep(secDelay);
        
        List<WebElement> elementos = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28']"));

        Thread.sleep(secDelay);
        
        boolean elementoEncontrado = false;

        for (WebElement elemento : elementos) {
            if (elemento.isEnabled()) {
                Actions actions = new Actions(driver);
                actions.click(elemento).sendKeys("3").sendKeys(Keys.ENTER).perform();
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
		
		WebElement AceptarMensajeAceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		AceptarMensajeAceptar.click();
		
		//solicitado a aprobado
		
		WebElement BtnFiltros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnEl")));
		BtnFiltros.click();
		
		WebElement NroServicioConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		NroServicioConsulta.click();
		
		NroServicioConsulta.sendKeys(NumeroDeServicio);
		
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
		
		Thread.sleep(secDelay);
		
		WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio.click();
		
		Thread.sleep(secDelay);
		
		WebElement Auditoria = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/auditoria.jpg']")));
		Auditoria.click();
		
		WebElement AuditoriaDeUsuarios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auditoriaUsuarios")));
		AuditoriaDeUsuarios.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarUsuarios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("codUsuario-trigger-picker")));
		DesplegarUsuarios.click();
		
		Thread.sleep(secDelay);
		
		WebElement Usuarios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='gsarmiento']")));
		Usuarios.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarProceso = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("proceso-trigger-picker")));
		DesplegarProceso.click();
		
		Thread.sleep(secDelay);
		
		WebElement Proceso = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Remesa']")));
		Proceso.click();
		
		WebElement DesplegarOperacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("operacion-trigger-picker")));
		DesplegarOperacion.click();
		
		Thread.sleep(secDelay);
		
		WebElement Operacion = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Modificar']")));
		Operacion.click();
		
		Thread.sleep(secDelay);
		
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		Consultar.click();
		
		Thread.sleep(secDelay);
		
		WebElement Imprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato.click();
		
		Thread.sleep(secDelay);
		
		WebElement Formato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		Formato.click();
		
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1047-btnInnerEl")));
		Aceptar2.click();
		
		Thread.sleep(secDelay);
		
		WebElement Inicio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio2.click();
		
		Thread.sleep(secDelay);
		
		WebElement Logistica2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("img-menu")));
  		Logistica2.click();
  		
  		WebElement AdminEfectivo2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
  		AdminEfectivo2.click();
		  
		  WebElement envio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
		  envio2.click();
		  
		  Thread.sleep(secDelay);
		  
		  WebElement Filtros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnInnerEl")));
		  Filtros.click();
		  
		  Thread.sleep(secDelay);
		  
		  WebElement NumeroDeServicio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		  NumeroDeServicio2.click();
		  Thread.sleep(secDelay);
		  NumeroDeServicio2.sendKeys(NumeroAleatorio);
		  
		  Thread.sleep(secDelay);
		  
		  WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnInnerEl")));
		  Consultar2.click();	  
	  
		
		//aprobado a despachado
		
		WebElement SeleccionarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-row-checker")));
		SeleccionarRemesa2.click();
		
		Thread.sleep(secDelay);
		Thread.sleep(secDelay);
		
		WebElement AvanzarRemesa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		AvanzarRemesa2.click();
		
		WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		Aceptar3.click();
		
		WebElement AceptarSi = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnEl")));
		AceptarSi.click();
		
		WebElement ConfirmarAceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		ConfirmarAceptar2.click();
		
		Thread.sleep(secDelay);
		
		WebElement Inicio3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio3.click();
		
		Thread.sleep(secDelay);
		
		WebElement Auditoria2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/auditoria.jpg']")));
		Auditoria2.click();
		
		WebElement AuditoriaDeUsuarios2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auditoriaUsuarios")));
		AuditoriaDeUsuarios2.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarUsuarios2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("codUsuario-trigger-picker")));
		DesplegarUsuarios2.click();
		
		Thread.sleep(secDelay);
		
		WebElement Usuarios2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='gsarmiento']")));
		Usuarios2.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarProceso2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("proceso-trigger-picker")));
		DesplegarProceso2.click();
		
		Thread.sleep(secDelay);
		
		WebElement Proceso2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Remesa']")));
		Proceso2.click();
		
		WebElement DesplegarOperacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("operacion-trigger-picker")));
		DesplegarOperacion2.click();
		
		Thread.sleep(secDelay);
		
		WebElement Operacion2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Modificar']")));
		Operacion2.click();
		
		Thread.sleep(secDelay);
		
		WebElement Consultar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		Consultar3.click();
		
		Thread.sleep(secDelay);
		
		WebElement Imprimir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir2.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato2.click();
		
		Thread.sleep(secDelay);
		
		WebElement Formato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		Formato2.click();
		
		WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1047-btnInnerEl")));
		Aceptar4.click();
		
		Thread.sleep(secDelay);
		
		WebElement Inicio4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio4.click();
		
		Thread.sleep(secDelay);
		
		WebElement Logistica3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("img-menu")));
  		Logistica3.click();
  		
  		WebElement AdminEfectivo3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
  		AdminEfectivo3.click();
		  
		WebElement envio3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
		envio3.click();
		  
		Thread.sleep(secDelay);
		  
		WebElement Filtros2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnInnerEl")));
		Filtros2.click();
		  
		Thread.sleep(secDelay);
		  
		WebElement NumeroDeServicio3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		NumeroDeServicio3.click();
		Thread.sleep(secDelay);
		NumeroDeServicio3.sendKeys(NumeroAleatorio);
		  
		Thread.sleep(secDelay);
		  
		WebElement Consultar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnInnerEl")));
		Consultar5.click();
		
		Thread.sleep(secDelay);
		
		//Despachado a recibido
		
		WebElement SeleccionarRemesa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-row-checker")));
		SeleccionarRemesa3.click();
		
		Thread.sleep(secDelay);
		
		WebElement AvanzarRemesa3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		AvanzarRemesa3.click();
		
		WebElement Aceptar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		Aceptar5.click();
		
		WebElement ConfirmarAceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		ConfirmarAceptar3.click();
		
		Thread.sleep(secDelay);
		
		WebElement Inicio5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio5.click();
		
		Thread.sleep(secDelay);
		
		WebElement Auditoria3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/auditoria.jpg']")));
		Auditoria3.click();
		
		WebElement AuditoriaDeUsuarios3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auditoriaUsuarios")));
		AuditoriaDeUsuarios3.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarUsuarios3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("codUsuario-trigger-picker")));
		DesplegarUsuarios3.click();
		
		Thread.sleep(secDelay);
		
		WebElement Usuarios3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='gsarmiento']")));
		Usuarios3.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarProceso3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("proceso-trigger-picker")));
		DesplegarProceso3.click();
		
		Thread.sleep(secDelay);
		
		WebElement Proceso3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Remesa']")));
		Proceso3.click();
		
		WebElement DesplegarOperacion3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("operacion-trigger-picker")));
		DesplegarOperacion3.click();
		
		Thread.sleep(secDelay);
		
		WebElement Operacion3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Modificar']")));
		Operacion3.click();
		
		Thread.sleep(secDelay);
		
		WebElement Consultar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		Consultar4.click();
		
		Thread.sleep(secDelay);
		
		WebElement Imprimir3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir3.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarFormato3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato3.click();
		
		Thread.sleep(secDelay);
		
		WebElement Formato3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		Formato3.click();
		
		WebElement Aceptar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1047-btnInnerEl")));
		Aceptar6.click();
		
		Thread.sleep(secDelay);
		
		WebElement Inicio6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio6.click();
		
		Thread.sleep(secDelay);
		
		WebElement Logistica4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("img-menu")));
  		Logistica4.click();
  		
  		WebElement AdminEfectivo4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
  		AdminEfectivo4.click();
		  
		WebElement envio4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
		envio4.click();
		  
		Thread.sleep(secDelay);
		  
		WebElement Filtros3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnInnerEl")));
		Filtros3.click();
		  
		Thread.sleep(secDelay);
		  
		WebElement NumeroDeServicio4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		NumeroDeServicio4.click();
		Thread.sleep(secDelay);
		NumeroDeServicio4.sendKeys(NumeroAleatorio);
		  
		Thread.sleep(secDelay);
		  
		WebElement Consultar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnInnerEl")));
		Consultar6.click();
		  
		Thread.sleep(secDelay);

		WebElement SeleccionarRemesa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-row-checker")));
		SeleccionarRemesa4.click();
		
		Thread.sleep(secDelay);
		
		WebElement AvanzarRemesa4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		AvanzarRemesa4.click();
		
		WebElement Aceptar7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		Aceptar7.click();
		
		WebElement ConfirmarAceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnEl")));
		ConfirmarAceptar4.click();
		
		Thread.sleep(secDelay);
		
		WebElement Inicio7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio7.click();
		
		Thread.sleep(secDelay);
		
		WebElement Auditoria4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/auditoria.jpg']")));
		Auditoria4.click();
		
		WebElement AuditoriaDeUsuarios4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auditoriaUsuarios")));
		AuditoriaDeUsuarios4.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarUsuarios4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("codUsuario-trigger-picker")));
		DesplegarUsuarios4.click();
		
		Thread.sleep(secDelay);
		
		WebElement Usuarios4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='gsarmiento']")));
		Usuarios4.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarProceso4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("proceso-trigger-picker")));
		DesplegarProceso4.click();
		
		Thread.sleep(secDelay);
		
		WebElement Proceso4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Remesa']")));
		Proceso4.click();
		
		WebElement DesplegarOperacion4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("operacion-trigger-picker")));
		DesplegarOperacion4.click();
		
		Thread.sleep(secDelay);
		
		WebElement Operacion4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Modificar']")));
		Operacion4.click();
		
		Thread.sleep(secDelay);
		
		WebElement Consultar7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		Consultar7.click();
		
		Thread.sleep(secDelay);
		
		WebElement Imprimir4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir4.click();
		
		Thread.sleep(secDelay);
		
		WebElement DesplegarFormato4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato4.click();
		
		Thread.sleep(secDelay);
		
		WebElement Formato4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		Formato4.click();
		
		WebElement Aceptar8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1047-btnInnerEl")));
		Aceptar8.click();
		
		Thread.sleep(secDelay);
		
	}
}
