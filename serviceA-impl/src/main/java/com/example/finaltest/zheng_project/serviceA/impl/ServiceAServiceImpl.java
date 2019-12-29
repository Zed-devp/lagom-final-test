package com.example.finaltest.zheng_project.serviceA.impl;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import com.example.finaltest.zheng_project.serviceA.api.ServiceAService;
import com.example.finaltest.zheng_project.serviceB.api.ServiceBService;
import com.example.finaltest.zheng_project.serviceC.api.ServiceCService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;

/**
 * Implementation of the ServiceAService.
 */
public class ServiceAServiceImpl implements ServiceAService {

    private final ServiceBService serviceBService;
    private final ServiceCService serviceCService;

    @Inject
    public ServiceAServiceImpl(ServiceBService serviceBService, ServiceCService serviceCService) {
        this.serviceCService = serviceCService;
		this.serviceBService = serviceBService;
    }
    
    @Override
    public ServiceCall<NotUsed, Long> sum() {
        return msg -> {
            CompletionStage<Long> responseB = serviceBService.getpow().invoke(NotUsed.getInstance());
            CompletionStage<Integer> responseC = serviceCService.get().invoke(NotUsed.getInstance());
            return responseB.thenCompose(b -> responseC.thenApply(c -> (b + c)));
        };
    }

}
