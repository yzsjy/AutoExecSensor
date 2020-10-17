package neu.lab.autoexec.sensor;

public class AutoPrintSize extends AutoSensor {

    public AutoPrintSize(String projectDir) {
        super(projectDir,"size");
    }

    @Override
    public String getCommand() {
        return "mvn package";
    }

    @Override
    public String getCommand(String message) {
        return null;
    }

}
