package com.example;

import com.example.core.PhraseAnalysisResult;
import com.example.core.PhraseAnalysisService;
import com.example.http.HttpContentFetcher;

import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {

    String url = System.getenv("URL");
    String phrase = System.getenv("PHRASE");

    // fallback local 
    if (url == null || url.isBlank() || phrase == null || phrase.isBlank()) {
      try (Scanner sc = new Scanner(System.in)) {
        System.out.print("URL: ");
        url = sc.nextLine().trim();

        System.out.print("Frase: ");
        phrase = sc.nextLine().trim();
      }
    }

    PhraseAnalysisService service = new PhraseAnalysisService(new HttpContentFetcher());
    PhraseAnalysisResult result = service.analyze(url, phrase);

    System.out.println();
    System.out.printf("\"%s\" => repete %d vezes%n", phrase, result.phraseCount());
    result.wordCounts().forEach((word, count) ->
        System.out.printf("\"%s\" => repete %d vezes%n", word, count)
    );
  }
}
