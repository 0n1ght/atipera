package com.example.githubproxy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class GitHubController {
    private final GitHubService service;

    public GitHubController(GitHubService service) {
        this.service = service;
    }

    @GetMapping("/{username}")
    public List<RepoResponse> getRepositories(@PathVariable String username) {
        return service.getRepos(username);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(Map.of("status", String.valueOf(ex.getStatusCode().value()), "message", Objects.requireNonNull(ex.getReason())));
    }
}
