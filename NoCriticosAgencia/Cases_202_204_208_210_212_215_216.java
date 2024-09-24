package NoCriticosAgencia;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
	   	Cajas.click();		Thread.sleep(secDelay);									
		WebElement DespelgarEstado = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-inputWrap")));
		DespelgarEstado.click();	Thread.sleep(secDelay);		
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options) {
            if (option.getText().equals("Todas")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);										
		WebElement DesplegarDivisa = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-inputWrap")));
		DesplegarDivisa.click();	Thread.sleep(secDelay);
		List<WebElement> options1 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options1) {
            if (option.getText().equals(""+Constantes.DIVISA+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);									
		WebElement Consultar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
		Consultar.click();
		
			File archivo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(archivo, new File(captura));		Thread.sleep(secDelay);
			
		//------------------------------------------------204 IMPRIMIR CONSULTA CAJA---------------------------------------//
	    
		WebElement Imprimir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir.click();	Thread.sleep(secDelay);
		WebElement DesplegarFormato = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato.click();	Thread.sleep(secDelay);		
		List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options2) {
            if (option.getText().equals("PDF")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);												
		WebElement Aceptar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1029")));
		Aceptar.click();															
		WebElement Imprimir1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir1.click();	Thread.sleep(secDelay);		
		WebElement DesplegarFormato2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato2.click();		Thread.sleep(secDelay);		
		List<WebElement> options3 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options3) {
            if (option.getText().equals("XLSX")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);																
		WebElement Aceptar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1029")));
		Aceptar2.click();	Thread.sleep(secDelay);
			
	    //--------------------------------------------------ENTRAMOS A DIFERENCIAS-----------------------------------------//
		
		WebElement Inicio = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inicio")));
	    Inicio.click();	Thread.sleep(secDelay);
		WebElement Diferencias = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("diferencias")));
	    Diferencias.click();	Thread.sleep(secDelay);
		WebElement DesplegarTipoConsulta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoConsulta-trigger-picker")));
	   	DesplegarTipoConsulta.click();										
	   	List<WebElement> options4 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options4) {
            if (option.getText().equals("Pendiente")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);														
		WebElement DesplegarTipodeDiferencia = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
		DesplegarTipodeDiferencia.click();										
		List<WebElement> options5 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options5) {
            if (option.getText().equals("Faltante")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);													
		WebElement DesplegarDivisas = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
		DesplegarDivisas.click();									
		List<WebElement> options6 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options6) {
            if (option.getText().equals(""+Constantes.DIVISA+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);														
		WebElement DesplegarOrigen = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
		DesplegarOrigen.click();									
		List<WebElement> options7 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options7) {
            if (option.getText().equals("BOVEDA")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);	
			
		//-------------------------------------------208 CONSULTAMOS SI EXISTEN DIFERENCIAS.--------------------------------//
		
		WebElement Consultar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
		Consultar1.click();		Thread.sleep(secDelay);
		
			File archivo1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(archivo1, new File(captura1));	Thread.sleep(secDelay);

			
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
		List<WebElement> options8 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options8) {
            if (option.getText().equals("Bóveda Disponible")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);															
		WebElement DesplegarDivisa1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		DesplegarDivisa1.click();	Thread.sleep(secDelay);			
		List<WebElement> options9 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options9) {
            if (option.getText().equals(""+Constantes.DIVISA+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);															
		WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
		Consultar2.click();		Thread.sleep(secDelay);				
		WebElement AjusteBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda")));
		AjusteBóveda.click();	Thread.sleep(secDelay);

		//---------------------------------------------------------FALTANTES.------------------------------------------------//
		
		WebElement DesplegarDenominación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
		DesplegarDenominación.click();	Thread.sleep(secDelay);					
		List<WebElement> options10 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options10) {
            if (option.getText().equals(""+Constantes.DENOMINACION+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);													
		WebElement DesplegarClasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
		DesplegarClasificaión.click();	Thread.sleep(secDelay);				
		List<WebElement> options11 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options11) {
            if (option.getText().equals("Aptos")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);										
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
		List<WebElement> options12 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options12) {
            if (option.getText().equals("Pendiente")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);													
		WebElement DesplegarTipodeDiferencia1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
		DesplegarTipodeDiferencia1.click();		Thread.sleep(secDelay);
		List<WebElement> options13 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options13) {
            if (option.getText().equals("Faltante")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);							
		WebElement DesplegarDivisas1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
		DesplegarDivisas1.click();	Thread.sleep(secDelay);
		List<WebElement> options14 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options14) {
            if (option.getText().equals(""+Constantes.DIVISA+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);													
		WebElement DesplegarOrigen1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
		DesplegarOrigen1.click();		Thread.sleep(secDelay);
		List<WebElement> options15 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options15) {
            if (option.getText().equals("BOVEDA")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);											
		WebElement Consultar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
		Consultar3.click();		Thread.sleep(secDelay);
		
		File archivo2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(archivo2, new File(captura2));	Thread.sleep(secDelay);
		
		}
		
		//----------------------------------------210 IMPRIMIMOS EL REPORTE DE LAS DIFERENCIAS--------------------------------//
		
		WebElement Imprimir2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir2.click();		Thread.sleep(secDelay);
		WebElement DesplegarFormato1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato1.click();		Thread.sleep(secDelay);		
		List<WebElement> options16 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options16) {
            if (option.getText().equals("PDF")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);											
		WebElement Aceptar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1060")));
		Aceptar3.click();															
		WebElement Imprimir3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opcionImprimir")));
		Imprimir3.click();	Thread.sleep(secDelay);		
		WebElement DesplegarFormato3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formatoImprimir-trigger-picker")));
		DesplegarFormato3.click();	Thread.sleep(secDelay);		
		List<WebElement> options17 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options17) {
            if (option.getText().equals("XLSX")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);														
		WebElement Aceptar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1060")));
		Aceptar4.click();		Thread.sleep(secDelay);
		
		//--------------------------------------------------212 SALDAMOS LA DIFERENCIA-----------------------------------------//
		
		WebElement SeleccionarDiferencias = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias.click();										
		WebElement Saldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar")));
		Saldar.click();		Thread.sleep(secDelay);				
		WebElement DesplegarModalidad = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
		DesplegarModalidad.click();		Thread.sleep(secDelay);		
		List<WebElement> options18 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options18) {
            if (option.getText().equals("Cargo en Cuenta")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);													
		WebElement MontoSaldar = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
		MontoSaldar.sendKeys("500");					
		WebElement Descripción = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
		Descripción.sendKeys("Pago");					
		WebElement NroDeCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nCuentaCuen-inputEl")));
		NroDeCuenta.sendKeys("210802");					
		WebElement NombreDeLaCuenta = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombreCuentaCuen-inputEl")));
		NombreDeLaCuenta.sendKeys("Orion-5");			
		WebElement Incluir = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incluirRegularizacionCuen")));
		Incluir.click();		Thread.sleep(secDelay);										
		WebElement Aceptar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aceptarSald")));
		Aceptar1.click();		Thread.sleep(secDelay);
		
		WebElement Mensaje1 = driver.findElement(By.id("messagebox-1001-msg"));
        String ObtenerMensaje1 = Mensaje1.getText().trim();
        System.out.println(ObtenerMensaje1);    
        String ExpectativaTexto1 = "Registro creado exitosamente";
        	Assert.assertEquals(ObtenerMensaje1, ExpectativaTexto1);
		
        	File archivo4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(archivo4, new File(captura4));		Thread.sleep(secDelay);
		
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
		List<WebElement> options19 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options19) {
            if (option.getText().equals("Bóveda Disponible")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);									
		WebElement DesplegarDivisa2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		DesplegarDivisa2.click();	Thread.sleep(secDelay);
		List<WebElement> options20 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options20) {
            if (option.getText().equals(""+Constantes.DIVISA+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);											
		WebElement Consultar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
		Consultar2.click();		Thread.sleep(secDelay);		
		WebElement AjusteBóveda = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda")));
		AjusteBóveda.click();	Thread.sleep(secDelay);
		
		//---------------------------------------------------------FALTANTES.------------------------------------------------------//
		
		WebElement DesplegarDenominación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
		DesplegarDenominación.click();		Thread.sleep(secDelay);		
		List<WebElement> options21 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options21) {
            if (option.getText().equals(""+Constantes.DENOMINACION+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);									
		WebElement DesplegarClasificaión = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
		DesplegarClasificaión.click();		Thread.sleep(secDelay);	
		List<WebElement> options22 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options22) {
            if (option.getText().equals("Aptos")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);				
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
		List<WebElement> options23 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options23) {
            if (option.getText().equals("Pendiente")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);									
		WebElement DesplegarTipodeDiferencia2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
		DesplegarTipodeDiferencia2.click();		Thread.sleep(secDelay);
		List<WebElement> options24 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options24) {
            if (option.getText().equals("Faltante")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);						
		WebElement DesplegarDivisas2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
		DesplegarDivisas2.click();		Thread.sleep(secDelay);
		List<WebElement> options25 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options25) {
            if (option.getText().equals(""+Constantes.DIVISA+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);										
		WebElement DesplegarOrigen2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
		DesplegarOrigen2.click();		Thread.sleep(secDelay);
		List<WebElement> options26 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options26) {
            if (option.getText().equals("BOVEDA")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);											
		WebElement Consultar3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
		Consultar3.click();		Thread.sleep(secDelay);
		WebElement SeleccionarDiferencias1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias1.click();	
		
		//------------------------------------SALDAR DIFERERNCIAS CON LA MODALIDAD REPOSICIÓN DE EFECTIVO--------------------------//
		
		WebElement Saldar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar")));
		Saldar1.click();		Thread.sleep(secDelay);
		WebElement DesplegarModalidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
		DesplegarModalidad1.click();		Thread.sleep(secDelay);
		List<WebElement> options27 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options27) {
            if (option.getText().equals("Reposicion de Efectivo")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);
		WebElement MontoSaldar1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
		MontoSaldar1.sendKeys("500");
		WebElement Descripción1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
		Descripción1.sendKeys("Pago");
		WebElement DesplegarDenominación1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionEfec-trigger-picker")));
		DesplegarDenominación1.click();	
		List<WebElement> options28 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options28) {
            if (option.getText().equals(""+Constantes.DENOMINACION+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);		
		WebElement Cantidad1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadEfec-inputEl")));
		Cantidad1.sendKeys("5");
		WebElement DesplegarClasificación = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionEfec-trigger-picker")));
		DesplegarClasificación.click();		Thread.sleep(secDelay);
		List<WebElement> options29 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options29) {
            if (option.getText().equals("Aptos")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);
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
			FileUtils.copyFile(archivo5, new File(captura5));	Thread.sleep(secDelay);

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
		List<WebElement> options30 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options30) {
            if (option.getText().equals("Bóveda Disponible")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);									
		WebElement DesplegarDivisa1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moneda-trigger-picker")));
		DesplegarDivisa1.click();	Thread.sleep(secDelay);	
		List<WebElement> options31 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options31) {
            if (option.getText().equals(""+Constantes.DIVISA+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);													
		WebElement Consultar4 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buscarFiltro")));
		Consultar4.click();			Thread.sleep(secDelay);		
		WebElement AjusteBóveda1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajustarBoveda")));
		AjusteBóveda1.click();		Thread.sleep(secDelay);

		//-----------------------------------------------------------FALTANTES--------------------------------------------------//
		
		WebElement DesplegarDenominación2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denominacionFaltantesAjuste-trigger-picker")));
		DesplegarDenominación2.click();	Thread.sleep(secDelay);	
		List<WebElement> options32 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options32) {
            if (option.getText().equals(""+Constantes.DENOMINACION+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);										
		WebElement DesplegarClasificaión1 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clasificacionFaltantesAjuste-trigger-picker")));
		DesplegarClasificaión1.click();	Thread.sleep(secDelay);	
		List<WebElement> options33 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options33) {
            if (option.getText().equals("Aptos")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);									
		WebElement Cantidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cantidadFaltantesAjuste-inputEl")));
		Cantidad2.sendKeys("5");									
		WebElement Incluir3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1097")));
		Incluir3.click();	Thread.sleep(secDelay);
		WebElement Aceptar10 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1110")));
		Aceptar10.click();		Thread.sleep(secDelay);	
		
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
		List<WebElement> options34 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options34) {
            if (option.getText().equals("Pendiente")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);											
		WebElement DesplegarTipodeDiferencia3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estado-trigger-picker")));
		DesplegarTipodeDiferencia3.click();		Thread.sleep(secDelay);
		List<WebElement> options35 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options35) {
            if (option.getText().equals("Faltante")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);								
		WebElement DesplegarDivisas3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divisa-trigger-picker")));
		DesplegarDivisas3.click();		Thread.sleep(secDelay);
		List<WebElement> options36 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options36) {
            if (option.getText().equals(""+Constantes.DIVISA+"")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);														
		WebElement DesplegarOrigen3 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("origen-trigger-picker")));
		DesplegarOrigen3.click();	Thread.sleep(secDelay);		
		List<WebElement> options37 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options37) {
            if (option.getText().equals("BOVEDA")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);														
		WebElement Consultar5 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1041")));
		Consultar5.click();		Thread.sleep(secDelay);	
		WebElement SeleccionarDiferencias2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[data-columnid='gridcolumn-1025']")));
		SeleccionarDiferencias2.click();								
		
		//----------------------------------------------------SALDAR CON CHEQUE MISMO BANCO.-----------------------------------------//
		
		WebElement Saldar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saldar")));
		Saldar2.click();		Thread.sleep(secDelay);
		WebElement DesplegarModalidad2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalidadRegularizacion-trigger-picker")));
		DesplegarModalidad2.click();	Thread.sleep(secDelay);
		List<WebElement> options38 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options38) {
            if (option.getText().equals("Cheque mismo Banco")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);													
		WebElement MontoSaldar2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("montoSaldarRegularizacion-inputEl")));
		MontoSaldar2.sendKeys("500");						
		WebElement Descripción2 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("descripcionRegularizacion-inputEl")));
		Descripción2.sendKeys("Pago");				
		WebElement DesplegarBanco = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("banco-trigger-picker")));
		DesplegarBanco.click();			
		List<WebElement> options39 = driver.findElements(By.xpath("//ul[@class='x-list-plain']/li"));
        for (WebElement option : options39) {
            if (option.getText().equals("401 - Orion - 5")) {
                option.click();
                break;            
                }
            }		Thread.sleep(secDelay);					
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
			FileUtils.copyFile(archivo6, new File(captura6));	Thread.sleep(secDelay);

		WebElement Aceptar13 = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-1005-btnEl")));
		Aceptar13.click();		Thread.sleep(secDelay);
		}
	
		@After
		public void tearDown() throws Exception {
			
		//-------------------------------------------------------Cerrar el navegador---------------------------------------//
			
//		Thread.sleep(3000);
//		if (driver != null) {
//		    driver.quit();
//		}
		
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