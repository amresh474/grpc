package org.grpc.client.grpcclient.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.grpc.client.grpcclient.client.VectorsServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {
    final String hostname = "localhost";
    final int port = 8181;
    private final VectorsServiceClient vectorsServiceClient;
    @Autowired
    public Api(VectorsServiceClient vectorsServiceClient) {
        this.vectorsServiceClient = vectorsServiceClient;
    }


    @GetMapping("/remote/rest/proto/vectors")
    public Statistics getRestProtoVectors(
            @RequestParam int numberOfIterations, @RequestParam long seed, @RequestParam int numberOfVectors) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfIterations; ++i) {
            vectorsServiceClient.getVectors(hostname, port, seed, numberOfVectors);
        }

        long duration = System.currentTimeMillis() - startTime;

        return new Statistics(numberOfIterations, numberOfVectors, duration);
    }

    @Data
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    private class Statistics {
        private int numberOfIterations;
        private int numberOfVectors;
        private long duration;
    }
}
