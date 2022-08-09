package com.example.util;

import com.example.list.MyList;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof MyPair<?, ?> myPair)) {
            return false;
        }

        return (Objects.equals(myPair.getLeft(),this.left) &&
                Objects.equals(myPair.getRight(),this.right));
    }


}
// Se podria sustituir por
//public record Pair<L, R>(L left, R right) {
//}