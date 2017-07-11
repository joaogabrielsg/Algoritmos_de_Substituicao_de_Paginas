/**
 * Created by joaogabriel on 08/07/17.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class File {

    public static ArrayList<Reference> readFile(java.io.File file) {

        ArrayList<Reference> dataComplete = new ArrayList<> ();
        String value = "";

        try {
            FileInputStream stream = new FileInputStream(file);
            int data = stream.read();

            while(data != -1){
                if (data>=48 && data<=57){
                    while(data>=48 && data<=57){
                        value = value.concat(String.valueOf(data));
                        data = stream.read();
                    }
                    Integer page = Integer.valueOf(value);
                    String access = String.valueOf(data);
                    dataComplete.add(new Reference(page, access));
                    value = new String();
                }
                data = stream.read();
                data = stream.read();
            }

//            while (data != -1) {
//
//                data = inputstream.read();
//                dataComplete.add(String.valueOf(data));
//            }

            stream.close();
            
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return dataComplete;
    }
}
