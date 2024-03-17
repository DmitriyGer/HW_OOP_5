package Seminar005.views;

import Seminar005.models.Table;
import Seminar005.presenters.View;
import Seminar005.presenters.ViewObserver;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private Collection<ViewObserver> observers;

    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    @Override
    public void registerObserver(ViewObserver observer) {
        if (observers == null)
            observers = new ArrayList<>();
        observers.add(observer);
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер брони: #%d\n", reservationNo);
        }
        else {
            System.out.println("Произошла ошибка при попытке забронировать столик.\nПовторите операцию позже.");
        }
    }


    public void reservationTable(Date orderDate, int tableNo, String name){
        if (observers != null)
        {
            for (ViewObserver observer : observers){
                observer.onReservationTable(orderDate, tableNo, name);
            }
        }
    }
    
    
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNumber, String nameClients) {
        if (observers != null) {
            for (ViewObserver observer : observers) {
                observer.updateReservetionTable(oldReservation, reservationDate, tableNumber, nameClients);
            }
        }
    }

    
    public void showСhangeReservationTable(int newReservationNumber, int newNumberTable) {
        if (newReservationNumber > 0) {
            System.out.printf("Бронь изменена. В брони №%d изменен стол на №%d\n",
                    newReservationNumber, newNumberTable);
        } else {
            System.out.println("Произошла ошибка, попробуйте повторить попытку позже.");
        }
    }

}
