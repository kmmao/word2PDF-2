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
        System.out.println("�½��ļ��в���,�ļ�������" + directory.getName() + "���ļ���С" + directory.length());	
    }												
												
    @Override												
    public void onDirectoryChange(File directory) {												
        System.out.println("�ı��ļ��в���,�ļ�������" + directory.getName() + "���ļ���С" + directory.length());												
    }												
												
    @Override												
    public void onDirectoryDelete(File directory) {												
        System.out.println("ɾ���ļ��в���,�ļ�������" + directory.getName() + "���ļ���С" + directory.length());												
    }												
												
    @Override												
    public void onFileCreate(File file) {												
        System.out.println("�ļ���������,�ļ�����" + file.getName() + "���ļ���С" + file.length());
        //�߳���������
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        //���½��ļ���  ��ȡ������ļ�ת��Ϊpdf
        //���ж��ļ��ǲ���.doc����.docx��β
        if(file.getName().endsWith(".doc")||file.getName().endsWith(".docx")) {
        	//��ȡ�ļ�������·��
			/* System.out.println("����·��"+file.getAbsolutePath()); */
        	//������ļ�ת��ΪʹĿ¼�µ�pdf�ļ�
        	test test=new test();
        	test.wordToPDF(file);
        }
    }												
												
    @Override												
    public void onFileChange(File file) {												
        System.out.println("�ļ��ı����,�ļ�����" + file.getName() + "���ļ���С" + file.length());												
    }												
												
    @Override												
    public void onFileDelete(File file) {												
        System.out.println("�ļ�ɾ������,�ļ�����" + file.getName() + "���ļ���С" + file.length());												
    }												
												
    @Override												
    public void onStop(FileAlterationObserver observer) {												
    }												
}												
