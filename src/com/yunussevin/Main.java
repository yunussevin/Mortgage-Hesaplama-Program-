package com.yunussevin;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a = 0;
        double b = 0;
        int c = 0;

        Scanner anapara = new Scanner(System.in);
        while (true) {//While döngüsü ile girilebilecek sayıları 1000 ile 1 milyon arasında sınırlandırdık.
            System.out.print("Anaparayı Giriniz:");
            a = anapara.nextInt();
            if (a >= 1000 && a <= 1_000_000)
                break;
            System.out.println("Lütfen 1000 ile 1.000.000 arasında bir değer giriniz.");
        }

        Scanner ylfaiz = new Scanner(System.in);
        while (true) {
            System.out.print("Yıllık faiz oranını virgül kullanarak giriniz:");
            b = ylfaiz.nextDouble();
            if (b > 0 && b <= 10)
                break;
            System.out.println("Lütfen 0 ile 10 arasında bir değer giriniz.");
        }
        Scanner zaman = new Scanner(System.in);
        while (true) {
            System.out.print("Kaç yılda ödemek istiyorsunuz?:");
            c = zaman.nextInt();
            if (c >= 1 && c <= 30)
                break;
            System.out.println("Lütfen 1 ile 30 arasında bir değer giriniz.");
        }


        int aylodeme = (c * 12);//Kullanıcıdan aldığımız yıllık değeri 12 ile çarparak aylık değere çevirdik.
        double aylfaiz = (b / 12);//Kullanıcıdan aldığımız yıllık faiz değerini 12'ye bölerek aylık faiz oranını bulduk.
        double aylfaiz2 = (aylfaiz + 1);
        double aylfaiz3 = Math.pow(aylfaiz2, aylodeme);//Math.pow kullanarak aylfaiz2 değerinin üssünü aylodeme sayısıyla aldık.(Mortgage formülünün bir parçası.)
        double aylfaiz4 = (aylfaiz3 * aylfaiz);
        double aylfaiz5 = (aylfaiz3 - 1);
        double aylfaizson = (aylfaiz4 / aylfaiz5);
        double aylodemeson = (a * aylfaizson);
        String mortgage = NumberFormat.getCurrencyInstance().format(aylodemeson);//Burada double değerini NumberFormat ile okunabilir olması için para birimine dönüştürdük.
        System.out.println("Aylık ödeyeceğiniz tutar: " + mortgage);
    }
}
