package com.example.core;

import com.example.html.HtmlTextExtractor;
import com.example.http.ContentFetcher;

import java.util.Map;

public class PhraseAnalysisService {

  private final ContentFetcher fetcher;

  public PhraseAnalysisService(ContentFetcher fetcher) {
    this.fetcher = fetcher;
  }

  public PhraseAnalysisResult analyze(String url, String phrase) throws Exception {
    String html = fetcher.fetch(url);
    String rawText = HtmlTextExtractor.extractText(html);

    String normalizedText = TextNormalizer.normalize(rawText);
    String normalizedPhrase = TextNormalizer.normalize(phrase);

    int phraseCount = OccurrenceCounter.countPhrase(normalizedText, normalizedPhrase);
    Map<String, Integer> wordCounts = OccurrenceCounter.countWords(normalizedText, normalizedPhrase);

    return new PhraseAnalysisResult(phraseCount, wordCounts);
  }
}
