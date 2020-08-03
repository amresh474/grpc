package com.dplaps.grpc.client.msgrpcclient.client.catalog;


import com.dplaps.grpc.client.msgrpcclient.config.PropertiesConfig;
import com.dplaps.rpc.proto.base.CategoryProto;
import com.dplaps.rpc.proto.base.CategoryServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceClient {
    @Autowired
    private PropertiesConfig propConfig;
    public void getVectors(int id) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(propConfig.catHost, propConfig.catPort).usePlaintext().build();
        CategoryServiceGrpc.CategoryServiceBlockingStub blockingStub = CategoryServiceGrpc.newBlockingStub(managedChannel);
        CategoryProto.CategoryRequest catgRequest = CategoryProto.CategoryRequest.newBuilder()
                .setId(id)
                .build();

        CategoryProto.CatgTree response = blockingStub.findCatg(catgRequest);
        System.out.println(response.getName());
        System.out.println(response.getColor());
        System.out.println(response.getSubClasses(0));
        managedChannel.shutdown();
    }


}
