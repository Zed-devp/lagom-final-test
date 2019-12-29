package com.example.finaltest.zheng_project.serviceC.impl;

import static java.util.concurrent.CompletableFuture.completedFuture;

import com.example.finaltest.zheng_project.serviceC.api.ServiceCService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;

/**
 * Implementation of the ServiceCService.
 */
public class ServiceCServiceImpl implements ServiceCService {

    @Override
    public ServiceCall<NotUsed, Integer> get() {
        return request -> {
            return completedFuture(3);
        };
    }
}
