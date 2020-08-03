package com.pkt.rpc.proto;

import com.pkt.rpc.models.Point;
import com.pkt.rpc.models.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VectorGenerator {

    public List<Vector> generateRandomVectors(long seed, int numberOfVectors) {
        Random random = new Random(seed);

        List<Vector> vectors = new ArrayList<Vector>(numberOfVectors);
        for (int i = 0; i < numberOfVectors; ++i) {
            Point start = new Point(random.nextDouble(), random.nextDouble(), random.nextDouble());
            Point end = new Point(random.nextDouble(), random.nextDouble(), random.nextDouble());
            Vector vector = new Vector(start, end);

            vectors.add(vector);
        }

        return vectors;
    }
}
