package com.example.html;

import org.jsoup.Jsoup;

public class HtmlTextExtractor {

  public static String extractText(String html) {
    if (html == null) return "";
    var doc = Jsoup.parse(html);

    // Remover scripts, estilos e outros elementos não textuais
    doc.select("script, style, noscript").remove();

    // Pegar elementos fora do texto principal, como atributos alt de imagens
    for (org.jsoup.nodes.Element img : doc.select("img[alt]")) {
        doc.body().appendElement("p").text(img.attr("alt"));
    }


    return doc.text();
  }

}

