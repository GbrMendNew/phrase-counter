package com.example.core;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OccurrenceCounter {

  public static int countPhrase(String text, String phrase) {
    if (text == null || phrase == null) return 0;

    String t = text.trim();
    String p = phrase.trim();

    if (t.isBlank() || p.isBlank()) return 0;

    int count = 0;
    int idx = 0;

    while (true) {
      int found = t.indexOf(p, idx);
      if (found < 0) break;

      count++;
      idx = found + p.length();
    }

    return count;
  }

  public static Map<String, Integer> countWords(String text, String phrase) {
    if (phrase == null) return Map.of();

    // palavras da frase (mantém ordem)
    List<String> phraseWords = Tokenizer.tokenize(phrase);

    Map<String, Integer> result = new LinkedHashMap<>();
    for (String w : phraseWords) {
      result.put(w, 0);
    }

    if (text == null || text.isBlank()) return result;

    for (String token : Tokenizer.tokenize(text)) {
      if (result.containsKey(token)) {
        result.put(token, result.get(token) + 1);
      }
    }

    return result;
  }
}
