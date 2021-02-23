// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Protocol settings for file service. */
@Fluent
public final class ProtocolSettings {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ProtocolSettings.class);

    /*
     * Setting for SMB protocol
     */
    @JsonProperty(value = "smb")
    private SmbSetting smb;

    /**
     * Get the smb property: Setting for SMB protocol.
     *
     * @return the smb value.
     */
    public SmbSetting smb() {
        return this.smb;
    }

    /**
     * Set the smb property: Setting for SMB protocol.
     *
     * @param smb the smb value to set.
     * @return the ProtocolSettings object itself.
     */
    public ProtocolSettings withSmb(SmbSetting smb) {
        this.smb = smb;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (smb() != null) {
            smb().validate();
        }
    }
}
