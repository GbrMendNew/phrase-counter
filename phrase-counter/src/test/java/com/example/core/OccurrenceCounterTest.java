package com.example.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;



class OccurrenceCounterTest {

  @Test
  void shouldCountPhraseOccurrences_nonOverlapping() {
    String text = "bloques de piedra bloques de piedra x bloques de piedra";
    String phrase = "bloques de piedra";

    int count = OccurrenceCounter.countPhrase(text, phrase);

    assertEquals(3, count);
  }

  @Test
  void shouldReturnZeroWhenTextOrPhraseIsBlank() {
    assertEquals(0, OccurrenceCounter.countPhrase("", "abc"));
    assertEquals(0, OccurrenceCounter.countPhrase("abc", ""));
    assertEquals(0, OccurrenceCounter.countPhrase("   ", "abc"));
    assertEquals(0, OccurrenceCounter.countPhrase("abc", "   "));
  }

  @Test
  void shouldCountEachWordInPhrase() {
    String text = "bloques de piedra bloques bloques de";
    String phrase = "bloques de piedra";

    Map<String, Integer> counts = OccurrenceCounter.countWords(text, phrase);

    assertEquals(3, counts.get("bloques"));
    assertEquals(2, counts.get("de"));
    assertEquals(1, counts.get("piedra"));
}

}
