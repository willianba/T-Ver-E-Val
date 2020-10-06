package com.group;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.group.DepComb.TIPOPOSTO;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DepCombTesteValorLimiteTest {

  @ParameterizedTest
  @CsvSource({
    "150, 500, 350",
    "380, 500, 120",
    "492, 500, 8",
    "150, 600, 350",
    "380, 600, 120",
    "492, 600, 8",
    "150, 250, 250",
    "380, 250, 120",
    "492, 250, 8"
  })
  public void testaRecebeAditivo(int quantidadeNoTanque, int quantidadeAditivo, int resultadoEsperado) {
    DepComb depComb = new DepComb(quantidadeNoTanque, 0, 0, 0);
    int res = depComb.recebeAditivo(quantidadeAditivo);
    assertEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "2000, 10000, 8000",
    "8000, 10000, 2000",
    "9850, 10000, 150",
    "2000, 10100, 8000",
    "8000, 10100, 2000",
    "9850, 10100, 150",
    "2000, 250, 250",
    "8000, 250, 250",
    "9850, 250, 150"
  })
  public void testaRecebeGasolina(int quantidadeNoTanque, int quantidadeGasolina, int resultadoEsperado) {
    DepComb depComb = new DepComb(0, quantidadeNoTanque, 0, 0);
    int res = depComb.recebeGasolina(quantidadeGasolina);
    assertEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "0, 0, 2500, 2500",
    "1000, 1000, 2500, 500",
    "1250, 1250, 2500, 0",
    "0, 0, 2600, 2500",
    "1000, 1000, 2600, 500",
    "1250, 1250, 2600, 0",
    "0, 0, 250, 250",
    "1000, 1000, 250, 250",
    "1250, 1250, 250, 0"
  })
  public void testaRecebeAlcool(int quantidadeNoTanque1, int quantidadeNoTanque2, int quantidadeAlcool, int resultadoEsperado) {
    DepComb depComb = new DepComb(0, 0, quantidadeNoTanque1, quantidadeNoTanque2);
    int res = depComb.recebeAlcool(quantidadeAlcool);
    assertEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "10000, 0, 3000, 0, 0"
  })
  public void testaEncomendaCombustivelPostoComum(int quantidadeEncomendada, int resultadoAditivo,
      int resultadoGasolina, int resultadoAlcool1, int resultadoAlcool2) {
    int[] resultadoEsperado = {resultadoAditivo, resultadoGasolina, resultadoAlcool1, resultadoAlcool2};
    DepComb depComb = new DepComb(500, 10000, 1250, 1250);
    int[] res = depComb.encomendaCombustivel(quantidadeEncomendada, TIPOPOSTO.COMUM);
    assertArrayEquals(resultadoEsperado, res);
  }

  @ParameterizedTest
  @CsvSource({
    "10000, 0, 3000, 0, 0"
  })
  public void testaEncomendaCombustivelPostoEstrategico(int quantidadeEncomendada, int resultadoAditivo,
      int resultadoGasolina, int resultadoAlcool1, int resultadoAlcool2) {
    int[] resultadoEsperado = {resultadoAditivo, resultadoGasolina, resultadoAlcool1, resultadoAlcool2};
    DepComb depComb = new DepComb(500, 10000, 1250, 1250);
    int[] res = depComb.encomendaCombustivel(quantidadeEncomendada, TIPOPOSTO.ESTRATEGICO);
    assertArrayEquals(resultadoEsperado, res);
  }
}
