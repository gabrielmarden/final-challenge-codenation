package br.codenation.projectfinal.dto;

import br.codenation.projectfinal.model.User;
import br.codenation.projectfinal.util.FormatAndConvertDateToString;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsDTO {

    private Long id;
    private String username;
    private String fullname;
    private String nickname;
    private String createdAt;

    public UserDetailsDTO(User user){
        id = user.getId();
        fullname = user.getFullName();
        nickname = user.getNickname();
        username = user.getEmail();
        this.createdAt = FormatAndConvertDateToString.converter(user.getCreatedAt());
    }

    public static List<UserDetailsDTO> AsList(List<User> users){
        return users.stream().map(user-> new UserDetailsDTO(user)).collect(Collectors.toList());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
