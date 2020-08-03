package com.pkt.rpc.proto;

import com.pkt.rpc.models.Point;
import com.pkt.rpc.models.Vector;
import com.pkt.rpc.proto.base.VectorProto;

import java.util.List;

public class DomainToProto {
    private DomainToProto() {
    }

    public static VectorProto.Point toProto(Point point) {
        return VectorProto.Point.newBuilder()
                .setX(point.getX())
                .setY(point.getY())
                .setZ(point.getZ())
                .build();
    }

    public static VectorProto.Vector toProto(Vector vector) {
        return VectorProto.Vector.newBuilder()
                .setStart(toProto(vector.getStart()))
                .setEnd(toProto(vector.getEnd()))
                .build();
    }

    public static VectorProto.Vectors toProto(List<Vector> vectors) {
        VectorProto.Vectors.Builder vectorsBuilder = VectorProto.Vectors.newBuilder();
        vectors.forEach(vector -> vectorsBuilder.addVectors(toProto(vector)));

        return vectorsBuilder.build();
    }
}
