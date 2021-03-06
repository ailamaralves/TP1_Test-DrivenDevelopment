package IRPF;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import IRPFExceptions.DescricaoEmBrancoException;
import IRPFExceptions.NomeEmBrancoException;
import IRPFExceptions.ValorDeducaoInvalidoException;
import IRPFExceptions.ValorRendimentoInvalidoException;

public class IRPFTeste {

	private IRPF irpf;
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
//	@Test
//	public void testeCalculoDeducoes() {
//		try {
//			irpf.cadastrarDeducao("a", 100);
//			irpf.cadastrarDeducao("a", 100);
//			irpf.cadastrarDeducao("a", 100);
//			irpf.cadastrarDeducao("a", 100);
//		}
//		catch(Exception e) {
//			fail(e.toString());
//		}
//		assertEquals(400f, irpf.getTotalDeducao(), 0f);
//	}
//
//	@Test
//	public void testeOutraCalculoDeducoes() {
//		try {
//			irpf.cadastrarDeducao("a", 100);
//			irpf.cadastrarDeducao("a", 100);
//			irpf.cadastrarDeducao("a", 100);
//			irpf.cadastrarDeducao("a", 100);
//			irpf.cadastrarDeducao("a", 50);
//		}
//		catch(Exception e) {
//			fail(e.toString());
//		}
//		assertEquals(450f, irpf.getTotalDeducao(), 0f);
//	}
//
//
//	@Test
//	public void testeBaseDeCalculo() {
//		try {
//			irpf.cadastrarRendimento("a", 100);
//			irpf.cadastrarRendimento("a", 100);
//			irpf.cadastrarRendimento("a", 100);
//			irpf.cadastrarDeducao("a", 100);		
//		}
//		catch(Exception e) {
//			fail(e.toString());
//		}
//		assertEquals(200f, irpf.getBaseDoCalculo(), 0f);
//	}
//
//	@Test
//	public void testeOutraBaseDeCalculo() {
//		try {
//			irpf.cadastrarRendimento("a", 100);
//			irpf.cadastrarRendimento("a", 100);
//			irpf.cadastrarRendimento("a", 300);
//			irpf.cadastrarDenpedente("mateus", "1/1/2001");
//			irpf.cadastrarDeducao("a", 200);
//		}
//		catch(Exception e) {
//			fail(e.toString());
//		}
//		
//		assertEquals(110.41f, irpf.getBaseDoCalculo(), 0f);
//	}
//	
//	@Test
//	public void testeCalculoImposto() {
//		try {
//			irpf.cadastrarRendimento("a", 100);
//			irpf.cadastrarRendimento("a", 100);
//			irpf.cadastrarRendimento("a", 300);
//			irpf.cadastrarDenpedente("mateus", "1/1/2001");
//			irpf.cadastrarDeducao("a", 200);
//		}
//		catch(Exception e) {
//			fail(e.toString());
//		}
//		
//		irpf.calcularImposto();
//		assertEquals(0f, irpf.getTotalImposto(), 0f);
//	}
//	
//	@Test
//	public void testeOutroCalculoImposto() {
//		try {
//			irpf.cadastrarRendimento("a", 10000);
//		}
//		catch(Exception e) {
//			fail(e.toString());
//		}
//		irpf.calcularImposto();
//		assertEquals(1880.64f, irpf.getTotalImposto(), 0f);
//	}
//		
//	@Test
//	public void testeAliquotaEfetiva() {
//		try {
//			irpf.cadastrarRendimento("a", 10000);
//		}
//		catch(Exception e) {
//			fail(e.toString());
//		}
//		irpf.calcularImposto();
//		assertEquals(18.8064f, irpf.calcularAliquota(), 0f);
//	}
//	
//	@Test
//	public void testeOutraAliquotaEfetiva() {
//		try {
//			irpf.cadastrarRendimento("a", 3000);
//		}
//		catch(Exception e) {
//			fail(e.toString());
//		}
//		irpf.calcularImposto();
//		assertEquals(3.17f, (float)  Math.round(irpf.calcularAliquota() * 100f)/100, 0f);
//	}
	
	@Test(expected = DescricaoEmBrancoException.class)
	public void testeCadastroRendimentoDescricaoBranco() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		irpf.cadastrarRendimento("", 3000);
	}
	
	@Test(expected = ValorRendimentoInvalidoException.class)
	public void testeCadastroRendimentoValorRendimentoInvalido() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		irpf.cadastrarRendimento("salario", -1);
	}
	
	@Test(expected = DescricaoEmBrancoException.class)
	public void testeCadastroDeducaoDescricaoBranco() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		irpf.cadastrarDeducao("", 3000);
	}
	
	@Test(expected = ValorDeducaoInvalidoException.class)
	public void testeCadastroDeducaoValorRendimentoInvalido() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		irpf.cadastrarDeducao("salario", -1);
	}
	
	@Test(expected = NomeEmBrancoException.class)
	public void testeCadastroDependenteNomeBranco() throws NomeEmBrancoException {
		irpf.cadastrarDenpedente("", "1/1/2001");
	}
}
