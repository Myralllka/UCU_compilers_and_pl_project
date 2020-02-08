package org.truffle.cs.mj.nodes;

//import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.dsl.TypeSystemReference;

@NodeInfo
@TypeSystemReference(MJTypes.class)
public abstract class MJExpresionNode extends Node {

    public abstract Object executeGeneric(VirtualFrame frame);

    public void executeVoid(VirtualFrame frame) {
        executeGeneric(frame);
    }

    public int executeI32(VirtualFrame frame) throws UnexpectedResultException {
        return MJTypesGen.expectInteger(executeGeneric(frame));
    }

    public float executeF32(VirtualFrame frame) throws UnexpectedResultException {
        return (float) MJTypesGen.expectDouble(executeGeneric(frame));
    }

    public boolean executeBool(VirtualFrame frame) throws UnexpectedResultException {
        return MJTypesGen.expectBoolean(executeGeneric(frame));
    }
}
