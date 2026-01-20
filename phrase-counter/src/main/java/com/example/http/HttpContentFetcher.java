package com.example.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpContentFetcher implements ContentFetcher {

  private final HttpClient client = HttpClient.newHttpClient();

  @Override
  public String fetch(String url) throws Exception {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .header("User-Agent", "phrase-counter/1.0")
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
  }
}
