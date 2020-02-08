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
// try {
        for (MJStatementNode stat : statemnts) {
            try {
                stat.execute(frame);
            } catch (NullPointerException e) {
                // TODO: handle exception
                System.out.print(23);
            }
        }
// } catch (Exception e) {
// // TODO: handle exception
// System.out.print(23);
// }

        return null;
    }

}
