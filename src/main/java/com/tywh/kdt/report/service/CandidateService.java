package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> queryCandidateList() throws Exception;

    void add(Candidate candidate) throws Exception;
}
