package com.example.core;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OccurrenceCounter {

  public static int countPhrase(String text, String phrase) {
    if (text == null || phrase == null) return 0;

    // Normaliza ambos para evitar perder ocorrências por acento, caixa, pontuação etc.
    String t = TextNormalizer.normalize(text);
    String p = TextNormalizer.normalize(phrase);

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

    // Normaliza a frase e mantém ordem das palavras
    String normPhrase = TextNormalizer.normalize(phrase);
    List<String> phraseWords = Tokenizer.tokenize(normPhrase);

    Map<String, Integer> result = new LinkedHashMap<>();
    for (String w : phraseWords) {
      result.put(w, 0);
    }

    if (text == null || text.isBlank()) return result;

    // Normaliza o texto antes de tokenizar
    String normText = TextNormalizer.normalize(text);

    for (String token : Tokenizer.tokenize(normText)) {
      if (result.containsKey(token)) {
        result.put(token, result.get(token) + 1);
      }
    }

    return result;
  }
}
