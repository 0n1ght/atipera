package com.example.githubproxy;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class GitHubService {
    private final GitHubClient client;

    public GitHubService(GitHubClient client) {
        this.client = client;
    }

    public List<RepoResponse> getRepos(String username) {

        try {
            return Arrays.stream(client.getRepositories(username))
                    .filter(repo -> !repo.isFork())
                    .peek(repo -> repo.setBranches(List.of(client.getBranches(repo.getOwner().getLogin(), repo.getName()))))
                    .map(repo -> new RepoResponse(
                            repo.getName(),
                            repo.getOwner().getLogin(),
                            repo.getBranches().stream()
                                    .map(branch -> new RepoResponse.BranchResponse(branch.getName(), branch.getCommit().getSha()))
                                    .toList()
                    ))
                    .toList();
        } catch (HttpClientErrorException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user " + username + " not found");
        }
    }
}
