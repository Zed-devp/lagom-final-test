package com.example.finaltest.zheng_project.serviceB.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.client.ServiceClientGuiceSupport;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import com.example.finaltest.zheng_project.serviceB.api.ServiceBService;
import com.example.finaltest.zheng_project.serviceC.api.ServiceCService;

public class ServiceBModule extends AbstractModule implements ServiceGuiceSupport, ServiceClientGuiceSupport {
  @Override
  protected void configure() {
    bindService(ServiceBService.class, ServiceBServiceImpl.class);
    bindClient(ServiceCService.class);
  }
}
