import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter k value: ");
        int k = scanner.nextInt();

        if (k % 2 != 0) {
            System.out.println("Please input even k value");
            System.exit(0);
        }


        System.out.println("Number of PODs: " + k);
        System.out.println("Total number of aggregation switches: " + (k * k) / 2);
        System.out.println("Total number of edge switches " + (k * k) / 2);
        System.out.println("Total number of core switches " + ((k / 2) * (k / 2)));
        System.out.println("Total number of PMs " + (k * k * k) / 4);

        System.out.println();

        System.out.print("Printing out the uniform PIDs: ");
        System.out.println();

        //for loop to print the uniform PID's

        for (int i = (((k * k) / 2) + ((k * k) / 2) + (k * k * k) / 4) + 1; i <= (((k * k) / 4) + ((k * k) / 2) + ((k * k) / 2) + ((k * k * k) / 4)); i++) {
            System.out.print(i + "\t");
        }
        System.out.print(": Core");
        System.out.println();

        for (int i = ((k * k / 2) + (k * k * k) / 4); i <= ((k * k / 2) + ((k * k / 2) + (k * k * k) / 4)) - 1; i++) {
            System.out.print(i + "\t");
        }
        System.out.print(": Aggregation");
        System.out.println();

        for (int i = ((k * k * k) / 4); i <= ((k * k / 2) + (k * k * k) / 4) - 1; i++) {
            System.out.print(i + "\t");
        }
        System.out.print(": Edge");
        System.out.println();

        for (int i = 0; i <= ((k * k * k) / 4) - 1; i++) {
            System.out.print(i + "\t");
        }
        System.out.print(": PM");
        System.out.println();
        System.out.println();

        for (int i = 1; i <= k; i++) {
            System.out.print(i + "\t");
        }
        System.out.print(": POD");
        System.out.println();

        System.out.println();

        //Task 2: To compute the distance between 2 PID's

        System.out.print("Compute distance between 2 PID's: ");
        System.out.println();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter first PID: ");
        int n1 = scanner2.nextInt();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Please enter second PID: ");
        int n2 = scanner3.nextInt();

        if (n1 == n2) {
            System.out.println("Same PID, Distance is 0");
        }

//PM and PM: under
        if (n1 >= 0 && n1 <= (k * k * k) / 4 && n2 >= 0 && n2 <= ((k * k * k) / 4) - 1) {

            if ((n1 / k) < 1 && (n2 / k) < 1) {
                int P1 = n1 / ((k * k) / 4);
                int P2 = n2 / ((k * k) / 4);

                if (P1 != P2) {
                    System.out.println("Distance is 6");
                } else if (P1 == P2 && n1 / (k / 2) == n2 / (k / 2)) {

                    System.out.println("Distance is 2");
                } else {
                    System.out.println("Distance is 4");

                }
            }

            if (n1 / k >= 1 && n1 / k < 2 && n2 / k >= 1 && n2 / k < 2) {
                int P1 = (k * 2) - n1;
                int P2 = (k * 2) - n1;

                if (P1 != P2) {
                    System.out.println("Distance is 6");
                } else if (P1 == P2 && n1 / (k / 2) == n2 / (k / 2)) {

                    System.out.println("Distance is 2");
                } else {
                    System.out.println("Distance is 4");

                }

            }

            if (n1 / k >= 2 && n1 / k < 3 && n2 / k >= 2 && n2 / k < 3) {
                int P1 = (k * 2) - n1;
                int P2 = (k * 2) - n1;

                if (P1 != P2) {
                    System.out.println("Distance is 6");
                } else if (P1 == P2 && n1 / (k / 2) == n2 / (k / 2)) {

                    System.out.println("Distance is 2");
                } else {
                    System.out.println("Distance is 4");

                }

            }

            if (n1 / k >= 3 && n1 / k < 4 && n2 / k >= 3 && n2 / k < 4) {
                int P1 = (k * 2) - n1;
                int P2 = (k * 2) - n1;

                if (P1 != P2) {
                    System.out.println("Distance is 6");
                } else if (P1 == P2 && n1 / (k / 2) == n2 / (k / 2)) {

                    System.out.println("Distance is 2");
                } else {
                    System.out.println("Distance is 4");

                }

            }




        }
        //PID to core
        if (n1 >= 0 && n1 <= (k * k * k) / 4 && n2 >= (((k * k) / 2) + ((k * k) / 2) + (k * k * k) / 4) + 1 && n2 <= (((k * k) / 4) + ((k * k) / 2) + ((k * k) / 2) + ((k * k * k) / 4))) {
            System.out.println("PM to Core: Distance is 3");
        }

        //agg to core
        if (n1 >= ((k * k / 2) + (k * k * k) / 4) && n1 <= ((k * k / 2) + ((k * k / 2) + (k * k * k) / 4)) - 1 && n2 >= (((k * k) / 2) + ((k * k) / 2) + (k * k * k) / 4) + 1 && n2 <= (((k * k) / 4) + ((k * k) / 2) + ((k * k) / 2) + ((k * k * k) / 4))) {
            System.out.println("Aggregation to Core: Distance is 1");


        }

        //PM and edge

        if (n1 >= 0 && n1 <= (k * k * k) / 4 && n2 >= ((k * k * k) / 4) && n2 <= ((k * k / 2) + (k * k * k) / 4) - 1) {


                int P1 = n1 / ((k*k)  / 4);
                int P2 = (n2 - (((k * k * k) / 4))) / (k / 2);


                if (P1 != P2) {
                    System.out.println("Distance is 3");
                } else if (P1 == P2 && n1 / (k / 2) == (n2 - (((k * k * k) / 4))) / (k / 2)) {

                    System.out.println("PM and edge : Same edge switch -- Distance is 1");
                } else {
                    System.out.println("Distance is 3");

                }
            }

        //edge and agg

        if (n1 >= ((k * k * k) / 4) && n1 <= ((k * k / 2) + (k * k * k) / 4) - 1 && n2 >= ((k * k / 2) + (k * k * k) / 4) && n2 <= (((k * k / 2) + ((k * k / 2) + (k * k * k) / 4)) - 1)) {


            int P1 = (n1 - (((k * k * k) / 4))) / (k / 2);
            int P2 = (n2 - ((k * k / 2) + (k * k * k) / 4)) / (k / 2);


            if (P1 != P2) {
                System.out.println("Distance is 3");
            } else if (P1 == P2) {

                System.out.println("edge and agg : Same POD-- Distance is 2");
            }

            }

        //PM and agg

        if (n1 >= 0 && n1 <= (k * k * k) / 4 && n2 >= ((k * k / 2) + (k * k * k) / 4) && n2 <= ((k * k / 2) + ((k * k / 2) + (k * k * k) / 4)) - 1){


            int P1 = n1 / ((k*k)  / 4);
            int P2 = ((n2 - ((k * k / 2) + (k * k * k) / 4) )  / (k / 2));


            if (P1 != P2) {
                System.out.println("PM and aggregation - different POD :Distance is 4");
            } else if (P1 == P2){

                System.out.println("PM and aggregation : Same POD -- Distance is 2");


            }
        }

        //2 edge
        if (n1 >= ((k * k * k) / 4) && n1 <= ((k * k / 2) + (k * k * k) / 4) - 1 && n2 >= ((k * k * k) / 4) && n2 <= ((k * k / 2) + (k * k * k) / 4) - 1) {


            int P1 = (n1 - (((k * k * k) / 4))) / (k / 2);
            int P2 = (n2 - (((k * k * k) / 4))) / (k / 2);


            if (P1 != P2) {
                System.out.println("edge abd edge: Different POD -- Distance is 3");
            } else if (P1 == P2) {

                System.out.println("edge and edge : Same POD -- Distance is 2");
            }

            }

        //2 edge
        if (n1 >= ((k * k / 2) + (k * k * k) / 4) && n1 <= ((k * k / 2) + ((k * k / 2) + (k * k * k) / 4)) - 1&& n2 >= ((k * k / 2) + (k * k * k) / 4) && n2 <= ((k * k / 2) + ((k * k / 2) + (k * k * k) / 4)) - 1) {


            int P1 = (n1 - ((k * k / 2) + (k * k * k) / 4)) / (k / 2);
            int P2 = (n2 - ((k * k / 2) + (k * k * k) / 4)) / (k / 2);


            if (P1 != P2) {
                System.out.println("aggregate abd aggregate: Different POD -- Distance is 24");
            } else if (P1 == P2) {

                System.out.println("aggregate and aggregate : Same POD -- Distance is 2");
            }

        }
        }
        }


