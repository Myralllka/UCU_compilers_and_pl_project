package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;

@NodeChild(value = "x", type = MJExpresionNode.class)
@NodeChild(value = "y", type = MJExpresionNode.class)
public abstract class MJBinaryNode extends MJExpresionNode {

    public static abstract class BooleanOr extends MJBinaryNode {
        @Specialization
        public boolean or(boolean x, boolean y) {
            return x || y;
        }
    }

    public static abstract class BooleanAnd extends MJBinaryNode {
        @Specialization
        public boolean and(boolean x, boolean y) {
            return x && y;
        }
    }

    public static abstract class NotEqual extends MJBinaryNode {
        @Specialization
        public boolean notEqual(int x, int y) {
            return x != y;
        }

        @Specialization
        public boolean notEqual(Object x, Object y) {
            return x != y;
        }
    }

    public static abstract class Equal extends MJBinaryNode {
        @Specialization
        public boolean equal(int x, int y) {
            return x == y;
        }
    }

    public static abstract class GreaterEqual extends MJBinaryNode {
        @Specialization
        public boolean greaterEqual(int x, int y) {
            return x >= y;
        }
    }

    public static abstract class LessEqual extends MJBinaryNode {
        @Specialization
        public boolean lessEqual(int x, int y) {
            return x <= y;
        }
    }

    public static abstract class GreaterThanNode extends MJBinaryNode {
        @Specialization
        public boolean greaterThan(int x, int y) {
            return x > y;
        }
    }

    public static abstract class LessThanNode extends MJBinaryNode {
        @Specialization
        public boolean lessThan(int x, int y) {
            return x < y;
        }
    }

    public static abstract class AddNode extends MJBinaryNode {
        @Specialization
        public int add(int x, int y) {
            return x + y;
        }
    }

    public static abstract class SubNode extends MJBinaryNode {
        @Specialization
        public int sub(int x, int y) {
            return x - y;
        }
    }

    public static abstract class MulNode extends MJBinaryNode {
        @Specialization
        public int mul(int x, int y) {
            return x * y;
        }
    }

    public static abstract class DivNode extends MJBinaryNode {
        @Specialization
        public int div(int x, int y) {
            return x / y;
        }
    }

    public static abstract class ModNode extends MJBinaryNode {
        @Specialization
        public int mod(int x, int y) {
            return x % y;
        }
    }
}
