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
import org.truffle.cs.mj.nodes.MJAbsNode;
import org.truffle.cs.mj.nodes.MJExpresionNode;

@GeneratedBy(MJAbsNode.class)
public final class MJAbsNodeGen extends MJAbsNode {

    @Child private MJExpresionNode expression_;
    @CompilationFinal private int state_;

    private MJAbsNodeGen(MJExpresionNode expression) {
        this.expression_ = expression;
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b10) == 0 /* only-active absI(int) */ && state != 0  /* is-not absI(int) && absF(float) */) {
            return executeGeneric_int0(frameValue, state);
        } else if ((state & 0b1) == 0 /* only-active absF(float) */ && state != 0  /* is-not absI(int) && absF(float) */) {
            return executeGeneric_float1(frameValue, state);
        } else {
            return executeGeneric_generic2(frameValue, state);
        }
    }

    private Object executeGeneric_int0(VirtualFrame frameValue, int state) {
        int expressionValue_;
        try {
            expressionValue_ = this.expression_.executeI32(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active absI(int) */;
        return absI(expressionValue_);
    }

    private Object executeGeneric_float1(VirtualFrame frameValue, int state) {
        float expressionValue_;
        try {
            expressionValue_ = this.expression_.executeF32(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b10) != 0 /* is-active absF(float) */;
        return absF(expressionValue_);
    }

    private Object executeGeneric_generic2(VirtualFrame frameValue, int state) {
        Object expressionValue_ = this.expression_.executeGeneric(frameValue);
        if ((state & 0b1) != 0 /* is-active absI(int) */ && expressionValue_ instanceof Integer) {
            int expressionValue__ = (int) expressionValue_;
            return absI(expressionValue__);
        }
        if ((state & 0b10) != 0 /* is-active absF(float) */ && expressionValue_ instanceof Float) {
            float expressionValue__ = (float) expressionValue_;
            return absF(expressionValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(expressionValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeGeneric(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object expressionValue) {
        int state = state_;
        if (expressionValue instanceof Integer) {
            int expressionValue_ = (int) expressionValue;
            this.state_ = state = state | 0b1 /* add-active absI(int) */;
            return absI(expressionValue_);
        }
        if (expressionValue instanceof Float) {
            float expressionValue_ = (float) expressionValue;
            this.state_ = state = state | 0b10 /* add-active absF(float) */;
            return absF(expressionValue_);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {this.expression_}, expressionValue);
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

    public static MJAbsNode create(MJExpresionNode expression) {
        return new MJAbsNodeGen(expression);
    }

}
