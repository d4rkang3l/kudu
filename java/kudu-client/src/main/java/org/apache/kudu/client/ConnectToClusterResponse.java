// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.kudu.client;

import org.apache.kudu.annotations.InterfaceAudience;
import org.apache.kudu.consensus.Metadata;
import org.apache.kudu.master.Master;

/**
 * Response for {@link ConnectToMasterRequest}.
 */
@InterfaceAudience.Private
public class ConnectToClusterResponse extends KuduRpcResponse {

  private final Metadata.RaftPeerPB.Role role;

  /**
   * Describes a response to a {@link ConnectToMasterRequest}, built from
   * {@link Master.GetMasterRegistrationResponsePB}.
   *
   * @param role Master's role in the config.
   */
  public ConnectToClusterResponse(long elapsedMillis, String tsUUID,
                                  Metadata.RaftPeerPB.Role role) {
    super(elapsedMillis, tsUUID);
    this.role = role;
  }

  /**
   * Returns this master's role in the config.
   *
   * @see Metadata.RaftPeerPB.Role
   * @return Node's role in the cluster, or FOLLOWER if the node is not initialized.
   */
  public Metadata.RaftPeerPB.Role getRole() {
    return role;
  }

  @Override
  public String toString() {
    return "GetMasterRegistrationResponse{" +
        "role=" + role +
        '}';
  }
}
