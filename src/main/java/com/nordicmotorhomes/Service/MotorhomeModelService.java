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
}
