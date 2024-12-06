import java.io.IOException;

public class IdWorker implements Runnable{
	private UniqueId uniqueId;
	public IdWorker(UniqueId uniqueId) {
		this.uniqueId = uniqueId;
	}
	
    @Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				int newId = uniqueId.getNext();
				System.out.println(Thread.currentThread().getName() + " erzeugt ID: " + newId);
			} catch (IOException e) {
//                System.err.println(Thread.currentThread().getName() + " Fehler: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
