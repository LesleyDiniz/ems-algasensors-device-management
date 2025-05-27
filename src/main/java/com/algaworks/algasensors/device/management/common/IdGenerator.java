package com.algaworks.algasensors.device.management.common;

import io.hypersistence.tsid.TSID;

import java.util.Optional;

public class IdGenerator {

    private static final TSID.Factory tsidFactory;

    static {
        Optional.ofNullable(System.getenv("tsid.node"))
                        .ifPresent(tsiNode -> System.setProperty("tsid.node", tsiNode));
        Optional.ofNullable(System.getenv("tsid.node.count"))
                .ifPresent(tsiNodeCount -> System.setProperty("tsid.node.count", tsiNodeCount));

        tsidFactory = TSID.Factory.builder().build();
    }

    private IdGenerator(){

    }

    public static TSID generateTSID(){
        return tsidFactory.generate();
    }
}
