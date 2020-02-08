package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class MJContstantIntNode extends MJExpresionNode {
// public abstract class MJContstantIntNode extends MJExpresionNode implements TypeFactory {
    private final int constant;

    public MJContstantIntNode(int constant) {
        this.constant = constant;
    }

    @Specialization
    public int doInt() {
        return constant;
    }
}
