package com.example.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TokenizerTest {

  @Test
  void shouldSplitTextIntoWords() {
    String normalizedText = "bloques de piedra";

    List<String> words = Tokenizer.tokenize(normalizedText);

    assertEquals(3, words.size());
    assertEquals("bloques", words.get(0));
    assertEquals("de", words.get(1));
    assertEquals("piedra", words.get(2));
  }
  
  @Test
  void shouldIgnoreExtraSpaces() {
   String normalizedText = "  bloques   de   piedra  ";

   List<String> words = Tokenizer.tokenize(normalizedText);

   assertEquals(List.of("bloques", "de", "piedra"), words);
}

  
}
