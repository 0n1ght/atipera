package com.example.githubproxy;

import java.util.List;

public record GitHubRepository(String name, Owner owner, List<GitHubBranch> branches, boolean fork) {
    public record Owner(String login) {
    }
}
