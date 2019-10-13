import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Viewer;

class TestViewer {

	private Viewer viewer;
	
	private void setupStage() {
		viewer = new Viewer("1005966201", "Manuel", "Castaño", "icesi@edu.co", "Male", "Colombia", "Photo", "2/2/2019");
	}
	
	@Test
	public void testAddViewer() {
		setupStage();
		Viewer v1 = new Viewer("005966201", "Manuel", "Castaño", "icesi@edu.co", "Male", "Colombia", "Photo", "2/2/2019");
		Viewer v2 = new Viewer("905966201", "Manuel", "Castaño", "icesi@edu.co", "Male", "Colombia", "Photo", "2/2/2019");
		viewer.addViewer(v1);
		viewer.addViewer(v2);
		assertTrue(viewer.getLeft().compareTo(v1) == 0);
		assertTrue(viewer.getRight().compareTo(v2) == 0);
	}
	
	@Test
	public void testFindViewer() {
		setupStage();
		assertTrue(viewer.findViewer("00000") == null);
		Viewer v1 = new Viewer("005966201", "Manuel", "Castaño", "icesi@edu.co", "Male", "Colombia", "Photo", "2/2/2019");
		viewer.addViewer(v1);
		assertTrue(v1.compareTo(viewer.findViewer("005966201")) == 0);
		Viewer v2 = new Viewer("99991524", "Manuel", "Castaño", "icesi@edu.co", "Male", "Colombia", "Photo", "2/2/2019");
		viewer.addViewer(v2);
		assertTrue(v2.compareTo(viewer.findViewer("99991524")) == 0);
	}
	
	@Test
	public void testFindCountry() {
		setupStage();
		Viewer v1 = new Viewer("005966201", "Manuel", "Castaño", "icesi@edu.co", "Male", "Colombia", "Photo", "2/2/2019");
		Viewer v2 = new Viewer("905966201", "Manuel", "Castaño", "icesi@edu.co", "Male", "Colombia", "Photo", "2/2/2019");
		Viewer v3 = new Viewer("85416454", "Manuel", "Castaño", "icesi@edu.co", "Male", "Germany", "Photo", "2/2/2019");
		Viewer v4 = new Viewer("86416454", "Manuel", "Castaño", "icesi@edu.co", "Male", "Colombia", "Photo", "2/2/2019");
		viewer.addViewer(v1);
		viewer.addViewer(v2);
		viewer.addViewer(v3);
		viewer.addViewer(v4);
		String msg = "1005966201,Manuel,Castaño,icesi@edu.co,Male,Colombia,Photo,2/2/2019\n" + 
				"|_________005966201,Manuel,Castaño,icesi@edu.co,Male,Colombia,Photo,2/2/2019\n" + 
				"|_________905966201,Manuel,Castaño,icesi@edu.co,Male,Colombia,Photo,2/2/2019\n" + 
				"005966201,Manuel,Castaño,icesi@edu.co,Male,Colombia,Photo,2/2/2019\n" + 
				"|_________\n" + 
				"|_________\n" + 
				"905966201,Manuel,Castaño,icesi@edu.co,Male,Colombia,Photo,2/2/2019\n" + 
				"|_________\n" + 
				"|_________\n" + 
				"86416454,Manuel,Castaño,icesi@edu.co,Male,Colombia,Photo,2/2/2019\n" + 
				"|_________\n" + 
				"|_________\n";
		assertTrue(viewer.findCountry("Colombia").equals(msg));
	}
}
