module it.ludina.bugboard26.bugboard26frontend {
    requires transitive javafx.base;
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires static lombok;
    requires com.fasterxml.jackson.databind;
    requires java.net.http;

    opens it.ludina.bugboard26.bugboard26frontend to javafx.fxml;
    exports it.ludina.bugboard26.bugboard26frontend;
    exports it.ludina.bugboard26.bugboard26frontend.IssueDetails;
    opens it.ludina.bugboard26.bugboard26frontend.IssueDetails to javafx.fxml;
    exports it.ludina.bugboard26.bugboard26frontend.ErrorsController;
    opens it.ludina.bugboard26.bugboard26frontend.ErrorsController to javafx.fxml;
}