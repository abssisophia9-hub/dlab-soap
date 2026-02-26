package ma.aui.sse.paradigms.integration.xs.loganalysis.provider;

public class StatusCount {

    private int errorCount;
    private int warnCount;
    private int infoCount;
    private int debugCount;

    public StatusCount() {}

    public StatusCount(int errorCount, int warnCount, int infoCount, int debugCount) {
        this.errorCount = errorCount;
        this.warnCount = warnCount;
        this.infoCount = infoCount;
        this.debugCount = debugCount;
    }

    public int getErrorCount() { return errorCount; }
    public void setErrorCount(int errorCount) { this.errorCount = errorCount; }

    public int getWarnCount() { return warnCount; }
    public void setWarnCount(int warnCount) { this.warnCount = warnCount; }

    public int getInfoCount() { return infoCount; }
    public void setInfoCount(int infoCount) { this.infoCount = infoCount; }

    public int getDebugCount() { return debugCount; }
    public void setDebugCount(int debugCount) { this.debugCount = debugCount; }
}
