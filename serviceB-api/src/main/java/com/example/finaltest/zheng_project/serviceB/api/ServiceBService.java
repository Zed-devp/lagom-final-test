package com.example.finaltest.zheng_project.serviceB.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;


public interface ServiceBService extends Service {

  ServiceCall<NotUsed, Long> getpow();

  @Override
  default Descriptor descriptor() {
    // @formatter:off
    return named("serviceB").withCalls(
        pathCall("/api/service/b/getpow",  this::getpow)
      ).withAutoAcl(true);
    // @formatter:on
  }
}
