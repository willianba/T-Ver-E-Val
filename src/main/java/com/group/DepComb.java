package com.group;

public class DepComb {
	public enum SITUACAO { NORMAL, SOBRAVISO, EMERGENCIA }
	public enum TIPOPOSTO { COMUM, ESTRATEGICO }
	
	public static final int MAX_ADITIVO = 500;
	public static final int MAX_ALCOOL = 2500;
	public static final int MAX_GASOLINA = 10000;
	
	private int tAditivo, tGasolina, tAlcool1, tAlcool2;
	private SITUACAO situacao;
	
	public DepComb() {
		this.tAditivo = this.tGasolina = this.tAlcool1 = this.tAlcool2 = 0;
		defineSituacao();
	}
	
	public DepComb(int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {
		this.tAditivo = tAditivo;
		this.tGasolina = tGasolina;
		this.tAlcool1 = tAlcool1;
		this.tAlcool2 = tAlcool2;
		defineSituacao();
	}
	
	public void defineSituacao() {
		if( tAditivo > 250 && tGasolina > 5000 && tAlcool1 > 625 && tAlcool2 > 625) {
			situacao = SITUACAO.NORMAL;
		} else if (tAditivo < 125 || tGasolina < 2500 || tAlcool1 < 313 || tAlcool2 < 313) {
			situacao = SITUACAO.EMERGENCIA;
		} else {
			situacao = SITUACAO.SOBRAVISO;
		}
	}
	
	public SITUACAO getSituacao() {
		return this.situacao;
	}
	
	public int getGasolina() {
		return this.tGasolina;
	}
	
	public int getAditivo() {
		return this.tAditivo;
	}
	
	public int getAlcool1() {
		return this.tAlcool1;
	}
	
	public int getAlcool2() {
		return this.tAlcool2;
	}
	
	public int recebeAditivo(int qtdade) {
		if (qtdade < 0) {
			return -1; 
		} else {
			if (tAditivo + qtdade < MAX_ADITIVO ) {
				tAditivo = (tAditivo + qtdade);
				defineSituacao();
				return qtdade;
			} else {
				int retorno = tAditivo + qtdade - MAX_ADITIVO;
				tAditivo = MAX_ADITIVO;
				defineSituacao();
				return retorno;
			}
		}
	}
	
	public int recebeGasolina(int qtdade) {
		if (qtdade < 0) {
			return -1; 
		} else {
			if (tGasolina + qtdade < MAX_GASOLINA ) {
				tGasolina = (tGasolina + qtdade);
				defineSituacao();
				return qtdade;
			} else {
				int retorno = tGasolina + qtdade - MAX_GASOLINA;
				tGasolina = MAX_GASOLINA;
				defineSituacao();
				return retorno;
			}
		}
	}
	
	public int recebeAlcool(int qtdade) {
		if (qtdade < 0) {
			return -1; 
		} else {
			int montanteAlcool = qtdade + tAlcool1 + tAlcool2;
			if (montanteAlcool < MAX_ALCOOL ) {
				if((montanteAlcool) % 2 == 0) {
					tAlcool1 = tAlcool2 = montanteAlcool / 2;
				} else {
					tAlcool1 = (montanteAlcool - 1) / 2;
					tAlcool2 = (montanteAlcool + 1) / 2;
				}
				defineSituacao();
				return qtdade;
			} else {
				int retorno = montanteAlcool - MAX_ALCOOL;
				tAlcool1 = tAlcool2 = MAX_ALCOOL / 2;
				defineSituacao();
				return retorno;
			}
		}
	}

	public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
		if (qtdade < 0) { 
			int[] arranjo = {-1,0,0,0}; 
			return arranjo;
		}
		if (situacao == SITUACAO.NORMAL){
			if (tAditivo - (qtdade * 0.05) < 0 || tGasolina - (qtdade * 0.7) < 0 || tAlcool1 + tAlcool2 - (qtdade * 0.25) < 0) {
				int[] arranjo =  {-3,0,0,0};			
				return arranjo;
			}
			tAditivo = round(tAditivo - (qtdade * 0.05));
			tGasolina = round(tGasolina - (qtdade * 0.7));
			int montanteAlcool = round(tAlcool1 + tAlcool2 - (qtdade * 0.25));
			if(montanteAlcool % 2 == 0){
				tAlcool1 = tAlcool2 = montanteAlcool / 2;
			} else {
				tAlcool1 = (montanteAlcool - 1) / 2;
				tAlcool2 = (montanteAlcool + 1) / 2;
			}
		} else if (situacao == SITUACAO.SOBRAVISO) {
			if(tipoPosto == TIPOPOSTO.COMUM) { 
				qtdade = qtdade / 2;		
			}
			if (tAditivo - (qtdade * 0.05) < 0 || tGasolina - (qtdade * 0.7) < 0 || tAlcool1 + tAlcool2 - (qtdade * 0.25) < 0) {
				int[] arranjo =  {-3,0,0,0};			
				return arranjo;
			}
			tAditivo = round(tAditivo - (qtdade * 0.05));
			tGasolina = round(tGasolina - (qtdade * 0.7));
			int montanteAlcool = round(tAlcool1 + tAlcool2 - (qtdade * 0.25));
		} else {
			if(TIPOPOSTO.COMUM){
				int[] arranjo = {-2,0,0,0};
				return arranjo;
			} else if (tGasolina - (qtdade * 0.7) < 0 || tAlcool1 + tAlcool2 - (qtdade * 0.25) < 0) {
				int[] arranjo =  {-3,0,0,0};			
				return arranjo;
			} else if (tAditivo > qtdade * 0.05) {
				tAditivo = round(tAditivo - (qtdade * 0.05));
			} else {
				tGasolina = round(tGasolina - (qtdade * 0.7));
				int montanteAlcool = round(tAlcool1 + tAlcool2 - (qtdade * 0.25));
				if(montanteAlcool % 2 == 0){
					tAlcool1 = tAlcool2 = montanteAlcool / 2;
				} else {
					tAlcool1 = (montanteAlcool - 1) / 2;
					tAlcool2 = (montanteAlcool + 1) / 2;
				}
			}
		}
		defineSituacao();
		int[] arranjo = {tAditivo, tGasolina, tAlcool1, tAlcool2};
		return arranjo;
	}

}
