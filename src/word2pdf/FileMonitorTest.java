package word2pdf;



import java.awt.Checkbox;
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

public class FileMonitorTest {		
	public static void main(String[] args) throws Exception {
		MyFileLister myFileLister = new MyFileLister();										
		FileAlterationObserver observer1 = new FileAlterationObserver(PropertiesUtil.getProperty("position"));
		System.out.println(PropertiesUtil.getProperty("position"));
		observer1.addListener(myFileLister);										
		//配置Monitor，第一个参数单位是毫秒，是监听的间隔；第二个参数就是绑定我们之前的观察对象。  										
		FileAlterationMonitor monitor = new FileAlterationMonitor(1000,observer1);										
		/*monitor.addObserver(observer1);*/										
		monitor.start();										
	}										
}										
									
