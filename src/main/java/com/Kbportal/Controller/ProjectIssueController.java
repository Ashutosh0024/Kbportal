package com.Kbportal.Controller;

import com.Kbportal.Entity.ProjectIssue;
import com.Kbportal.Repo.KpportalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class ProjectIssueController {

    @Autowired
    private KpportalRepo kpportalRepo;

    @GetMapping
    public List<ProjectIssue> getAllIssue(){
        return kpportalRepo.findAll();
    }

    @GetMapping("/{id}")
    public ProjectIssue GetIssueById(@PathVariable Long id){
        return kpportalRepo.findById(id).orElse(null);
    }

    @PostMapping
    public ProjectIssue createIssue(@RequestBody ProjectIssue projectIssue){
        return kpportalRepo.save(projectIssue);
    }


    @PutMapping("/{id}")
    public ProjectIssue updateIssue(@PathVariable Long id, @RequestBody ProjectIssue updatedIssue) {
        return kpportalRepo.findById(id).map(issue -> {
            issue.setIssueTitle(updatedIssue.getIssueTitle());
            issue.setErrorMessage(updatedIssue.getErrorMessage());
            issue.setRootCause(updatedIssue.getRootCause());
            issue.setSolution(updatedIssue.getSolution());
            issue.setCreatedBy(updatedIssue.getCreatedBy());
            return kpportalRepo.save(issue);
        }).orElse(null);
    }


    @DeleteMapping("/{id}")
    public String deleteIssue(@PathVariable Long id) {
        kpportalRepo.deleteById(id);
        return "Issue deleted with id: " + id;
    }

    @GetMapping("/search")
    public List<ProjectIssue> searchIssues(@RequestParam String keyword) {
        return kpportalRepo.searchByKeyword(keyword);
    }
}
