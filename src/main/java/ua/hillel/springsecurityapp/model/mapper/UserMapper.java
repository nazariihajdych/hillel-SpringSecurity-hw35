package ua.hillel.springsecurityapp.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ua.hillel.springsecurityapp.model.dto.UserDTO;
import ua.hillel.springsecurityapp.model.entity.User;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {
    public abstract UserDTO userToUserDTO(User user);
    public abstract User userDTOToUser(UserDTO userDTO);

}
