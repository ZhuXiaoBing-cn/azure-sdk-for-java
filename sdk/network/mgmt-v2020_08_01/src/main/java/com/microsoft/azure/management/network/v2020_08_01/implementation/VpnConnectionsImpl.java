/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.network.v2020_08_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.network.v2020_08_01.VpnConnections;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.network.v2020_08_01.VpnConnection;

class VpnConnectionsImpl extends WrapperImpl<VpnConnectionsInner> implements VpnConnections {
    private final NetworkManager manager;

    VpnConnectionsImpl(NetworkManager manager) {
        super(manager.inner().vpnConnections());
        this.manager = manager;
    }

    public NetworkManager manager() {
        return this.manager;
    }

    @Override
    public VpnConnectionImpl define(String name) {
        return wrapModel(name);
    }

    private VpnConnectionImpl wrapModel(VpnConnectionInner inner) {
        return  new VpnConnectionImpl(inner, manager());
    }

    private VpnConnectionImpl wrapModel(String name) {
        return new VpnConnectionImpl(name, this.manager());
    }

    @Override
    public Observable<String> startPacketCaptureAsync(String resourceGroupName, String gatewayName, String vpnConnectionName) {
        VpnConnectionsInner client = this.inner();
        return client.startPacketCaptureAsync(resourceGroupName, gatewayName, vpnConnectionName)
    ;}

    @Override
    public Observable<String> stopPacketCaptureAsync(String resourceGroupName, String gatewayName, String vpnConnectionName) {
        VpnConnectionsInner client = this.inner();
        return client.stopPacketCaptureAsync(resourceGroupName, gatewayName, vpnConnectionName)
    ;}

    @Override
    public Observable<VpnConnection> listByVpnGatewayAsync(final String resourceGroupName, final String gatewayName) {
        VpnConnectionsInner client = this.inner();
        return client.listByVpnGatewayAsync(resourceGroupName, gatewayName)
        .flatMapIterable(new Func1<Page<VpnConnectionInner>, Iterable<VpnConnectionInner>>() {
            @Override
            public Iterable<VpnConnectionInner> call(Page<VpnConnectionInner> page) {
                return page.items();
            }
        })
        .map(new Func1<VpnConnectionInner, VpnConnection>() {
            @Override
            public VpnConnection call(VpnConnectionInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<VpnConnection> getAsync(String resourceGroupName, String gatewayName, String connectionName) {
        VpnConnectionsInner client = this.inner();
        return client.getAsync(resourceGroupName, gatewayName, connectionName)
        .flatMap(new Func1<VpnConnectionInner, Observable<VpnConnection>>() {
            @Override
            public Observable<VpnConnection> call(VpnConnectionInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((VpnConnection)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String gatewayName, String connectionName) {
        VpnConnectionsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, gatewayName, connectionName).toCompletable();
    }

}
