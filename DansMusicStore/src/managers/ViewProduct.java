package managers;

import dao.*;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewProduct {

    public static List<Object[]> getProductsByCategory(String category) {
        List<Object[]> rows = new ArrayList<>();

        switch (category.toLowerCase()) {
            case "guitar" -> rows = GuitarDAO.getAllGuitars();
            case "drum" -> rows = DrumDAO.getAllDrums();
            case "bass" -> rows = BassDAO.getAllBasses();
            case "keyboard" -> rows = KeyboardDAO.getAllKeyboards();
            case "amp" -> rows = AmpDAO.getAllAmps();
            case "audio" -> rows = AudioDAO.getAllAudio();
            case "accessories" -> rows = AccessoriesDAO.getAllAccessories();
        }
        return rows;
    }
}
