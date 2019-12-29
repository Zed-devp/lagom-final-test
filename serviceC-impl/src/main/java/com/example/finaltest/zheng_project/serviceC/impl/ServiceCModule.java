package com.example.finaltest.zheng_project.serviceC.impl;

import com.example.finaltest.zheng_project.serviceC.api.ServiceCService;
import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

/**
 * The module that binds the ServiceCService so that it can be served.
 */
public class ServiceCModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {
    bindService(ServiceCService.class, ServiceCServiceImpl.class);
  }
}
