package site.metacoding.white.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white.domain.user.User;

public class BoardRequestDto {

    @Getter
    @Setter
    public static class BoardSaveDto {
        private String title;
        private String content;

        @Getter
        @Setter
        public class ServiceDto {
            private User user;
        }

        private ServiceDto serviceDto;

        public void newInstance() {
            serviceDto = new ServiceDto();
        }
    }

    // 계속해서 DTO 를 추가하기 가능
}
