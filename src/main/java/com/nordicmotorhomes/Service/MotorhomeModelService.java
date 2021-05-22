package com.nordicmotorhomes.Service;

import com.nordicmotorhomes.Model.MotorhomeModel;
import com.nordicmotorhomes.Repository.MotorhomeModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorhomeModelService {
    @Autowired
    MotorhomeModelRepo motorhomeModelRepo;
    public List<MotorhomeModel> loadAllMotorhomeModels(){
        return motorhomeModelRepo.loadAllMotorhomeModels();
    }
    public void createMotorhomeModel(MotorhomeModel motorhomeModel){
        motorhomeModelRepo.createMotorhomeModel(motorhomeModel);
    }
    public MotorhomeModel selectMotorhomeModel(int id){
        return motorhomeModelRepo.selectMotorhomeModel(id);
    }
    public void updateMotorhomeModel(MotorhomeModel motorhomeModel){
        motorhomeModelRepo.updateMotorhomeModel(motorhomeModel);
    }
    public void deleteMotorhomeModel(int id){
        motorhomeModelRepo.deleteMotorhomeModel(id);
    }
}
