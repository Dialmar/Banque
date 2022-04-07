package com.example.conversion;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.*;
import java.lang.*;
import java.io.*;


public class ConversionController {
    private int montant;
    private int tauxActu;
    @FXML
    private Label errorNumber;
    @FXML
    private TextField somme1;
    @FXML
    private Label taux;
    @FXML
    private ChoiceBox monnaies;
    @FXML
    private TextField tauxResult;

    @FXML
    private Text currencyError;

    double franc = 0.0021;
    double Usd = 1.26;
    double euro = 1.37;
    double dinarTunisien = 0.42;
    double livreSterling = 1.64;
    double roupîeIndienne = 0.017;

    @FXML
    public void Calculer() {
       if(NumberOnly()) {
        double total = 0;
        double somme = Integer.parseInt(somme1.getText());
        String monnaie = getCurrency();
        switch (monnaie){
            case "Franc CFA":
                total = somme * franc;
                break;
            case "Euro":
                total = somme * euro;
                break;
            case "Dollars USD" :
                total = somme * Usd ;
                break;
            case "Livre Sterling" :
                total = somme * livreSterling;
                break;
            case "Roupie Indienne" :
                total = somme * roupîeIndienne;
                break;
            case "Dinar Tunisien" :
                total = somme * dinarTunisien;
                break;
        }
        double arrondir = Math.round(total*100.0)/100.0;
        tauxResult.setText(String.valueOf(arrondir) + " $");
System.out.println("user input " + monnaie + " $");

       }
    }

    public boolean NumberOnly(){
        boolean isnotNumber = false;
             isnotNumber = somme1.getText().toString().chars().allMatch( x -> Character.isDigit(x));
if(!isnotNumber ||  somme1.getText().isBlank())
    errorNumber.setText("Veuillez rentrer un chiffre ");
else
    errorNumber.setText("");

        return isnotNumber;
    }
    public String getCurrency(){
        String monnaie = null;
         monnaie = monnaies.getValue().toString();
            if (monnaie.equals("monnaies") )
                currencyError.setText("Veuillez selectionner une monnaie ");
            else
                currencyError.setText("");

            return  monnaie;
    }
}
