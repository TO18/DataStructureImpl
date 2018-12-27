import java.lang.*;
import org.junit.Test;

public class Practice {
    public static void main(String[] args) {
        String strTest = "value1";
        strTest.concat("value2");
        System.out.println(strTest);

        PracticeObject practiceObj = new PracticeObject();
        System.out.println(practiceObj.toString());
        System.out.println(practiceObj.clone());
        System.out.println(practiceObj.hashCode());
        System.out.println(practiceObj.equals(strTest));
        System.out.println(practiceObj.run());
        System.out.println(practiceObj.nextRun());
        System.out.println(practiceObj.nextNextRun());
        // toString(), hashCode(), clone(), equals() all extended from the Object super class

        System.out.println("str" instanceof Object);
        System.out.println(practiceCommonVariables.run);
    }

    @Test
    public void testStringBuffer() {
        StringBuffer strBuffer = new StringBuffer("value1");
        String s2 = "value2";
        for (int i = 0; i < 100000; i++) {
            strBuffer.append(s2);
        }
        System.out.println(strBuffer);
    }

    @Test
    public void testString() {
        String str = "value1";
        String s2 = "value2";
        for (int i = 0; i < 100000; i++) {
            str += s2;
        }
        System.out.println(str);
    }
}


abstract class practiceAbsClass {
    protected abstract String run();
    abstract String nextNextRun();
}

abstract class practiceAbsClass2 extends practiceAbsClass{
    public String run() {
        return "running";
    }

    protected abstract String nextRun();
}

class PracticeObject extends practiceAbsClass2{
    @Override
    public boolean equals(Object compObject) {
        return (compObject.hashCode() == this.hashCode());
    }
    @Override
    public Object clone() {
        return new PracticeObject();
    }
    @Override
    public int hashCode() {
        return 123456789;
    }
    @Override
    public String toString() {
        return "{this: is the object returned}";
    }

    @Override
    String nextNextRun() {
        return "nextNextRunning";
    }

    @Override
    public String nextRun() {
        return "nextRunning";
    }
}

interface PracticeInterface {
    void running();
    default void newRunning() {

    }
    int run = 3;
}

final class practiceCommonVariables {
    static final int run = 3;
}