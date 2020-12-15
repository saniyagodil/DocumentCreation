import fr.opensagres.xdocreport.core.document.DocumentKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.TemplateEngineInitializerRegistry;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.freemarker.FreemarkerTemplateEngine;
import freemarker.ext.dom.NodeModel;
import org.xml.sax.InputSource;

import java.io.*;

public class DocCreation {

    public static void docCreation(String newDocumentName, String templatePath, String dataModelPath) {
        FreemarkerTemplateEngine templateEngine = (FreemarkerTemplateEngine) TemplateEngineInitializerRegistry
                .getRegistry()
                .getTemplateEngine(TemplateEngineKind.Freemarker, DocumentKind.DOCX);
        File template;
        IXDocReport report = null;

        try {
            template = new File(templatePath);
            try (InputStream inputStream = new FileInputStream(template)) {
                report = XDocReportRegistry.getRegistry().loadReport(inputStream, TemplateEngineKind.Freemarker);
            }

            //Load and Parse XML Data
            InputSource inputSource = new InputSource(String.valueOf(new File(dataModelPath)));
            NodeModel parsedXML = NodeModel.parse(inputSource);
            IContext context = report.createContext();
            context.put("doc", parsedXML);

            // Create File
            try (OutputStream out = new FileOutputStream(new File(newDocumentName + ".docx"))) {
                report.process(context, out);
                System.out.println("Document created!!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
