import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Directories implements IDataHolder {
    /* A Directory class has the following attributes
    ● name - up to 32 characters long
    ● creation date (date type)
    ● A directory can contain directories or files */

    private static final String MSG_NAME_IS_TOO_LONG = "Name is too long";
    private static Map<String, Directories> allDirectories = new HashMap<>();

    // private attributes
    private String name;
    private Date creationDate;
    // map to store inner directories
    private Map<String, Directories> innerDirectories = new HashMap<>();
    // map to store inner files
    private Map<String, Files> innerFiles = new HashMap<>();

    public Directories(String name, Date creationDate) {

        // check name is longer then 32 characters
        if (name.length() > 32) {
            System.out.println(MSG_NAME_IS_TOO_LONG);
        } else {
            this.name = name;
        }

        this.name = name;
        this.creationDate = creationDate;

        // add directory to all directories map
        allDirectories.put(name, this);
    }

    public static Directories getDirectory(String parentDirName) {
        if (allDirectories.containsKey(parentDirName)) {
            return allDirectories.get(parentDirName);
        } else {
            return null;
        }
    }

    public static Map<String, Directories> getAllDirectories() {
        return allDirectories;
    }

    public void addFile(Files newFile) {
        innerFiles.put(newFile.getName(), newFile);
    }

    public void addDirectory(Directories newDirectory) {
        innerDirectories.put(newDirectory.getName(), newDirectory);
    }

    public String getName() {
        return this.name;
    }

    public void deleteDirectory() {
        // delete directory from all directories map
        allDirectories.remove(this.name);
        // delete inner directories
        for (Directories innerDirectory : innerDirectories.values()) {
            innerDirectory.deleteDirectory();
        }
        // check if directory has parent directory and delete it from parent directory
        for (Directories parentDirectory : allDirectories.values()) {
            if (parentDirectory.innerDirectories.containsKey(this.name)) {
                parentDirectory.innerDirectories.remove(this.name);
            }
        }
    }

    public Map<String, Files> getInnerFiles() {
        return innerFiles;
    }

    public void removeFile(String fileName) {
        innerFiles.remove(fileName);
    }

    public Map<String, Directories> getInnerDirectories() {
        return innerDirectories;
    }

    public void print() {
        System.out.println("Directory name: " + this.name);
        System.out.println("Creation date: " + this.creationDate);
        System.out.println("Inner files: ");
        System.out.println("{");
        for (Files innerFile : innerFiles.values()) {
            innerFile.print();
        }
        // print inner directories
        for (Directories innerDirectory : innerDirectories.values()) {
            innerDirectory.print();
        }
        System.out.println("}");
    }
}
