// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import org.truffle.cs.mj.nodes.MJContstantCharNode;

@GeneratedBy(MJContstantCharNode.class)
public final class MJContstantCharNodeGen extends MJContstantCharNode {

    private MJContstantCharNodeGen(char constant) {
        super(constant);
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        return doChar();
    }

    @Override
    public char executeChar(VirtualFrame frameValue) {
        return doChar();
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeChar(frameValue);
        return;
    }

    @Override
    public NodeCost getCost() {
        return NodeCost.MONOMORPHIC;
    }

    public static MJContstantCharNode create(char constant) {
        return new MJContstantCharNodeGen(constant);
    }

}
