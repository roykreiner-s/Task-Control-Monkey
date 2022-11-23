import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* A Directory class has the following attributes
● name - up to 32 characters long
● creation date (date type)
● A directory can contain directories or files */


public class Directories {

    /**
     *
     */
    private static final String MSG_NAME_IS_TOO_LONG = "Name is too long";
    // private attributes
    private String name;
    private Date creationDate;
    // map to store inner directories
    private Map<String, Directories> innerDirectories = new HashMap<>();
    // map to store inner files
    private Map<String, Files> innerFiles = new HashMap<>();

    // Constructor with 2 params (name, creation date)
    public Directories(String name, Date creationDate) {

        // check name is longer then 32 characters
        if (name.length() > 32) {
            System.out.println(MSG_NAME_IS_TOO_LONG);
        } else {
            this.name = name;
        }

        this.name = name;
        this.creationDate = creationDate;
    }
}
