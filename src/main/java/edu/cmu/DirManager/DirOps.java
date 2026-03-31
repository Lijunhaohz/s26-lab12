package edu.cmu.DirManager;

// The API flaw is not in this file
public interface DirOps {
    public boolean checkDirectoryExists(String path);
    public boolean checkPathValid(String path);
    public void createDirectory(String path);
}
