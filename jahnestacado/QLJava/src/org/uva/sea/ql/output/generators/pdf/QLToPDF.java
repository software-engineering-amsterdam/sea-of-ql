package org.uva.sea.ql.output.generators.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
public class QLToPDF {
	private final static Font symbolFont = new Font(Font.FontFamily.ZAPFDINGBATS, 15, Font.BOLD);
	private final static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.UNDERLINE);
    private static Font questionFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,Font.ITALIC);
    private static Font resultsFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,Font.BOLD);
    private final static String imgPath = "src/org/uva/sea/ql/output/generators/pdf/images/uva_logo.jpg";
    private final static Map<String,String> boolValues;
    static
    {
    	boolValues = new HashMap<String, String>();
    	boolValues.put("true", "Yes");
    	boolValues.put("false","No");
    }
    
    private final static Map<String,String> yesOrNoSymbol;
    static
    {
    	yesOrNoSymbol = new HashMap<String, String>();
    	yesOrNoSymbol.put("true", "4");   //** Values '4' and '6' corresponds to 'tick' and 'X' symbols of
    	yesOrNoSymbol.put("false","6");   //** the ZAPFDINGBATS font. 
    }


    private final List<String> questionLabels;
    private final List<String> questionValues;
	
	
	
	private QLToPDF(List<String> questionLabels,List<String> questionValues){
		this.questionLabels=questionLabels;
		this.questionValues=questionValues;
	}

    public static void generatePdf(String frameName,List<String> questionLabels,List<String> questionValues) {
    	QLToPDF generator=new QLToPDF(questionLabels,questionValues);
    	generator.putContent(frameName);
    	
    }
    
    
	private void putContent(String frameName) {
		try {
			String path = "src/org/uva/sea/ql/output/pdf/" + frameName + ".pdf";
			File filePath = new File(path);
			OutputStream file = new FileOutputStream(filePath.getAbsolutePath());
			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			Image img = Image.getInstance(imgPath);
			document.add(setHeaderLogo(img));
			document.add(setTitle(frameName));

			for (int i = 0; i <= questionLabels.size() - 1; i++) {
				Paragraph p1 = new Paragraph(questionLabels.get(i),
						questionFont);

				p1 = getProperDisplayedValue(p1, questionValues.get(i));
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
    
	private static Paragraph setHeaderLogo(Image img) {
		Paragraph logoHeader = new Paragraph();
		img.scalePercent(15f);
		Chunk imgChunk = new Chunk(img, 0, 0, true);
		logoHeader.add(imgChunk);
		logoHeader.setAlignment(Element.ALIGN_LEFT);
		addEmptyLine(logoHeader, 1);
		return logoHeader;
	}
    
	private static Paragraph setTitle(String frameName) {
		Paragraph header = new Paragraph();
		addEmptyLine(header, 1);
		Paragraph title = new Paragraph(frameName + " Questionnaire", titleFont);
		header.add(title);
		addEmptyLine(header, 2);
		title.setAlignment(Element.ALIGN_CENTER);
		return header;
	}
    
	private Paragraph getProperDisplayedValue(Paragraph p, String value) {
		p.add(new Chunk("     "));
		if (boolValues.containsKey(value)) {
			p.add(new Chunk(yesOrNoSymbol.get(value), symbolFont));
			p.add(new Chunk("  (" + boolValues.get(value) + ")", resultsFont));
		} else {
			p.add(new Chunk("  " + value, resultsFont));

		}

		return p;

	}
   
}