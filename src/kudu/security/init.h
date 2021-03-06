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
#pragma once

#include "kudu/util/status.h"

namespace kudu {

class RWMutex;

namespace security {

// Initializes Kerberos for a server. In particular, this processes
// the '--keytab' command line flag.
Status InitKerberosForServer();

// Returns the process lock 'kerberos_reinit_lock'
// This lock is acquired in write mode while the ticket is being renewed, and
// acquired in read mode before using the SASL library which might require a ticket.
RWMutex* KerberosReinitLock();

} // namespace security
} // namespace kudu
