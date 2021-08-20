package com.tywh.kdt.report.service.impl;

import com.tywh.kdt.report.mapper.CandidateMapper;
import com.tywh.kdt.report.pojo.Candidate;
import com.tywh.kdt.report.service.CandidateService;
import com.tywh.kdt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateMapper candidateMapper;

    @Override
    public List<Candidate> queryCandidateList() throws Exception{
        return candidateMapper.queryCandidateList();
    }

    @Override
    public void add(Candidate candidate) throws Exception {
        candidate.setId(2);
        candidate.setCreatedate(DateUtil.format(new Date(),"yyyy-MM-dd"));
        this.candidateMapper.add(candidate);
    }
}
