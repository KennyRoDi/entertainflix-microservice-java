package com.example.microservice.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoryFilterDTO {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("limit")
    private Integer limit;

    @JsonProperty("offset")
    private Integer offset;

    public HistoryFilterDTO() {
    }

    public HistoryFilterDTO(
            String requestId,
            String userId,
            String transactionType,
            Integer limit,
            Integer offset) {
        this.requestId = requestId;
        this.userId = userId;
        this.transactionType = transactionType;
        this.limit = limit;
        this.offset = offset;
    }

    // Getters and Setters
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
