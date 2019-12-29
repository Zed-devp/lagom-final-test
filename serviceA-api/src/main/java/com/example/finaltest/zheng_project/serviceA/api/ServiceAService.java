package com.example.finaltest.zheng_project.serviceA.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;

public interface ServiceAService extends Service {

	ServiceCall<NotUsed, Long> sum();

	@Override
	default Descriptor descriptor() {
		// @formatter:off
		return named("serviceA").withCalls(pathCall("/api/service/a/sum", this::sum)
		).withAutoAcl(true);
		// @formatter:on
	}
}
