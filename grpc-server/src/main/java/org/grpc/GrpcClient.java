package org.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);


        SkuAttributeRequest sar = SkuAttributeRequest
                .newBuilder()
                .setSkuCode("SKU101")
                .setKey("wastage")
                .setKey("5kg")
                .setPtype(PhoneType.LANDLINE)
                .putProjects("ABC", "CDE")
                .build();
        SkuAttributePayload payload = SkuAttributePayload.newBuilder()
                .setType("2")
                .addSkuAttributeRequest(sar)
                .build();
        //HelloResponse helloResponse = stub.bulkAddOrUpdateSkuAttributes(payload);
        SkuAttributeRes response = stub.bulkAddOrUpdateSkuAttributes(payload);

        channel.shutdown();
    }
}
