package com.example.core;

import java.util.Map;

public record PhraseAnalysisResult(int phraseCount, Map<String, Integer> wordCounts) {}
