package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String NUM_1 = "1";
    public static final String NUM_2 = "2";
    public static final String NUM_3 = "3";
    public static final String NUM_4 = "4";
    public static final String NUM_5 = "5";
    public static final String NUM_6 = "6";
    public static final String NUM_7 = "7";
    public static final String NUM_8 = "8";
    public static final String NUM_9 = "9";
    public static final String NUM_0 = "0";
    public static final String COMA_DECIMAL = ".";

    private TextView visor;
    private String termino1;
    private String termino2;
    private String operacion;
    private String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visor = (TextView) findViewById(R.id.visor);
    }

    public void calcular(View v) {
        float num1 = 0;
        float num2 = 0;

        if (this.termino1 != null && this.termino2 != null && this.resultado == null) {
            num1 = Float.parseFloat(this.termino1);
            num2 = Float.parseFloat(this.termino2);
        } else if(this.termino1 != null && this.termino2 != null && this.resultado != null){
            num1 = Float.parseFloat(this.resultado);
            num2 = Float.parseFloat(this.termino2);
        } else if (this.termino1 != null && this.termino2 == null && this.resultado == null) {
            num1 = Float.parseFloat(this.termino1);
        }

        if(operacion != null){
            switch (operacion) {
                case "+":
                    hacerSuma(num1, num2);
                    break;
                case "-":
                    hacerResta(num1, num2);
                    break;
                case "*":
                    hacerMultiplicacion(num1, num2);
                    break;
                case "/":
                    hacerDivision(num1, num2);
                    break;
                default:
                    visor.setText("0");
                    break;
            }
        }
    }

    public void limpiarTodo(View v) {
        visor.setText("0");
        this.termino1 = null;
        this.termino2 = null;
        this.operacion = null;
        this.resultado = null;
    }

    public void limpiarVisor(View v) {
        visor.setText("0");
        System.out.println(this.operacion);
        if (this.operacion == null) {
            this.termino1 = null;
        } else {
            this.termino2 = null;
        }
    }

    public void borrarUltimoDigito(View v){
        if(visor.getText().toString().equals("0")==false){
            String visorTemp = visor.getText().toString();
            visorTemp = visorTemp.substring(0, visorTemp.length()-1);
            visor.setText(visorTemp);
            if (operacion == null) {
                termino1 = visorTemp;
            } else {
                termino2 = visorTemp;
            }
        }
    }

    // Operaciones ----------------

    public void invertirSigno(View v) {
        if (this.termino1 != null && this.operacion == null) {
            if (this.termino1.charAt(0) == "-".charAt(0)) {
                this.termino1 = this.termino1.replace("-", "");
                visor.setText(this.termino1);
            } else {
                this.termino1 = "-"+this.termino1;
                visor.setText(this.termino1);
            }
        } else if (this.termino2 != null) {
            if (this.termino2.charAt(0) == "-".charAt(0)) {
                this.termino2 = this.termino2.replace("-", "");
                visor.setText(this.termino2);
            } else {
                this.termino2 = "-"+this.termino2;
                visor.setText(this.termino2);
            }
        }
    }

    public void sumar(View v) {
        if(this.termino1 == null) {
            this.termino1 = "0";
        }
        operacion = "+";
        visor.setText("0");
    }

    public void restar(View v) {
        if(this.termino1 == null) {
            this.termino1 = "0";
        }
        operacion = "-";
        visor.setText("0");
    }

    public void multiplicar(View v) {
        if(this.termino1 == null) {
            this.termino1 = "0";
        }
        operacion = "*";
        visor.setText("0");
    }

    public void dividir(View v) {
        if(this.termino1 == null) {
            this.termino1 = "0";
        }
        operacion = "/";
        visor.setText("0");
    }

    public void porcentual(View v) {
        if (this.termino1 != null && this.termino2 != null && this.operacion != null) {
            float num2 = (Float.parseFloat(this.termino2)/100)*Float.parseFloat(this.termino1);
            this.termino2 = num2+"";
            visor.setText(this.termino2);
        } else {
            visor.setText("0");
            termino1 = null;
            termino2 = null;
            operacion = null;
            resultado = null;
        }
    }

    public void radicar(View v) {
        if (this.termino1 != null) {
            if (operacion == null && this.termino2 == null) {
                double num1 = Math.sqrt((Float.parseFloat(this.termino1)));
                this.termino1 = num1+"";
                visor.setText(this.termino1);
            }
            else {
                if(this.termino2 != null) {
                    if (this.resultado == null) {
                        double num2 = Math.sqrt((Float.parseFloat(this.termino2)));
                        this.termino2 = num2+"";
                        visor.setText(this.termino2);
                    } else if(this.resultado != null) {
                        double num2 = Math.sqrt((Float.parseFloat(this.resultado)));
                        this.termino2 = num2 + "";
                        this.resultado = this.termino2;
                        visor.setText(this.termino2);
                    }
                }
            }
        }
    }

    public void elevarCuadrado(View v) {
        if(operacion == null && this.termino1 != null) {
            float num1 = Float.parseFloat(this.termino1)*Float.parseFloat(this.termino1);
            this.termino1 = num1+"";
            visor.setText(this.termino1);
        } else if (this.termino2 != null) {
            float num2 = Float.parseFloat(this.termino2)*Float.parseFloat(this.termino2);
            this.termino2 = num2+"";
            visor.setText(this.termino2);
        }
    }

    public void invertir(View v) {
        if(operacion == null && this.termino1 != null) {
            float num1 = 1/Float.parseFloat(this.termino1);
            this.termino1 = num1+"";
            visor.setText(this.termino1);
        } else if (this.termino2 != null) {
            float num2 = 1/Float.parseFloat(this.termino2);
            this.termino2 = num2+"";
            visor.setText(this.termino2);
        } else {
            visor.setText("ERROR");
            this.termino2 = null;
        }
    }

    public void hacerSuma(float num1, float num2) {
        float res = num1+num2;
        this.resultado = res+"";
        visor.setText(resultado);
    }

    public void hacerResta(float num1, float num2) {
        float res = num1-num2;
        this.resultado = res+"";
        visor.setText(resultado);
    }

    public void hacerMultiplicacion(float num1, float num2) {
        float res = num1*num2;
        this.resultado = res+"";
        visor.setText(resultado);
    }

    public void hacerDivision(float num1, float num2) {
        if(num2 != 0) {
            float res = num1/num2;
            this.resultado = res+"";
            visor.setText(resultado);
        } else {
            visor.setText("ERROR");
        }
    }

    // Digitar Valores ------------
    public void digitarNumero(String num){
        if(visor.getText().toString().equals("0")) {
            visor.setText("");
        }
        if (operacion == null) {
            this.termino1 = visor.getText().toString() + num;
            visor.setText(termino1);
        } else {
            if(resultado == null) {
                this.termino2 = visor.getText().toString() + num;
                visor.setText(termino2);
            } else {
                this.termino1 = resultado;
                resultado = null;
                this.termino2 = visor.getText().toString() + num;
                visor.setText(termino2);
            }
        }
    }

    public void digitarComaDecimal(View v) {
        if(visor.getText().toString().equals("0")==false) {
            if(operacion == null) {
                String term = visor.getText().toString();
                if(term.contains(",")==false){
                    this.termino1 = term + COMA_DECIMAL;
                    visor.setText(this.termino1);
                }
            } else {
                String term = visor.getText().toString();
                if(term.contains(",")==false){
                    this.termino2 = term + COMA_DECIMAL;
                    visor.setText(this.termino2);
                }
            }
        }
    }

    public void digitarUno(View v){
        digitarNumero(NUM_1);
    }

    public void digitarDos(View v){
        digitarNumero(NUM_2);
    }

    public void digitarTres(View v){
        digitarNumero(NUM_3);
    }

    public void digitarCuatro(View v){
        digitarNumero(NUM_4);
    }

    public void digitarCinco(View v){
        digitarNumero(NUM_5);
    }

    public void digitarSeis(View v){
        digitarNumero(NUM_6);
    }

    public void digitarSiete(View v){
        digitarNumero(NUM_7);
    }

    public void digitarOcho(View v){
        digitarNumero(NUM_8);
    }

    public void digitarNueve(View v){
        digitarNumero(NUM_9);
    }

    public void digitarCero(View v){
        digitarNumero(NUM_0);
    }
}