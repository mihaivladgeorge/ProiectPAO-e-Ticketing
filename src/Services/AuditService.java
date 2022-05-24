package Services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Time;
import java.sql.Timestamp;

public class AuditService {

    private static AuditService instance = null;
    private AuditService() {}
    public static AuditService getInstance() {
        if(instance == null) {
            instance = new AuditService();
        }
        return instance;
    }

    public void writeLogs(String method) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try(var out = new BufferedWriter(new FileWriter("Files/audit.csv", true))) {
            String log = method + "," + ts + '\n';
            out.write(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
