package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class MJContstantFloatNode extends MJExpresionNode {

    private final float constant;

    public MJContstantFloatNode(float constant) {
        this.constant = constant;
    }

    @Specialization
    public float doFloat() {
        return constant;
    }
}
