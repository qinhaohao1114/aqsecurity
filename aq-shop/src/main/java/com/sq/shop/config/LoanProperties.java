package com.sq.shop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 */
@Configuration
@ConfigurationProperties("loan")
public class LoanProperties {
    private final static Integer DEFAULT_MAX_BATCH_SIZE = 200;

    private boolean checkSourceSystem;
    private Long maxWaitMillis;
    private Long maxProcessingRequest;
    private Integer maxBatchSize = DEFAULT_MAX_BATCH_SIZE;
    private String replyQueueName;

    public Long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(Long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public Long getMaxProcessingRequest() {
        return maxProcessingRequest;
    }

    public void setMaxProcessingRequest(Long maxProcessingRequest) {
        this.maxProcessingRequest = maxProcessingRequest;
    }

    public boolean isCheckSourceSystem() {
        return checkSourceSystem;
    }

    public void setCheckSourceSystem(boolean checkSourceSystem) {
        this.checkSourceSystem = checkSourceSystem;
    }

    public Integer getMaxBatchSize() {
        return maxBatchSize;
    }

    public void setMaxBatchSize(Integer maxBatchSize) {
        this.maxBatchSize = maxBatchSize;
    }

    public String getReplyQueueName() {
        return replyQueueName;
    }

    public void setReplyQueueName(String replyQueueName) {
        this.replyQueueName = replyQueueName;
    }
}
