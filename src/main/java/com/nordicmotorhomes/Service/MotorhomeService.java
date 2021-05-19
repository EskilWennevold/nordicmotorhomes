package com.nordicmotorhomes.Service;

import com.nordicmotorhomes.Model.Customer;
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

    public Motorhome createMotorhome(Motorhome motorhome){ return motorhomeRepo.createMotorhome(motorhome); }

    public Motorhome readMotorhome(int id){ return motorhomeRepo.readMotorhome(id); }

    public Motorhome updateMotorhome(int id,Motorhome motorhome){ return motorhomeRepo.updateMotorhome(id,motorhome); }

    public boolean deleteMotorhome(int id){
        return motorhomeRepo.deleteMotorhome(id);
    }
}
