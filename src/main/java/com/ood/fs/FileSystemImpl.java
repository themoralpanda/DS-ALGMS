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
    public Directory createDirectory(String path, String name) throws IllegalArgumentException {
        if(!isValidPath(path)) throw new IllegalArgumentException();
        Directory d = new Directory();
        d.setName(name);
        String[] crumbs = path.split("/");
        if(crumbs.length == 1)
            return root.addDirectory(d);

    }



    public boolean isValidPath(String path) {
        if(path == null || path.isEmpty()) return false;
        if(path.charAt(0) != '/') return false;
        return true;
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
