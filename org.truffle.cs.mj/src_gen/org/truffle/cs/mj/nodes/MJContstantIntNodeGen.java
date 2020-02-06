// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import org.truffle.cs.mj.nodes.MJContstantIntNode;

@GeneratedBy(MJContstantIntNode.class)
public final class MJContstantIntNodeGen extends MJContstantIntNode {

    private MJContstantIntNodeGen(int constant) {
        super(constant);
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        return doInt();
    }

    @Override
    public int executeI32(VirtualFrame frameValue) {
        return doInt();
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeI32(frameValue);
        return;
    }

    @Override
    public NodeCost getCost() {
        return NodeCost.MONOMORPHIC;
    }

    public static MJContstantIntNode create(int constant) {
        return new MJContstantIntNodeGen(constant);
    }

}
