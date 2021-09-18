package com.ood.fs;

public class FileSystemImpl implements FileSystem {
    private Directory root;

    public FileSystemImpl() {
        root = new Directory();
        root.setCreatedAt(System.currentTimeMillis());
        root.setPath("/");
        root.setParent(null);
        root.setUpdatedAt(System.currentTimeMillis());
    }

    @Override
    public Directory createDirectory(String path) {
        return null;
    }

    @Override
    public File createFile(String path, File f) {
        return null;
    }

    @Override
    public Directory deleteDirectory(String path) {
        return null;
    }

    @Override
    public File deleteFile(String path) {
        return null;
    }

    @Override
    public void moveDirectory(String newPath, Directory d) throws IllegalArgumentException {

    }

    @Override
    public void moveFile(String path, File f) {

    }

    @Override
    public void moveFile(Directory d, File f) {

    }
}
