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
	float totalImposto;
	
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
		throwExceptionForEmptyDescription(descricao);
		throwExceptionForInvalidValue(valor);
		rendimentos.add((float) valor);
		totalRendimentos += valor;
		return totalRendimentos;
	}

	private void throwExceptionForInvalidValue(float valor) throws ValorRendimentoInvalidoException {
		if(valor <= 0f) {
			throw new ValorRendimentoInvalidoException();
		}
	}

	private void throwExceptionForEmptyDescription(String descricao) throws DescricaoEmBrancoException {
		if(descricao == "") {
			throw new DescricaoEmBrancoException();
		}
	}
	
	public float cadastrarDeducao(String descricao, float valor) throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		throwExceptionForEmptyDescription(descricao);
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
		return  new CalcularImposto(this).computar();
	}

	public float calcularAliquota() {
		aliquotaEfetiva = totalImposto/totalRendimentos * 100;
		return Math.round(aliquotaEfetiva * 100f)/100f;
	}
	
	
}


