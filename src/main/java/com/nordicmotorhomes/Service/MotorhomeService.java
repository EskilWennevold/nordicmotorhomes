package com.nordicmotorhomes.Service;

import com.nordicmotorhomes.Repo.MotorhomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorhomeService {
    @Autowired
    MotorhomeRepo motorhomeRepo;
}
