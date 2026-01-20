package com.example.html;

import org.jsoup.Jsoup;

public class HtmlTextExtractor {

  public static String extractText(String html) {
    if (html == null) return "";
    return Jsoup.parse(html).text();
  }
}

