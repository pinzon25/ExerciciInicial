/*
Una cuenta corriente tiene un titular y un saldo.

Ademas cuenta con los metodos "ingresa" y "abona" que incrementan y decrementan el saldo respectivamente.

Nota importante: Debemos tener en cuenta el saldo a la hora de hacer un abono, 
si intentamos sacar una cantidad superior al saldo, el saldo
lanzara una excepcion de tipo illegalAccesException.
 */
package exerciciinicial;

import java.util.Scanner;

/**
 *
 * @author Riki
 */
public class CuentaCorriente {

    private String titular;
    private float saldo;

    private CuentaCorriente() {
        titular = "";
        saldo = 0;
    }

    public CuentaCorriente(String titular, float saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void ingresa(float cantidad) {
        this.saldo += cantidad;
    }

    public void abona(float cantidad) {
        if (cantidad > this.saldo) {
            throw new IllegalArgumentException("La cantidad introducida es mayor al saldo de la cuenta.");
        } else {
            this.saldo -= cantidad;
        }
    }

    @Override
    public String toString() {
        return "titular: " + titular + "\nsaldo: " + saldo;
    }

    public static void main(String[] args) {
        int opcion = 0;
        String titular = "";
        float saldo = 0, cantidad = 0;
        Scanner a = new Scanner(System.in);

        System.out.println("Introduce el nombre del titular de la cuenta: ");
        titular = a.nextLine();

        System.out.println("Introduce el saldo de la cuenta: ");
        saldo = a.nextFloat();
        System.out.println("\n\n");
        CuentaCorriente c = new CuentaCorriente(titular, saldo);

        do {
            System.out.println("Escoge que quieres hacer: \n1-Ingresar.\n\n2-Abonar.");
            opcion = a.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce la cantidad a ingresar: \n");
                    cantidad = a.nextFloat();
                    c.ingresa(cantidad);
                    a.nextLine();
                    System.out.println("\nCantidad ingresada correctamente.");
                    System.out.println(c.toString());
                    System.out.println("Saldo total: " + c.getSaldo());
                    System.out.println("\n\n");
                    cantidad = 0;
                    break;
                case 2:
                    System.out.println("Introduce la cantidad a extraer:\n");
                    cantidad = a.nextFloat();
                    c.abona(cantidad);
                    System.out.println("\nCantidad abonada correctamente.");
                    System.out.println(c.toString());
                    System.out.println("Saldo total: " + c.getSaldo());
                    System.out.println("\n\n");
                    break;
                default:
                    System.out.println("No has escogido una de las opciones disponibles.");
                    break;
            }
        } while (opcion == 1 | opcion == 2);
    }

}
