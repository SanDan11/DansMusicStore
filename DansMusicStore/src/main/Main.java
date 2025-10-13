package main;

import database.DatabaseSetup;
import utils.DatabaseBackup;
import gui.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[]args) {

        DatabaseSetup.createTables();
        DatabaseBackup.createBackup();

        SwingUtilities.invokeLater(() -> new MainWindow());
    }
}