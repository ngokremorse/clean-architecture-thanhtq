package com.thanhtq.external.infracstructure.elasticsearch.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.support.HttpHeaders;
import javax.net.ssl.*;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.Objects;


@Configuration
@Log4j2
@EnableElasticsearchRepositories(basePackages = "com.thanhtq.*")
public class ElasticSearchConfig extends ElasticsearchConfiguration {

    @Value("${elasticsearch.uris}")
    private String uris;

    @Value("${elasticsearch.username}")
    private String username;

    @Value("${elasticsearch.password}")
    private String password;

    private SSLContext getSSLConetxt() {
        TrustManager[] trustAllCerts =
                new TrustManager[]{
                        new X509TrustManager() {
                            public X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(
                                    X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(
                                    X509Certificate[] certs, String authType) {
                            }
                        }
                };
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, null);
            SSLContext.setDefault(sc);
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
            return sc;
        } catch (Exception e) {
            log.error(e);
        }
        return sc;
    }

    @Override
    public ClientConfiguration clientConfiguration() {
        HttpHeaders compatibilityHeaders = new HttpHeaders();
        compatibilityHeaders.add("Accept", "application/vnd.elasticsearch+json;compatible-with=7");
        compatibilityHeaders.add("X-Elastic-Product", "Elasticsearch");
        compatibilityHeaders.add(
                "Content-Type", "application/vnd.elasticsearch+json;compatible-with=7");

        final ClientConfiguration clientConfiguration =
                ClientConfiguration.builder()
                        .connectedTo(uris.split(","))
//                        .usingSsl(Objects.requireNonNull(getSSLConetxt()))
                        .withBasicAuth(username, password)
                        .withConnectTimeout(Duration.ofSeconds(60))
                        .withSocketTimeout(Duration.ofSeconds(90))
                        .withDefaultHeaders(compatibilityHeaders)
                        .build();
        return clientConfiguration;
    }
}
