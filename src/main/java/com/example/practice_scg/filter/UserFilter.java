package com.example.practice_scg.filter;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserFilter extends AbstractGatewayFilterFactory<com.example.practice_scg.filter.GlobalFilter.Config> {
    private static final Logger logger = LogManager.getLogger(com.example.practice_scg.filter.GlobalFilter.class);

    public UserFilter() {
        super(com.example.practice_scg.filter.GlobalFilter.Config.class);
    }

    @Override
    public GatewayFilter apply(com.example.practice_scg.filter.GlobalFilter.Config config) {
        return ((exchange, chain) -> {
            logger.info("UserFilter baseMessage>>>>>>" + config.getBaseMessage());
            if (config.isPreLogger()) {
                logger.info("UserFilter Start>>>>>>" + exchange.getRequest());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                if (config.isPostLogger()) {
                    logger.info("UserFilter End>>>>>>" + exchange.getResponse());
                }
            }));
        });
    }

    @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}