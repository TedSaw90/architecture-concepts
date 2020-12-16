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
package de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.offer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * A resource that provides access to vehicle insurance offers for tenant {@link TenantType#TENANT_1}.
 */
@Path("/tenant1/offers")
public class Tenant1VehicleInsuranceOfferResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(Tenant1VehicleInsuranceOfferResource.class);

  @Inject
  private VehicleInsuranceOfferService service;

  @POST
  public Response tariff(final OfferRequestDTO offerRequest) {
    LOGGER.info("Tariff vehicle insurance offer");

    OfferResponseDTO offerResponse = service.tariff(offerRequest);

    LOGGER.info("Offer created");

    return Response.status(Response.Status.CREATED).entity(offerResponse).build();
  }
}
