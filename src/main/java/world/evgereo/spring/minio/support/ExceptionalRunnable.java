package world.evgereo.spring.minio.support;

@FunctionalInterface
public interface ExceptionalRunnable<E extends Exception> {
    void run() throws E;
}
