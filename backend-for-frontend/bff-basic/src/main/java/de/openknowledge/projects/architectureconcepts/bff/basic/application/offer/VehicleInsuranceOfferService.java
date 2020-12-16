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
package de.openknowledge.projects.architectureconcepts.bff.basic.application.offer;

import de.openknowledge.projects.architectureconcepts.bff.basic.application.backendservice.OfferClient;
import de.openknowledge.projects.architectureconcepts.bff.basic.application.backendservice.OfferClientRequestDTO;
import de.openknowledge.projects.architectureconcepts.bff.basic.application.backendservice.OfferClientResponseDTO;
import de.openknowledge.projects.architectureconcepts.bff.basic.infrastructure.stereotypes.ApplicationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * A service that provides functionality for vehicle insurance offers.
 */
@ApplicationService
public class VehicleInsuranceOfferService {

  private static final Logger LOGGER = LoggerFactory.getLogger(VehicleInsuranceOfferService.class);

  @Inject
  private OfferClient client;

  public OfferResponseDTO tariff(final OfferRequestDTO offerRequest) {
    LOGGER.debug("Tariff vehicle insurance");

    OfferClientRequestDTO offerClientRequest = mapRequest(offerRequest);

    LOGGER.info("Request vehicle insurance offer from backend service");

    Response response = client.tariff(offerClientRequest);

    LOGGER.info("Vehicle insurance offer received from backend service");

    OfferClientResponseDTO offerClientResponse = (OfferClientResponseDTO) response.getEntity();
    OfferResponseDTO offerResponse = mapResponse(offerClientResponse);

    LOGGER.debug("Offer created");

    return offerResponse;
  }

  private OfferClientRequestDTO mapRequest(final OfferRequestDTO offerRequest) {
    // TODO map request to client request
    return new OfferClientRequestDTO();
  }

  private OfferResponseDTO mapResponse(final OfferClientResponseDTO offerClientResponse) {
    // TODO map client response to response
    return new OfferResponseDTO();
  }
}
