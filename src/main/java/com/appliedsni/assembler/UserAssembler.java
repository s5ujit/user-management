package com.appliedsni.assembler;


import org.springframework.stereotype.Service;

import com.appliedsni.dto.ProfileDto;
import com.appliedsni.dto.UserDto;
import com.appliedsni.entity.User;
import com.appliedsni.utility.AttributeCopier;

@Service
public class UserAssembler {

    public UserAssembler() {

    }
    public final User assembleUser(final UserDto pUserDto) {
        final User aUser = new User();
        AttributeCopier.copyAttribute(pUserDto, aUser);
                return aUser;
    }
    public final UserDto assembleUserDto(final User pUser) {
        final UserDto aUserDto = new UserDto();
        AttributeCopier.copyAttribute(pUser, aUserDto);
        ProfileDto profileDto=new ProfileDto();
        AttributeCopier.copyAttribute(pUser.getProfile(), profileDto);
        aUserDto.setProfile(profileDto);
               return aUserDto;
    }

   }
