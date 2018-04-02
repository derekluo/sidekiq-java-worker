package com.zouyyu.job;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * @author YuZou
 * @date 29/03/2018
 */
public class Job {

    private String klass;
    private String wrapped;
    private String queue;
    private String jid;
    private Boolean retry = true;
    private Double  createdAt;
    private Double  enqueuedAt;
    private List<Args> args;

    @JsonProperty("class")
    public String getKlass() {
        return klass;
    }

    public String getWrapped() {
        return wrapped;
    }

    public String getQueue() {
        return queue;
    }

    public String getJid() {
        return jid;
    }


    public Boolean getRetry() {
        return retry;
    }

    @JsonProperty("created_at")
    public Double getCreatedAt() {
        return createdAt;
    }


    @JsonProperty("enqueued_at")
    public Double getEnqueuedAt() {
        return enqueuedAt;
    }

    public List<Args> getArgs() {
        return args;
    }

    public void setArgs(List<Args> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "Job{" +
            "klass='" + klass + '\'' +
            ", wrapped='" + wrapped + '\'' +
            ", queue='" + queue + '\'' +
            ", jid='" + jid + '\'' +
            ", retry=" + retry +
            ", createdAt=" + createdAt +
            ", enqueuedAt=" + enqueuedAt +
            ", args=" + args +
            '}';
    }
}
