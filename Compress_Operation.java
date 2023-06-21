package Comp_Decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compress_Operation {

    private static String name;


    public static void File_Read(File file) throws IOException {


        String filePathDirectory = file.getParent();

        FileInputStream read_File = new FileInputStream(file);
        FileOutputStream write_File = new FileOutputStream(filePathDirectory + "/"+file.getName()+ "_Comp.gz");
        GZIPOutputStream comp_File = new GZIPOutputStream(write_File);

        name = file.getName();

        byte[] data = new byte[1024];
        int len;

        while((len = read_File.read(data)) != -1){
            comp_File.write(data,0,len);

        }

        read_File.close();
        write_File.close();
        comp_File.close();

    }

    public static void main(String[] args) throws IOException{
        File path = new File("Users/VIJAY/Desktop/first/"+name+"_Comp.gz");
        File_Read(path);
    }

}
