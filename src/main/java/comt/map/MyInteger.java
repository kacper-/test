package comt.map;

import java.util.Objects;

public class MyInteger {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    MyInteger(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyInteger myInteger = (MyInteger) o;
        return i == myInteger.i;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(i);
    }
}
