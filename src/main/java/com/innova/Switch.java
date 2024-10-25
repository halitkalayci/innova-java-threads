package com.innova;

public class Switch {
  public static void main(String[] args) {
    System.out.println("**** Switch Expressions ****");
    int day=2;
    String dayName;
    switch(day)
    {
      case 1:
        dayName = "Pazartesi";
        break;
      case 2:
        dayName = "Salı";
        break;
      default:
        dayName = "Bilinmedik";
    }
    System.out.println("Dayname:" + dayName);
    System.out.println("********************");
    day = 5;
    String dayName2 = switch (day) {
      case 1 -> "Pazartesi";
      case 2 -> "Salı";
      case 3 -> throw new RuntimeException();
      default -> {
       System.out.println("Custom işlem yapılıyor....");
       yield "Bilinmedik gün";
      }
    };
    System.out.println("Dayname:" + dayName2);
  }
}
