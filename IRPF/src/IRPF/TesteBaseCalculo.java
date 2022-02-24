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
import IRPFExceptions.NomeEmBrancoException;
import IRPFExceptions.ValorDeducaoInvalidoException;
import IRPFExceptions.ValorRendimentoInvalidoException;

@RunWith(Parameterized.class)
public class TesteBaseCalculo {
	private IRPF irpf;
	
	Object[][] rendimentos;
	Object[][] deducoes;
	Object[][] dependentes;
	float valorEsperado;
	
	public TesteBaseCalculo(Object[][] rendimentos, Object[][] deducoes, Object[][] dependentes, float valorEsperado) {
		this.rendimentos = rendimentos;
		this.deducoes = deducoes;
		this.dependentes = dependentes;
		this.valorEsperado = valorEsperado;
	}
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void testeBaseDeCalculo() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException, NomeEmBrancoException, ValorDeducaoInvalidoException {
		for (Object[] rendimento : rendimentos) {
			irpf.cadastrarRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		
		for (Object[] deducao : deducoes) {
			irpf.cadastrarDeducao((String)deducao[0], (float)deducao[1]);
		}
		
		for (Object[] dependente : dependentes) {
			irpf.cadastrarDenpedente((String)dependente[0], (String)dependente[1]);
		}
		
		assertEquals(valorEsperado, irpf.getBaseDoCalculo(), 0f);
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{new Object[][]{
					{"a", 100f},
					{"a", 100f},
					{"a", 100f},
			}, 
			new Object[][]{
				{"a", 100f},
			}, 
			new Object[][]{}, 200f},
			
			{new Object[][]{
				{"a", 100f},
				{"a", 100f},
				{"a", 300f},
			}, 
			new Object[][]{
				{"a", 200f},
			}, 
			new Object[][]{
				{"mateus", "01/01/2001"}
			}, 110.41f},
			
			{new Object[][]{
				{"a", 1000f},
				{"a", 100f},
				{"a", 300f},
			}, 
			new Object[][]{
				{"a", 200f},
				{"a", 300f},
			}, 
			new Object[][]{
				{"mateus", "01/01/2001"},
				{"aquiles", "01/01/2002"},
				{"aila", "01/01/2003"},
			}, 331.23f},
		};
		
		return Arrays.asList(parametros);
	}
}
