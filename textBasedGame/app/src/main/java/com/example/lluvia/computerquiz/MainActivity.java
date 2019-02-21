package com.example.lluvia.computerquiz;

import android.app.Activity;
import android.app.assist.AssistStructure;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private TextView historiaView;
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private ArrayList<String> historia1;
    private ArrayList<String> historia2;
    private ArrayList<String> historia3;
    private ArrayList<String> botonTexto1;
    private ArrayList<String> botonTexto2;
    private ArrayList<String> botonTexto3;
    private int historiaIndex1;
    private int historiaIndex2;
    private int historiaIndex3;
    private int botonTextoIndex1;
    private int botonTextoIndex2;
    private int botonTextoIndex3;
    private boolean principioVariable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        this.initialize();
    }

    public void initialize() { //Defines everything and starts the story from beginning
        historiaIndex1 = 0;
        historiaIndex2 = -1;
        historiaIndex3 = -1;
        botonTextoIndex1 = 0;
        botonTextoIndex2 = 0;
        botonTextoIndex3 = 0;

        historiaView = findViewById(R.id.texto_Historia);
        boton1 = findViewById(R.id.boton_Eleccion1);
        boton2 = findViewById(R.id.boton_Eleccion2);
        boton3 = findViewById(R.id.boton_Eleccion3);

        principioVariable = false;

        historia1 = new ArrayList<String>();
        historia2 = new ArrayList<String>();
        historia3 = new ArrayList<String>();
        botonTexto1 = new ArrayList<String>();
        botonTexto2 = new ArrayList<String>();
        botonTexto3 = new ArrayList<String>();

        this.principio();

    }

    public void muestraHistoria1(int index) { //Shows the story in the TextView
        historiaView.setText(historia1.get(historiaIndex1));

        this.textoBotones(botonTextoIndex1);
        this.textoBotones(botonTextoIndex2);
        this.textoBotones(botonTextoIndex3);
    }

    public void muestraHistoria2(int index) { //Shows the branching of the story
        historiaView.setText(historia2.get(historiaIndex2));

        this.textoBotones2(botonTextoIndex2);
    }

    public void muestraHistoria3(int index) { //Shows the branching of the story
        historiaView.setText(historia3.get(historiaIndex3));

        this.textoBotones3(botonTextoIndex3);
    }
    public void textoBotones(int index) { //Shows button text
        boton1.setText(botonTexto1.get(botonTextoIndex1));
        boton2.setText(botonTexto2.get(botonTextoIndex2));
        boton3.setText(botonTexto3.get(botonTextoIndex3));

    }

    public void textoBotones2(int index) {//Shows button text in the branch
        boton2.setText(botonTexto2.get(botonTextoIndex2));

    }

    public void textoBotones3(int index) { //Shows the button text in the branch
        boton3.setText(botonTexto3.get(botonTextoIndex3));
    }

    public void chequeaBotones1() { //Checks for the visibility of the button

        if (historiaIndex1 == 1) {
            boton2.setVisibility(View.GONE);
            boton3.setVisibility(View.GONE);
        }

        if (historiaIndex1 == 3) {
            boton2.setVisibility(View.VISIBLE);
        }

        if(historiaIndex1 == 4) {
            boton2.setVisibility(View.GONE);
        }

        if (historiaIndex2 == 0) {
            boton1.setVisibility(View.GONE);
        }

        if(historiaIndex1 == 17) {
            boton3.setVisibility(View.VISIBLE);
        }

        if(historiaIndex1 == 18) {
            boton3.setVisibility(View.GONE);
        }

        if(historiaIndex3 == 0) {
            boton1.setVisibility(View.GONE);
        }

        this.chequeaBotones2();
    }

    public void chequeaBotones2() { //Checks for the value and shows certain text dialogue from that
        if (historiaIndex1 == 1) {
            historia1.add(new String("Bien. Vamos a empezar"));
            botonTexto1.add(new String("Empieza"));
            this.muestraHistoria1(historiaIndex1);
        }

        if (historiaIndex1 == 2) {
            historia1.add(new String("Un dia, habia una cosa en la ventana de una casa en una calle de un pueblo en una ciudad en un pais en un continento en una planeta. " +
                    "Supongo que es de la Tierra, pero no se."));
            botonTexto1.add(new String("Entiendo"));
            this.muestraHistoria1(historiaIndex1);
        }

        if (historiaIndex1 == 3 && historiaIndex2 < 0) {
            historia1.add(new String("La cosa era un pastel de manzanas. Ay, el olor del pastel alcanza a su nariz. " +
                    "Que olor tiene el pastel. Es como al que cocinaba su mama."));
            botonTexto1.add(new String("Quiero comerlo. Dame ya."));
            botonTexto2.add(new String("Mi mama no cocinaba pasteles de manzanas."));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 4) {
            historia1.add(new String("Bueno, lo toma de la ventana de la casa en la calle. " +
                    "Y lo come usted porque tenia mucho hambre y no puede resistir la tension mucho mas."));
            botonTexto1.add(new String("Que delicioso"));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 5) {
            historia1.add(new String("Pero un problema aparece. Ahora, esta aburrido/a usted, " +
                    "y necesita algo de entretenimiento"));
            botonTexto1.add(new String("Que tipo de historia es esto?"));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 6) {
            historia1.add(new String("Solo escucheme por favor. No soy bueno a contar historias, " +
            "pero creo que esta va a ser la mas buena que he contado"));
            botonTexto1.add(new String("Esta bien. Vamos, cuentame."));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 7) {
            historia1.add(new String("Bueno, va usted a una habitacion y ve una computadora. " +
            "Tiene un HTC Vive asi que puede jugar un juego que soporta realidad virtual."));
            botonTexto1.add(new String("O. Que bien. Quiero jugar."));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 8) {
            historia1.add(new String("Pero un otro problema aparece. La computadora " +
            "necesita una contrasena para que se pueda desbloquear y lo juega usted."));
            botonTexto1.add(new String("Mira, solo quiero jugarlo. Que tengo que hacer?"));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 9) {
            historia1.add(new String("Mire, la contrasena esta debajo del teclado. " +
            "El dueno no sabe nada de seguridad. No deberia dejar la contrasena en los lugares " +
            "cerca de la cosa que necesita ella. No es buena forma de guardarlo de personas como usted,"));
            botonTexto1.add(new String("Si ya se. Pero el dueno no es inteligente."));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 10) {
            historia1.add(new String("Bueno, vaya a jugar. El videojuego es de tu vida."));
            botonTexto1.add(new String("Solo dejame jugar."));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 11) {
            historia1.add(new String("Empieza usted con un ambiente calmado. Hay arboles, " +
            "cesped, y una casa en una calle de un pueblo en una ciudad en un pais en un " +
            "continento en una planeta. Supongo que e de la Tierra, pero no se."));
            botonTexto1.add(new String("Que deja vu. He estado aqui hace unos minutos, no?"));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 12) {
            historia1.add(new String("Vaya por la ventana, hay un pastel de manzanas por " +
            "ahi. Y huele muy bien, como canela y todo lo que contiene un pastel de manzanas."));
            botonTexto1.add(new String("Bueno, supongo que puedo comerlo. Huele bien, como dices"));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 13) {
            historia1.add(new String("Lo come completamente, y no queda ninguna miga, " +
            "gracias a su lengua."));
            botonTexto1.add(new String("El pastel fue delicioso, como el primer pastel, " +
            "que comi ya."));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 14) {
            historia1.add(new String("Espere. Hay alguien en la casa. Lo escucho." +
            "Esta en la habitacion donde fue usted. Vamos a encontrar que esta dentro."));
            botonTexto1.add(new String("Esta bien. Pero estoy nervioso."));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 15) {
            historia1.add(new String("Mire, esta utilizando la computadora. " +
            "El mira debajo del teclado, pero no se por que. Pues quiere la contrasena."));
            botonTexto1.add(new String("Que deja vu."));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 16) {
            historia1.add(new String("Desbloqueo la computadora y ahora juega un " +
            "videojuego. Esta utilizando el HTC Vive y juega algo acerca de su vida. Supongo " +
            "que es el mismo juego que esta jugando usted ahora mismo."));
            botonTexto1.add(new String("Que deberia hacer? El me parece como mi mismo"));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 17 && historiaIndex3 < 0) {
            historia1.add(new String("Matalo, porque este es un videojuego. y no hay " +
            "consecuencias aca. Tome la pistola al lado de ti en el suelo y hazlo."));
            botonTexto1.add(new String("Bueno, vamos"));
            botonTexto3.add(new String("No, te voy a matar a ti."));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 18) {
            historia1.add(new String("Ha matado usted a usted mismo. Asi que muere " +
            "usted tambien con una bala en la cabeza como la otra persona que ya ha muerta. " +
            "Bueno no es otra persona, pero es usted. Solo hay un cadaver en el piso, no dos. " +
            "Creo que ya sabes que tratando de decir."));
            botonTexto1.add(new String("Gracias por sugerir matarme a mi mismo."));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex1 == 19) {
            historia1.add(new String("Bueno, perdon pero no sabia que fue un videojuego " +
            " tan real en que puede matarse a su mismo. Que paradoja. Vamos otra vez."));
            botonTexto1.add(new String("Vamos otra vez, pues."));
            this.muestraHistoria1(historiaIndex1);
        }

        if(historiaIndex2 == 0) {
            historia2.add(new String("Bueno, tiene que elegir la otra opcion, tio. Vamos otra vez."));
            botonTexto2.add(new String("Supongo que si"));
            this.muestraHistoria2(historiaIndex2);
        }

        if(historiaIndex3 == 0) {
            historia3.add(new String("No, no puede hacer eso, usted! Le he creado " +
            "para mi entretenimiento. No es capaz para matarme."));
            botonTexto3.add(new String("Mira, escucho algo de un cuarto por el este. " +
            "Esta por el otro lado de la puerta."));
            this.muestraHistoria3(historiaIndex3);
        }

        if(historiaIndex3 == 1) {
            historia3.add(new String("No, no abra la puerta. No hay nada por el otro lado."));
            botonTexto3.add(new String("La estoy abriendo"));
            this.muestraHistoria3(historiaIndex3);
        }

        if(historiaIndex3 == 2) {
            historia3.add(new String("Asi que me encontro usted a mi. Bueno no puede " +
            "hacer nada a mi. Jajajaja"));
            botonTexto3.add(new String("Te disparo a ti."));
            this.muestraHistoria3(historiaIndex3);
        }

        if(historiaIndex3 == 3) {
            historia3.add(new String("Ay me disparo a mi usted. Pero estoy muerto? " +
            "Compra el DLC para saber. Es veinte dolares."));
            botonTexto3.add(new String("Compra el DLC."));
            this.muestraHistoria3(historiaIndex3);
        }
    }

    public void principio() { //Deletes everything and starts over
        historiaIndex1 = 0;
        historiaIndex2 = -1;
        historiaIndex3 = -1;
        botonTextoIndex1 = 0;
        botonTextoIndex2 = 0;
        botonTextoIndex3 = 0;
        principioVariable = false;

        for (int i = 0; i < historia1.size(); i++) {
            historia1.remove(i);
        }

        for (int i = 0; i < botonTexto1.size(); i++) {
            botonTexto1.remove(i);
        }

        for (int i = 0; i < botonTexto2.size(); i++) {
            botonTexto2.remove(i);
        }

        for (int i = 0; i < botonTexto3.size(); i++) {
            botonTexto3.remove(i);
        }

        historia1.add(new String("Esta listo usted para tomar parte en esta historia?"));
        botonTexto1.add(new String("Si."));
        botonTexto2.add(new String("No."));
        botonTexto3.add(new String("No estoy entuciasmado/a"));

        boton1.setVisibility(View.VISIBLE);
        boton2.setVisibility(View.VISIBLE);
        boton3.setVisibility(View.VISIBLE);

        this.muestraHistoria1(historiaIndex1);

    }

    public void aumenta1(View v) { //increase story index by 1 each time it's pressed
        historiaIndex1++;
        botonTextoIndex1++;

        this.chequeaBotones1();

        if(historiaIndex1 == 2) {
            botonTextoIndex2++;
        }

        if(historiaIndex1 == 16) {
            botonTextoIndex3++;
        }

        if(historiaIndex1 == 20) {
            this.initialize();
        }
    }

    public void aumenta2(View v) { //increase story index by 1 or, if 0, shows a Toast message
        if (historiaIndex1 == 0) {
            Toast.makeText(this, "Este juego no es para perdedores. Asi que pongase la cara de un ganador. LOL.",
                    Toast.LENGTH_LONG).show();
        }
        if (historiaIndex1 == 3) {
            historiaIndex2++;
            botonTextoIndex2++;
        }
        if(historiaIndex2 == 1) {
            Toast.makeText(this, "Vamos a empezar de nuevo.", Toast.LENGTH_SHORT).show();
            this.initialize();
        }
        this.chequeaBotones1();
    }

    public void aumenta3(View v) {
        if (historiaIndex1 == 0) {
            Toast.makeText(this, "Yo tampoco, pero tengo que ser una guia para usted.",
                    Toast.LENGTH_SHORT).show();
        }

        if(historiaIndex1 == 17) {
            historiaIndex3++;
            botonTextoIndex3++;
        }

        if(historiaIndex3 == 4) {
            Toast.makeText(this, "Lol. No hay DLC. Esta muerto el narrador y sigue " +
                    "vivo usted. Yo se que fue una historia mala Pero, solo queria practicar " +
                    "utilizando Android Studio.", Toast.LENGTH_LONG).show();
            this.initialize();
        }
        this.chequeaBotones1();
    }
}
