// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.library.Message;
import com.oracle.truffle.api.library.ReflectionLibrary;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.NodeUtil;
import com.oracle.truffle.api.utilities.FinalBitSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import org.truffle.cs.mj.nodes.ArrayLibrary;

@GeneratedBy(ArrayLibrary.class)
final class ArrayLibraryGen extends LibraryFactory<ArrayLibrary> {

    private static final Class<ArrayLibrary> LIBRARY_CLASS = ArrayLibraryGen.lazyLibraryClass();
    private static final Message IS_ARRAY = new MessageImpl("isArray", 0, boolean.class, Object.class);
    private static final Message READ = new MessageImpl("read", 1, int.class, Object.class, int.class);
    private static final ArrayLibraryGen INSTANCE = new ArrayLibraryGen();
    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(ArrayLibraryGen.LIBRARY_CLASS, new Default());
        LibraryFactory.register(ArrayLibraryGen.LIBRARY_CLASS, INSTANCE);
    }

    private ArrayLibraryGen() {
        super(ArrayLibraryGen.LIBRARY_CLASS, Collections.unmodifiableList(Arrays.asList(ArrayLibraryGen.IS_ARRAY, ArrayLibraryGen.READ)));
    }

    @Override
    protected Class<?> getDefaultClass(Object receiver) {
        return ArrayLibrary.class;
    }

    @Override
    protected ArrayLibrary createProxy(ReflectionLibrary library) {
        return new Proxy(library);
    }

    @Override
    protected FinalBitSet createMessageBitSet(Message... messages) {
        BitSet bitSet = new BitSet(2);
        for (Message message : messages) {
            bitSet.set(((MessageImpl) message).index);
        }
        return FinalBitSet.valueOf(bitSet);
    }

    @Override
    protected ArrayLibrary createDelegate(ArrayLibrary delegateLibrary) {
        return new Delegate(delegateLibrary);
    }

    @Override
    protected Object genericDispatch(Library originalLib, Object receiver, Message message, Object[] args, int offset) throws Exception {
        ArrayLibrary lib = (ArrayLibrary) originalLib;
        MessageImpl messageImpl = (MessageImpl) message;
        if (messageImpl.getParameterCount() - 1 != args.length - offset) {
            CompilerDirectives.transferToInterpreter();
            throw new IllegalArgumentException("Invalid number of arguments.");
        }
        switch (messageImpl.index) {
            case 0 :
                return lib.isArray(receiver);
            case 1 :
                return lib.read(receiver, (int) args[offset]);
        }
        CompilerDirectives.transferToInterpreter();
        throw new AbstractMethodError(message.toString());
    }

    @Override
    protected ArrayLibrary createDispatchImpl(int limit) {
        return new CachedDispatchFirst(null, null, limit);
    }

    @Override
    protected ArrayLibrary createUncachedDispatch() {
        return new UncachedDispatch();
    }

    @SuppressWarnings("unchecked")
    private static Class<ArrayLibrary> lazyLibraryClass() {
        try {
            return (Class<ArrayLibrary>) Class.forName("org.truffle.cs.mj.nodes.ArrayLibrary", false, ArrayLibraryGen.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    @GeneratedBy(ArrayLibrary.class)
    private static final class Default extends LibraryExport<ArrayLibrary> {

        private Default() {
            super(ArrayLibrary.class, Object.class, false);
        }

        @Override
        protected ArrayLibrary createUncached(Object receiver) {
            ArrayLibrary uncached = new Uncached(receiver);
            return uncached;
        }

        @Override
        protected ArrayLibrary createCached(Object receiver) {
            return new Cached(receiver);
        }

        @GeneratedBy(ArrayLibrary.class)
        private static final class Cached extends ArrayLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;
            private final Class<?> dynamicDispatchTarget_;

            Cached(Object receiver) {
                this.dynamicDispatch_ = insert(DYNAMIC_DISPATCH_LIBRARY_.create(receiver));
                this.dynamicDispatchTarget_ = DYNAMIC_DISPATCH_LIBRARY_.getUncached(receiver).dispatch(receiver);
            }

            @Override
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == dynamicDispatchTarget_;
            }

            @Override
            public boolean isArray(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return super.isArray((dynamicDispatch_.cast(receiver)));
            }

            @Override
            public int read(Object receiver, int index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

        }
        @GeneratedBy(ArrayLibrary.class)
        private static final class Uncached extends ArrayLibrary {

            @Child private DynamicDispatchLibrary dynamicDispatch_;
            private final Class<?> dynamicDispatchTarget_;

            Uncached(Object receiver) {
                this.dynamicDispatch_ = DYNAMIC_DISPATCH_LIBRARY_.getUncached(receiver);
                this.dynamicDispatchTarget_ = dynamicDispatch_.dispatch(receiver);
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                return dynamicDispatch_.accepts(receiver) && dynamicDispatch_.dispatch(receiver) == dynamicDispatchTarget_;
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
                return super.isArray(receiver);
            }

            @TruffleBoundary
            @Override
            public int read(Object receiver, int index) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                throw new AbstractMethodError();
            }

        }
    }
    @GeneratedBy(ArrayLibrary.class)
    private static class MessageImpl extends Message {

        final int index;

        MessageImpl(String name, int index, Class<?> returnType, Class<?>... parameters) {
            super(ArrayLibraryGen.LIBRARY_CLASS, name, returnType, parameters);
            this.index = index;
        }

    }
    @GeneratedBy(ArrayLibrary.class)
    private static final class Proxy extends ArrayLibrary {

        @Child private ReflectionLibrary lib;

        Proxy(ReflectionLibrary lib) {
            this.lib = lib;
        }

        @Override
        public boolean isArray(Object receiver_) {
            try {
                return (boolean) lib.send(receiver_, ArrayLibraryGen.IS_ARRAY);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                CompilerDirectives.transferToInterpreter();
                throw new AssertionError(e_);
            }
        }

        @Override
        public int read(Object receiver_, int index) {
            try {
                return (int) lib.send(receiver_, ArrayLibraryGen.READ, index);
            } catch (RuntimeException e_) {
                throw e_;
            } catch (Exception e_) {
                CompilerDirectives.transferToInterpreter();
                throw new AssertionError(e_);
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return lib.accepts(receiver_);
        }

    }
    @GeneratedBy(ArrayLibrary.class)
    private static final class Delegate extends ArrayLibrary {

        @Child private ArrayLibrary delegateLibrary;

        Delegate(ArrayLibrary delegateLibrary) {
            this.delegateLibrary = delegateLibrary;
        }

        @Override
        public boolean isArray(Object receiver_) {
            if (LibraryFactory.isDelegated(delegateLibrary, 0)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).isArray(delegate);
            } else {
                return this.delegateLibrary.isArray(receiver_);
            }
        }

        @Override
        public int read(Object receiver_, int index) {
            if (LibraryFactory.isDelegated(delegateLibrary, 1)) {
                Object delegate = LibraryFactory.readDelegate(this.delegateLibrary, receiver_);
                return LibraryFactory.getDelegateLibrary(this.delegateLibrary, delegate).read(delegate, index);
            } else {
                return this.delegateLibrary.read(receiver_, index);
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return delegateLibrary.accepts(receiver_);
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        @Override
        public boolean isAdoptable() {
            return this.delegateLibrary.isAdoptable();
        }

    }
    @GeneratedBy(ArrayLibrary.class)
    private static final class CachedToUncachedDispatch extends ArrayLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public boolean isArray(Object receiver_) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            Node prev_ = NodeUtil.pushEncapsulatingNode(getParent());
            try {
                return INSTANCE.getUncached(receiver_).isArray(receiver_);
            } finally {
                NodeUtil.popEncapsulatingNode(prev_);
            }
        }

        @TruffleBoundary
        @Override
        public int read(Object receiver_, int index) {
            assert getRootNode() != null : "Invalid libray usage. Cached library must be adopted by a RootNode before it is executed.";
            Node prev_ = NodeUtil.pushEncapsulatingNode(getParent());
            try {
                return INSTANCE.getUncached(receiver_).read(receiver_, index);
            } finally {
                NodeUtil.popEncapsulatingNode(prev_);
            }
        }

        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

    }
    @GeneratedBy(ArrayLibrary.class)
    private static final class UncachedDispatch extends ArrayLibrary {

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @TruffleBoundary
        @Override
        public boolean isArray(Object receiver_) {
            return INSTANCE.getUncached(receiver_).isArray(receiver_);
        }

        @TruffleBoundary
        @Override
        public int read(Object receiver_, int index) {
            return INSTANCE.getUncached(receiver_).read(receiver_, index);
        }

        @TruffleBoundary
        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
    @GeneratedBy(ArrayLibrary.class)
    private static final class CachedDispatchNext extends CachedDispatch {

        CachedDispatchNext(ArrayLibrary library, CachedDispatch next) {
            super(library, next);
        }

        @Override
        int getLimit() {
            throw new AssertionError();
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

    }
    @GeneratedBy(ArrayLibrary.class)
    private static final class CachedDispatchFirst extends CachedDispatch {

        private final int limit_;

        CachedDispatchFirst(ArrayLibrary library, CachedDispatch next, int limit_) {
            super(library, next);
            this.limit_ = limit_;
        }

        @Override
        int getLimit() {
            return this.limit_;
        }

        @Override
        public NodeCost getCost() {
            if (this.library instanceof CachedToUncachedDispatch) {
                return NodeCost.MEGAMORPHIC;
            }
            CachedDispatch current = this;
            int count = 0;
            do {
                if (current.library != null) {
                    count++;
                }
                current = current.next;
            } while (current != null);
            return NodeCost.fromCount(count);
        }

    }
    @GeneratedBy(ArrayLibrary.class)
    private abstract static class CachedDispatch extends ArrayLibrary {

        @Child ArrayLibrary library;
        @Child CachedDispatch next;

        CachedDispatch(ArrayLibrary library, CachedDispatch next) {
            this.library = library;
            this.next = next;
        }

        abstract int getLimit();

        @ExplodeLoop
        @Override
        public boolean isArray(Object receiver_) {
            do {
                CachedDispatch current = this;
                do {
                    ArrayLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.isArray(receiver_);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @ExplodeLoop
        @Override
        public int read(Object receiver_, int index) {
            do {
                CachedDispatch current = this;
                do {
                    ArrayLibrary thisLibrary = current.library;
                    if (thisLibrary != null && thisLibrary.accepts(receiver_)) {
                        return thisLibrary.read(receiver_, index);
                    }
                    current = current.next;
                } while (current != null);
                CompilerDirectives.transferToInterpreterAndInvalidate();
                specialize(receiver_);
            } while (true);
        }

        @Override
        public boolean accepts(Object receiver_) {
            return true;
        }

        private void specialize(Object receiver_) {
            CachedDispatch current = this;
            ArrayLibrary thisLibrary = current.library;
            if (thisLibrary == null) {
                this.library = insert(INSTANCE.create(receiver_));
            } else {
                Lock lock = getLock();
                lock.lock();
                try {
                    int count = 0;
                    do {
                        ArrayLibrary currentLibrary = current.library;
                        if (currentLibrary != null && currentLibrary.accepts(receiver_)) {
                            return;
                        }
                        count++;
                        current = current.next;
                    } while (current != null);
                    if (count >= getLimit()) {
                        this.library = insert(new CachedToUncachedDispatch());
                        this.next = null;
                    } else {
                        this.next = insert(new CachedDispatchNext(INSTANCE.create(receiver_), next));
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

    }
}
