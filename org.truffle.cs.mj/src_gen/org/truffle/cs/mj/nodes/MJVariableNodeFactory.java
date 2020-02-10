// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import java.util.concurrent.locks.Lock;
import org.truffle.cs.mj.nodes.MJExpresionNode;
import org.truffle.cs.mj.nodes.MJTypesGen;
import org.truffle.cs.mj.nodes.MJVariableNode;
import org.truffle.cs.mj.nodes.MJVariableNode.MJReadLocalVariableNode;
import org.truffle.cs.mj.nodes.MJVariableNode.MJWriteLocalVariableNode;

@GeneratedBy(MJVariableNode.class)
public final class MJVariableNodeFactory {

    @GeneratedBy(MJReadLocalVariableNode.class)
    public static final class MJReadLocalVariableNodeGen extends MJReadLocalVariableNode {

        private final FrameSlot slot;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;

        private MJReadLocalVariableNodeGen(FrameSlot slot) {
            this.slot = slot;
        }

        @Override
        protected FrameSlot getSlot() {
            return this.slot;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1) != 0 /* is-active readI(VirtualFrame) */) {
                if ((frameValue.isInt(getSlot()))) {
                    return readI(frameValue);
                }
            }
            if ((state & 0b10) != 0 /* is-active readF(VirtualFrame) */) {
                if ((frameValue.isFloat(getSlot()))) {
                    return readF(frameValue);
                }
            }
            if ((state & 0b100) != 0 /* is-active readB(VirtualFrame) */) {
                if ((frameValue.isBoolean(getSlot()))) {
                    return readB(frameValue);
                }
            }
            if ((state & 0b1000) != 0 /* is-active readC(VirtualFrame) */) {
                if ((frameValue.isByte(getSlot()))) {
                    return readC(frameValue);
                }
            }
            if ((state & 0b10000) != 0 /* is-active readVariableNode(VirtualFrame) */) {
                return readVariableNode(frameValue);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b10000) != 0 /* is-active readVariableNode(VirtualFrame) */) {
                return MJTypesGen.expectBoolean(executeGeneric(frameValue));
            }
            if ((state & 0b100) != 0 /* is-active readB(VirtualFrame) */) {
                if ((frameValue.isBoolean(getSlot()))) {
                    return readB(frameValue);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return MJTypesGen.expectBoolean(executeAndSpecialize(frameValue));
        }

        @Override
        public char executeChar(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b10000) != 0 /* is-active readVariableNode(VirtualFrame) */) {
                return MJTypesGen.expectCharacter(executeGeneric(frameValue));
            }
            if ((state & 0b1000) != 0 /* is-active readC(VirtualFrame) */) {
                if ((frameValue.isByte(getSlot()))) {
                    return readC(frameValue);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return MJTypesGen.expectCharacter(executeAndSpecialize(frameValue));
        }

        @Override
        public float executeF32(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b10000) != 0 /* is-active readVariableNode(VirtualFrame) */) {
                return expectFloat(executeGeneric(frameValue));
            }
            if ((state & 0b10) != 0 /* is-active readF(VirtualFrame) */) {
                if ((frameValue.isFloat(getSlot()))) {
                    return readF(frameValue);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return expectFloat(executeAndSpecialize(frameValue));
        }

        @Override
        public int executeI32(VirtualFrame frameValue) throws UnexpectedResultException {
            int state = state_;
            if ((state & 0b10000) != 0 /* is-active readVariableNode(VirtualFrame) */) {
                return MJTypesGen.expectInteger(executeGeneric(frameValue));
            }
            if ((state & 0b1) != 0 /* is-active readI(VirtualFrame) */) {
                if ((frameValue.isInt(getSlot()))) {
                    return readI(frameValue);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return MJTypesGen.expectInteger(executeAndSpecialize(frameValue));
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            int state = state_;
            try {
                if ((state & 0b11110) == 0 /* only-active readI(VirtualFrame) */ && state != 0  /* is-not readI(VirtualFrame) && readF(VirtualFrame) && readB(VirtualFrame) && readC(VirtualFrame) && readVariableNode(VirtualFrame) */) {
                    executeI32(frameValue);
                    return;
                } else if ((state & 0b11101) == 0 /* only-active readF(VirtualFrame) */ && state != 0  /* is-not readI(VirtualFrame) && readF(VirtualFrame) && readB(VirtualFrame) && readC(VirtualFrame) && readVariableNode(VirtualFrame) */) {
                    executeF32(frameValue);
                    return;
                } else if ((state & 0b10111) == 0 /* only-active readC(VirtualFrame) */ && state != 0  /* is-not readI(VirtualFrame) && readF(VirtualFrame) && readB(VirtualFrame) && readC(VirtualFrame) && readVariableNode(VirtualFrame) */) {
                    executeChar(frameValue);
                    return;
                } else if ((state & 0b11011) == 0 /* only-active readB(VirtualFrame) */ && state != 0  /* is-not readI(VirtualFrame) && readF(VirtualFrame) && readB(VirtualFrame) && readC(VirtualFrame) && readVariableNode(VirtualFrame) */) {
                    executeBool(frameValue);
                    return;
                }
                executeGeneric(frameValue);
                return;
            } catch (UnexpectedResultException ex) {
                return;
            }
        }

        private Object executeAndSpecialize(VirtualFrame frameValue) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (((exclude & 0b1)) == 0 /* is-not-excluded readI(VirtualFrame) */) {
                    if ((frameValue.isInt(getSlot()))) {
                        this.state_ = state = state | 0b1 /* add-active readI(VirtualFrame) */;
                        lock.unlock();
                        hasLock = false;
                        return readI(frameValue);
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded readF(VirtualFrame) */) {
                    if ((frameValue.isFloat(getSlot()))) {
                        this.state_ = state = state | 0b10 /* add-active readF(VirtualFrame) */;
                        lock.unlock();
                        hasLock = false;
                        return readF(frameValue);
                    }
                }
                if (((exclude & 0b100)) == 0 /* is-not-excluded readB(VirtualFrame) */) {
                    if ((frameValue.isBoolean(getSlot()))) {
                        this.state_ = state = state | 0b100 /* add-active readB(VirtualFrame) */;
                        lock.unlock();
                        hasLock = false;
                        return readB(frameValue);
                    }
                }
                if (((exclude & 0b1000)) == 0 /* is-not-excluded readC(VirtualFrame) */) {
                    if ((frameValue.isByte(getSlot()))) {
                        this.state_ = state = state | 0b1000 /* add-active readC(VirtualFrame) */;
                        lock.unlock();
                        hasLock = false;
                        return readC(frameValue);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1111 /* add-excluded readI(VirtualFrame), readF(VirtualFrame), readB(VirtualFrame), readC(VirtualFrame) */;
                state = state & 0xfffffff0 /* remove-active readI(VirtualFrame), readF(VirtualFrame), readB(VirtualFrame), readC(VirtualFrame) */;
                this.state_ = state = state | 0b10000 /* add-active readVariableNode(VirtualFrame) */;
                lock.unlock();
                hasLock = false;
                return readVariableNode(frameValue);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        private static float expectFloat(Object value) throws UnexpectedResultException {
            if (value instanceof Float) {
                return (float) value;
            }
            throw new UnexpectedResultException(value);
        }

        public static MJReadLocalVariableNode create(FrameSlot slot) {
            return new MJReadLocalVariableNodeGen(slot);
        }

    }
    @GeneratedBy(MJWriteLocalVariableNode.class)
    public static final class MJWriteLocalVariableNodeGen extends MJWriteLocalVariableNode {

        private final FrameSlot slot;
        @Child private MJExpresionNode value_;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;

        private MJWriteLocalVariableNodeGen(MJExpresionNode value, FrameSlot slot) {
            this.slot = slot;
            this.value_ = value;
        }

        @Override
        protected FrameSlot getSlot() {
            return this.slot;
        }

        @Override
        public Object execute(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b11110) == 0 /* only-active writeI(VirtualFrame, int) */ && state != 0  /* is-not writeI(VirtualFrame, int) && writeF(VirtualFrame, float) && writeB(VirtualFrame, boolean) && writeC(VirtualFrame, char) && write(VirtualFrame, Object) */) {
                return execute_int0(frameValue, state);
            } else if ((state & 0b11101) == 0 /* only-active writeF(VirtualFrame, float) */ && state != 0  /* is-not writeI(VirtualFrame, int) && writeF(VirtualFrame, float) && writeB(VirtualFrame, boolean) && writeC(VirtualFrame, char) && write(VirtualFrame, Object) */) {
                return execute_float1(frameValue, state);
            } else if ((state & 0b11011) == 0 /* only-active writeB(VirtualFrame, boolean) */ && state != 0  /* is-not writeI(VirtualFrame, int) && writeF(VirtualFrame, float) && writeB(VirtualFrame, boolean) && writeC(VirtualFrame, char) && write(VirtualFrame, Object) */) {
                return execute_boolean2(frameValue, state);
            } else if ((state & 0b10111) == 0 /* only-active writeC(VirtualFrame, char) */ && state != 0  /* is-not writeI(VirtualFrame, int) && writeF(VirtualFrame, float) && writeB(VirtualFrame, boolean) && writeC(VirtualFrame, char) && write(VirtualFrame, Object) */) {
                return execute_char3(frameValue, state);
            } else {
                return execute_generic4(frameValue, state);
            }
        }

        private Object execute_int0(VirtualFrame frameValue, int state) {
            int valueValue_;
            try {
                valueValue_ = this.value_.executeI32(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(frameValue, ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active writeI(VirtualFrame, int) */;
            if ((isIOrIllegal(frameValue))) {
                return writeI(frameValue, valueValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, valueValue_);
        }

        private Object execute_float1(VirtualFrame frameValue, int state) {
            float valueValue_;
            try {
                valueValue_ = this.value_.executeF32(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(frameValue, ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active writeF(VirtualFrame, float) */;
            if ((isFOrIllegal(frameValue))) {
                return writeF(frameValue, valueValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, valueValue_);
        }

        private Object execute_boolean2(VirtualFrame frameValue, int state) {
            boolean valueValue_;
            try {
                valueValue_ = this.value_.executeBool(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(frameValue, ex.getResult());
            }
            assert (state & 0b100) != 0 /* is-active writeB(VirtualFrame, boolean) */;
            if ((isBOrIllegal(frameValue))) {
                return writeB(frameValue, valueValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, valueValue_);
        }

        private Object execute_char3(VirtualFrame frameValue, int state) {
            char valueValue_;
            try {
                valueValue_ = this.value_.executeChar(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(frameValue, ex.getResult());
            }
            assert (state & 0b1000) != 0 /* is-active writeC(VirtualFrame, char) */;
            if ((isCOrIllegal(frameValue))) {
                return writeC(frameValue, valueValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, valueValue_);
        }

        private Object execute_generic4(VirtualFrame frameValue, int state) {
            Object valueValue_ = this.value_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active writeI(VirtualFrame, int) */ && valueValue_ instanceof Integer) {
                int valueValue__ = (int) valueValue_;
                if ((isIOrIllegal(frameValue))) {
                    return writeI(frameValue, valueValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active writeF(VirtualFrame, float) */ && valueValue_ instanceof Float) {
                float valueValue__ = (float) valueValue_;
                if ((isFOrIllegal(frameValue))) {
                    return writeF(frameValue, valueValue__);
                }
            }
            if ((state & 0b100) != 0 /* is-active writeB(VirtualFrame, boolean) */ && valueValue_ instanceof Boolean) {
                boolean valueValue__ = (boolean) valueValue_;
                if ((isBOrIllegal(frameValue))) {
                    return writeB(frameValue, valueValue__);
                }
            }
            if ((state & 0b1000) != 0 /* is-active writeC(VirtualFrame, char) */ && valueValue_ instanceof Character) {
                char valueValue__ = (char) valueValue_;
                if ((isCOrIllegal(frameValue))) {
                    return writeC(frameValue, valueValue__);
                }
            }
            if ((state & 0b10000) != 0 /* is-active write(VirtualFrame, Object) */) {
                return write(frameValue, valueValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(frameValue, valueValue_);
        }

        private Object executeAndSpecialize(VirtualFrame frameValue, Object valueValue) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (((exclude & 0b1)) == 0 /* is-not-excluded writeI(VirtualFrame, int) */ && valueValue instanceof Integer) {
                    int valueValue_ = (int) valueValue;
                    if ((isIOrIllegal(frameValue))) {
                        this.state_ = state = state | 0b1 /* add-active writeI(VirtualFrame, int) */;
                        lock.unlock();
                        hasLock = false;
                        return writeI(frameValue, valueValue_);
                    }
                }
                if (((exclude & 0b10)) == 0 /* is-not-excluded writeF(VirtualFrame, float) */ && valueValue instanceof Float) {
                    float valueValue_ = (float) valueValue;
                    if ((isFOrIllegal(frameValue))) {
                        this.state_ = state = state | 0b10 /* add-active writeF(VirtualFrame, float) */;
                        lock.unlock();
                        hasLock = false;
                        return writeF(frameValue, valueValue_);
                    }
                }
                if (((exclude & 0b100)) == 0 /* is-not-excluded writeB(VirtualFrame, boolean) */ && valueValue instanceof Boolean) {
                    boolean valueValue_ = (boolean) valueValue;
                    if ((isBOrIllegal(frameValue))) {
                        this.state_ = state = state | 0b100 /* add-active writeB(VirtualFrame, boolean) */;
                        lock.unlock();
                        hasLock = false;
                        return writeB(frameValue, valueValue_);
                    }
                }
                if (((exclude & 0b1000)) == 0 /* is-not-excluded writeC(VirtualFrame, char) */ && valueValue instanceof Character) {
                    char valueValue_ = (char) valueValue;
                    if ((isCOrIllegal(frameValue))) {
                        this.state_ = state = state | 0b1000 /* add-active writeC(VirtualFrame, char) */;
                        lock.unlock();
                        hasLock = false;
                        return writeC(frameValue, valueValue_);
                    }
                }
                this.exclude_ = exclude = exclude | 0b1111 /* add-excluded writeI(VirtualFrame, int), writeF(VirtualFrame, float), writeB(VirtualFrame, boolean), writeC(VirtualFrame, char) */;
                state = state & 0xfffffff0 /* remove-active writeI(VirtualFrame, int), writeF(VirtualFrame, float), writeB(VirtualFrame, boolean), writeC(VirtualFrame, char) */;
                this.state_ = state = state | 0b10000 /* add-active write(VirtualFrame, Object) */;
                lock.unlock();
                hasLock = false;
                return write(frameValue, valueValue);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        public static MJWriteLocalVariableNode create(MJExpresionNode value, FrameSlot slot) {
            return new MJWriteLocalVariableNodeGen(value, slot);
        }

    }
}
