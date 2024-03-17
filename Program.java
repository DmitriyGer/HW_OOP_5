package Seminar005;

import Seminar005.models.TableService;
import Seminar005.presenters.BookingPresenter;
import Seminar005.presenters.Model;
import Seminar005.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Model model = new TableService();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTablesView();

        view.reservationTable(new Date(), 2, "Станислав");
        view.reservationTable(new Date(), 4, "Дмитрий");

        view.changeReservationTable(1001, new Date(), 5, "Станислав");

    }

}
