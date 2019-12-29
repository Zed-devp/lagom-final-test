package com.example.finaltest.zheng_project.serviceC.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;

/**
 * The ServiceC service interface.
 * <p>
 * This describes everything that Lagom needs to know about how to serve and
 * consume the ServiceC.
 */
public interface ServiceCService extends Service {


  ServiceCall<NotUsed, Integer> get();

  @Override
  default Descriptor descriptor() {
    // @formatter:off
    return named("serviceC").withCalls(
        pathCall("/api/service/c/get",  this::get)
      ).withAutoAcl(true);
    // @formatter:on
  }
}
