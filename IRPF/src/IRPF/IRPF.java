package IRPF;

import java.util.LinkedList;
import java.util.List;
import IRPFExceptions.*;

public class IRPF {
	

	private float totalRendimentos = 0;
	private float totalDeducoes = 0;

	private List<Float> rendimentos;
	private List<Float> deducoes;
	
	private float baseDoCalculo;
	private float totalImposto;
	
	private float aliquotaEfetiva;
	
	public float getBaseDoCalculo() {
		baseDoCalculo = totalRendimentos - totalDeducoes;
		return Math.round(baseDoCalculo * 100f)/100f;
	}

	public float getTotalImposto() {
		return Math.round(totalImposto * 100f)/100f;
	}

	public float getTotalDeducao() {
		return totalDeducoes;
	}

	public float getAliquotaEfetiva() {
		return aliquotaEfetiva;
	}

	public IRPF() {
		rendimentos = new LinkedList<Float>();
		deducoes = new LinkedList<Float>();
	}
	
	
	public float cadastrarRendimento(String descricao, float valor) throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		if(descricao == "") {
			throw new DescricaoEmBrancoException();
		}
		if(valor <= 0f) {
			throw new ValorRendimentoInvalidoException();
		}
		rendimentos.add((float) valor);
		totalRendimentos += valor;
		return totalRendimentos;
	}
	
	public float cadastrarDeducao(String descricao, float valor) throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		if(descricao == "") {
			throw new DescricaoEmBrancoException();
		}
		if(valor <= 0f) {
			throw new ValorDeducaoInvalidoException();
		}
		deducoes.add((float) valor);
		totalDeducoes += valor;
		
		return totalDeducoes;
	}
	
	public float cadastrarDenpedente(String nome, String dataNasc) throws NomeEmBrancoException {
		if(nome == "") {
			throw new NomeEmBrancoException();
		}
		totalDeducoes += 189.59;
		return totalDeducoes;
	}
	
	public float calcularImposto() {
		this.getBaseDoCalculo();
		float faixa1 = 1903.98f;
		float faixa2 = 2826.65f;
		float faixa3 = 3751.05f;
		float faixa4 = 4664.68f;
		
		if (baseDoCalculo <= faixa1 ) {
			totalImposto = 0;
			return totalImposto;
		}
		else if (baseDoCalculo <= faixa2 ) {
			totalImposto = (baseDoCalculo - faixa1) * 0.075f;
			return totalImposto;
		}
		else if (baseDoCalculo <= faixa3 ) {
			totalImposto = (baseDoCalculo - faixa2) * 0.15f + 69.2003f;
			return totalImposto;
		}
		else if (baseDoCalculo <= faixa4 ) {
			totalImposto = (baseDoCalculo - faixa3) * 0.225f + 69.2003f + 138.6600f;
			return totalImposto;
		}
		else {
			totalImposto = (baseDoCalculo - faixa4) * 0.275f + 69.2003f + 138.6600f + 205.5667f;
			return totalImposto;
		}
	}

	public float calcularAliquota() {
		aliquotaEfetiva = totalImposto/totalRendimentos * 100;
		return Math.round(aliquotaEfetiva * 100f)/100f;
	}
	
	
}

