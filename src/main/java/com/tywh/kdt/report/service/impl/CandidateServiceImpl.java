package com.tywh.kdt.report.service.impl;

import com.tywh.kdt.report.mapper.CandidateMapper;
import com.tywh.kdt.report.pojo.Candidate;
import com.tywh.kdt.report.pojo.QueryConditionCandidate;
import com.tywh.kdt.report.service.CandidateService;
import com.tywh.kdt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateMapper candidateMapper;

    @Override
    public List<Candidate> queryCandidateList(QueryConditionCandidate queryConditionCandidate) throws Exception{
        return candidateMapper.queryCandidateList(queryConditionCandidate);
    }


    @Override
    public void add(Candidate candidate) throws Exception {
        candidate.setId(null);
        candidate.setCreatedate(DateUtil.format(new Date(),"yyyy-MM-dd"));
        this.candidateMapper.add(candidate);
    }

    @Override
    public Candidate queryById(Integer id) {
        return this.candidateMapper.queryById(id);
    }

    @Override
    public void update(Candidate candidate) {
        this.candidateMapper.update(candidate);
    }

    @Override
    public Map<String, Integer> queryTotalRecords(QueryConditionCandidate queryConditionCandidate) {
        return candidateMapper.queryTotalRecords(queryConditionCandidate);
    }
}
