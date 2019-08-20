package data;

import java.io.*;

public class DataUtils {

    public static String getFileAbsolutePathFromFolder(String folderAbsolutePath) {
        File folder = new File(folderAbsolutePath);

        if (folder.listFiles().length > 0) {
            return folder.listFiles()[0].getAbsolutePath();
        } else {
            return "";
        }
    }

    public static String getFileNameFromFileAbsolutePath(String fileAbsolutePath) {
        File file = new File(fileAbsolutePath);
        return file.getName();
    }

    public static BufferedReader getReaderForFile(String fileAbsolutePath) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(fileAbsolutePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return br;
    }

    public static boolean closeReader(BufferedReader br) {
        try {
            br.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean createFolder(String folderAbsolutePath) {
        return new File(folderAbsolutePath).mkdirs();
    }

    public static boolean moveFile(String fileName, String originFolderAbsolutePath, String destinyFolderAbsolutePath) {
        String originalFile = originFolderAbsolutePath + "\\" + fileName;
        String newFile = destinyFolderAbsolutePath + "\\" + fileName;

        try {
            File aFile = new File(originalFile);
            File bFile = new File(newFile);

            return aFile.renameTo(bFile);
        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

}