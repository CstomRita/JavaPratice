package designpattern.singleton;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 11:21 2019-04-02
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class TicketMarker {
    private int ticket = 1000;
    private static TicketMarker ticketMarker;
    private static Object object = new Object();
    private TicketMarker() {

    }
    public static TicketMarker getInstance() {
        if (ticketMarker == null) {
            synchronized (object) {
                if (ticketMarker == null) {
                    ticketMarker = new TicketMarker();
                }
            }
        }
        return ticketMarker;
    }
    public synchronized int getNextTicketNumber() {
        return ticket++;
    }

}
