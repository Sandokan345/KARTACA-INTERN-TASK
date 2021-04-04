package com.kartaca.task.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "log-data")
@Builder
@lombok.Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Data {

    private String requestType;

    private String responseTime;

    private String timestamp;
}
