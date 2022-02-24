package IRPF;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import IRPFExceptions.DescricaoEmBrancoException;
import IRPFExceptions.ValorDeducaoInvalidoException;

@RunWith(Parameterized.class)
public class TesteDeducoes {
	private IRPF irpf;
	
	Object[][] contribuicoes;
	float valorEsperado;
	
	public TesteDeducoes(Object[][] contribuicoes, float valorEsperado) {
		this.contribuicoes = contribuicoes;
		this.valorEsperado = valorEsperado;
	}
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void cadastroContribuicoes() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		for (Object[] contribuicao : contribuicoes) {
			irpf.cadastrarDeducao((String)contribuicao[0], (float)contribuicao[1]);
		}
		
		assertEquals(valorEsperado, irpf.getTotalDeducao(), 0f);
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{new Object[][]{
				{"Ca", 1000f}
			}, 1000f},
			
			{new Object[][] { 
				{"ria", 800f}
			}, 800f},
			
			{new Object[][] { 
				{"oria", 1000f}, 
				{"CS", 800f}
			}, 1800f},
			
			{new Object[][] {
				{"ia", 1000f}, 
				{"Inss 1", 800f},
				{"Inss 2", 200f}
			}, 2000f}
		};
		
		return Arrays.asList(parametros);
	}
}
