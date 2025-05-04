package com.ejemplo.diff;
import java.util.List;

public class JavaDiffReport {
    public static void main(String[] args) throws Exception {
        List<String> oldLines = FileLoader.readLines("oldVersion.java");
        List<String> newLines = FileLoader.readLines("newVersion.java");

        DiffProcessor processor = new DiffProcessor(oldLines, newLines);
        List<FormattedLine> diffLines = processor.generateDiff();

        PdfReportWriter generator = new PdfReportWriter();
        generator.generate("diff-report.pdf", diffLines);
    }
}