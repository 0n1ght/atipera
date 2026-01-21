# GitHub Proxy API

Prosta aplikacja proxy do GitHub API, napisana w **Java 25 + Spring Boot 4.0.1 + Gradle-Kotlin**.  
Aplikacja umożliwia pobranie wszystkich **repozytoriów użytkownika**, które **nie są forkami**, wraz z listą branchy i SHA ostatniego commita.

---

## Funkcjonalności

- Pobranie listy repozytoriów użytkownika GitHub, które nie są forkami
- Dla każdego repozytorium: nazwa repozytorium, login właściciela oraz lista branchy z SHA ostatniego commita
- Obsługa nieistniejącego użytkownika → zwraca error `404` w formacie:

```json
{
  "status": "404",
  "message": "user <username> not found"
}
```
## Przykład użycia
Endpoint:
<br>
`GET localhost:8080/{username}`
<br>
(`username`- nazwa użytkownika)

Odpowiedź:
```json
[
  {
    "repositoryName": "Hello-World",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "main",
        "lastCommitSha": "abc677..."
      }
    ]
  }
]
```