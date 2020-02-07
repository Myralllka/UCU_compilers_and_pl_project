package org.truffle.cs.mj.nodes;

import org.truffle.cs.mj.nodes.MJReturnNode.MJReturnException;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ControlFlowException;

public class MJBreakNode extends MJStatementNode {

    public static class MJBreakException extends ControlFlowException {
        public MJBreakException() {
        }
    }

    @Override
    public Object execute(VirtualFrame frame) {
        throw new MJBreakException();
    }

}
