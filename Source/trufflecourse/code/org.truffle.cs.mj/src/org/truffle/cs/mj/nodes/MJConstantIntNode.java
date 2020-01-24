package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class MJConstantIntNode extends MJExpresionNode {

    private final int constant;

    public MJConstantIntNode(int constant) {
        this.constant = constant;
    }

    @Specialization
    public int doInt() {
        return constant;
    }

// @Specialization
// public float doFloat() {
// return (float) constant;
// }
}
