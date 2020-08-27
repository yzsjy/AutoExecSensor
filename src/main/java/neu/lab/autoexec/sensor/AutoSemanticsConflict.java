package neu.lab.autoexec.sensor;

public class AutoSemanticsConflict extends AutoSensor {

    public AutoSemanticsConflict(String projectDir) {
        super(projectDir, "conflict");
    }

    public String getCommand() {
        return "mvn -f=pom.xml -DresultPath=/root/sensor/out/ -Dappend=false -DrunTime=1 -DprintDiff=true -Dmaven.test.skip=true neu.lab:X:1.0:semanticsConflict -e";
    }

    public String getCommand(String message) {
        return null;
    }
}
