package org.truffle.cs.mj.nodes;

import org.truffle.cs.mj.nodes.MJBreakNode.MJBreakException;
import org.truffle.cs.mj.nodes.MJContinueNode.MJContinueException;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class MJWhileLoop extends MJStatementNode {
    @Child MJExpresionNode condition;
    @Child MJStatementNode loopBody;

    public MJWhileLoop(MJExpresionNode condition, MJStatementNode loopBody) {
        this.condition = condition;
        this.loopBody = loopBody;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        try {
            while (condition.executeBool(frame)) {
                try {
                    loopBody.execute(frame);
                } catch (MJContinueException e) {
                }

            }
        } catch (UnexpectedResultException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MJBreakException e) {
        }
        return null;
    }

}
