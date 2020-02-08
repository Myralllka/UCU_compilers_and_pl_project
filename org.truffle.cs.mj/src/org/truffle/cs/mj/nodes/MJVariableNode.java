package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
//import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.FrameUtil;
import com.oracle.truffle.api.frame.VirtualFrame;

public class MJVariableNode {

    @NodeField(name = "slot", type = FrameSlot.class)
    public abstract static class MJReadLocalVariableNode extends MJExpresionNode {
        protected abstract FrameSlot getSlot();

//
// @Specialization
// public Object readVariableNode(VirtualFrame frame) {
// try {
// return frame.getObject(getSlot());
// } catch (FrameSlotTypeException e) {
// CompilerDirectives.transferToInterpreter();
// throw new Error(e);
// }
// }
//
        @Specialization(guards = "frame.isLong(getSlot())")
        protected int readI(VirtualFrame frame) {
            return FrameUtil.getIntSafe(frame, getSlot());
        }

        @Specialization(guards = "frame.isFloat(getSlot())")
        protected float readF(VirtualFrame frame) {
            return FrameUtil.getFloatSafe(frame, getSlot());
        }

        @Specialization(guards = "frame.isBoolean(getSlot())")
        protected boolean readB(VirtualFrame frame) {
            return FrameUtil.getBooleanSafe(frame, getSlot());
        }

        @Specialization(replaces = {"readI", "readB", "readF"})
        protected Object readVariableNode(VirtualFrame frame) {
            if (!frame.isObject(getSlot())) {
                CompilerDirectives.transferToInterpreter();
                Object result = frame.getValue(getSlot());
                frame.setObject(getSlot(), result);
                return result;
            }

            return FrameUtil.getObjectSafe(frame, getSlot());
        }
    }

    @NodeChild(value = "value", type = MJExpresionNode.class)
    @NodeField(name = "slot", type = FrameSlot.class)
    public abstract static class MJWriteLocalVariableNode extends MJStatementNode {
        protected abstract FrameSlot getSlot();

        @Specialization(guards = "isIOrIllegal(frame)")
        protected int writeI(VirtualFrame frame, int value) {
            frame.getFrameDescriptor().setFrameSlotKind(getSlot(), FrameSlotKind.Int);

            frame.setInt(getSlot(), value);
            return value;
        }

        @Specialization(guards = "isFOrIllegal(frame)")
        protected float writeF(VirtualFrame frame, float value) {
            frame.getFrameDescriptor().setFrameSlotKind(getSlot(), FrameSlotKind.Float);

            frame.setFloat(getSlot(), value);
            return value;
        }

        @Specialization(guards = "isBOrIllegal(frame)")
        protected boolean writeB(VirtualFrame frame, boolean value) {
            frame.getFrameDescriptor().setFrameSlotKind(getSlot(), FrameSlotKind.Boolean);

            frame.setBoolean(getSlot(), value);
            return value;
        }

        // ##########################ASSERTS##########################
        protected boolean isIOrIllegal(VirtualFrame frame) {
            final FrameSlotKind kind = frame.getFrameDescriptor().getFrameSlotKind(getSlot());
            return kind == FrameSlotKind.Int || kind == FrameSlotKind.Illegal;
        }

        protected boolean isFOrIllegal(VirtualFrame frame) {
            final FrameSlotKind kind = frame.getFrameDescriptor().getFrameSlotKind(getSlot());
            return kind == FrameSlotKind.Float || kind == FrameSlotKind.Illegal;
        }

        protected boolean isBOrIllegal(VirtualFrame frame) {
            final FrameSlotKind kind = frame.getFrameDescriptor().getFrameSlotKind(getSlot());
            return kind == FrameSlotKind.Boolean || kind == FrameSlotKind.Illegal;
        }

        @Specialization(replaces = {"writeI", "writeF", "writeB"})
        protected Object write(VirtualFrame frame, Object value) {
            frame.getFrameDescriptor().setFrameSlotKind(getSlot(), FrameSlotKind.Object);

            frame.setObject(getSlot(), value);
// ######### return value; // uncomment for i++ operations!!! //
            return null;
        }

    }

}
