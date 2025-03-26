module com.terracotta004.javafxtimedbuttongame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.terracotta004.javafxtimedbuttongame to javafx.fxml;
    exports com.terracotta004.javafxtimedbuttongame;
}