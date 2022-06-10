package com.caresoft.clinicapp;
import java.util.*;

public class Physician extends User implements HIPAACompliantUser  {
	
	private ArrayList<String> patientNotes;
	
	public Physician(Integer id) {
		super(id);
	}

	//... imports class definition...
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	@Override
	public boolean assignPin(int pin) {
		int strLength = String.valueOf(pin).length();
		if(strLength == 4) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.getId() == confirmedAuthID) {
			return true;
		}
		else {
			return false;
		}
	}
}
