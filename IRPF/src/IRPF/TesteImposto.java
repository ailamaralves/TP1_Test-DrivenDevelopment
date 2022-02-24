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
public class TesteImposto {
	private IRPF irpf;
	
	Object[][] rendimentos;
	Object[][] deducoes;
	Object[][] dependentes;
	float valorEsperado;
	
	public TesteImposto(Object[][] rendimentos, Object[][] deducoes, Object[][] dependentes, float valorEsperado) {
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
	public void testeImposto() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException, NomeEmBrancoException, ValorDeducaoInvalidoException {
		for (Object[] rendimento : rendimentos) {
			irpf.cadastrarRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		
		for (Object[] deducao : deducoes) {
			irpf.cadastrarDeducao((String)deducao[0], (float)deducao[1]);
		}
		
		for (Object[] dependente : dependentes) {
			irpf.cadastrarDenpedente((String)dependente[0], (String)dependente[1]);
		}
		
		irpf.calcularImposto();
		
		assertEquals(valorEsperado, irpf.getTotalImposto(), 0f);
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{new Object[][]{
				{"a", 10000f},
			}, 
			new Object[][]{}, 
			new Object[][]{}, 1880.64f},
			
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
			}, 0f},
			
			{new Object[][]{
				{"a", 7500f},
			}, 
			new Object[][]{
				{"a", 500f},
			}, 
			new Object[][]{
				{"mateus", "01/01/2001"},
				{"mateus", "01/01/2001"},
				{"mateus", "01/01/2001"},
			}, 899.23f},
		};
		
		return Arrays.asList(parametros);
	}
}
