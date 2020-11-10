package persistence.implementation;


import persistence.General;

import java.util.function.Supplier;

public class PartsStore<E> implements General<E> {
    private final Supplier<Class<E>> getterClass;
    public PartsStore(Supplier<Class<E>> eSupplier) {
        this.getterClass = eSupplier;
    }
    @Override
    public Class<E> setType() {
        return getterClass.get();
    }

}
