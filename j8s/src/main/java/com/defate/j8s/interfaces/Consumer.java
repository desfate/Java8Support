package com.defate.j8s.interfaces;
import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T var1);

//    default Consumer<T> andThen(Consumer<? super T> after) {
//        Objects.requireNonNull(after);
//        return (t) -> {
//            this.accept(t);
//            after.accept(t);
//        };
//    }
}
