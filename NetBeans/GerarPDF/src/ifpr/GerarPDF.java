package ifpr;

import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.*; 
import com.lowagie.text.pdf.PdfImage;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class GerarPDF 
{
    private Document documento;
    private final int COLUNAS_TABLE = 1;
    
    public static void main(String[] args) 
    {
        new GerarPDF().executar();
    }
    
    public void executar()
    {
        documento = new Document();
        
        try {
	        PdfWriter.getInstance(documento, new FileOutputStream("C://PDF_LinhaCodigo.pdf"));

	        documento.open();
                
                String texto = "Exemplo Geração de Arquivo PDF via iText - Java";
                
                Image img = Image.getInstance("C:\\crocodilo.jpg");
                img.setAlignment(Element.ALIGN_CENTER);
                
                Paragraph paragrafo = new Paragraph(texto);
                
                PdfPCell cell = new PdfPCell(paragrafo);
                PdfPCell cell2 = new PdfPCell(img);

                PdfPTable table = new PdfPTable(COLUNAS_TABLE);
                
                table.addCell(cell);
                table.addCell(cell2);
                   
	        documento.add(table);
                
                documento.close();
            }
	   
        catch(DocumentException de) 
        {
	           
            System.err.println(de.getMessage());
        }
	       
        catch(IOException ioe) 
        {
	
            System.err.println(ioe.getMessage());
        }
    }
}