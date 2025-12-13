module it.ludina.bugboard26fe.bugboard26frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires java.desktop;
    requires java.net.http;

    opens it.ludina.bugboard26fe.bugboard26frontend to javafx.fxml;
    exports it.ludina.bugboard26fe.bugboard26frontend;
    exports it.ludina.bugboard26fe.bugboard26frontend.DettaglioIssue;
    opens it.ludina.bugboard26fe.bugboard26frontend.DettaglioIssue to javafx.fxml;
}