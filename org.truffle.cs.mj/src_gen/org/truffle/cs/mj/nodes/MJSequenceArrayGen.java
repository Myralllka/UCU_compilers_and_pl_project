// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.NodeCost;
import org.truffle.cs.mj.nodes.ArrayLibrary;
import org.truffle.cs.mj.nodes.MJArrayNode.MJSequenceArray;

@GeneratedBy(MJSequenceArray.class)
final class MJSequenceArrayGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(MJSequenceArray.class, new ArrayLibraryExports());
    }

    private MJSequenceArrayGen() {
    }

    @GeneratedBy(MJSequenceArray.class)
    private static final class ArrayLibraryExports extends LibraryExport<ArrayLibrary> {

        private static final Uncached UNCACHED = new Uncached();
        private static final Cached CACHE = new Cached();

        private ArrayLibraryExports() {
            super(ArrayLibrary.class, MJSequenceArray.class, false);
        }

        @Override
        protected ArrayLibrary createUncached(Object receiver) {
            assert receiver instanceof MJSequenceArray;
            ArrayLibrary uncached = ArrayLibraryExports.UNCACHED;
            return uncached;
        }

        @Override
        protected ArrayLibrary createCached(Object receiver) {
            assert receiver instanceof MJSequenceArray;
            return ArrayLibraryExports.CACHE;
        }

        @GeneratedBy(MJSequenceArray.class)
        private static final class Cached extends ArrayLibrary {

            Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof MJSequenceArray) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'org.truffle.cs.mj.nodes.MJArrayNode.MJSequenceArray'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof MJSequenceArray;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public boolean isArray(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((MJSequenceArray) receiver).isArray();
            }

            @Override
            public int read(Object receiver, int index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((MJSequenceArray) receiver).read(index);
            }

        }
        @GeneratedBy(MJSequenceArray.class)
        private static final class Uncached extends ArrayLibrary {

            Uncached() {
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof MJSequenceArray) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'org.truffle.cs.mj.nodes.MJArrayNode.MJSequenceArray'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof MJSequenceArray;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public boolean isArray(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((MJSequenceArray) receiver) .isArray();
            }

            @TruffleBoundary
            @Override
            public int read(Object receiver, int index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((MJSequenceArray) receiver) .read(index);
            }

        }
    }
}
