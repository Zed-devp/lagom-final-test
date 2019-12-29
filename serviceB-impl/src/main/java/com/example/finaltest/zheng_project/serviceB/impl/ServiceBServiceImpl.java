package com.example.finaltest.zheng_project.serviceB.impl;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import com.example.finaltest.zheng_project.serviceB.api.ServiceBService;
import com.example.finaltest.zheng_project.serviceC.api.ServiceCService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;


public class ServiceBServiceImpl implements ServiceBService {

    private final ServiceCService serviceCService;

    @Inject
    public ServiceBServiceImpl(ServiceCService serviceCService) {
        this.serviceCService = serviceCService;
    }
    
    private static Long convertToLong(final int a) {
        return (long) (a*a);
    }

    @Override
    public ServiceCall<NotUsed, Long> getpow() {
        return msg -> {
            CompletionStage<Integer> response = serviceCService.get().invoke(NotUsed.getInstance());
            return response.thenApply(answer -> convertToLong(answer));
        };
    }
}
