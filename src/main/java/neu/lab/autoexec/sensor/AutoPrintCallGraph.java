package neu.lab.autoexec.sensor;

/**
 * @author SUNJUNYAN
 */
public class AutoPrintCallGraph extends AutoSensor {
    public AutoPrintCallGraph(String projectDir) {
        super(projectDir, "printCallGraph");
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public String getCommand(String message) {
        String groupId = message.split(" ")[0];
        String artifactId = message.split(" ")[1];
        String version = message.split(" ")[2];
        String entryClass = message.split(" ")[3];
        String riskMethod = message.split(" ")[4];
        return "mvn -f=pom.xml -Dmaven.test.skip=true -DtestGroupId=" + groupId + " -DtestArtifactId=" + artifactId + " -DchangeVersion=" + version + " -DtestClass=" + entryClass + " -DtestMethod=" + riskMethod + " -DresultPath=D:\\wwww\\sjy\\autoSensor\\ neu.lab:X:1.0:printCallGraph -e";
    }
}
