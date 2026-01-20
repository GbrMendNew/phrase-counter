package com.example.http;

public interface ContentFetcher {
  String fetch(String url) throws Exception;
}
