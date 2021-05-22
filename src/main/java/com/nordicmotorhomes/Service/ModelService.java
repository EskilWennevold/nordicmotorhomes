package com.nordicmotorhomes.Service;

import com.nordicmotorhomes.Repository.ModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
    @Autowired
    ModelRepo modelRepo;
}
