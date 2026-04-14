package edu.cmu.DirManager;

public class Manager {
    private DirOps dirOps;
    
    /**
     * Creates a new directory at the specified path.
     *
     * @param path the path where the new directory should be created
     * @throws DirectoryExistsException if the directory already exists
     * @throws InvalidPathException if the path is invalid
     */
    public void newDirectory(String path) throws DirectoryExistsException, InvalidPathException {
        if (dirOps.checkDirectoryExists(path)) {
            throw new DirectoryExistsException(path);
        } else if (!dirOps.checkPathValid(path)) {
            throw new InvalidPathException(path);
        } else {
            dirOps.createDirectory(path);
        }
    }
}
