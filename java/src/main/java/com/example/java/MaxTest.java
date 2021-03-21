    package com.example.java;

import java.util.Scanner;

public class MaxTest {


    public static void  Max()
    {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int tmp;
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if (a>b) {
                tmp = a;
                a = b;
                b = tmp;
            }
            if (a>c) {
                tmp = c;
                a = c;
                c = a;
            }
            if (b>c) {
                tmp = b;
                b = c;
                c = tmp;
            }

            System.out.println(" x = " + a + ", y = " + b + ", z = " + c);
        }
    }

    public static void GradeDisPlay() {

        Scanner sc = new Scanner(System.in);
        System.out.print("please input you num: ");
        int num = sc.nextInt();
        char display = num >= 90 ? 'A' : num >= 60 ? 'B' : 'C';
        System.out.println(display);
    }

    public static void countOf() {
        int abcCount = 0;
        int spaceCount = 0;
        int numCount = 0;
        int otherCount = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("input : ");
        String str = scan.nextLine();

        char[] a = str.toCharArray();
        for (char c : a) {
            //System.out.println(c);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                abcCount++;
            }
            else if (Character.isSpaceChar(c)) {
                spaceCount++;
                /*if(c == ' ') {
                    System.out.println("this is a space");
                }*/
            }
            else if (c >= '0' && c <= '9') {
                numCount++;
            }
            else {
                otherCount++;
            }


        }
        System.out.println("abcCount    " + abcCount);
        System.out.println("spaceCount  " + spaceCount);
        System.out.println("numCount    " + numCount);
        System.out.println("otherCount  " + otherCount);

    }


    public static void main(String[] args) {
        //Max();
        //GradeDisPlay();
        countOf();
    }
}