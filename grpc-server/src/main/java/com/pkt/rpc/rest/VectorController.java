package com.pkt.rpc.rest;

import com.pkt.rpc.proto.VectorGenerator;
import com.pkt.rpc.models.Vectors;
import com.pkt.rpc.proto.base.VectorProto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.pkt.rpc.proto.DomainToProto.toProto;

@RestController
public class VectorController {

    private final VectorGenerator vectorGenerator;

    @Autowired
    public VectorController(VectorGenerator vectorGenerator) {
        this.vectorGenerator = vectorGenerator;
    }

    @GetMapping("/json/vectors")
    public Vectors getJsonVectors(@RequestParam long seed, @RequestParam int numberOfVectors) {
        return new Vectors(vectorGenerator.generateRandomVectors(seed, numberOfVectors));
    }

    @GetMapping("/proto/vectors")
    public VectorProto.Vectors getProtoVectors(@RequestParam long seed, @RequestParam int numberOfVectors) {
        VectorProto.Vectors.Builder vectorsBuilder = VectorProto.Vectors.newBuilder();
        vectorGenerator.generateRandomVectors(seed, numberOfVectors).forEach(vector -> vectorsBuilder.addVectors(toProto(vector)));
        return vectorsBuilder.build();
    }
}
