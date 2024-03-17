package Seminar005.presenters;

import Seminar005.models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    void showTables(Collection<Table> tables);

    void registerObserver(ViewObserver observer);

    void showReservationTableResult(int reservationNo);

    void showСhangeReservationTable(int reservationNo, int newNumberTable);

    void changeReservationTable(int oldReservation, Date reservationDate, int tableNumber, String nameClients);
}
