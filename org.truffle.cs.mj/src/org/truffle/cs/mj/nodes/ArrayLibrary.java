package org.truffle.cs.mj.nodes;

import com.oracle.truffle.api.library.GenerateLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryFactory;

@GenerateLibrary
public abstract class ArrayLibrary extends Library {

    public boolean isArray(Object receiver) {
        return false;
    }

    public abstract int read(Object receiver, int index);

    public static LibraryFactory<ArrayLibrary> getFactory() {
        return FACTORY;
    }

    public static ArrayLibrary getUncached() {
        return FACTORY.getUncached();
    }

    private static final LibraryFactory<ArrayLibrary> FACTORY = LibraryFactory.resolve(ArrayLibrary.class);
}
