/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Shrenik
 */
public class Compress {
    public static void compressFunction(File file) throws FileNotFoundException, IOException{
       String fileDirectory = file.getParent();
       System.out.println(fileDirectory);
       FileInputStream fis = new FileInputStream(file);
       FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.gz");
       GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
       
       byte[]buffer = new byte[1024];
       int len;
       
       while((len=fis.read(buffer))!=-1){
           gzipOS.write(buffer, 0, len);
       }
       gzipOS.close();
       fos.close();
       fis.close();
    }
   public static void main(String[]args) throws FileNotFoundException, IOException{
      File path = new File("C:\\Users\\Shrenik\\Documents\\NetBeansProjects\\CompressDecompressProject\\src\\ProjectOneDemoFile.txt");
      compressFunction(path);
   } 
}
