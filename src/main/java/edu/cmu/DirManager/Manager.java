package edu.cmu.DirManager;

public class Manager {
    private DirOps dirOps;
    
    /**
     * Creates a new directory at the specified path.
     *
     * @param path the path where the new directory should be created
     * @return 0 if the directory creation was successful
     *        -1 if the directory already exists,
     *        -2 if the path is invalid
     */
    public int newDirectory(String path) {
        if (dirOps.checkDirectoryExists(path)) {
            return -1;
        } else if (!dirOps.checkPathValid(path)) {
            return -2;
        } else {
            dirOps.createDirectory(path);
            return 0;
        }
    }
}
