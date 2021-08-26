package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.Candidate;

import java.util.List;

public interface CandidateMapper {

    List<Candidate> queryCandidateList() throws Exception;

    void add(Candidate candidate) throws Exception;

    Candidate queryById(Integer id);

    void update(Candidate candidate);
}
