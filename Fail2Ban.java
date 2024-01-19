/* Liang Yang
 * ly2522
 * list of IP addresses that have failed 3 or more times
 */

import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class Fail2Ban{
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("Wrong Input!!!");
            return;
        }

        String logFile = args[0];
        String outputFile = args[1];

        HashMap<String, Integer> fail = new HashMap<>();

        try(BufferedReader r = new BufferedReader(new FileReader(logFile))){
            String i;
            while((i = r.readLine()) != null){
                if(i.contains("Invalid")){
                    String[] split = i.split(" ");
                    // Assuming IP is always at the same position
                    String ip = split[9];
                    fail.put(ip, fail.getOrDefault(ip, 0)+1);
                }
            }
            
            // write result to the output file
            try(PrintWriter w = new PrintWriter(new FileWriter(outputFile))){
                for(Map.Entry<String, Integer> e : fail.entrySet()){
                    if(e.getValue() >= 3){
                        w.println(e.getKey());
                    }
                }
            }
        }catch(IOException ioe){
            System.err.println("Wrong input/output");
        }

    }
}

