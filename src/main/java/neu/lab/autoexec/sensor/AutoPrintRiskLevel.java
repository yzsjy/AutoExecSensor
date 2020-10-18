package neu.lab.autoexec.sensor;

/**
 * @author SUNJUNYAN
 */
public class AutoPrintRiskLevel extends AutoSensor {
    public AutoPrintRiskLevel(String projectDir) {
        super(projectDir, "printRiskLevel");
    }

    @Override
    public String getCommand() {
        return "mvn -f=pom.xml -Dmaven.test.skip=true -DuseAllJar=false -DfilterSuper=true neu.lab:riddle:1.0:printRiskLevel -DresultPath=E:\\GrandTruth\\result\\seata\\ -e";
    }

    @Override
    public String getCommand(String message) {
        return null;
    }
}
