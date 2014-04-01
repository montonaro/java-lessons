package threads;

public class MyThread extends Thread {
	
	public void run(){
		
		try {
			System.out.println("ID:" + getId());
            Thread.sleep(1000); // �������� ��������� ����� ����������
        } catch (InterruptedException e) { 
           return; 
        }
		
		
		while (!isInterrupted()) {
            System.out.println(getId());
            
        }

	}
}
