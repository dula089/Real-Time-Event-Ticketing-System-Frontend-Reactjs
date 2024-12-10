import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static final String LOG_FILE="system.log";

    public static void log(String message){
        String timestamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logMessage=timestamp+" - "+message;
        System.out.println(logMessage);

        try(BufferedWriter writer=new BufferedWriter(new FileWriter(LOG_FILE,true))){
            writer.write(logMessage);
            writer.newLine();
        }catch(IOException e){
            System.err.println("Failed to write log to file: "+e.getMessage());
        }
    }
}
