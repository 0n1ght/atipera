package com.example.githubproxy;

import java.util.List;

public record RepoResponse(String repositoryName, String ownerLogin, List<BranchResponse> branches) {
    public record BranchResponse(String name, String lastCommitSha) {
    }
}
