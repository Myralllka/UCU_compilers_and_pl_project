// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.truffle.cs.mj.nodes.MJExpresionNode;
import org.truffle.cs.mj.nodes.MJPrintNode;

@GeneratedBy(MJPrintNode.class)
public final class MJPrintNodeGen extends MJPrintNode {

    @Child private MJExpresionNode expression_;
    @CompilationFinal private int state_;

    private MJPrintNodeGen(MJExpresionNode expression) {
        this.expression_ = expression;
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b11110) == 0 /* only-active printI(int) */ && state != 0  /* is-not printI(int) && printF(float) && printC(char) && printB(boolean) && printO(Object) */) {
            return execute_int0(frameValue, state);
        } else if ((state & 0b11101) == 0 /* only-active printF(float) */ && state != 0  /* is-not printI(int) && printF(float) && printC(char) && printB(boolean) && printO(Object) */) {
            return execute_float1(frameValue, state);
        } else if ((state & 0b11011) == 0 /* only-active printC(char) */ && state != 0  /* is-not printI(int) && printF(float) && printC(char) && printB(boolean) && printO(Object) */) {
            return execute_char2(frameValue, state);
        } else if ((state & 0b10111) == 0 /* only-active printB(boolean) */ && state != 0  /* is-not printI(int) && printF(float) && printC(char) && printB(boolean) && printO(Object) */) {
            return execute_boolean3(frameValue, state);
        } else {
            return execute_generic4(frameValue, state);
        }
    }

    private Object execute_int0(VirtualFrame frameValue, int state) {
        int expressionValue_;
        try {
            expressionValue_ = this.expression_.executeI32(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active printI(int) */;
        return printI(expressionValue_);
    }

    private Object execute_float1(VirtualFrame frameValue, int state) {
        float expressionValue_;
        try {
            expressionValue_ = this.expression_.executeF32(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b10) != 0 /* is-active printF(float) */;
        return printF(expressionValue_);
    }

    private Object execute_char2(VirtualFrame frameValue, int state) {
        char expressionValue_;
        try {
            expressionValue_ = this.expression_.executeChar(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b100) != 0 /* is-active printC(char) */;
        return printC(expressionValue_);
    }

    private Object execute_boolean3(VirtualFrame frameValue, int state) {
        boolean expressionValue_;
        try {
            expressionValue_ = this.expression_.executeBool(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        assert (state & 0b1000) != 0 /* is-active printB(boolean) */;
        return printB(expressionValue_);
    }

    private Object execute_generic4(VirtualFrame frameValue, int state) {
        Object expressionValue_ = this.expression_.executeGeneric(frameValue);
        if ((state & 0b1) != 0 /* is-active printI(int) */ && expressionValue_ instanceof Integer) {
            int expressionValue__ = (int) expressionValue_;
            return printI(expressionValue__);
        }
        if ((state & 0b10) != 0 /* is-active printF(float) */ && expressionValue_ instanceof Float) {
            float expressionValue__ = (float) expressionValue_;
            return printF(expressionValue__);
        }
        if ((state & 0b100) != 0 /* is-active printC(char) */ && expressionValue_ instanceof Character) {
            char expressionValue__ = (char) expressionValue_;
            return printC(expressionValue__);
        }
        if ((state & 0b1000) != 0 /* is-active printB(boolean) */ && expressionValue_ instanceof Boolean) {
            boolean expressionValue__ = (boolean) expressionValue_;
            return printB(expressionValue__);
        }
        if ((state & 0b10000) != 0 /* is-active printO(Object) */) {
            return printO(expressionValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(expressionValue_);
    }

    private Object executeAndSpecialize(Object expressionValue) {
        int state = state_;
        if (expressionValue instanceof Integer) {
            int expressionValue_ = (int) expressionValue;
            this.state_ = state = state | 0b1 /* add-active printI(int) */;
            return printI(expressionValue_);
        }
        if (expressionValue instanceof Float) {
            float expressionValue_ = (float) expressionValue;
            this.state_ = state = state | 0b10 /* add-active printF(float) */;
            return printF(expressionValue_);
        }
        if (expressionValue instanceof Character) {
            char expressionValue_ = (char) expressionValue;
            this.state_ = state = state | 0b100 /* add-active printC(char) */;
            return printC(expressionValue_);
        }
        if (expressionValue instanceof Boolean) {
            boolean expressionValue_ = (boolean) expressionValue;
            this.state_ = state = state | 0b1000 /* add-active printB(boolean) */;
            return printB(expressionValue_);
        }
        this.state_ = state = state | 0b10000 /* add-active printO(Object) */;
        return printO(expressionValue);
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

    public static MJPrintNode create(MJExpresionNode expression) {
        return new MJPrintNodeGen(expression);
    }

}
