package com.gr7.skitimer;

import java.io.File;
import java.io.FileOutputStream;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

class FileManager {
	
	public static boolean saveResult(CompetitionResult result, String fileName ) {
		File file = new File("./results/" + fileName);
		try {
			JAXBContext context = JAXBContext.newInstance(CompetitionResult.class, Competitor.class);
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			FileOutputStream os = new FileOutputStream( file);
			marshaller.marshal(result, os);
			
			return true;
			
		}catch(Exception e) {
			System.err.println(e.getMessage()+ e.getStackTrace());
			return false;
		}
	}
	
	public static CompetitionResult loadResult(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(CompetitionResult.class, Competitor.class);
			return (CompetitionResult) context.createUnmarshaller().unmarshal(file);
		}catch(Exception e) {
			System.err.println(e.getMessage()+ e.getStackTrace());
			return null;
		}
	}
}
