package neu.lab.autoexec.sensor;

public class AutoCount extends AutoSensor {

    public AutoCount(String projectDir) {
        super(projectDir,"count");
    }


    @Override
    public String getCommand() {
        return "mvn -DresultPath=/root/sensor/out/ -Dmaven.test.skip=true neu.lab:X:1.0:countProject -e";
    }

    @Override
    public String getCommand(String message) {
        return null;
    }
}
