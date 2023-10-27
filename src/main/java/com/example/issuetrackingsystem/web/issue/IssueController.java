package com.example.issuetrackingsystem.web.issue;

import com.example.issuetrackingsystem.domain.issue.IssueEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IssueController {
    // GET /issues
    @GetMapping("/issues")
    public String showList(Model model){
        var issueList = List.of(
                new IssueEntity(1, "概要1", "説明1"),
                new IssueEntity(2, "概要2", "説明2"),
                new IssueEntity(3, "概要3", "説明3")
        );
        model.addAttribute("issueList", issueList);
        return "issues/list";
    }
}
