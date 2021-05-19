package com.nordicmotorhomes.Service;

import com.nordicmotorhomes.Model.Rental;
import com.nordicmotorhomes.Repository.RentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    RentalRepo rentalRepo;

    public List<Rental> loadAllRentals(){ return rentalRepo.loadAllRentals(); }

    public void createRental(Rental rental){ rentalRepo.createRental(rental); }

    public Rental readRental(int id){ return rentalRepo.readRental(id); }

    public void updateRental(int id,Rental rental){ rentalRepo.updateRental(id,rental); }

    public void deleteRental(int id){
        rentalRepo.deleteRental(id);
    }
}
