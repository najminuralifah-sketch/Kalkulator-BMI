package controler;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import model.BMI;

public class KalkulatorBMIController {

    @FXML
    private ToggleButton btnLakiLaki, btnPerempuan;

    @FXML
    private TextField txtBerat, txtTinggi;

    @FXML
    private Label lblHasil;

    private ToggleGroup genderGroup;

    @FXML
    public void initialize() {
        genderGroup = new ToggleGroup();

        btnLakiLaki.setToggleGroup(genderGroup);
        btnPerempuan.setToggleGroup(genderGroup);

        btnLakiLaki.setSelected(true);
    }

    @FXML
    public void pilihLakiLaki() {
        btnLakiLaki.setSelected(true);
    }

    @FXML
    public void pilihPerempuan() {
        btnPerempuan.setSelected(true);
    }

    @FXML
    public void hitungBMI() {
        try {
            // Mengambil jenis kelamin
            String gender;

            if (btnLakiLaki.isSelected()) {
                gender = "Laki-laki";
            } else {
                gender = "Perempuan";
            }

            // Mengambil input berat dan tinggi
            int berat = Integer.parseInt(txtBerat.getText());
            int tinggi = Integer.parseInt(txtTinggi.getText());

            // Membuat objek Model BMI
            BMI bmi = new BMI(gender, berat, tinggi);

            // Menghitung BMI
            double nilaiBMI = bmi.perhitunganBMI();

            // Menentukan kategori
            String kategori = bmi.kategori(nilaiBMI);

            // Menampilkan hasil
            lblHasil.setText(
                String.format(
                    "Gender: %s\nBMI: %.2f\nKategori: %s",
                    gender, nilaiBMI, kategori
                )
            );

        } catch (NumberFormatException e) {
            lblHasil.setText("Masukkan berat dan tinggi dengan benar!");

        } catch (IllegalArgumentException e) {
            lblHasil.setText(e.getMessage());
        }
    }
}
