package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;



public class tempiPiscina extends Application{

	Button bAlloca = new Button("alloca");
	Button bInserisci = new Button("inserisci");
	Button bStampa = new Button("stampa");
	TextField tNumero = new TextField("numero:");
	TextField tQuanti = new TextField("quanti numeri:");
	Label lElenco = new Label("");
	Label lMedia = new Label("");
	Label lDiminuizione = new Label("");
	Label lConta = new Label("");
	
	int numTempi;
	int [] tempi;
	int posizione;
	int conta;
	
	public void start(Stage finestra) {
		
		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);
		
		
		
		griglia.add(tNumero, 0, 0);
		griglia.add(tQuanti, 1, 0);
		griglia.add(bAlloca, 0, 1);
		griglia.add(bInserisci, 0, 2);
		griglia.add(bStampa, 0, 3);
		griglia.add(lElenco, 0, 4);
		griglia.add(lMedia, 0, 5);
		griglia.add(lConta, 0, 6);
		
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10));
		
		
		
		finestra.setScene(scena);
		finestra.setTitle("esercizio 1 vettori");
		finestra.show();
		
		bAlloca.setOnAction(e->alloca());
		bInserisci.setOnAction(e->inserisci());
		bStampa.setOnAction(e->stampa());
	
		
	}
	
	
	public void alloca() {
		
		tempi = new int[ Integer.parseInt(tQuanti.getText())];
		posizione = 0;
		conta = Integer.parseInt(tQuanti.getText());
		lConta.setText(""+conta);
	}
	
	
	public void inserisci() {
		if (posizione < tempi.length) {
			tempi[posizione++]= Integer.parseInt(tNumero.getText());
			tNumero.setText("");
			conta-=1;
			lConta.setText(""+conta);
		}
	}
		private  void stampa() {
			String s="";
			int somma =0;
			double media = 0;
			for ( int i=0; i<tempi.length;i++) {
				s=s+tempi[i]+"-";
				somma = somma+tempi[i];
			}
			media = somma/tempi.length;
			lMedia.setText(media+"");
			lElenco.setText(s);
			 
		}
		
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
