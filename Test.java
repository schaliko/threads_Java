import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		String fileName = "id.dat";
        UniqueId uniqueId = new UniqueId(fileName);
        uniqueId.init(10000);
        
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new IdWorker(uniqueId));
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
