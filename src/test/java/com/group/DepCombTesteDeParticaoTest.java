package com.group;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.group.DepComb.TIPOPOSTO;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DepCombTesteDeParticaoTest {

  @ParameterizedTest
  @CsvSource({
    "0, 0, -1",
    "200, 0, -1",
    "500, 0, -1",
    "0, -10, -1",
    "200,-10, -1",
    "500, -10, -1",
    "0, 350, 350",
    "200, 350, 300",
    "500, 350, 0"
  })
  public void testaRecebeAditivo(int quantidadeNoTanque, int quantidadeAditivo, int resultadoEsperado) {
    DepComb depComb = new DepComb(quantidadeNoTanque, 0, 0, 0);
    int res = depComb.recebeAditivo(quantidadeAditivo);
    assertEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "0, 0, -1",
    "5000, 0, -1",
    "10000, 0, -1",
    "0, -10, -1",
    "5000,-10, -1",
    "10000, -10, -1",
    "0, 7500, 7500",
    "5000, 7500, 5000",
    "10000, 7500, 0"
  })
  public void testaRecebeGasolina(int quantidadeNoTanque, int quantidadeGasolina, int resultadoEsperado) {
    DepComb depComb = new DepComb(0, quantidadeNoTanque, 0, 0);
    int res = depComb.recebeGasolina(quantidadeGasolina);
    assertEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "0, 0, 0, -1",
    "1000, 1000, 0, -1",
    "1250, 1250, 0, -1",
    "0, 0, -10, -1",
    "1000, 1000, -10, -1",
    "1250, 1250, -10, -1",
    "0, 0, 1500, 1500",
    "1000, 1000, 1500, 500",
    "1250, 1250, 1500, 0"
  })
  public void testaRecebeAlcool(int quantidadeNoTanque1, int quantidadeNoTanque2, int quantidadeAlcool, int resultadoEsperado) {
    DepComb depComb = new DepComb(0, 0, quantidadeNoTanque1, quantidadeNoTanque2);
    int res = depComb.recebeAlcool(quantidadeAlcool);
    assertEquals(resultadoEsperado, res);
  }

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
    assertEquals(resultadoEsperado, res);
  }
}
