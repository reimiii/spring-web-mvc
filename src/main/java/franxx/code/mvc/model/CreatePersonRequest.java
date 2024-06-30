package franxx.code.mvc.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class CreatePersonRequest {
    @NotBlank
    @NotNull
    private String username;

    @NotBlank
    @NotNull
    private String email;

    private String phone;
    private Address address;
    private List<String> hobbies;
    private List<SocialMedia> socialMedia;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(staticName = "of")
    public static class Address {
        private String city;
        private String county;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(staticName = "of")
    public static class SocialMedia {
        private String name;
        private String url;
    }
}
