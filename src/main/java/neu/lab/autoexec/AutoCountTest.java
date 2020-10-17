package neu.lab.autoexec;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AutoCountTest {
    private static String projectFolders = "E:\\GrandTruth\\text\\Project.txt";
    private static List<String> getPomPath(String file) {
        ArrayList pomPaths = new ArrayList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!line.equals("")) {
                    String path = line.split(" ")[0] + "/target/classes/";
                    File testFile = new File(path);
                    if (testFile.exists()) {
                        System.out.println(line);
                        pomPaths.add(line);
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pomPaths;
    }

    private static List<String> countTestFiles() {
        ArrayList count = new ArrayList();
        for (String path : getPomPath(projectFolders)) {
            File file = new File(path + "/src/test/");
            int num = 0;
            num = findTestFiles(file, num);
            System.out.println(path + " " + num);
            count.add(path + " " + num);
        }
        return count;
    }

    private static int findTestFiles(File father, int num) {
        File[] children = father.listFiles();
        for (File child : children) {
            if (child.getName().substring(child.getName().lastIndexOf(".") + 1).equals("java")) {
                num ++;
            }
            if (child.isDirectory()) {
                num = findTestFiles(child, num);
            }
        }
        return num;
    }

    protected static List<String> getPomDirs() {
        ArrayList pomPaths = new ArrayList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(projectFolders));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!line.equals("")) {
                    File testFile = new File(line);
                    pomPaths.addAll(findPomPaths(testFile));
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pomPaths;
    }

    private static List<String> findPomPaths(File father) {
        File[] children = father.listFiles();
        List<String> pomPaths = new ArrayList<String>();
        if (!father.getAbsolutePath().contains("/target/")
                && !father.getAbsolutePath().contains("/src/main/resources/")
                && !father.getAbsolutePath().contains("/src/test/")) {
            for (File child : children) {
                if (child.getName().equals("pom.xml")) {
                    pomPaths.add(father.getAbsolutePath());
                }
                if (child.isDirectory()) {
                    pomPaths.addAll(findPomPaths(child));
                }
            }
        }
        return pomPaths;
    }

    public static void main(String []args) {
        try {
            PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(new File("E:\\GrandTruth\\text\\testProject1.txt"), false)));
            for (String info : getPomPath("E:\\GrandTruth\\text\\testProject.txt")) {
                printer.println(info);
            }
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
