# Phrase Counter

Desafio técnico Backend Sillion

Aplicação em **Java** que analisa o conteúdo textual de uma página web e conta:

- quantas vezes uma **frase completa** aparece no texto
- quantas vezes **cada palavra da frase** aparece individualmente

O projeto foi desenvolvido com foco em **simplicidade, legibilidade e TDD**, e pode ser executado:
- localmente (Java/Maven)
- via Docker
- em um cluster Kubernetes (kind, minikube, EKS, GKE, etc.)

---

## Lógica de contagem

- O texto da página é:
  - convertido de HTML para texto
  - normalizado 
- A **frase** é contada como **substring** no texto normalizado
- As **palavras** são contadas como **tokens exatos**

> Exemplo:
>
> Frase: `example`  
> Texto: `example domain example domain example`
>
> - Frase: 3 ocorrências  
> - Palavra `"example"`: 2 ocorrências

---

## Testes (TDD)

O projeto foi construído seguindo **TDD**, com testes unitários para:

- normalização de texto
- tokenização
- contagem de frase
- contagem de palavras
- serviço de análise (com fetcher fake)

Para rodar os testes:

```bash
mvn test
