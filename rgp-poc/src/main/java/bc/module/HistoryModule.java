package bc.module;

import java.io.*;
import java.time.LocalTime;
import java.util.LinkedHashMap;

public class HistoryModule implements IModule {
    private static HistoryModule hm;
    private LinkedHashMap<LocalTime, String> historyLogs;

    private HistoryModule() {
        historyLogs = new LinkedHashMap<>();
    }

    public static HistoryModule getInstance() {
        if (hm == null)
            hm = new HistoryModule();
        return hm;
    }

    public void logCalculation(Calculation c) {
        historyLogs.put(LocalTime.now(), c.getCurrentOperator() + " " + c.getCurrentValue());
    }

    public void dumpLogs() {
        File historyLog = new File("historyLog.txt");
        if (!historyLog.exists()) {
            try {
                historyLog.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(historyLog, true), true);

            historyLogs.forEach((lt, c) -> pw.println(lt.toString() + " : " + c));

            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        historyLogs.clear();

    }
}
