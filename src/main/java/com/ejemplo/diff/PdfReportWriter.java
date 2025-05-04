package com.ejemplo.diff;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.IOException;
import java.util.List;

public class PdfReportWriter {

    private final LineFormatter formatter;

    public PdfReportWriter() {
        this.formatter = new LineFormatter();
    }

    public void generate(String filename, List<FormattedLine> lines) throws IOException {
        PdfWriter writer = new PdfWriter(filename);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Reporte de Cambios")
                .setBold()
                .setTextAlignment(TextAlignment.CENTER));

        for (FormattedLine line : lines) {
            formatter.formatLine(line).forEach(text -> {
                document.add(new Paragraph().add(text));
            });
        }

        document.close();
    }
}
