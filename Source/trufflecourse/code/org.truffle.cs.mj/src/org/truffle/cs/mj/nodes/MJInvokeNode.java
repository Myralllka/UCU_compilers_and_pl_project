package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;

public class MJInvokeNode extends MJExpresionNode {
    @Child private DirectCallNode directCallNode;

    @Children private final MJExpresionNode[] params;

    public MJInvokeNode(CallTarget target, MJExpresionNode[] params) {
        this.directCallNode = DirectCallNode.create(target);
        this.params = params;
    }

    @Override
    @ExplodeLoop
    public Object executeGeneric(VirtualFrame frame) {
        Object[] argumentValues = new Object[params.length];
        for (int i = 0; i < params.length; ++i) {
            argumentValues[i] = params[i].executeGeneric(frame);
        }

        return directCallNode.call(argumentValues);
    }

}
