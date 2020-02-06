package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;

public class MJVariableNode {

    @NodeField(name = "slot", type = FrameSlot.class)
    public abstract static class MJReadLocalVariableNode extends MJExpresionNode {
        protected abstract FrameSlot getSlot();

        @Specialization
        public Object readVariableNode(VirtualFrame frame) {
            try {
                return frame.getObject(getSlot());
            } catch (FrameSlotTypeException e) {
                CompilerDirectives.transferToInterpreter();
                throw new Error(e);
            }
        }
    }

    @NodeChild(value = "value", type = MJExpresionNode.class)
    @NodeField(name = "slot", type = FrameSlot.class)
    public abstract static class MJWriteLocalVariableNode extends MJStatementNode {
        protected abstract FrameSlot getSlot();

        @Specialization
        public Object excute(VirtualFrame frame, Object value) {
            frame.setObject(getSlot(), value);
            return null;
        }
    }
}
