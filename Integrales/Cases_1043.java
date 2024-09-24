package Integrales;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.After;
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

public class Cases_1043 {
	
	int secDelay = 2000;
	private WebDriver driver;
	private ReadExcelFile readFile;
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		readFile = new ReadExcelFile();
		
		driver.get("http://192.168.2.214:8901/Central/");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InterruptedException {
		
		//Bloque de codigo para generar un numero aleatorio------------------------------------------------
		
		Random rand = new Random();
	    int numeroAleatorio = rand.nextInt(1000000) + 1000000000;
	    String numeroTexto = Integer.toString(numeroAleatorio);
	    
	    Random rand1 = new Random();
	    int numeroAleatorio1 = rand1.nextInt(1000000) + 1000000000;
	    String numeroTexto1 = Integer.toString(numeroAleatorio1);
		
		//Bloque de codigo para el excel---------------------------------------------------------------------
		
		String filepath = ""+Constante_PreCalidad.RUTA_EXCEL+"\\MatrizIntegrales.xlsx";
		
		String TipoUnidadEmisora = readFile.getCellValue(filepath, "Cases", 61, 1);
		String UnidadEmisora = readFile.getCellValue(filepath, "Cases", 61, 2);
		String TipoUnidadReceptora = readFile.getCellValue(filepath, "Cases", 61, 3);
		String UnidadReceptora = readFile.getCellValue(filepath, "Cases", 61, 4);
		String EmpresaTransportista = readFile.getCellValue(filepath, "Cases", 61, 5);
		
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
		
		// --------------------------- CREAR UN ENVIO CON DOS O MAS REMESAS --------------------------------//
		
		//Ingresamos en el modulo central--------------------------------------------------------------------
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
	    login.sendKeys(Constante_PreCalidad.USUARIO);
	    WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
	    WebElement enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
	    enter.click();
	    
	    //Ingresamos en el apartado de envios-----------------------------------------------------------------
	    
	    WebElement logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
	    logistica.click();
	    WebElement administracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
	    administracionEfectivo.click();
	    WebElement envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
	    envios.click();
	    
	    //Procedemos a crear el envio---------------------------------------------------------------------------
	    
	    WebElement crearenvios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
	    crearenvios.click();
	    
	    
	    WebElement DesplegarTipoUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadEmisoraCrear-trigger-picker")));
        DesplegarTipoUnidadEmisora.click();		Thread.sleep(secDelay);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options) {
            if (option.getText().equals(TipoUnidadEmisora)) {
                option.click();
                break;
            
                }
            }		Thread.sleep(secDelay);
		
		
        WebElement DesplegarUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadEmisoraCrear-trigger-picker")));
    	DesplegarUnidadEmisora.click();		Thread.sleep(secDelay);
		List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options2) {
            if (option.getText().equals(UnidadEmisora)) {
                option.click();
                break;
                }
            };		Thread.sleep(secDelay);
	    
	    
        WebElement DesplegarTipoUnidadReceptora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadReceptoraCrear-trigger-picker")));
        DesplegarTipoUnidadReceptora.click();		Thread.sleep(secDelay);
		List<WebElement> options3 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options3) {
            if (option.getText().equals(TipoUnidadReceptora)) {
                option.click();
                break;
            
                }
            }		Thread.sleep(secDelay);
	    
	    
	    WebElement DesplegarUnidadReceptora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadReceptoraCrear-trigger-picker")));
	    DesplegarUnidadReceptora.click();		Thread.sleep(secDelay);
		List<WebElement> options4 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options4) {
	        if (option.getText().equals(UnidadReceptora)) {
	            option.click();
	            break;
	        
	            }
	        }		Thread.sleep(secDelay);
	    
	    
        WebElement DesplegarEmpresaTransportista = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transportistaCrear-trigger-picker")));	Thread.sleep(secDelay);
        DesplegarEmpresaTransportista.click();
		List<WebElement> options5 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options5) {
            if (option.getText().equals(EmpresaTransportista)) {
                option.click();
                break;
            
                }
            };
	    
	    
	    WebElement botonSiguiente = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siguiente1Crear-btnWrap")));
	    botonSiguiente.click();
	    			    
	    WebElement desplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
	    desplegarDivisa.click();
	    WebElement elementoDolar = driver.findElement(By.xpath("//li[text()='Dólar']"));
	    elementoDolar.click();
	    WebElement numeroServicioAleatorio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl"))); 
	    numeroServicioAleatorio.sendKeys(String.valueOf(numeroTexto)); 
	    System.out.println("El Cataporte es: " + numeroTexto);
	    	    	    	
	    WebElement destinoDesplegar1 = driver.findElement(By.id("destinoCrear-trigger-picker"));
	    if (destinoDesplegar1.isEnabled()) {
	       	destinoDesplegar1.click();
	    } else {
	    }	Thread.sleep(secDelay);

	    	try {
	    		WebElement destinoSeleccionar = driver.findElement(By.xpath("//li[text()='Boveda']"));
	    		destinoSeleccionar.click();
	    	} catch (NoSuchElementException e){	    	
	    	}	Thread.sleep(secDelay);
	     
	    WebElement botonIncluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear-btnWrap")));
        botonIncluir.click();	  Thread.sleep(secDelay);
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
        botonIncluirEnvases.click();	 Thread.sleep(secDelay);
        WebElement colocarNumeroPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
        colocarNumeroPlomos.sendKeys("1");
        WebElement botonIncluirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnIconEl")));
        botonIncluirPlomos.click();		Thread.sleep(secDelay);
        
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
            
        }		Thread.sleep(secDelay);
                            	                
        WebElement desplegarDivisa1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("monedaCrear-trigger-picker")));
	    desplegarDivisa1.click();
	    WebElement elementoDolar1 = driver.findElement(By.xpath("//li[text()='Dólar']"));
	    elementoDolar1.click();
	        
	    WebElement numeroServicioAleatorio1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioCrear-inputEl"))); 
	    numeroServicioAleatorio1.sendKeys(String.valueOf(numeroTexto1)); 
	    System.out.println("El Cataporte es: " + numeroTexto1);
	        
	    WebElement destinoDesplegar2 = driver.findElement(By.id("destinoCrear-trigger-picker"));
	    if (destinoDesplegar2.isEnabled()) {
	       	destinoDesplegar2.click();
	    } else {
	    }	Thread.sleep(secDelay);

	    try {
	    WebElement destinoSeleccionar = driver.findElement(By.xpath("//li[text()='Boveda']"));
	    destinoSeleccionar.click();
	    } catch (NoSuchElementException e){
	    }	Thread.sleep(secDelay);
	     
	    WebElement botonIncluir1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear-btnWrap")));
        botonIncluir1.click();	   Thread.sleep(secDelay);
        WebElement desplegarTipoEnvase1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoEnvaseCrear-trigger-picker")));
        desplegarTipoEnvase1.click();
        WebElement seleccionarTipoEnvase1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='CAJA']")));
        seleccionarTipoEnvase1.click();
        WebElement desplegarTipoPieza1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoPiezaCrear-trigger-picker")));
        desplegarTipoPieza1.click();
        WebElement seleccionarTipoPieza1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billetes']")));
        seleccionarTipoPieza1.click();
        WebElement colocarCantidadEnvases1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEnvaseCrear-inputEl")));
        colocarCantidadEnvases1.sendKeys("1");
        WebElement botonIncluirEnvases1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirEnvasesCrear-btnWrap")));
        botonIncluirEnvases1.click();	  Thread.sleep(secDelay);
        WebElement colocarNumeroPlomos1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
        colocarNumeroPlomos1.sendKeys("1");		Thread.sleep(secDelay);
        WebElement botonIncluirPlomos1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnIconEl")));
        botonIncluirPlomos1.click();	 Thread.sleep(secDelay);
        
        WebElement elementoCantidad2 = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1163']")); //En 2.6 es 1163 y en 2.5 es 1161
        Actions doble2 = new Actions(driver);
        doble2.doubleClick(elementoCantidad2).perform();	Thread.sleep(secDelay);
		
        List<WebElement> elementos2 = driver.findElements(By.cssSelector("[id^='ext-element-'][id$='16'], [id^='ext-element-'][id$='17'], [id^='ext-element-'][id$='18'], [id^='ext-element-'][id$='19'], [id^='ext-element-'][id$='20'], [id^='ext-element-'][id$='21'], [id^='ext-element-'][id$='22'], [id^='ext-element-'][id$='23'], [id^='ext-element-'][id$='24'], [id^='ext-element-'][id$='25'], [id^='ext-element-'][id$='26'], [id^='ext-element-'][id$='27'], [id^='ext-element-'][id$='28'], [id^='ext-element-'][id$='29'], [id^='ext-element-'][id$='30']"));
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
                     		      	    
        WebElement aceptarCreacionRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar1-btnWrap")));
        aceptarCreacionRemesa.click();	   Thread.sleep(secDelay);
   	        
        WebElement mensajeConfirmacion = driver.findElement(By.id("container-1029-innerCt"));
        String texto = mensajeConfirmacion.getText();
        System.out.println("La creacion Fue: " + texto);	Thread.sleep(secDelay);
        WebElement aceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
        aceptarMensajeInformativo.click();
   
        driver.navigate().refresh();
        
    	 	
	    WebElement filtros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
        filtros.click();
        WebElement campoNroServicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
        campoNroServicio.sendKeys(numeroTexto);	Thread.sleep(secDelay);
        WebElement consultarFiltros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
        consultarFiltros.click();	  Thread.sleep(secDelay);
        
        //Avance Remesa a Aprobado------------------------------------------------------------------------------------------------------
          
        WebElement seleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesa.click();	   Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoSolicitado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoSolicitado.click();  	  Thread.sleep(secDelay);
        WebElement avanceEstadoSolicitado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoSolicitado.click();

        Thread.sleep(secDelay);
        WebElement mensajeConfirmacion1 = driver.findElement(By.id("messagebox-1027-msg"));
        String texto1 = mensajeConfirmacion1.getText();
         System.out.println("Avance: " + texto1);
               
        WebElement aceptarAvanceEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstado.click();    
          
        	
        //Avance Remesa a Despachado----------------------------------------------------------------------------------------------------------------	
    		
        Thread.sleep(secDelay);	
              
        WebElement seleccionarRemesaAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesaAprobado.click();	   Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoAprobado.click();  	Thread.sleep(secDelay);
        WebElement avanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoAprobado.click();	  Thread.sleep(secDelay);
        WebElement confirmarAvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnEl")));
        confirmarAvanceEstadoAprobado.click();	   Thread.sleep(secDelay);
              
        WebElement mensajeConfirmacionAprobado = driver.findElement(By.id("messagebox-1027-msg"));
        String texto2 = mensajeConfirmacionAprobado.getText();
        System.out.println("Avance: " + texto2);
              
        WebElement aceptarAvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstadoAprobado.click();	 Thread.sleep(secDelay);
              
        
        //Avance Remesa a Recibido----------------------------------------------------------------------------------------------------------------------
        
        WebElement seleccionarRemesaDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesaDespachado.click();	 Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoDespachado.click();	  Thread.sleep(secDelay);
        WebElement avanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoDespachado.click();		Thread.sleep(secDelay);
          
        WebElement mensajeConfirmacionDespachado = driver.findElement(By.id("messagebox-1027-msg"));
        String texto3 = mensajeConfirmacionDespachado.getText();
        System.out.println("Avance: " + texto3);
      	    	 
        WebElement aceptarAvanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstadoDespachado.click();

        // Avance Remesa a Confirmado Sin Ajuste 
   	    
        Thread.sleep(secDelay);
        WebElement seleccionarRemesaRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesaRecibido.click();	   Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoRecibido.click();		Thread.sleep(secDelay);
        WebElement avanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoRecibido.click();	  Thread.sleep(secDelay);
          
        WebElement mensajeConfirmacionRecibido = driver.findElement(By.id("messagebox-1027-msg"));
        String texto4 = mensajeConfirmacionRecibido.getText();
        System.out.println("Avance: " + texto4);
      	
        WebElement aceptarAvanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstadoRecibido.click();
        
        driver.navigate().refresh();	Thread.sleep(secDelay);
        
        WebElement filtros1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
        filtros1.click();
        WebElement campoNroServicio1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
        campoNroServicio1.sendKeys(numeroTexto1);	Thread.sleep(secDelay);
        WebElement consultarFiltros1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
        consultarFiltros1.click();	   Thread.sleep(secDelay);
        
        //Avance Remesa a Aprobado-----------------------------------------------------------------------------------------------------------
          
        WebElement seleccionarRemesa1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesa1.click();		Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoSolicitado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoSolicitado1.click();     Thread.sleep(secDelay);
        WebElement avanceEstadoSolicitado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoSolicitado1.click();	 Thread.sleep(secDelay);
        WebElement mensajeConfirmacion11 = driver.findElement(By.id("messagebox-1027-msg"));
        String texto11 = mensajeConfirmacion11.getText();
         System.out.println("Avance: " + texto11);
               
        WebElement aceptarAvanceEstado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstado1.click();    
        	
        //Avance Remesa a Despachado-------------------------------------------------------------------------------------------------------------	
    		
        Thread.sleep(secDelay);	
              
        WebElement seleccionarRemesaAprobado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesaAprobado1.click();		Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoAprobado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoAprobado1.click();  	 Thread.sleep(secDelay);
        WebElement avanceEstadoAprobado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoAprobado1.click();	   Thread.sleep(secDelay);
        WebElement confirmarAvanceEstadoAprobado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnEl")));
        confirmarAvanceEstadoAprobado1.click();		Thread.sleep(secDelay);
              
        WebElement mensajeConfirmacionAprobado1 = driver.findElement(By.id("messagebox-1027-msg"));
        String texto21 = mensajeConfirmacionAprobado1.getText();
        System.out.println("Avance: " + texto21);
              
        WebElement aceptarAvanceEstadoAprobado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstadoAprobado1.click();	  Thread.sleep(secDelay);
        
        //Avance Remesa a Recibido-------------------------------------------------------------------------------------------------
        
        WebElement seleccionarRemesaDespachado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesaDespachado1.click();	  Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoDespachado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoDespachado1.click();	   Thread.sleep(secDelay);
        WebElement avanceEstadoDespachado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoDespachado1.click();	 Thread.sleep(secDelay);
          
        WebElement mensajeConfirmacionDespachado1 = driver.findElement(By.id("messagebox-1027-msg"));
        String texto31 = mensajeConfirmacionDespachado1.getText();
        System.out.println("Avance: " + texto31);
      	    	 
        WebElement aceptarAvanceEstadoDespachado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstadoDespachado1.click();

        // Avance Remesa a Confirmado Sin Ajuste 
   	    
        Thread.sleep(secDelay);
        WebElement seleccionarRemesaRecibido1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
        seleccionarRemesaRecibido1.click();		Thread.sleep(secDelay);
        WebElement botonAvanzarEstadoRecibido1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
        botonAvanzarEstadoRecibido1.click();	 Thread.sleep(secDelay);
        WebElement avanceEstadoRecibido1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
        avanceEstadoRecibido1.click();	   Thread.sleep(secDelay);
          
        WebElement mensajeConfirmacionRecibido1 = driver.findElement(By.id("messagebox-1027-msg"));
        String texto41 = mensajeConfirmacionRecibido1.getText();
        System.out.println("Avance: " + texto41);
      	
        WebElement aceptarAvanceEstadoRecibido1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
        aceptarAvanceEstadoRecibido1.click();
      	
        
	}
}