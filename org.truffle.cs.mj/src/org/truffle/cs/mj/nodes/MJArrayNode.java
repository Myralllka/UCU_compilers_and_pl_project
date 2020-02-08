package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.library.GenerateLibrary;
import com.oracle.truffle.api.nodes.Node.Child;

public class MJArrayNode {

    final class BufferArray {
        int length;
        int[] buffer;

        BufferArray(int length) {
            this.length = length;
            this.buffer = new int[length];
        }
    }

    final class SequenceArray {
        final int start;
        final int stride;
        final int length;

        SequenceArray(int start, int stride, int length) {
            this.start = start;
            this.stride = stride;
            this.length = length;
        }
    }

    @NodeChild
    @NodeChild
    abstract static class ArrayReadNode extends MJExpresionNode {

        @Specialization
        int doBuffer(BufferArray array, int index) {
            return array.buffer[index];
        }

        @Specialization
        int doSequence(SequenceArray seq, int index) {
            return seq.start + seq.stride * index;
        }
    }

    static final class ArgumentNode extends MJExpresionNode {
        private final int index;

        ArgumentNode(int index) {
            this.index = index;
        }

        @Override
        public Object executeGeneric(VirtualFrame frame) {
            return frame.getArguments()[index];
        }
    }
}