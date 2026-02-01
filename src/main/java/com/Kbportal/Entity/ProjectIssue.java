package com.Kbportal.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ProjectIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issueTitle;
    private String errorMessage;
    private String rootCause;

    @Column(columnDefinition = "TEXT")
    private String solution;

    private String createdBy;

    private LocalDateTime createdAt;

    // Constructors
    public ProjectIssue() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIssueTitle() { return issueTitle; }
    public void setIssueTitle(String issueTitle) { this.issueTitle = issueTitle; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    public String getRootCause() { return rootCause; }
    public void setRootCause(String rootCause) { this.rootCause = rootCause; }

    public String getSolution() { return solution; }
    public void setSolution(String solution) { this.solution = solution; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
