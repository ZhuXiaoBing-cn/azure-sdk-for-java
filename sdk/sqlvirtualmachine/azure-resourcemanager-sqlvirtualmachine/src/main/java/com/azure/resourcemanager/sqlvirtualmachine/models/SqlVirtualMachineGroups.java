// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sqlvirtualmachine.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/** Resource collection API of SqlVirtualMachineGroups. */
public interface SqlVirtualMachineGroups {
    /**
     * Gets a SQL virtual machine group.
     *
     * @param resourceGroupName Name of the resource group that contains the resource. You can obtain this value from
     *     the Azure Resource Manager API or the portal.
     * @param sqlVirtualMachineGroupName Name of the SQL virtual machine group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a SQL virtual machine group.
     */
    SqlVirtualMachineGroup getByResourceGroup(String resourceGroupName, String sqlVirtualMachineGroupName);

    /**
     * Gets a SQL virtual machine group.
     *
     * @param resourceGroupName Name of the resource group that contains the resource. You can obtain this value from
     *     the Azure Resource Manager API or the portal.
     * @param sqlVirtualMachineGroupName Name of the SQL virtual machine group.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a SQL virtual machine group.
     */
    Response<SqlVirtualMachineGroup> getByResourceGroupWithResponse(
        String resourceGroupName, String sqlVirtualMachineGroupName, Context context);

    /**
     * Deletes a SQL virtual machine group.
     *
     * @param resourceGroupName Name of the resource group that contains the resource. You can obtain this value from
     *     the Azure Resource Manager API or the portal.
     * @param sqlVirtualMachineGroupName Name of the SQL virtual machine group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByResourceGroup(String resourceGroupName, String sqlVirtualMachineGroupName);

    /**
     * Deletes a SQL virtual machine group.
     *
     * @param resourceGroupName Name of the resource group that contains the resource. You can obtain this value from
     *     the Azure Resource Manager API or the portal.
     * @param sqlVirtualMachineGroupName Name of the SQL virtual machine group.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String sqlVirtualMachineGroupName, Context context);

    /**
     * Gets all SQL virtual machine groups in a resource group.
     *
     * @param resourceGroupName Name of the resource group that contains the resource. You can obtain this value from
     *     the Azure Resource Manager API or the portal.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all SQL virtual machine groups in a resource group.
     */
    PagedIterable<SqlVirtualMachineGroup> listByResourceGroup(String resourceGroupName);

    /**
     * Gets all SQL virtual machine groups in a resource group.
     *
     * @param resourceGroupName Name of the resource group that contains the resource. You can obtain this value from
     *     the Azure Resource Manager API or the portal.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all SQL virtual machine groups in a resource group.
     */
    PagedIterable<SqlVirtualMachineGroup> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * Gets all SQL virtual machine groups in a subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all SQL virtual machine groups in a subscription.
     */
    PagedIterable<SqlVirtualMachineGroup> list();

    /**
     * Gets all SQL virtual machine groups in a subscription.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all SQL virtual machine groups in a subscription.
     */
    PagedIterable<SqlVirtualMachineGroup> list(Context context);

    /**
     * Gets a SQL virtual machine group.
     *
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a SQL virtual machine group.
     */
    SqlVirtualMachineGroup getById(String id);

    /**
     * Gets a SQL virtual machine group.
     *
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a SQL virtual machine group.
     */
    Response<SqlVirtualMachineGroup> getByIdWithResponse(String id, Context context);

    /**
     * Deletes a SQL virtual machine group.
     *
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Deletes a SQL virtual machine group.
     *
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByIdWithResponse(String id, Context context);

    /**
     * Begins definition for a new SqlVirtualMachineGroup resource.
     *
     * @param name resource name.
     * @return the first stage of the new SqlVirtualMachineGroup definition.
     */
    SqlVirtualMachineGroup.DefinitionStages.Blank define(String name);
}
