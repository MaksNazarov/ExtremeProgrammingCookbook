module hse.exam.extremeprogrammingcookbook {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens hse.exam.extremeprogrammingcookbook to javafx.fxml;
    exports hse.exam.extremeprogrammingcookbook;

    opens hse.exam.extremeprogrammingcookbook.view;
    exports hse.exam.extremeprogrammingcookbook.view;
    exports hse.exam.extremeprogrammingcookbook.model;
}