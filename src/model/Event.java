package model;

import java.io.*;

public class Event {
	
	private Viewer firstViewer;
	private Competitor firstCompetitor;
	private String file;
	
	public Event(String file) throws IOException {
		this.file = file;
		loadData();
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
	
	public void loadData() throws IOException {
		File f = new File(file);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = "";
		while((line = br.readLine()) != null) {
			if(!line.equals("id,first_name,last_name,email,gender,country,photo,birthday")) {
				String[] s = line.split(",");
				Viewer v = new Viewer(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
				if(firstViewer == null) {
					firstViewer = v;
				}
				else {
					firstViewer.addViewer(v);
				}
				if((int)(Math.random()*2) == 0) {
					Competitor c = new Competitor(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
					if(firstCompetitor == null) {
						firstCompetitor = c;
					}
					else {
						firstCompetitor.addCompetitor(c);
						firstCompetitor = c;
					}
				}
			}
		}
		br.close();
	}
	
	public Viewer findViewer(String idViewer) {
		if(firstViewer != null) {
			return firstViewer.findViewer(idViewer);
		}
		else {
			return null;
		}
	}
	
	public Competitor findCompetitor(String idCompetitor) {
		if(firstCompetitor != null) {
			return firstCompetitor.findCompetitor(idCompetitor, firstCompetitor);
		}
		else {
			return null;
		}
	}
	
	public String findCountryViewers(String country) {
		if(firstViewer != null) {
			return firstViewer.findCountry(country);
		}
		else {
			return null;
		}
	}
	
	public String findCountryCompetitors(String country) {
		if(firstCompetitor != null) {
			return firstCompetitor.findCountry(country);
		}
		else {
			return null;
		}
	}
}
