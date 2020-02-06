// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import org.truffle.cs.mj.nodes.MJExpresionNode;
import org.truffle.cs.mj.nodes.MJUnaryNode;
import org.truffle.cs.mj.nodes.MJUnaryNode.NegNode;
import org.truffle.cs.mj.nodes.MJUnaryNode.NotNode;

@GeneratedBy(MJUnaryNode.class)
public final class MJUnaryNodeFactory {

    @GeneratedBy(NotNode.class)
    public static final class NotNodeGen extends NotNode {

        @Child private MJExpresionNode x_;
        @CompilationFinal private int state_;

        private NotNodeGen(MJExpresionNode x) {
            this.x_ = x;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            boolean xValue_ = this.x_.executeBool(frameValue);
            if (state != 0 /* is-active not(boolean) */) {
                return not(xValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            boolean xValue_ = this.x_.executeBool(frameValue);
            if (state != 0 /* is-active not(boolean) */) {
                return not(xValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_);
        }

        private boolean executeAndSpecialize(Object xValue) {
            int state = state_;
            if (xValue instanceof Boolean) {
                boolean xValue_ = (boolean) xValue;
                this.state_ = state = state | 0b1 /* add-active not(boolean) */;
                return not(xValue_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_}, xValue);
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else {
                return NodeCost.MONOMORPHIC;
            }
        }

        public static NotNode create(MJExpresionNode x) {
            return new NotNodeGen(x);
        }

    }
    @GeneratedBy(NegNode.class)
    public static final class NegNodeGen extends NegNode {

        @Child private MJExpresionNode x_;
        @CompilationFinal private int state_;

        private NegNodeGen(MJExpresionNode x) {
            this.x_ = x;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b10) == 0 /* only-active neg(int) */ && state != 0  /* is-not neg(int) && neg(float) */) {
                return executeGeneric_int0(frameValue, state);
            } else if ((state & 0b1) == 0 /* only-active neg(float) */ && state != 0  /* is-not neg(int) && neg(float) */) {
                return executeGeneric_float1(frameValue, state);
            } else {
                return executeGeneric_generic2(frameValue, state);
            }
        }

        private Object executeGeneric_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active neg(int) */;
            return neg(xValue_);
        }

        private Object executeGeneric_float1(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active neg(float) */;
            return neg(xValue_);
        }

        private Object executeGeneric_generic2(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active neg(int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                return neg(xValue__);
            }
            if ((state & 0b10) != 0 /* is-active neg(float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                return neg(xValue__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new AssertionError("Delegation failed.");
        }

        @Override
        public float executeF32(VirtualFrame frameValue) {
            int state = state_;
            float xValue_ = this.x_.executeF32(frameValue);
            if ((state & 0b10) != 0 /* is-active neg(float) */) {
                return neg(xValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (float) executeAndSpecialize(xValue_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            if ((state & 0b1) != 0 /* is-active neg(int) */) {
                return neg(xValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (int) executeAndSpecialize(xValue_);
        }

        private Object executeAndSpecialize(Object xValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                this.state_ = state = state | 0b1 /* add-active neg(int) */;
                return neg(xValue_);
            }
            if (xValue instanceof Float) {
                float xValue_ = (float) xValue;
                this.state_ = state = state | 0b10 /* add-active neg(float) */;
                return neg(xValue_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_}, xValue);
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

        public static NegNode create(MJExpresionNode x) {
            return new NegNodeGen(x);
        }

    }
}
