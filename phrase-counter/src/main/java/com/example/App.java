package com.example;

import com.example.core.PhraseAnalysisResult;
import com.example.core.PhraseAnalysisService;
import com.example.http.HttpContentFetcher;

import java.util.Scanner;

public class App {

public static void main(String[] args) throws Exception {

  try (Scanner sc = new Scanner(System.in)) {

    System.out.print("URL: ");
    String url = sc.nextLine().trim();

    System.out.print("Frase: ");
    String phrase = sc.nextLine().trim();

    PhraseAnalysisService service =
        new PhraseAnalysisService(new HttpContentFetcher());

    PhraseAnalysisResult result = service.analyze(url, phrase);

    System.out.println();
    System.out.printf("\"%s\" => repete %d vezes%n",
        phrase, result.phraseCount());

    result.wordCounts().forEach((word, count) ->
        System.out.printf("\"%s\" => repete %d vezes%n", word, count)
    );
  }
}
}

