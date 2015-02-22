package ua.dou.hack.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author Dmytro Troshchuk
 * @version 1.00  22.02.15.
 */
@Component
public class PdfUtils {
    private final Logger LOGGER = LogManager.getLogger();

    public void createPdf(String html, String pathOut) {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pathOut));
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(html));
            document.close();
            LOGGER.info("PDF created");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
