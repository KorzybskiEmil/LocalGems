package com.korzybskiemil.localgems.applicationuser.dto;

import com.korzybskiemil.localgems.car.Car;
import com.korzybskiemil.localgems.gamesandconsoles.GamesAndConsoles;
import com.korzybskiemil.localgems.musicandeducation.MusicAndEducation;
import com.korzybskiemil.localgems.realestate.RealEstate;
import com.korzybskiemil.localgems.sports.Sports;
import com.korzybskiemil.localgems.variousservices.VariousServices;
import com.korzybskiemil.localgems.work.Work;

public record NewApplicationUserDto(

        String username,
        String password,
        Car carAssignedToUser,
        GamesAndConsoles gamesAndConsolesAssignedToUser,
        MusicAndEducation musicAndEducationAssignedToUser,
        RealEstate realEstateAssignedToUser,
        Sports sportsAssignedToUser,
        VariousServices variousServicesAssignedToUser,
        Work workAssignedToUser
) {
}
