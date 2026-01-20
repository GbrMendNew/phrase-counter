package com.example.core;

import java.text.Normalizer;

public class TextNormalizer {

  public static String normalize(String s) {
    if (s == null) return "";

    String lower = s.toLowerCase();

    String noAccents = Normalizer
        .normalize(lower, Normalizer.Form.NFD)
        .replaceAll("\\p{M}+", "");

    return noAccents
        .replaceAll("[^a-z0-9 ]", " ")
        .trim()
        .replaceAll("\\s+", " ");
  }
}
