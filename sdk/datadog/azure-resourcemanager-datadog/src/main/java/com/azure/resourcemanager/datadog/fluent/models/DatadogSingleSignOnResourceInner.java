// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datadog.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.datadog.models.DatadogSingleSignOnProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The DatadogSingleSignOnResource model. */
@Fluent
public final class DatadogSingleSignOnResourceInner extends ProxyResource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(DatadogSingleSignOnResourceInner.class);

    /*
     * The properties property.
     */
    @JsonProperty(value = "properties")
    private DatadogSingleSignOnProperties properties;

    /**
     * Get the properties property: The properties property.
     *
     * @return the properties value.
     */
    public DatadogSingleSignOnProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: The properties property.
     *
     * @param properties the properties value to set.
     * @return the DatadogSingleSignOnResourceInner object itself.
     */
    public DatadogSingleSignOnResourceInner withProperties(DatadogSingleSignOnProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
    }
}
