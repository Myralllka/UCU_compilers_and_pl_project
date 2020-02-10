package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.Specialization;

public abstract class MJContstantCharNode extends MJExpresionNode {

    private final char constant;

    public MJContstantCharNode(char constant) {
        this.constant = constant;
    }

    @Specialization
    public char doChar() {
        return constant;
    }
}
