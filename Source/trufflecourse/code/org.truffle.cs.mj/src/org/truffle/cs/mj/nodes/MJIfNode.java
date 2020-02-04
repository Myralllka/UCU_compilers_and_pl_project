package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

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
        if (condition.executeBool(frame)) {
            return trueBranch.execute(frame);
        }

        if (falseBranch != null) {
            return falseBranch.execute(frame);
        }
        return null;
    }

}
