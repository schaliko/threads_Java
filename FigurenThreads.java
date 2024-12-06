public class FigurenThreads {
	ExtendedFigur figur = new ExtendedFigur();
	
	public FigurenThreads() {
        System.out.println("Starting writer...");
        Schreiber writer = new Schreiber(figur);
        writer.setDaemon(true);
        writer.start();

        System.out.println("Starting reader...");
        Leser reader = new Leser(figur);
        reader.setDaemon(true);
        reader.start();

        // Wait for the reader to complete
        try {
            reader.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    	new FigurenThreads();
        System.out.println("Main Thread finished");
    }
}
