package Seminar005.presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private Model model;
    private View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        view.registerObserver(this);
    }

    public void updateTablesView(){
        view.showTables(model.loadTables());
    }

    private void updateReservationTableView(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }

    public void updateСhangeReservationTable(int reservationNo, int numberTable) {
        view.showСhangeReservationTable(reservationNo, numberTable);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        }
        catch (Exception e){
            updateReservationTableView(-1);
        }
    }

    @Override
    public void updateReservetionTable(int oldReservation, Date reservationDate, int tableNo, String name){
        try{
            int newReservetionNumber = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            updateСhangeReservationTable(newReservetionNumber, tableNo);
        } catch (Exception e) {
            updateСhangeReservationTable(-1, -1);
        }
    }
}
