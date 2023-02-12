package com.ivanov.laboratory.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    private List<Integer> analyzeIds;
}
