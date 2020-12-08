// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for SparkJobReferenceType. */
public final class SparkJobReferenceType extends ExpandableStringEnum<SparkJobReferenceType> {
    /** Static value SparkJobDefinitionReference for SparkJobReferenceType. */
    public static final SparkJobReferenceType SPARK_JOB_DEFINITION_REFERENCE =
            fromString("SparkJobDefinitionReference");

    /**
     * Creates or finds a SparkJobReferenceType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding SparkJobReferenceType.
     */
    @JsonCreator
    public static SparkJobReferenceType fromString(String name) {
        return fromString(name, SparkJobReferenceType.class);
    }

    /** @return known SparkJobReferenceType values. */
    public static Collection<SparkJobReferenceType> values() {
        return values(SparkJobReferenceType.class);
    }
}
