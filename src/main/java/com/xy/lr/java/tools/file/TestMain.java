package com.xy.lr.java.tools.file;

import java.io.File;

/**
 * Created by xylr on 16-3-10.
 */
public class TestMain {
    public static void main(String[] args) {
        FindAllFileOnCatalogue fin = new FindAllFileOnCatalogue();

        fin.getCatalogueList(new File("/home/xylr/Working/IdeaProjects/KnowLedgeBase" +
                "/data"));

        fin.removeFileToNewPath(57995, "/home/xylr/Working/IdeaProjects/KnowLedgeBase" +
                "/data_big");
    }
}
