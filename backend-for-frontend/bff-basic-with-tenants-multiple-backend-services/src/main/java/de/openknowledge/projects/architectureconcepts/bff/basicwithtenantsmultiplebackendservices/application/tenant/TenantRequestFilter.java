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
package de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.tenant;

import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.infrastructure.qualifier.Current;

import java.io.IOException;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

/**
 * A JAX-RS request filter that extracts the tenant from the URI and provides it to the application.
 */
public class TenantRequestFilter implements ClientRequestFilter {

  @Inject
  @Current
  private Event<Tenant> event;

  @Override
  public void filter(ClientRequestContext requestContext) {
    String path = requestContext.getUri().getPath();
    String tenant = extractTenantFromPath(path);
    TenantType tenantType = TenantType.valueOf(tenant);
    event.fire(new Tenant(tenantType));
  }

  private String extractTenantFromPath(String path) {
    // TODO extract tenant from path
    return "";
  }
}
