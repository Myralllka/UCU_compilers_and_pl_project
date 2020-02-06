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
            if ((state & 0b110) == 0 /* only-active notEqual(int, int) */ && state != 0  /* is-not notEqual(int, int) && notEqual(float, float) && notEqual(Object, Object) */) {
                return executeGeneric_int_int0(frameValue, state);
            } else if ((state & 0b101) == 0 /* only-active notEqual(float, float) */ && state != 0  /* is-not notEqual(int, int) && notEqual(float, float) && notEqual(Object, Object) */) {
                return executeGeneric_float_float1(frameValue, state);
            } else {
                return executeGeneric_generic2(frameValue, state);
            }
        }

        private Object executeGeneric_int_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active notEqual(int, int) */;
            return notEqual(xValue_, yValue_);
        }

        private Object executeGeneric_float_float1(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active notEqual(float, float) */;
            return notEqual(xValue_, yValue_);
        }

        private Object executeGeneric_generic2(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active notEqual(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return notEqual(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active notEqual(float, float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if (yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return notEqual(xValue__, yValue__);
                }
            }
            if ((state & 0b100) != 0 /* is-active notEqual(Object, Object) */) {
                return notEqual(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b110) == 0 /* only-active notEqual(int, int) */ && state != 0  /* is-not notEqual(int, int) && notEqual(float, float) && notEqual(Object, Object) */) {
                return executeBool_int_int3(frameValue, state);
            } else if ((state & 0b101) == 0 /* only-active notEqual(float, float) */ && state != 0  /* is-not notEqual(int, int) && notEqual(float, float) && notEqual(Object, Object) */) {
                return executeBool_float_float4(frameValue, state);
            } else {
                return executeBool_generic5(frameValue, state);
            }
        }

        private boolean executeBool_int_int3(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active notEqual(int, int) */;
            return notEqual(xValue_, yValue_);
        }

        private boolean executeBool_float_float4(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active notEqual(float, float) */;
            return notEqual(xValue_, yValue_);
        }

        private boolean executeBool_generic5(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active notEqual(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return notEqual(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active notEqual(float, float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if (yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return notEqual(xValue__, yValue__);
                }
            }
            if ((state & 0b100) != 0 /* is-active notEqual(Object, Object) */) {
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
            if (xValue instanceof Float) {
                float xValue_ = (float) xValue;
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b10 /* add-active notEqual(float, float) */;
                    return notEqual(xValue_, yValue_);
                }
            }
            this.state_ = state = state | 0b100 /* add-active notEqual(Object, Object) */;
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
            if ((state & 0b10) == 0 /* only-active greaterEqual(int, int) */ && state != 0  /* is-not greaterEqual(int, int) && greaterEqual(float, float) */) {
                return executeGeneric_int_int0(frameValue, state);
            } else if ((state & 0b1) == 0 /* only-active greaterEqual(float, float) */ && state != 0  /* is-not greaterEqual(int, int) && greaterEqual(float, float) */) {
                return executeGeneric_float_float1(frameValue, state);
            } else {
                return executeGeneric_generic2(frameValue, state);
            }
        }

        private Object executeGeneric_int_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active greaterEqual(int, int) */;
            return greaterEqual(xValue_, yValue_);
        }

        private Object executeGeneric_float_float1(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active greaterEqual(float, float) */;
            return greaterEqual(xValue_, yValue_);
        }

        private Object executeGeneric_generic2(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active greaterEqual(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return greaterEqual(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active greaterEqual(float, float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if (yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return greaterEqual(xValue__, yValue__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b10) == 0 /* only-active greaterEqual(int, int) */ && state != 0  /* is-not greaterEqual(int, int) && greaterEqual(float, float) */) {
                return executeBool_int_int3(frameValue, state);
            } else if ((state & 0b1) == 0 /* only-active greaterEqual(float, float) */ && state != 0  /* is-not greaterEqual(int, int) && greaterEqual(float, float) */) {
                return executeBool_float_float4(frameValue, state);
            } else {
                return executeBool_generic5(frameValue, state);
            }
        }

        private boolean executeBool_int_int3(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active greaterEqual(int, int) */;
            return greaterEqual(xValue_, yValue_);
        }

        private boolean executeBool_float_float4(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active greaterEqual(float, float) */;
            return greaterEqual(xValue_, yValue_);
        }

        private boolean executeBool_generic5(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active greaterEqual(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return greaterEqual(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active greaterEqual(float, float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if (yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return greaterEqual(xValue__, yValue__);
                }
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
            if (xValue instanceof Float) {
                float xValue_ = (float) xValue;
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b10 /* add-active greaterEqual(float, float) */;
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
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
            if ((state & 0b10) == 0 /* only-active lessEqual(int, int) */ && state != 0  /* is-not lessEqual(int, int) && lessEqual(float, float) */) {
                return executeGeneric_int_int0(frameValue, state);
            } else if ((state & 0b1) == 0 /* only-active lessEqual(float, float) */ && state != 0  /* is-not lessEqual(int, int) && lessEqual(float, float) */) {
                return executeGeneric_float_float1(frameValue, state);
            } else {
                return executeGeneric_generic2(frameValue, state);
            }
        }

        private Object executeGeneric_int_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active lessEqual(int, int) */;
            return lessEqual(xValue_, yValue_);
        }

        private Object executeGeneric_float_float1(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active lessEqual(float, float) */;
            return lessEqual(xValue_, yValue_);
        }

        private Object executeGeneric_generic2(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active lessEqual(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return lessEqual(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active lessEqual(float, float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if (yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return lessEqual(xValue__, yValue__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b10) == 0 /* only-active lessEqual(int, int) */ && state != 0  /* is-not lessEqual(int, int) && lessEqual(float, float) */) {
                return executeBool_int_int3(frameValue, state);
            } else if ((state & 0b1) == 0 /* only-active lessEqual(float, float) */ && state != 0  /* is-not lessEqual(int, int) && lessEqual(float, float) */) {
                return executeBool_float_float4(frameValue, state);
            } else {
                return executeBool_generic5(frameValue, state);
            }
        }

        private boolean executeBool_int_int3(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active lessEqual(int, int) */;
            return lessEqual(xValue_, yValue_);
        }

        private boolean executeBool_float_float4(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active lessEqual(float, float) */;
            return lessEqual(xValue_, yValue_);
        }

        private boolean executeBool_generic5(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active lessEqual(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return lessEqual(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active lessEqual(float, float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if (yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return lessEqual(xValue__, yValue__);
                }
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
            if (xValue instanceof Float) {
                float xValue_ = (float) xValue;
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b10 /* add-active lessEqual(float, float) */;
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
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
            if ((state & 0b10) == 0 /* only-active greaterThan(int, int) */ && state != 0  /* is-not greaterThan(int, int) && greaterThan(float, float) */) {
                return executeGeneric_int_int0(frameValue, state);
            } else if ((state & 0b1) == 0 /* only-active greaterThan(float, float) */ && state != 0  /* is-not greaterThan(int, int) && greaterThan(float, float) */) {
                return executeGeneric_float_float1(frameValue, state);
            } else {
                return executeGeneric_generic2(frameValue, state);
            }
        }

        private Object executeGeneric_int_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active greaterThan(int, int) */;
            return greaterThan(xValue_, yValue_);
        }

        private Object executeGeneric_float_float1(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active greaterThan(float, float) */;
            return greaterThan(xValue_, yValue_);
        }

        private Object executeGeneric_generic2(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active greaterThan(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return greaterThan(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active greaterThan(float, float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if (yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return greaterThan(xValue__, yValue__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b10) == 0 /* only-active greaterThan(int, int) */ && state != 0  /* is-not greaterThan(int, int) && greaterThan(float, float) */) {
                return executeBool_int_int3(frameValue, state);
            } else if ((state & 0b1) == 0 /* only-active greaterThan(float, float) */ && state != 0  /* is-not greaterThan(int, int) && greaterThan(float, float) */) {
                return executeBool_float_float4(frameValue, state);
            } else {
                return executeBool_generic5(frameValue, state);
            }
        }

        private boolean executeBool_int_int3(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active greaterThan(int, int) */;
            return greaterThan(xValue_, yValue_);
        }

        private boolean executeBool_float_float4(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active greaterThan(float, float) */;
            return greaterThan(xValue_, yValue_);
        }

        private boolean executeBool_generic5(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active greaterThan(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return greaterThan(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active greaterThan(float, float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if (yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return greaterThan(xValue__, yValue__);
                }
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
            if (xValue instanceof Float) {
                float xValue_ = (float) xValue;
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b10 /* add-active greaterThan(float, float) */;
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
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
            if ((state & 0b10) == 0 /* only-active lessThan(int, int) */ && state != 0  /* is-not lessThan(int, int) && lessThan(float, float) */) {
                return executeGeneric_int_int0(frameValue, state);
            } else if ((state & 0b1) == 0 /* only-active lessThan(float, float) */ && state != 0  /* is-not lessThan(int, int) && lessThan(float, float) */) {
                return executeGeneric_float_float1(frameValue, state);
            } else {
                return executeGeneric_generic2(frameValue, state);
            }
        }

        private Object executeGeneric_int_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active lessThan(int, int) */;
            return lessThan(xValue_, yValue_);
        }

        private Object executeGeneric_float_float1(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active lessThan(float, float) */;
            return lessThan(xValue_, yValue_);
        }

        private Object executeGeneric_generic2(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active lessThan(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return lessThan(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active lessThan(float, float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if (yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return lessThan(xValue__, yValue__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public boolean executeBool(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b10) == 0 /* only-active lessThan(int, int) */ && state != 0  /* is-not lessThan(int, int) && lessThan(float, float) */) {
                return executeBool_int_int3(frameValue, state);
            } else if ((state & 0b1) == 0 /* only-active lessThan(float, float) */ && state != 0  /* is-not lessThan(int, int) && lessThan(float, float) */) {
                return executeBool_float_float4(frameValue, state);
            } else {
                return executeBool_generic5(frameValue, state);
            }
        }

        private boolean executeBool_int_int3(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active lessThan(int, int) */;
            return lessThan(xValue_, yValue_);
        }

        private boolean executeBool_float_float4(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active lessThan(float, float) */;
            return lessThan(xValue_, yValue_);
        }

        private boolean executeBool_generic5(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active lessThan(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return lessThan(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active lessThan(float, float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if (yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return lessThan(xValue__, yValue__);
                }
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
            if (xValue instanceof Float) {
                float xValue_ = (float) xValue;
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b10 /* add-active lessThan(float, float) */;
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
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
            if ((state & 0b1110) == 0 /* only-active add(int, int) */ && state != 0  /* is-not add(int, int) && add(int, float) && add(float, float) && add(float, int) */) {
                return executeGeneric_int_int0(frameValue, state);
            } else if ((state & 0b1101) == 0 /* only-active add(int, float) */ && state != 0  /* is-not add(int, int) && add(int, float) && add(float, float) && add(float, int) */) {
                return executeGeneric_int_float1(frameValue, state);
            } else if ((state & 0b1011) == 0 /* only-active add(float, float) */ && state != 0  /* is-not add(int, int) && add(int, float) && add(float, float) && add(float, int) */) {
                return executeGeneric_float_float2(frameValue, state);
            } else if ((state & 0b111) == 0 /* only-active add(float, int) */ && state != 0  /* is-not add(int, int) && add(int, float) && add(float, float) && add(float, int) */) {
                return executeGeneric_float_int3(frameValue, state);
            } else {
                return executeGeneric_generic4(frameValue, state);
            }
        }

        private Object executeGeneric_int_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active add(int, int) */;
            return add(xValue_, yValue_);
        }

        private Object executeGeneric_int_float1(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active add(int, float) */;
            return add(xValue_, yValue_);
        }

        private Object executeGeneric_float_float2(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b100) != 0 /* is-active add(float, float) */;
            return add(xValue_, yValue_);
        }

        private Object executeGeneric_float_int3(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1000) != 0 /* is-active add(float, int) */;
            return add(xValue_, yValue_);
        }

        private Object executeGeneric_generic4(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b11) != 0 /* is-active add(int, int) || add(int, float) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if ((state & 0b1) != 0 /* is-active add(int, int) */ && yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return add(xValue__, yValue__);
                }
                if ((state & 0b10) != 0 /* is-active add(int, float) */ && yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return add(xValue__, yValue__);
                }
            }
            if ((state & 0b1100) != 0 /* is-active add(float, float) || add(float, int) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if ((state & 0b100) != 0 /* is-active add(float, float) */ && yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return add(xValue__, yValue__);
                }
                if ((state & 0b1000) != 0 /* is-active add(float, int) */ && yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return add(xValue__, yValue__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
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
            if ((state & 0b1000) == 0 /* only-active add(float, float) */ && (state & 0b1100) != 0  /* is-not add(float, float) && add(float, int) */) {
                return executeF32_float5(frameValue, state, xValue_);
            } else if ((state & 0b100) == 0 /* only-active add(float, int) */ && (state & 0b1100) != 0  /* is-not add(float, float) && add(float, int) */) {
                return executeF32_int6(frameValue, state, xValue_);
            } else {
                return executeF32_generic7(frameValue, state, xValue_);
            }
        }

        private float executeF32_float5(VirtualFrame frameValue, int state, float xValue_) {
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b100) != 0 /* is-active add(float, float) */;
            return add(xValue_, yValue_);
        }

        private float executeF32_int6(VirtualFrame frameValue, int state, float xValue_) {
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1000) != 0 /* is-active add(float, int) */;
            return add(xValue_, yValue_);
        }

        private float executeF32_generic7(VirtualFrame frameValue, int state, float xValue_) {
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b100) != 0 /* is-active add(float, float) */ && yValue_ instanceof Float) {
                float yValue__ = (float) yValue_;
                return add(xValue_, yValue__);
            }
            if ((state & 0b1000) != 0 /* is-active add(float, int) */ && yValue_ instanceof Integer) {
                int yValue__ = (int) yValue_;
                return add(xValue_, yValue__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (float) executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            if ((state & 0b10) == 0 /* only-active add(int, int) */ && (state & 0b11) != 0  /* is-not add(int, int) && add(int, float) */) {
                return executeI32_int8(frameValue, state, xValue_);
            } else if ((state & 0b1) == 0 /* only-active add(int, float) */ && (state & 0b11) != 0  /* is-not add(int, int) && add(int, float) */) {
                return executeI32_float9(frameValue, state, xValue_);
            } else {
                return executeI32_generic10(frameValue, state, xValue_);
            }
        }

        private int executeI32_int8(VirtualFrame frameValue, int state, int xValue_) {
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active add(int, int) */;
            return add(xValue_, yValue_);
        }

        private int executeI32_float9(VirtualFrame frameValue, int state, int xValue_) {
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active add(int, float) */;
            return add(xValue_, yValue_);
        }

        private int executeI32_generic10(VirtualFrame frameValue, int state, int xValue_) {
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active add(int, int) */ && yValue_ instanceof Integer) {
                int yValue__ = (int) yValue_;
                return add(xValue_, yValue__);
            }
            if ((state & 0b10) != 0 /* is-active add(int, float) */ && yValue_ instanceof Float) {
                float yValue__ = (float) yValue_;
                return add(xValue_, yValue__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (int) executeAndSpecialize(xValue_, yValue_);
        }

        private Object executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active add(int, int) */;
                    return add(xValue_, yValue_);
                }
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b10 /* add-active add(int, float) */;
                    return add(xValue_, yValue_);
                }
            }
            if (xValue instanceof Float) {
                float xValue_ = (float) xValue;
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b100 /* add-active add(float, float) */;
                    return add(xValue_, yValue_);
                }
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1000 /* add-active add(float, int) */;
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
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
            if ((state & 0b1110) == 0 /* only-active sub(int, int) */ && state != 0  /* is-not sub(int, int) && sub(int, float) && sub(float, float) && sub(float, int) */) {
                return executeGeneric_int_int0(frameValue, state);
            } else if ((state & 0b1101) == 0 /* only-active sub(int, float) */ && state != 0  /* is-not sub(int, int) && sub(int, float) && sub(float, float) && sub(float, int) */) {
                return executeGeneric_int_float1(frameValue, state);
            } else if ((state & 0b1011) == 0 /* only-active sub(float, float) */ && state != 0  /* is-not sub(int, int) && sub(int, float) && sub(float, float) && sub(float, int) */) {
                return executeGeneric_float_float2(frameValue, state);
            } else if ((state & 0b111) == 0 /* only-active sub(float, int) */ && state != 0  /* is-not sub(int, int) && sub(int, float) && sub(float, float) && sub(float, int) */) {
                return executeGeneric_float_int3(frameValue, state);
            } else {
                return executeGeneric_generic4(frameValue, state);
            }
        }

        private Object executeGeneric_int_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active sub(int, int) */;
            return sub(xValue_, yValue_);
        }

        private Object executeGeneric_int_float1(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active sub(int, float) */;
            return sub(xValue_, yValue_);
        }

        private Object executeGeneric_float_float2(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b100) != 0 /* is-active sub(float, float) */;
            return sub(xValue_, yValue_);
        }

        private Object executeGeneric_float_int3(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1000) != 0 /* is-active sub(float, int) */;
            return sub(xValue_, yValue_);
        }

        private Object executeGeneric_generic4(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b11) != 0 /* is-active sub(int, int) || sub(int, float) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if ((state & 0b1) != 0 /* is-active sub(int, int) */ && yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return sub(xValue__, yValue__);
                }
                if ((state & 0b10) != 0 /* is-active sub(int, float) */ && yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return sub(xValue__, yValue__);
                }
            }
            if ((state & 0b1100) != 0 /* is-active sub(float, float) || sub(float, int) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if ((state & 0b100) != 0 /* is-active sub(float, float) */ && yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return sub(xValue__, yValue__);
                }
                if ((state & 0b1000) != 0 /* is-active sub(float, int) */ && yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return sub(xValue__, yValue__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
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
            if ((state & 0b1000) == 0 /* only-active sub(float, float) */ && (state & 0b1100) != 0  /* is-not sub(float, float) && sub(float, int) */) {
                return executeF32_float5(frameValue, state, xValue_);
            } else if ((state & 0b100) == 0 /* only-active sub(float, int) */ && (state & 0b1100) != 0  /* is-not sub(float, float) && sub(float, int) */) {
                return executeF32_int6(frameValue, state, xValue_);
            } else {
                return executeF32_generic7(frameValue, state, xValue_);
            }
        }

        private float executeF32_float5(VirtualFrame frameValue, int state, float xValue_) {
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b100) != 0 /* is-active sub(float, float) */;
            return sub(xValue_, yValue_);
        }

        private float executeF32_int6(VirtualFrame frameValue, int state, float xValue_) {
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1000) != 0 /* is-active sub(float, int) */;
            return sub(xValue_, yValue_);
        }

        private float executeF32_generic7(VirtualFrame frameValue, int state, float xValue_) {
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b100) != 0 /* is-active sub(float, float) */ && yValue_ instanceof Float) {
                float yValue__ = (float) yValue_;
                return sub(xValue_, yValue__);
            }
            if ((state & 0b1000) != 0 /* is-active sub(float, int) */ && yValue_ instanceof Integer) {
                int yValue__ = (int) yValue_;
                return sub(xValue_, yValue__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (float) executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            if ((state & 0b10) == 0 /* only-active sub(int, int) */ && (state & 0b11) != 0  /* is-not sub(int, int) && sub(int, float) */) {
                return executeI32_int8(frameValue, state, xValue_);
            } else if ((state & 0b1) == 0 /* only-active sub(int, float) */ && (state & 0b11) != 0  /* is-not sub(int, int) && sub(int, float) */) {
                return executeI32_float9(frameValue, state, xValue_);
            } else {
                return executeI32_generic10(frameValue, state, xValue_);
            }
        }

        private int executeI32_int8(VirtualFrame frameValue, int state, int xValue_) {
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active sub(int, int) */;
            return sub(xValue_, yValue_);
        }

        private int executeI32_float9(VirtualFrame frameValue, int state, int xValue_) {
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active sub(int, float) */;
            return sub(xValue_, yValue_);
        }

        private int executeI32_generic10(VirtualFrame frameValue, int state, int xValue_) {
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active sub(int, int) */ && yValue_ instanceof Integer) {
                int yValue__ = (int) yValue_;
                return sub(xValue_, yValue__);
            }
            if ((state & 0b10) != 0 /* is-active sub(int, float) */ && yValue_ instanceof Float) {
                float yValue__ = (float) yValue_;
                return sub(xValue_, yValue__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (int) executeAndSpecialize(xValue_, yValue_);
        }

        private Object executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active sub(int, int) */;
                    return sub(xValue_, yValue_);
                }
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b10 /* add-active sub(int, float) */;
                    return sub(xValue_, yValue_);
                }
            }
            if (xValue instanceof Float) {
                float xValue_ = (float) xValue;
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b100 /* add-active sub(float, float) */;
                    return sub(xValue_, yValue_);
                }
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1000 /* add-active sub(float, int) */;
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
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
            if ((state & 0b1110) == 0 /* only-active mul(int, int) */ && state != 0  /* is-not mul(int, int) && mul(int, float) && mul(float, float) && mul(float, int) */) {
                return executeGeneric_int_int0(frameValue, state);
            } else if ((state & 0b1101) == 0 /* only-active mul(int, float) */ && state != 0  /* is-not mul(int, int) && mul(int, float) && mul(float, float) && mul(float, int) */) {
                return executeGeneric_int_float1(frameValue, state);
            } else if ((state & 0b1011) == 0 /* only-active mul(float, float) */ && state != 0  /* is-not mul(int, int) && mul(int, float) && mul(float, float) && mul(float, int) */) {
                return executeGeneric_float_float2(frameValue, state);
            } else if ((state & 0b111) == 0 /* only-active mul(float, int) */ && state != 0  /* is-not mul(int, int) && mul(int, float) && mul(float, float) && mul(float, int) */) {
                return executeGeneric_float_int3(frameValue, state);
            } else {
                return executeGeneric_generic4(frameValue, state);
            }
        }

        private Object executeGeneric_int_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active mul(int, int) */;
            return mul(xValue_, yValue_);
        }

        private Object executeGeneric_int_float1(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active mul(int, float) */;
            return mul(xValue_, yValue_);
        }

        private Object executeGeneric_float_float2(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b100) != 0 /* is-active mul(float, float) */;
            return mul(xValue_, yValue_);
        }

        private Object executeGeneric_float_int3(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1000) != 0 /* is-active mul(float, int) */;
            return mul(xValue_, yValue_);
        }

        private Object executeGeneric_generic4(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b11) != 0 /* is-active mul(int, int) || mul(int, float) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if ((state & 0b1) != 0 /* is-active mul(int, int) */ && yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return mul(xValue__, yValue__);
                }
                if ((state & 0b10) != 0 /* is-active mul(int, float) */ && yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return mul(xValue__, yValue__);
                }
            }
            if ((state & 0b1100) != 0 /* is-active mul(float, float) || mul(float, int) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if ((state & 0b100) != 0 /* is-active mul(float, float) */ && yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return mul(xValue__, yValue__);
                }
                if ((state & 0b1000) != 0 /* is-active mul(float, int) */ && yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return mul(xValue__, yValue__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
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
            if ((state & 0b1000) == 0 /* only-active mul(float, float) */ && (state & 0b1100) != 0  /* is-not mul(float, float) && mul(float, int) */) {
                return executeF32_float5(frameValue, state, xValue_);
            } else if ((state & 0b100) == 0 /* only-active mul(float, int) */ && (state & 0b1100) != 0  /* is-not mul(float, float) && mul(float, int) */) {
                return executeF32_int6(frameValue, state, xValue_);
            } else {
                return executeF32_generic7(frameValue, state, xValue_);
            }
        }

        private float executeF32_float5(VirtualFrame frameValue, int state, float xValue_) {
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b100) != 0 /* is-active mul(float, float) */;
            return mul(xValue_, yValue_);
        }

        private float executeF32_int6(VirtualFrame frameValue, int state, float xValue_) {
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1000) != 0 /* is-active mul(float, int) */;
            return mul(xValue_, yValue_);
        }

        private float executeF32_generic7(VirtualFrame frameValue, int state, float xValue_) {
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b100) != 0 /* is-active mul(float, float) */ && yValue_ instanceof Float) {
                float yValue__ = (float) yValue_;
                return mul(xValue_, yValue__);
            }
            if ((state & 0b1000) != 0 /* is-active mul(float, int) */ && yValue_ instanceof Integer) {
                int yValue__ = (int) yValue_;
                return mul(xValue_, yValue__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (float) executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            if ((state & 0b10) == 0 /* only-active mul(int, int) */ && (state & 0b11) != 0  /* is-not mul(int, int) && mul(int, float) */) {
                return executeI32_int8(frameValue, state, xValue_);
            } else if ((state & 0b1) == 0 /* only-active mul(int, float) */ && (state & 0b11) != 0  /* is-not mul(int, int) && mul(int, float) */) {
                return executeI32_float9(frameValue, state, xValue_);
            } else {
                return executeI32_generic10(frameValue, state, xValue_);
            }
        }

        private int executeI32_int8(VirtualFrame frameValue, int state, int xValue_) {
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active mul(int, int) */;
            return mul(xValue_, yValue_);
        }

        private int executeI32_float9(VirtualFrame frameValue, int state, int xValue_) {
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active mul(int, float) */;
            return mul(xValue_, yValue_);
        }

        private int executeI32_generic10(VirtualFrame frameValue, int state, int xValue_) {
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active mul(int, int) */ && yValue_ instanceof Integer) {
                int yValue__ = (int) yValue_;
                return mul(xValue_, yValue__);
            }
            if ((state & 0b10) != 0 /* is-active mul(int, float) */ && yValue_ instanceof Float) {
                float yValue__ = (float) yValue_;
                return mul(xValue_, yValue__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (int) executeAndSpecialize(xValue_, yValue_);
        }

        private Object executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active mul(int, int) */;
                    return mul(xValue_, yValue_);
                }
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b10 /* add-active mul(int, float) */;
                    return mul(xValue_, yValue_);
                }
            }
            if (xValue instanceof Float) {
                float xValue_ = (float) xValue;
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b100 /* add-active mul(float, float) */;
                    return mul(xValue_, yValue_);
                }
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1000 /* add-active mul(float, int) */;
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
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
            if ((state & 0b1110) == 0 /* only-active div(int, int) */ && state != 0  /* is-not div(int, int) && div(int, float) && div(float, float) && div(float, int) */) {
                return executeGeneric_int_int0(frameValue, state);
            } else if ((state & 0b1101) == 0 /* only-active div(int, float) */ && state != 0  /* is-not div(int, int) && div(int, float) && div(float, float) && div(float, int) */) {
                return executeGeneric_int_float1(frameValue, state);
            } else if ((state & 0b1011) == 0 /* only-active div(float, float) */ && state != 0  /* is-not div(int, int) && div(int, float) && div(float, float) && div(float, int) */) {
                return executeGeneric_float_float2(frameValue, state);
            } else if ((state & 0b111) == 0 /* only-active div(float, int) */ && state != 0  /* is-not div(int, int) && div(int, float) && div(float, float) && div(float, int) */) {
                return executeGeneric_float_int3(frameValue, state);
            } else {
                return executeGeneric_generic4(frameValue, state);
            }
        }

        private Object executeGeneric_int_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active div(int, int) */;
            return div(xValue_, yValue_);
        }

        private Object executeGeneric_int_float1(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active div(int, float) */;
            return div(xValue_, yValue_);
        }

        private Object executeGeneric_float_float2(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b100) != 0 /* is-active div(float, float) */;
            return div(xValue_, yValue_);
        }

        private Object executeGeneric_float_int3(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1000) != 0 /* is-active div(float, int) */;
            return div(xValue_, yValue_);
        }

        private Object executeGeneric_generic4(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b11) != 0 /* is-active div(int, int) || div(int, float) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if ((state & 0b1) != 0 /* is-active div(int, int) */ && yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return div(xValue__, yValue__);
                }
                if ((state & 0b10) != 0 /* is-active div(int, float) */ && yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return div(xValue__, yValue__);
                }
            }
            if ((state & 0b1100) != 0 /* is-active div(float, float) || div(float, int) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if ((state & 0b100) != 0 /* is-active div(float, float) */ && yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return div(xValue__, yValue__);
                }
                if ((state & 0b1000) != 0 /* is-active div(float, int) */ && yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return div(xValue__, yValue__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
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
            if ((state & 0b1000) == 0 /* only-active div(float, float) */ && (state & 0b1100) != 0  /* is-not div(float, float) && div(float, int) */) {
                return executeF32_float5(frameValue, state, xValue_);
            } else if ((state & 0b100) == 0 /* only-active div(float, int) */ && (state & 0b1100) != 0  /* is-not div(float, float) && div(float, int) */) {
                return executeF32_int6(frameValue, state, xValue_);
            } else {
                return executeF32_generic7(frameValue, state, xValue_);
            }
        }

        private float executeF32_float5(VirtualFrame frameValue, int state, float xValue_) {
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b100) != 0 /* is-active div(float, float) */;
            return div(xValue_, yValue_);
        }

        private float executeF32_int6(VirtualFrame frameValue, int state, float xValue_) {
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1000) != 0 /* is-active div(float, int) */;
            return div(xValue_, yValue_);
        }

        private float executeF32_generic7(VirtualFrame frameValue, int state, float xValue_) {
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b100) != 0 /* is-active div(float, float) */ && yValue_ instanceof Float) {
                float yValue__ = (float) yValue_;
                return div(xValue_, yValue__);
            }
            if ((state & 0b1000) != 0 /* is-active div(float, int) */ && yValue_ instanceof Integer) {
                int yValue__ = (int) yValue_;
                return div(xValue_, yValue__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (float) executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            if ((state & 0b10) == 0 /* only-active div(int, int) */ && (state & 0b11) != 0  /* is-not div(int, int) && div(int, float) */) {
                return executeI32_int8(frameValue, state, xValue_);
            } else if ((state & 0b1) == 0 /* only-active div(int, float) */ && (state & 0b11) != 0  /* is-not div(int, int) && div(int, float) */) {
                return executeI32_float9(frameValue, state, xValue_);
            } else {
                return executeI32_generic10(frameValue, state, xValue_);
            }
        }

        private int executeI32_int8(VirtualFrame frameValue, int state, int xValue_) {
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active div(int, int) */;
            return div(xValue_, yValue_);
        }

        private int executeI32_float9(VirtualFrame frameValue, int state, int xValue_) {
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active div(int, float) */;
            return div(xValue_, yValue_);
        }

        private int executeI32_generic10(VirtualFrame frameValue, int state, int xValue_) {
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active div(int, int) */ && yValue_ instanceof Integer) {
                int yValue__ = (int) yValue_;
                return div(xValue_, yValue__);
            }
            if ((state & 0b10) != 0 /* is-active div(int, float) */ && yValue_ instanceof Float) {
                float yValue__ = (float) yValue_;
                return div(xValue_, yValue__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (int) executeAndSpecialize(xValue_, yValue_);
        }

        private Object executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active div(int, int) */;
                    return div(xValue_, yValue_);
                }
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b10 /* add-active div(int, float) */;
                    return div(xValue_, yValue_);
                }
            }
            if (xValue instanceof Float) {
                float xValue_ = (float) xValue;
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b100 /* add-active div(float, float) */;
                    return div(xValue_, yValue_);
                }
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1000 /* add-active div(float, int) */;
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
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
            if ((state & 0b10) == 0 /* only-active mod(int, int) */ && state != 0  /* is-not mod(int, int) && mod(float, float) */) {
                return executeGeneric_int_int0(frameValue, state);
            } else if ((state & 0b1) == 0 /* only-active mod(float, float) */ && state != 0  /* is-not mod(int, int) && mod(float, float) */) {
                return executeGeneric_float_float1(frameValue, state);
            } else {
                return executeGeneric_generic2(frameValue, state);
            }
        }

        private Object executeGeneric_int_int0(VirtualFrame frameValue, int state) {
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            assert (state & 0b1) != 0 /* is-active mod(int, int) */;
            return mod(xValue_, yValue_);
        }

        private Object executeGeneric_float_float1(VirtualFrame frameValue, int state) {
            float xValue_ = this.x_.executeF32(frameValue);
            float yValue_ = this.y_.executeF32(frameValue);
            assert (state & 0b10) != 0 /* is-active mod(float, float) */;
            return mod(xValue_, yValue_);
        }

        private Object executeGeneric_generic2(VirtualFrame frameValue, int state) {
            Object xValue_ = this.x_.executeGeneric(frameValue);
            Object yValue_ = this.y_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active mod(int, int) */ && xValue_ instanceof Integer) {
                int xValue__ = (int) xValue_;
                if (yValue_ instanceof Integer) {
                    int yValue__ = (int) yValue_;
                    return mod(xValue__, yValue__);
                }
            }
            if ((state & 0b10) != 0 /* is-active mod(float, float) */ && xValue_ instanceof Float) {
                float xValue__ = (float) xValue_;
                if (yValue_ instanceof Float) {
                    float yValue__ = (float) yValue_;
                    return mod(xValue__, yValue__);
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(xValue_, yValue_);
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
            float yValue_ = this.y_.executeF32(frameValue);
            if ((state & 0b10) != 0 /* is-active mod(float, float) */) {
                return mod(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (float) executeAndSpecialize(xValue_, yValue_);
        }

        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            int xValue_ = this.x_.executeI32(frameValue);
            int yValue_ = this.y_.executeI32(frameValue);
            if ((state & 0b1) != 0 /* is-active mod(int, int) */) {
                return mod(xValue_, yValue_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return (int) executeAndSpecialize(xValue_, yValue_);
        }

        private Object executeAndSpecialize(Object xValue, Object yValue) {
            int state = state_;
            if (xValue instanceof Integer) {
                int xValue_ = (int) xValue;
                if (yValue instanceof Integer) {
                    int yValue_ = (int) yValue;
                    this.state_ = state = state | 0b1 /* add-active mod(int, int) */;
                    return mod(xValue_, yValue_);
                }
            }
            if (xValue instanceof Float) {
                float xValue_ = (float) xValue;
                if (yValue instanceof Float) {
                    float yValue_ = (float) yValue;
                    this.state_ = state = state | 0b10 /* add-active mod(float, float) */;
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
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

        public static ModNode create(MJExpresionNode x, MJExpresionNode y) {
            return new ModNodeGen(x, y);
        }

    }
}
