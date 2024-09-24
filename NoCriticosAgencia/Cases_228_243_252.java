package NoCriticosAgencia;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constantes.Constantes;

public class Cases_228_243_252 {
	int secDelay = 1000;
	private WebDriver driver;
	private Process ffmpegProcess;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constantes.URL_AGENCIA);
	}

	@Test
	public void Test() throws InterruptedException, IOException {
		
		//--------------------SALDAR DIFERENCIAS TIPO SOBRANTE: ENTREGA DE EFECTIVO,------------------// 
		//-------CHEQUE MISMO BANCO O CHEQUE DE OTROS BANCOS, ABONO EN CUNETA O CONTRA INGRESO.-------//
		
		LocalDate fechaActual = LocalDate.now();
    	LocalTime horaActual = LocalTime.now();
    	
    	DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	String fechaFormateada = fechaActual.format(formatoFecha);
    	DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH-mm-ss");
    	String horaFormateada = horaActual.format(formatoHora);
		
    	String nombreArchivo = fechaFormateada.replace("/", "-") + "_" + horaFormateada + ".avi";
		System.out.println("Fecha y Hora (formato dd/MM/yyyy/HH/mm/ss): " + nombreArchivo);
		
		//-------------------------Iniciar grabación de pantalla usando ffmpeg-----------------------//
		
        String outputFile = "C:\\Users\\esalvatierra\\Videos\\EvidenciasCOE\\PreCalidad\\NoCriticosAgencia\\Case_228_243_252\\"+nombreArchivo+"";
        String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 "
        									+ "-video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" "
        									+ "-offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
        ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
		
		//---------------------------------------Espera Explícita-------------------------------------//
		
		WebDriverWait ewait = new WebDriverWait(driver,10);
		
		String directorioCapturas = ""+Constantes.RUTA_CAPTURES+"\\NoCriticosAgencia\\Case_228_243_252";
        String nombreArchivo1 = "228.png";
        String captura = directorioCapturas + "/" + nombreArchivo1;
        String nombreArchivo2 = "243.png";
        String captura1 = directorioCapturas + "/" + nombreArchivo2;
        String nombreArchivo3 = "252.png";
        String captura2 = directorioCapturas + "/" + nombreArchivo3;
		
		//-------------------------------------INGRESAMOS EN AGENCIA.--------------------------------//
		
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);	Thread.sleep(secDelay);		
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);
		
	    //-------------------------------------ENTRAMOS A DIFERENCIAS.-------------------------------//
		
		WebElement Diferencias = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
	    Diferencias.click();	Thread.sleep(secDelay);
		WebElement DesplegarTipoConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
	   	DesplegarTipoConsulta.click();										
		WebElement TipoConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
		TipoConsulta.click();													
		WebElement DesplegarTipodeDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
		DesplegarTipodeDiferencia.click();										
		WebElement TipodeDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Sobrante']")));
		TipodeDiferencia.click();												
		WebElement DesplegarDivisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
		DesplegarDivisas.click();									
		WebElement Divisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisas.click();													
		WebElement DesplegarOrigen = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
		DesplegarOrigen.click();									
		WebElement Origen = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOVEDA']")));
		Origen.click();
			
		//--------------------------------CONSULTAMOS SI EXISTE UNA DIFERENCIA.-----------------------//
		
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
		Consultar.click();		Thread.sleep(secDelay);
			
		//--------------------SI NO EXISTE UAN REMESA EN BOVEDA CREADA PASAMOS AL TRY.CATH.------------//
		
		try {
		WebElement SeleccionarDiferencias = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias.click();	
			} catch (Exception CrearUnaDiferencia) {
				
			//---------------------ENTRAMOS A CUADRE DE AGENCIA PARA CREAR UN AJUSTE DE BÓVEDA.-------------//
				
			WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio.click();		Thread.sleep(secDelay);
			WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
			CuadreDeAgencia.click();	Thread.sleep(secDelay);		
			WebElement Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
			Inventario.click();		Thread.sleep(secDelay);
			WebElement DesplegarTipoDeBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
			DesplegarTipoDeBóveda.click();		Thread.sleep(secDelay);					
			WebElement TipoDeBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
			TipoDeBóveda.click();														
			WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			DesplegarDivisa.click();	Thread.sleep(secDelay);			
			WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
			Divisa.click();														
			WebElement Consultar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
			Consultar1.click();		Thread.sleep(secDelay);				
			WebElement AjusteBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda")));
			AjusteBóveda.click();		Thread.sleep(secDelay);
	
			//------------------------------------------------FALTANTES----------------------------------------//
			
			WebElement DesplegarDenominación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionSobrantesAjuste-triggerWrap")));
			DesplegarDenominación.click();		Thread.sleep(secDelay);					
			WebElement Denominacón = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));
			Denominacón.click();												
			WebElement DesplegarClasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionSobrantesAjuste-trigger-picker")));
			DesplegarClasificaión.click();		Thread.sleep(secDelay);				
			WebElement Clasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
			Clasificaión.click();									
			WebElement Cantidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadSobrantesAjuste-inputEl")));
			Cantidad.sendKeys("5");													
			WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1087")));
			Incluir.click();		Thread.sleep(secDelay);
			WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1110")));
			Aceptar2.click();		Thread.sleep(secDelay);	
			WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005")));
			Aceptar3.click();		
			
			//-------------------------------------------VOLVEMOS A DIFERENCIAS--------------------------------//
			
			WebElement Inicio1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio1.click();		Thread.sleep(secDelay);
			WebElement Diferencias1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
			Diferencias1.click();		Thread.sleep(secDelay);    
			WebElement DesplegarTipoConsulta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
			DesplegarTipoConsulta1.click();		Thread.sleep(secDelay);
			WebElement TipoConsulta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
			TipoConsulta1.click();													
			WebElement DesplegarTipodeDiferencia1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
			DesplegarTipodeDiferencia1.click();		Thread.sleep(secDelay);
			WebElement TipodeDiferencia1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Sobrante']")));
			TipodeDiferencia1.click();					
			WebElement DesplegarDivisas1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
			DesplegarDivisas1.click();	Thread.sleep(secDelay);
			WebElement Divisas1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
			Divisas1.click();													
			WebElement DesplegarOrigen1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
			DesplegarOrigen1.click();	Thread.sleep(secDelay);
			WebElement Origen1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOVEDA']")));
			Origen1.click();											
			WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
			Consultar2.click();		Thread.sleep(secDelay);
			}
		
		//-------------------------------------------SALDAMOS LA DIFERENCIA.-------------------------------//
		
		WebElement SeleccionarDiferencias = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias.click();										
		WebElement Saldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar")));
		Saldar.click();		Thread.sleep(secDelay);				
		WebElement DesplegarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
		DesplegarModalidad.click();		Thread.sleep(secDelay);		
		WebElement Modalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Entrega de Efectivo']")));
		Modalidad.click();													
		WebElement MontoSaldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
		MontoSaldar.sendKeys("500");					
		WebElement Descripción = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
		Descripción.sendKeys("Pago");					
		WebElement DesplegarDenominacón = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionEfec-trigger-picker")));
		DesplegarDenominacón.click();					
		WebElement Denominación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));
		Denominación.click();
		WebElement Cantidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEfec-inputEl")));
		Cantidad.sendKeys("5");
		WebElement DesplegarClasificación = driver.findElement(By.id("clasificacionEfec-trigger-picker"));
	    DesplegarClasificación.click();		Thread.sleep(secDelay);
	    List<WebElement> options1 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
	    for (WebElement option : options1) {
	      if (option.getText().equals("Aptos")) {
	          option.click();
	          break;	            
	          }
	    }	Thread.sleep(secDelay);	
		WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacionEfec")));
		Incluir.click();	Thread.sleep(secDelay);
		WebElement Aceptar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarSald")));
		Aceptar1.click();	Thread.sleep(secDelay);Thread.sleep(secDelay);
		
			File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(archivo, new File(captura));		Thread.sleep(secDelay);
			
		WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		Aceptar3.click();										Thread.sleep(secDelay);
				
		//-243 SALDAR CON MODALIDAD TIPO SOBRANTE: CHEQUE MISMO BANCO CHEQUE DE OTROS BANCOS, MODULO AGENCIA.-//
		
		try {
		WebElement SeleccionarDiferencias1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias1.click();	
			} catch (Exception CrearUnaDiferencia) {
			
		//-------------------------ENTRANMOS A CUADRE DE AGENCIA PARA CREAR UN AJUSTE DE BÓVEDA.---------------//
			
			WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio.click();		Thread.sleep(secDelay);
			WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
			CuadreDeAgencia.click();	Thread.sleep(secDelay);		
			WebElement Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
			Inventario.click();		Thread.sleep(secDelay);
			WebElement DesplegarTipoDeBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
			DesplegarTipoDeBóveda.click();		Thread.sleep(secDelay);					
			WebElement TipoDeBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
			TipoDeBóveda.click();														
			WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			DesplegarDivisa.click();	Thread.sleep(secDelay);			
			WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
			Divisa.click();														
			WebElement Consultar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
			Consultar1.click();		Thread.sleep(secDelay);				
			WebElement AjusteBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda")));
			AjusteBóveda.click();	Thread.sleep(secDelay);
	
			//--------------------------------------------------FALTANTES.--------------------------------------//
			
			WebElement DesplegarDenominación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionSobrantesAjuste-triggerWrap")));
			DesplegarDenominación.click();		Thread.sleep(secDelay);					
			WebElement Denominacón = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));
			Denominacón.click();												
			WebElement DesplegarClasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionSobrantesAjuste-trigger-picker")));
			DesplegarClasificaión.click();		Thread.sleep(secDelay);				
			WebElement Clasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
			Clasificaión.click();									
			WebElement Cantidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadSobrantesAjuste-inputEl")));
			Cantidad1.sendKeys("5");	Thread.sleep(secDelay);				
			WebElement Incluir1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1087")));
			Incluir1.click();	Thread.sleep(secDelay);
			WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1110")));
			Aceptar4.click();	 Thread.sleep(secDelay);	
			WebElement Aceptar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005")));
			Aceptar5.click();		
			
			//-------------------------------------------VOLVEMOS A DIFERENCIAS.--------------------------------//
			
			WebElement Inicio1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio1.click();	Thread.sleep(secDelay);
			WebElement Diferencias1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
			Diferencias1.click();	Thread.sleep(secDelay);    
			WebElement DesplegarTipoConsulta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
			DesplegarTipoConsulta1.click();		Thread.sleep(secDelay);
			WebElement TipoConsulta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
			TipoConsulta1.click();													
			WebElement DesplegarTipodeDiferencia1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
			DesplegarTipodeDiferencia1.click();		Thread.sleep(secDelay);
			WebElement TipodeDiferencia1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Sobrante']")));
			TipodeDiferencia1.click();							
			WebElement DesplegarDivisas1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
			DesplegarDivisas1.click();	Thread.sleep(secDelay);
			WebElement Divisas1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
			Divisas1.click();													
			WebElement DesplegarOrigen1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
			DesplegarOrigen1.click();	Thread.sleep(secDelay);
			WebElement Origen1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOVEDA']")));
			Origen1.click();											
			WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
			Consultar2.click();		Thread.sleep(secDelay);
			}
		
		//----------------------------------------------------SALDAR.--------------------------------------//
		
		WebElement SeleccionarDiferencias1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias1.click();
		WebElement Saldar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar")));
		Saldar2.click();		Thread.sleep(secDelay);
		WebElement DesplegarModalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
		DesplegarModalidad2.click();	Thread.sleep(secDelay);
		WebElement Modalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cheque mismo Banco']")));
		Modalidad2.click();													
		WebElement MontoSaldar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
		MontoSaldar2.sendKeys("500");						
		WebElement Descripción2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
		Descripción2.sendKeys("Pago");				
		WebElement DesplegarBanco = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("banco-trigger-picker")));
		DesplegarBanco.click();			
		WebElement Banco = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='122 - Banco Ka']")));
		Banco.click();				
		WebElement NroDeCuenta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuenta-inputEl")));
		NroDeCuenta1.sendKeys("210802");			
		WebElement NombreDeLaCuenta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuenta-inputEl")));
		NombreDeLaCuenta1.sendKeys("Orion-5");	Thread.sleep(secDelay);	
		WebElement Serial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("serial-inputEl")));
		Serial.sendKeys("031114");	
		WebElement Incluir4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacion")));
		Incluir4.click();		Thread.sleep(secDelay);
		WebElement Aceptar12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarSald")));
		Aceptar12.click();		Thread.sleep(secDelay);Thread.sleep(secDelay);
		
			File archivo1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(archivo1, new File(captura1));		Thread.sleep(secDelay);
		
		WebElement Aceptar11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		Aceptar11.click();
			
		//--252 SALDAR DIFERENCIA MODALIDAD TIPO SOBRANTE: ABONO EN CUENTA O CONTRA INGRESO / MODULOA GENCIA.--//
		
		try {
		WebElement SeleccionarDiferencias2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias2.click();
			} catch (Exception CrearUnaDiferencia) {
	
			//----------------------ENTRAMOS A CUADRE DE AGENCIA PARA CREAR UN AJUSTE DE BÓVEDA.------------------//
				
			WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio.click();		Thread.sleep(secDelay);
			WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
			CuadreDeAgencia.click();	Thread.sleep(secDelay);		
			WebElement Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
			Inventario.click();		Thread.sleep(secDelay);
			WebElement DesplegarTipoDeBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
			DesplegarTipoDeBóveda.click();		Thread.sleep(secDelay);					
			WebElement TipoDeBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
			TipoDeBóveda.click();														
			WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
			DesplegarDivisa.click();	Thread.sleep(secDelay);			
			WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
			Divisa.click();														
			WebElement Consultar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
			Consultar1.click();		Thread.sleep(secDelay);				
			WebElement AjusteBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda")));
			AjusteBóveda.click();	Thread.sleep(secDelay);
	
			//-------------------------------------------------FALTANTES.-------------------------------------------//
			
			WebElement DesplegarDenominación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionSobrantesAjuste-triggerWrap")));
			DesplegarDenominación.click();		Thread.sleep(secDelay);					
			WebElement Denominacón = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));
			Denominacón.click();												
			WebElement DesplegarClasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionSobrantesAjuste-trigger-picker")));
			DesplegarClasificaión.click();		Thread.sleep(secDelay);				
			WebElement Clasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
			Clasificaión.click();									
			WebElement Cantidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadSobrantesAjuste-inputEl")));
			Cantidad1.sendKeys("5");	Thread.sleep(secDelay);				
			WebElement Incluir1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1087")));
			Incluir1.click();	Thread.sleep(secDelay);
			WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1110")));
			Aceptar4.click();	Thread.sleep(secDelay);	
			WebElement Aceptar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005")));
			Aceptar5.click();	Thread.sleep(secDelay);
			
			//------------------------------------------VOLVEMOS A DIFERERNCIA.-----------------------------------//
			
			WebElement Inicio1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
			Inicio1.click();	Thread.sleep(secDelay);
			WebElement Diferencias1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
			Diferencias1.click();	Thread.sleep(secDelay);    
			WebElement DesplegarTipoConsulta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
			DesplegarTipoConsulta1.click();		Thread.sleep(secDelay);
			WebElement TipoConsulta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
			TipoConsulta1.click();													
			WebElement DesplegarTipodeDiferencia1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
			DesplegarTipodeDiferencia1.click();		Thread.sleep(secDelay);
			WebElement TipodeDiferencia1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Sobrante']")));
			TipodeDiferencia1.click();							
			WebElement DesplegarDivisas1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
			DesplegarDivisas1.click();		Thread.sleep(secDelay);
			WebElement Divisas1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
			Divisas1.click();													
			WebElement DesplegarOrigen1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
			DesplegarOrigen1.click();		Thread.sleep(secDelay);
			WebElement Origen1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOVEDA']")));
			Origen1.click();											
			WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
			Consultar2.click();		Thread.sleep(secDelay);
			}
		
		//-------------------------------------------SALDAMOS LA DIFERENCIA.---------------------------------//
		
		WebElement SeleccionarDiferencias2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias2.click();										
		WebElement Saldar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar")));
		Saldar1.click();	Thread.sleep(secDelay);				
		WebElement DesplegarModalidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
		DesplegarModalidad1.click();		Thread.sleep(secDelay);		
		WebElement Modalidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Contra Ingreso']")));
		Modalidad1.click();													
		WebElement MontoSaldar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
		MontoSaldar1.sendKeys("500");					
		WebElement Descripción1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
		Descripción1.sendKeys("Pago");					
		WebElement NrodeCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuentaCuen-inputEl")));
		NrodeCuenta.sendKeys("210802");					
		WebElement NombreDeLaCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuentaCuen-inputEl")));
		NombreDeLaCuenta.sendKeys("Orion-5");	
		WebElement Incluir1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacionCuen")));
		Incluir1.click();	Thread.sleep(secDelay);
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarSald")));
		Aceptar2.click();		Thread.sleep(secDelay);Thread.sleep(secDelay);
		
			File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(archivo2, new File(captura2));		Thread.sleep(secDelay);
			
		WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		Aceptar4.click();		Thread.sleep(secDelay);
		}	
	
		@After
		public void tearDown() throws Exception {
			
	    //---------------------------------------------Cerrar el navegador-------------------------------------//
			
		Thread.sleep(3000);
	    if (driver != null) {
	        driver.quit();
	    }
	    
	    //--------------------------Asegúrate de que todas las tareas pendientes han finalizado----------------//
	    
	    //---------------------------------Espera de 1 segundo (puedes ajustar este valor)---------------------//
	    
	    Thread.sleep(2000);
	    
	    //-----------------------------------------Detener la grabación de pantalla----------------------------//
	    
	    if (ffmpegProcess != null) {
	        ffmpegProcess.destroy();
	        ffmpegProcess.waitFor();
	        
	    //-----------------------------Esperar a que el proceso FFmpeg se detenga completamente-----------------//		 
	    	}
		}
	}