package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;

@NodeChild(value = "expression", type = MJExpresionNode.class)
public abstract class MJAbsNode extends MJExpresionNode {
    @Specialization
    Object absI(int i) {
        return abs(i);
    }

    @Specialization
    Object absF(float f) {
        return abs(f);
    }

    @TruffleBoundary
    private static int abs(int i) {
        return i >= 0 ? i : -i;
    }

    @TruffleBoundary
    private static float abs(float f) {
        return f >= 0 ? f : -f;
    }
}
