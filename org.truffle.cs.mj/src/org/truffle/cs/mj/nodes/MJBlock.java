package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;

public class MJBlock extends MJStatementNode {
    @Children MJStatementNode[] statemnts;

    public MJBlock(MJStatementNode[] statemnts) {
        this.statemnts = statemnts;
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame frame) {
        for (MJStatementNode stat : statemnts) {
            stat.execute(frame);
        }
        return null;
    }

}
