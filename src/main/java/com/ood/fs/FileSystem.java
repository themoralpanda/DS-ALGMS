package com.ood.fs;

/**
 * In memory Filesystem.
 *
 * @author vig venkat
 */
public interface FileSystem {

    Directory createDirectory(String path, String name) throws IllegalArgumentException;

    File createFile(String path, File f);

    Directory deleteDirectory(String path);

    File deleteFile(String path);

    void moveDirectory(String newPath, Directory d) throws IllegalArgumentException;

    void moveFile(String path, File f);

    void moveFile(Directory d, File f);
}
