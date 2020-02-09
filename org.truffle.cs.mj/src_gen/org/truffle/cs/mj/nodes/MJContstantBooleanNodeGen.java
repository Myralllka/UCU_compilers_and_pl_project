// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import org.truffle.cs.mj.nodes.MJContstantBooleanNode;

@GeneratedBy(MJContstantBooleanNode.class)
public final class MJContstantBooleanNodeGen extends MJContstantBooleanNode {

    private MJContstantBooleanNodeGen(boolean constant) {
        super(constant);
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        return doBoolean();
    }

    @Override
    public boolean executeBool(VirtualFrame frameValue) {
        return doBoolean();
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBool(frameValue);
        return;
    }

    @Override
    public NodeCost getCost() {
        return NodeCost.MONOMORPHIC;
    }

    public static MJContstantBooleanNode create(boolean constant) {
        return new MJContstantBooleanNodeGen(constant);
    }

}
