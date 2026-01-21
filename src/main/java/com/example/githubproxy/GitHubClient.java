package com.example.githubproxy;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public Repo[] getRepositories(String username) {

        return restTemplate.getForObject(
                "https://api.github.com/users/{username}/repos",
                Repo[].class,
                username);
    }

    public Branch[] getBranches(String owner, String repo) {

        return restTemplate.getForObject(
                "https://api.github.com/repos/{owner}/{repo}/branches",
                Branch[].class,
                owner, repo);
    }
}
