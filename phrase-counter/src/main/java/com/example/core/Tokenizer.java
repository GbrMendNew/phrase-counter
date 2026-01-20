package com.example.core;

import java.util.List;

public class Tokenizer {

  public static List<String> tokenize(String text) {
  if (text == null || text.isBlank()) {
    return List.of();
  }

  return List.of(text.trim().split("\\s+"));
}

}
