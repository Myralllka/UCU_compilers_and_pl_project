package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class MJContstantBooleanNode extends MJExpresionNode {
    private final boolean constant;

    public MJContstantBooleanNode(boolean constant) {
        this.constant = constant;
    }

    @Specialization
    public boolean doBoolean() {
        return constant;
    }
}