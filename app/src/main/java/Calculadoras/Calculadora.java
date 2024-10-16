package Calculadoras;

public  class Calculadora {
    private Double operando1;
    private Double operando2;
    private String operador;

    public void setOperando1(Double operando1) {
        this.operando1 = operando1;
    }

    public void setOperando2(Double operando2) {
        this.operando2 = operando2;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public double calcularResultado() {
        double resultado = 0;
        switch (operador) {
            case "+":
                resultado = operando1 + operando2;
                break;
            case "-":
                resultado = operando1 - operando2;
                break;
            case "*":
                resultado = operando1 * operando2;
                break;
            case "/":
                if (operando2 != 0) {
                    resultado = operando1 / operando2;
                } else {
                    throw new ArithmeticException("No se puede dividir por cero");
                }
                break;
        }
        return resultado;
    }

    public void reset() {
        operando1 = null;
        operando2 = null;
        operador = null;
    }
}

