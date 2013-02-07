package pdfgenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
public class PdfGen {
	private final static Font font = new Font(Font.FontFamily.ZAPFDINGBATS, 13f, Font.BOLD);
	private final static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
    private static Font qFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL);

    private final List<String> questionLabels;
    private final List<String> questionValues;
	
	final String yes="4";
	final String no="6";
	
	private PdfGen(List<String> questionLabels,List<String> questionValues){
	
		this.questionLabels=questionLabels;
		this.questionValues=questionValues;
	}

    public static void createPdf(String frameName,List<String> questionLabels,List<String> questionValues) {
    	PdfGen generator=new PdfGen(questionLabels,questionValues);
    	generator.putContent(frameName);
    	
    }
    
    
    
    private void putContent(String frameName){
        try {
        	
            OutputStream file = new FileOutputStream(new File("/home/jahn/Desktop/test.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            document.add(setTitle(frameName));

            for(int i=0;i<=questionLabels.size()-1;i++){
            Paragraph p1=new Paragraph(questionLabels.get(i),qFont);
            p1.add(new Chunk(" "+questionValues.get(i)));
            addEmptyLine(p1, 1);


            document.add(new Paragraph(p1));
            }
          
 
            document.close();
            file.close();
 
        } catch (Exception e) {
 
            e.printStackTrace();
        }
    }
    
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
          paragraph.add(new Paragraph(" "));
        }
      }
    
    private static Paragraph setTitle(String frameName){
    	Paragraph header= new Paragraph();
        addEmptyLine(header, 1);
        Paragraph title= new Paragraph(frameName, catFont);
        header.add(title);
        addEmptyLine(header, 4);
        title.setAlignment(Element.ALIGN_CENTER);
        return header;
    }
   
}