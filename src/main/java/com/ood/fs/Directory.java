package com.ood.fs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Directory {
    private String name;
    private String path;
    private Directory parent;
    private long createdAt;
    private long updatedAt;

    private Set<File> files;
    private Set<Directory> subDirectories;

    public File addFile(File f) {
        if(files == null)
            files = new HashSet<>();
        files.add(f);
        f.setParent(this);
        return f;
    }

    public Directory addDirectory(Directory d) {
        if(subDirectories == null)
            subDirectories = new HashSet<>();
        subDirectories.add(d);
        d.parent = this;
        return d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
