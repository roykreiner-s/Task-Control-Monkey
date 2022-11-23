import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class SystemManager {
    /* SystemManager will include the following functionalities:
    addFile (string parentDirName, String fileName, integer fileSize) - Adds a new File under the Directory branch
    addDir (string parentDirName, String dirName) - Adds a new Directory under the parent Directory
    delete (string name) - Deletes the Directory or the File with this name
    showFileSystem() - Displays all files & directories with their hierarchical structure (a file should display all file properties and a directory should display all directory properties) */

    private static final String FILE_OR_DIRECTORY_DOES_NOT_EXIST = "File or directory does not exist";
    // singleton class systemManager
    private static SystemManager systemManager = new SystemManager();

    private SystemManager() {
    }

    // get instance of systemManager
    public static SystemManager getInstance() {
        return systemManager;
    }

    /* Adds a new File under the Directory branch */
    public void addFile(String parentDirName, String fileName, int fileSize) {
        Directories parentDirectory = Directories.getDirectory(parentDirName);
        Files newFile = new Files(fileName, fileSize, new Date(System.currentTimeMillis()));
        parentDirectory.addFile(newFile);
    }

    /* Adds a new Directory under the parent Directory */
    public void addDir(String parentDirName, String dirName) {
        Directories parentDirectory = Directories.getDirectory(parentDirName);
        Directories newDirectory = new Directories(dirName, new Date(System.currentTimeMillis()));
        parentDirectory.addDirectory(newDirectory);
    }

    /* Deletes the Directory or the File with this name */
    public void delete(String name) {
        Directories directory = Directories.getDirectory(name);
        // check if directory exists
        if (directory != null) {
            directory.deleteDirectory();
        } else {
            for (Directories parentDirectory : Directories.getAllDirectories().values()) {
                if (parentDirectory.getInnerFiles().containsKey(name)) {
                    parentDirectory.removeFile(name);
                } else {
                    System.out.println(FILE_OR_DIRECTORY_DOES_NOT_EXIST);
                }
            }
        }
    }

    /* Displays all files & directories with their hierarchical structure (a file should display all file properties and a directory should display all directory properties) */
    public void showFileSystem() {
        // Find all directories that have no parent directory
        List<Directories> rootDirectories = new ArrayList<>();
        for (Directories directory : Directories.getAllDirectories().values()) {
            boolean isRootDirectory = true;
            for (Directories parentDirectory : Directories.getAllDirectories().values()) {
                if (parentDirectory.getInnerDirectories().containsKey(directory.getName())) {
                    isRootDirectory = false;
                    break;
                }
            }
            if (isRootDirectory) {
                rootDirectories.add(directory);
            }
        }

        // print structure
        for (Directories rootDirectory : rootDirectories) {
            rootDirectory.printDirectory();
        }
    }
}


