package IRPF;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IRPFTeste {

	private IRPF irpf;
	
	@Before
	public void setup() {
		irpf = new IRPF();		
	}
	
	@Test
	public void testeCalculoDeducoes() {
		irpf.cadastrarDeducao("a", 0);
		irpf.cadastrarDeducao("a", 0);
		irpf.cadastrarDeducao("a", 0);
		irpf.cadastrarDeducao("a", 0);
		
		assertEquals(400f, irpf.getTotalDeducao(), 0f);
	}

	@Test
	public void testeBaseDeCalculo() {
		irpf.cadastrarRendimento("a", 0);
		irpf.cadastrarRendimento("a", 0);
		irpf.cadastrarRendimento("a", 0);
		irpf.cadastrarDeducao("a", 0);		
		irpf.calcularImposto();
		
		assertEquals(200f, irpf.getBaseDoCalculo(), 0f);
	}

	@Test
	public void testeFaixaImposto() {		
		assertEquals(1000f, irpf.calcularImposto(), 0f);
	}

	@Test
	public void testeAliquotaEfetiva() {
		assertEquals(2000f, irpf.calcularAliquota(), 0f);
		
	}

		

	
}
