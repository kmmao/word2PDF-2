package word2pdf;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

class MyFileLister extends FileAlterationListenerAdaptor {												
	
    @Override												
    public void onStart(FileAlterationObserver observer) {												
    }												
												
    @Override												
    public void onDirectoryCreate(File directory) {												
        System.out.println("新建文件夹操作,文件夹名是" + directory.getName() + "，文件大小" + directory.length());	
    }												
												
    @Override												
    public void onDirectoryChange(File directory) {												
        System.out.println("改变文件夹操作,文件夹名是" + directory.getName() + "，文件大小" + directory.length());												
    }												
												
    @Override												
    public void onDirectoryDelete(File directory) {												
        System.out.println("删除文件夹操作,文件夹名是" + directory.getName() + "，文件大小" + directory.length());												
    }												
												
    @Override												
    public void onFileCreate(File file) {												
        System.out.println("文件创建操作,文件名是" + file.getName() + "，文件大小" + file.length());
        //线程阻塞两秒
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        //当新建文件是  获取将这个文件转换为pdf
        //先判断文件是不是.doc或者.docx结尾
        if(file.getName().endsWith(".doc")||file.getName().endsWith(".docx")) {
        	//获取文件的完整路径
			/* System.out.println("完整路径"+file.getAbsolutePath()); */
        	//将这个文件转换为痛目录下的pdf文件
        	test test=new test();
        	test.wordToPDF(file);
        }
    }												
												
    @Override												
    public void onFileChange(File file) {												
        System.out.println("文件改变操作,文件名是" + file.getName() + "，文件大小" + file.length());												
    }												
												
    @Override												
    public void onFileDelete(File file) {												
        System.out.println("文件删除操作,文件名是" + file.getName() + "，文件大小" + file.length());												
    }												
												
    @Override												
    public void onStop(FileAlterationObserver observer) {												
    }												
}												
