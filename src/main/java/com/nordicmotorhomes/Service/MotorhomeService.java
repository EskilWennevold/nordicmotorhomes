package com.nordicmotorhomes.Service;

import com.nordicmotorhomes.Model.Motorhome;
import com.nordicmotorhomes.Repository.MotorhomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorhomeService {
    @Autowired
    MotorhomeRepo motorhomeRepo;

    public List<Motorhome> loadAllMotorhomes(){ return motorhomeRepo.loadAllMotorhomes(); }

    public void createMotorhome(Motorhome m){ motorhomeRepo.createMotorhome(m); }

    public Motorhome viewMotorhome(int id){ return motorhomeRepo.viewMotorhome(id); }

    public void updateMotorhome(Motorhome motorhome){ motorhomeRepo.updateMotorhome(motorhome); }

    public void deleteMotorhome(int id){ motorhomeRepo.deleteMotorhome(id); }
}
