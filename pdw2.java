package U03EP02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class pdw2 {
    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);
        int elegir = 0;
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", so = System.getProperty("os.name");
        int modulo = alfabeto.length();
        char repetido1, repetido2;
        boolean comprobar = true;
        boolean comprobaralfabeto = true;
        String seguir;
        StringBuilder cifrado = new StringBuilder();
        String texto = "";
        int k = 0;
        boolean comk = true;
        String txtfilt = "";


        while (true) {
            elegir = 0;
            System.out.println("    CRIPTOGRAFIA CESAR");
            System.out.println("");
            System.out.println("1. Configurar.");
            System.out.println("2. Encriptar.");
            System.out.println("3. Desencriptar.");
            System.out.println("4. Salir.");

            System.out.println("Escoja una opcion (1-4): ");

            //Aseguramos que el valor que se introduce se encuentre entre las opciones.

            while (comprobar) {
                try {
                    elegir = sc.nextInt();
                    comprobar = false;
                } catch (InputMismatchException e) {
                    System.out.println("Escoja una opcion (1-4): ");
                    sc.next();
                }
                if (elegir > 4 || elegir < 1) {
                    System.out.println("Escoja una opcion (1-4): ");
                    comprobar = true;
                }

            }
            //En función de la elección, ocurre una cosa u otra.

            if (elegir == 1) {

                System.out.println("    CRIPTOGRAFIA CESAR-CONFIGURAR");
                System.out.printf("%n Alfabeto actual: \" %s \" ", alfabeto);
                System.out.printf("%n Modulo actual: %d", modulo);
                System.out.println("");
                System.out.println("Nuevo alfabeto (enter para no cambiar): ");

                sc.nextLine();
                alfabeto = sc.nextLine();

                //Testeamos que no se repita ninguna letra.
                comprobaralfabeto = true;
                while (comprobaralfabeto) {
                    for (int i = 0; i < alfabeto.length(); i++) {
                        repetido1 = alfabeto.charAt(i);

                        for (int o = i + 1; o < alfabeto.length(); o++) {
                            repetido2 = alfabeto.charAt(o);
                            if (repetido1 == (repetido2)) {
                                System.out.println("No puede tener letras repetidas.");
                                System.out.println("Nuevo alfabeto (enter para no cambiar): ");
                                alfabeto = sc.nextLine();
                            } else {
                                comprobaralfabeto = false;
                            }
                        }
                    }

                }

                modulo = alfabeto.length();
                System.out.printf("Modulo actual: %d", modulo);
                System.out.println("");
                System.out.println("Pulse ENTER para volver al menu principal.");
                try {
                    seguir = sc.nextLine();
                } catch (Exception err) {
                }
            }

            //Cifrado de código
            if (elegir == 2) {

                while (true) {
                    //Limpiamos la terminal.
                    if (so.equals("Windows 10")) {
                        try {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        } catch (Exception e) {
                           
                        }
                    } else {
                        
                        try {
                            new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
                        } catch (Exception e) {
                            
                        }
                    }

                    //Encriptar
                    String mensajeCifrado = "", textoEncriptar = "";
                    Integer codigo, codigoCifrado;
                    Character cifra;

                    //Mostramos el titulo del menu.
                    System.out.println("  CRIPTOGRAFIA CESAR-ENCRIPTAR");

                    
                    try {

                        while (k == 0 || k > (alfabeto.length() - 1) || k < 0) {

                            System.out.print("k (1-" + (alfabeto.length() - 1) + "): ");
                            k = sc.nextInt();

                        }

                        //Pedimos que nos diga el mensaje a encriptar.
                        while (textoEncriptar.equals("")) {
                            sc.nextLine();

                            System.out.print("Texto en claro: ");
                            textoEncriptar = sc.nextLine().toUpperCase();

                        }

                        //Filtramos el texto
                        for(int i = 0; i < textoEncriptar.length(); i++) {

                            
                            if(!alfabeto.contains("" + textoEncriptar.charAt(i) +"")) {

                                textoEncriptar = textoEncriptar.replace("" +textoEncriptar.charAt(i) + "", "");

                            }
                            
                            txtfilt = textoEncriptar;

                        }

                        for(int i = 0; i < txtfilt.length(); i++) {

                            //Codificar
                            codigo = alfabeto.indexOf(txtfilt.charAt(i));
                            
                            //Encriptar
                            codigoCifrado = Math.abs((codigo + k) % alfabeto.length());

                            //Decodificar
                            cifra = alfabeto.charAt(codigoCifrado);

                            mensajeCifrado += cifra;



                        }

                        System.out.println("  Texto filtrado: " + txtfilt);
                        System.out.print("  Texto cifrado: " + mensajeCifrado);
                        System.out.print("%n %n  Pulse ENTER para volver al menu");
                        sc.nextLine();
                        break;

                    } catch (InputMismatchException e) {

                        
                        sc.nextLine();

                    }
                }
            }

            if (elegir == 3) {

                while (true) {
                    
                    if (so.equals("Windows 10")) {
                        try {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        } catch (Exception e) {
                           
                        }
                    } else {
                        
                        try {
                            new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
                        } catch (Exception e) {
                            
                        }
                    }
                    String mensajeClaro = "", textoEncriptar = "";
                    Integer codigo, codigoDescifrado;
                    Character txt;
                    System.out.println("  CRIPTOGRAFIA CESAR-DESENCRIPTAR");
                    try {

                        while (k == 0 || k > (alfabeto.length() - 1) || k < 0) {

                            System.out.print("k (1-" + (alfabeto.length() - 1) + "): ");
                            k = sc.nextInt();

                        }
                        while (textoEncriptar.equals("")) {
                            sc.nextLine();

                            System.out.print("Texto cifrado: ");
                            textoEncriptar = sc.nextLine().toUpperCase();

                        }

                        for(int i = 0; i < textoEncriptar.length(); i++) {

                            
                            if(!alfabeto.contains("" + textoEncriptar.charAt(i) +"")) {

                                textoEncriptar = textoEncriptar.replace("" +textoEncriptar.charAt(i) + "", "");

                            }
                            
                            txtfilt = textoEncriptar;

                        }

                        for(int i = 0; i < txtfilt.length(); i++) {
                            codigo = alfabeto.indexOf(txtfilt.charAt(i));
                            codigoDescifrado = Math.abs((codigo - k) % alfabeto.length());
                            txt = alfabeto.charAt(codigoDescifrado);

                            mensajeClaro += txt;



                        }
                        System.out.println("  Cifra filtrada: " + txtfilt);
                        System.out.print("  Texto en claro: " + mensajeClaro);
                        System.out.print("%n %n  Pulse ENTER para volver al menu");
                        sc.nextLine();
                        break;

                    } catch (InputMismatchException e) {
                        sc.nextLine();
                        System.out.print("  ERROR: La k es un numero entero, pulse ENTER para introducir de nuevo otro valor.");

                        sc.nextLine();

                    }
                }

            }

            if (elegir == 4) {
                System.out.println("");
                System.exit(0);
            }
            comprobar = true;
        }

    }

    
}
