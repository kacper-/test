package comt.offheap;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public class Main {
    public static void main(String[] args) {
        MemorySegment segment = Arena.global().allocate(100, ValueLayout.JAVA_BYTE.byteAlignment());
        segment.set(ValueLayout.JAVA_BYTE, 0, (byte) 10);
        System.out.println(segment.get(ValueLayout.JAVA_BYTE, 0));
    }
}
