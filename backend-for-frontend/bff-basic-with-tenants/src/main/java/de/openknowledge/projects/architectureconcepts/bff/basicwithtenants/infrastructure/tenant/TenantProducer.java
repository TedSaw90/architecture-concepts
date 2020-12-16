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

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * A CDI producer that provides a {@link Tenant} with the {@link TenantType} specified in the {@link TenantQualifier} qualifier.
 */
@ApplicationScoped
public class TenantProducer {

  @Produces
  @RequestScoped
  public Tenant getTenant(final InjectionPoint injectionPoint) {
    Annotated annotated = injectionPoint.getAnnotated();
    TenantQualifier tenantQualifier = annotated.getAnnotation(TenantQualifier.class);
    TenantType tenantType = tenantQualifier.value();
    return new Tenant(tenantType);
  }
}
