package com.group;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.group.DepComb.SITUACAO;
import com.group.DepComb.TIPOPOSTO;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DepCombTesteEstruturalTest {

  @ParameterizedTest
  @CsvSource({
    "0, 500, 10000, 1250, 1250",
    "-10, -1, 0, 0, 0",
    "100, 495, 9930, 1237, 1237",
    "100000, -3, 0, 0, 0",
  })
  public void testaEncomendaCombustivelPostoComum(int quantidadeEncomendada, int resultadoAditivo,
      int resultadoGasolina, int resultadoAlcool1, int resultadoAlcool2) {
    int[] resultadoEsperado = {resultadoAditivo, resultadoGasolina, resultadoAlcool1, resultadoAlcool2};
    DepComb depComb = new DepComb(500, 10000, 1250, 1250);
    int[] res = depComb.encomendaCombustivel(quantidadeEncomendada, TIPOPOSTO.COMUM);
    /**
    SITUACAO situacao = depComb.getSituacao();
    assertEquals(SITUACAO.NORMAL, situacao); 
     */
    assertEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "0, 500, 10000, 1250, 1250",
    "-10, -1, 0, 0, 0",
    "100, 495, 9930, 1237, 1237",
    "100000, -3, 0, 0, 0",
  })
  public void testaEncomendaCombustivelPostoEstrategico(int quantidadeEncomendada, int resultadoAditivo,
      int resultadoGasolina, int resultadoAlcool1, int resultadoAlcool2) {
    int[] resultadoEsperado = {resultadoAditivo, resultadoGasolina, resultadoAlcool1, resultadoAlcool2};
    DepComb depComb = new DepComb(500, 10000, 1250, 1250);
    int[] res = depComb.encomendaCombustivel(quantidadeEncomendada, TIPOPOSTO.ESTRATEGICO);
    /**
    SITUACAO situacao = depComb.getSituacao();
    assertEquals(SITUACAO.NORMAL, situacao); 
     */
    assertEquals(resultadoEsperado, res);

  }
}
