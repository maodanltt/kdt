package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.Candidate;

import java.util.List;
import java.util.Map;

public interface CandidateMapper {

    List<Candidate> queryCandidateList(Candidate candidate) throws Exception;

    void add(Candidate candidate) throws Exception;

    Candidate queryById(Integer id);

    void update(Candidate candidate);

    Map<String, Integer> queryTotalRecords(Candidate candidate);


}
