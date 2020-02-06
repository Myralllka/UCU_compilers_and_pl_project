package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class MJIfNode extends MJStatementNode {

    @Child MJExpresionNode condition;
    @Child MJStatementNode trueBranch;
    @Child MJStatementNode falseBranch;

    public MJIfNode(MJExpresionNode condition, MJStatementNode trueBranch, MJStatementNode falseBranch) {
        this.condition = condition;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        try {
            if (condition.executeBool(frame)) {
                return trueBranch.execute(frame);
            }
        } catch (UnexpectedResultException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (falseBranch != null) {
            return falseBranch.execute(frame);
        }
        return null;
    }

}
