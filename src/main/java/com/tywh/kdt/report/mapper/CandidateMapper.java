package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.Candidate;
import com.tywh.kdt.report.pojo.QueryConditionCandidate;

import java.util.List;
import java.util.Map;

public interface CandidateMapper {

    List<Candidate> queryCandidateList(QueryConditionCandidate queryConditionCandidate) throws Exception;

    void add(Candidate candidate) throws Exception;

    Candidate queryById(Integer id);

    void update(Candidate candidate);

    Map<String, Integer> queryTotalRecords(QueryConditionCandidate queryConditionCandidate);


}
