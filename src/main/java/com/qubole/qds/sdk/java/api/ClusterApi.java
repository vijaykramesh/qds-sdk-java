/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.ClusterItem;
import com.qubole.qds.sdk.java.entities.ClusterMetrics;
import com.qubole.qds.sdk.java.entities.ClusterState;
import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.Message;

import java.util.List;

/**
 * Corresponds to http://www.qubole.com/docs/documentation/cluster-api/
 */
public interface ClusterApi
{
    /**
     * Corresponds to http://www.qubole.com/docs/list-clusters/
     *
     * @return new builder
     */
    public InvokableBuilder<List<ClusterItem>> list();

    /**
     * Corresponds to http://www.qubole.com/docs/get-cluster-state/
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public InvokableBuilder<ClusterState> state(String labelOrId);

    /**
     * Corresponds to http://docs.qubole.com/en/latest/rest-api/cluster_api/metrics-cluster.html
     *
     * @param labelOrId the Cluster label/id
     * @param metrics metric to monitor.
     * @param hostname hostname for which metric values are required.
     * @param interval interval for which the metric values are required.
     * @return new builder
     */
    public InvokableBuilder<ClusterMetrics> metrics(String labelOrId, String metrics, String hostname, String interval);

    /**
     * Corresponds to http://www.qubole.com/docs/get-cluster-information/
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public InvokableBuilder<ClusterItem> information(String labelOrId);

    /**
     * Corresponds to http://www.qubole.com/docs/start-terminate-cluster/ for "start"
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public InvokableBuilder<Message> start(String labelOrId);

    /**
     * Corresponds to http://www.qubole.com/docs/start-terminate-cluster/ for "terminate"
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public InvokableBuilder<Message> terminate(String labelOrId);

    /**
     * Corresponds to http://www.qubole.com/docs/edit-cluster/
     *
     * @param labelOrId the Cluster label/id
     * @param configBuilder config values - use {@link #clusterConfig()}
     * @return new builder
     */
    public InvokableBuilder<ClusterItem> edit(String labelOrId, ClusterConfigBuilder configBuilder);

    /**
     * Corresponds to http://www.qubole.com/docs/create-new-cluster/
     *
     * @param configBuilder config values - use {@link #clusterConfig()}
     * @return new builder
     */
    public InvokableBuilder<ClusterItem> create(ClusterConfigBuilder configBuilder);

    /**
     * Corresponds to http://www.qubole.com/docs/delete-cluster/
     *
     * @param labelOrId the Cluster label/id
     * @return new builder
     */
    public InvokableBuilder<ClusterItem> delete(String labelOrId);

    /**
     * Corresponds to http://docs.qubole.com/en/latest/rest-api/cluster_api/add-node.html
     *
     * @param labelOrId the Cluster label/id
     * @param node_count the number of nodes to add
     * @return new builder
     */
    public InvokableBuilder<Command> add_nodes(String labelOrId, int node_count);

    /**
     * Corresponds to http://docs.qubole.com/en/latest/rest-api/cluster_api/replace-node.html
     *
     * @param labelOrId the Cluster label/id
     * @param private_dns the dns of slave to replace
     * @return new builder
     */
    public InvokableBuilder<Command> replace_node(String labelOrId, String private_dns);

    /**
     * Corresponds to http://docs.qubole.com/en/latest/rest-api/cluster_api/remove-node.html
     *
     * @param labelOrId the Cluster label/id
     * @param private_dns the dns of slave to remove
     * @return new builder
     */
    public InvokableBuilder<Command> remove_node(String labelOrId, String private_dns);

    /**
     * Corresponds to cloning cluster under http://docs.qubole.com/en/latest/rest-api/cluster_api/clone-cluster.html
     *
     * @param labelOrId the Cluster label/id
     * @param configBuilder config values - use {@link #clusterConfig()}
     * @return new builder
     */
    public InvokableBuilder<ClusterItem> clone(String labelOrId, ClusterConfigBuilder configBuilder);

    /**
     * Return a new cluster config builder. Can be used with
     * apis such as {@link ClusterApi#edit(String, ClusterConfigBuilder)}
     *
     * @return builder
     */
    public ClusterConfigBuilder clusterConfig();
}
