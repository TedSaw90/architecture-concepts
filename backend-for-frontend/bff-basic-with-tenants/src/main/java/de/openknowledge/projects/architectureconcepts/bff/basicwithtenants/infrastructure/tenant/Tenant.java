/*
 * Copyright (C) open knowledge GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package de.openknowledge.projects.architectureconcepts.bff.basicwithtenants.infrastructure.tenant;

import org.apache.commons.lang3.Validate;

/**
 * A DTO that provides a tenant.
 */
public class Tenant {

  private TenantType tenantType;

  public Tenant() {
    super();
  }

  public Tenant(TenantType tenantType) {
    this();
    this.tenantType = Validate.notNull(tenantType, "tenantType must not be null");
  }

  public TenantType getTenantType() {
    return tenantType;
  }
}
