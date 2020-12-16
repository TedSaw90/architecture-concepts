package de.openknowledge.projects.architectureconcepts.bff.basic.api.interfaces;

import de.openknowledge.projects.architectureconcepts.bff.basic.api.interfaces.model.OfferServiceRequestDTO;
import de.openknowledge.projects.architectureconcepts.bff.basic.api.interfaces.model.OfferServiceResponseDTO;

public interface VehicleInsuranceOfferService {
  OfferServiceResponseDTO tariff(final OfferServiceRequestDTO offerRequest);
}
