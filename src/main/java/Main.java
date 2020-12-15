public class Main {

    public static void main(String[] args){
        String newDocumentName = "NewSimpleDocument";
        String templatePath = "template.docx";
        String dataModelPath = "dataModel.xml";

        String newSchoolDocumentName = "NewSchoolDocument";
        String schoolTemplatePath = "schoolTemplate.docx";
        String schoolDataModelPath = "schoolDataModel.xml";

        DocCreation.docCreation(newSchoolDocumentName, schoolTemplatePath, schoolDataModelPath);
        DocCreation.docCreation(newDocumentName, templatePath, dataModelPath);
    }
}
