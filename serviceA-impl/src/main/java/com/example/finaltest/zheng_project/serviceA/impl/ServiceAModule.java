package com.example.finaltest.zheng_project.serviceA.impl;

import com.example.finaltest.zheng_project.serviceA.api.ServiceAService;
import com.example.finaltest.zheng_project.serviceB.api.ServiceBService;
import com.example.finaltest.zheng_project.serviceC.api.ServiceCService;
import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.client.ServiceClientGuiceSupport;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;


/**
 * The module that binds the ServiceAService so that it can be served.
 */
public class ServiceAModule extends AbstractModule implements ServiceGuiceSupport, ServiceClientGuiceSupport {
  @Override
  protected void configure() {
    bindService(ServiceAService.class, ServiceAServiceImpl.class);
    bindClient(ServiceBService.class);
    bindClient(ServiceCService.class);
  }
}
