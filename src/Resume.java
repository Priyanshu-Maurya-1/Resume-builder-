import java.io.File;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.cj.Constants;
import java.awt.Color;


import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.sl.usermodel.Background;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.xmlbeans.XmlToken;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
/**
 * Servlet implementation class Resume
 */
@WebServlet("/Resume")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,
maxRequestSize=1024*1024*50)
public class Resume extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Resume() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public Connection getConnection()
	{
		Connection con=null;
		try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part=request.getPart("file");
		/*String fileName=extractFileName(part);
		String savePath="D:\\eclipse-workspace\\User\\WebContent\\Images\\"+ (File.separator + fileName);
		File fileSaveDir =new File(savePath);
		//part.write(savePath + File.separator);*/
		String fileName = getFileName(part);
		String name=fileName.substring(fileName.lastIndexOf('\\')+1);
		//String item[]=fileName.split("\\");
		//System.out.println("my out put : "+item[0]);
		 part.write("C:\\Users\\Admin\\eclipse-workspace\\User\\WebContent\\Images" + name);
		 		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String mobilenumber=request.getParameter("mobilenumber");
		String dob=request.getParameter("dob");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String languages[]=request.getParameterValues("languages");
		String objective=request.getParameter("objective");
		String sscm=request.getParameter("sscm");
		String hscm=request.getParameter("hscm");
		String btechm=request.getParameter("btechm");
		String pskills=request.getParameter("pskills");
		String askills=request.getParameter("askills");
		String strength=request.getParameter("strength");
		String phobbies=request.getParameter("phobbies");
		String hobbies[]=request.getParameterValues("hobbies");
		String langs="";
		String hobbs="";
		for(int i=0;i<languages.length;i++)
		{
			langs+=languages[i]+" ";
		}
		for(int i=0;i<hobbies.length;i++)
		{
			hobbs+=hobbies[i]+" ";
		}
	 try {
		 loadDriver("com.mysql.jdbc.Driver");
			Connection con=getConnection();
		 PreparedStatement ps=con.prepareStatement("insert into userdb.resumeinfo values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 	
		 	ps.setString(1, name);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, email);
			ps.setString(5, mobilenumber);
			ps.setString(6, dob);
			ps.setString(7, address);
			ps.setString(8, gender);
			ps.setString(9, langs);
			ps.setString(10, objective);
			ps.setString(11, sscm);
			ps.setString(12, hscm);
			ps.setString(13, btechm);
			ps.setString(14, pskills);
			ps.setString(15, askills);
			ps.setString(16, strength);
			ps.setString(17, phobbies);
			ps.setString(18, hobbs);
			ps.executeUpdate();
			System.out.println("Done");
		 
			  //Blank Document
		      XWPFDocument document = new XWPFDocument(); 
		        
		      //Write the Document in file system
		      FileOutputStream out = new FileOutputStream(new File("resume.docx"));
		        
		      //create paragraph
		      XWPFParagraph paragraph1 = document.createParagraph();
		   
		      XWPFRun header = paragraph1.createRun();
		         header.setText("Curriculum vitae");
		         header.setBold(true);
		         header.setItalic(true);
		         header.addCarriageReturn();
		         header.setFontSize(30);
		         header.setUnderline(UnderlinePatterns.SINGLE);
		        paragraph1.setAlignment(ParagraphAlignment.CENTER);
		        XWPFStyles styles = document.createStyles();
		        CTShd cTShd = header.getCTR().addNewRPr().addNewShd();
		        cTShd.setVal(STShd.CLEAR);
		        cTShd.setColor("auto");
		        cTShd.setFill("00FFFF");
		 
		        
		        
		        XWPFParagraph paragraph2 = document.createParagraph();
		        XWPFRun p1 = paragraph2.createRun();
		        
		//
//		        //******Here all values in string are given randomly please connect to jdbc and take values from there and put here in input ********//
//		        String fname="fname";
//		        String lname="lname";                      //**************get value of name from database and assign it to name***********/////
//		        String email="abc@gmail.com";
//		        String mobilenumber="0000000000";
//		        String dob="69/420/666";
//		        String address="address";
//		        String gender="mofo";
//		        String objective="some objective";
//		        String sscm="69";
//		        String hscm="69";
//		        String btechm="6.9";
//		        String pskills="Some akills";
//		        String strength="Strengths";
//		        String phobbies="professional hobbies";
//		        String hobbs="hobbies";
//		        String langs="asdsf";
//		      
		       
		        //get value of email from database and assign it to name
		        p1.setText("NAME="+fname+" "+lname);
		        p1.addCarriageReturn();
		        p1.setText("EMAIL="+email);
		        paragraph2.setAlignment(ParagraphAlignment.LEFT);
		        p1.setBold(true);
		        p1.addCarriageReturn();
		       
		        
		        XWPFParagraph h0 = document.createParagraph();
		        XWPFRun h0cr = h0.createRun();
		        XWPFParagraph personal = document.createParagraph();
		        XWPFRun personaldet = personal.createRun();
		       
		        h0cr.setText("Personal Details");
		        h0cr.setBold(true);
		        h0cr.setItalic(true);
		        h0cr.setFontSize(16);
		      //  h0.setBorderBottom(Borders.BASIC_BLACK_DASHES); 
		        
		        
		        
		      
		        	
		        personaldet.setText("NAME="+fname+" "+lname);
		        personaldet.addCarriageReturn();
		        
		        personaldet.setText("DATE OF BIRTH="+dob);
		        personaldet.addCarriageReturn();
		        
		        personaldet.setText("GENDER="+gender);
		        personaldet.addCarriageReturn();
		        
		        personaldet.setText("Mobile Number="+mobilenumber);
		        personaldet.addCarriageReturn();
		        
		        personaldet.setText("ADDRESS="+address);
		        personaldet.addCarriageReturn();
		        
		        personaldet.setText("LANGUAGES COMFORTABLE="+langs);
		        personaldet.addCarriageReturn();
		        personaldet.addCarriageReturn();
		       personal.setBorderBottom(Borders.BASIC_BLACK_DASHES);
		      personal.setBorderTop(Borders.BASIC_BLACK_DASHES);
		        
		      XWPFParagraph h3 = document.createParagraph();
		      XWPFRun h3cr = h3.createRun();
		        XWPFParagraph edu = document.createParagraph();
		        XWPFRun education = edu.createRun();
		        
		        h3cr.addCarriageReturn();
		        h3cr.addCarriageReturn();
		        h3cr.setItalic(true);
		        h3cr.setText("Education Qualification");
		        h3cr.setBold(true);
		        h3cr.setFontSize(16);
		        h3.setBorderBottom(Borders.BASIC_BLACK_DASHES); 
		        
		        education.setText("SSC%="+sscm);
		        education.addCarriageReturn();
		        education.setText("HSC%="+hscm);
		        education.addCarriageReturn();
		        education.setText("COLLAGE CGPA="+btechm);
		        education.addCarriageReturn();
		        education.setText("Programming Skill="+pskills);
		        education.addCarriageReturn();
		        
		        
		        XWPFParagraph h4 = document.createParagraph();
		        XWPFRun h4cr = h4.createRun();
		        XWPFParagraph str = document.createParagraph();
		        XWPFRun strengths = str.createRun();
		        
		        h4cr.addCarriageReturn();
		        h4cr.setText("Strengths");
		        h4cr.setBold(true);
		        h4cr.setItalic(true);
		        h4cr.setFontSize(16);
		        h4.setBorderBottom(Borders.BASIC_BLACK_DASHES);
		        strengths.setText("Strengths="+strength);
		        strengths.addCarriageReturn();
		        
		        XWPFParagraph h5 = document.createParagraph();
		        XWPFRun h5cr = h5.createRun();
		        XWPFParagraph objecti = document.createParagraph();
		        XWPFRun objectiv = objecti.createRun();
		        h5cr.addCarriageReturn();
		        h5cr.setText("Career Objectives");
		        h5cr.setBold(true);
		        h5cr.setItalic(true);
		        h5cr.setFontSize(16);
		        h5.setBorderBottom(Borders.BASIC_BLACK_DASHES);
		        objectiv.setText("Objectives="+objective);
		        
		        XWPFParagraph h6 = document.createParagraph();
		        XWPFRun h6cr = h6.createRun();
		          XWPFParagraph extra = document.createParagraph();
		          XWPFRun extracurr = extra.createRun();
		         h6cr.addCarriageReturn();
		        h6cr.setText("Hobbies");
		        h6cr.setBold(true);
		        h6cr.setItalic(true);
		        h6cr.setFontSize(16);
		        h6.setBorderBottom(Borders.BASIC_BLACK_DASHES);
		        extracurr.setText("Professional Hobbies="+phobbies);
		        extracurr.addCarriageReturn();
		        extracurr.setText("Hobbies="+hobbs);
		        
		        
		        
		      document.write(out);
		      out.close();
		      System.out.println("resume.docx written successully");
			
			
	     }catch(Exception e) {System.out.println(e);}
	}
    /*private String extractFileName(Part part)
	{
		String contentDisp=part.getHeader("content-disposition");
		System.out.println(contentDisp);
		String[] items=contentDisp.split(";");
		System.out.println(items[0]);
		for(String s:items)
		{
			if(s.trim().startsWith("fileName"))
			{
				return s.substring(s.indexOf("=")+2,s.length()-1);
			}
		}
		return "";
	}*/
	
	private String getFileName(Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename"))
	            return content.substring(content.indexOf("=") + 2, content.length() - 1);
	        }
	    return Constants.CJ_FULL_NAME;
	}
	
}
