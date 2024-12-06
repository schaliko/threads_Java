public class ExtendedFigur extends Figur{
	
	@Override
	public synchronized void setPosition(char x, int y) {
		this.x = x;
//		System.out.print(" Writer " + x);
        MachMal.eineZehntelSekundeLangGarNichts();
        this.y = y;
//        System.out.print(" Writer " + y);
	}

	@Override
	public synchronized String getPosition() {
		try {
		      Thread.sleep(1000);
		    } 
		    catch (InterruptedException e) {
		    	throw new RuntimeException(e);
		    }
		  
	     return " READER " + x + y;
	}

}
