package com.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

  @Test
  public void testTest() {
    int result = depComb.getAditivo();
    assertEquals(0, result);
    assertNotNull(depComb);
  }
}
