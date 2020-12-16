package de.openknowledge.projects.architectureconcepts.bff.basic.api.implementations;

import de.openknowledge.projects.architectureconcepts.bff.basic.api.implementations.host.OfferClient;
import de.openknowledge.projects.architectureconcepts.bff.basic.api.implementations.host.OfferClientRequestDTO;
import de.openknowledge.projects.architectureconcepts.bff.basic.api.implementations.host.OfferClientResponseDTO;
import de.openknowledge.projects.architectureconcepts.bff.basic.api.interfaces.VehicleInsuranceOfferService;
import de.openknowledge.projects.architectureconcepts.bff.basic.api.interfaces.model.OfferServiceRequestDTO;
import de.openknowledge.projects.architectureconcepts.bff.basic.api.interfaces.model.OfferServiceResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

public class VehicleInsuranceOfferServiceImpl implements VehicleInsuranceOfferService {

  private static final Logger LOGGER = LoggerFactory.getLogger(VehicleInsuranceOfferService.class);

  private OfferClient client;

  @Override
  public OfferServiceResponseDTO tariff(final OfferServiceRequestDTO offerRequest) {
    LOGGER.debug("Tariff vehicle insurance");

    OfferClientRequestDTO offerClientRequest = mapRequest(offerRequest);

    LOGGER.info("Request vehicle insurance offer from backend service");

    Response response = client.tariff(offerClientRequest);

    LOGGER.info("Vehicle insurance offer received from backend service");

    OfferClientResponseDTO offerClientResponse = (OfferClientResponseDTO) response.getEntity();
    OfferServiceResponseDTO offerResponse = mapResponse(offerClientResponse);

    LOGGER.debug("Offer created");

    return offerResponse;
  }

  private OfferClientRequestDTO mapRequest(final OfferServiceRequestDTO offerRequest) {
    // TODO map request to client request
    return new OfferClientRequestDTO();
  }

  private OfferServiceResponseDTO mapResponse(final OfferClientResponseDTO offerClientResponse) {
    // TODO map client response to response
    return new OfferServiceResponseDTO();
  }
}
