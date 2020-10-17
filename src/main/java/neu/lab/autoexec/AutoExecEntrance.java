package neu.lab.autoexec;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AutoExecEntrance {

    // TODO which directory
    public static final String projectDir = "D:\\grandtruthProject\\";
    public static final String sensorPath = "";

    public static void main(String[] args) throws IOException {
        //TODO which goal
        if (args.length == 0) {
            new neu.lab.autoexec.sensor.AutoPrintSize(projectDir).autoExe(getPomPathByTest(sensorPath), true);
        } else if (args[0].equals("detect")) {
            new neu.lab.autoexec.sensor.AutoSemanticsConflict(projectDir).autoExe(getPomPathBySize("/root/sensor/out/projectSize.txt"), true);
        } else if (args[0].equals("change")) {
            new neu.lab.autoexec.sensor.AutoChangeDependencyVersion(projectDir).autoExe(getPomPathByTest("/Users/yzsjy/Desktop/SensorData/text/projectTestSort.txt"), true);
        } else if (args[0].equals("count")) {
            new neu.lab.autoexec.sensor.AutoCount(projectDir).autoExe(getPomPathBySize("/root/sensor/dataset/sortProject.txt"), true);
        } else if (args[0].equals("risk")) {
            new neu.lab.autoexec.sensor.AutoSemanticsRisk(projectDir).autoExe(getPomPathByTreeSize("/root/sensor/out/projectSize.txt"), true);
        } else if (args[0].equals("classes")) {
            new neu.lab.autoexec.sensor.AutoSemanticsClassesDuplicate(projectDir).autoExe(getPomPathByTreeSize("/root/sensor/out/projectSize.txt"), true);
        } else if (args[0].equals("sup")) {
            new neu.lab.autoexec.sensor.AutoSemanticsSupImpl(projectDir).autoExe(getPomPathByTreeSize("/root/sensor/out/projectSize.txt"), true);
        } else if (args[0].equals("printCallGraph")) {
            new neu.lab.autoexec.sensor.AutoPrintCallGraph(projectDir).autoExe(getPomPath(sensorPath), getMessage(sensorPath), true);
        } else if (args[0].equals("printRiskLevel")) {
            new neu.lab.autoexec.sensor.AutoPrintRiskLevel(projectDir).autoExe(getPomPath("E:\\GrandTruth\\text\\risktest.txt"), true);
        }
    }

    private static List<String> getPomPathBySize(String sizeFile) {
        Map<Integer, List<String>> size2poms = new TreeMap<Integer, List<String>>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sizeFile));
            String line = reader.readLine();
            while (line != null) {
                if (!line.equals("")) {
                    String[] pom_jar_size = line.split(" ");
                    Integer size = Integer.valueOf(pom_jar_size[2]);
                    List<String> poms = size2poms.get(size);
                    if (poms == null) {
                        poms = new ArrayList<String>();
                        size2poms.put(size, poms);
                    }
                    poms.add(pom_jar_size[0]);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> sortedPomPaths = new ArrayList<String>();
        for (Integer size : size2poms.keySet()) {
            sortedPomPaths.addAll(size2poms.get(size));
        }
        return sortedPomPaths;
    }

    private static List<String> getPomPathByTreeSize(String sizeFile) {
        Map<Integer, List<String>> size2poms = new TreeMap<Integer, List<String>>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sizeFile));
            String line = reader.readLine();
            while (line != null) {
                if (!line.equals("")) {
                    try {
                        String[] pom_jar_size = line.split(" ");
                        Integer size = Integer.valueOf(pom_jar_size[1]);
                        if (size < 10) {
                            line = reader.readLine();
                            continue;
                        }
                        List<String> poms = size2poms.get(size);
                        if (poms == null) {
                            poms = new ArrayList<String>();
                            size2poms.put(size, poms);
                        }
                        poms.add(pom_jar_size[0]);
                    }catch (Exception e){
                        e.printStackTrace();
                        line = reader.readLine();
                        continue;
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> sortedPomPaths = new ArrayList<String>();
        for (Integer size : size2poms.keySet()) {
            sortedPomPaths.addAll(size2poms.get(size));
        }
        return sortedPomPaths;
    }

    private static List<String> getPomPathByTestSize(String sizeFile) {
        Map<Integer, List<String>> size2poms = new TreeMap<Integer, List<String>>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sizeFile));
            String line = reader.readLine();
            while (line != null) {
                if (!line.equals("")) {
                    String[] pom_jar_test_size = line.split(" ");
                    Integer size = Integer.valueOf(pom_jar_test_size[1]);
                    if (size > 10) {
                        List<String> poms = size2poms.get(size);
                        if (poms == null) {
                            poms = new ArrayList<String>();
                            size2poms.put(size, poms);
                        }
                        poms.add(pom_jar_test_size[0]);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> sortedPomPaths = new ArrayList<String>();
        for (Integer size : size2poms.keySet()) {
            sortedPomPaths.addAll(size2poms.get(size));
        }
        return sortedPomPaths;
    }

    private static List<String> getPomPath(String file) {
        ArrayList pomPaths = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!line.equals("")) {
                    pomPaths.add(line);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pomPaths;
    }

    private static List<String> getMessage(String file) {
        ArrayList pomPaths = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!line.equals("")) {
                    String[] path = line.split(" ");
                    pomPaths.add(path[1] + " " + path[2] + " " + path[3] + " " + path[4] + " " + path[5]);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pomPaths;
    }

    private static List<String> getPomPathByTest(String file) {
        ArrayList pomPaths = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!line.equals("")) {
                    pomPaths.add(line.split(" ")[0]);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pomPaths;
    }

}
