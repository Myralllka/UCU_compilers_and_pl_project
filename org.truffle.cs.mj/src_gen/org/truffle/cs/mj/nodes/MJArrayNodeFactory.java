// CheckStyle: start generated
package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.NodeUtil;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import java.util.concurrent.locks.Lock;
import org.truffle.cs.mj.nodes.ArrayLibrary;
import org.truffle.cs.mj.nodes.MJArrayNode;
import org.truffle.cs.mj.nodes.MJExpresionNode;
import org.truffle.cs.mj.nodes.MJArrayNode.ArrayReadNode;

@GeneratedBy(MJArrayNode.class)
public final class MJArrayNodeFactory {

    private static final LibraryFactory<ArrayLibrary> ARRAY_LIBRARY_ = LibraryFactory.resolve(ArrayLibrary.class);

    @GeneratedBy(ArrayReadNode.class)
    static final class ArrayReadNodeGen extends ArrayReadNode {

        @Child private MJExpresionNode child0_;
        @Child private MJExpresionNode child1_;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;
        @Child private Default0Data default0_cache;

        private ArrayReadNodeGen(MJExpresionNode child0, MJExpresionNode child1) {
            this.child0_ = child0;
            this.child1_ = child1;
        }

        @ExplodeLoop
        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            int state = state_;
            Object child0Value_ = this.child0_.executeGeneric(frameValue);
            int child1Value_;
            try {
                child1Value_ = this.child1_.executeI32(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(child0Value_, ex.getResult());
            }
            if (state != 0 /* is-active doDefault(Object, int, ArrayLibrary) || doDefault(Object, int, ArrayLibrary) */) {
                if ((state & 0b1) != 0 /* is-active doDefault(Object, int, ArrayLibrary) */) {
                    Default0Data s1_ = this.default0_cache;
                    while (s1_ != null) {
                        if ((s1_.arrays_.accepts(child0Value_)) && (s1_.arrays_.isArray(child0Value_))) {
                            return doDefault(child0Value_, child1Value_, s1_.arrays_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doDefault(Object, int, ArrayLibrary) */) {
                    Node prev_ = NodeUtil.pushEncapsulatingNode(this);
                    try {
                        if (((ARRAY_LIBRARY_.getUncached(child0Value_)).isArray(child0Value_))) {
                            return doDefault(child0Value_, child1Value_, (ARRAY_LIBRARY_.getUncached(child0Value_)));
                        }
                    } finally {
                        NodeUtil.popEncapsulatingNode(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(child0Value_, child1Value_);
        }

        @ExplodeLoop
        @Override
        public int executeI32(VirtualFrame frameValue) {
            int state = state_;
            Object child0Value_ = this.child0_.executeGeneric(frameValue);
            int child1Value_;
            try {
                child1Value_ = this.child1_.executeI32(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(child0Value_, ex.getResult());
            }
            if (state != 0 /* is-active doDefault(Object, int, ArrayLibrary) || doDefault(Object, int, ArrayLibrary) */) {
                if ((state & 0b1) != 0 /* is-active doDefault(Object, int, ArrayLibrary) */) {
                    Default0Data s1_ = this.default0_cache;
                    while (s1_ != null) {
                        if ((s1_.arrays_.accepts(child0Value_)) && (s1_.arrays_.isArray(child0Value_))) {
                            return doDefault(child0Value_, child1Value_, s1_.arrays_);
                        }
                        s1_ = s1_.next_;
                    }
                }
                if ((state & 0b10) != 0 /* is-active doDefault(Object, int, ArrayLibrary) */) {
                    Node prev_ = NodeUtil.pushEncapsulatingNode(this);
                    try {
                        if (((ARRAY_LIBRARY_.getUncached(child0Value_)).isArray(child0Value_))) {
                            return doDefault(child0Value_, child1Value_, (ARRAY_LIBRARY_.getUncached(child0Value_)));
                        }
                    } finally {
                        NodeUtil.popEncapsulatingNode(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(child0Value_, child1Value_);
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeI32(frameValue);
            return;
        }

        private int executeAndSpecialize(Object child0Value, Object child1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            try {
                if (child1Value instanceof Integer) {
                    int child1Value_ = (int) child1Value;
                    if ((exclude) == 0 /* is-not-excluded doDefault(Object, int, ArrayLibrary) */) {
                        int count1_ = 0;
                        Default0Data s1_ = this.default0_cache;
                        if ((state & 0b1) != 0 /* is-active doDefault(Object, int, ArrayLibrary) */) {
                            while (s1_ != null) {
                                if ((s1_.arrays_.accepts(child0Value)) && (s1_.arrays_.isArray(child0Value))) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                ArrayLibrary arrays__ = super.insert((ARRAY_LIBRARY_.create(child0Value)));
                                // assert (s1_.arrays_.accepts(child0Value));
                                if ((arrays__.isArray(child0Value)) && count1_ < (2)) {
                                    s1_ = super.insert(new Default0Data(default0_cache));
                                    s1_.arrays_ = s1_.insertAccessor(arrays__);
                                    this.default0_cache = s1_;
                                    this.state_ = state = state | 0b1 /* add-active doDefault(Object, int, ArrayLibrary) */;
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return doDefault(child0Value, child1Value_, s1_.arrays_);
                        }
                    }
                    {
                        Node prev_ = NodeUtil.pushEncapsulatingNode(this);
                        try {
                            {
                                ArrayLibrary default1_arrays__ = (ARRAY_LIBRARY_.getUncached(child0Value));
                                if ((default1_arrays__.isArray(child0Value))) {
                                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doDefault(Object, int, ArrayLibrary) */;
                                    this.default0_cache = null;
                                    state = state & 0xfffffffe /* remove-active doDefault(Object, int, ArrayLibrary) */;
                                    this.state_ = state = state | 0b10 /* add-active doDefault(Object, int, ArrayLibrary) */;
                                    lock.unlock();
                                    hasLock = false;
                                    return doDefault(child0Value, child1Value_, default1_arrays__);
                                }
                            }
                        } finally {
                            NodeUtil.popEncapsulatingNode(prev_);
                        }
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.child0_, this.child1_}, child0Value, child1Value);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                Default0Data s1_ = this.default0_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        public static ArrayReadNode create(MJExpresionNode child0, MJExpresionNode child1) {
            return new ArrayReadNodeGen(child0, child1);
        }

        @GeneratedBy(ArrayReadNode.class)
        private static final class Default0Data extends Node {

            @Child Default0Data next_;
            @Child ArrayLibrary arrays_;

            Default0Data(Default0Data next_) {
                this.next_ = next_;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
    }
}
