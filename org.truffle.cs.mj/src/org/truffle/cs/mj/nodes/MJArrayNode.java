package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.library.GenerateLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;

@SuppressWarnings({"static-method", "unused"})
public class MJArrayNode {

    @ExportLibrary(ArrayLibrary.class)
    final class MJSequenceArray {
        private final int start;
        private final int stride;
        private final int length;

        MJSequenceArray(int start, int stride, int length) {
            this.start = start;
            this.stride = stride;
            this.length = length;
        }

        @ExportMessage
        boolean isArray() {
            return true;
        }

        @ExportMessage
        public int read(int index) {
            return start + (stride * index);
        }
    }

    @ExportLibrary(ArrayLibrary.class)
    final class MJBufferArray {

        private int length;
        private int[] buffer;

        MJBufferArray(int length) {
            this.length = length;
            this.buffer = new int[length];
        }

        @ExportMessage
        boolean isArray() {
            return true;
        }

        @ExportMessage
        int read(int index) {
            return buffer[index];
        }
    }

    @NodeChild
    @NodeChild
    abstract static class ArrayReadNode extends MJExpresionNode {
        @Specialization(guards = "arrays.isArray(array)", limit = "2")
        int doDefault(Object array, int index,
                        @CachedLibrary("array") ArrayLibrary arrays) {
            return arrays.read(array, index);
        }
    }
}