import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloApi {

    @POST("/1/cards")
    Call<CardNewBoard> createCard(@Body CardNewBoard card,
                                  @Query("id") String idList, @Query("name") String name);

    @GET ("/1/cards/{id}")
    Call<CardNewBoard> getCard(@Path("id") String id, @Query("key") String key,
                               @Query("token") String token);


    @PUT ("/1/cards/{id}")
    Call<CardNewBoard> updateCard(@Body CardNewBoard card, @Path("id") String id,
                                  @Query("name") String name);


    @DELETE ("/1/cards/{id}")
    Call<CardNewBoard> deleteCard(@Path("id") String id, @Query("key") String key,
                                   @Query("token") String token);


}
