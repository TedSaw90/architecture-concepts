package de.openknowledge.projects.architectureconcepts.bff.basic.api.implementations.host;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/xyz")
public interface OfferClient {

  @POST
  Response tariff(OfferClientRequestDTO offerClientRequest);
}
