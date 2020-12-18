// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kusto.models;

import com.azure.resourcemanager.kusto.fluent.models.DiagnoseVirtualNetworkResultInner;
import java.util.List;

/** An immutable client-side representation of DiagnoseVirtualNetworkResult. */
public interface DiagnoseVirtualNetworkResult {
    /**
     * Gets the findings property: The list of network connectivity diagnostic finding.
     *
     * @return the findings value.
     */
    List<String> findings();

    /**
     * Gets the inner com.azure.resourcemanager.kusto.fluent.models.DiagnoseVirtualNetworkResultInner object.
     *
     * @return the inner object.
     */
    DiagnoseVirtualNetworkResultInner innerModel();
}
