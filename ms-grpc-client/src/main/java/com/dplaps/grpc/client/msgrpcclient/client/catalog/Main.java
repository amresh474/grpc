package com.dplaps.grpc.client.msgrpcclient.client.catalog;

import com.dplaps.rpc.proto.base.CategoryProto;
import com.dplaps.rpc.proto.base.CategoryServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Main {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8181).usePlaintext().build();
        CategoryServiceGrpc.CategoryServiceBlockingStub blockingStub = CategoryServiceGrpc.newBlockingStub(managedChannel);
        CategoryProto.CategoryRequest catgRequest = CategoryProto.CategoryRequest.newBuilder()
                .setId(1)
                .build();

        CategoryProto.CatgTree response = blockingStub.findCatg(catgRequest);
        System.out.println(response.getName());
        System.out.println(response.getColor());
        //System.out.println(response.getSubClasses(0));
        managedChannel.shutdown();
    }
}
