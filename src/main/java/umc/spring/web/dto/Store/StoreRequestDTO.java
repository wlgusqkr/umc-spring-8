package umc.spring.web.dto.Store;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class CreateDTO{

        @Size(max = 50)
        @NotNull
        String name;

        @Size(max = 50)
        @NotNull
        String address;

        @NotNull
        Float score;

        Long regionId;
    }


}
