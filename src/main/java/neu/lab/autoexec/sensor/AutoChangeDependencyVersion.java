package neu.lab.autoexec.sensor;

import neu.lab.autoexec.util.FileSyn;

import java.io.IOException;

public class AutoChangeDependencyVersion extends AutoSensor {

    public AutoChangeDependencyVersion(String projectDir) {

        super(projectDir, "change");
    }


    @Override
    public String getCommand() {
        return "mvn clean\n" +
                "mvn -f=pom.xml -DlogFilePath=/Users/yzsjy/Desktop/SensorData/autoChangeDependencyVersionLog/ -Dmaven.test.skip=true neu.lab:AutoChangeDependencyVersion:1.0:changeDependency -e";
    }

    @Override
    public String getCommand(String message) {
        return null;
    }
}
