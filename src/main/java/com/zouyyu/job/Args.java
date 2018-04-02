package com.zouyyu.job;

import java.util.List;

/**
 * @author YuZou
 * @date 29/03/2018
 */
public class Args {

    private String job_class;
    private String job_id;
    private String provider_job_id;
    private String queue_name;
    private String priority;
    private List<Object> arguments;
    private Integer executions;
    private String locale;

    public String getJob_class() {
        return job_class;
    }

    public void setJob_class(String job_class) {
        this.job_class = job_class;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getProvider_job_id() {
        return provider_job_id;
    }

    public void setProvider_job_id(String provider_job_id) {
        this.provider_job_id = provider_job_id;
    }

    public String getQueue_name() {
        return queue_name;
    }

    public void setQueue_name(String queue_name) {
        this.queue_name = queue_name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public List<Object> getArguments() {
        return arguments;
    }

    public void setArguments(List<Object> arguments) {
        this.arguments = arguments;
    }

    public Integer getExecutions() {
        return executions;
    }

    public void setExecutions(Integer executions) {
        this.executions = executions;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "Args{" +
            "job_class='" + job_class + '\'' +
            ", job_id='" + job_id + '\'' +
            ", provider_job_id='" + provider_job_id + '\'' +
            ", queue_name='" + queue_name + '\'' +
            ", priority='" + priority + '\'' +
            ", arguments=" + arguments +
            ", executions=" + executions +
            ", locale='" + locale + '\'' +
            '}';
    }
}
