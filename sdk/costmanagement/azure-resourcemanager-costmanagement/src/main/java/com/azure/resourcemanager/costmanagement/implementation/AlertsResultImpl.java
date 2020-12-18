// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.implementation;

import com.azure.resourcemanager.costmanagement.CostManagementManager;
import com.azure.resourcemanager.costmanagement.fluent.models.AlertInner;
import com.azure.resourcemanager.costmanagement.fluent.models.AlertsResultInner;
import com.azure.resourcemanager.costmanagement.models.Alert;
import com.azure.resourcemanager.costmanagement.models.AlertsResult;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class AlertsResultImpl implements AlertsResult {
    private AlertsResultInner innerObject;

    private final CostManagementManager serviceManager;

    AlertsResultImpl(AlertsResultInner innerObject, CostManagementManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public List<Alert> value() {
        List<AlertInner> inner = this.innerModel().value();
        if (inner != null) {
            return Collections
                .unmodifiableList(
                    inner.stream().map(inner1 -> new AlertImpl(inner1, this.manager())).collect(Collectors.toList()));
        } else {
            return Collections.emptyList();
        }
    }

    public String nextLink() {
        return this.innerModel().nextLink();
    }

    public AlertsResultInner innerModel() {
        return this.innerObject;
    }

    private CostManagementManager manager() {
        return this.serviceManager;
    }
}
