package org.truffle.cs.mj.nodes;

import java.util.concurrent.locks.Condition;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.profiles.ConditionProfile;

public class MJIfNode extends MJStatementNode {

    @Child MJExpresionNode conditionNode;
    @Child MJStatementNode trueBranch;
    @Child MJStatementNode falseBranch;

    final ConditionProfile condition = ConditionProfile.createCountingProfile();

    public MJIfNode(MJExpresionNode conditionNode, MJStatementNode trueBranch, MJStatementNode falseBranch) {
        this.conditionNode = conditionNode;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        try {
            if (condition.profile(conditionNode.executeBool(frame))) {
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
