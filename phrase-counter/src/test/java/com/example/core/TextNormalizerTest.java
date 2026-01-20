package com.example.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextNormalizerTest {

  @Test
  void shouldNormalizeText() {
    String input = "  PíRÂmIdes de EGITO!! ";
    String result = TextNormalizer.normalize(input);

    assertEquals("piramides de egito", result);
  }
}
