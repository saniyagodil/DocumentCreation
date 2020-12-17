public class Main {

    public static void main(String[] args){
        String newDocumentName = "NewSimpleDocument";
        String templatePath = "src\\main\\resources\\template.docx";
        String dataModelPath = "src\\main\\resources\\dataModel.xml";

        String newSchoolDocumentName = "NewSchoolDocument";
        String schoolTemplatePath = "src\\main\\resources\\schoolTemplate.docx";
        String schoolDataModelPath = "src\\main\\resources\\schoolDataModel.xml";

        DocCreation.docCreation(newSchoolDocumentName, schoolTemplatePath, schoolDataModelPath);
        DocCreation.docCreation(newDocumentName, templatePath, dataModelPath);
    }
}
