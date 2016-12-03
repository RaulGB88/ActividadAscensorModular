/* 
 * Copyright 2016  - Raul Granel - raul.granel@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.app;

//Importación clase Scanner.
import java.util.Scanner;

/**
 *
 * @author - Raul Granel - raul.granel@gmail.com
 */
public class App {

    //Constantes.
    public static final int NUM_PERSONAS = 5;
    public static final char PISO_MIN = '0';
    public static final char PISO_MAX = '9';

    //Utilidad Scanner.
    private final Scanner scn = new Scanner(System.in, "ISO-8859-1");

    //Variables.
    //Variable número de personas que suben al ascensor.
    int persona = 0;
    //Variable piso que introduce una persona.
    char piso = 0;
    //Variable control fin del bucle para carácter correcto.
    boolean testOK = true;
    //Variable control fin de bucle para validar una planta correcta.
    boolean ascensorOK = true;

    public void lanzarAplicacion() {

        bucle();
    }

    private void bucle() {

        for (persona = 1; persona < NUM_PERSONAS; persona++) {
            validarPiso();
        }
    }

    private void validarPiso() {

        //Validar piso válido.
        do {
            validarChar();
            ascensorOK = !(piso >= PISO_MIN && piso <= PISO_MAX);
            if (ascensorOK) {
                System.out.println("Plantas 0...9");
            }
        } while (ascensorOK);
    }

    private void validarChar() {

        // Entrar PISO
        do {
            try {
                System.out.printf("Persona %d ---> ", persona);
                piso = scn.nextLine().charAt(0);
                testOK = false;
            } catch (Exception e) {
                System.out.println("Error entrada.");
            }
        } while (testOK);
    }

}
