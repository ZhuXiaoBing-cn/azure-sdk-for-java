/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.cdn.v2020_09_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.cdn.v2020_09_01.AFDEndpoints;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.cdn.v2020_09_01.Usage;
import com.microsoft.azure.management.cdn.v2020_09_01.ValidateCustomDomainOutput;
import com.microsoft.azure.management.cdn.v2020_09_01.AfdPurgeParameters;
import com.microsoft.azure.management.cdn.v2020_09_01.AFDEndpoint;

class AFDEndpointsImpl extends WrapperImpl<AFDEndpointsInner> implements AFDEndpoints {
    private final CdnManager manager;

    AFDEndpointsImpl(CdnManager manager) {
        super(manager.inner().aFDEndpoints());
        this.manager = manager;
    }

    public CdnManager manager() {
        return this.manager;
    }

    @Override
    public AFDEndpointImpl define(String name) {
        return wrapModel(name);
    }

    private AFDEndpointImpl wrapModel(AFDEndpointInner inner) {
        return  new AFDEndpointImpl(inner, manager());
    }

    private AFDEndpointImpl wrapModel(String name) {
        return new AFDEndpointImpl(name, this.manager());
    }

    @Override
    public Completable purgeContentAsync(String resourceGroupName, String profileName, String endpointName, AfdPurgeParameters contents) {
        AFDEndpointsInner client = this.inner();
        return client.purgeContentAsync(resourceGroupName, profileName, endpointName, contents).toCompletable();
    }

    @Override
    public Observable<Usage> listResourceUsageAsync(final String resourceGroupName, final String profileName, final String endpointName) {
        AFDEndpointsInner client = this.inner();
        return client.listResourceUsageAsync(resourceGroupName, profileName, endpointName)
        .flatMapIterable(new Func1<Page<UsageInner>, Iterable<UsageInner>>() {
            @Override
            public Iterable<UsageInner> call(Page<UsageInner> page) {
                return page.items();
            }
        })
        .map(new Func1<UsageInner, Usage>() {
            @Override
            public Usage call(UsageInner inner) {
                return new UsageImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<ValidateCustomDomainOutput> validateCustomDomainAsync(String resourceGroupName, String profileName, String endpointName, String hostName) {
        AFDEndpointsInner client = this.inner();
        return client.validateCustomDomainAsync(resourceGroupName, profileName, endpointName, hostName)
        .map(new Func1<ValidateCustomDomainOutputInner, ValidateCustomDomainOutput>() {
            @Override
            public ValidateCustomDomainOutput call(ValidateCustomDomainOutputInner inner) {
                return new ValidateCustomDomainOutputImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<AFDEndpoint> listByProfileAsync(final String resourceGroupName, final String profileName) {
        AFDEndpointsInner client = this.inner();
        return client.listByProfileAsync(resourceGroupName, profileName)
        .flatMapIterable(new Func1<Page<AFDEndpointInner>, Iterable<AFDEndpointInner>>() {
            @Override
            public Iterable<AFDEndpointInner> call(Page<AFDEndpointInner> page) {
                return page.items();
            }
        })
        .map(new Func1<AFDEndpointInner, AFDEndpoint>() {
            @Override
            public AFDEndpoint call(AFDEndpointInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<AFDEndpoint> getAsync(String resourceGroupName, String profileName, String endpointName) {
        AFDEndpointsInner client = this.inner();
        return client.getAsync(resourceGroupName, profileName, endpointName)
        .flatMap(new Func1<AFDEndpointInner, Observable<AFDEndpoint>>() {
            @Override
            public Observable<AFDEndpoint> call(AFDEndpointInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((AFDEndpoint)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String profileName, String endpointName) {
        AFDEndpointsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, profileName, endpointName).toCompletable();
    }

}
