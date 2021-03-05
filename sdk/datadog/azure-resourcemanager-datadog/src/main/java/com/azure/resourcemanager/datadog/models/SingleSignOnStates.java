// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datadog.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for SingleSignOnStates. */
public final class SingleSignOnStates extends ExpandableStringEnum<SingleSignOnStates> {
    /** Static value Initial for SingleSignOnStates. */
    public static final SingleSignOnStates INITIAL = fromString("Initial");

    /** Static value Enable for SingleSignOnStates. */
    public static final SingleSignOnStates ENABLE = fromString("Enable");

    /** Static value Disable for SingleSignOnStates. */
    public static final SingleSignOnStates DISABLE = fromString("Disable");

    /** Static value Existing for SingleSignOnStates. */
    public static final SingleSignOnStates EXISTING = fromString("Existing");

    /**
     * Creates or finds a SingleSignOnStates from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding SingleSignOnStates.
     */
    @JsonCreator
    public static SingleSignOnStates fromString(String name) {
        return fromString(name, SingleSignOnStates.class);
    }

    /** @return known SingleSignOnStates values. */
    public static Collection<SingleSignOnStates> values() {
        return values(SingleSignOnStates.class);
    }
}
