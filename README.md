# GitHub Proxy API

Aplikacja proxy do GitHub API, napisana w **Java 25 + Spring Boot 4.0.1**.  
Umożliwia pobranie wszystkich repozytoriów użytkownika, które **nie są forkami**, oraz listę jego branchy i SHA ostatniego commita.

---

## Funkcjonalności

- Pobranie listy repozytoriów użytkownika GitHub, które nie są forkami
- Dla każdego repozytorium: jego nazwa, login właściciela oraz lista branchy (nazwa brancha i SHA ostatniego commita)
- Obsługa nieistniejącego użytkownika → zwraca error:

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
