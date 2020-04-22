import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class TrelloTestsHomework {

    private String id;

    @Test(priority = 1)
    public void checkCreateCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        CardNewBoard card = new CardNewBoard();
        String name  = "My card 1";

        CardNewBoard createdCard = retrofitBuilder.getTrelloApi().
                createCard(card, card.getIdList(), name).execute().body();

        id = createdCard.getIdCard();
        Assert.assertEquals(createdCard.getName(), name);
    }


    @Test(priority = 2)
    public void checkUpdateCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        CardNewBoard card = new CardNewBoard();
        String updatedName  = "Updated card name";
        card.setName(updatedName);
        CardNewBoard updatedCard = retrofitBuilder.getTrelloApi().
                updateCard(card, id, updatedName).execute().body();

        id = updatedCard.getIdCard();
        Assert.assertEquals(updatedCard.getName(), updatedName);
    }



    @Test(priority = 3)
    public void getCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        CardNewBoard card = new CardNewBoard();

        CardNewBoard сardGet  = retrofitBuilder.getTrelloApi().
                getCard(id, card.getKey(), card.getToken()).execute().body();
        String name = сardGet.getName();
        Assert.assertEquals(сardGet.getName(), name);
    }



    @Test(priority = 4)
    public void checkDeleteCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        CardNewBoard card = new CardNewBoard();
        int code = retrofitBuilder.getTrelloApi().deleteCard(id, card.getKey(),
                card.getToken()).execute().code();
        Assert.assertEquals(code, 200);
    }




}
