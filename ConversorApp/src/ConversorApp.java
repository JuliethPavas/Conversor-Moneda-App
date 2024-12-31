import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Conversor conversor = new Conversor();
        boolean continuar = true;
        String menu = """
                ***********************************************
                
                ¡Bienvenid@ al conversor de monedas!
                
                Selecciona una de las sigueintes opcines:
                1) Dólar =>> Peso Argentino.
                2) Peso Argentino =>> Dólar.
                3) Dólar =>> Real Brasileño.
                4) Real Brasileño =>> Dólar.
                5) Dólar =>> Peso Colombiano.
                6) Peso Colombiano. =>> Dólar.
                7) Divisa Distinta.
                8) Salir.
                
                ***********************************************
                """;
        String subMenu = """
                ***********************************************
                
                ¿Desea realizar otra consulta?
                1. Sí (Volver al menú)
                2. No (Cerrar programa)
                
                ***********************************************
                """;

        while (continuar) {
            try {
                System.out.println(menu);

                int opcion = lectura.nextInt();

                if (opcion == 8) {
                    System.out.println("Gracias por usar nuestro conversor.");
                    continuar = false;
                    break;
                }

                String origen = "";
                String destino = "";
                double cant = 0;

                switch (opcion) {
                    case 1:
                        origen = "USD";
                        destino = "ARS";
                        System.out.print("Digite la cantidad en Dólar: ");
                        cant = lectura.nextDouble();
                        break;
                    case 2:
                        origen = "ARS";
                        destino = "USD";
                        System.out.print("Digite la cantidad en Peso Argentino: ");
                        cant = lectura.nextDouble();
                        break;
                    case 3:
                        origen = "USD";
                        destino = "BRL";
                        System.out.print("Digite la cantidad en Dólar: ");
                        cant = lectura.nextDouble();
                        break;
                    case 4:
                        origen = "BRL";
                        destino = "USD";
                        System.out.print("Digite la cantidad en Real Brasileño: ");
                        cant = lectura.nextDouble();
                        break;
                    case 5:
                        origen = "USD";
                        destino = "COP";
                        System.out.print("Digite la cantidad en Dólar: ");
                        cant = lectura.nextDouble();
                        break;
                    case 6:
                        origen = "COP";
                        destino = "USD";
                        System.out.print("Digite la cantidad en Peso Colombiano: ");
                        cant = lectura.nextDouble();
                        break;
                    case 7:
                        System.out.print("Digite la sigla de la divisa de origen (ej. USD): ");
                        origen = lectura.next();
                        System.out.print("Digite la sigla de la divisa de destino (ej. COP): ");
                        destino = lectura.next();
                        System.out.print("Digite la cantidad en " + origen + ": ");
                        cant = lectura.nextDouble();
                        break;
                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                        continue;
                }

                {
                    Moneda moneda = conversor.convertirPar(origen, destino, cant);
                    System.out.println(moneda.toString());
                    System.out.println(subMenu);
                    int continuarOpcion = lectura.nextInt();
                    if (continuarOpcion == 2) {
                        System.out.println("Gracias por usar nuestro conversor. ¡Hasta pronto!");
                        continuar = false;
                    }


                }
            } catch (InputMismatchException e){
                System.out.println("Solo se permiten números para las opciones.");
                lectura.nextLine();
            }
        }
        lectura.close();
    }
}