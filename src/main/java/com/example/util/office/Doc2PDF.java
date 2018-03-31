package com.example.util.office;

import com.aspose.words.Document;


/**
 * Created by Zhangkh on 2018/3/29.
 */
public class Doc2PDF {

    public static void test(String[] args) throws Exception {
        // The path to the documents directory.
//        String dataDir = Utils.getDataDir(Doc2PDF.class);

        String dataDir = "C:\\Users\\Zhangkh\\Desktop\\";

        //ExStart:Doc2Pdf
        // Load the document from disk.
        Document doc = new Document(dataDir + "移动办公附件说明.docx");

        // Save the document in PDF format.
        dataDir = dataDir + "13output.pdf";
        doc.save(dataDir);
        //ExEnd:Doc2Pdf

        System.out.println("\nDocument converted to PDF successfully.\nFile saved at " + dataDir);
    }

    public static void test1() {
        String path = "C:\\Users\\Zhangkh\\Desktop\\";
        String srcFile = path + "蜂巢微信版建设方案.docx";
        String targetFile = path + "17.pdf";
        try {
            OfficeUtil.setConfig(false, null);
            OfficeUtil.doc2Pdf(srcFile, targetFile);
//            OfficeUtil.excel2pdf(srcFile, targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        test1();
    }
}
