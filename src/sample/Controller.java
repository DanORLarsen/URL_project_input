package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.awt.desktop.OpenURIHandler;
import java.net.URL;

import java.awt.*;
import java.awt.desktop.OpenFilesEvent;
import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML
    TextField displayer;

    @FXML
    TextArea outputDisplay;


    public void sendKommando(ActionEvent actionEvent) {
        try {

            String s = displayer.getText();
            outputDisplay.setText((outputDisplay.getText() + "Du har skrevet: " + s + "\n"));
            s = s.toLowerCase();
            if (s.charAt(0) == 'w' && s.charAt(1) == 'w' && s.charAt(2) == 'w' && s.charAt(3) == '.')
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(s));
            else
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("www." + s));
        }catch (Exception e){
            System.out.println("Kan ikke finde siden");
        }
    }

    public void clear(ActionEvent actionEvent) {
        outputDisplay.clear();
    }

    public void getInfo(ActionEvent actionEvent) {

        outputDisplay.setText(outputDisplay.getText() + "Navn: Dan" + "\nAlder: 21 år" + "\nUddannelse: DAT\n");
    }

    public void openTank(MouseEvent mouseEvent) throws IOException {
        String htmlPath = "www.tanktrouble.com";
        java.awt.Desktop.getDesktop().browse(java.net.URI.create(htmlPath));

    }
}
