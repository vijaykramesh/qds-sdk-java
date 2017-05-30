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

import com.qubole.qds.sdk.java.entities.Notebook;;

/**
 * Corresponds to http://docs.qubole.com/en/latest/rest-api/notebook_api/index.html
 */
public interface NotebookAPI
{
    /**
    * Corresponds to http://docs.qubole.com/en/latest/rest-api/notebook_api/create-notebook.html
    *
    * @param name name of the notebook
    * @param location location of the notebook
    * @param note_type type of the notebook, available are "spark" and "presto"
    * @param cluster_id cluster id of the cluster to associate notebook with
    * @return new builder
    */
    public InvokableBuilder<Notebook> create(String name, String location, String note_type, String cluster_id);

    /**
    * Corresponds to http://docs.qubole.com/en/latest/rest-api/notebook_api/configure-notebook.html
    *
    * @param name name of the notebook
    * @param location location of the notebook
    * @param cluster_id cluster id of the cluster to associate notebook with
    * @param notebook_id notebook id to configure
    * @return new builder
    */
    public InvokableBuilder<Notebook> configure(String name, String location, String cluster_id, String notebook_id);

    /**
     * Corresponds to http://docs.qubole.com/en/latest/rest-api/notebook_api/clone-notebook.html
     *
     * @param name name of the notebook
     * @param location location of the notebook
     * @param cluster_id cluster id of the cluster to associate notebook with
     * @param cloned_from_notebook notebook id from which the new notebook is cloned
     * @return new builder
     */
     public InvokableBuilder<Notebook> clone(String name, String location, String cluster_id, String cloned_from_notebook);

     /**
      * Corresponds to http://docs.qubole.com/en/latest/rest-api/notebook_api/bind-notebook.html
      * @param cluster_id cluster id of the cluster who needs to be associated with notebook
      * @param notebook_id notebook id
      * @return new builder
      */
      public InvokableBuilder<Notebook> bind_notebook_to_cluster(String cluster_id, String notebook_id);

       /**
        * Corresponds to http://docs.qubole.com/en/latest/rest-api/notebook_api/delete-notebook.html
        * @param notebook_id notebook id
        * @return new builder
        */
        public InvokableBuilder<Notebook> delete(String notebook_id);
}