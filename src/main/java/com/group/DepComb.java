package com.group;

public class DepComb {
  public enum SITUACAO { NORMAL, SOBRAVISO, EMERGENCIA }
  public enum TIPOPOSTO { COMUM, ESTRATEGICO }

  public static final int MAX_ADITIVO = 500;
  public static final int MAX_ALCOOL = 2500;
  public static final int MAX_GASOLINA = 10000;

  public DepComb() {}

  public DepComb(int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {}

  public void defineSituacao() {}

  public SITUACAO getSituacao() {
    return SITUACAO.EMERGENCIA;
  }

  public int getGasolina() {
    return 0;
  }

  public int getAditivo() {
    return 0;
  }

  public int getAlcool1() {
    return 0;
  }

  public int getAlcool2() {
    return 0;
  }

  public int recebeAditivo(int qtdade) {
    return 0;
  }

  public int recebeGasolina(int qtdade) {
    return 0;
  }

  public int recebeAlcool(int qtdade) {
    return 0;
  }

  public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
    return null;
  }
}
