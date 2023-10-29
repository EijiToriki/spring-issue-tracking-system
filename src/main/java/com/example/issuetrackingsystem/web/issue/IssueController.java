package com.example.issuetrackingsystem.web.issue;

import com.example.issuetrackingsystem.domain.issue.IssueEntity;
import com.example.issuetrackingsystem.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    // GET /issues
    @GetMapping
    public String showList(Model model){
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }

    // GET /issues/creationForm
    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form){
        return "issues/creationForm";
    }

    // POST /issues
    @PostMapping
    public String create(@Validated IssueForm issueForm, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return showCreationForm(issueForm);
        }
        issueService.create(issueForm.getSummary(), issueForm.getDescription());
        return "redirect:/issues";
    }

    // GET localhost:8080/issues/1
    @GetMapping("{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model){
        model.addAttribute("issue", issueService.findById(issueId));
        return "issues/detail";
    }
}
