package com.group;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.group.DepComb.SITUACAO;
import com.group.DepComb.TIPOPOSTO;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DepCombTesteEstruturalTest {

  @ParameterizedTest
  @CsvSource({
    "0, 0, 500, 500, 10000, 1250, 1250",
    "0, 10, 249, 259, 10000, 1250, 1250",
    "0, 127, 124, 251, 10000, 1250, 1250"
  })
  public void testaEncomendaCombustivelPostoComumSituacaoFinalNormal(int quantidadeEncomendada, int quantidadeAditivo, int aditivoInicial,
      int resultadoAditivo, int resultadoGasolina, int resultadoAlcool1, int resultadoAlcool2) {
    int[] resultadoEsperado = {resultadoAditivo, resultadoGasolina, resultadoAlcool1, resultadoAlcool2};
    DepComb depComb = new DepComb(aditivoInicial, 10000, 1250, 1250);
    depComb.recebeAditivo(quantidadeAditivo);
    int[] res = depComb.encomendaCombustivel(quantidadeEncomendada, TIPOPOSTO.COMUM);
    SITUACAO situacao = depComb.getSituacao();
    assertEquals(SITUACAO.NORMAL, situacao);
    assertArrayEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "5020, 0, 500, 249, 6486, 622, 622",
    "2500, 0, 249, 186, 9125, 1093, 1093",
    "0, 10, 124, 134, 10000, 1250, 1250"
  })
  public void testaEncomendaCombustivelPostoComumSituacaoFinalSobraviso(int quantidadeEncomendada, int quantidadeAditivo, int aditivoInicial,
      int resultadoAditivo, int resultadoGasolina, int resultadoAlcool1, int resultadoAlcool2) {
    int[] resultadoEsperado = {resultadoAditivo, resultadoGasolina, resultadoAlcool1, resultadoAlcool2};
    DepComb depComb = new DepComb(aditivoInicial, 10000, 1250, 1250);
    depComb.recebeAditivo(quantidadeAditivo);
    int[] res = depComb.encomendaCombustivel(quantidadeEncomendada, TIPOPOSTO.COMUM);
    SITUACAO situacao = depComb.getSituacao();
    assertEquals(SITUACAO.SOBRAVISO, situacao);
    assertArrayEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "7520, 0, 500, 124, 4736, 310, 310",
    "3800, 0, 200, 105, 8670, 1012, 1012",
    "1000, 0, 123, -2, 0, 0, 0"
  })
  public void testaEncomendaCombustivelPostoComumSituacaoFinalEmergencia(int quantidadeEncomendada, int quantidadeAditivo, int aditivoInicial,
      int resultadoAditivo, int resultadoGasolina, int resultadoAlcool1, int resultadoAlcool2) {
    int[] resultadoEsperado = {resultadoAditivo, resultadoGasolina, resultadoAlcool1, resultadoAlcool2};
    DepComb depComb = new DepComb(aditivoInicial, 10000, 1250, 1250);
    depComb.recebeAditivo(quantidadeAditivo);
    int[] res = depComb.encomendaCombustivel(quantidadeEncomendada, TIPOPOSTO.COMUM);
    SITUACAO situacao = depComb.getSituacao();
    assertEquals(SITUACAO.EMERGENCIA, situacao);
    assertArrayEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "0, 0, 500, 500, 10000, 1250, 1250",
    "0, 10, 249, 259, 10000, 1250, 1250",
    "0, 127, 124, 251, 10000, 1250, 1250"
  })
  public void testaEncomendaCombustivelPostoEstrategicoSituacaoFinalNormal(int quantidadeEncomendada, int quantidadeAditivo, int aditivoInicial,
      int resultadoAditivo, int resultadoGasolina, int resultadoAlcool1, int resultadoAlcool2) {
    int[] resultadoEsperado = {resultadoAditivo, resultadoGasolina, resultadoAlcool1, resultadoAlcool2};
    DepComb depComb = new DepComb(aditivoInicial, 10000, 1250, 1250);
    depComb.recebeAditivo(quantidadeAditivo);
    int[] res = depComb.encomendaCombustivel(quantidadeEncomendada, TIPOPOSTO.ESTRATEGICO);
    SITUACAO situacao = depComb.getSituacao();
    assertEquals(SITUACAO.NORMAL, situacao);
    assertArrayEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "5020, 0, 500, 249, 6486, 622, 622",
    "2400, 0, 249, 129, 8320, 950, 950",
    "0, 10, 124, 134, 10000, 1250, 1250"
  })
  public void testaEncomendaCombustivelPostoEstrategicoSituacaoFinalSobraviso(int quantidadeEncomendada, int quantidadeAditivo, int aditivoInicial,
      int resultadoAditivo, int resultadoGasolina, int resultadoAlcool1, int resultadoAlcool2) {
    int[] resultadoEsperado = {resultadoAditivo, resultadoGasolina, resultadoAlcool1, resultadoAlcool2};
    DepComb depComb = new DepComb(aditivoInicial, 10000, 1250, 1250);
    depComb.recebeAditivo(quantidadeAditivo);
    int[] res = depComb.encomendaCombustivel(quantidadeEncomendada, TIPOPOSTO.ESTRATEGICO);
    SITUACAO situacao = depComb.getSituacao();
    assertEquals(SITUACAO.SOBRAVISO, situacao);
    assertArrayEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "7520, 0, 500, 124, 4736, 310, 310",
    "3800, 0, 249, 59, 7340, 775, 775",
    "2500, 0, 123, 123, 8250, 937, 937"
  })
  public void testaEncomendaCombustivelPostoEstrategicoSituacaoFinalEmergencia(int quantidadeEncomendada, int quantidadeAditivo, int aditivoInicial,
      int resultadoAditivo, int resultadoGasolina, int resultadoAlcool1, int resultadoAlcool2) {
    int[] resultadoEsperado = {resultadoAditivo, resultadoGasolina, resultadoAlcool1, resultadoAlcool2};
    DepComb depComb = new DepComb(aditivoInicial, 10000, 1250, 1250);
    depComb.recebeAditivo(quantidadeAditivo);
    int[] res = depComb.encomendaCombustivel(quantidadeEncomendada, TIPOPOSTO.ESTRATEGICO);
    SITUACAO situacao = depComb.getSituacao();
    assertEquals(SITUACAO.EMERGENCIA, situacao);
    assertArrayEquals(resultadoEsperado, res);
  }
}
