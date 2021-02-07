// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.chat.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** A paged collection of chat message read receipts. */
@Fluent
public final class ChatMessageReadReceiptsCollection {
    /*
     * Collection of chat message read receipts.
     */
    @JsonProperty(value = "value", required = true)
    private List<ChatMessageReadReceipt> value;

    /*
     * If there are more chat message read receipts that can be retrieved, the
     * next link will be populated.
     */
    @JsonProperty(value = "nextLink", access = JsonProperty.Access.WRITE_ONLY)
    private String nextLink;

    /**
     * Get the value property: Collection of chat message read receipts.
     *
     * @return the value value.
     */
    public List<ChatMessageReadReceipt> getValue() {
        return this.value;
    }

    /**
     * Set the value property: Collection of chat message read receipts.
     *
     * @param value the value value to set.
     * @return the ChatMessageReadReceiptsCollection object itself.
     */
    public ChatMessageReadReceiptsCollection setValue(List<ChatMessageReadReceipt> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: If there are more chat message read receipts that can be retrieved, the next link will
     * be populated.
     *
     * @return the nextLink value.
     */
    public String getNextLink() {
        return this.nextLink;
    }
}
