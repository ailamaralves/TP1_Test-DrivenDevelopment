package IRPF;

public class CalcularImposto {
	private float faixa1 = 1903.98f;
	private float faixa2 = 2826.65f;
	private float faixa3 = 3751.05f;
	private float faixa4 = 4664.68f;
	
	private IRPF _irpf;

	CalcularImposto(IRPF source){
		this._irpf = source;
	}
	
	public float computar() {
		if (_irpf.getBaseDoCalculo() <= faixa1 ) {
			_irpf.totalImposto = 0;
			return _irpf.totalImposto;
		}
		else if (_irpf.getBaseDoCalculo() <= faixa2 ) {
			_irpf.totalImposto = (_irpf.getBaseDoCalculo() - faixa1) * 0.075f;
			return _irpf.totalImposto;
		}
		else if (_irpf.getBaseDoCalculo() <= faixa3 ) {
			_irpf.totalImposto = (_irpf.getBaseDoCalculo() - faixa2) * 0.15f + 69.2003f;
			return _irpf.totalImposto;
		}
		else if (_irpf.getBaseDoCalculo() <= faixa4 ) {
			_irpf.totalImposto = (_irpf.getBaseDoCalculo() - faixa3) * 0.225f + 69.2003f + 138.6600f;
			return _irpf.totalImposto;
		}
		else {
			_irpf.totalImposto = (_irpf.getBaseDoCalculo() - faixa4) * 0.275f + 69.2003f + 138.6600f + 205.5667f;
			return _irpf.totalImposto;
		}
	}
}
