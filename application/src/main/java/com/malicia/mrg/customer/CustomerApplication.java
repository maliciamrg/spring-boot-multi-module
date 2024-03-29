package com.malicia.mrg.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StringUtils;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories(basePackages = "com.malicia.mrg.customer.*")
@EntityScan(basePackages = "com.malicia.mrg.customer.*")
@ComponentScan(basePackages = "com.malicia.mrg.customer.*")
public class CustomerApplication {

    public static final String HTTP_DEFAULT_PORT = "8080";
    private static final Logger logger = LoggerFactory.getLogger(CustomerApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        final Environment env = SpringApplication.run(CustomerApplication.class, args).getEnvironment();
        logApplicationStartup(env);

        logger.trace("---==[ trace  ]==---");
        logger.debug("---==[ debug ]==---");
        logger.info("---==[  info   ]==---");
        logger.warn("---==[  warn   ]==---");
        logger.error("---==[ error  ]==---");
        logger.info("Start");

        logger.info("CustomerApplication Started........");
    }

    private static void logApplicationStartup(Environment env) throws UnknownHostException {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        final String serverPort = Optional.ofNullable(env.getProperty("server.port")).orElse(HTTP_DEFAULT_PORT);
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isEmpty(contextPath)) {
            contextPath = "/";
        }
        final String hosttAddress = InetAddress.getLocalHost().getHostAddress();
        final String ipOutsideDocker = env.getProperty("spring.ipOutsideDocker");
        logger.info("\n---------------------------------------------------------------\n\t" +
                        "Application '{} ({})' is running!\n\tAccess URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Ip for Testing: \t{}\t (manual)\n\t" +
                        "Profile(s): \t{}\n\t" +
                        "---------------------------------------------------------------\n\t"+
                        "Swagger: \t{}://{}:{}{}swagger-ui/index.html\n\t" +
                        "Swagger for testing: \t{}swagger-ui/index.html\n\t" ,
                env.getProperty("spring.application.name"),
                env.getProperty("application.version"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hosttAddress,
                serverPort,
                contextPath,
                ipOutsideDocker,
                env.getActiveProfiles(),
                protocol,
                hosttAddress,
                serverPort,
                contextPath,
                ipOutsideDocker);
    }

}
