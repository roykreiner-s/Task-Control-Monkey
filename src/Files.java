import java.util.Date;

/*  A File class has the following attributes
● name - up to 32 characters long
● size - positive long integer
● creation date (date type)
*/


public class Files {

    private static final String MSG_NAME_IS_TOO_LONG = "Name is too long";


    // private attributes
    private String name;
    private long size;
    private Date creationDate;

    // public attributes


    // Constructor with 3 params (name, size, creation date)
    public Files(String name, long size, Date creationDate) {

        // check name is longer then 32 characters
        if (name.length() > 32) {
            System.out.println(MSG_NAME_IS_TOO_LONG);
        } else {
            this.name = name;
        }

        this.name = name;
        this.size = size;
        this.creationDate = creationDate;
    }

}
