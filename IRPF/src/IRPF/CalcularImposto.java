package IRPF;

public class CalcularImposto {
	private static float baseDeCalculo;
	
	private static final float RENDA_LIMITE_ANUAL_FAIXA_3 = 205.5667f;
	private static final float RENDA_LIMITE_ANUAL_FAIXA_2 = 138.6600f;
	private static final float RENDA_LIMITE_ANUAL_FAIXA_1 = 69.2003f;
	
	private static final float ALIQUOTA_27_5 = 0.275f;
	private static final float ALIQUOTA_22_5 = 0.225f;
	private static final float ALIQUOTA_15 = 0.15f;
	private static final float ALIQUOTA_75 = 0.075f;

	private static final float LIMITE_SUPERIOR_FAIXA1 = 1903.98f;
	private static final float LIMITE_SUPERIOR_FAIXA2 = 2826.65f;
	private static final float LIMITE_SUPERIOR_FAIXA3 = 3751.05f;
	private static final float LIMITE_SUPERIOR_FAIXA4 = 4664.68f;

	private static final float BASE_DE_CALCULO_FAIXA_4 = (baseDeCalculo - LIMITE_SUPERIOR_FAIXA4) * ALIQUOTA_27_5 + RENDA_LIMITE_ANUAL_FAIXA_1 + RENDA_LIMITE_ANUAL_FAIXA_2 + RENDA_LIMITE_ANUAL_FAIXA_3;
	private static final float BASE_DE_CALCULO_FAIXA_3 = (baseDeCalculo - LIMITE_SUPERIOR_FAIXA3) * ALIQUOTA_22_5 + RENDA_LIMITE_ANUAL_FAIXA_1 + RENDA_LIMITE_ANUAL_FAIXA_2;
	private static final float BASE_DE_CALCULO_FAIXA_2 = (baseDeCalculo - LIMITE_SUPERIOR_FAIXA2) * ALIQUOTA_15 + RENDA_LIMITE_ANUAL_FAIXA_1;
	private static final float BASE_DE_CALCULO_FAIXA_1 = (baseDeCalculo - LIMITE_SUPERIOR_FAIXA1) * ALIQUOTA_75; 
	
	private IRPF _irpf;

	CalcularImposto(IRPF source){
		_irpf = source;
		baseDeCalculo = _irpf.getBaseDoCalculo();
	}
	
	public float computar() {
		if (baseDeCalculo <= LIMITE_SUPERIOR_FAIXA1 ) {
			_irpf.totalImposto = 0;
			return _irpf.totalImposto;
		}
		else if (baseDeCalculo <= LIMITE_SUPERIOR_FAIXA2 ) {
			_irpf.totalImposto = BASE_DE_CALCULO_FAIXA_1;
			return _irpf.totalImposto;
		}
		else if (baseDeCalculo <= LIMITE_SUPERIOR_FAIXA3 ) {
			_irpf.totalImposto = BASE_DE_CALCULO_FAIXA_2;
			return _irpf.totalImposto;
		}
		else if (baseDeCalculo <= LIMITE_SUPERIOR_FAIXA4 ) {
			_irpf.totalImposto = BASE_DE_CALCULO_FAIXA_3;
			return _irpf.totalImposto;
		}
		else {
			_irpf.totalImposto = BASE_DE_CALCULO_FAIXA_4;
			return _irpf.totalImposto;
		}
	}
}
