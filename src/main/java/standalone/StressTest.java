package standalone;

public class StressTest {
    public static void main(String args[]) {
        StressThread T1 = new StressThread( "StressThread-1");
        T1.start();

        StressThread T2 = new StressThread( "StressThread-2");
        T2.start();

        StressThread T3 = new StressThread( "StressThread-3");
        T3.start();
    }
}