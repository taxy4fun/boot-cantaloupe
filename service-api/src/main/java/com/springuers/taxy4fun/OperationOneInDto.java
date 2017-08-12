package com.springuers.taxy4fun;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OperationOneInDto {
    private Long id;
    private String propertyOne;

    public OperationOneInDto(final Long id, final String propertyOne) {
        this.id = id;
        this.propertyOne = propertyOne;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getPropertyOne() {
        return propertyOne;
    }

    public void setPropertyOne(final String propertyOne) {
        this.propertyOne = propertyOne;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("propertyOne", propertyOne)
                .toString();
    }
}
