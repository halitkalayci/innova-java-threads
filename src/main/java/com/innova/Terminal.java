package com.innova;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Terminal
{
  public static void main(String[] args) {
    System.out.println("**** Java ile terminal kodları yazma ****");

    List<String> commands = new ArrayList<>();
    commands.add("tesseract");
    commands.add("C:\\Users\\klyyc\\Downloads\\belirsiz-sureli-is-sozlesmesi-1.png");
    commands.add("cikti");

    try{
      ProcessBuilder processBuilder = new ProcessBuilder(commands);
      processBuilder.redirectErrorStream(true);

      Process process = processBuilder.start();

      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while((line = reader.readLine()) != null)
      {
        System.out.println(line);
      }

      int exitCode = process.waitFor();
      System.out.println("Process exit code: " + exitCode);

      File outputFile = new File("cikti.txt");
      if(outputFile.exists())
      {
        System.out.println("OCR başarılı çıktı dosyası:" + outputFile.getAbsolutePath());
      }else{
        System.out.println("OCR işlemi başarısız.");
      }
    }catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
