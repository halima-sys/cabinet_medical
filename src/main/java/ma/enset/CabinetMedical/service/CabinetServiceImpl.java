package ma.enset.CabinetMedical.service;

import ma.enset.CabinetMedical.entities.Consultation;
import ma.enset.CabinetMedical.entities.Medecin;
import ma.enset.CabinetMedical.entities.Patient;
import ma.enset.CabinetMedical.repositories.ConsultationRepository;
import ma.enset.CabinetMedical.repositories.MedecinRepository;
import ma.enset.CabinetMedical.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CabinetServiceImpl implements ICabinetService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ConsultationRepository consultationRepository;
    @Autowired
    MedecinRepository medecinRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> searchPatientsByQuery(String Query) {
        //return null;
        return patientRepository.findPatientsByNomContainsOrPrenomContainsOrEmailContainsOrCinContains(Query, Query, Query, Query);
    }

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Consultation> getConsultationsByPatient(Patient patient) {
        return ConsultationRepository.findConsultationByPatient(patient);
    }

    @Override
    public void addMedecin(Medecin medecin) {
        medecinRepository.save(medecin);
    }

    @Override
    public List<Medecin> getAllMedecin() {
        return medecinRepository.findAll();
    }

    @Override
    public void deleteMedecinById(Long id) {
        medecinRepository.deleteById(id);
    }


    @Override
    public List<Consultation> getConsultationsByMedecin(Medecin medecin) {
        return null;
    }


    @Override
    public void addConsultation(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    @Override
    public void deleteConsultation(Consultation consultation) {
        consultationRepository.delete(consultation);
    }

    @Override
    public Medecin getMedecinById(Long id) {
        return medecinRepository.findById(id).get();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public Consultation getConsultationById(Long id) {
        return consultationRepository.findById(id).get();
    }

    @Override
    public List<Medecin> searchMedecinsByQuery(String Query) {
        return medecinRepository.findMedecinsByNomContainsOrPrenomContainsOrEmailContains(Query, Query, Query);
    }

    @Override
    public void deleteConsultationById(Long id) {

    }

    /**
     * @param mc
     * @return
     */
    @Override
    public List<Consultation> searchConsultationsByQuery(String mc) {
        return null;
    }

    @Override
    public List<Consultation> searchConsultationsByQuery(Medecin Query) {
        return ConsultationRepository.findConsultationsByMedecin(String.valueOf(Query));
    }


    @Override
    public List<Consultation> searchConsultationsByMedecin(String co) {
        return null;
    }

    @Override
    public List<Consultation> searchConsultationsByPatient(String co) {
        return null;
    }

}
