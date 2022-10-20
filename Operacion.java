package calcu;
public class Operacion implements Interfaz{
    @Override
    public float suma(float num1, float num2) {
        return num1+num2;
    }

    @Override
    public float resta(float num1, float num2) {
        return num1-num2;
    }

    @Override
    public float multi(float num1, float num2) {
        return num1*num2;
    }

    @Override
    public float div(float num1, float num2) {
        return num1/num2;
    }

    @Override
    public float potencia(float num, float potencia) {
        float result=num;
        for(int i=1; i<potencia; i++){
            result*=num;
        }
        return result;
    }

    @Override
    public float modulo(float num, float mod) {
        return num % mod;
    }
    
    
}
