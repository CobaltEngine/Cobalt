package io.github.cobalt.common.utils;

import java.io.File;

public class FileWalker {
    public static int Walk(File baseDir, FileConsumer consumer) {
        int filesConsumed = 0;
        if(baseDir.isFile()) { consumer.Consume(baseDir); return filesConsumed; }
        File[] files = baseDir.listFiles();
        if(files == null) return filesConsumed; //Ignore This Directory
        for(File file : files) {
            if(file.isFile()) {
                filesConsumed++;
                consumer.Consume(file);
            } else {
                filesConsumed += Walk(file, consumer);
            }
        }
        return filesConsumed;
    }

    public static interface FileConsumer {
        void Consume(File file);
    }
}
