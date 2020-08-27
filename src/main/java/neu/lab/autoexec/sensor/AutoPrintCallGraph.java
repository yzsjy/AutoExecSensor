package neu.lab.autoexec.sensor;

public class AutoPrintCallGraph extends AutoSensor {
    public AutoPrintCallGraph(String projectDir) {
        super(projectDir, "printCallGraph");
    }

    public String getCommand() {
        return null;
    }

    public String getCommand(String message) {
        String groupId = message.split(" ")[0];
        String artifactId = message.split(" ")[1];
        String version = message.split(" ")[2];
        String entryClass = message.split(" ")[3];
        String riskMethod = message.split(" ")[4];
//        return "mvn package\n" +
        return 
                "mvn -f=pom.xml -Dmaven.test.skip=true -DtestGroupId=" + groupId + " -DtestArtifactId=" + artifactId + " -DchangeVersion=" + version + " -DtestClass=" + entryClass
                + " -DtestMethod=" + riskMethod + " -DresultPath=/Users/yzsjy/Desktop/Result/ neu.lab:X:1.0:printCallGraph -e";
    }
}
