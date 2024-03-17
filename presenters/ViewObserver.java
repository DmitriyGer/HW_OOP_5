package Seminar005.presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);

    void updateReservetionTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
