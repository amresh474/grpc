package org.grpc;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
//    @Override
//    public void hello(
//            HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
//
//        String greeting = new StringBuilder()
//                .append("Hello, ")
//                .append(request.getFirstName())
//                .append(" ")
//                .append(request.getLastName())
//                .toString();
//
//        HelloResponse response = HelloResponse.newBuilder()
//                .setGreeting(greeting)
//                .build();
//
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }

    @Override
    public void bulkAddOrUpdateSkuAttributes(SkuAttributePayload request, StreamObserver<SkuAttributeRes> responseObserver) {
//        String greeting = new StringBuilder()
//                .append(request.getType())
//                .append(" ")
//                .append(request.getSkuAttributeRequest(0).getSkuCode())
//                .append(" ")
//                .append(request.getSkuAttributeRequest(0).getKey())
//                .append(" ")
//                .append(request.getSkuAttributeRequest(0).getValue())
//                .append(" ")
//                .append(request.getType().toString())
//                .append(" ")
//                .append(request.getSkuAttributeRequest(0).getProjectsMap().get("ABC"))
//                .toString();
//        HelloResponse response = HelloResponse.newBuilder()
//                .setGreeting(greeting)
//                .build();
        //responseObserver.onNext(response);
        SkuAttributeRes res=SkuAttributeRes
                .newBuilder()
                .setSkuCode(request.getSkuAttributeRequest(0).getSkuCode())
                .setKey(request.getSkuAttributeRequest(0).getKey())
                .setValue(request.getSkuAttributeRequest(0).getValue())
                .setPtype(request.getSkuAttributeRequest(0).getPtype())
                .setType(request.getType())
                .putAllProjects(request.getSkuAttributeRequest(0).getProjectsMap())
                .build();
                responseObserver.onNext(res);
        responseObserver.onCompleted();
    }
}
