import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        // get input from user until "stop" is entered
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please insert function name: ");
            String input = scanner.nextLine();
            UserInput userInput = UserInput.valueOf(input.toUpperCase());

            switch (userInput) {
                case ADD_FILE:
                    System.out.println("Enter parent directory name");
                    String parentDirOfFileName = scanner.nextLine();
                    System.out.println("Enter file name");
                    String fileName = scanner.nextLine();
                    System.out.println("Enter file size");
                    int fileSize = scanner.nextInt();
                    addFile(parentDirOfFileName, fileName, fileSize);
                    break;

                case ADD_DIR:
                    System.out.println("Enter parent directory name");
                    String parentDirName = scanner.nextLine();
                    System.out.println("Enter directory name");
                    String dirName = scanner.nextLine();
                    addDir(parentDirName, dirName);
                    break;

                case DELETE:
                    System.out.println("Enter file or directory name");
                    String name = scanner.nextLine();
                    delete(name);
                    break;


                case SHOW_FILE_SYSTEM:
                    showFileSystem();
                    break;

                case STOP:
                    scanner.close();
                    System.exit(0);
            }
        }


    }

    /* Adds a new File under the Directory branch */
    public static void addFile(String parentDirName, String fileName, int fileSize) {
        SystemManager systemManager = SystemManager.getInstance();
        systemManager.addFile(parentDirName, fileName, fileSize);
    }

    /* Adds a new Directory under the parent Directory */
    public static void addDir(String parentDirName, String dirName) {
        SystemManager systemManager = SystemManager.getInstance();
        systemManager.addDir(parentDirName, dirName);
    }

    /* Deletes the Directory or the File with this name */
    public static void delete(String name) {
        SystemManager systemManager = SystemManager.getInstance();
        systemManager.delete(name);
    }

    /* Displays all files & directories with their hierarchical structure (a file should display all file properties and a directory should display all directory properties) */
    public static void showFileSystem() {
        SystemManager systemManager = SystemManager.getInstance();
        systemManager.showFileSystem();

    }

    public enum UserInput {
        ADD_FILE, ADD_DIR, DELETE, SHOW_FILE_SYSTEM, STOP
    }

}
