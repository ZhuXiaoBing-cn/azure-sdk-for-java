// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Encryption identity for the storage account. */
@Fluent
public class EncryptionIdentity {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(EncryptionIdentity.class);

    /*
     * Resource identifier of the UserAssigned identity to be associated with
     * server-side encryption on the storage account.
     */
    @JsonProperty(value = "userAssignedIdentity")
    private String encryptionUserAssignedIdentity;

    /**
     * Get the encryptionUserAssignedIdentity property: Resource identifier of the UserAssigned identity to be
     * associated with server-side encryption on the storage account.
     *
     * @return the encryptionUserAssignedIdentity value.
     */
    public String encryptionUserAssignedIdentity() {
        return this.encryptionUserAssignedIdentity;
    }

    /**
     * Set the encryptionUserAssignedIdentity property: Resource identifier of the UserAssigned identity to be
     * associated with server-side encryption on the storage account.
     *
     * @param encryptionUserAssignedIdentity the encryptionUserAssignedIdentity value to set.
     * @return the EncryptionIdentity object itself.
     */
    public EncryptionIdentity withEncryptionUserAssignedIdentity(String encryptionUserAssignedIdentity) {
        this.encryptionUserAssignedIdentity = encryptionUserAssignedIdentity;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
