// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import org.truffle.cs.mj.nodes.MJExpresionNode;
import org.truffle.cs.mj.nodes.MJPrintNode;

@GeneratedBy(MJPrintNode.class)
public final class MJPrintNodeGen extends MJPrintNode {

    @Child private MJExpresionNode expresion_;
    @CompilationFinal private int state_;

    private MJPrintNodeGen(MJExpresionNode expresion) {
        this.expresion_ = expresion;
    }

    @Override
    public Object execute(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b10) == 0 /* only-active printI(int) */ && state != 0  /* is-not printI(int) && printO(Object) */) {
            return execute_int0(frameValue, state);
        } else {
            return execute_generic1(frameValue, state);
        }
    }

    private Object execute_int0(VirtualFrame frameValue, int state) {
        int expresionValue_ = this.expresion_.executeI32(frameValue);
        assert (state & 0b1) != 0 /* is-active printI(int) */;
        return printI(expresionValue_);
    }

    private Object execute_generic1(VirtualFrame frameValue, int state) {
        Object expresionValue_ = this.expresion_.executeGeneric(frameValue);
        if ((state & 0b1) != 0 /* is-active printI(int) */ && expresionValue_ instanceof Integer) {
            int expresionValue__ = (int) expresionValue_;
            return printI(expresionValue__);
        }
        if ((state & 0b10) != 0 /* is-active printO(Object) */) {
            return printO(expresionValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(expresionValue_);
    }

    private Object executeAndSpecialize(Object expresionValue) {
        int state = state_;
        if (expresionValue instanceof Integer) {
            int expresionValue_ = (int) expresionValue;
            this.state_ = state = state | 0b1 /* add-active printI(int) */;
            return printI(expresionValue_);
        }
        this.state_ = state = state | 0b10 /* add-active printO(Object) */;
        return printO(expresionValue);
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

    public static MJPrintNode create(MJExpresionNode expresion) {
        return new MJPrintNodeGen(expresion);
    }

}
