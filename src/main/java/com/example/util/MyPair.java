package com.example.util;

/**
 * A pair represents two elements in an ordered form.
 */
public class MyPair<L, R> {
    private final L left;
    private final R right;

    public MyPair(L left, R right) {
       this.left = left;
       this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}
// Se podria sustituir por
//public record Pair<L, R>(L left, R right) {
//}