// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.eventgrid.fluent.models.EventTypeInner;
import com.azure.resourcemanager.eventgrid.fluent.models.TopicInner;
import com.azure.resourcemanager.eventgrid.fluent.models.TopicSharedAccessKeysInner;
import com.azure.resourcemanager.eventgrid.models.TopicRegenerateKeyRequest;
import com.azure.resourcemanager.eventgrid.models.TopicUpdateParameters;

/** An instance of this class provides access to all the operations defined in TopicsClient. */
public interface TopicsClient {
    /**
     * Get properties of a topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of a topic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TopicInner getByResourceGroup(String resourceGroupName, String topicName);

    /**
     * Get properties of a topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of a topic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<TopicInner> getByResourceGroupWithResponse(String resourceGroupName, String topicName, Context context);

    /**
     * Asynchronously creates a new topic with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param topicInfo Topic information.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return eventGrid Topic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<TopicInner>, TopicInner> beginCreateOrUpdate(
        String resourceGroupName, String topicName, TopicInner topicInfo);

    /**
     * Asynchronously creates a new topic with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param topicInfo Topic information.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return eventGrid Topic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<TopicInner>, TopicInner> beginCreateOrUpdate(
        String resourceGroupName, String topicName, TopicInner topicInfo, Context context);

    /**
     * Asynchronously creates a new topic with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param topicInfo Topic information.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return eventGrid Topic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TopicInner createOrUpdate(String resourceGroupName, String topicName, TopicInner topicInfo);

    /**
     * Asynchronously creates a new topic with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param topicInfo Topic information.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return eventGrid Topic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TopicInner createOrUpdate(String resourceGroupName, String topicName, TopicInner topicInfo, Context context);

    /**
     * Delete existing topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String topicName);

    /**
     * Delete existing topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String topicName, Context context);

    /**
     * Delete existing topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String topicName);

    /**
     * Delete existing topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String topicName, Context context);

    /**
     * Asynchronously updates a topic with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param topicUpdateParameters Topic update information.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<TopicInner>, TopicInner> beginUpdate(
        String resourceGroupName, String topicName, TopicUpdateParameters topicUpdateParameters);

    /**
     * Asynchronously updates a topic with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param topicUpdateParameters Topic update information.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<TopicInner>, TopicInner> beginUpdate(
        String resourceGroupName, String topicName, TopicUpdateParameters topicUpdateParameters, Context context);

    /**
     * Asynchronously updates a topic with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param topicUpdateParameters Topic update information.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TopicInner update(String resourceGroupName, String topicName, TopicUpdateParameters topicUpdateParameters);

    /**
     * Asynchronously updates a topic with the specified parameters.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param topicUpdateParameters Topic update information.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TopicInner update(
        String resourceGroupName, String topicName, TopicUpdateParameters topicUpdateParameters, Context context);

    /**
     * List all the topics under an Azure subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Topics operation.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<TopicInner> list();

    /**
     * List all the topics under an Azure subscription.
     *
     * @param filter The query used to filter the search results using OData syntax. Filtering is permitted on the
     *     'name' property only and with limited number of OData operations. These operations are: the 'contains'
     *     function as well as the following logical operations: not, and, or, eq (for equal), and ne (for not equal).
     *     No arithmetic operations are supported. The following is a valid filter example: $filter=contains(namE,
     *     'PATTERN') and name ne 'PATTERN-1'. The following is not a valid filter example: $filter=location eq
     *     'westus'.
     * @param top The number of results to return per page for the list operation. Valid range for top parameter is 1 to
     *     100. If not specified, the default number of results to be returned is 20 items per page.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Topics operation.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<TopicInner> list(String filter, Integer top, Context context);

    /**
     * List all the topics under a resource group.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Topics operation.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<TopicInner> listByResourceGroup(String resourceGroupName);

    /**
     * List all the topics under a resource group.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param filter The query used to filter the search results using OData syntax. Filtering is permitted on the
     *     'name' property only and with limited number of OData operations. These operations are: the 'contains'
     *     function as well as the following logical operations: not, and, or, eq (for equal), and ne (for not equal).
     *     No arithmetic operations are supported. The following is a valid filter example: $filter=contains(namE,
     *     'PATTERN') and name ne 'PATTERN-1'. The following is not a valid filter example: $filter=location eq
     *     'westus'.
     * @param top The number of results to return per page for the list operation. Valid range for top parameter is 1 to
     *     100. If not specified, the default number of results to be returned is 20 items per page.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Topics operation.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<TopicInner> listByResourceGroup(
        String resourceGroupName, String filter, Integer top, Context context);

    /**
     * List the two keys used to publish to a topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return shared access keys of the Topic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TopicSharedAccessKeysInner listSharedAccessKeys(String resourceGroupName, String topicName);

    /**
     * List the two keys used to publish to a topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return shared access keys of the Topic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<TopicSharedAccessKeysInner> listSharedAccessKeysWithResponse(
        String resourceGroupName, String topicName, Context context);

    /**
     * Regenerate a shared access key for a topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param regenerateKeyRequest Request body to regenerate key.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return shared access keys of the Topic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TopicSharedAccessKeysInner regenerateKey(
        String resourceGroupName, String topicName, TopicRegenerateKeyRequest regenerateKeyRequest);

    /**
     * Regenerate a shared access key for a topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param topicName Name of the topic.
     * @param regenerateKeyRequest Request body to regenerate key.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return shared access keys of the Topic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<TopicSharedAccessKeysInner> regenerateKeyWithResponse(
        String resourceGroupName, String topicName, TopicRegenerateKeyRequest regenerateKeyRequest, Context context);

    /**
     * List event types for a topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param providerNamespace Namespace of the provider of the topic.
     * @param resourceTypeName Name of the topic type.
     * @param resourceName Name of the topic.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Event Types operation.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<EventTypeInner> listEventTypes(
        String resourceGroupName, String providerNamespace, String resourceTypeName, String resourceName);

    /**
     * List event types for a topic.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription.
     * @param providerNamespace Namespace of the provider of the topic.
     * @param resourceTypeName Name of the topic type.
     * @param resourceName Name of the topic.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the List Event Types operation.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<EventTypeInner> listEventTypes(
        String resourceGroupName,
        String providerNamespace,
        String resourceTypeName,
        String resourceName,
        Context context);
}
