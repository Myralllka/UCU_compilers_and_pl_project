package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.TypeSystem;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.ImplicitCast;

@TypeSystem({boolean.class, int.class, double.class})
// @DSLOPtions
public abstract class MJTypes {
    @ImplicitCast
    @TruffleBoundary
    public static Double castDouble(int value) {
        return new Double(value);
    }
}
