package com.tywh.kdt.report.web;

import com.tywh.kdt.report.pojo.Candidate;
import com.tywh.kdt.report.pojo.ResultCandidate;
import com.tywh.kdt.report.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/hr/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping("/page")
    public String toPage() {

        return "candidate";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultCandidate list() throws Exception{

        List<Candidate> list = candidateService.queryCandidateList();
        ResultCandidate resultCandidate = new ResultCandidate();
        resultCandidate.setList(list);
        return resultCandidate;
    }

    @RequestMapping("/add")
    public void add(Candidate candidate) throws Exception{
        String str = "test";
        this.candidateService.add(candidate);
    }
}
