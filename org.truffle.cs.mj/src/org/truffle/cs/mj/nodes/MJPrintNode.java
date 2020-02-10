package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;

@NodeChild(value = "expression", type = MJExpresionNode.class)
public abstract class MJPrintNode extends MJStatementNode {

    @Specialization
    Object printI(int i) {
        print(i);
        return null;
    }

    @Specialization
    Object printF(float f) {
        print(f);
        return null;
    }

    @Specialization
    Object printC(char c) {
        print(c);
        return null;
    }

    @Specialization
    Object printB(boolean b) {
        print(b);
        return null;
    }

    @Specialization
    Object printO(Object o) {
        print(o);
        return null;
    }

    @TruffleBoundary
    private static void print(int i) {
        System.out.println(i);
    }

    @TruffleBoundary
    private static void print(boolean b) {
        System.out.println(b);
    }

    @TruffleBoundary
    private static void print(char c) {
        System.out.println(c);
    }

    @TruffleBoundary
    private static void print(float f) {
        System.out.println(f);
    }

    @TruffleBoundary
    private static void print(Object o) {
        System.out.println(o);
    }
}
