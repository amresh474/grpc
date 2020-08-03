package com.pkt.rpc.proto;

import com.pkt.rpc.proto.base.VectorProto;
import com.pkt.rpc.proto.base.VectorServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import static com.pkt.rpc.proto.DomainToProto.toProto;

@GRpcService
public class VectorsService extends VectorServiceGrpc.VectorServiceImplBase {

    private final VectorGenerator vectorGenerator;

    @Autowired
    public VectorsService(VectorGenerator vectorGenerator) {
        this.vectorGenerator = vectorGenerator;
    }

    @Override
    public void getVectors(VectorProto.VectorsRequest request, StreamObserver<VectorProto.Vectors> responseObserver) {
        responseObserver.onNext(toProto(vectorGenerator.generateRandomVectors(request.getSeed(), request.getNumberOfVectors())));
        responseObserver.onCompleted();
    }

    @Override
    public void getVectorStream(VectorProto.VectorsRequest request, StreamObserver<VectorProto.Vector> responseObserver) {
        vectorGenerator.generateRandomVectors(request.getSeed(), request.getNumberOfVectors()).forEach(vector -> responseObserver.onNext(toProto(vector)));
        responseObserver.onCompleted();
    }
}
