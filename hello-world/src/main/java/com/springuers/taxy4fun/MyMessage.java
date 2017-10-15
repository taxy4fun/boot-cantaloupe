package com.springuers.taxy4fun;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MyMessage implements Serializable {
    private String subject;
    private LocalDateTime dateTime;

    public MyMessage(String subject, LocalDateTime dateTime) {
        this.subject = subject;
        this.dateTime = dateTime;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("subject", subject)
                .append("dateTime", dateTime)
                .toString();
    }
}
