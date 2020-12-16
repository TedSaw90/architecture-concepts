package de.openknowledge.projects.architectureconcepts.bff.basic.api.application.offer;

import de.openknowledge.projects.architectureconcepts.bff.basic.api.implementations.VehicleInsuranceOfferServiceImpl;
import de.openknowledge.projects.architectureconcepts.bff.basic.api.interfaces.VehicleInsuranceOfferService;
import de.openknowledge.projects.architectureconcepts.bff.basic.api.interfaces.model.OfferServiceRequestDTO;
import de.openknowledge.projects.architectureconcepts.bff.basic.api.interfaces.model.OfferServiceResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * A resource that provides access to offers for vehicle insurance.
 */
@Path("/offers")
public class VehicleInsuranceOfferResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(VehicleInsuranceOfferResource.class);

  @Inject
  VehicleInsuranceOfferService offerService;

  @POST
  public Response tariff(final OfferRequestDTO offerRequestDTO) {
    LOGGER.info("Tariff vehicle insurance offer");
    OfferServiceRequestDTO offerServiceRequestDTO = mapOfferRequest(offerRequestDTO);
    OfferServiceResponseDTO offerServiceResponseDTO = offerService.tariff(offerServiceRequestDTO);
    LOGGER.info("Offer created");
    // What if ServiceResponse doesn't match FE Response? todo Another Mapping is needed.
    return Response.status(Response.Status.CREATED).entity(offerServiceResponseDTO).build();
  }

  private OfferServiceRequestDTO mapOfferRequest(final OfferRequestDTO offerRequestDTO) {
    //todo map FE DTO to API DTO
    return new OfferServiceRequestDTO();
  }
}
