package Comp_Decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompression_Operation {

    private static String name;

    public static void File_Read(File file) throws IOException {



        String filePathDirectory = file.getParent();

        FileInputStream read_File = new FileInputStream(file);
        GZIPInputStream write_File = new GZIPInputStream(read_File);
        FileOutputStream decomp_file = new FileOutputStream(filePathDirectory +"/"+file.getName()+"_decomp");

        name = file.getName();

        byte [] data = new byte[1024];
        int len;

        while((len = write_File.read(data)) == -1){
            decomp_file.write(data,0,len);
        }
        read_File.close();
        write_File.close();
        decomp_file.close();
    }

    public static void main(String[] args) throws IOException {
        File path = new File("Users/VIJAY/Desktop/first/"+name+"_Decomp");
        File_Read(path);
    }



}
