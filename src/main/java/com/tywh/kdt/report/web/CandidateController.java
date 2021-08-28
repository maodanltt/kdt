package com.tywh.kdt.report.web;

import com.tywh.kdt.report.pojo.Candidate;
import com.tywh.kdt.report.pojo.QueryConditionCandidate;
import com.tywh.kdt.report.pojo.ResultCandidate;
import com.tywh.kdt.report.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    public ResultCandidate list(QueryConditionCandidate queryConditionCandidate) {

        try {

            if (queryConditionCandidate == null) {
                queryConditionCandidate = new QueryConditionCandidate();
            }
            if (queryConditionCandidate.getPageno() == null) {
                queryConditionCandidate.setPageno(1);
            }

            if (queryConditionCandidate.getPagesize() == null) {
                queryConditionCandidate.setPagesize(3);
            }

            List<Candidate> list = candidateService.queryCandidateList(queryConditionCandidate);
            ResultCandidate resultCandidate = new ResultCandidate();
            resultCandidate.setList(list);

            Map<String, Integer> map = candidateService.queryTotalRecords(queryConditionCandidate);
            resultCandidate.setTotal(map.get("total"));
            return resultCandidate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/add")
    public void add(Candidate candidate) throws Exception{
        String str = "test";
        this.candidateService.add(candidate);
    }

    @RequestMapping("/queryById")
    @ResponseBody
    public Candidate queryById(Integer id) {

        return this.candidateService.queryById(id);
    }

    @RequestMapping("/update")
    public void update(Candidate candidate) {
        this.candidateService.update(candidate);
    }
}
