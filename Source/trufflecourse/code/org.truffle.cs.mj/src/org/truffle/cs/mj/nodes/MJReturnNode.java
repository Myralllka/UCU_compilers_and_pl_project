package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ControlFlowException;

public class MJReturnNode extends MJStatementNode {
    @Child MJExpresionNode returnValue;

    public MJReturnNode(MJExpresionNode returnValue) {
        this.returnValue = returnValue;
    }

    public static class MJReturnException extends ControlFlowException {
        final Object value;

        public MJReturnException(Object value) {
            this.value = value;
        }
    }

    @Override
    public Object execute(VirtualFrame frame) {
        if (returnValue != null) {
            throw new MJReturnException(returnValue.executeGeneric(frame));
        }
        throw new MJReturnException(null);
    }
}
