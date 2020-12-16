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
package de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.application.tenant;

import de.openknowledge.projects.architectureconcepts.bff.basicwithtenantsmultiplebackendservices.infrastructure.qualifier.Current;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * A CDI producer that provides the current {@link Tenant}.
 */
@RequestScoped
public class TenantProducer {

  private Tenant tenant;

  public void observeTenant(@Observes(notifyObserver = Reception.ALWAYS) Tenant tenant) {
    this.tenant = tenant;
  }

  @Produces
  @Current
  @RequestScoped
  public Tenant getTenant() {
    return tenant;
  }
}
