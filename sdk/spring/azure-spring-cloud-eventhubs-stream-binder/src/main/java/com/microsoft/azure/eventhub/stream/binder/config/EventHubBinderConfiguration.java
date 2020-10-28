// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.azure.eventhub.stream.binder.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.binder.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.microsoft.azure.eventhub.stream.binder.EventHubMessageChannelBinder;
import com.microsoft.azure.eventhub.stream.binder.properties.EventHubExtendedBindingProperties;
import com.microsoft.azure.eventhub.stream.binder.provisioning.EventHubChannelProvisioner;
import com.microsoft.azure.eventhub.stream.binder.provisioning.EventHubChannelResourceManagerProvisioner;
import com.microsoft.azure.management.Azure;
import com.microsoft.azure.spring.cloud.autoconfigure.context.AzureEnvironmentAutoConfiguration;
import com.microsoft.azure.spring.cloud.autoconfigure.eventhub.AzureEventHubAutoConfiguration;
import com.microsoft.azure.spring.cloud.autoconfigure.eventhub.AzureEventHubProperties;
import com.microsoft.azure.spring.cloud.autoconfigure.eventhub.EventHubUtils;
import com.microsoft.azure.spring.cloud.context.core.config.AzureProperties;
import com.microsoft.azure.spring.cloud.context.core.impl.EventHubConsumerGroupManager;
import com.microsoft.azure.spring.cloud.context.core.impl.EventHubManager;
import com.microsoft.azure.spring.cloud.context.core.impl.EventHubNamespaceManager;
import com.microsoft.azure.spring.cloud.telemetry.TelemetryCollector;
import com.microsoft.azure.spring.integration.eventhub.api.EventHubOperation;

/**
 * @author Warren Zhu
 */
@Configuration
@ConditionalOnMissingBean(Binder.class)
@Import({ AzureEventHubAutoConfiguration.class, AzureEnvironmentAutoConfiguration.class })
@EnableConfigurationProperties({ AzureEventHubProperties.class, EventHubExtendedBindingProperties.class })
public class EventHubBinderConfiguration {

    private static final String EVENT_HUB_BINDER = "EventHubBinder";
    private static final String NAMESPACE = "Namespace";

    @Autowired(required = false)
    private EventHubNamespaceManager eventHubNamespaceManager;

    @Autowired(required = false)
    private EventHubManager eventHubManager;

    @Autowired(required = false)
    private EventHubConsumerGroupManager eventHubConsumerGroupManager;

    @PostConstruct
    public void collectTelemetry() {
        TelemetryCollector.getInstance().addService(EVENT_HUB_BINDER);
    }

    @Bean
    @ConditionalOnMissingBean
    public EventHubChannelProvisioner eventHubChannelProvisioner(AzureEventHubProperties eventHubProperties) {
        // TODO: With the previous ResourceManagerProvider architecture, eventHubManager
        // and eventHubConsumerGroup manager were created unconditionally.
        // Now, they are not created at all. Should they be?
        if (eventHubNamespaceManager != null && eventHubManager != null && eventHubConsumerGroupManager != null) {
            return new EventHubChannelResourceManagerProvisioner(eventHubNamespaceManager, eventHubManager,
                    eventHubConsumerGroupManager, eventHubProperties.getNamespace());
        } else {
            String namespace = eventHubProperties.getNamespace() != null ? eventHubProperties.getNamespace()
                    : EventHubUtils.getNamespace(eventHubProperties.getConnectionString());
            TelemetryCollector.getInstance().addProperty(EVENT_HUB_BINDER, NAMESPACE, namespace);
        }

        return new EventHubChannelProvisioner();
    }

    @Bean
    @ConditionalOnMissingBean
    public EventHubMessageChannelBinder eventHubBinder(EventHubChannelProvisioner eventHubChannelProvisioner,
            EventHubOperation eventHubOperation, EventHubExtendedBindingProperties bindingProperties) {
        EventHubMessageChannelBinder binder = new EventHubMessageChannelBinder(null, eventHubChannelProvisioner,
                eventHubOperation);
        binder.setBindingProperties(bindingProperties);
        return binder;
    }

    @Bean
    @ConditionalOnMissingBean
    public EventHubManager eventHubManager(Azure azure, AzureProperties azureProperties) {
        return new EventHubManager(azure, azureProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public EventHubConsumerGroupManager eventHubConsumerGroupManager(Azure azure, AzureProperties azureProperties) {
        return new EventHubConsumerGroupManager(azure, azureProperties);
    }
}
