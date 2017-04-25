package com.sdajava.jdbcSingleton;

import java.util.Scanner;

/**
 * Created by Andrzej on 25.04.2017.
 */
public class GUI {



    public static void menuFunctions() {

        //BooksList booksList = new BooksList();

        System.out.println("Menu: \n\n" +
                "1.Lista \n" +
                "2.Dodaj ksiazke \n" +
                "3.Update ksiazki \n" +
                "4.Usuniecie ksiazki \n" +
                "5.Zakoncaenie programu"
        );

        boolean menuFlag = true;
        Scanner menuScanner = new Scanner(System.in);



        while (menuFlag) {
        int menuOptions = menuScanner.nextInt();

            switch (menuOptions) {
                case 1:
                    BooksList.showBooksList();
                    GUI.menuFunctions();
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    menuFlag = false;
                    break;
                default:
                    System.out.println("\n\nPodales niepoprawny numer");
                    menuFlag = true;
            }
        }
    }
}
