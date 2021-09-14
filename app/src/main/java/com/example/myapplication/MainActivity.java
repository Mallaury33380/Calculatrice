package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Variables
    float valeur1=0;
    float valeur2=0;
    boolean isVal1=true;
    boolean resultatPrecedent=false;
    String operateur="";
    String affichageTemp="";
    String historique="";
    TextView resultat;
    TextView textresultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultat = findViewById(R.id.resultat);
        textresultat = findViewById(R.id.historique);
        resultat.setMovementMethod(new ScrollingMovementMethod());

        //On récupère les valeurs stockées dans le bundle
        if(savedInstanceState != null)
        {
            valeur1=savedInstanceState.getFloat("val1");
            valeur2=savedInstanceState.getFloat("val2");
            isVal1=savedInstanceState.getBoolean("isVal1");
            operateur=savedInstanceState.getString("operateur");
            affichageTemp=savedInstanceState.getString("affichageTemp");
            resultat.setText(affichageTemp);
        }

        
        //On crée tous les boutons
        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(this);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);

        Button buttonplus = findViewById(R.id.buttonplus);
        buttonplus.setOnClickListener(this);

        Button buttonmoins = findViewById(R.id.buttonmoins);
        buttonmoins.setOnClickListener(this);

        Button buttonfois = findViewById(R.id.buttonfois);
        buttonfois.setOnClickListener(this);

        Button buttondivise = findViewById(R.id.buttondivise);
        buttondivise.setOnClickListener(this);

        Button buttonegale = findViewById(R.id.buttonegale);
        buttonegale.setOnClickListener(this);

        Button buttonclear = findViewById(R.id.buttonclear);
        buttonclear.setOnClickListener(this);



    }

    //On sauvegarde les variables dans le bundle
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putFloat("val1", valeur1);
        savedInstanceState.putFloat("val2", valeur2);
        savedInstanceState.putBoolean("isVal1",isVal1);
        savedInstanceState.putString("operateur",operateur);
        savedInstanceState.putString("affichageTemp",affichageTemp);
        savedInstanceState.putString("historique",affichageTemp);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onClick(View v)
    {
        String tmp="";

        //On effectue une animation à chaque appui
        AnimatorSet animation= new AnimatorSet();
        animation.playTogether(
                ObjectAnimator.ofFloat(v, "alpha", 1.0f, 0.0f, 1.0f),
                ObjectAnimator.ofFloat(v, "rotationX", 0.0f, 360f)
        );
        animation.start();

        //Si aucun opérateur n'a été encore sélectionné
        if(operateur=="")
        {
            //On détecte quel opérateur a été choisi
            switch (v.getId())
            {
                case R.id.buttonplus:
                    isVal1=false;
                    operateur="+";
                    affichageTemp+="+";
                    resultat.setText(affichageTemp);
                    break;
                case R.id.buttonmoins:
                    isVal1=false;
                    operateur="-";
                    affichageTemp+="-";
                    resultat.setText(affichageTemp);
                    break;
                case R.id.buttonfois:
                    isVal1=false;
                    operateur="*";
                    affichageTemp+="*";
                    resultat.setText(affichageTemp);
                    break;
                case R.id.buttondivise:
                    isVal1=false;
                    operateur="/";
                    affichageTemp+="/";
                    resultat.setText(affichageTemp);
                    break;
            }
        }
        //Si un opérateur a déjà été choisi
        else if(v.getId()==R.id.buttonplus || v.getId()==R.id.buttonmoins || v.getId()==R.id.buttonfois || v.getId()==R.id.buttondivise)
        {
            //On effectue la première opération, on affiche le résultat avec le nouvel opérateur et on détecte l'opérateur choisi
            switch (operateur)
            {
                case "+":
                    tmp+=(String.valueOf(valeur1));
                    tmp+=operateur;
                    tmp+=String.valueOf(valeur2);
                    tmp+="=";
                    tmp+=String.valueOf(valeur1+valeur2);
                    tmp+="\n";
                    historique=tmp+historique;
                    tmp="";
                    textresultat.setText(historique);

                    resultatPrecedent=true;

                    valeur1+=valeur2;
                    valeur2=0;
                    operateur="";
                    affichageTemp=String.valueOf(valeur1);
                    resultat.setText(affichageTemp);

                    isVal1=true;
                    break;
                case "-":
                    tmp+=(String.valueOf(valeur1));
                    tmp+=operateur;
                    tmp+=String.valueOf(valeur2);
                    tmp+="=";
                    tmp+=String.valueOf(valeur1-valeur2);
                    tmp+="\n";
                    historique=tmp+historique;
                    tmp="";
                    textresultat.setText(historique);

                    resultatPrecedent=true;

                    valeur1-=valeur2;
                    valeur2=0;
                    operateur="";
                    affichageTemp=String.valueOf(valeur1);
                    resultat.setText(affichageTemp);

                    isVal1=true;
                    break;
                case "*":
                    tmp+=(String.valueOf(valeur1));
                    tmp+=operateur;
                    tmp+=String.valueOf(valeur2);
                    tmp+="=";
                    tmp+=String.valueOf(valeur1*valeur2);
                    tmp+="\n";
                    historique=tmp+historique;
                    tmp="";
                    textresultat.setText(historique);

                    resultatPrecedent=true;

                    valeur1*=valeur2;
                    valeur2=0;
                    operateur="";
                    affichageTemp=String.valueOf(valeur1);
                    resultat.setText(affichageTemp);

                    isVal1=true;
                    break;
                case "/":
                    if(valeur2!=0)
                    {
                        tmp+=(String.valueOf(valeur1));
                        tmp+=operateur;
                        tmp+=String.valueOf(valeur2);
                        tmp+="=";
                        tmp+=String.valueOf(valeur1/valeur2);
                        tmp+="\n";
                        historique=tmp+historique;
                        tmp="";
                        textresultat.setText(historique);

                        resultatPrecedent=true;

                        valeur1/=valeur2;
                        valeur2=0;
                        operateur="";
                        affichageTemp=String.valueOf(valeur1);
                        resultat.setText(affichageTemp);

                        isVal1=true;
                    }
                    else
                    {
                        valeur1=0;
                        valeur2=0;
                        isVal1=true;
                        operateur="";
                        affichageTemp="";
                        resultat.setText("Division par zéro");
                    }
                    break;
            }

            switch (v.getId())
            {
                case R.id.buttonplus:
                    isVal1=false;
                    operateur="+";
                    affichageTemp+="+";
                    resultat.setText(affichageTemp);
                    break;
                case R.id.buttonmoins:
                    isVal1=false;
                    operateur="-";
                    affichageTemp+="-";
                    resultat.setText(affichageTemp);
                    break;
                case R.id.buttonfois:
                    isVal1=false;
                    operateur="*";
                    affichageTemp+="*";
                    resultat.setText(affichageTemp);
                    break;
                case R.id.buttondivise:
                    isVal1=false;
                    operateur="/";
                    affichageTemp+="/";
                    resultat.setText(affichageTemp);
                    break;
            }
        }

        //Si on appuie sur le bouton clear
        if(v.getId()==R.id.buttonclear)
        {
            valeur1=0;
            valeur2=0;
            isVal1=true;
            resultatPrecedent=false;
            operateur="";
            affichageTemp="";
            resultat.setText("0.0");
        }

        //Si on souhaite calculer l'opération entrée
        if(v.getId()==R.id.buttonegale)
        {
            switch (operateur)
            {
                case "+":
                    tmp+=(String.valueOf(valeur1));
                    tmp+=operateur;
                    tmp+=String.valueOf(valeur2);
                    tmp+="=";
                    tmp+=String.valueOf(valeur1+valeur2);
                    tmp+="\n";
                    historique=tmp+historique;
                    tmp="";
                    textresultat.setText(historique);

                    resultatPrecedent=true;

                    valeur1+=valeur2;
                    valeur2=0;
                    operateur="";
                    affichageTemp=String.valueOf(valeur1);
                    resultat.setText(affichageTemp);

                    isVal1=true;
                    break;
                case "-":
                    tmp+=(String.valueOf(valeur1));
                    tmp+=operateur;
                    tmp+=String.valueOf(valeur2);
                    tmp+="=";
                    tmp+=String.valueOf(valeur1-valeur2);
                    tmp+="\n";
                    historique=tmp+historique;
                    tmp="";
                    textresultat.setText(historique);

                    resultatPrecedent=true;

                    valeur1-=valeur2;
                    valeur2=0;
                    operateur="";
                    affichageTemp=String.valueOf(valeur1);
                    resultat.setText(affichageTemp);

                    isVal1=true;
                    break;
                case "*":
                    tmp+=(String.valueOf(valeur1));
                    tmp+=operateur;
                    tmp+=String.valueOf(valeur2);
                    tmp+="=";
                    tmp+=String.valueOf(valeur1*valeur2);
                    tmp+="\n";
                    historique=tmp+historique;
                    tmp="";
                    textresultat.setText(historique);

                    resultatPrecedent=true;

                    valeur1*=valeur2;
                    valeur2=0;
                    operateur="";
                    affichageTemp=String.valueOf(valeur1);
                    resultat.setText(affichageTemp);

                    isVal1=true;
                    break;
                case "/":
                    if(valeur2!=0)
                    {
                        tmp+=(String.valueOf(valeur1));
                        tmp+=operateur;
                        tmp+=String.valueOf(valeur2);
                        tmp+="=";
                        tmp+=String.valueOf(valeur1/valeur2);
                        tmp+="\n";
                        historique=tmp+historique;
                        tmp="";
                        textresultat.setText(historique);

                        resultatPrecedent=true;

                        valeur1/=valeur2;
                        valeur2=0;
                        operateur="";
                        affichageTemp=String.valueOf(valeur1);
                        resultat.setText(affichageTemp);

                        isVal1=true;
                    }
                    else
                    {
                        valeur1=0;
                        valeur2=0;
                        isVal1=true;
                        operateur="";
                        affichageTemp="";
                        resultat.setText("Division par zéro");
                    }
                    break;
            }
        }

        //On crée la première opérande si l'opération en cours ne dépend pas d'une opération précédente
        if(isVal1==true && resultatPrecedent==false)
        {
            switch (v.getId())
            {
                case R.id.button0:
                    valeur1=valeur1*10+0;
                    affichageTemp=affichageTemp+0;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button1:
                    valeur1=valeur1*10+1;
                    affichageTemp=affichageTemp+1;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button2:
                    valeur1=valeur1*10+2;
                    affichageTemp=affichageTemp+2;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button3:
                    valeur1=valeur1*10+3;
                    affichageTemp=affichageTemp+3;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button4:
                    valeur1=valeur1*10+4;
                    affichageTemp=affichageTemp+4;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button5:
                    valeur1=valeur1*10+5;
                    affichageTemp=affichageTemp+5;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button6:
                    valeur1=valeur1*10+6;
                    affichageTemp=affichageTemp+6;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button7:
                    valeur1=valeur1*10+7;
                    affichageTemp=affichageTemp+7;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button8:
                    valeur1=valeur1*10+8;
                    affichageTemp=affichageTemp+8;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button9:
                    valeur1=valeur1*10+9;
                    affichageTemp=affichageTemp+9;
                    resultat.setText(affichageTemp);
                    break;
            }
        }
        //On crée la seconde opérande
        else if(isVal1==false)
        {
            switch (v.getId())
            {
                case R.id.button0:
                    valeur2=valeur2*10+0;
                    affichageTemp=affichageTemp+0;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button1:
                    valeur2=valeur2*10+1;
                    affichageTemp=affichageTemp+1;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button2:
                    valeur2=valeur2*10+2;
                    affichageTemp=affichageTemp+2;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button3:
                    valeur2=valeur2*10+3;
                    affichageTemp=affichageTemp+3;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button4:
                    valeur2=valeur2*10+4;
                    affichageTemp=affichageTemp+4;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button5:
                    valeur2=valeur2*10+5;
                    affichageTemp=affichageTemp+5;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button6:
                    valeur2=valeur2*10+6;
                    affichageTemp=affichageTemp+6;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button7:
                    valeur2=valeur2*10+7;
                    affichageTemp=affichageTemp+7;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button8:
                    valeur2=valeur2*10+8;
                    affichageTemp=affichageTemp+8;
                    resultat.setText(affichageTemp);
                    break;
                case R.id.button9:
                    valeur2=valeur2*10+9;
                    affichageTemp=affichageTemp+9;
                    resultat.setText(affichageTemp);
                    break;
            }
        }
    }

}

