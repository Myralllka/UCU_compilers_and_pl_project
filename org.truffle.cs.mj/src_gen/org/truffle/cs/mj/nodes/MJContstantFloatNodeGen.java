// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import org.truffle.cs.mj.nodes.MJContstantFloatNode;

@GeneratedBy(MJContstantFloatNode.class)
public final class MJContstantFloatNodeGen extends MJContstantFloatNode {

    private MJContstantFloatNodeGen(float constant) {
        super(constant);
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        return doFloat();
    }

    @Override
    public float executeF32(VirtualFrame frameValue) {
        return doFloat();
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeF32(frameValue);
        return;
    }

    @Override
    public NodeCost getCost() {
        return NodeCost.MONOMORPHIC;
    }

    public static MJContstantFloatNode create(float constant) {
        return new MJContstantFloatNodeGen(constant);
    }

}
