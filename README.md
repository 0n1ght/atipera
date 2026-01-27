# GitHub Proxy API

A proxy application for the GitHub API, built with **Java 25 + Spring Boot 4.0.1**.
It allows fetching all user repositories that **are not forks**, along with their branches and the SHA of the latest commit.

---

## Features

* Fetch a list of GitHub user repositories that are not forks
* For each repository: repository name, owner login, and a list of branches (branch name and latest commit SHA)
* Handles non-existing users → returns an error:

```json
{
  "status": "404",
  "message": "user <username> not found"
}
```

## Usage Example

Endpoint:

`GET localhost:8080/{username}`

where `{username}` is the GitHub username.

Response:

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
