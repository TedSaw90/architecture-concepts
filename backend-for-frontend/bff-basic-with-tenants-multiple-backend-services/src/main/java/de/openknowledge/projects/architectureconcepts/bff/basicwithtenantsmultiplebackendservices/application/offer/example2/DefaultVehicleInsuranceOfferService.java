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
package de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.offer.example2;

import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.backendservice1.Backend1OfferClient;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.backendservice1.Backend1OfferClientRequestDTO;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.backendservice1.Backend1OfferClientResponseDTO;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.offer.OfferRequestDTO;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.offer.OfferResponseDTO;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.infrastructure.qualifier.Current;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.infrastructure.stereotypes.ApplicationService;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.tenant.Tenant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * Service implementation for tenant {@link TenantType#TENANT_1}.
 */
@ApplicationService
@ApplicationScoped
public class DefaultVehicleInsuranceOfferService implements VehicleInsuranceOfferService {

  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultVehicleInsuranceOfferService.class);

  @Inject
  @Current
  private Tenant tenant;

  @Inject
  private Backend1OfferClient client;

  public OfferResponseDTO tariff(final OfferRequestDTO offerRequest) {
    LOGGER.debug("Tariff vehicle insurance");

    Backend1OfferClientRequestDTO offerClientRequest = mapRequest(offerRequest, tenant);

    LOGGER.info("Request vehicle insurance offer from backend service 1");

    Response response = client.tariff(offerClientRequest);

    LOGGER.info("Vehicle insurance offer received from backend service 1");

    Backend1OfferClientResponseDTO offerClientResponse = (Backend1OfferClientResponseDTO) response.getEntity();
    OfferResponseDTO offerResponse = mapResponse(offerClientResponse);

    LOGGER.debug("Offer created");

    return offerResponse;
  }

  private Backend1OfferClientRequestDTO mapRequest(final OfferRequestDTO offerRequest, final Tenant tenant) {
    // TODO map request to client request
    return new Backend1OfferClientRequestDTO();
  }

  private OfferResponseDTO mapResponse(final Backend1OfferClientResponseDTO offerClientResponse) {
    // TODO map client response to response
    return new OfferResponseDTO();
  }
}
