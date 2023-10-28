package com.example.issuetrackingsystem.web.issue;

import com.example.issuetrackingsystem.domain.issue.IssueEntity;
import com.example.issuetrackingsystem.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    // GET /issues
    @GetMapping("/issues")
    public String showList(Model model){
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }
}
