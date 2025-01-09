package world.evgereo.spring.minio.support;

@FunctionalInterface
public interface ExceptionalSupplier<T, E extends Exception> {
    T get() throws E;
}
