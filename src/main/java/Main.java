public class Main {

    public static void main(String[] args){
        String newDocumentName = "NewDocument";
        String templatePath = "template.docx";
        String dataModelPath = "dataModel.xml";

        DocCreation.docCreation(newDocumentName, templatePath, dataModelPath);
    }
}
