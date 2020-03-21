package main.canil.controller;

import main.canil.models.BathRequest;
import main.canil.models.BathResponse;
import main.canil.services.BathRequestService;

import java.util.List;

public class BathController {

    private static BathRequestService bathRequestService = new BathRequestService();

    public BathResponse findBestPetshop(BathRequest bathRequest) {
        return bathRequestService.findBestPetshop(bathRequest);
    }

    public List<BathResponse> findAllBestPetshops() {
        return bathRequestService.findAllResponses();
    }

}
