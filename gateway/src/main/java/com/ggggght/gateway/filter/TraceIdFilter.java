package com.ggggght.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class TraceIdFilter extends AbstractGatewayFilterFactory<TraceIdFilter.Config> {
    Logger log = LoggerFactory.getLogger(TraceIdFilter.class);

    public TraceIdFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // 获取请求头中的 Trace ID
            String traceId = exchange.getRequest().getHeaders().getFirst("traceId");

            log.info("traceId: {}", traceId);
            // 添加 Trace ID 到转发请求头中
            return chain.filter(exchange.mutate()
                    .request(exchange.getRequest().mutate()
                            .header("traceid", traceId)
                            .build())
                    .build());
        };
    }

    public static class Config {
        // 可以在需要的情况下添加一些配置参数
    }
}
