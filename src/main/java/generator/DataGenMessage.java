package generator;

import java.util.UUID;
import java.util.Random;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dtregonning on 9/12/17.
 */
public class DataGenMessage {
    String message = null;
    UUID uuid = null;
    int sequenceNumber = 0;
    Timestamp timestamp = null;

    public DataGenMessage(int size, int sequenceNumber) {
        this.uuid = UUID.randomUUID();
        this.message = String.valueOf(randomizeMessage(size));
        this.sequenceNumber = sequenceNumber;
	this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    private char[] randomizeMessage(int size) {
        char[] char_array  = new char[size];
        Random r = new Random();
        for(int i = 0; i < char_array.length; i++) {
            char_array[i] = (char) (r.nextInt(26) + 'a');
        }
        return char_array;
    }

    public String toString() {
        return "UUID:" + this.uuid + "\nMESSAGE:" + this.message;
    }

    public String toJSON() {
        return "{"+ "\"timestamp\":\"" + this.timestamp + "\", \"region\": \"EMEA\", \"company\":\"acme\", " + "\"eventKey\":\"" + this.sequenceNumber + "\", \"uuid\":\"" + this.uuid +"\", \"message\":\"" + this.message + "\"}";
    }
}
