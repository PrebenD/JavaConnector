package com.linknordic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;





public class App 
{
    public static void main( String[] args ) throws IOException
    {
        try {
            File infile = new File("C:\\Users\\prebe\\Google Drive\\LINK\\JavaConnector\\src\\main\\resources\\TestJson.json");
            InputStream inputStream = new FileInputStream(infile);
            File outfile = new File("C:\\Users\\prebe\\Google Drive\\LINK\\JavaConnector\\src\\main\\resources\\TestJson.xml");
            OutputStream outputStream = new FileOutputStream(outfile);
            JavaFilter jf = new JavaFilter();
            jf.invoke(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
