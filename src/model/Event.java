package model;

public class Event {
	
	private Viewer firstViewer;
	private Competitor firstCompetitor;
	private String file;
	
	public Event(String file) {
		this.file = file;
	}
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Viewer getFirstViewer() {
		return firstViewer;
	}
	public void setFirstViewer(Viewer firstViewer) {
		this.firstViewer = firstViewer;
	}
	public Competitor getFirstCompetitor() {
		return firstCompetitor;
	}
	public void setFirstCompetitor(Competitor firstCompetitor) {
		this.firstCompetitor = firstCompetitor;
	} 
}
