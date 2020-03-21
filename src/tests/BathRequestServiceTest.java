package tests;

import main.canil.models.BathRequest;
import main.canil.models.BathResponse;
import main.canil.models.Kennel;
import main.canil.services.BathRequestService;
import main.canil.utils.DateUtil;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BathRequestServiceTest {

    private BathRequestService bathRequestService = new BathRequestService();

    private DateUtil dateUtil = new DateUtil();

    @Test
    public void getARequisitionList() {
        BathRequest bathRequest = new BathRequest(dateUtil.toLocaldate("21/03/2020"), 1, 1);
        bathRequestService.findBestPetshop(bathRequest);
        bathRequestService.findBestPetshop(bathRequest);
        bathRequestService.findBestPetshop(bathRequest);
        bathRequestService.findBestPetshop(bathRequest);
        int responses = bathRequestService.findAllResponses().size();

        Assert.assertEquals(4, responses);
    }

    @Test
    public void getPriceOfBaths() {
        Kennel kennel = new Kennel(1L, "canil", 1000, 20F, 40F);

        BathRequest bathRequest = new BathRequest(dateUtil.toLocaldate("20/03/2020"), 1, 1);

        Float price = bathRequestService.getPriceOfBathsPublic(bathRequest, kennel);
        Float priceExpected = 20F + 40F;

        Assert.assertEquals(priceExpected, price);
    }

    @Test
    public void getBestKennelWeekEndExpectedMeuCaninoFeliz() {
        BathRequest bathRequest = new BathRequest(dateUtil.toLocaldate("21/03/2020"), 1, 1);
        BathResponse bathResponse = bathRequestService.findBestPetshop(bathRequest);

        Float priceExpected = 24F + 48F;

        Assert.assertEquals("Meu Canino Feliz", bathResponse.getKennel().getName());
        Assert.assertEquals(priceExpected, bathResponse.getTotalPrice());
    }

    @Test
    public void getBestKennelWeekDayExpectedMeuCaninoFeliz() {
        BathRequest bathRequest = new BathRequest(dateUtil.toLocaldate("20/03/2020"), 1, 1);
        BathResponse bathResponse = bathRequestService.findBestPetshop(bathRequest);

        Float priceExpected = 20F + 40F;

        Assert.assertEquals("Meu Canino Feliz", bathResponse.getKennel().getName());
        Assert.assertEquals(priceExpected, bathResponse.getTotalPrice());
    }

    @Test
    public void getBestKennelExpectedVaiRex() {
        BathRequest bathRequest = new BathRequest(dateUtil.toLocaldate("20/03/2020"), 5, 1);
        BathResponse bathResponse = bathRequestService.findBestPetshop(bathRequest);

        Float priceExpected = (5 * 15F) + 50F;

        Assert.assertEquals("Vai Rex", bathResponse.getKennel().getName());
        Assert.assertEquals(priceExpected, bathResponse.getTotalPrice());
    }

    @Test
    public void getBestKennelExpectedChowChawgas() {
        BathRequest bathRequest = new BathRequest(dateUtil.toLocaldate("21/03/2020"), 1, 5);
        BathResponse bathResponse = bathRequestService.findBestPetshop(bathRequest);

        Float priceExpected = 30 + (45F * 5);

        Assert.assertEquals("Chow Chawgas", bathResponse.getKennel().getName());
        Assert.assertEquals(priceExpected, bathResponse.getTotalPrice());
    }

    @Test
    public void getBestKennelEqualPriceExpectedVaiRex() {
        BathRequest bathRequest = new BathRequest(dateUtil.toLocaldate("20/03/2020"), 2, 1);
        BathResponse bathResponse = bathRequestService.findBestPetshop(bathRequest);

        Float priceExpected = 80F;

        Assert.assertEquals("Vai Rex", bathResponse.getKennel().getName());
        Assert.assertEquals(priceExpected, bathResponse.getTotalPrice());
    }

}
