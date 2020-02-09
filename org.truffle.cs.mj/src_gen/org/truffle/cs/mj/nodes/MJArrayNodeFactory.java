// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.truffle.cs.mj.nodes.MJArrayNode;
import org.truffle.cs.mj.nodes.MJExpresionNode;
import org.truffle.cs.mj.nodes.MJArrayNode.ArrayReadNode;
import org.truffle.cs.mj.nodes.MJArrayNode.BufferArray;
import org.truffle.cs.mj.nodes.MJArrayNode.SequenceArray;

@GeneratedBy(MJArrayNode.class)
public final class MJArrayNodeFactory {

    @GeneratedBy(ArrayReadNode.class)
    static final class ArrayReadNodeGen extends ArrayReadNode {

        @Child private MJExpresionNode child0_;
        @Child private MJExpresionNode child1_;
        @CompilationFinal private int state_;

        private ArrayReadNodeGen(MJExpresionNode child0, MJExpresionNode child1) {
            this.child0_ = child0;
            this.child1_ = child1;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            Object child0Value_ = this.child0_.executeGeneric(frameValue);
            int child1Value_;
            try {
                child1Value_ = this.child1_.executeI32(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(child0Value_, ex.getResult());
            }
            if ((state & 0b1) != 0 /* is-active doBuffer(BufferArray, int) */ && child0Value_ instanceof BufferArray) {
                BufferArray child0Value__ = (BufferArray) child0Value_;
                return doBuffer(child0Value__, child1Value_);
            }
            if ((state & 0b10) != 0 /* is-active doSequence(SequenceArray, int) */ && child0Value_ instanceof SequenceArray) {
                SequenceArray child0Value__ = (SequenceArray) child0Value_;
                return doSequence(child0Value__, child1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(child0Value_, child1Value_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            Object child0Value_ = this.child0_.executeGeneric(frameValue);
            int child1Value_;
            try {
                child1Value_ = this.child1_.executeI32(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(child0Value_, ex.getResult());
            }
            if ((state & 0b1) != 0 /* is-active doBuffer(BufferArray, int) */ && child0Value_ instanceof BufferArray) {
                BufferArray child0Value__ = (BufferArray) child0Value_;
                return doBuffer(child0Value__, child1Value_);
            }
            if ((state & 0b10) != 0 /* is-active doSequence(SequenceArray, int) */ && child0Value_ instanceof SequenceArray) {
                SequenceArray child0Value__ = (SequenceArray) child0Value_;
                return doSequence(child0Value__, child1Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(child0Value_, child1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeI32(frameValue);
            return;
        }

        private int executeAndSpecialize(Object child0Value, Object child1Value) {
            int state = state_;
            if (child1Value instanceof Integer) {
                int child1Value_ = (int) child1Value;
                if (child0Value instanceof BufferArray) {
                    BufferArray child0Value_ = (BufferArray) child0Value;
                    this.state_ = state = state | 0b1 /* add-active doBuffer(BufferArray, int) */;
                    return doBuffer(child0Value_, child1Value_);
                }
                if (child0Value instanceof SequenceArray) {
                    SequenceArray child0Value_ = (SequenceArray) child0Value;
                    this.state_ = state = state | 0b10 /* add-active doSequence(SequenceArray, int) */;
                    return doSequence(child0Value_, child1Value_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.child0_, this.child1_}, child0Value, child1Value);
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

        public static ArrayReadNode create(MJExpresionNode child0, MJExpresionNode child1) {
            return new ArrayReadNodeGen(child0, child1);
        }

    }
}
