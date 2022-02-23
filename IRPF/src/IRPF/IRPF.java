package IRPF;

import java.util.LinkedList;
import java.util.List;

public class IRPF {
	

	private float totalRendimentos = 0;
	private float totalDeducoes = 0;
	private List<Float> rendimentos;
	private List<Float> deducoes;
	
	private float baseDoCalculo;
	private float[] imposto;
	
	private float aliquotaEfetiva;
	
	public float getBaseDoCalculo() {
		return baseDoCalculo;
	}

	public float getImposto() {
		return imposto[0];
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
	
	
	public float cadastrarRendimento(String descricao, float valor) {
		rendimentos.add((float) 100);
		totalRendimentos += 100;
		return totalRendimentos;
	}
	
	public float cadastrarDeducao(String descricao, float valor) {
		deducoes.add((float) 100);
		totalDeducoes += 100;
		
		return totalDeducoes;
	}
	
	public float calcularImposto() {
		baseDoCalculo = totalRendimentos - totalDeducoes;
		
		
		return 1000;
	}

	public float calcularAliquota() {
		
		
		return 2000;
	}
	
	
}

