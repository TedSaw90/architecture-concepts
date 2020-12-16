package de.openknowledge.projects.architectureconcepts.bff.basic.api.application.offer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * A resource that provides access to offers for vehicle insurance.
 */
@Path("/offers")
public class VehicleInsuranceOfferResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(VehicleInsuranceOfferResource.class);

  @POST
  public Response tariff(final OfferRequestDTO offerRequest) {
    LOGGER.info("Tariff vehicle insurance offer");
    //todo use api from other module
    LOGGER.info("Offer created");

    return Response.status(Response.Status.CREATED).build();

    //todo use response from api
    //return Response.status(Response.Status.CREATED).entity(offerResponse).build();
  }
}
