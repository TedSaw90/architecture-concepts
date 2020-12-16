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
package de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.offer.example1;

import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.tenant.Tenant;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.infrastructure.qualifier.Current;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * A CDI producer that provides a service implementation of the {@link de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.offer.VehicleInsuranceOfferService} for the current {@link Tenant}.
 */
@ApplicationScoped
public class VehicleInsuranceOfferServiceProducer {

  @Inject
  private Instance<VehicleInsuranceOfferService> instance;

  @Produces
  public VehicleInsuranceOfferService produceService(final @Current Tenant tenant) {
    switch (tenant.getTenantType()) {
      case TENANT_1: return instance.select(Tenant1VehicleInsuranceOfferService.class).get();
      case TENANT_2: return instance.select(Tenant2VehicleInsuranceOfferService.class).get();
    }

    throw new IllegalStateException("Invalid tenantType");
  }
}
