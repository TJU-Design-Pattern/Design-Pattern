package crossfarm;

import java.io.*;
import java.util.Base64;

public class Memento {
    private String memento_state;

    Memento(Farm farm) throws IOException {
        this.memento_state = toString(farm);
    }

    Farm updateState(Farm farm) {
        if (memento_state == null) {
            throw new RuntimeException("memento_state is empty");
        }
        try {
            Farm state_farm = (Farm) fromString(memento_state);
            return state_farm;
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    /** Read the object from Base64 string. */
    private static Object fromString( String s ) throws IOException,
            ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
    }

    /** Write the object to a Base64 string. */
    private static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}
