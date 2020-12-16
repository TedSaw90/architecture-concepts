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

import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.backendservice2.Backend2OfferClient;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.backendservice2.Backend2OfferClientRequestDTO;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.backendservice2.Backend2OfferClientResponseDTO;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.offer.OfferRequestDTO;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.offer.OfferResponseDTO;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.infrastructure.qualifier.Current;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.infrastructure.stereotypes.ApplicationService;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.tenant.Tenant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * Service implementation for tenant {@link TenantType#TENANT_2}.
 */
@ApplicationService
@ApplicationScoped
public class Tenant2VehicleInsuranceOfferService extends AbstractVehicleInsuranceOfferService<Backend2OfferClientRequestDTO, Backend2OfferClientResponseDTO> {

  private Backend2OfferClient client;

  public Tenant2VehicleInsuranceOfferService() {
    super();
  }

  @Inject
  public Tenant2VehicleInsuranceOfferService(@Current Tenant tenant, Backend2OfferClient client) {
    super(tenant);
    this.client = client;
  }

  @Override
  protected Response getTariff(Backend2OfferClientRequestDTO offerClientRequest) {
    return client.tariff(offerClientRequest);
  }

  @Override
  protected Backend2OfferClientRequestDTO mapRequest(final OfferRequestDTO offerRequest, final Tenant tenant) {
    // TODO map request to client request
    return new Backend2OfferClientRequestDTO();
  }

  @Override
  protected OfferResponseDTO mapResponse(final Backend2OfferClientResponseDTO offerClientResponse) {
    // TODO map client response to response
    return new OfferResponseDTO();
  }
}
