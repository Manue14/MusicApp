module edu.badpals.appmusica {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens edu.badpals.appmusica to javafx.fxml;
    opens edu.badpals.appmusica.entities to org.hibernate.orm.core;
    exports edu.badpals.appmusica;
}