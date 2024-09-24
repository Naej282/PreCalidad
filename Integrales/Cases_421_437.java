package Integrales;

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

import Constantes.Constante_PreCalidad;
import DataDrivenTesting.ReadExcelFile;
import DataDrivenTesting.WriteExcelFile;

public class Cases_421_437 {
	
	int secDelay = 2000;
	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		
		driver.get(Constante_PreCalidad.URL_CENTRAL);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, InterruptedException {
		
		//Bloque de codigo para obtener un numero ramdom 

		 Random rand = new Random();
	     int numeroAleatorio = rand.nextInt(1000000) + 1000000000;
	     String numeroTexto = Integer.toString(numeroAleatorio);
		
		//Bloque de codigo para el Excel - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		String filepath =  "" + Constante_PreCalidad.RUTA_EXCEL + "\\MatrizIntegrales.xlsx";
									
		String TipoUnidadEmisora_Envio = readFile.getCellValue(filepath, "Cases", 5, 1);
		String UnidadEmisora_Envio = readFile.getCellValue(filepath, "Cases", 5, 2);
		String TipoUnidadReceptora_Envio = readFile.getCellValue(filepath, "Cases", 5, 3);
		String UnidadReceptora_Envio = readFile.getCellValue(filepath, "Cases", 5, 4);
		String EmpresaTransportista = readFile.getCellValue(filepath, "Cases", 5, 5);
														
		String TipoUnidadEmisora_Inventario = readFile.getCellValue(filepath, "General", 9, 1);
		String UnidadEmisora_Inventario = readFile.getCellValue(filepath, "General", 9, 2);
		String TipoUnidadReceptora_Inventario = readFile.getCellValue(filepath, "General", 10, 1);
		String UnidadReceptora_Inventario = readFile.getCellValue(filepath, "General", 10, 2);
										
		String TipoUnidadReceptora_Consulta = readFile.getCellValue(filepath, "Cases", 9, 2);
		String UnidadReceptora_Consulta = readFile.getCellValue(filepath, "Cases", 9, 2);
				
		String InventarioReceptor = Constante_PreCalidad.URL_CENTRAL;
		
		
		// variables - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		int Monto = 4;
		double Diferencia = 1;		
		String DiferenciaString = String.format("%.0f", Diferencia);
		
		
		// Cambio de Pestaña - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
							
		String InventarioEmisor = Constante_PreCalidad.URL_CENTRAL;		
		String Central_Envios = Constante_PreCalidad.URL_CENTRAL_ENVIO;
		
	    //-----------------------------  Remesa Banco Central a Centro de Acopio  --------------------------------//	
		
		//Ingresamos en el modulo central - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -			
		 
		WebDriverWait ewait = new WebDriverWait(driver,8); //Espera Explícita
			 	       
		WebElement Login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		Login.sendKeys(Constante_PreCalidad.USUARIO);
		WebElement Password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		Password.sendKeys(Constante_PreCalidad.CONTRASEÑA);
		WebElement Enter = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		Enter.click();
     
		 //Consulta Inventario Receptor---------------------------------------------------------------------------------------------
		    
		 Thread.sleep(secDelay);
	     js.executeScript("window.open(arguments[0]);", InventarioReceptor);	  
		    
		 Set<String> handles = driver.getWindowHandles();
		    
		 String InventarioInicialEmisor = (String) handles.toArray()[handles.size() - 1];
		 driver.switchTo().window(InventarioInicialEmisor);
		 
		 WebElement login2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		 login2.sendKeys(Constante_PreCalidad.USUARIO);
		 WebElement password2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		 password2.sendKeys(Constante_PreCalidad.CONTRASEÑA);	Thread.sleep(secDelay);
		 WebElement enter2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		 enter2.click();
     
		 WebElement logistica1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
	     logistica1.click();
	     WebElement inventarioEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inventarioEfectivo\"]")));
	     inventarioEfectivo.click();	 Thread.sleep(secDelay);
	     WebElement desplegarTipoUnidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidad-trigger-picker")));
	     desplegarTipoUnidad1.click();	   Thread.sleep(secDelay);
	     WebElement seleccionarTipoUnidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item'][text()='"+TipoUnidadReceptora_Envio+"']")));
	     seleccionarTipoUnidad1.click();	 Thread.sleep(secDelay);
	     WebElement desplegarUnidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-trigger-picker")));
	     desplegarUnidad1.click();	   Thread.sleep(secDelay);
	     WebElement seleccionarUnidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item'][text()='"+UnidadReceptora_Envio+"']")));
	     seleccionarUnidad1.click();	 Thread.sleep(secDelay);
	     WebElement desplegarBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoBoveda-trigger-picker")));
	     desplegarBoveda.click();	  Thread.sleep(secDelay);
	     WebElement seleccionarBoveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constante_PreCalidad.BOVEDA+"']")));
	     seleccionarBoveda.click();
	     WebElement desplegaDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
	     desplegaDivisa.click();	 Thread.sleep(secDelay);
	     WebElement seleccionarDivisa1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constante_PreCalidad.DIVISA+"']")));
	     seleccionarDivisa1.click();
	     WebElement consultarInventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
	     consultarInventario.click();
	     WebElement desplegarConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-grid-group-title")));
	     desplegarConsulta.click();
	     
	     WebElement CantidadDenominacion_100_Receptor = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));
  		 String Cantidad_100_Receptor = CantidadDenominacion_100_Receptor.getText();
  		 Cantidad_100_Receptor = Cantidad_100_Receptor.replace(".", "");
  		 double ObtenerPiezasDenominacion_100_Solicitado_Receptor = Double.parseDouble(Cantidad_100_Receptor);
  		 System.out.println(ObtenerPiezasDenominacion_100_Solicitado_Receptor);
    	 
    	 // Ingresamos en central----------------------------------------------------------------------------------------------------------
           	
         String Inicio = (String) handles.toArray()[handles.size() - 2];
 	     driver.switchTo().window(Inicio);
 	     	    
    	 WebElement logistica = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/logistica.jpg']")));
    	 logistica.click();
    	 WebElement administracionEfectivo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("administracionEfectivo")));
    	 administracionEfectivo.click();
    	 WebElement envios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("envio")));
    	 envios.click();
    	 
    	 //Ingresamos en el apartado de envios--------------------------------------------------------------------------------------------
          
    	 WebElement crearenvios = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionNuevo")));
    	 crearenvios.click();
    	 
    	 
    	WebElement DesplegarTipoUnidadEmisora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadEmisoraCrear-trigger-picker")));
        DesplegarTipoUnidadEmisora.click();		Thread.sleep(secDelay);
 		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
         for (WebElement option : options) {
             if (option.getText().equals(TipoUnidadEmisora_Envio)) {
                 option.click();
                 break;
             
                 }
             }		Thread.sleep(secDelay);
        WebElement DesplegarUnidadEmisora2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadEmisoraCrear-trigger-picker")));
     	DesplegarUnidadEmisora2.click();		Thread.sleep(secDelay);
 		List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
         for (WebElement option : options2) {
             if (option.getText().equals(UnidadEmisora_Envio)) {
                 option.click();
                 break;
             
                 }
             };		Thread.sleep(secDelay);
        WebElement DesplegarTipoUnidadReceptora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoUnidadReceptoraCrear-trigger-picker")));
        DesplegarTipoUnidadReceptora.click();		Thread.sleep(secDelay);
 		List<WebElement> options3 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
         for (WebElement option : options3) {
             if (option.getText().equals(TipoUnidadReceptora_Envio)) {
                 option.click();
                 break;
             
                 }
             }		Thread.sleep(secDelay);
        WebElement DesplegarUnidadReceptora = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidadReceptoraCrear-trigger-picker")));
        DesplegarUnidadReceptora.click();		Thread.sleep(secDelay);
 		List<WebElement> options4 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
         for (WebElement option : options4) {
             if (option.getText().equals(UnidadReceptora_Envio)) {
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
	     System.out.println("El Cataporte es: " + numeroTexto);		Thread.sleep(secDelay);
	        
	     
	     WebElement botonIncluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRemesasCrear-btnWrap")));
	     botonIncluir.click();	   Thread.sleep(secDelay);
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
	     botonIncluirEnvases.click();	  Thread.sleep(secDelay);
	     WebElement colocarNumeroPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numeroCrear-inputEl")));
	     colocarNumeroPlomos.sendKeys("1");
	     WebElement botonIncluirPlomos = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirPlomosCrear-btnIconEl")));
	     botonIncluirPlomos.click();	 Thread.sleep(secDelay);
	     
	     WebElement elementoCantidad = driver.findElement(By.cssSelector("td[data-columnid='gridcolumn-1163']")); //En 2.6 es 1163 y en 2.5 es 1161
	     Actions doble = new Actions(driver);
	     doble.doubleClick(elementoCantidad).perform();		Thread.sleep(secDelay);
			
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
	     
	     WebElement aceptarCreacionRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptar1-btnWrap")));
	     aceptarCreacionRemesa.click();		Thread.sleep(secDelay);
		        
	     WebElement mensajeConfirmacion = driver.findElement(By.id("container-1029-innerCt"));
	     String texto = mensajeConfirmacion.getText();
	     System.out.println("La creacion Fue: " + texto);	Thread.sleep(secDelay);
	     
	     WebElement aceptarMensajeInformativo = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnWrap")));
	     aceptarMensajeInformativo.click();
	
	     driver.navigate().refresh();
	    	
	     //Avance de Remesa---------------------------------------------------------------------------------------------------------------------
	        
		 WebElement filtros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filtrosEnvio-btnWrap")));
		 filtros.click();
		 WebElement campoNroServicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nroServicioConsulta-inputEl")));
		 campoNroServicio.sendKeys(numeroTexto);	Thread.sleep(secDelay);
		 
		 WebElement consultarFiltros = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1139-btnWrap")));
		 consultarFiltros.click();	   Thread.sleep(secDelay);
		
		 WebElement seleccionarRemesa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		 seleccionarRemesa.click();		Thread.sleep(secDelay);
		 WebElement botonAvanzarEstadoSolicitado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		 botonAvanzarEstadoSolicitado.click();     Thread.sleep(secDelay);
		 WebElement avanceEstadoSolicitado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		 avanceEstadoSolicitado.click();	 Thread.sleep(secDelay);     
		 WebElement aceptarAvanceEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		 aceptarAvanceEstado.click();    
	        
		 WebElement seleccionarRemesaAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		 seleccionarRemesaAprobado.click();		Thread.sleep(secDelay);
		 WebElement botonAvanzarEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		 botonAvanzarEstadoAprobado.click();  	 Thread.sleep(secDelay);
		 WebElement avanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		 avanceEstadoAprobado.click();	   Thread.sleep(secDelay);
		 WebElement confirmarAvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnEl")));
		 confirmarAvanceEstadoAprobado.click();		Thread.sleep(secDelay);   
		 WebElement aceptarAvanceEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		 aceptarAvanceEstadoAprobado.click();	  Thread.sleep(secDelay);
		    
		 WebElement seleccionarRemesaDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		 seleccionarRemesaDespachado.click();	  Thread.sleep(secDelay);
		 WebElement botonAvanzarEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
		 botonAvanzarEstadoDespachado.click();	   Thread.sleep(secDelay);
		 WebElement avanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
		 avanceEstadoDespachado.click();	 Thread.sleep(secDelay);    	 
		 WebElement aceptarAvanceEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		 aceptarAvanceEstadoDespachado.click();
		     
		 driver.switchTo().window(InventarioInicialEmisor);
	   
		 WebElement consultarInventario2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		 consultarInventario2.click();	   Thread.sleep(secDelay);
		      
		 WebElement CantidadDenominacion_100_Receptor4 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));
 		 Thread.sleep(secDelay);
  		 String Cantidad_100_Receptor4 = CantidadDenominacion_100_Receptor4.getText();
  		 Cantidad_100_Receptor4 = Cantidad_100_Receptor4.replace(".", "");
  		 double ObtenerPiezasDenominacion_100_Recibido_Receptor = Double.parseDouble(Cantidad_100_Receptor4);
  		 System.out.println(ObtenerPiezasDenominacion_100_Recibido_Receptor);
  		 Assert.assertEquals(ObtenerPiezasDenominacion_100_Recibido_Receptor, (ObtenerPiezasDenominacion_100_Solicitado_Receptor + 2), 0.000001);
  		 System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado recibido (Inventario Receptor)");
		 	 
  		 driver.switchTo().window(Inicio);
		 
  		 Thread.sleep(secDelay);
	    	
	     WebElement seleccionarRemesaRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	     seleccionarRemesaRecibido.click();		Thread.sleep(secDelay);
	     WebElement botonAvanzarEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
	     botonAvanzarEstadoRecibido.click();	 Thread.sleep(secDelay);
	     WebElement avanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
	     avanceEstadoRecibido.click();	   Thread.sleep(secDelay);
	        
	     WebElement mensajeConfirmacionRecibido = driver.findElement(By.id("messagebox-1027-msg"));
	     String texto4 = mensajeConfirmacionRecibido.getText();
	     System.out.println("Avance: " + texto4);
	    	
	     WebElement aceptarAvanceEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	     aceptarAvanceEstadoRecibido.click();
	    	
	     driver.switchTo().window(Inicio);
	     
	     //Consulta Inventario Confirmado----------------------------------------------------------------------------------------------------------------------
	      
	     driver.switchTo().window(InventarioInicialEmisor);
	   
		 WebElement consultarInventario3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		 consultarInventario3.click();	   Thread.sleep(secDelay);
		 
		 WebElement CantidadDenominacion_100_Receptor5 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));	
		 Thread.sleep(secDelay);
  		 String Cantidad_100_Receptor5 = CantidadDenominacion_100_Receptor5.getText();
  		 Cantidad_100_Receptor5 = Cantidad_100_Receptor5.replace(".", "");
  		 double ObtenerPiezasDenominacion_100_ConsfirmadoSinAjustes_Receptor = Double.parseDouble(Cantidad_100_Receptor5);
  		 System.out.println(ObtenerPiezasDenominacion_100_ConsfirmadoSinAjustes_Receptor);
  		 Assert.assertEquals(ObtenerPiezasDenominacion_100_ConsfirmadoSinAjustes_Receptor, (ObtenerPiezasDenominacion_100_Recibido_Receptor), 0.000001);
  		 System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Confirmado Sin Ajustes (Inventario Receptor)");
		     
	     	 
  		 driver.switchTo().window(Inicio);
	      
	     //Reverso Confirmado Sin Ajuste-----------------------------------------------------------------------------------------------------------------------
	     
  		 Thread.sleep(secDelay);
	     WebElement seleccionarRemesaConfirmadoSinAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	     seleccionarRemesaConfirmadoSinAjuste.click();	   Thread.sleep(secDelay);
	     WebElement botonReversarConfirmadoSinAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnInnerEl")));
	     botonReversarConfirmadoSinAjuste.click();
	     WebElement ReversoEstadoConfirmadoSinAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	     ReversoEstadoConfirmadoSinAjuste.click();	   Thread.sleep(secDelay);
	    	 
	     WebElement aceptarReversoEstadoConfirmadoSinAjuste = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	     aceptarReversoEstadoConfirmadoSinAjuste.click();
	      
	      //Avance Confirmado Ajuste Faltante-----------------------------------------------------------------------------------------------------------------
	    	
	      WebElement seleccionarRemesaAvanveAlternoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	      seleccionarRemesaAvanveAlternoFaltante.click();	  Thread.sleep(secDelay);
	      WebElement botonAvanceAlternoRemesaRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnInnerEl")));
	      botonAvanceAlternoRemesaRecibido.click();
	      WebElement desplegarAvanzarEstadoAlternoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
	      desplegarAvanzarEstadoAlternoRecibido.click();
	      WebElement seleccionarAvanzarEstadoAlternoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item x-boundlist-item-over'][text()='Confirmado Ajuste Faltante']")));
	      seleccionarAvanzarEstadoAlternoRecibido.click();
	      WebElement aceptarAvanzarEstadoAlternoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnInnerEl")));
	      aceptarAvanzarEstadoAlternoRecibido.click();	   Thread.sleep(secDelay);
	      WebElement desplegarDenominacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
	      desplegarDenominacionFaltante.click();	 Thread.sleep(secDelay);
	      WebElement seleccionarDenominacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constante_PreCalidad.DENOMINACION_DIFERENCIA+"']")));          
	      seleccionarDenominacionFaltante.click();	   Thread.sleep(secDelay);
	      WebElement desplegarClasificaciónFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
	      desplegarClasificaciónFaltante.click();
	      WebElement seleccionarClasificacionFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item x-boundlist-item-over'][text()='"+Constante_PreCalidad.APTOS+"']")));
	      seleccionarClasificacionFaltante.click();
	      WebElement escribirCantidadFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantesAjuste-inputEl")));
	      escribirCantidadFaltante.sendKeys("1");
	      WebElement incluirFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirFaltantesAjuste-btnInnerEl")));
	      incluirFaltante.click();
	      WebElement aceptarFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAjuste-btnInnerEl")));
	      aceptarFaltante.click();     Thread.sleep(secDelay);
	     
	      WebElement aceptarAvanceAlternoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarAvanceAlternoFaltante.click();
	      
	      // Consulta Inventario Confirmado Ajuste Faltante---------------------------------------------------------------------------------------------------
	      
	      driver.switchTo().window(InventarioInicialEmisor);
	      
		  WebElement consultarInventario4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
		  consultarInventario4.click();	    Thread.sleep(secDelay);
		       
		  WebElement CantidadDenominacion_100_Receptor6 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));	
		  Thread.sleep(secDelay);
  		  String Cantidad_100_Receptor6 = CantidadDenominacion_100_Receptor6.getText();
  		  Cantidad_100_Receptor6 = Cantidad_100_Receptor6.replace(".", "");
  		  double ObtenerPiezasDenominacion_100_Flatante_Receptor = Double.parseDouble(Cantidad_100_Receptor6);
  		  System.out.println(ObtenerPiezasDenominacion_100_Flatante_Receptor);
  		  Assert.assertEquals(ObtenerPiezasDenominacion_100_Flatante_Receptor, (ObtenerPiezasDenominacion_100_Recibido_Receptor - 1), 0.000001);
  		  System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Faltante (Inventario Receptor)");
	     	 
	      //Reverso Confirmado Ajuste Faltante-----------------------------------------------------------------------------------------------------------------
  		  
  		  driver.switchTo().window(Inicio);
	      
	      WebElement seleccionarRemesaReversoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	      seleccionarRemesaReversoFaltante.click();		Thread.sleep(secDelay);
	      WebElement botonReversarFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnInnerEl")));
	      botonReversarFaltante.click();
	      WebElement ReversoEstadoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	      ReversoEstadoFaltante.click();	 Thread.sleep(secDelay);
	        
	      WebElement mensajeConfirmacionReversoFaltante = driver.findElement(By.id("messagebox-1027-msg"));
      	  String texto7 = mensajeConfirmacionReversoFaltante.getText();
      	  System.out.println("Reverso: " + texto7);
	    	 
	      WebElement aceptarReversoEstadoFaltante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarReversoEstadoFaltante.click();
	         
	      //Consulta Inventario Reverso Confirmado Ajuste Faltante----------------------------------------------------------------------------------------------
	      
	      driver.switchTo().window(InventarioInicialEmisor);
	         
	   	  WebElement consultarInventario5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
	   	  consultarInventario5.click();	 	Thread.sleep(secDelay);
	   	       
	   	  WebElement CantidadDenominacion_100_Receptor7 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));	
		  Thread.sleep(secDelay);
		  String Cantidad_100_Receptor7 = CantidadDenominacion_100_Receptor7.getText();
		  Cantidad_100_Receptor7 = Cantidad_100_Receptor7.replace(".", "");
		  double ObtenerPiezasDenominacion_100_Reverso_Faltante_Receptor = Double.parseDouble(Cantidad_100_Receptor7);
		  System.out.println(ObtenerPiezasDenominacion_100_Reverso_Faltante_Receptor);
		  Assert.assertEquals(ObtenerPiezasDenominacion_100_Reverso_Faltante_Receptor, (ObtenerPiezasDenominacion_100_Flatante_Receptor + 1), 0.000001);
		  System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Recibido luego de un reverso del estado faltante (Inventario Receptor)");		Thread.sleep(secDelay);
	        	 
	      //Avance Remesa Ajuste Confirmado Sobrante--------------------------------------------------------------------------------------------------------------

		  driver.switchTo().window(Inicio);
		  
		  Thread.sleep(secDelay);
	      WebElement seleccionarRemesaAvanceAlternoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	      seleccionarRemesaAvanceAlternoSobrante.click();	  Thread.sleep(secDelay);
	      WebElement botonAvanceAlternoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnInnerEl")));
	      botonAvanceAlternoSobrante.click();
	      WebElement desplegarAvanzarEstadoAlternoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
	      desplegarAvanzarEstadoAlternoSobrante.click();	 Thread.sleep(secDelay);
	      WebElement seleccionarAvanzarEstadoAlternoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Confirmado Ajuste Sobrante']")));
	      seleccionarAvanzarEstadoAlternoSobrante.click();
	      WebElement aceptarAvanzarEstadoAlternoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnInnerEl")));
	      aceptarAvanzarEstadoAlternoSobrante.click();	   Thread.sleep(secDelay);
	      WebElement desplegarDenominacionSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionSobrantesAjuste-trigger-picker")));
	      desplegarDenominacionSobrante.click();
		  List<WebElement> options6 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	        for (WebElement option : options6) {
	            if (option.getText().equals(Constante_PreCalidad.DENOMINACION_DIFERENCIA)) {
	                option.click();
	                break;
	            
	                }
	            };
	      
	      WebElement desplegarClasificaciónSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionSobrantesAjuste-trigger-picker")));
	      desplegarClasificaciónSobrante.click();	  Thread.sleep(secDelay);
	      List<WebElement> options7 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	        for (WebElement option : options7) {
	            if (option.getText().equals(Constante_PreCalidad.APTOS)) {
	                option.click();
	                break;
	            
	                }
	            };
	            
	      WebElement escribirCantidadSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadSobrantesAjuste-inputEl")));
	      escribirCantidadSobrante.sendKeys("1");
	      WebElement incluirSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirSobrantesAjuste-btnInnerEl")));
	      incluirSobrante.click();
	      WebElement aceptarSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAjuste-btnInnerEl")));
	      aceptarSobrante.click();     Thread.sleep(secDelay);
	   	
	      WebElement mensajeConfirmacionSobrante = driver.findElement(By.id("messagebox-1027-msg"));
      		String texto8 = mensajeConfirmacionSobrante.getText();
	      	System.out.println("Avance: " + texto8);
	     
	      WebElement aceptarAvanceAlternoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarAvanceAlternoSobrante.click();
	      	
	      // Consulta Inventario Confirmado Ajuste Sobrante-------------------------------------------------------------------------------------------------------
	      
	      driver.switchTo().window(InventarioInicialEmisor);
	      	
	     
	      WebElement consultarInventario6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
	      consultarInventario6.click();		Thread.sleep(secDelay);
	      
	      WebElement CantidadDenominacion_100_Receptor8 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));	
		  Thread.sleep(secDelay);
		  String Cantidad_100_Receptor8 = CantidadDenominacion_100_Receptor8.getText();
		  Cantidad_100_Receptor8 = Cantidad_100_Receptor8.replace(".", "");
		  double ObtenerPiezasDenominacion_100_sobrante_Receptor = Double.parseDouble(Cantidad_100_Receptor8);
		  System.out.println(ObtenerPiezasDenominacion_100_sobrante_Receptor);
		  Assert.assertEquals(ObtenerPiezasDenominacion_100_sobrante_Receptor, (ObtenerPiezasDenominacion_100_Reverso_Faltante_Receptor + 1), 0.000001);
		  System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Sobrante (Inventario Receptor)");		Thread.sleep(secDelay);	
	      	
	      //Reverso Confirmado Ajuste Sobrante---------------------------------------------------------------------------------------------------------------------
	    	
		  driver.switchTo().window(Inicio);
		  
	      WebElement seleccionarRemesaReversoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	      seleccionarRemesaReversoSobrante.click();		Thread.sleep(secDelay);
	      WebElement botonReversarSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
	      botonReversarSobrante.click();	 Thread.sleep(secDelay);
	      WebElement ReversoEstadoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar")));
	      ReversoEstadoSobrante.click();	 Thread.sleep(secDelay);
	    	
	      WebElement mensajeConfirmacionReversoSobrante = driver.findElement(By.id("messagebox-1027-msg"));
	      	String texto9 = mensajeConfirmacionReversoSobrante.getText();
	      	System.out.println("Reverso: " + texto9);
	    	 
	      WebElement aceptarReversoEstadoSobrante = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarReversoEstadoSobrante.click();
	      	
	      // Consulta Inventario Reverso Confirmado Ajuste Sobrante-------------------------------------------------------------------------------------------------
	      
	      driver.switchTo().window(InventarioInicialEmisor);
	        
	      WebElement consultarInventario7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
	      consultarInventario7.click();		Thread.sleep(secDelay);
	      
	      WebElement CantidadDenominacion_100_Receptor9 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));	
		  Thread.sleep(secDelay);
		  String Cantidad_100_Receptor9 = CantidadDenominacion_100_Receptor9.getText();
		  Cantidad_100_Receptor9 = Cantidad_100_Receptor9.replace(".", "");
		  double ObtenerPiezasDenominacion_100_Reverso_sobrante_Receptor = Double.parseDouble(Cantidad_100_Receptor9);
		  System.out.println(ObtenerPiezasDenominacion_100_Reverso_sobrante_Receptor);
		  Assert.assertEquals(ObtenerPiezasDenominacion_100_Reverso_sobrante_Receptor, (ObtenerPiezasDenominacion_100_sobrante_Receptor - 1), 0.000001);
		  System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Recibido luego de reversarlo del estado sobrante (Inventario Receptor)");		Thread.sleep(secDelay);
	      	
	      //Reverso Recibido----------------------------------------------------------------------------------------------------------------------------------------
		  
		  driver.switchTo().window(Inicio);
	      	
	      WebElement seleccionarRemesaReversoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	      seleccionarRemesaReversoRecibido.click();		Thread.sleep(secDelay);
	      WebElement botonReversarRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
	      botonReversarRecibido.click();
	      WebElement ReversoEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	      ReversoEstadoRecibido.click();	 Thread.sleep(secDelay);
	    	
	      WebElement mensajeConfirmacionReversoRecibido = driver.findElement(By.id("messagebox-1027-msg"));
	      	String texto10 = mensajeConfirmacionReversoRecibido.getText();
	      	System.out.println("Reverso: " + texto10);
	    	 
	      WebElement aceptarReversoEstadoRecibido = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarReversoEstadoRecibido.click();
	        	
	      //Consulta Inventario Reverso Recibido--------------------------------------------------------------------------------------------------------------------
	      
	      driver.switchTo().window(InventarioInicialEmisor);
	          
	      WebElement consultarInventario8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
	      consultarInventario8.click();		Thread.sleep(secDelay);
	         
	      WebElement CantidadDenominacion_100_Receptor10 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));	
		  Thread.sleep(secDelay);
		  String Cantidad_100_Receptor10 = CantidadDenominacion_100_Receptor10.getText();
		  Cantidad_100_Receptor10 = Cantidad_100_Receptor10.replace(".", "");
		  double ObtenerPiezasDenominacion_100_Reverso_Recibido = Double.parseDouble(Cantidad_100_Receptor10);
		  System.out.println(ObtenerPiezasDenominacion_100_Reverso_Recibido);
		  Assert.assertEquals(ObtenerPiezasDenominacion_100_Reverso_Recibido, (ObtenerPiezasDenominacion_100_Reverso_sobrante_Receptor - 2), 0.000001);
		  System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Despachado luego de reversarlo del estado Recibido (Inventario Receptor)");		Thread.sleep(secDelay);
	    	
	      //Avance Devuelto-----------------------------------------------------------------------------------------------------------------------------------------
	    	
		  driver.switchTo().window(Inicio);
		  
	      WebElement seleccionarRemesaAvanzarDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	      seleccionarRemesaAvanzarDevuelto.click();		Thread.sleep(secDelay);
	      WebElement botonAvanzaAlternoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnInnerEl")));
	      botonAvanzaAlternoDevuelto.click();
	      WebElement desplegarEstadoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
	      desplegarEstadoDevuelto.click();
	      WebElement seleccionarEstadoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Devuelto']")));
	      seleccionarEstadoDevuelto.click();
	      WebElement aceptarEstadoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnInnerEl")));
	      aceptarEstadoDevuelto.click();	 Thread.sleep(secDelay);
	    	
	      WebElement mensajeAvanceEstadoDevuelto = driver.findElement(By.id("messagebox-1027-msg"));
	      	String texto11 = mensajeAvanceEstadoDevuelto.getText();
	    	System.out.println("Avance: " + texto11);
	    	 
	      WebElement aceptarAvanceEstadoDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarAvanceEstadoDevuelto.click();
	    	
	      //Avance Recibido Emisor------------------------------------------------------------------------------------------------------------------------------------	
	    	
	      WebElement seleccionarRemesaDevuelto = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	      seleccionarRemesaDevuelto.click();	 Thread.sleep(secDelay);
	      WebElement AvanzarEstadoRecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
	      AvanzarEstadoRecibidoEmisor.click();	   Thread.sleep(secDelay);
	      WebElement aceptarAvanceEstadoRecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
	      aceptarAvanceEstadoRecibidoEmisor.click();	 Thread.sleep(secDelay);
	    	
	      WebElement mensajeAvanceEstadoRecibidoEmisor = driver.findElement(By.id("messagebox-1027-msg"));
	      	String texto12 = mensajeAvanceEstadoRecibidoEmisor.getText();
	    	System.out.println("Avance: " + texto12);
	    	 
	      WebElement aceptarMensajeAvanceEstadoRecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarMensajeAvanceEstadoRecibidoEmisor.click();
	    		       	  	
	      //Avance Recibido Confirmado--------------------------------------------------------------------------------------------------------------------------------		
	    	
	      Thread.sleep(secDelay);	
	      WebElement seleccionarRemesaRecibidoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	      seleccionarRemesaRecibidoEmisor.click();
	      Thread.sleep(secDelay);
	      WebElement AvanzarEstadoConfirmadoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarNormal-btnInnerEl")));
	      AvanzarEstadoConfirmadoEmisor.click();
	      WebElement aceptarAvanceEstadoConfirmadoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarNomal-btnInnerEl")));
	      aceptarAvanceEstadoConfirmadoEmisor.click();
	      Thread.sleep(secDelay);
	    	
	      WebElement mensajeAvanceEstadoConfirmadoEmisor = driver.findElement(By.id("messagebox-1027-msg"));
	    	String texto13 = mensajeAvanceEstadoConfirmadoEmisor.getText();
	    	System.out.println("Avance: " + texto13);
	    	 
	      WebElement aceptarMensajeAvanceEstadoConfirmadoEmisor = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarMensajeAvanceEstadoConfirmadoEmisor.click(); 	  Thread.sleep(secDelay);
		  WebElement seleccionarRemesaReversar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		  seleccionarRemesaReversar.click();	 Thread.sleep(secDelay);	
		  WebElement botonReversar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
          botonReversar.click();
          WebElement ReversoEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	      ReversoEstado.click();
	      WebElement aceptarReverso = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarReverso.click();
	      
	      WebElement seleccionarRemesaReversar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		  seleccionarRemesaReversar1.click();	 Thread.sleep(secDelay);	
		  WebElement botonReversar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
          botonReversar1.click();
          WebElement ReversoEstado1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	      ReversoEstado1.click();
	      WebElement aceptarReverso1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarReverso1.click();
	      
	      WebElement seleccionarRemesaReversar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		  seleccionarRemesaReversar2.click();	 Thread.sleep(secDelay);	
		  WebElement botonReversar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
          botonReversar2.click();
          WebElement ReversoEstado2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	      ReversoEstado2.click();
	      WebElement aceptarReverso2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarReverso2.click();
	    	 
	      //Avance al Estado Atracado--------------------------------------------------------------------------------------------------------------------------------
	    	
	      WebElement seleccionarRemesaAvanzarAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	      seleccionarRemesaAvanzarAtracado.click();		Thread.sleep(secDelay);	
	      WebElement botonAvanzaAlternoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("avanzarAlterno-btnInnerEl")));
	      botonAvanzaAlternoAtracado.click();
	      WebElement desplegarEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nodoAlterno-trigger-picker")));
	      desplegarEstadoAtracado.click();
	      WebElement seleccionarEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item x-boundlist-item-over'][text()='Atracado']"))); 
	      seleccionarEstadoAtracado.click();
	      WebElement aceptarEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarAvanzarAlterno-btnInnerEl")));
	      aceptarEstadoAtracado.click();	 Thread.sleep(secDelay);
	        
	      WebElement mensajeAvanceEstadoAtracado = driver.findElement(By.id("messagebox-1027-msg"));
	      String texto14 = mensajeAvanceEstadoAtracado.getText();
	      System.out.println("Avance: " + texto14);
	    	 
	      WebElement aceptarMensajeAvanceEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarMensajeAvanceEstadoAtracado.click();

	      //Reverso Estado Atracado-----------------------------------------------------------------------------------------------------------------------------------
	    	
	      WebElement seleccionarRemesaAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	      seleccionarRemesaAtracado.click();
	      Thread.sleep(secDelay);	
	      WebElement botonReversarAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
	      botonReversarAtracado.click();
	      WebElement ReversoEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	      ReversoEstadoAtracado.click();
	      Thread.sleep(secDelay);
	    	
	      WebElement mensajeReversoEstadoAtracado = driver.findElement(By.id("messagebox-1027-msg"));
	      	String texto15 = mensajeReversoEstadoAtracado.getText();
	      	System.out.println("Reverso: " + texto15);
	    	 
	      WebElement aceptarMensajeReversoEstadoAtracado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarMensajeReversoEstadoAtracado.click();
	      
	      //Reverso Despachado-----------------------------------------------------------------------------------------------------------------------------------------
	      
	      WebElement seleccionarRemesaReversoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
	      seleccionarRemesaReversoDespachado.click();
	      Thread.sleep(secDelay);	
	      WebElement botonReversarDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
	      botonReversarDespachado.click();
	      WebElement ReversoEstadoDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
	      ReversoEstadoDespachado.click();
	      WebElement botonConfirmarReversarDespachado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1032-btnInnerEl")));
	      botonConfirmarReversarDespachado.click();
	      Thread.sleep(secDelay);
	    	
	      WebElement mensajeReversoEstadoAprobado = driver.findElement(By.id("messagebox-1027-msg"));
	     	String texto16 = mensajeReversoEstadoAprobado.getText();
	    	System.out.println("Reverso: " + texto16);
	    	 
	      WebElement aceptarMensajeReversoEstadoAprobado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	      aceptarMensajeReversoEstadoAprobado.click();
	      	
	
	             	
	      //Consulta Inventario Reverso Despachado---------------------------------------------------------------------------------------------------------------
	      
	      driver.switchTo().window(InventarioInicialEmisor);        
	         
          WebElement consultarInventario10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
          consultarInventario10.click();
          
          WebElement CantidadDenominacion_100_Receptor11 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));	
		  Thread.sleep(secDelay);
		  String Cantidad_100_Receptor11 = CantidadDenominacion_100_Receptor11.getText();
		  Cantidad_100_Receptor11 = Cantidad_100_Receptor11.replace(".", "");
		  double ObtenerPiezasDenominacion_100_Reverso_Aprobado = Double.parseDouble(Cantidad_100_Receptor11);
		  System.out.println(ObtenerPiezasDenominacion_100_Reverso_Aprobado);
//		  Assert.assertEquals(ObtenerPiezasDenominacion_100_Reverso_Aprobado, (ObtenerPiezasDenominacion_100_Reverso_Despachado), 0.000001);
		  System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Aprobado luego de reversarlo del estado Despachado (Inventario Receptor)");		Thread.sleep(secDelay);
	                           	 
		  //Consulta Inventario Reverso Aprobado
		  
		  driver.switchTo().window(Inicio);
	                
		  WebElement seleccionarRemesaReversar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1065']")));
		  seleccionarRemesaReversar3.click();
		  Thread.sleep(secDelay);	
		  WebElement botonReversar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reversar-btnWrap")));
		  botonReversar3.click();
		  WebElement ReversoEstado3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarReversar-btnInnerEl")));
		  ReversoEstado3.click();
		  WebElement aceptarReverso3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
		  aceptarReverso3.click();
	   		
	      //Consulta Inventario Reverso Solicitado
		  
		  driver.switchTo().window(InventarioInicialEmisor);   
	        
	      WebElement consultarInventario11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro-btnInnerEl")));
	      consultarInventario11.click();
	       
	      WebElement CantidadDenominacion_100_Receptor12 = driver.findElement(By.xpath("//td[@data-columnid='gridcolumn-1017']"));	
		  Thread.sleep(secDelay);
		  String Cantidad_100_Receptor12 = CantidadDenominacion_100_Receptor12.getText();
		  Cantidad_100_Receptor12 = Cantidad_100_Receptor12.replace(".", "");
//		  double ObtenerPiezasDenominacion_100_Reverso_Aprobado = Double.parseDouble(Cantidad_100_Receptor12);
		  System.out.println(ObtenerPiezasDenominacion_100_Reverso_Aprobado);
		  Assert.assertEquals(ObtenerPiezasDenominacion_100_Reverso_Aprobado, (ObtenerPiezasDenominacion_100_Reverso_Aprobado), 0.000001);
		  System.out.println("El resultado de la comparacion fue certificado de manera exitosa cuando estamos en el estado Aprobado luego de reversarlo del estado Despachado (Inventario Receptor)");		Thread.sleep(secDelay);             	 
	    	
	    	//Consultas Gerenciales
	    	
	    	WebElement inicioCasita = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	    	inicioCasita.click();
	    	WebElement consulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='./images/menu/consultas.jpg']")));
	    	consulta.click();
	    	WebElement consultaGenerakes = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"consultasGenerales\"]")));
	    	consultaGenerakes.click();
	    	Thread.sleep(secDelay);
	    	WebElement desplegarReportes = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reporteReportConsult-trigger-picker")));
	    	desplegarReportes.click();
	    	WebElement seleccionarReportes = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#boundlist-1021-listEl > li:nth-child(3)")));
	    	seleccionarReportes.click();
	    	Thread.sleep(secDelay);
	    	WebElement desplegarTipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoAgrupacionReportConsult-trigger-picker")));
	    	desplegarTipoUnidad.click();
	    	Thread.sleep(secDelay);
	    	WebElement seleccionarTipoUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#boundlist-1023-listEl > li:nth-child(3)")));
	    	seleccionarTipoUnidad.click();
	    	Thread.sleep(secDelay);	
	    	WebElement desplegarUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreAgrupacionReportConsult-trigger-picker")));
	    	desplegarUnidad.click();
	    	Thread.sleep(secDelay);
	    	WebElement seleccionarUnidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='x-boundlist-item'][text()='1105 - CDA PA 3']")));
	    	seleccionarUnidad.click();
	    	Thread.sleep(secDelay);
	    	WebElement desplegarDivisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisaReportConsult-trigger-picker")));
	    	desplegarDivisas.click();
	        Thread.sleep(secDelay);
	    	WebElement seleccionarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Dólar']")));
	    	seleccionarDivisa.click();
	    	Thread.sleep(secDelay);
	    	WebElement iconoImprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
	    	iconoImprimir.click();
	    	Thread.sleep(secDelay);	
	    	WebElement aceptarImprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1031-btnInnerEl")));
	    	aceptarImprimir.click();
    	       	    
     }
}