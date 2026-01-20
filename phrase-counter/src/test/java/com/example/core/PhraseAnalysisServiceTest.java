package com.example.core;

import com.example.http.ContentFetcher;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class PhraseAnalysisServiceTest {

  @Test
  void shouldAnalyzeTextFromFetcher_andCountPhraseAndWords() throws Exception {
    // fake fetcher: não usa internet
    ContentFetcher fakeFetcher = url -> "<html><body>Bloques de piedra. Bloques de piedra!</body></html>";

    PhraseAnalysisService service = new PhraseAnalysisService(fakeFetcher);

    PhraseAnalysisResult result = service.analyze("http://fake", "bloques de piedra");

    assertEquals(2, result.phraseCount());
    assertEquals(2, result.wordCounts().get("bloques"));
    assertEquals(2, result.wordCounts().get("de"));
    assertEquals(2, result.wordCounts().get("piedra"));
  }
}
