import java.util.Date;


public class Files implements IDataHolder {
    /*  A File class has the following attributes
    ● name - up to 32 characters long
    ● size - positive long integer
    ● creation date (date type)
    */
    private static final int MAX_NAME_LEN = 32;

    private static final String MSG_NAME_IS_TOO_LONG = "Name is too long";

    // private attributes
    private String name;
    private long size;
    private Date creationDate;

    public Files(String name, long size, Date creationDate) {
        // check name is longer then 32 characters
        if (name.length() > MAX_NAME_LEN) {
            System.out.println(MSG_NAME_IS_TOO_LONG);
        } else {
            this.name = name;
        }

        this.name = name;
        this.size = size;
        this.creationDate = creationDate;

    }

    public String getName() {
        return this.name;
    }

    public void print() {
        System.out.println("File name: " + this.name);
        System.out.println("File size: " + this.size);
        System.out.println("File creation date: " + this.creationDate);
    }

}
