package Integrales_Diferencias;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class pruebas {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		int Monto = 4;
		double Monto_Inventario = Monto;
		double Diferencia = 1;
		
		String DiferenciaString = Double.toString(Diferencia);
		DiferenciaString = DiferenciaString.replace(".", "");

		
		
		System.out.print(DiferenciaString);
		
	}

}
