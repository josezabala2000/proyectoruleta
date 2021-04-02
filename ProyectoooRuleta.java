package ProyectoRuleta;
import java.util.Random;
import java.util.Scanner;


public class ProyectoRuleta {
   
    public static void main(String[] args) {
        
        Scanner ingresa = new Scanner(System.in);
        Random al = new Random(); 
        
        boolean colorp[] = {true, true, false, true, false, true, false,
            true, false, true, false, false, true, false, true, false,
            true, false, true, true, false, true, false, true, false, true,
            false, true, false, false, true, false, true, false, true,
            false, true};

        int menu = 0, Aleatorio;
        int cantidadJ;
        int apuestaJugador, fichasA;
        int fichasG = 0; 
        boolean jugar = true;
        boolean valido = true;
        boolean parImpar = false;
        boolean validoEspecial = true;
        String apuesta;
        String desicion;
        String girar; //permite que al usuario ponga a girar la balota

        boolean retiro = true;
        int condicion, k = 0, jugadorSalir;

        System.out.println("Bienvenido al juego de Ruleta!");
        System.out.print("Cuantos jugadores van a apostar: ");
        cantidadJ = ingresa.nextInt();


        int jugadores[] = new int[cantidadJ];
        int cantidadA[] = new int[cantidadJ];
        int apuestasJ[] = new int[cantidadJ];
        
        for (int i = 0; i < cantidadJ; i++) {
            jugadores[i] = 20;
        }
        String datosJugadores[] = new String[cantidadJ]; 
        for (int i = 0; i < cantidadJ; i++) {
            System.out.print("Escriba el nombre del jugador #" + (i + 1) + ": ");
            datosJugadores[i] = ingresa.next();
        }

        while (jugar) {
            for (int i = 0; i < cantidadJ; i++) {

                 valido = true;

                while (valido) {

                    System.out.println("Turno del Jugador " + (i + 1) + " - " + (datosJugadores[i]));
                    System.out.print("Menu de apuestas permitidas por nuestro casino: \n"
                            + "1. Apuesta a un solo numero entre 1 - 36.\n"              
                            + "2. Apuesta por colores rojo o negro.\n"
                            + "3. Apuesta por numeros pares o impares. \n"
                            + "4. Apuesta a numeros bajos entre 1 a 18. \n"
                            + "5. Apuesta a numeros altos entre 19 a 36. \n"
                            + "6. Apuestas a varios numeros entre 1-36"
                            + "Por favor digite el numero de la opcion que desea: ");
                    menu = ingresa.nextInt();
        
                    
                     switch (menu) {
                        case 1:
                            System.out.println("Apuesta a un solo numero");

                            System.out.print("Que numero prefiere para elegir: ");                            
                            apuestaJugador = ingresa.nextInt();
                            apuestasJ[i] = apuestaJugador;
                            valido = false;
                            break;

                        case 2:
                            System.out.println("Apuesta por color: rojo o negro.");

                            while(validoEspecial){
                                System.out.print("Coloque la letra 'R' si desea apostarle al rojo o la letra 'N' si es al negro ");
                                apuesta = ingresa.next();
                                if (apuesta.equalsIgnoreCase("R")) {
                                    apuestasJ[i] = 37;
                                    break;
                                } 
                                else if (apuesta.equalsIgnoreCase("N")) {
                                    apuestasJ[i] = 38;
                                    break;
                                } 
                                else{
                                    System.out.println("Error en la eleccion del color, coloque 'R' o 'N'");
                                    validoEspecial = true;
                                }
                            }
                            valido = false;
                            break;

                        case 3:
                            System.out.println("Apuesta de numeros pares o impares.");

                            while(validoEspecial){
                                System.out.print("Coloque la letra 'P' si desea apostarle a un numero par o la letra 'I' si es a uno impar");
                                
                                apuesta = ingresa.next();
                                
                                if (apuesta.equalsIgnoreCase("P")) {
                                    apuestasJ[i] = 39;
                                    break;
                                } 
                                else if (apuesta.equalsIgnoreCase("I")) {
                                    apuestasJ[i] = 40;
                                    break;
                                }
                                else{
                                    System.out.println("Esta opcion no exite, Elija 'P' o 'I' ");
                                    validoEspecial = true;
                                }
                            }
                            valido = false;
                            break;

                        case 4:
                            System.out.println("Apuesta de numeros entre 1 a 18.");
                            apuestasJ[i] = 41;
                            valido = false;
                            break;

                        case 5:
                            System.out.println("Apuesta de numeros entre 19 a 36.");                           
                            apuestasJ[i] = 42;
                            valido = false;
                            break;

                        case 6:
                            System.out.println("Apuesta a varios numeros");
                            
                            while (validoEspecial){
                                System.out.print("ingrese un numero a apostar");
                                apuestaJugador= ingresa.nextInt();
                                apuestasJ[i] = apuestaJugador;
                                System.out.print("desea ingresar otro numero a la apuesta?");
                                desicion = ingresa.next();
                                if (desicion.equalsIgnoreCase("S")) {
                                    System.out.print("Ingresa otra apuesta");
                                    validoEspecial=true;
                                }
                                else if (desicion.equalsIgnoreCase("N")){
                                    valido = false;
                                    break;                                    
                                }
                            }

                        default:
                            System.out.println("No Existe La Opcion Seleccionada. Escoja una opcion de las que se encuentran dentro del menu");           
                            valido = true;
                            break;
                    }
                }
                   
                valido = true;               
                while (valido) {
                    System.out.print("Cuantas fichas desea apostarle a este numero: ");
                    fichasA = ingresa.nextInt();

                    if (fichasA > 0 && fichasA < 11 && fichasA <= jugadores[i]) {
                        cantidadA[i] = fichasA;
                        break;
                    } 
                    else {                        
                        System.out.println("El jugador posee " + jugadores[i] + " fichas.");
                        System.out.println("El rango limite de apuestas es de 1 a 10 fichas.");
                       
                        valido = true;
                    }

                }

            }
            Aleatorio = (int) (al.nextDouble() * 36 + 1);
            parImpar = (Aleatorio % 2 == 0);

            System.out.println("\nApuestas del Casino!");
            
            for (int i = 0; i < cantidadJ; i++) {

                if (apuestasJ[i] >= 0 && apuestasJ[i] <= 36) {
                    System.out.print("El Jugador " + (i + 1) + " - " + (datosJugadores[i]) );
                    System.out.print("Aposto " + (cantidadA[i]) + " fichas, al numero: " + (apuestasJ[i]));
                } 
                else if (apuestasJ[i] == 37) {
                    System.out.print("El Jugador " + (i + 1) + " - " + (datosJugadores[i]));
                    System.out.print("Aposto " + (cantidadA[i]) + " fichas, al color ROJO.");
                } 
                else if (apuestasJ[i] == 38) {
                    System.out.print("El Jugador " + (i + 1) + " - " + (datosJugadores[i]));
                    System.out.print("Aposto " + (cantidadA[i]) + " fichas, al color NEGRO");
                } 
                else if (apuestasJ[i] == 39) {
                    System.out.print("El Jugador " + (i + 1) + " - " + (datosJugadores[i]));
                    System.out.print("Aposto " + (cantidadA[i]) + " fichas, a los numeros PARES.");
                } 
                else if (apuestasJ[i] == 40) {
                    System.out.print("El Jugador " + (i + 1) + " - " + (datosJugadores[i]) + ".\n");
                    System.out.print("Aposto " + (cantidadA[i]) + " fichas, a los numeros IMPARES.");
                } 
                else if (apuestasJ[i] == 41) {
                    System.out.print("El Jugador " + (i + 1) + " - " + (datosJugadores[i]) + ".\n");
                    System.out.print("Aposto " + (cantidadA[i]) + " fichas, a un numero entre 1 y 18.");
                } 
                else if (apuestasJ[i] == 42) {
                    System.out.print("El Jugador " + (i + 1) + " - " + (datosJugadores[i]) + ".\n");
                    System.out.print("Aposto " + (cantidadA[i]) + " fichas, a un numero entre 19 y 36.");
                } 
                 else if (apuestasJ[i] >= 0 && apuestasJ[i] <= 36) {
                    System.out.print("El Jugador " + (i + 1) + " - " + (datosJugadores[i]) + ".");
                    System.out.print("Aposto " + (cantidadA[i]) + " fichas, a varios numeros");
                }

            }

            System.out.print("Coloque la letra 'G' para girar la ruleta ");
            girar = ingresa.next();
            if (girar.equalsIgnoreCase("G")) {
                System.out.println("Girar la Ruleta");
                String color = Aleatorio == 0 ? "VERDE" : (colorp[Aleatorio] ? "ROJO" : "NEGRO");
            
                System.out.println("Y el numero ganador es: " + color + " " + Aleatorio);
            }
            for (int i = 0; i < cantidadJ; i++) {
                boolean gano = false;

                if (apuestasJ[i] >= 0 && apuestasJ[i] <= 36) {                    
                    if (apuestasJ[i] == Aleatorio) {                        
                        fichasG = cantidadA[i] * 36;                       
                        jugadores[i] = jugadores[i] + fichasG;                       
                        gano = true;
                    }
                } 
                else if (apuestasJ[i] == 37 && Aleatorio != 0) {                    
                    if (colorp[Aleatorio]) {                       
                        fichasG = cantidadA[i] * 2;                        
                        jugadores[i] = jugadores[i] + fichasG;
                        gano = true;
                    }
                } 
                else if (apuestasJ[i] == 38 && Aleatorio != 0) {
                    if (!colorp[Aleatorio]) {  
                        fichasG = cantidadA[i] * 2;
                        jugadores[i] = jugadores[i] + fichasG;
                        gano = true;
                    }
                }
                else if (apuestasJ[i] == 39 && Aleatorio != 0) {                    
                    if (parImpar) {                    
                        fichasG = cantidadA[i] * 2;                        
                        jugadores[i] = jugadores[i] + fichasG;
                        gano = true;
                    }
                } 
                else if (apuestasJ[i] == 40 && Aleatorio != 0) {                   
                    if (!parImpar) {                    
                        fichasG = cantidadA[i] * 2;                        
                        jugadores[i] = jugadores[i] + fichasG;                        
                        gano = true;
                    }
                } 
                else if (apuestasJ[i] == 41 && Aleatorio != 0) {
                    if (apuestasJ[i] >= 1 && apuestasJ[i] <= 18) {
                        fichasG = cantidadA[i] * 2;
                        jugadores[i] = jugadores[i] + fichasG;
                        gano = true;
                    }
                } 
                else if (apuestasJ[i] == 42 && Aleatorio != 0) {                   
                    if (apuestasJ[i] >= 19 && apuestasJ[i] <= 36) {                       
                        fichasG = cantidadA[i] * 2;                        
                        jugadores[i] = jugadores[i] + fichasG;                        
                        gano = true;
                    }
                } 


//                FASE IMPRIMIR RESULTADOS

             if (gano) {
                    System.out.println("----------- CASINOO -----------------");
                    System.out.println("Jugador " + datosJugadores[i]);
                    System.out.println("Usted ha ganado: " + fichasG + " fichas.");
                    System.out.println("Y quedo con: " + jugadores[i] + " fichas.");
                } 
                else {
                    System.out.println("----------- CASINOO -----------------");
                    System.out.println("Jugador " + datosJugadores[i]);
                    System.out.println("Usted ha perdido: " + cantidadA[i] + " fichas.");
                    jugadores[i] = jugadores[i] - cantidadA[i];
                    System.out.println("Y quedo con: " + jugadores[i] + " fichas.");
                }

            }

//            FASE DE ELIMINACION
            while (retiro) {

                if (cantidadJ > 0) {
                    System.out.print("algun jugador quiere retirarse del juego? de ser asi coloque '0' "
                            + "si no coloque '1': ");
                    condicion = ingresa.nextInt();
                    if (condicion == 0) {
                        for (int i = 0; i < cantidadJ; i++) {

                            System.out.print("El Jugador " + (i) + ", es " + datosJugadores[i] + ": ");
                        }
                        System.out.print("que jugador se desea retirar, (coloque el numero al que corresponde) ");
                        jugadorSalir = ingresa.nextInt();                        
                        if(jugadorSalir < 0 || jugadorSalir > jugadores.length - 1){
                            System.out.println("Este jugador no existe");
                        }
                        else{
                            int[] jugadoresTemporal = new int[jugadores.length - 1];
                            k = 0;                             
                            for (int j = 0; j < jugadores.length; j++) {
                                if (j != jugadorSalir) {
                                    jugadoresTemporal[k] = jugadores[j];
                                    k++;
                                }
                            }
                            String[] nombresJugadoresTemporal = new String[datosJugadores.length - 1];
                            k = 0;                             
                            for (int j = 0; j < jugadores.length; j++) {
                                if (j != jugadorSalir) {
                                    nombresJugadoresTemporal[k] = datosJugadores[j];
                                    k++;
                                }
                            }
                            for (int i = 0; i < cantidadJ; i++) {

                                if (jugadorSalir == i) {
                                    System.out.println("el jugador se ha salido");
                                    System.out.println("El jugador: " + datosJugadores[i]);
                                    System.out.println("Inicio con 20 fichas.");
                                    System.out.println("Y se retiro con " + jugadores[i] + " fichas.");
                                }
                            }                            
                            datosJugadores = nombresJugadoresTemporal;
                            jugadores = jugadoresTemporal;
                            cantidadJ = jugadores.length;
                            retiro = true;
                            }
                        } 
                    else {
                            break;
                        }
                    } 
                else {
                        System.out.print("Estas apuestas han finalizado");
                        retiro = false;
                        System.exit(0); 
                    }
            }
        }
    }
}
   
                
                
                
        
    
                
                

