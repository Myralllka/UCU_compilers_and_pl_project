// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import org.truffle.cs.mj.nodes.MJBinaryNode;
import org.truffle.cs.mj.nodes.MJExpresionNode;
import org.truffle.cs.mj.nodes.MJBinaryNode.AddNode;
import org.truffle.cs.mj.nodes.MJBinaryNode.BooleanAnd;
import org.truffle.cs.mj.nodes.MJBinaryNode.BooleanOr;
import org.truffle.cs.mj.nodes.MJBinaryNode.DivNode;
import org.truffle.cs.mj.nodes.MJBinaryNode.Equal;
import org.truffle.cs.mj.nodes.MJBinaryNode.GreaterEqual;
import org.truffle.cs.mj.nodes.MJBinaryNode.GreaterThanNode;
import org.truffle.cs.mj.nodes.MJBinaryNode.LessEqual;
import org.truffle.cs.mj.nodes.MJBinaryNode.LessThanNode;
import org.truffle.cs.mj.nodes.MJBinaryNode.ModNode;
import org.truffle.cs.mj.nodes.MJBinaryNode.MulNode;
import org.truffle.cs.mj.nodes.MJBinaryNode.NotEqual;
import org.truffle.cs.mj.nodes.MJBinaryNode.SubNode;

@GeneratedBy(MJBinaryNode.class)
public final class MJBinaryNodeFactory {

    @GeneratedBy(BooleanOr.class)
    public static final class BooleanOrNodeGen extends BooleanOr {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private BooleanOrNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            boolean xValue_ = this.x_.executeBool(frameValue);
            boolean yValue_ = this.y_.executeBool(frameValue);
            if (state != 0 /* is-active or(boolean, boolean) */) {
                return or(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            boolean xValue_ = this.x_.executeBool(frameValue);
            boolean yValue_ = this.y_.executeBool(frameValue);
            if (state != 0 /* is-active or(boolean, boolean) */) {
                return or(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private boolean executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Boolean) {
                boolean xValue_ = (boolean) xValue;
                if (yValue instanceof Boolean) {
                    boolean yValue_ = (boolean) yValue;
                    this.state_ = state = state | 0b1 /* add-active or(boolean, boolean) */;
                    return or(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static BooleanOr create(MJExpresionNode x, MJExpresionNode y) {
            return new BooleanOrNodeGen(x, y);
        }

    }
    @GeneratedBy(BooleanAnd.class)
    public static final class BooleanAndNodeGen extends BooleanAnd {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private BooleanAndNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            boolean xValue_ = this.x_.executeBool(frameValue);
            boolean yValue_ = this.y_.executeBool(frameValue);
            if (state != 0 /* is-active and(boolean, boolean) */) {
                return and(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            boolean xValue_ = this.x_.executeBool(frameValue);
            boolean yValue_ = this.y_.executeBool(frameValue);
            if (state != 0 /* is-active and(boolean, boolean) */) {
                return and(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private boolean executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Boolean) {
                boolean xValue_ = (boolean) xValue;
                if (yValue instanceof Boolean) {
                    boolean yValue_ = (boolean) yValue;
                    this.state_ = state = state | 0b1 /* add-active and(boolean, boolean) */;
                    return and(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static BooleanAnd create(MJExpresionNode x, MJExpresionNode y) {
            return new BooleanAndNodeGen(x, y);
        }

    }
    @GeneratedBy(NotEqual.class)
    public static final class NotEqualNodeGen extends NotEqual {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private NotEqualNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b10) == 0 /* only-active notEqual(int, int) */ && state != 0  /* is-not notEqual(int, int) && notEqual(Object, Object) */) {
                return executeGeneric_int_int0(frameValue, state);
            } else {
                return executeGeneric_generic1(frameValue, state);
            }
        }

        private Object executeGeneric_int_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active notEqual(int, int) */;
            return notEqual(xValue_, yValue_);
        }

        private Object executeGeneric_generic1(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active notEqual(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return notEqual(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active notEqual(Object, Object) */) {
                return notEqual(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b10) == 0 /* only-active notEqual(int, int) */ && state != 0  /* is-not notEqual(int, int) && notEqual(Object, Object) */) {
                return executeBool_int_int2(frameValue, state);
            } else {
                return executeBool_generic3(frameValue, state);
            }
        }

        private boolean executeBool_int_int2(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active notEqual(int, int) */;
            return notEqual(xValue_, yValue_);
        }

        private boolean executeBool_generic3(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active notEqual(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return notEqual(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active notEqual(Object, Object) */) {
                return notEqual(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private boolean executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active notEqual(int, int) */;
                    return notEqual(xValue_, yValue_);
                }
            }
            this.state_ = state = state | 0b10 /* add-active notEqual(Object, Object) */;
            return notEqual(xValue, yValue);
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

        public static NotEqual create(MJExpresionNode x, MJExpresionNode y) {
            return new NotEqualNodeGen(x, y);
        }

    }
    @GeneratedBy(Equal.class)
    public static final class EqualNodeGen extends Equal {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private EqualNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active equal(int, int) */) {
                return equal(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active equal(int, int) */) {
                return equal(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private boolean executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active equal(int, int) */;
                    return equal(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static Equal create(MJExpresionNode x, MJExpresionNode y) {
            return new EqualNodeGen(x, y);
        }

    }
    @GeneratedBy(GreaterEqual.class)
    public static final class GreaterEqualNodeGen extends GreaterEqual {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private GreaterEqualNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active greaterEqual(int, int) */) {
                return greaterEqual(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active greaterEqual(int, int) */) {
                return greaterEqual(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private boolean executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active greaterEqual(int, int) */;
                    return greaterEqual(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static GreaterEqual create(MJExpresionNode x, MJExpresionNode y) {
            return new GreaterEqualNodeGen(x, y);
        }

    }
    @GeneratedBy(LessEqual.class)
    public static final class LessEqualNodeGen extends LessEqual {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private LessEqualNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active lessEqual(int, int) */) {
                return lessEqual(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active lessEqual(int, int) */) {
                return lessEqual(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private boolean executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active lessEqual(int, int) */;
                    return lessEqual(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static LessEqual create(MJExpresionNode x, MJExpresionNode y) {
            return new LessEqualNodeGen(x, y);
        }

    }
    @GeneratedBy(GreaterThanNode.class)
    public static final class GreaterThanNodeGen extends GreaterThanNode {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private GreaterThanNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active greaterThan(int, int) */) {
                return greaterThan(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active greaterThan(int, int) */) {
                return greaterThan(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private boolean executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active greaterThan(int, int) */;
                    return greaterThan(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static GreaterThanNode create(MJExpresionNode x, MJExpresionNode y) {
            return new GreaterThanNodeGen(x, y);
        }

    }
    @GeneratedBy(LessThanNode.class)
    public static final class LessThanNodeGen extends LessThanNode {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private LessThanNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active lessThan(int, int) */) {
                return lessThan(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active lessThan(int, int) */) {
                return lessThan(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private boolean executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active lessThan(int, int) */;
                    return lessThan(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static LessThanNode create(MJExpresionNode x, MJExpresionNode y) {
            return new LessThanNodeGen(x, y);
        }

    }
    @GeneratedBy(AddNode.class)
    public static final class AddNodeGen extends AddNode {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private AddNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active add(int, int) */) {
                return add(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active add(int, int) */) {
                return add(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private int executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active add(int, int) */;
                    return add(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static AddNode create(MJExpresionNode x, MJExpresionNode y) {
            return new AddNodeGen(x, y);
        }

    }
    @GeneratedBy(SubNode.class)
    public static final class SubNodeGen extends SubNode {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private SubNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active sub(int, int) */) {
                return sub(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active sub(int, int) */) {
                return sub(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private int executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active sub(int, int) */;
                    return sub(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static SubNode create(MJExpresionNode x, MJExpresionNode y) {
            return new SubNodeGen(x, y);
        }

    }
    @GeneratedBy(MulNode.class)
    public static final class MulNodeGen extends MulNode {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private MulNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active mul(int, int) */) {
                return mul(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active mul(int, int) */) {
                return mul(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private int executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active mul(int, int) */;
                    return mul(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static MulNode create(MJExpresionNode x, MJExpresionNode y) {
            return new MulNodeGen(x, y);
        }

    }
    @GeneratedBy(DivNode.class)
    public static final class DivNodeGen extends DivNode {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private DivNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active div(int, int) */) {
                return div(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active div(int, int) */) {
                return div(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private int executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active div(int, int) */;
                    return div(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static DivNode create(MJExpresionNode x, MJExpresionNode y) {
            return new DivNodeGen(x, y);
        }

    }
    @GeneratedBy(ModNode.class)
    public static final class ModNodeGen extends ModNode {

        @Child private MJExpresionNode x_;
        @Child private MJExpresionNode y_;
        @CompilationFinal private int state_;

        private ModNodeGen(MJExpresionNode x, MJExpresionNode y) {
            this.x_ = x;
            this.y_ = y;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active mod(int, int) */) {
                return mod(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if (state != 0 /* is-active mod(int, int) */) {
                return mod(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        private int executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active mod(int, int) */;
                    return mod(xValue_, yValue_);
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.x_, this.y_}, xValue, yValue);
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

        public static ModNode create(MJExpresionNode x, MJExpresionNode y) {
            return new ModNodeGen(x, y);
        }

    }
}
