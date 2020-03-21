package main.canil.services;

import main.canil.models.BathRequest;
import main.canil.models.BathResponse;
import main.canil.models.Kennel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BathRequestService {

    private static List<BathResponse> bathResponseList = new ArrayList<>();

    private BathRequest bathRequest;

    public BathResponse findBestPetshop(BathRequest bathRequest) {
        this.bathRequest = bathRequest;
        List<Kennel> kennelList = this.findKennelList(this.bathRequest.getDate());
        Float price = Float.MAX_VALUE;
        Float priceAux;
        Kennel kennel = new Kennel();
        Integer distance = 0;

        for (Kennel k : kennelList) {
            priceAux = this.getPriceOfBaths(k);

            if (price == Float.MAX_VALUE
                    || price > priceAux
                    || ( price.equals(priceAux) && distance > k.getDistance()) )
            {
                price = priceAux;
                distance = k.getDistance();
                kennel = k;
            }
        }

        BathResponse bathResponse = new BathResponse(kennel, price);
        this.saveResponse(bathResponse);

        return bathResponse;
    }

    private Float getPriceOfBaths(Kennel kennel) {
        Float bigDogs = kennel.getPriceBig() * bathRequest.getBigDogs();
        Float smallDogs =  kennel.getPriceSmall() * bathRequest.getSmallDogs();

        return bigDogs + smallDogs;
    }

    public Float getPriceOfBathsPublic(BathRequest bathRequest, Kennel kennel) {
        this.bathRequest = bathRequest;
        return getPriceOfBaths(kennel);
    }

    private void saveResponse(BathResponse bathResponse) {
        bathResponseList.add(bathResponse);
    }

    public List<BathResponse> findAllResponses() {
        return bathResponseList;
    }

    private List<Kennel> findKennelList(LocalDate localDate) {
        KennelService kennelService = new KennelService();
        return kennelService.findAll(localDate);
    }

}
