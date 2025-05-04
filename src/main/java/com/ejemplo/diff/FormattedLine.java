package com.ejemplo.diff;

public class FormattedLine {
    public int lineNumber;
    public String content;
    public String changeType;
    public boolean isContinuation;

    public FormattedLine(int lineNumber, String content, String changeType, boolean isContinuation) {
        this.lineNumber = lineNumber;
        this.content = content;
        this.changeType = changeType;
        this.isContinuation = isContinuation;
    }
}
