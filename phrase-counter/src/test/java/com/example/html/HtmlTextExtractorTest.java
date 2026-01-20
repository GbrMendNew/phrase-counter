package com.example.html;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class HtmlTextExtractorTest {

  @Test
  void shouldExtractVisibleTextFromHtml() {
    String html = "<html><body><h1>Titulo</h1><p>Olá <b>Mundo</b></p></body></html>";

    String text = HtmlTextExtractor.extractText(html);

    assertTrue(text.contains("Titulo"));
    assertTrue(text.contains("Olá Mundo"));
  }

  @Test
  void shouldReturnEmptyStringWhenHtmlIsNull() {
    assertEquals("", HtmlTextExtractor.extractText(null));
  }
}
