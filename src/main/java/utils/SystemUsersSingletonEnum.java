package utils;

public enum SystemUsersSingletonEnum {
    SYSTEM_ADMIN("SYSADMIN"), ADMIN("ADMIN");

    private String username;

    SystemUsersSingletonEnum(String username) {
        this.username = username;
    }

   /* public UserDTO getInstance(UserRepository userRepository, UserMapper userMapper) {
        return userRepository.findByUserName(this.username)
                .map(userMapper::mapBOToDTO)
                .orElseThrow(() -> new Exception(this.username + " user is not exists."));
    }*/

}

// usage:
// SystemUsersSingletonEnum.SYSTEM_ADMIN.getInstance().getId())
