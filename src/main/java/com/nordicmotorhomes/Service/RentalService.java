package com.nordicmotorhomes.Service;

import com.nordicmotorhomes.Repo.RentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
    @Autowired
    RentalRepo rentalRepo;
}
