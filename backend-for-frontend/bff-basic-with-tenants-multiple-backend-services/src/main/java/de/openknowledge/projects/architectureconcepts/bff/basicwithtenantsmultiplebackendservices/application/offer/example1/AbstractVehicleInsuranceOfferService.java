package de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.offer.example1;

import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.offer.OfferRequestDTO;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.offer.OfferResponseDTO;
import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.tenant.Tenant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

public abstract class AbstractVehicleInsuranceOfferService<REQ, RES> implements VehicleInsuranceOfferService {

  private static final Logger LOGGER = LoggerFactory.getLogger(Tenant1VehicleInsuranceOfferService.class);

  private Tenant tenant;

  public AbstractVehicleInsuranceOfferService() {
    super();
  }

  public AbstractVehicleInsuranceOfferService(final Tenant tenant) {
    this();
    this.tenant = tenant;
  }

  public OfferResponseDTO tariff(final OfferRequestDTO offerRequest) {
    LOGGER.debug("Tariff vehicle insurance");

    REQ offerClientRequest = mapRequest(offerRequest, tenant);

    LOGGER.info("Request vehicle insurance offer from backend service 1");

    Response response = getTariff(offerClientRequest);

    LOGGER.info("Vehicle insurance offer received from backend service 1");

    RES offerClientResponse = (RES) response.getEntity();
    OfferResponseDTO offerResponse = mapResponse(offerClientResponse);

    LOGGER.debug("Offer created");

    return offerResponse;
  }

  protected abstract Response getTariff(REQ offerClientRequest);

  protected abstract REQ mapRequest(final OfferRequestDTO offerRequest, final Tenant tenant);

  protected abstract OfferResponseDTO mapResponse(final RES offerClientResponse);
}
