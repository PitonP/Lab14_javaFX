module com.example.lab_with_javafx {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.lab_with_javafx to javafx.fxml;
    exports com.example.lab_with_javafx;
}