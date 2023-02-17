package com.ivanov.laboratory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivanov.laboratory.models.Analyze;
import com.ivanov.laboratory.services.AnalyzeService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get-analyze")
public class AnalyzeController {

    private final AnalyzeService analyzeService;

    public AnalyzeController(AnalyzeService analyzeService) {
        this.analyzeService = analyzeService;
    }

    @GetMapping
    public HttpEntity<Object> getAnalyzeDB() throws JsonProcessingException {
        List<Analyze> analyzeList = analyzeService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String s;
        s = mapper.writeValueAsString(analyzeList);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(s, headers);
    }

}
