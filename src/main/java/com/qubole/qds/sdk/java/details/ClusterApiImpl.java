package com.qubole.qds.sdk.java.details;

import com.qubole.qds.sdk.java.api.ClusterApi;
import com.qubole.qds.sdk.java.api.ClusterStatusBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;

class ClusterApiImpl implements ClusterApi
{
    private final QdsClient client;

    @Override
    public ClusterStatusBuilder status()
    {
        return new ClusterStatusBuilderImpl(client);
    }

    ClusterApiImpl(QdsClient client)
    {
        this.client = client;
    }
}
