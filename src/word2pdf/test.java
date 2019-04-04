package word2pdf;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;


import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class test {
	private static final int wdFormatPDF = 17;// PDF 格式  
	public static void wordToPDF(File file){ 
		String pathBefore =file.getAbsolutePath();
		System.out.println(pathBefore); 
		
		String pathAfter=file.getName().substring(0, file.getName().indexOf("."))+".pdf";
		pathAfter=PropertiesUtil.getProperty("targetPosition")+pathAfter;
		System.out.println(pathAfter); 
		
		ActiveXComponent app = null;  
		Dispatch doc = null;  
		try {      
			app = new ActiveXComponent("Word.Application");      
			app.setProperty("Visible", new Variant(false));  
			Dispatch docs = app.getProperty("Documents").toDispatch();    
			doc = Dispatch.call(docs,  "Open" , pathBefore).toDispatch();  
			File tofile = new File(pathAfter);      
			if (tofile.exists()) {      
				tofile.delete();      
			}      
			Dispatch.call(doc,"SaveAs", pathAfter, wdFormatPDF);      
		} catch (Exception e) {      
			System.out.println(e.getMessage()); 
			
		} finally {  
			Dispatch.call(doc,"Close",false);  
			if (app != null)      
				app.invoke("Quit", new Variant[] {});      
		}  
		//结束后关闭进程   
		ComThread.Release();
		System.out.println("产生成功");
	}
}
