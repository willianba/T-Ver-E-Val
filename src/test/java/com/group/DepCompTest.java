package com.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.group.DepComb.TIPOPOSTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_METHOD)
public class DepCompTest {
  private DepComb depComb;

  @BeforeEach
  public void setup() {
    depComb = new DepComb();
  }

  //TESTES DE PARTIÇÃO
  @Test
  public void recebeAditivoZero() {
    int res = depComb.recebeAditivo(0);
    assertEquals(-1, res);
  }

  @Test
  public void recebeAditivoNegativo() {
    int res = depComb.recebeAditivo(-1);
    assertEquals(-1, res);
  }

  @Test
  public void recebeAditivoPositivo() {
    int res = depComb.recebeAditivo(10);
    assertEquals(10, res);
  }

  @Test
  public void recebeGasolinaZerada() {
    int res = depComb.recebeGasolina(0);
    assertEquals(-1, res);
  }
  
  @Test
  public void recebeGasolinaNegativa() {
    int res = depComb.recebeGasolina(-1);
    assertEquals(-1, res);
  }
  
  @Test
  public void recebeGasolinaPositiva() {
    int res = depComb.recebeGasolina(10);
    assertEquals(10, res);
  }

  @Test
  public void recebeAlcoolZerado() {
    int res = depComb.recebeAlcool(0);
    assertEquals(-1, res);
  }

  @Test
  public void recebeAlcoolNegativo() {
    int res = depComb.recebeAlcool(-1);
    assertEquals(-1, res);
  }

  @Test
  public void recebeAlcoolPositivo() {
    int res = depComb.recebeAlcool(10);
    assertEquals(10, res);
  }

  @Test
  public void encomendaCombustivelComumZerado() {
    int[] res = depComb.encomendaCombustivel(0, TIPOPOSTO.COMUM);
    int[] exp = {500, 10000, 1250, 1250};
    assertEquals(exp, res);
  }

  @Test
  public void encomendaCombustivelComumNegativo() {
    int[] res = depComb.encomendaCombustivel(-10, TIPOPOSTO.COMUM);
    int[] exp = {-1};
    assertEquals(exp, res);
  }

  @Test
  public void encomendaCombustivelComumPositivo() {
    int[] res = depComb.encomendaCombustivel(100, TIPOPOSTO.COMUM);
    double[] exp = {495, 9930, 1237.5, 1237.5};
    assertEquals(exp, res);
  }

  @Test
  public void encomendaCombustivelComumPositivoGrande() {
    int[] res = depComb.encomendaCombustivel(100000, TIPOPOSTO.COMUM);
    double[] exp = {-3};
    assertEquals(exp, res);
  }

  @Test
  public void encomendaCombustivelEstrategicoZerado() {
    int[] res = depComb.encomendaCombustivel(0, TIPOPOSTO.ESTRATEGICO);
    int[] exp = {500, 10000, 1250, 1250};
    assertEquals(exp, res);
  }

  @Test
  public void encomendaCombustivelEstrategicoNegativo() {
    int[] res = depComb.encomendaCombustivel(-10, TIPOPOSTO.ESTRATEGICO);
    int[] exp = {-1};
    assertEquals(exp, res);
  }

  @Test
  public void encomendaCombustivelEstrategicoPositivo() {
    int[] res = depComb.encomendaCombustivel(100, TIPOPOSTO.ESTRATEGICO);
    double[] exp = {495, 9930, 1237.5, 1237.5};
    assertEquals(exp, res);
  }

  @Test
  public void encomendaCombustivelEstrategicoPositivoGrande() {
    int[] res = depComb.encomendaCombustivel(100000, TIPOPOSTO.ESTRATEGICO);
    double[] exp = {-3};
    assertEquals(exp, res);
  }

  //TESTES DE VALOR LIMITE
  @Test
  public void recebeAditivoLimiteTanque() {
    int res = depComb.recebeAditivo(500);
    assertEquals(500, res);
  }

  @Test
  public void recebeAditivoLimiteTanqueAcima() {
    int res = depComb.recebeAditivo(600);
    assertEquals(-1, res);
  }

  @Test
  public void recebeAditivoLimiteTanqueAbaixo() {
    int res = depComb.recebeAditivo(250);
    assertEquals(250, res);
  }

  @Test
  public void recebeGasolinaLimiteTanque() {
    int res = depComb.recebeGasolina(2500);
    assertEquals(2500, res);
  }

  @Test
  public void recebeGasolinaLimiteTanqueAcima() {
    int res = depComb.recebeGasolina(2600);
    assertEquals(-1, res);
  }

  @Test
  public void recebeGasolinaLimiteTanqueAbaixo() {
    int res = depComb.recebeGasolina(250);
    assertEquals(250, res);
  }

  @Test
  public void recebeAlcoolLimiteTanque() {
    int res = depComb.recebeAlcool(10000);
    assertEquals(10000, res);
  }

  @Test
  public void recebeAlcoolLimiteTanqueAcima() {
    int res = depComb.recebeAlcool(10100);
    assertEquals(-1, res);
  }

  @Test
  public void recebeAlcoolLimiteTanqueAbaixo() {
    int res = depComb.recebeAlcool(250);
    assertEquals(250, res);
  }

  @Test
  public void encomendaCombustivelLimiteTanqueComum() {
    int[] res = depComb.encomendaCombustivel(10000, TIPOPOSTO.COMUM);
    int[] exp = {0, 300, 0, 0};
    assertEquals(exp, res);
  }

  @Test
  public void encomendaCombustivelLimiteTanqueComumAcima() {
    int[] res = depComb.encomendaCombustivel(1000000, TIPOPOSTO.COMUM);
    int[] exp = {-3};
    assertEquals(exp, res);
  }

  @Test
  public void encomendaCombustivelLimiteTanqueEstrategico() {
    int[] res = depComb.encomendaCombustivel(1000000, TIPOPOSTO.ESTRATEGICO);
    int[] exp = {0, 300, 0, 0};
    assertEquals(exp, res);
  }

  @Test
  public void encomendaCombustivelLimiteTanqueEstrategicoAcima() {
    int[] res = depComb.encomendaCombustivel(1000000, TIPOPOSTO.ESTRATEGICO);
    int[] exp = {-3};
    assertEquals(exp, res);
  }

}
