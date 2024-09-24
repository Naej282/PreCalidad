package NoCriticosAgencia;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
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
public class Cases_202_204_208_210_212_215_216 {
	int secDelay = 1500;
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
	public void test() throws InterruptedException, IOException {
		
		//-CONSULTAS DE CAJA, IMPRIMIR CONSULTAS DE CAJA, CONSULTAS DE DIFERENCIAS, IMPRIMIR CONSULTAS DE DIFERENCIAS-//
		//-SALDAR DIFERENCIAS MODALIDAD TIPO FALTANTE CARGO EN CUENTA, CONTRA GASTO, MODALIDAD REPOSICIÓN DE EFECTIVO-//
		//----------------------------------CHEQUE MISMO BANCO, CHEQUE DE OTROS BANCOS.-------------------------------//
	
		LocalDate fechaActual = LocalDate.now();
    	LocalTime horaActual = LocalTime.now();
    	
    	DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	String fechaFormateada = fechaActual.format(formatoFecha);
    	DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH-mm-ss");
    	String horaFormateada = horaActual.format(formatoHora);
		
    	String nombreArchivo = fechaFormateada.replace("/", "-") + "_" + horaFormateada + ".avi";
		System.out.println("Fecha y Hora (formato dd/MM/yyyy/HH/mm/ss): " + nombreArchivo);
		
		//---------------------------Iniciar grabación de pantalla usando ffmpeg-------------------------------------//
        String outputFile = ""+Constantes.RUTA_CAPTURES+"\\NoCriticosAgencia\\Case_202_204_208_210_212_215_216\\"+nombreArchivo+"";
        String ffmpegCommand = String.format("ffmpeg -y -f gdigrab -i desktop -framerate 60 "
        									+ "-video_size 19820x1080 -vf "+Constantes.ConfigFFMPEG+" "
        									+ "-offset_x 0 -offset_y 0 -codec:v libx264 %s", outputFile);
        ffmpegProcess = Runtime.getRuntime().exec(ffmpegCommand);
        
		//-------------------------------------------------Espera Explícita-------------------------------------------//
		
		WebDriverWait ewait = new WebDriverWait(driver,10);	
	
		String directorioCapturas = ""+Constantes.RUTA_CAPTURES+"\\NoCriticosAgencia\\Case_202_204_208_210_212_215_216";
        String Archivo = "202.png";
        String captura = directorioCapturas + "/" + Archivo;
        String Archivo1 = "208.png";
        String captura1 = directorioCapturas + "/" + Archivo1;
        String Archivo2 = "208.png";
        String captura2 = directorioCapturas + "/" + Archivo2;
        String Archivo4 = "212.png";
        String captura4 = directorioCapturas + "/" + Archivo4;
        String Archivo5 = "215.png";
        String captura5 = directorioCapturas + "/" + Archivo5;
        String Archivo6 = "216.png";
        String captura6 = directorioCapturas + "/" + Archivo6;

		//-----------------------------------------------INGRESAMOS EN AGENCIA-----------------------------------------//
	
		WebElement login = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		login.sendKeys(Constantes.USUARIO);		
		WebElement password = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys(Constantes.CONTRASEÑA);							
		WebElement logear = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imagenOk")));
		logear.click();		Thread.sleep(secDelay);

		//-----------------------------------------------202 CONSULTAMOS CAJAS-------------------------------------------//
		
		WebElement Caja = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taquilla")));
	    Caja.click();		Thread.sleep(secDelay);
		WebElement Cajas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terminales")));
	   	Cajas.click();										
		WebElement DespelgarEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-inputWrap")));
		DespelgarEstado.click();	Thread.sleep(secDelay);		
		WebElement Estado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Todas']")));
		Estado.click();										
		WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-inputWrap")));
		DesplegarDivisa.click();	Thread.sleep(secDelay);
		WebElement Divisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa.click();									
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
		Consultar.click();
		File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(archivo, new File(captura));		Thread.sleep(secDelay);
			
		//------------------------------------------------204 IMPRIMIR CONSULTA CAJA---------------------------------------//
	    
		WebElement Imprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir.click();	Thread.sleep(secDelay);
		WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato.click();	Thread.sleep(secDelay);		
		WebElement Formato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		Formato.click();											
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1029")));
		Aceptar.click();															
		WebElement Imprimir1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir1.click();	Thread.sleep(secDelay);		
		WebElement DesplegarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato2.click();		Thread.sleep(secDelay);		
		WebElement Formato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
		Formato2.click();															
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1029")));
		Aceptar2.click();	Thread.sleep(secDelay);
			
	    //--------------------------------------------------ENTRAMOS A DIFERENCIAS-----------------------------------------//
		
		WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	    Inicio.click();	Thread.sleep(secDelay);
		WebElement Diferencias = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
	    Diferencias.click();	Thread.sleep(secDelay);
		WebElement DesplegarTipoConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
	   	DesplegarTipoConsulta.click();										
		WebElement TipoConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
		TipoConsulta.click();													
		WebElement DesplegarTipodeDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
		DesplegarTipodeDiferencia.click();										
		WebElement TipodeDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Faltante']")));
		TipodeDiferencia.click();												
		WebElement DesplegarDivisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
		DesplegarDivisas.click();									
		WebElement Divisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisas.click();													
		WebElement DesplegarOrigen = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
		DesplegarOrigen.click();									
		WebElement Origen = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOVEDA']")));
		Origen.click();
			
		//-------------------------------------------208 CONSULTAMOS SI EXISTEN DIFERENCIAS.--------------------------------//
		
		WebElement Consultar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
		Consultar1.click();		Thread.sleep(secDelay);
		File archivo1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(archivo1, new File(captura1));	Thread.sleep(secDelay);Thread.sleep(secDelay);

			
		//--------------------------------SI NO EXISTES UNA REMASA EN BOVEDA PASAMOS AL TRY.CATCH---------------------------//
	    
		try {
		WebElement SeleccionarDiferencias = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias.click();	
		} catch (Exception CrearUnaDiferencia) {
			
		//----------------------------ENTRAMOS A CUADRE DE AGENCIA PARA CREAR UN AJUSTE DE BÓVEDA.-------------------------//
			
		WebElement Inicio1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio1.click();	Thread.sleep(secDelay);
		WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
		CuadreDeAgencia.click();	Thread.sleep(secDelay);		
		WebElement Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
		Inventario.click();		Thread.sleep(secDelay);
		WebElement DesplegarTipoDeBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
		DesplegarTipoDeBóveda.click();		Thread.sleep(secDelay);					
		WebElement TipoDeBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
		TipoDeBóveda.click();														
		WebElement DesplegarDivisa1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		DesplegarDivisa1.click();	Thread.sleep(secDelay);			
		WebElement Divisa1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa1.click();														
		WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
		Consultar2.click();		Thread.sleep(secDelay);				
		WebElement AjusteBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda")));
		AjusteBóveda.click();	Thread.sleep(secDelay);

		//---------------------------------------------------------FALTANTES.------------------------------------------------//
		
		WebElement DesplegarDenominación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
		DesplegarDenominación.click();	Thread.sleep(secDelay);					
		WebElement Denominacón = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));
		Denominacón.click();												
		WebElement DesplegarClasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
		DesplegarClasificaión.click();	Thread.sleep(secDelay);				
		WebElement Clasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
		Clasificaión.click();									
		WebElement Cantidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantesAjuste-inputEl")));
		Cantidad.sendKeys("5");													
		WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1097")));
		Incluir.click();	Thread.sleep(secDelay);
		WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1110")));
		Aceptar3.click();	Thread.sleep(secDelay);
		WebElement Mensaje = driver.findElement(By.id("messagebox-1001-msg"));
        Thread.sleep(secDelay);
        String ObtenerMensaje = Mensaje.getText().trim();
        System.out.println(ObtenerMensaje);    
        String ExpectativaTexto = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje, ExpectativaTexto);
		WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005")));
		Aceptar4.click();	Thread.sleep(secDelay);
		
		//--------------------------------------------------VOLVEMOS A DIFERERNCIAS.---------------------------------------//
		
		WebElement Inicio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio2.click();	Thread.sleep(secDelay);
		WebElement Diferencias1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
		Diferencias1.click();		Thread.sleep(secDelay);    
		WebElement DesplegarTipoConsulta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
		DesplegarTipoConsulta1.click();		Thread.sleep(secDelay);
		WebElement TipoConsulta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
		TipoConsulta1.click();													
		WebElement DesplegarTipodeDiferencia1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
		DesplegarTipodeDiferencia1.click();		Thread.sleep(secDelay);
		WebElement TipodeDiferencia1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Faltante']")));
		TipodeDiferencia1.click();							
		WebElement DesplegarDivisas1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
		DesplegarDivisas1.click();	Thread.sleep(secDelay);
		WebElement Divisas1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisas1.click();													
		WebElement DesplegarOrigen1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
		DesplegarOrigen1.click();		Thread.sleep(secDelay);
		WebElement Origen1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOVEDA']")));
		Origen1.click();											
		WebElement Consultar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
		Consultar3.click();		Thread.sleep(secDelay);
		File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(archivo2, new File(captura2));	Thread.sleep(secDelay);Thread.sleep(secDelay);
		}
		
		//----------------------------------------210 IMPRIMIMOS EL REPORTE DE LAS DIFERENCIAS--------------------------------//
		
		WebElement Imprimir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir2.click();		Thread.sleep(secDelay);
		WebElement DesplegarFormato1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato1.click();		Thread.sleep(secDelay);		
		WebElement Formato1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='PDF']")));
		Formato1.click();											
		WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1060")));
		Aceptar3.click();															
		WebElement Imprimir3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir3.click();	Thread.sleep(secDelay);		
		WebElement DesplegarFormato3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato3.click();	Thread.sleep(secDelay);		
		WebElement Formato3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='XLSX']")));
		Formato3.click();															
		WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1060")));
		Aceptar4.click();		Thread.sleep(secDelay);
		
		//--------------------------------------------------212 SALDAMOS LA DIFERENCIA-----------------------------------------//
		
		WebElement SeleccionarDiferencias = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias.click();										
		WebElement Saldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar")));
		Saldar.click();		Thread.sleep(secDelay);				
		WebElement DesplegarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
		DesplegarModalidad.click();		Thread.sleep(secDelay);		
		WebElement Modalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Cargo en Cuenta']")));
		Modalidad.click();													
		WebElement MontoSaldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
		MontoSaldar.sendKeys("500");					
		WebElement Descripción = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
		Descripción.sendKeys("Pago");					
		WebElement NroDeCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuentaCuen-inputEl")));
		NroDeCuenta.sendKeys("210802");					
		WebElement NombreDeLaCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuentaCuen-inputEl")));
		NombreDeLaCuenta.sendKeys("Orion-5");			
		WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacionCuen")));
		Incluir.click();											
		WebElement Aceptar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarSald")));
		Aceptar1.click();	Thread.sleep(secDelay);
		WebElement Mensaje1 = driver.findElement(By.id("messagebox-1001-msg"));
        Thread.sleep(secDelay);
        String ObtenerMensaje1 = Mensaje1.getText().trim();
        System.out.println(ObtenerMensaje1);    
        String ExpectativaTexto1 = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje1, ExpectativaTexto1);
		File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(archivo4, new File(captura4));		Thread.sleep(secDelay);Thread.sleep(secDelay);
		WebElement Aceptar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		Aceptar5.click();	Thread.sleep(secDelay);
		
		//---------------------------------215 CREAR UAN DIFERERNCIA PARA SALDAR CON REPOSICIÓN DE EFECTIVO--------------------//
		
		WebElement Inicio3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio3.click();		Thread.sleep(secDelay);		
		WebElement CuadreDeAgencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
		CuadreDeAgencia.click();		Thread.sleep(secDelay);			
		WebElement Inventario = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
		Inventario.click();		Thread.sleep(secDelay);
		WebElement DesplegarTipoDeBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
		DesplegarTipoDeBóveda.click();		Thread.sleep(secDelay);
		WebElement TipoDeBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
		TipoDeBóveda.click();									
		WebElement DesplegarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		DesplegarDivisa2.click();	Thread.sleep(secDelay);
		WebElement Divisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa2.click();											
		WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
		Consultar2.click();		Thread.sleep(secDelay);		
		WebElement AjusteBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda")));
		AjusteBóveda.click();	Thread.sleep(secDelay);
		
		//---------------------------------------------------------FALTANTES.------------------------------------------------------//
		
		WebElement DesplegarDenominación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
		DesplegarDenominación.click();		Thread.sleep(secDelay);		
		WebElement Denominacón = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));
		Denominacón.click();									
		WebElement DesplegarClasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
		DesplegarClasificaión.click();		Thread.sleep(secDelay);	
		WebElement Clasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
		Clasificaión.click();				
		WebElement Cantidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantesAjuste-inputEl")));
		Cantidad.sendKeys("5");									
		WebElement Incluir1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1097")));
		Incluir1.click();		Thread.sleep(secDelay);
		WebElement Aceptar6 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1110")));
		Aceptar6.click();		Thread.sleep(secDelay);
		WebElement Mensaje2 = driver.findElement(By.id("messagebox-1001-msg"));
        Thread.sleep(secDelay);
        String ObtenerMensaje2 = Mensaje2.getText().trim();
        System.out.println(ObtenerMensaje2);    
        String ExpectativaTexto2 = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje2, ExpectativaTexto2);
		WebElement Aceptar7 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005")));
		Aceptar7.click();		Thread.sleep(secDelay);
		
		//-----------------------------------------------------VOLVEMOS A DIFERENCIAS.---------------------------------------------//
		
		WebElement Inicio1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio1.click();	Thread.sleep(secDelay);
		WebElement Diferencias2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
		Diferencias2.click();	Thread.sleep(secDelay);    
		WebElement DesplegarTipoConsulta2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
		DesplegarTipoConsulta2.click();		Thread.sleep(secDelay);
		WebElement TipoConsulta2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
		TipoConsulta2.click();										
		WebElement DesplegarTipodeDiferencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
		DesplegarTipodeDiferencia2.click();		Thread.sleep(secDelay);
		WebElement TipodeDiferencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Faltante']")));
		TipodeDiferencia2.click();							
		WebElement DesplegarDivisas2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
		DesplegarDivisas2.click();		Thread.sleep(secDelay);
		WebElement Divisas2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisas2.click();										
		WebElement DesplegarOrigen2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
		DesplegarOrigen2.click();		Thread.sleep(secDelay);
		WebElement Origen2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOVEDA']")));
		Origen2.click();											
		WebElement Consultar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
		Consultar3.click();		Thread.sleep(secDelay);
		WebElement SeleccionarDiferencias1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias1.click();	
		
		//------------------------------------SALDAR DIFERERNCIAS CON LA MODALIDAD REPOSICIÓN DE EFECTIVO--------------------------//
		
		WebElement Saldar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar")));
		Saldar1.click();		Thread.sleep(secDelay);
		WebElement DesplegarModalidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
		DesplegarModalidad1.click();		Thread.sleep(secDelay);
		WebElement Modalidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Reposicion de Efectivo']")));
		Modalidad1.click();
		WebElement MontoSaldar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
		MontoSaldar1.sendKeys("500");
		WebElement Descripción1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
		Descripción1.sendKeys("Pago");
		WebElement DesplegarDenominación1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionEfec-trigger-picker")));
		DesplegarDenominación1.click();	
		WebElement Denominacón1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));
		Denominacón1.click();			
		WebElement Cantidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEfec-inputEl")));
		Cantidad1.sendKeys("5");
		WebElement DesplegarClasificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionEfec-trigger-picker")));
		DesplegarClasificación.click();		Thread.sleep(secDelay);
		WebElement Clasificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
		Clasificación.click();
		WebElement Incluir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacionEfec")));
		Incluir2.click();		Thread.sleep(secDelay);
		WebElement Aceptar8 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarSald")));
		Aceptar8.click();		Thread.sleep(secDelay);
		WebElement Mensaje3 = driver.findElement(By.id("messagebox-1001-msg"));
        Thread.sleep(secDelay);
        String ObtenerMensaje3 = Mensaje3.getText().trim();
        System.out.println(ObtenerMensaje3);    
        String ExpectativaTexto3 = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje3, ExpectativaTexto3);
		File archivo5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(archivo5, new File(captura5));	Thread.sleep(secDelay);Thread.sleep(secDelay);
		WebElement Aceptar9 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		Aceptar9.click();
		
		//----------------------------------------216 CREAR UNA DIFERENCIA PARA SALDAR CON CHEQUE MISMO BANCO-------------------------//
		
		WebElement Inicio4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio4.click();
		WebElement CuadreDeAgencia1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cuadre")));
		CuadreDeAgencia1.click();		Thread.sleep(secDelay);
		WebElement Inventario1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventario")));
		Inventario1.click();			Thread.sleep(secDelay);
		WebElement DesplegarTipoDeBóveda1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boveda-trigger-picker")));
		DesplegarTipoDeBóveda1.click();		Thread.sleep(secDelay);
		WebElement TipoDeBóveda1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Bóveda Disponible']")));
		TipoDeBóveda1.click();									
		WebElement DesplegarDivisa1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		DesplegarDivisa1.click();	Thread.sleep(secDelay);	
		WebElement Divisa1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisa1.click();												
		WebElement Consultar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
		Consultar4.click();			Thread.sleep(secDelay);		
		WebElement AjusteBóveda1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda")));
		AjusteBóveda1.click();		Thread.sleep(secDelay);

		//-----------------------------------------------------------FALTANTES--------------------------------------------------//
		
		WebElement DesplegarDenominación2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
		DesplegarDenominación2.click();	Thread.sleep(secDelay);	
		WebElement Denominacón2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Billete - 100,000']")));
		Denominacón2.click();									
		WebElement DesplegarClasificaión1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
		DesplegarClasificaión1.click();	Thread.sleep(secDelay);	
		WebElement Clasificaión1= ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Aptos']")));
		Clasificaión1.click();								
		WebElement Cantidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantesAjuste-inputEl")));
		Cantidad2.sendKeys("5");									
		WebElement Incluir3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1097")));
		Incluir3.click();	Thread.sleep(secDelay);
		WebElement Aceptar10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1110")));
		Aceptar10.click();
		WebElement Mensaje4 = driver.findElement(By.id("messagebox-1001-msg"));
        Thread.sleep(secDelay);
        String ObtenerMensaje4 = Mensaje4.getText().trim();
        System.out.println(ObtenerMensaje4);    
        String ExpectativaTexto4 = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje4, ExpectativaTexto4);
		WebElement Aceptar11 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005")));
		Aceptar11.click();	
			
		//-----------------------------------------------------VOLVEMOS A DIFERENCIAS.--------------------------------------------//
		
		WebElement Inicio2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
		Inicio2.click();	Thread.sleep(secDelay);
		WebElement Diferencias3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
		Diferencias3.click();	Thread.sleep(secDelay);
		WebElement DesplegarTipoConsulta3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
		DesplegarTipoConsulta3.click();		Thread.sleep(secDelay);
		WebElement TipoConsulta3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Pendiente']")));
		TipoConsulta3.click();										
		WebElement DesplegarTipodeDiferencia3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
		DesplegarTipodeDiferencia3.click();		Thread.sleep(secDelay);
		WebElement TipodeDiferencia3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Faltante']")));
		TipodeDiferencia3.click();							
		WebElement DesplegarDivisas3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
		DesplegarDivisas3.click();		Thread.sleep(secDelay);
		WebElement Divisas3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+Constantes.DIVISA+"']")));
		Divisas3.click();													
		WebElement DesplegarOrigen3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
		DesplegarOrigen3.click();	Thread.sleep(secDelay);		
		WebElement Origen3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='BOVEDA']")));
		Origen3.click();													
		WebElement Consultar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
		Consultar5.click();		Thread.sleep(secDelay);	
		WebElement SeleccionarDiferencias2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias2.click();								
		
		//----------------------------------------------------SALDAR CON CHEQUE MISMO BANCO.-----------------------------------------//
		
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
		WebElement Banco = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='401 - Orion - 5']")));
		Banco.click();				
		WebElement NroDeCuenta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuenta-inputEl")));
		NroDeCuenta1.sendKeys("210802");			
		WebElement NombreDeLaCuenta1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuenta-inputEl")));
		NombreDeLaCuenta1.sendKeys("Orion-5");		Thread.sleep(secDelay);	
		WebElement Serial = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("serial-inputEl")));
		Serial.sendKeys("031114");	
		WebElement Incluir4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacion")));
		Incluir4.click();		Thread.sleep(secDelay);
		WebElement Aceptar12 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarSald")));
		Aceptar12.click();		Thread.sleep(secDelay);
		WebElement Mensaje5 = driver.findElement(By.id("messagebox-1001-msg"));
        Thread.sleep(secDelay);
        String ObtenerMensaje5 = Mensaje5.getText().trim();
        System.out.println(ObtenerMensaje5);    
        String ExpectativaTexto5 = "Registro creado exitosamente";
        Assert.assertEquals(ObtenerMensaje5, ExpectativaTexto5);
		File archivo6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(archivo6, new File(captura6));	Thread.sleep(secDelay);Thread.sleep(secDelay);
		WebElement Aceptar13 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		Aceptar13.click();		Thread.sleep(secDelay);
		}
	
		@After
		public void tearDown() throws Exception {
			
		//-------------------------------------------------------Cerrar el navegador---------------------------------------//
			
		Thread.sleep(3000);
		if (driver != null) {
		    driver.quit();
		}
		
		//------------------------------Asegúrate de que todas las tareas pendientes han finalizado-------------------------//
		
		//-------------------------------------Espera de 1 segundo (puedes ajustar este valor)------------------------------//
		
		Thread.sleep(2000);
		
		//----------------------------------------------DETENER LA GRABACIÓN DE LA PANTALLA---------------------------------//
		
		if (ffmpegProcess != null) {
		    ffmpegProcess.destroy();
		    ffmpegProcess.waitFor(); 
		
		//------------------------------------Esperar a que el proceso FFmpeg se detenga completamente----------------------//
		    
		    }
	 	}
	}