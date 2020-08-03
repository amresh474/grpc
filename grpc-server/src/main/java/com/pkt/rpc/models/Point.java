package com.pkt.rpc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    private double x;
    private double y;
    private double z;
}
