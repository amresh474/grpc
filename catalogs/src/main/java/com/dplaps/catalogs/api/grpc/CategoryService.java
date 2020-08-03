package com.dplaps.catalogs.api.grpc;

import com.dplaps.catalogs.dto.CatgTree;
import com.dplaps.rpc.proto.base.CategoryProto;
import com.dplaps.rpc.proto.base.CategoryServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@GRpcService
public class CategoryService extends CategoryServiceGrpc.CategoryServiceImplBase {
    @Autowired
    private com.dplaps.catalogs.service.CategoryService categoryService;

    public static CategoryProto.CatgTree toProto(CatgTree catgTree) {
        return CategoryProto.CatgTree.newBuilder()
                .setName(catgTree.getName())
                .setColor(catgTree.getColor())
                .build();
    }

    @Override
    public void findCatg(CategoryProto.CategoryRequest request, StreamObserver<CategoryProto.CatgTree> responseObserver) {
        int id = request.getId();
        CatgTree catgTree = categoryService.findCatg(id);

        CategoryProto.CatgTree.Builder catgTreeBuilder = CategoryProto.CatgTree.newBuilder();
        catgTreeBuilder.setName(catgTree.getName());
        catgTreeBuilder.setColor(catgTree.getColor());
        catgTree.getSubClasses().forEach(catg -> catgTreeBuilder.addSubClasses(toProto(catg)));
        responseObserver.onNext( catgTreeBuilder.build());
        responseObserver.onCompleted();
    }

//    @Override
//    public void findCatgs(CategoryProto.Empty request, StreamObserver<CategoryProto.CatgTrees> responseObserver) {
//        vectorGenerator.generateRandomVectors(request.getSeed(), request.getNumberOfVectors()).forEach(vector -> responseObserver.onNext(toProto(vector)));
//        responseObserver.onCompleted();
//    }
}
