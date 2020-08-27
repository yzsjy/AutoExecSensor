package neu.lab.autoexec.sensor;

public class AutoSemanticsClassesDuplicate extends AutoSensor {

    public AutoSemanticsClassesDuplicate(String projectDir) {
        super(projectDir, "classesDuplicate");
    }

    @Override
    public String getCommand() {
        return //"mvn package -Dmaven.test.skip=true\n" +
                "mvn -f=pom.xml -DresultPath=/root/sensor/out/classes/ -DignoreTestScope=true -Dmaven.test.skip=true neu.lab:X:1.0:classDupRisk -e";
    }

    public String getCommand(String message) {
        return null;
    }
}
