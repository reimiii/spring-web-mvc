package franxx.code.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class CreatePersonRequest {
    private String username;
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
