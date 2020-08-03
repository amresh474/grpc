package com.pkt.rpc.proto;

import com.pkt.rpc.proto.base.VectorProto;
import com.pkt.rpc.proto.base.VectorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class VectorsServiceConsumer {

    public void getVectors(String hostname, int port, long seed, int numberOfVectors) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(hostname, port).usePlaintext().build();
        VectorServiceGrpc.VectorServiceBlockingStub blockingStub = VectorServiceGrpc.newBlockingStub(managedChannel);
        VectorProto.VectorsRequest vectorsRequest = VectorProto.VectorsRequest.newBuilder()
                .setNumberOfVectors(numberOfVectors)
                .setSeed(seed)
                .build();

        VectorProto.Vectors response = blockingStub.getVectors(vectorsRequest);

        response.getVectorsList();

        managedChannel.shutdown();
    }

    public void getVectorStream(String hostname, int port, long seed, int numberOfVectors) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(hostname, port).usePlaintext().build();
        VectorServiceGrpc.VectorServiceBlockingStub blockingStub = VectorServiceGrpc.newBlockingStub(managedChannel);
        VectorProto.VectorsRequest vectorsRequest = VectorProto.VectorsRequest.newBuilder()
                .setNumberOfVectors(numberOfVectors)
                .setSeed(seed)
                .build();

        Iterator<VectorProto.Vector> response = blockingStub.getVectorStream(vectorsRequest);

        while (response.hasNext()) {
            response.next();
        }

        managedChannel.shutdown();
    }
}

