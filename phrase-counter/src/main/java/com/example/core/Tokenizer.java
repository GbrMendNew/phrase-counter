package com.example.core;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

  public static List<String> tokenize(String text) {
    if (text == null || text.isBlank()) return List.of();

    List<String> out = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);

      // pega TODOS os tipos de espaço
      if (Character.isWhitespace(c) || Character.isSpaceChar(c)) {
        if (sb.length() > 0) {
          out.add(sb.toString());
          sb.setLength(0);
        }
      } else {
        sb.append(c);
      }
    }

    if (sb.length() > 0) out.add(sb.toString());
    return out;
  }
}
