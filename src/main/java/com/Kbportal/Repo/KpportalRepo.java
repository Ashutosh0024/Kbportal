package com.Kbportal.Repo;

import com.Kbportal.Entity.ProjectIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KpportalRepo extends JpaRepository<ProjectIssue , Long> {

    @Query("SELECT p FROM ProjectIssue p WHERE " +
            "LOWER(p.issueTitle) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.errorMessage) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.solution) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<ProjectIssue> searchByKeyword(@Param("keyword") String keyword);
}
