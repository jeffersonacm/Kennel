package main.canil.services;

import main.canil.enums.DayType;
import main.canil.models.Kennel;
import main.canil.utils.DateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KennelService {

    private DayType dayType;

    private List<Kennel> kennelList = new ArrayList<>();

    private void save(Kennel kennel) {
        this.kennelList.add(kennel);
    }

    public List<Kennel> findAll(LocalDate localDate) {
        this.setDayType(localDate);
        this.buildData();
        return this.kennelList;
    }

    private void buildData() {
        Float priceSmall = 20F;
        Float priceBig = 40F;

        if (this.dayType.equals(DayType.WEEKEND)) {
            priceSmall = priceSmall + (priceSmall * 0.20F);
            priceBig = priceBig + (priceBig * 0.20F);
        }

        Kennel kennel1 = new Kennel(1L, "Meu Canino Feliz", 2000, priceSmall, priceBig);
        this.save(kennel1);

        priceSmall = 15F;
        priceBig = 50F;

        if (this.dayType.equals(DayType.WEEKEND)) {
            priceSmall = 20F;
            priceBig = 55F;
        }

        Kennel kennel2 = new Kennel(2L, "Vai Rex", 1700, priceSmall, priceBig);
        this.save(kennel2);

        Kennel kennel3 = new Kennel(3L, "Chow Chawgas", 800, 30F, 45F);
        this.save(kennel3);
    }

    private void setDayType(LocalDate localDate) {
        DateUtil dateUtil = new DateUtil();
        this.dayType = dateUtil.getWeekdayOrWeekend(localDate);
    }

}
